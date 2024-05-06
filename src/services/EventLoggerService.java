package services;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
/**
 *
 * @authors Johan Stiven Rengifo y Tatiana Muñoz Daza
 * Registro de eventos (Beta)
 */
public class EventLoggerService {
    private static final String LOG_FILE = "event_log.txt";

    public static void logInfo(String message) {
        log("[INFO]", message);
    }

    public static void logWarning(String message) {
        log("[WARNING]", message);
    }

    public static void logError(String message) {
        log("[ERROR]", message);
    }

    private static void log(String level, String message) {
        String logEntry = "[" + LocalDateTime.now() + "] " + level + " " + message;
        try (PrintWriter writer = new PrintWriter(new FileWriter(LOG_FILE, true))) {
            writer.println(logEntry);
            System.out.println(logEntry);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
