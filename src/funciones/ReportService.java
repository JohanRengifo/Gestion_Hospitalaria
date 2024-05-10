package funciones;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import java.io.IOException;
import java.io.File;
import java.util.List;
import modelo.Analisis;

public class ReportService {

    public static void generarInformeAnalisis(List<Analisis> listaAnalisis, String carpetaSalida) {
        String nombreArchivo = "informe_analisis_" + System.currentTimeMillis() + ".pdf";
        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);
            String directorioActual = System.getProperty("user.dir");
            String rutaFuente = directorioActual + "/src/funciones/fonts/TimesNewRoman.ttf";
            PDType0Font font = PDType0Font.load(document, new File(rutaFuente));
            try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
                contentStream.setFont(font, 12);
                int currentYPosition = 700; // Posición vertical inicial de la tabla
                int rowHeight = 20; // Altura de cada fila de la tabla
                // Definir las coordenadas de inicio y fin de la tabla
                float tableTopY = 700;
                float tableBottomY = 50;
                float tableWidth = page.getMediaBox().getWidth() - 50;
                float tableXPosition = 50;
                // Definir el número de columnas y sus anchos
                float[] columnWidths = {80, 100, 150, 150, 150, 100}; // Anchura de cada columna
                float columnHeight = 20; // Altura de las celdas
                // Imprimir encabezados de columna
                String[] headers = {"ID del paciente", "Tipo de análisis", "Fecha de realización", "Médico solicitante", "Enfermero realizador", "Resultado"};
                drawRow(contentStream, font, 12, tableXPosition, tableTopY, tableWidth, columnHeight, headers);
                for (Analisis analisis : listaAnalisis) {
                    String[] rowData = {
                        String.valueOf(analisis.getIdPaciente()),
                        analisis.getTipoAnalisis(),
                        analisis.getFechaRealizacion().toString(),
                        String.valueOf(analisis.getMedicoSolicitante()), 
                        String.valueOf(analisis.getEnfermeroRealizador()), 
                        analisis.getResultado()
                    };
                    drawRow(contentStream, font, 12, tableXPosition, currentYPosition, tableWidth, columnHeight, rowData);
                    currentYPosition -= rowHeight;
                    if (currentYPosition <= tableBottomY) {
                        contentStream.endText();
                        contentStream.close();
                        page = new PDPage(PDRectangle.A4);
                        document.addPage(page);
                        contentStream = new PDPageContentStream(document, page);
                        contentStream.setFont(font, 12);
                        contentStream.beginText();
                        currentYPosition = (int) tableTopY;
                        drawRow(contentStream, font, 12, tableXPosition, tableTopY, tableWidth, columnHeight, headers);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            document.save(carpetaSalida + "/" + nombreArchivo);
            System.out.println("Informe de análisis generado correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void drawRow(PDPageContentStream contentStream, PDType0Font font, int fontSize, float x, float y, float width, float rowHeight, String[] rowData) throws IOException {
        float cellMargin = 5;
        float tableYPosition = y;
        float tableBottomY = y - rowHeight;
        // Dibujar cada celda
        for (String text : rowData) {
            contentStream.beginText();
            contentStream.setFont(font, fontSize);
            contentStream.newLineAtOffset(x + cellMargin, tableYPosition - (rowHeight / 2f) - (fontSize / 2f));
            contentStream.showText(text != null ? text : "");
            contentStream.endText();
            x += width;
        }
    }
}