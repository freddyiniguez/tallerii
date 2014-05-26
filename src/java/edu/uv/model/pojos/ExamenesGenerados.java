package edu.uv.model.pojos;
// Generated 25/05/2014 11:11:21 AM by Hibernate Tools 3.6.0


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * ExamenesGenerados generated by hbm2java
 */
public class ExamenesGenerados  implements java.io.Serializable {


     private Integer idexamenesGenerados;
     private ExperieciaEducativa experieciaEducativa;
     private Personal personal;
     private String periodo;
     private String tipoExamen;
     private Date fechaCreacion;
     private String descripcionExamen;
     private Integer porcTeoria;
     private Integer porcPractica;
     private String estadoExamen;
     private Set examenPreguntas = new HashSet(0);

    public ExamenesGenerados() {
    }

	
    public ExamenesGenerados(String periodo, String tipoExamen, Date fechaCreacion, String estadoExamen) {
        this.periodo = periodo;
        this.tipoExamen = tipoExamen;
        this.fechaCreacion = fechaCreacion;
        this.estadoExamen = estadoExamen;
    }
    public ExamenesGenerados(ExperieciaEducativa experieciaEducativa, Personal personal, String periodo, String tipoExamen, Date fechaCreacion, String descripcionExamen, Integer porcTeoria, Integer porcPractica, String estadoExamen, Set examenPreguntas) {
       this.experieciaEducativa = experieciaEducativa;
       this.personal = personal;
       this.periodo = periodo;
       this.tipoExamen = tipoExamen;
       this.fechaCreacion = fechaCreacion;
       this.descripcionExamen = descripcionExamen;
       this.porcTeoria = porcTeoria;
       this.porcPractica = porcPractica;
       this.estadoExamen = estadoExamen;
       this.examenPreguntas = examenPreguntas;
    }
   
    public Integer getIdexamenesGenerados() {
        return this.idexamenesGenerados;
    }
    
    public void setIdexamenesGenerados(Integer idexamenesGenerados) {
        this.idexamenesGenerados = idexamenesGenerados;
    }
    public ExperieciaEducativa getExperieciaEducativa() {
        return this.experieciaEducativa;
    }
    
    public void setExperieciaEducativa(ExperieciaEducativa experieciaEducativa) {
        this.experieciaEducativa = experieciaEducativa;
    }
    public Personal getPersonal() {
        return this.personal;
    }
    
    public void setPersonal(Personal personal) {
        this.personal = personal;
    }
    public String getPeriodo() {
        return this.periodo;
    }
    
    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }
    public String getTipoExamen() {
        return this.tipoExamen;
    }
    
    public void setTipoExamen(String tipoExamen) {
        this.tipoExamen = tipoExamen;
    }
    public Date getFechaCreacion() {
        return this.fechaCreacion;
    }
    
    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    public String getDescripcionExamen() {
        return this.descripcionExamen;
    }
    
    public void setDescripcionExamen(String descripcionExamen) {
        this.descripcionExamen = descripcionExamen;
    }
    public Integer getPorcTeoria() {
        return this.porcTeoria;
    }
    
    public void setPorcTeoria(Integer porcTeoria) {
        this.porcTeoria = porcTeoria;
    }
    public Integer getPorcPractica() {
        return this.porcPractica;
    }
    
    public void setPorcPractica(Integer porcPractica) {
        this.porcPractica = porcPractica;
    }
    public String getEstadoExamen() {
        return this.estadoExamen;
    }
    
    public void setEstadoExamen(String estadoExamen) {
        this.estadoExamen = estadoExamen;
    }
    public Set getExamenPreguntas() {
        return this.examenPreguntas;
    }
    
    public void setExamenPreguntas(Set examenPreguntas) {
        this.examenPreguntas = examenPreguntas;
    }




}


