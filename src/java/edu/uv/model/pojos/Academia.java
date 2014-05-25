package edu.uv.model.pojos;
// Generated 25/05/2014 11:11:21 AM by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * Academia generated by hbm2java
 */
public class Academia  implements java.io.Serializable {


     private Integer idAcademia;
     private Personal personal;
     private String nombreAcademia;
     private Set carreraAcademias = new HashSet(0);
     private Set experieciaEducativas = new HashSet(0);

    public Academia() {
    }

	
    public Academia(String nombreAcademia) {
        this.nombreAcademia = nombreAcademia;
    }
    public Academia(Personal personal, String nombreAcademia, Set carreraAcademias, Set experieciaEducativas) {
       this.personal = personal;
       this.nombreAcademia = nombreAcademia;
       this.carreraAcademias = carreraAcademias;
       this.experieciaEducativas = experieciaEducativas;
    }
   
    public Integer getIdAcademia() {
        return this.idAcademia;
    }
    
    public void setIdAcademia(Integer idAcademia) {
        this.idAcademia = idAcademia;
    }
    public Personal getPersonal() {
        return this.personal;
    }
    
    public void setPersonal(Personal personal) {
        this.personal = personal;
    }
    public String getNombreAcademia() {
        return this.nombreAcademia;
    }
    
    public void setNombreAcademia(String nombreAcademia) {
        this.nombreAcademia = nombreAcademia;
    }
    public Set getCarreraAcademias() {
        return this.carreraAcademias;
    }
    
    public void setCarreraAcademias(Set carreraAcademias) {
        this.carreraAcademias = carreraAcademias;
    }
    public Set getExperieciaEducativas() {
        return this.experieciaEducativas;
    }
    
    public void setExperieciaEducativas(Set experieciaEducativas) {
        this.experieciaEducativas = experieciaEducativas;
    }




}


