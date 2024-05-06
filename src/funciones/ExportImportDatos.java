package funciones;
import modelo.Pacientes;
import java.io.*;
import java.util.ArrayList;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import java.io.FileNotFoundException;
import java.util.List;
/**
 *
 * @authors Johan Stiven Rengifo y Tatiana Muñoz Daza
 * Exportación de Datos, desde los Botones de la UI
 */
public class ExportImportDatos {

    // Exportar la lista de pacientes a un archivo CSV
    public void exportarPacientes(List<Pacientes> pacientes, String archivo) {
        try (PrintWriter writer = new PrintWriter(new File(archivo))) {
            StringBuilder sb = new StringBuilder();
            sb.append("Paciente ID,Nombre,Dirección\n");
            for (Pacientes paciente : pacientes) {
                sb.append(paciente.getPacienteId()).append(",").append(paciente.getNombre()).append(",").append(paciente.getDireccion()).append("\n");
            }
            writer.write(sb.toString());
            System.out.println("Datos exportados correctamente a " + archivo);
        } catch (FileNotFoundException e) {
            System.err.println("Error al exportar los datos: " + e.getMessage());
        }
    }

    // Importar la lista de pacientes desde un archivo CSV
    public List<Pacientes> importarPacientes(String archivo) {
        List<Pacientes> pacientes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            // Saltar la primera línea que contiene los nombres de las columnas
            reader.readLine();
            while ((linea = reader.readLine()) != null) {
                String[] campos = linea.split(",");
                int pacienteId = Integer.parseInt(campos[0]);
                String nombre = campos[1];
                String direccion = campos[2];
                pacientes.add(new Pacientes(pacienteId, nombre, direccion));
            }
            System.out.println("Datos importados correctamente desde " + archivo);
        } catch (IOException e) {
            System.err.println("Error al importar los datos: " + e.getMessage());
        }
        return pacientes;
    }
    
    //Exportar la lista de pacientes a un archivo PDF (Beta)
    public void exportarPacientesPDF(List<Pacientes> pacientes, String archivo) {
        try {
            PdfWriter writer = new PdfWriter(archivo);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            // Agregar contenido al documento PDF
            document.add(new Paragraph("Lista de Pacientes"));
            document.add(new Paragraph("\n"));

            for (Pacientes paciente : pacientes) {
                document.add(new Paragraph("ID: " + paciente.getPacienteId()));
                document.add(new Paragraph("Nombre: " + paciente.getNombre()));
                document.add(new Paragraph("Dirección: " + paciente.getDireccion()));
                document.add(new Paragraph("\n"));
            }

            document.close();
            System.out.println("Datos exportados correctamente a " + archivo);
        } catch (FileNotFoundException e) {
            System.err.println("Error al exportar los datos: " + e.getMessage());
        }
    }
}