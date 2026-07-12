package controlador;

import dao.DetallePedidoDAO;
import dao.OrdenPedidoDAO;
import modelo.DetallePedido;
import modelo.OrdenPedido;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PedidoController {

    private OrdenPedidoDAO ordenPedidoDAO;
    private DetallePedidoDAO detallePedidoDAO;
    private InventarioController inventarioController;

    public PedidoController() {
        ordenPedidoDAO = new OrdenPedidoDAO();
        detallePedidoDAO = new DetallePedidoDAO();
        inventarioController = new InventarioController();
    }

    // Verifica que haya stock suficiente para TODAS las líneas antes de guardar nada.
    // Devuelve null si todo está OK, o el código del primer producto sin stock suficiente.
    public String validarStock(List<DetallePedido> lineas) {

        Map<String, Integer> cantidadRequeridaPorProducto = new HashMap<>();

        for (DetallePedido d : lineas) {
            cantidadRequeridaPorProducto.merge(d.getFkCodProducto(), d.getCantidad(), Integer::sum);
        }

        for (Map.Entry<String, Integer> entry : cantidadRequeridaPorProducto.entrySet()) {
            int stockDisponible = inventarioController.obtenerStockPorProducto(entry.getKey());
            if (entry.getValue() > stockDisponible) {
                return entry.getKey();
            }
        }

        return null;
    }

    // Guarda la cabecera (ORDEN_PEDIDO), todas sus lineas (DETALLE_PEDIDO) y descuenta el stock
    public boolean guardarPedidoCompleto(int fkIdCliente, Date fecha, String estado, List<DetallePedido> lineas) {

        if (lineas == null || lineas.isEmpty()) {
            return false;
        }

        // Verificación de stock antes de guardar nada (RF-02 del informe)
        if (validarStock(lineas) != null) {
            return false;
        }

        double monto = 0;
        for (DetallePedido d : lineas) {
            monto += d.getSubtotal();
        }

        OrdenPedido orden = new OrdenPedido();
        orden.setFecha(fecha);
        orden.setEstado(estado);
        orden.setMonto(monto);
        orden.setFkIdCliente(fkIdCliente);

        int idPedidoGenerado = ordenPedidoDAO.insertar(orden);

        if (idPedidoGenerado == -1) {
            return false;
        }

        boolean todoOk = true;

        for (DetallePedido linea : lineas) {
            linea.setFkIdPedido(idPedidoGenerado);
            boolean ok = detallePedidoDAO.insertar(linea);
            if (!ok) {
                todoOk = false;
            } else {
                inventarioController.descontarStock(linea.getFkCodProducto(), linea.getCantidad());
            }
        }

        return todoOk;
    }

    public List<Object[]> listarPedidos() {
        return ordenPedidoDAO.listar();
    }

    public List<Object[]> listarDetallePorPedido(int idPedido) {
        return detallePedidoDAO.listarPorPedido(idPedido);
    }

    // Elimina primero las lineas (por la FK) y luego la cabecera
    public boolean eliminarPedido(int idPedido) {
        detallePedidoDAO.eliminarPorPedido(idPedido);
        return ordenPedidoDAO.eliminar(idPedido);
    }
}
