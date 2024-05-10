package funciones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.Usuario;

public class EdicionUsuario {
    
    public static boolean editarUsuario(Usuario usuario) {
        String query = "UPDATE Usuarios SET nombre = ?, rol = ? WHERE id = ?";
        try (Connection connection = DBManager.getConnection();
            PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, usuario.getNombre());
            statement.setString(2, usuario.getRol().toString());
            statement.setInt(3, usuario.getId());
            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false; 
        }
    }
}