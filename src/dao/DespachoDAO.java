package dao;

import config.Conexion;
import modelo.Despacho;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DespachoDAO {

    Connection con;
    PreparedStatement ps;

    // INSERTAR
    public boolean insertar(Despacho despacho) {

        String sql = "INSERT INTO DESPACHO(estado, transportista, fk_idPedido, fk_idRuta) VALUES (?, ?, ?, ?)";

        try {
            con = Conexion.getConexion();
            ps = con.prepareStatement(sql);

            ps.setString(1, despacho.getEstado());
            ps.setString(2, despacho.getTransportista());
            ps.setInt(3, despacho.getFkIdPedido());
            ps.setInt(4, despacho.getFkIdRuta());

            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            Conexion.cerrarConexion(con);
        }
    }

    // LISTAR - trae datos de PEDIDO y RUTA mediante INNER JOIN
    public List<Object[]> listar() {

        List<Object[]> lista = new ArrayList<>();

        String sql = "SELECT d.idDespacho, d.fk_idPedido, r.origen, r.destino, d.estado, d.transportista "
                   + "FROM DESPACHO d "
                   + "INNER JOIN RUTA_DISTRIBUCION r ON d.fk_idRuta = r.idRuta "
                   + "ORDER BY d.idDespacho DESC";

        try {
            con = Conexion.getConexion();
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Object[] fila = new Object[6];
                fila[0] = rs.getInt("idDespacho");
                fila[1] = rs.getInt("fk_idPedido");
                fila[2] = rs.getString("origen") + " -> " + rs.getString("destino");
                fila[3] = rs.getString("estado");
                fila[4] = rs.getString("transportista");
                lista.add(fila);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexion.cerrarConexion(con);
        }

        return lista;
    }

    // ACTUALIZAR ESTADO
    public boolean actualizarEstado(int idDespacho, String estado) {

        String sql = "UPDATE DESPACHO SET estado=? WHERE idDespacho=?";

        try {
            con = Conexion.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, estado);
            ps.setInt(2, idDespacho);
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
    public boolean eliminar(int idDespacho) {

        String sql = "DELETE FROM DESPACHO WHERE idDespacho=?";

        try {
            con = Conexion.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idDespacho);
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
