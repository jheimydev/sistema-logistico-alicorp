package dao;

import config.Conexion;
import modelo.DetallePedido;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DetallePedidoDAO {

    Connection con;
    PreparedStatement ps;

    // INSERTAR
    public boolean insertar(DetallePedido detalle) {

        String sql = "INSERT INTO DETALLE_PEDIDO(fk_idPedido, fk_codProducto, cantidad, precioUnitario) VALUES (?, ?, ?, ?)";

        try {

            con = Conexion.getConexion();
            ps = con.prepareStatement(sql);

            ps.setInt(1, detalle.getFkIdPedido());
            ps.setString(2, detalle.getFkCodProducto());
            ps.setInt(3, detalle.getCantidad());
            ps.setDouble(4, detalle.getPrecioUnitario());

            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            Conexion.cerrarConexion(con);
        }
    }

    // LISTAR POR PEDIDO - trae el nombre del producto mediante INNER JOIN
    public List<Object[]> listarPorPedido(int idPedido) {

        List<Object[]> lista = new ArrayList<>();

        String sql = "SELECT d.idDetalle, p.nombre, d.cantidad, d.precioUnitario "
                   + "FROM DETALLE_PEDIDO d "
                   + "INNER JOIN PRODUCTO p ON d.fk_codProducto = p.codProducto "
                   + "WHERE d.fk_idPedido = ?";

        try {

            con = Conexion.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idPedido);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Object[] fila = new Object[4];
                fila[0] = rs.getInt("idDetalle");
                fila[1] = rs.getString("nombre");
                fila[2] = rs.getInt("cantidad");
                fila[3] = rs.getDouble("precioUnitario");
                lista.add(fila);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexion.cerrarConexion(con);
        }

        return lista;
    }

    // ELIMINAR TODAS LAS LINEAS DE UN PEDIDO (se usa antes de borrar la cabecera)
    public boolean eliminarPorPedido(int idPedido) {

        String sql = "DELETE FROM DETALLE_PEDIDO WHERE fk_idPedido=?";

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
