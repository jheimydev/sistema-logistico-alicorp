package controlador;

import dao.IncidenciaDAO;
import modelo.Incidencia;

import java.util.List;

public class IncidenciaController {

    private IncidenciaDAO incidenciaDAO;

    public IncidenciaController() {
        incidenciaDAO = new IncidenciaDAO();
    }

    public boolean guardarIncidencia(String tipo, String descripcion, int fkIdEntrega) {
        Incidencia incidencia = new Incidencia();
        incidencia.setTipo(tipo);
        incidencia.setDescripcion(descripcion);
        incidencia.setFkIdEntrega(fkIdEntrega);
        return incidenciaDAO.insertar(incidencia);
    }

    public List<Object[]> listarIncidencias() {
        return incidenciaDAO.listar();
    }

    public boolean eliminarIncidencia(int idIncidencia) {
        return incidenciaDAO.eliminar(idIncidencia);
    }
}
