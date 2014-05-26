package edu.uv.model.pojos;
// Generated 25/05/2014 02:39:24 PM by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * Pregunta generated by hbm2java
 */
public class Pregunta  implements java.io.Serializable {


     private Integer idPregunta;
     private Temas temas;
     private String tipoPregunta;
     private String descripcionPregunta;
     private String modalidadPregunta;
     private int complejidadPregunta;
     private Integer puntuacionPregunta;
     private String comentRetroalimentacion;
     private String estado;
     private Set examenPreguntas = new HashSet(0);
     private Set respuestases = new HashSet(0);

    public Pregunta() {
    }

	
    public Pregunta(String tipoPregunta, String descripcionPregunta, String modalidadPregunta, int complejidadPregunta) {
        this.tipoPregunta = tipoPregunta;
        this.descripcionPregunta = descripcionPregunta;
        this.modalidadPregunta = modalidadPregunta;
        this.complejidadPregunta = complejidadPregunta;
    }
    public Pregunta(Temas temas, String tipoPregunta, String descripcionPregunta, String modalidadPregunta, int complejidadPregunta, Integer puntuacionPregunta, String comentRetroalimentacion, String estado, Set examenPreguntas, Set respuestases) {
       this.temas = temas;
       this.tipoPregunta = tipoPregunta;
       this.descripcionPregunta = descripcionPregunta;
       this.modalidadPregunta = modalidadPregunta;
       this.complejidadPregunta = complejidadPregunta;
       this.puntuacionPregunta = puntuacionPregunta;
       this.comentRetroalimentacion = comentRetroalimentacion;
       this.estado = estado;
       this.examenPreguntas = examenPreguntas;
       this.respuestases = respuestases;
    }
   
    public Integer getIdPregunta() {
        return this.idPregunta;
    }
    
    public void setIdPregunta(Integer idPregunta) {
        this.idPregunta = idPregunta;
    }
    public Temas getTemas() {
        return this.temas;
    }
    
    public void setTemas(Temas temas) {
        this.temas = temas;
    }
    public String getTipoPregunta() {
        return this.tipoPregunta;
    }
    
    public void setTipoPregunta(String tipoPregunta) {
        this.tipoPregunta = tipoPregunta;
    }
    public String getDescripcionPregunta() {
        return this.descripcionPregunta;
    }
    
    public void setDescripcionPregunta(String descripcionPregunta) {
        this.descripcionPregunta = descripcionPregunta;
    }
    public String getModalidadPregunta() {
        return this.modalidadPregunta;
    }
    
    public void setModalidadPregunta(String modalidadPregunta) {
        this.modalidadPregunta = modalidadPregunta;
    }
    public int getComplejidadPregunta() {
        return this.complejidadPregunta;
    }
    
    public void setComplejidadPregunta(int complejidadPregunta) {
        this.complejidadPregunta = complejidadPregunta;
    }
    public Integer getPuntuacionPregunta() {
        return this.puntuacionPregunta;
    }
    
    public void setPuntuacionPregunta(Integer puntuacionPregunta) {
        this.puntuacionPregunta = puntuacionPregunta;
    }
    public String getComentRetroalimentacion() {
        return this.comentRetroalimentacion;
    }
    
    public void setComentRetroalimentacion(String comentRetroalimentacion) {
        this.comentRetroalimentacion = comentRetroalimentacion;
    }
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public Set getExamenPreguntas() {
        return this.examenPreguntas;
    }
    
    public void setExamenPreguntas(Set examenPreguntas) {
        this.examenPreguntas = examenPreguntas;
    }
    public Set getRespuestases() {
        return this.respuestases;
    }
    
    public void setRespuestases(Set respuestases) {
        this.respuestases = respuestases;
    }




}


