package modelo;
import java.util.ArrayList;  

/**
 *
 * @authors Johan Stiven Rengifo y Tatiana Muñoz Daza
 * Modelo de datos Pacientes
 */

public class Pacientes {
    private int pacienteId;
    private String nombre;
    private String direccion;
    private ArrayList<Doctores> doctores = new ArrayList<>();
    private ArrayList<Enfermeros> enfermeros = new ArrayList<>();
    private ArrayList<Analisis> analisis = new ArrayList<>();

    public Pacientes(int pacienteId, String nombre, String direccion) {
        this.pacienteId = pacienteId;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public void mostrarInformacionPaciente() {
        System.out.println("ID del paciente: " + pacienteId);
        System.out.println("Nombre: " + nombre);
        System.out.println("Dirección: " + direccion);
        System.out.println("Doctores asignados:");
        for (Doctores doctor : doctores) {
            System.out.println("- " + doctor.getNombre() + " (" + doctor.getEspecialidad() + ")");
        }
        System.out.println("Enfermeros asignados:");
        for (Enfermeros enfermero : enfermeros) {
            System.out.println("- " + enfermero.getNombre());
        }
        System.out.println("Análisis realizados:");
        for (Analisis analisisItem : analisis) {
            System.out.println("- " + analisisItem.getTipo() + " solicitado por " + analisisItem.getDoctorSolicitante().getNombre());
        }

        System.out.println();
    }

    public int getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(int pacienteId) {
        this.pacienteId = pacienteId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<Doctores> getDoctores() {
        return doctores;
    }

    public void setDoctores(ArrayList<Doctores> doctores) {
        this.doctores = doctores;
    }

    public ArrayList<Enfermeros> getEnfermeros() {
        return enfermeros;
    }

    public void setEnfermeros(ArrayList<Enfermeros> enfermeros) {
        this.enfermeros = enfermeros;
    }

    public ArrayList<Analisis> getAnalisis() {
        return analisis;
    }

    public void setAnalisis(ArrayList<Analisis> analisis) {
        this.analisis = analisis;
    }
    
}
