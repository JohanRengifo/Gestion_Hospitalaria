package funciones;

import modelo.RolUsuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import modelo.Usuario;

public class ControlLogin {

    public static RolUsuario verificarCredenciales(String nombreUsuario, String password) {
        String query = "SELECT rol FROM usuarios WHERE nombre_usuario = ? AND password = ?";
        try (Connection connection = DBManager.getConnection();
            PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, nombreUsuario);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String rolString = resultSet.getString("rol");
                return RolUsuario.valueOf(rolString);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; 
    }

    public static Usuario obtenerInformacionUsuario(String nombreUsuario) {
        String query = "SELECT * FROM usuarios WHERE nombre_usuario = ?";
        try (Connection connection = DBManager.getConnection();
            PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, nombreUsuario);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                String password = resultSet.getString("password");
                String direccion = resultSet.getString("direccion");
                String rolString = resultSet.getString("rol");
                RolUsuario rol = RolUsuario.valueOf(rolString);
                LocalDateTime fechaRegistro = resultSet.getTimestamp("fecha_registro").toLocalDateTime();
                return new Usuario(id, nombre, nombreUsuario, password, direccion, rol, fechaRegistro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Registramos el evento
    public static void registrarInicioSesion(String nombreUsuario, boolean exitoso) {
        String tipoEvento = exitoso ? "Inicio de sesión exitoso" : "Inicio de sesión fallido";
        String query = "INSERT INTO eventos (id_usuario, tipo_evento, fecha_registro) VALUES ((SELECT id FROM usuarios WHERE nombre_usuario = ?), ?, ?)";
        try (Connection connection = DBManager.getConnection();
            PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, nombreUsuario);
            statement.setString(2, tipoEvento);
            statement.setObject(3, LocalDateTime.now());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Cerrar la sesión
    public static void cerrarSesion() {
        
    }
}