package funciones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EventLoggerService {

    public static boolean registrarEvento(int idUsuario, String tipoEvento) {
        String query = "INSERT INTO Eventos (id_usuario, tipo_evento) VALUES (?, ?)";

        try (Connection connection = DBManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idUsuario);
            statement.setString(2, tipoEvento);
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static ResultSet consultarEventosPorUsuarioYTipo(int idUsuario, String tipoEvento) {
        String query = "SELECT * FROM Eventos WHERE id_usuario = ? AND tipo_evento = ?";

        try (Connection connection = DBManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idUsuario);
            statement.setString(2, tipoEvento);
            return statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
