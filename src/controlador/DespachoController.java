package controlador;

import dao.DespachoDAO;
import dao.RutaDistribucionDAO;
import modelo.Despacho;
import modelo.RutaDistribucion;

import java.util.List;

public class DespachoController {

    private DespachoDAO despachoDAO;
    private RutaDistribucionDAO rutaDAO;

    public DespachoController() {
        despachoDAO = new DespachoDAO();
        rutaDAO = new RutaDistribucionDAO();
    }

    // ---- Rutas ----
    public boolean guardarRuta(String origen, String destino, double distancia) {
        RutaDistribucion ruta = new RutaDistribucion();
        ruta.setOrigen(origen);
        ruta.setDestino(destino);
        ruta.setDistancia(distancia);
        return rutaDAO.insertar(ruta);
    }

    public List<RutaDistribucion> listarRutas() {
        return rutaDAO.listar();
    }

    // ---- Despachos ----
    public boolean guardarDespacho(String estado, String transportista, int fkIdPedido, int fkIdRuta) {
        Despacho despacho = new Despacho();
        despacho.setEstado(estado);
        despacho.setTransportista(transportista);
        despacho.setFkIdPedido(fkIdPedido);
        despacho.setFkIdRuta(fkIdRuta);
        return despachoDAO.insertar(despacho);
    }

    public List<Object[]> listarDespachos() {
        return despachoDAO.listar();
    }

    public boolean actualizarEstadoDespacho(int idDespacho, String estado) {
        return despachoDAO.actualizarEstado(idDespacho, estado);
    }

    public boolean eliminarDespacho(int idDespacho) {
        return despachoDAO.eliminar(idDespacho);
    }
}
