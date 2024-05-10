package funciones;

import com.mysql.cj.jdbc.result.ResultSetImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import modelo.Analisis;

public class RegistroAnalisis {
    
    public static boolean registrarAnalisis(Analisis analisis) {
        // Insertar análisis en la BD
        String query = "INSERT INTO Analisis (id_paciente, tipo_analisis, fecha_realizacion, medico_solicitante, enfermero_realizador, resultado) VALUES (?, ?, ?, ?, ?, ?)";
        
        try (Connection connection = DBManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            // Establecer los parámetros de la consulta
            statement.setInt(1, analisis.getIdPaciente());
            statement.setString(2, analisis.getTipoAnalisis());
            statement.setTimestamp(3, new Timestamp(analisis.getFechaRealizacion().getTime()));
            statement.setInt(4, analisis.getMedicoSolicitante());
            statement.setInt(5, analisis.getEnfermeroRealizador());
            statement.setString(6, analisis.getResultado());
            
            // Ejecutar la inserción
            int rowsInserted = statement.executeUpdate();
            
            // Verificar si se insertó correctamente
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false; 
        }
    }

    public class PacienteDAO {

        // Método para obtener los IDs de los pacientes
        public static List<Integer> obtenerIDsPacientes() {
            List<Integer> idsPacientes = new ArrayList<>();

            try (Connection connection = DBManager.getConnection();
                 PreparedStatement statement = connection.prepareStatement("SELECT id FROM Pacientes");
                 ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    int idPaciente = resultSet.getInt("id");
                    idsPacientes.add(idPaciente);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return idsPacientes;
        }
    }
}