package modelo;

public class EmpleadoSanitario {
    private int id;
    private String numeroEmpleado;
    private String nombre;
    private String tipo;
    private String especialidad; // Solo para el médico
    
    // Constructor
    public EmpleadoSanitario(int id, String numeroEmpleado, String nombre, String tipo, String especialidad) {
        this.id = id;
        this.numeroEmpleado = numeroEmpleado;
        this.nombre = nombre;
        this.tipo = tipo;
        this.especialidad = especialidad;
    }
    
    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumeroEmpleado() {
        return numeroEmpleado;
    }

    public void setNumeroEmpleado(String numeroEmpleado) {
        this.numeroEmpleado = numeroEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
}
