package dao;

import config.Conexion;
import modelo.Entrega;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class EntregaDAO {

    Connection con;
    PreparedStatement ps;

    // INSERTAR
    public boolean insertar(Entrega entrega) {

        String sql = "INSERT INTO ENTREGA(fechaEntrega, fk_idDespacho) VALUES (?, ?)";

        try {
            con = Conexion.getConexion();
            ps = con.prepareStatement(sql);

            ps.setTimestamp(1, entrega.getFechaEntrega());
            ps.setInt(2, entrega.getFkIdDespacho());

            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            Conexion.cerrarConexion(con);
        }
    }

    // LISTAR - trae datos del Despacho, Pedido y Ruta mediante INNER JOIN
    public List<Object[]> listar() {

        List<Object[]> lista = new ArrayList<>();

        String sql = "SELECT e.idEntrega, e.fk_idDespacho, d.fk_idPedido, d.estado, d.transportista, e.fechaEntrega "
                   + "FROM ENTREGA e "
                   + "INNER JOIN DESPACHO d ON e.fk_idDespacho = d.idDespacho "
                   + "ORDER BY e.idEntrega DESC";

        try {
            con = Conexion.getConexion();
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Object[] fila = new Object[6];
                fila[0] = rs.getInt("idEntrega");
                fila[1] = rs.getInt("fk_idDespacho");
                fila[2] = rs.getInt("fk_idPedido");
                fila[3] = rs.getString("estado");
                fila[4] = rs.getString("transportista");
                fila[5] = rs.getTimestamp("fechaEntrega");
                lista.add(fila);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexion.cerrarConexion(con);
        }

        return lista;
    }

    // LISTAR DESPACHOS SIN ENTREGA REGISTRADA AUN (para el combo del formulario)
    public List<Object[]> listarDespachosSinEntrega() {

        List<Object[]> lista = new ArrayList<>();

        String sql = "SELECT d.idDespacho, d.fk_idPedido, d.estado, d.transportista "
                   + "FROM DESPACHO d "
                   + "WHERE d.idDespacho NOT IN (SELECT fk_idDespacho FROM ENTREGA) "
                   + "ORDER BY d.idDespacho DESC";

        try {
            con = Conexion.getConexion();
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Object[] fila = new Object[4];
                fila[0] = rs.getInt("idDespacho");
                fila[1] = rs.getInt("fk_idPedido");
                fila[2] = rs.getString("estado");
                fila[3] = rs.getString("transportista");
                lista.add(fila);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexion.cerrarConexion(con);
        }

        return lista;
    }

    // ELIMINAR
    public boolean eliminar(int idEntrega) {

        String sql = "DELETE FROM ENTREGA WHERE idEntrega=?";

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
}
