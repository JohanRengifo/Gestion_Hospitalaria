package funciones;
import modelo.Pacientes;
import modelo.Doctores;
import modelo.Enfermeros;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @authors Johan Stiven Rengifo y Tatiana Muñoz Daza
 * Modelo de Roles, Asignación y Gestion de los mismos
 */

// Enum para los roles de usuario
enum Rol {
    ADMINISTRADOR,
    USUARIO_NORMAL
}

// Clase para representar un usuario
class Usuario {
    private String nombre;
    private Rol rol;

    public Usuario(String nombre, Rol rol) {
        this.nombre = nombre;
        this.rol = rol;
    }

    public String getNombre() {
        return nombre;
    }

    public Rol getRol() {
        return rol;
    }
}

// Gestión de usuarios y roles
public class GestionUsuarios {

    private Connection conexion;

    public GestionUsuarios() {
        // Establecer la conexión con la base de datos (SQLite)
        try {
            Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection("jdbc:sqlite:usuarios.db");
            Statement statement = conexion.createStatement();
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS usuarios (nombre TEXT PRIMARY KEY, rol TEXT)");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Agregar un nuevo usuario a la base de datos
    public void agregarUsuario(String nombre, Rol rol) {
        try {
            PreparedStatement statement = conexion.prepareStatement("INSERT INTO usuarios (nombre, rol) VALUES (?, ?)");
            statement.setString(1, nombre);
            statement.setString(2, rol.toString());
            statement.executeUpdate();
            System.out.println("Usuario agregado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Verificar el rol de un usuario en la base de datos
    public Rol obtenerRolUsuario(String nombreUsuario) {
        try {
            PreparedStatement statement = conexion.prepareStatement("SELECT rol FROM usuarios WHERE nombre = ?");
            statement.setString(1, nombreUsuario);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return Rol.valueOf(resultSet.getString("rol"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

