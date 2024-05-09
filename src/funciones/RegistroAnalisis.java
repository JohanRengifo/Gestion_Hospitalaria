package funciones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import modelo.Analisis;

public class RegistroAnalisis {
    
    public static boolean registrarAnalisis(Analisis analisis) {
        // Insertar análisis en la BD
        String query = "INSERT INTO Analisis (id_paciente, tipo_analisis, fecha_realizacion, medico_solicitante, enfermero_realizador, resultado) VALUES (?, ?, ?, ?, ?, ?)";
        
        try (Connection connection = DBManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            // Establecemos los parámetros de la consulta
            statement.setInt(1, analisis.getIdPaciente());
            statement.setString(2, analisis.getTipoAnalisis());
            statement.setDate(3, new java.sql.Date(analisis.getFechaRealizacion().getTime()));
            statement.setInt(4, analisis.getMedicoSolicitante());
            statement.setInt(5, analisis.getEnfermeroRealizador());
            statement.setString(6, analisis.getResultado());
            
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
