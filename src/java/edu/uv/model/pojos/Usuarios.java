package edu.uv.model.pojos;
// Generated 12/05/2014 09:41:03 AM by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * Usuarios generated by hbm2java
 */
public class Usuarios  implements java.io.Serializable {


     private Integer idUsuario;
     private Personal personal;
     private String loginUsuario;
     private String passwordUsuario;
     private String estadoUsuario;
     private Set usuarioRols = new HashSet(0);

    public Usuarios() {
    }

	
    public Usuarios(Personal personal, String loginUsuario, String passwordUsuario) {
        this.personal = personal;
        this.loginUsuario = loginUsuario;
        this.passwordUsuario = passwordUsuario;
    }
    public Usuarios(Personal personal, String loginUsuario, String passwordUsuario, String estadoUsuario, Set usuarioRols) {
       this.personal = personal;
       this.loginUsuario = loginUsuario;
       this.passwordUsuario = passwordUsuario;
       this.estadoUsuario = estadoUsuario;
       this.usuarioRols = usuarioRols;
    }
   
    public Integer getIdUsuario() {
        return this.idUsuario;
    }
    
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
    public Personal getPersonal() {
        return this.personal;
    }
    
    public void setPersonal(Personal personal) {
        this.personal = personal;
    }
    public String getLoginUsuario() {
        return this.loginUsuario;
    }
    
    public void setLoginUsuario(String loginUsuario) {
        this.loginUsuario = loginUsuario;
    }
    public String getPasswordUsuario() {
        return this.passwordUsuario;
    }
    
    public void setPasswordUsuario(String passwordUsuario) {
        this.passwordUsuario = passwordUsuario;
    }
    public String getEstadoUsuario() {
        return this.estadoUsuario;
    }
    
    public void setEstadoUsuario(String estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }
    public Set getUsuarioRols() {
        return this.usuarioRols;
    }
    
    public void setUsuarioRols(Set usuarioRols) {
        this.usuarioRols = usuarioRols;
    }




}


