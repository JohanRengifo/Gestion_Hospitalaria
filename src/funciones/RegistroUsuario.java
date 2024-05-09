package funciones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.Usuario;

public class RegistroUsuario {
    
    public static boolean registrarUsuario(Usuario usuario) {
        // Insertar usuario en la BD
        String query = "INSERT INTO Usuarios (nombre, nombre_usuario, contraseña, rol) VALUES (?, ?, ?, ?)";
        
        try (Connection connection = DBManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            // Establecemos los parámetros de la consulta
            statement.setString(1, usuario.getNombre());
            statement.setString(2, usuario.getNombreUsuario());
            statement.setString(3, usuario.getContraseña());
            statement.setString(4, usuario.getRol().toString());
            
            // Ejecutamos la inserción
            int rowsInserted = statement.executeUpdate();
            
            // Verificamos si se insertó correctamente
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false; 
        }
    }
}