package edu.uv.model.pojos;
// Generated 23/05/2014 05:30:57 PM by Hibernate Tools 3.6.0



/**
 * CarreraAcademia generated by hbm2java
 */
public class CarreraAcademia  implements java.io.Serializable {


     private Integer idCarreraAcademia;
     private Carrera carrera;
     private Academia academia;

    public CarreraAcademia() {
    }

    public CarreraAcademia(Carrera carrera, Academia academia) {
       this.carrera = carrera;
       this.academia = academia;
    }
   
    public Integer getIdCarreraAcademia() {
        return this.idCarreraAcademia;
    }
    
    public void setIdCarreraAcademia(Integer idCarreraAcademia) {
        this.idCarreraAcademia = idCarreraAcademia;
    }
    public Carrera getCarrera() {
        return this.carrera;
    }
    
    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }
    public Academia getAcademia() {
        return this.academia;
    }
    
    public void setAcademia(Academia academia) {
        this.academia = academia;
    }




}


