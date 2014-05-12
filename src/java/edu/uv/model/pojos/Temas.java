package edu.uv.model.pojos;
// Generated 12/05/2014 09:41:03 AM by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * Temas generated by hbm2java
 */
public class Temas  implements java.io.Serializable {


     private Integer idTema;
     private Unidades unidades;
     private Temas temas;
     private String nombreTema;
     private Set temases = new HashSet(0);
     private Set preguntas = new HashSet(0);

    public Temas() {
    }

	
    public Temas(Unidades unidades, String nombreTema) {
        this.unidades = unidades;
        this.nombreTema = nombreTema;
    }
    public Temas(Unidades unidades, Temas temas, String nombreTema, Set temases, Set preguntas) {
       this.unidades = unidades;
       this.temas = temas;
       this.nombreTema = nombreTema;
       this.temases = temases;
       this.preguntas = preguntas;
    }
   
    public Integer getIdTema() {
        return this.idTema;
    }
    
    public void setIdTema(Integer idTema) {
        this.idTema = idTema;
    }
    public Unidades getUnidades() {
        return this.unidades;
    }
    
    public void setUnidades(Unidades unidades) {
        this.unidades = unidades;
    }
    public Temas getTemas() {
        return this.temas;
    }
    
    public void setTemas(Temas temas) {
        this.temas = temas;
    }
    public String getNombreTema() {
        return this.nombreTema;
    }
    
    public void setNombreTema(String nombreTema) {
        this.nombreTema = nombreTema;
    }
    public Set getTemases() {
        return this.temases;
    }
    
    public void setTemases(Set temases) {
        this.temases = temases;
    }
    public Set getPreguntas() {
        return this.preguntas;
    }
    
    public void setPreguntas(Set preguntas) {
        this.preguntas = preguntas;
    }




}


