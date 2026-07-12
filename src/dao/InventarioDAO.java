package dao;

import config.Conexion;
import modelo.Inventario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InventarioDAO {

    Connection con;
    PreparedStatement ps;

    // INSERTAR
    public boolean insertar(Inventario inventario) {
        String sql = "INSERT INTO INVENTARIO(fk_codProducto, cantidad) VALUES (?, ?)";
        try {
            con = Conexion.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, inventario.getFkCodProducto());
            ps.setInt(2, inventario.getCantidad());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            Conexion.cerrarConexion(con);
        }
    }

    // LISTAR
    public List<Object[]> listar() {
        List<Object[]> lista = new ArrayList<>();

        String sql = "SELECT i.idInventario, p.nombre, i.cantidad, p.codProducto "
                   + "FROM INVENTARIO i "
                   + "INNER JOIN PRODUCTO p "
                   + "ON i.fk_codProducto = p.codProducto";
        try {
            con = Conexion.getConexion();
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Object[] fila = new Object[4];
                fila[0] = rs.getInt("idInventario");
                fila[1] = rs.getString("nombre");
                fila[2] = rs.getInt("cantidad");
                fila[3] = rs.getString("codProducto");
                lista.add(fila);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexion.cerrarConexion(con);
        }
        return lista;
    }

    // EDITAR
    public boolean editar(Inventario inventario) {
        String sql = "UPDATE INVENTARIO SET fk_codProducto=?, cantidad=? WHERE idInventario=?";
        try {
            con = Conexion.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, inventario.getFkCodProducto());
            ps.setInt(2, inventario.getCantidad());
            ps.setInt(3, inventario.getIdInventario());
            int filas = ps.executeUpdate();
            return filas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            Conexion.cerrarConexion(con);
        }
    }

    // ELIMINAR
    public boolean eliminar(int idInventario) {
        String sql = "DELETE FROM INVENTARIO WHERE idInventario=?";
        try {
            con = Conexion.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idInventario);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            Conexion.cerrarConexion(con);
        }
    }

    // OBTENER STOCK DISPONIBLE DE UN PRODUCTO (para validar antes de un pedido)
    public int obtenerStockPorProducto(String codProducto) {
        String sql = "SELECT COALESCE(SUM(cantidad), 0) AS stock FROM INVENTARIO WHERE fk_codProducto = ?";
        try {
            con = Conexion.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, codProducto);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("stock");
            }
            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        } finally {
            Conexion.cerrarConexion(con);
        }
    }

    // DESCONTAR STOCK (se usa al confirmar un pedido)
    public boolean descontarStock(String codProducto, int cantidad) {
        String sql = "UPDATE INVENTARIO SET cantidad = cantidad - ? WHERE fk_codProducto = ?";
        try {
            con = Conexion.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cantidad);
            ps.setString(2, codProducto);
            int filas = ps.executeUpdate();
            return filas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            Conexion.cerrarConexion(con);
        }
    }
}
