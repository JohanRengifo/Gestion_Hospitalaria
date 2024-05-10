package modelo;
import java.util.Date;

public class Analisis {
    private int idPaciente;
    private String tipoAnalisis;
    private Date fechaRealizacion;
    private int medicoSolicitante;
    private int enfermeroRealizador;
    private String resultado;
    
    // Constructor
    public Analisis(int idPaciente, String tipoAnalisis, Date fechaRealizacion, int medicoSolicitante, int enfermeroRealizador, String resultado) {
        this.idPaciente = idPaciente;
        this.tipoAnalisis = tipoAnalisis;
        this.fechaRealizacion = fechaRealizacion;
        this.medicoSolicitante = medicoSolicitante;
        this.enfermeroRealizador = enfermeroRealizador;
        this.resultado = resultado;
    }
    
    // Getters y setters
    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getTipoAnalisis() {
        return tipoAnalisis;
    }

    public void setTipoAnalisis(String tipoAnalisis) {
        this.tipoAnalisis = tipoAnalisis;
    }

    public Date getFechaRealizacion() {
        return fechaRealizacion;
    }

    public void setFechaRealizacion(Date fechaRealizacion) {
        this.fechaRealizacion = fechaRealizacion;
    }

    public int getMedicoSolicitante() {
        return medicoSolicitante;
    }

    public void setMedicoSolicitante(int medicoSolicitante) {
        this.medicoSolicitante = medicoSolicitante;
    }

    public int getEnfermeroRealizador() {
        return enfermeroRealizador;
    }

    public void setEnfermeroRealizador(int enfermeroRealizador) {
        this.enfermeroRealizador = enfermeroRealizador;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
    
}
