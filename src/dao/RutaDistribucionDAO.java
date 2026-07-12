package dao;

import config.Conexion;
import modelo.RutaDistribucion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RutaDistribucionDAO {

    Connection con;
    PreparedStatement ps;

    // INSERTAR
    public boolean insertar(RutaDistribucion ruta) {

        String sql = "INSERT INTO RUTA_DISTRIBUCION(origen, destino, distancia) VALUES (?, ?, ?)";

        try {
            con = Conexion.getConexion();
            ps = con.prepareStatement(sql);

            ps.setString(1, ruta.getOrigen());
            ps.setString(2, ruta.getDestino());
            ps.setDouble(3, ruta.getDistancia());

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
    public List<RutaDistribucion> listar() {

        List<RutaDistribucion> lista = new ArrayList<>();

        String sql = "SELECT * FROM RUTA_DISTRIBUCION";

        try {
            con = Conexion.getConexion();
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                RutaDistribucion ruta = new RutaDistribucion();
                ruta.setIdRuta(rs.getInt("idRuta"));
                ruta.setOrigen(rs.getString("origen"));
                ruta.setDestino(rs.getString("destino"));
                ruta.setDistancia(rs.getDouble("distancia"));
                lista.add(ruta);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexion.cerrarConexion(con);
        }

        return lista;
    }
}
