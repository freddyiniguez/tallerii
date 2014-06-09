<<<<<<< HEAD
package edu.uv.controller;

import edu.uv.model.dao.PersonalDAO;
import edu.uv.model.dao.UsuariosDAO;
import edu.uv.model.pojos.Personal;
import edu.uv.model.pojos.Usuarios;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {



    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PersonalDAO personal=new PersonalDAO();
        if (request.getParameter("usuario")!=null) {
            
        
        String usuario = request.getParameter("usuario");
        String pass = request.getParameter("password");
        Usuarios res = validar(usuario, pass);
        
        if (res!=null) {
            Personal per=res.getPersonal();
            HttpSession session = request.getSession(true);
            session.setAttribute("user", per.getNombreProfesor());
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }else{
            request.getRequestDispatcher("IniciarSesion.jsp").forward(request, response);
        
        }
        }else
        {
            HttpSession session = request.getSession(true);
            String ses=(String)session.getAttribute("user");
            if (ses==null) {
            request.getRequestDispatcher("IniciarSesion.jsp").forward(request, response);    
            }else{
            request.getRequestDispatcher("index.jsp").forward(request, response);    
            }
        }
    }

    protected Usuarios validar(String usuario, String password) {
        UsuariosDAO Usuarios_DAO = new UsuariosDAO();
        List<Usuarios> users = Usuarios_DAO.findAll();
        boolean encontrado = false;
        Usuarios u=null;

        for (Usuarios user : users) {
            String userlist = user.getLoginUsuario();
            String passlist = user.getPasswordUsuario();
            //boolean res=userlist.matches(usuario);

            if (userlist.matches(usuario) && passlist.matches(password)) {
                encontrado = true;
                u=user;
            }
        }
        return u;
        /*if (encontrado == false) {
            return u;
        } else {
            return u;
        }*/
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
       // request.getRequestDispatcher("IniciarSesion.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
=======
package edu.uv.controller;

import edu.uv.model.dao.AcademiaDAO;
import edu.uv.model.dao.PersonalDAO;
import edu.uv.model.dao.UsuariosDAO;
import edu.uv.model.pojos.Academia;
import edu.uv.model.pojos.Personal;
import edu.uv.model.pojos.Usuarios;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {



    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PersonalDAO personal=new PersonalDAO();
        HttpSession session = request.getSession(true);
        //session.invalidate();
        //session = request.getSession(true);
        if (request.getParameter("usuario")!=null) {
            
        
        String usuario = request.getParameter("usuario");
        String pass = request.getParameter("password");
        Usuarios res = validar(usuario, pass);
        
        if (res!=null) {
            Personal per=res.getPersonal();
            session.setAttribute("idusuario", res.getIdUsuario());
            
            if (res.getEstadoUsuario().equals("inactivo")) {
                session.setAttribute("estado", "Su cuenta esta desactivada, consulte al administrador");
                request.getRequestDispatcher("login_.jsp").forward(request, response);
            }else{
                if (res.getRol().equals("Administrador")) {
                    session.setAttribute("rol", "Administrador");
                    
                }else{/////////////////////////////////////////////////////////////////////////////////////////////////
                    int academia= buscarRol(per.getIdPersonal());
                    if (academia!=-5) {
                        session.setAttribute("rol", "Coordinador");
                        session.setAttribute("academia", academia);
                    }else{
                        session.setAttribute("rol", "Profesor");
                    }
                }
                
            session.setAttribute("user", res.getLoginUsuario());
            session.setAttribute("estado", "");
            request.getRequestDispatcher("index.jsp").forward(request, response);
            }
           
        }else{
            session.setAttribute("estado", "su cuenta no existe");
            request.getRequestDispatcher("login_.jsp").forward(request, response);
            
        }
        }else
        {
            session = request.getSession(true);
            String ses=(String)session.getAttribute("user");
            if (ses==null) {
            session.setAttribute("estado", "");
            request.getRequestDispatcher("login_.jsp").forward(request, response);    
            }else{
            session.setAttribute("estado", "");
            request.getRequestDispatcher("index.jsp").forward(request, response);   
            }
        }
    }
    
    protected int buscarRol(int idPersonal){
        AcademiaDAO ac=new AcademiaDAO();
        List<Academia>acs=ac.findAll();
        int idAcademia= -5;
        //ArrayList<Academia>AcademiasR=new ArrayList();
        
        for(Academia a : acs){
            if (a.getPersonal().getIdPersonal().equals(idPersonal)) {
                idAcademia=a.getIdAcademia();
            }
        }
        
        return idAcademia;
        
    }

    protected Usuarios validar(String usuario, String password) {
        UsuariosDAO Usuarios_DAO = new UsuariosDAO();
        List<Usuarios> users = Usuarios_DAO.findAll();
        boolean encontrado = false;
        Usuarios u=null;

        for (Usuarios user : users) {
            String userlist = user.getLoginUsuario();
            String passlist = user.getPasswordUsuario();
            //boolean res=userlist.matches(usuario);

            if (userlist.matches(usuario) && passlist.matches(password)) {
                encontrado = true;
                u=user;
            }
        }
        return u;
        /*if (encontrado == false) {
            return u;
        } else {
            return u;
        }*/
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
       // request.getRequestDispatcher("IniciarSesion.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
>>>>>>> 7bd91c95df4bcb7e4d563aa3d059474dee9d7b57
