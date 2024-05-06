package funciones;
import modelo.Pacientes;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @authors Johan Stiven Rengifo y Tatiana Muñoz Daza
 */
public class EdicionPacientes {
    // Editar datos de un paciente
    public void editarPaciente(List<Pacientes> pacientes, int id, String nuevoNombre, String nuevaDireccion) {
        for (Pacientes paciente : pacientes) {
            if (paciente.getPacienteId() == id) {
                paciente.setNombre(nuevoNombre);
                paciente.setDireccion(nuevaDireccion);
                System.out.println("Datos del paciente editados correctamente.");
                return;
            }
        }
        System.out.println("No se encontró un paciente con el ID proporcionado.");
    }

    // Eliminar un paciente
    public void eliminarPaciente(List<Pacientes> pacientes, int id) {
        for (int i = 0; i < pacientes.size(); i++) {
            if (pacientes.get(i).getPacienteId() == id) {
                pacientes.remove(i);
                System.out.println("Paciente eliminado correctamente.");
                return;
            }
        }
        System.out.println("No se encontró un paciente con el ID proporcionado.");
    }

    // Agregar un nuevo paciente
    public void agregarPaciente(List<Pacientes> pacientes, int id, String nombre, String direccion) {
        pacientes.add(new Pacientes(id, nombre, direccion));
        System.out.println("Nuevo paciente agregado correctamente.");
    }
}

