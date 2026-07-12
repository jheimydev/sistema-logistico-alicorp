package dao;

import config.Conexion;
import modelo.Incidencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IncidenciaDAO {

    Connection con;
    PreparedStatement ps;

    // INSERTAR
    public boolean insertar(Incidencia incidencia) {

        String sql = "INSERT INTO INCIDENCIA(tipo, descripcion, fk_idEntrega) VALUES (?, ?, ?)";

        try {
            con = Conexion.getConexion();
            ps = con.prepareStatement(sql);

            ps.setString(1, incidencia.getTipo());
            ps.setString(2, incidencia.getDescripcion());
            ps.setInt(3, incidencia.getFkIdEntrega());

            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            Conexion.cerrarConexion(con);
        }
    }

    // LISTAR - trae datos de la Entrega mediante INNER JOIN
    public List<Object[]> listar() {

        List<Object[]> lista = new ArrayList<>();

        String sql = "SELECT i.idIncidencia, i.fk_idEntrega, e.fechaEntrega, i.tipo, i.descripcion "
                   + "FROM INCIDENCIA i "
                   + "INNER JOIN ENTREGA e ON i.fk_idEntrega = e.idEntrega "
                   + "ORDER BY i.idIncidencia DESC";

        try {
            con = Conexion.getConexion();
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Object[] fila = new Object[5];
                fila[0] = rs.getInt("idIncidencia");
                fila[1] = rs.getInt("fk_idEntrega");
                fila[2] = rs.getTimestamp("fechaEntrega");
                fila[3] = rs.getString("tipo");
                fila[4] = rs.getString("descripcion");
                lista.add(fila);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexion.cerrarConexion(con);
        }

        return lista;
    }

    // ELIMINAR TODAS LAS INCIDENCIAS DE UNA ENTREGA (se usa antes de borrar la entrega)
    public boolean eliminarPorEntrega(int idEntrega) {

        String sql = "DELETE FROM INCIDENCIA WHERE fk_idEntrega=?";

        try {
            con = Conexion.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idEntrega);
            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            Conexion.cerrarConexion(con);
        }
    }

    // ELIMINAR
    public boolean eliminar(int idIncidencia) {

        String sql = "DELETE FROM INCIDENCIA WHERE idIncidencia=?";

        try {
            con = Conexion.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idIncidencia);
            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            Conexion.cerrarConexion(con);
        }
    }
}
