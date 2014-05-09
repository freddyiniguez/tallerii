package edu.uv.modelo.pojos;
// Generated 08/05/2014 12:06:02 AM by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * Roles generated by hbm2java
 */
public class Roles  implements java.io.Serializable {


     private Integer idRol;
     private String nombreRol;
     private String descripcion;
     private Set usuarioses = new HashSet(0);

    public Roles() {
    }

	
    public Roles(String nombreRol) {
        this.nombreRol = nombreRol;
    }
    public Roles(String nombreRol, String descripcion, Set usuarioses) {
       this.nombreRol = nombreRol;
       this.descripcion = descripcion;
       this.usuarioses = usuarioses;
    }
   
    public Integer getIdRol() {
        return this.idRol;
    }
    
    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }
    public String getNombreRol() {
        return this.nombreRol;
    }
    
    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Set getUsuarioses() {
        return this.usuarioses;
    }
    
    public void setUsuarioses(Set usuarioses) {
        this.usuarioses = usuarioses;
    }




}


