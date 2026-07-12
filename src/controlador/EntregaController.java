package controlador;

import dao.EntregaDAO;
import dao.IncidenciaDAO;
import modelo.Entrega;

import java.sql.Timestamp;
import java.util.List;

public class EntregaController {

    private EntregaDAO entregaDAO;
    private IncidenciaDAO incidenciaDAO;

    public EntregaController() {
        entregaDAO = new EntregaDAO();
        incidenciaDAO = new IncidenciaDAO();
    }

    public boolean guardarEntrega(Timestamp fechaEntrega, int fkIdDespacho) {
        Entrega entrega = new Entrega();
        entrega.setFechaEntrega(fechaEntrega);
        entrega.setFkIdDespacho(fkIdDespacho);
        return entregaDAO.insertar(entrega);
    }

    public List<Object[]> listarEntregas() {
        return entregaDAO.listar();
    }

    public List<Object[]> listarDespachosSinEntrega() {
        return entregaDAO.listarDespachosSinEntrega();
    }

    // Elimina primero las incidencias asociadas (por la FK) y luego la entrega
    public boolean eliminarEntrega(int idEntrega) {
        incidenciaDAO.eliminarPorEntrega(idEntrega);
        return entregaDAO.eliminar(idEntrega);
    }
}
