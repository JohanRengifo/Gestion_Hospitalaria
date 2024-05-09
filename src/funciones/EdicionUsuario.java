package funciones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.Usuario;

public class EdicionUsuario {
    
    public static boolean editarUsuario(Usuario usuario) {
        // Consulta para actualizar el usuario en la base de datos
        String query = "UPDATE Usuarios SET nombre = ?, rol = ? WHERE id = ?";
        
        try (Connection connection = DBManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            // Establecer los parámetros de la consulta
            statement.setString(1, usuario.getNombre());
            statement.setString(2, usuario.getRol().toString());
            statement.setInt(3, usuario.getId());
            
            // Ejecutar la actualización
            int rowsUpdated = statement.executeUpdate();
            
            // Verificar si se actualizó correctamente
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false; 
        }
    }
}