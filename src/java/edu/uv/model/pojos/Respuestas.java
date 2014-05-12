package edu.uv.model.pojos;
// Generated 12/05/2014 09:41:03 AM by Hibernate Tools 3.6.0



/**
 * Respuestas generated by hbm2java
 */
public class Respuestas  implements java.io.Serializable {


     private Integer idRespuesta;
     private Pregunta pregunta;
     private String descripcionRespuesta;
     private String tipoResp;

    public Respuestas() {
    }

	
    public Respuestas(Pregunta pregunta) {
        this.pregunta = pregunta;
    }
    public Respuestas(Pregunta pregunta, String descripcionRespuesta, String tipoResp) {
       this.pregunta = pregunta;
       this.descripcionRespuesta = descripcionRespuesta;
       this.tipoResp = tipoResp;
    }
   
    public Integer getIdRespuesta() {
        return this.idRespuesta;
    }
    
    public void setIdRespuesta(Integer idRespuesta) {
        this.idRespuesta = idRespuesta;
    }
    public Pregunta getPregunta() {
        return this.pregunta;
    }
    
    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }
    public String getDescripcionRespuesta() {
        return this.descripcionRespuesta;
    }
    
    public void setDescripcionRespuesta(String descripcionRespuesta) {
        this.descripcionRespuesta = descripcionRespuesta;
    }
    public String getTipoResp() {
        return this.tipoResp;
    }
    
    public void setTipoResp(String tipoResp) {
        this.tipoResp = tipoResp;
    }




}


