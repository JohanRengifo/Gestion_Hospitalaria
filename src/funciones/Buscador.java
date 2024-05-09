package funciones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.RegistroBusqueda;

public class Buscador {

    public static List<RegistroBusqueda> buscar(String palabra) {
        List<RegistroBusqueda> resultados = new ArrayList<>();

        try (Connection connection = DBManager.getConnection()) {
            String query = "SELECT id, nombre, tipo FROM Pacientes WHERE nombre LIKE ? UNION " +
                    "SELECT id, nombre, tipo FROM EmpleadosSanitarios WHERE nombre LIKE ? UNION " +
                    "SELECT id, tipo_analisis AS nombre, 'Analisis' AS tipo FROM Analisis WHERE tipo_analisis LIKE ?";

            try (PreparedStatement statement = connection.prepareStatement(query)) {
                String likePattern = "%" + palabra + "%";
                statement.setString(1, likePattern);
                statement.setString(2, likePattern);
                statement.setString(3, likePattern);

                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String nombre = resultSet.getString("nombre");
                        String tipo = resultSet.getString("tipo");
                        resultados.add(new RegistroBusqueda(id, nombre, tipo));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultados;
    }
}