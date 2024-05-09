package funciones;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType0Font;

import java.io.File;
import java.io.IOException;
import java.util.List;
import modelo.Analisis;

public class ReportService {

    public static void generarInformeAnalisis(List<Analisis> listaAnalisis, String carpetaSalida) {
        // Generar el nombre del archivo único
        String nombreArchivo = "informe_analisis_" + System.currentTimeMillis() + ".pdf";

        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage();
            document.addPage(page);

            PDType0Font font = PDType0Font.load(document, new File("fonts/Times New Roman.ttf"));

            try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
                contentStream.setFont(font, 12);
                contentStream.beginText();
                contentStream.newLineAtOffset(100, 700);
                contentStream.showText("Informe de Análisis");
                contentStream.newLine();
                contentStream.newLine();

                for (Analisis analisis : listaAnalisis) {
                    contentStream.showText("ID del paciente: " + analisis.getIdPaciente());
                    contentStream.newLine();
                    contentStream.showText("Tipo de análisis: " + analisis.getTipoAnalisis());
                    contentStream.newLine();
                    contentStream.showText("Fecha de realización: " + analisis.getFechaRealizacion());
                    contentStream.newLine();
                    contentStream.showText("Médico solicitante: " + analisis.getMedicoSolicitante());
                    contentStream.newLine();
                    contentStream.showText("Enfermero realizador: " + analisis.getEnfermeroRealizador());
                    contentStream.newLine();
                    contentStream.showText("Resultado: " + analisis.getResultado());
                    contentStream.newLine();
                    contentStream.newLine();
                }

                contentStream.endText();
            }

            document.save(carpetaSalida + "/" + nombreArchivo);
            System.out.println("Informe de análisis generado correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}