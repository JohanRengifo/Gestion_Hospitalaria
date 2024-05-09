package funciones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
    // Conexión a la base de datos (MySQL)
    private static final String URL = "jdbc:mysql://localhost/hospitalgen";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    // Obtener la conexión
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Cerrar la Conexión
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                // Imprimir errores
                e.printStackTrace();
            }
        }
    }
}
