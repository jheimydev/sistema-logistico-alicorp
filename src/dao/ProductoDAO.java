package dao;

import config.Conexion;
import modelo.Producto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {

    Connection con;
    PreparedStatement ps;

    // INSERTAR
    public boolean insertar(Producto producto) {

        String sql = "INSERT INTO PRODUCTO(codProducto, nombre, precio) VALUES (?, ?, ?)";

        try {

            con = Conexion.getConexion();
            ps = con.prepareStatement(sql);

            ps.setString(1, producto.getCodProducto());
            ps.setString(2, producto.getNombre());
            ps.setDouble(3, producto.getPrecio());

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
    public List<Producto> listar() {

        List<Producto> lista = new ArrayList<>();

        String sql = "SELECT * FROM PRODUCTO";

        try {

            con = Conexion.getConexion();
            ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Producto producto = new Producto();

                producto.setCodProducto(rs.getString("codProducto"));
                producto.setNombre(rs.getString("nombre"));
                producto.setPrecio(rs.getDouble("precio"));

                lista.add(producto);

            }

        } catch (SQLException e) {

            e.printStackTrace();

        } finally {

            Conexion.cerrarConexion(con);

        }

        return lista;
    }

    // EDITAR
    public boolean editar(String codigoOriginal, Producto producto) {

    String sql = "UPDATE PRODUCTO SET codProducto=?, nombre=?, precio=? WHERE codProducto=?";

    try {

        con = Conexion.getConexion();

        ps = con.prepareStatement(sql);

        ps.setString(1, producto.getCodProducto());
        ps.setString(2, producto.getNombre());
        ps.setDouble(3, producto.getPrecio());
        ps.setString(4, codigoOriginal);

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
    public boolean eliminar(String codigo) {

        String sql = "DELETE FROM PRODUCTO WHERE codProducto=?";

        try {

            con = Conexion.getConexion();
            ps = con.prepareStatement(sql);

            ps.setString(1, codigo);

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