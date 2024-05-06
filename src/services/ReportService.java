package services;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
/**
 *
 * @authors Johan Stiven Rengifo y Tatiana Muñoz Daza
 * Informes de pacientes, Análisis médicos desde Base de datos
 */
public class ReportService {
    public static void generatePDFReport(String filename, String query) {
        try (Connection connection = DatabaseService.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery()) {

            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(filename));
            document.open();

            while (resultSet.next()) {
                String reportLine = resultSet.getString(1) + " - " + resultSet.getString(2);
                document.add(new Paragraph(reportLine));
            }

            document.close();
            System.out.println("Informe PDF generado exitosamente: " + filename);
        } catch (SQLException | DocumentException | IOException e) {
            System.err.println("Error al generar el informe PDF: " + e.getMessage());
        }
    }
}
