package funciones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import modelo.Analisis;

public class DBManager {
    private static final String URL = "jdbc:mysql://localhost/hospitalgen";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    /**
     * Conexión a la base de datos.
     *
     * @return La conexión a la base de datos.
     * @throws SQLException Si ocurre un error al establecer la conexión.
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    /**
     * Cierre de Seccion BD
     *
     * @param connection La conexión a cerrar.
     */
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Obtiene Datos asociados
     *
     * @param idPaciente El ID del paciente.
     * @return Una lista de análisis asociados al paciente.
     */
    public static List<Analisis> obtenerAnalisisPaciente(int idPaciente) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Analisis> analisisList = new ArrayList<>();

        try {
            connection = getConnection();
            String query = "SELECT * FROM analisis WHERE id_paciente = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, idPaciente);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String tipoAnalisis = resultSet.getString("tipo_analisis");
                String resultados = resultSet.getString("resultado");

                // Aquí corregimos la llamada al constructor de Analisis
                Analisis analisis = new Analisis(idPaciente, tipoAnalisis, new Date(), 0, 0, resultados);
                analisisList.add(analisis);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection);
            try {
                if (statement != null) {
                    statement.close();
                }
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    } return analisisList;
}