package modelo;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @authors Johan Stiven Rengifo y Tatiana Muñoz Daza
 * API de la Barra de Busqueda
 */

public class Buscador {

    // Busqueda en odos los datos registrados
    public List<String> buscarEnTodos(List<Pacientes> pacientes, List<Doctores> doctores,
                                       List<Enfermeros> enfermeros, List<Analisis> analisis, String busqueda) {
        List<String> resultados = new ArrayList<>();

        // Buscar en pacientes
        for (Pacientes paciente : pacientes) {
            if (paciente.getNombre().toLowerCase().contains(busqueda.toLowerCase()) ||
                paciente.getDireccion().toLowerCase().contains(busqueda.toLowerCase())) {
                resultados.add("Paciente: " + paciente.getNombre() + " - " + paciente.getDireccion());
            }
        }

        // Buscar en doctores
        for (Doctores doctor : doctores) {
            if (doctor.getNombre().toLowerCase().contains(busqueda.toLowerCase()) ||
                doctor.getEspecialidad().toLowerCase().contains(busqueda.toLowerCase())) {
                resultados.add("Doctor: " + doctor.getNombre() + " - " + doctor.getEspecialidad());
            }
        }

        // Buscar en enfermeros
        for (Enfermeros enfermero : enfermeros) {
            if (enfermero.getNombre().toLowerCase().contains(busqueda.toLowerCase())) {
                resultados.add("Enfermero: " + enfermero.getNombre());
            }
        }

        // Buscar en análisis
        for (Analisis analisisItem : analisis) {
            if (analisisItem.getTipo().toLowerCase().contains(busqueda.toLowerCase()) ||
                analisisItem.getResultados().toLowerCase().contains(busqueda.toLowerCase())) {
                resultados.add("Análisis: " + analisisItem.getTipo() + " - " + analisisItem.getResultados());
            }
        }

        return resultados;
    }
}

