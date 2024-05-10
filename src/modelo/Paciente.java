package modelo;

public class Paciente {
    private int id;
    private String numeroHistoriaClinica;
    private String nombre;
    private String direccion;
     
    // Constructor
    public Paciente(int id, String numeroHistoriaClinica, String nombre, String direccion) {
        this.id = id;
        this.numeroHistoriaClinica = numeroHistoriaClinica;
        this.nombre = nombre;
        this.direccion = direccion;
    }
    
    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumeroHistoriaClinica() {
        return numeroHistoriaClinica;
    }

    public void setNumeroHistoriaClinica(String numeroHistoriaClinica) {
        this.numeroHistoriaClinica = numeroHistoriaClinica;
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
}
