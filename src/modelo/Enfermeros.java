package modelo;

/**
 *
 * @authors Johan Stiven Rengifo y Tatiana Muñoz Daza
 */
public class Enfermeros {
    private int enfermeroId;
    private String nombre;

    public Enfermeros(int enfermeroId, String nombre) {
        this.enfermeroId = enfermeroId;
        this.nombre = nombre;
    }

    public int getEnfermeroId() {
        return enfermeroId;
    }

    public void setEnfermeroId(int enfermeroId) {
        this.enfermeroId = enfermeroId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
}

