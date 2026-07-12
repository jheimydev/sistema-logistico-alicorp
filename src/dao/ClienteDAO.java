package dao;

import config.Conexion;
import modelo.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.ResultSet;


public class ClienteDAO {

    Connection con;
    PreparedStatement ps;

    public boolean insertar(Cliente cliente) {

        String sql = "INSERT INTO CLIENTE(idCliente, nombre, tipo, contacto) VALUES (?, ?, ?, ?)";

        try {

            con = Conexion.getConexion();
            ps = con.prepareStatement(sql);

            ps.setInt(1, cliente.getIdCliente());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getTipo());
            ps.setString(4, cliente.getContacto());

            ps.executeUpdate();

            return true;

        } catch (SQLException e) {

            e.printStackTrace();
            return false;

        } finally {

            Conexion.cerrarConexion(con);

        }

    }
    
    public List<Cliente> listar() {

    List<Cliente> lista = new ArrayList<>();

    String sql = "SELECT * FROM CLIENTE";

    try {

        con = Conexion.getConexion();
        ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            Cliente cliente = new Cliente();

            cliente.setIdCliente(rs.getInt("idCliente"));
            cliente.setNombre(rs.getString("nombre"));
            cliente.setTipo(rs.getString("tipo"));
            cliente.setContacto(rs.getString("contacto"));

            lista.add(cliente);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        Conexion.cerrarConexion(con);
    }

    return lista;
}
    
    
    public boolean editar(int idOriginal, Cliente cliente) {

    String sql = "UPDATE CLIENTE SET idCliente=?, nombre=?, tipo=?, contacto=? WHERE idCliente=?";

    try {

        con = Conexion.getConexion();
        ps = con.prepareStatement(sql);

        ps.setInt(1, cliente.getIdCliente());
        ps.setString(2, cliente.getNombre());
        ps.setString(3, cliente.getTipo());
        ps.setString(4, cliente.getContacto());
        ps.setInt(5, idOriginal);

        int filas = ps.executeUpdate();

        return filas > 0;

    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    } finally {
        Conexion.cerrarConexion(con);
    }
}
    
    public boolean eliminar(int id) {

    String sql = "DELETE FROM CLIENTE WHERE idCliente=?";

    try {

        con = Conexion.getConexion();
        ps = con.prepareStatement(sql);

        ps.setInt(1, id);

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