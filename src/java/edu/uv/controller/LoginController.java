package edu.uv.controller;

import edu.uv.model.dao.AcademiaDAO;
import edu.uv.model.dao.PersonalDAO;
import edu.uv.model.dao.UsuariosDAO;
import edu.uv.model.dao.ImparteDAO;
import edu.uv.model.pojos.Academia;
import edu.uv.model.pojos.Personal;
import edu.uv.model.pojos.Usuarios;
import edu.uv.model.pojos.Imparte;
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
                    //session.setAttribute("academia", null);
                    session.removeAttribute("academia");
                    
                    List<Imparte> mats =buscarMaterias(-50,0);
                    if (mats.size()>0) {
                        session.setAttribute("matslist", mats);
                    }
                    
                }else{/////////////////////////////////////////////////////////////////////////////////////////////////
                    int academia= buscarRol(per.getIdPersonal());
                    List<Imparte> mats =buscarMaterias(per.getIdPersonal(),1);
                    if (mats.size()>0) {
                        session.setAttribute("matslist", mats);
                    }
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
            session.setAttribute("estado", "Su cuenta no existe");
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
    
    protected List buscarMaterias(int idPersonal, int modo){
        ImparteDAO im=new ImparteDAO();
        List<Imparte>matsAll=im.findAll();
        List<Imparte> mats=new ArrayList();
        if (modo==0) {
            mats=matsAll;
        }else{
        for (Imparte imp:matsAll) {
            if (imp.getPersonal().getIdPersonal().equals(idPersonal)) {
                mats.add(imp);
            }
        }
        }
        
        return mats;
    }
    
    /*protected List buscarMaterias(int id personal){
        return null;
    }*/

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
