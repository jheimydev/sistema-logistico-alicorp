package util;

import config.Conexion;
import java.sql.Connection;

public class TestConexion {

    public static void main(String[] args) {

        Connection conexion = Conexion.getConexion();

        if (conexion != null) {
            System.out.println("¡Conexión realizada correctamente!");
            Conexion.cerrarConexion(conexion);
        } else {
            System.out.println("No se pudo establecer la conexión.");
        }

    }
}
