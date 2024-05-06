package modelo;

/**
 *
 * @authors Johan Stiven Rengifo y Tatiana Muñoz Daza
 */
import java.util.Date;

public class Analisis {
    private int numeroReferencia;
    private String tipo;
    private Date fechaRealizacion;
    private Doctores DoctorSolicitante;
    private Enfermeros enfermeroResponsable;
    private String resultados;

    public Analisis(int numeroReferencia, String tipo, Date fechaRealizacion, Doctores doctorSolicitante, Enfermeros enfermeroResponsable) {
        this.numeroReferencia = numeroReferencia;
        this.tipo = tipo;
        this.fechaRealizacion = fechaRealizacion;
        this.DoctorSolicitante = doctorSolicitante;
        this.enfermeroResponsable = enfermeroResponsable;
    }
    
    public Doctores getDoctorSolicitante() {
        return DoctorSolicitante;
    }

    public void setDoctorSolicitante(Doctores DoctorSolicitante) {
        this.DoctorSolicitante = DoctorSolicitante;
    }

    public int getNumeroReferencia() {
        return numeroReferencia;
    }

    public void setNumeroReferencia(int numeroReferencia) {
        this.numeroReferencia = numeroReferencia;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getFechaRealizacion() {
        return fechaRealizacion;
    }

    public void setFechaRealizacion(Date fechaRealizacion) {
        this.fechaRealizacion = fechaRealizacion;
    }

    public Enfermeros getEnfermeroResponsable() {
        return enfermeroResponsable;
    }

    public void setEnfermeroResponsable(Enfermeros enfermeroResponsable) {
        this.enfermeroResponsable = enfermeroResponsable;
    }

    public String getResultados() {
        return resultados;
    }

    public void setResultados(String resultados) {
        this.resultados = resultados;
    }



    
}
