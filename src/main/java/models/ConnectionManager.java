package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    // Información de conexión (ajusta estos valores según tu configuración)
    private final String url = "jdbc:mysql://localhost:3306/mvcdb";
    private final String user = "Dropxni";
    private final String password = "M@nuel191104"; // Coloca tu contraseña si es necesario

    private Connection conexion = null;

    // Método para obtener la conexión
    public Connection getConexion() {
        try {
            conexion = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión exitosa a la base de datos");
        } catch (SQLException e) {
            System.out.println("Error al conectarse a la base de datos: " + e.getMessage());
        }
        return conexion;
    }

    // Método para cerrar la conexión
    public void desconectar() {
        try {
            if (conexion != null) {
                conexion.close();
                System.out.println("Conexión cerrada");
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }
}
