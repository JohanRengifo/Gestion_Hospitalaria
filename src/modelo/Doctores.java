package modelo;

/**
 *
 * @authors Johan Stiven Rengifo y Tatiana Muñoz Daza
 */
public class Doctores {
    private int doctorId;
    private String nombre;
    private String especialidad;

    public Doctores(int doctorId, String nombre, String especialidad) {
        this.doctorId = doctorId;
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    
}

