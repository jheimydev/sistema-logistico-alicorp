package controlador;

import dao.InventarioDAO;
import modelo.Inventario;
import java.util.List;

public class InventarioController {

    private InventarioDAO inventarioDAO;

    public InventarioController() {
        inventarioDAO = new InventarioDAO();
    }

    public boolean guardarInventario(String codigoProducto, int cantidad) {
        Inventario inventario = new Inventario();
        inventario.setFkCodProducto(codigoProducto);
        inventario.setCantidad(cantidad);
        return inventarioDAO.insertar(inventario);
    }

    public List<Object[]> listarInventario() {
        return inventarioDAO.listar();
    }

    public boolean editarInventario(int idInventario, String codigoProducto, int cantidad) {
        Inventario inventario = new Inventario();
        inventario.setIdInventario(idInventario);
        inventario.setFkCodProducto(codigoProducto);
        inventario.setCantidad(cantidad);
        return inventarioDAO.editar(inventario);
    }

    public boolean eliminarInventario(int idInventario) {
        return inventarioDAO.eliminar(idInventario);
    }

    public int obtenerStockPorProducto(String codProducto) {
        return inventarioDAO.obtenerStockPorProducto(codProducto);
    }

    public boolean descontarStock(String codProducto, int cantidad) {
        return inventarioDAO.descontarStock(codProducto, cantidad);
    }
}