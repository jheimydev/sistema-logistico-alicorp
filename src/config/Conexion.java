package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String URL = "jdbc:mysql://localhost:3307/SistemaLogisticoAlicorp";
    private static final String USER = "root";
    private static final String PASSWORD = "12345";

    public static Connection getConexion() {

        Connection con = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(URL, USER, PASSWORD);

            con.setAutoCommit(true);

            System.out.println("Conexión exitosa a la base de datos.");

        } catch (ClassNotFoundException e) {

            System.out.println("No se encontró el Driver JDBC.");
            e.printStackTrace();

        } catch (SQLException e) {

            System.out.println("Error al conectar con la base de datos.");
            e.printStackTrace();

        }

        return con;

    }

    public static void cerrarConexion(Connection con) {

        if (con != null) {

            try {

                if (!con.isClosed()) {
                    con.close();
                    System.out.println("Conexión cerrada.");
                }

            } catch (SQLException e) {

                e.printStackTrace();

            }

        }

    }

}