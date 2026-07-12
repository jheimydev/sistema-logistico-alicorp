package dao;

import config.Conexion;
import modelo.OrdenPedido;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrdenPedidoDAO {

    Connection con;
    PreparedStatement ps;

    // INSERTAR - devuelve el idPedido generado, o -1 si falla
    public int insertar(OrdenPedido orden) {

        String sql = "INSERT INTO ORDEN_PEDIDO(fecha, estado, monto, fk_idCliente) VALUES (?, ?, ?, ?)";

        try {

            con = Conexion.getConexion();
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setDate(1, orden.getFecha());
            ps.setString(2, orden.getEstado());
            ps.setDouble(3, orden.getMonto());
            ps.setInt(4, orden.getFkIdCliente());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                return rs.getInt(1);
            }

            return -1;

        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        } finally {
            Conexion.cerrarConexion(con);
        }
    }

    // LISTAR - trae el nombre del cliente mediante INNER JOIN
    public List<Object[]> listar() {

        List<Object[]> lista = new ArrayList<>();

        String sql = "SELECT o.idPedido, c.nombre, o.fecha, o.estado, o.monto "
                   + "FROM ORDEN_PEDIDO o "
                   + "INNER JOIN CLIENTE c ON o.fk_idCliente = c.idCliente "
                   + "ORDER BY o.idPedido DESC";

        try {

            con = Conexion.getConexion();
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Object[] fila = new Object[5];
                fila[0] = rs.getInt("idPedido");
                fila[1] = rs.getString("nombre");
                fila[2] = rs.getDate("fecha");
                fila[3] = rs.getString("estado");
                fila[4] = rs.getDouble("monto");
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
    public boolean eliminar(int idPedido) {

        String sql = "DELETE FROM ORDEN_PEDIDO WHERE idPedido=?";

        try {

            con = Conexion.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idPedido);
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
