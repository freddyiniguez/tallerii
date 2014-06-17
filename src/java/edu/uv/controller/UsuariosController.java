package edu.uv.controller;
import edu.uv.model.dao.PersonalDAO;
import edu.uv.model.dao.UsuariosDAO;
import edu.uv.model.pojos.Personal;
import edu.uv.model.pojos.Usuarios;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

@WebServlet(name = "UsuariosController", urlPatterns = {"/UsuariosController"})
public class UsuariosController extends HttpServlet {
    static final String LIST = "";
    static final String DELETE = "borrar";
    static final String FIND ="buscar";
    static final String ADD = "agregar";
    static final String UPDATE = "actualizar";
    static final String INSERT = "insertar";


protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            //validar que el usuario tenga la sesion iniciada
            HttpSession session = request.getSession(true);
            
            if ((session.getAttribute("user") == null)) {
            request.getRequestDispatcher("login_.jsp").forward(request, response);
            return;
            } 
           String accion = request.getParameter("accion");
            String id ="";
            String id2="";
            Personal x = null;
            Usuarios c = null;
            Personal P = new Personal();
            response.setContentType("text/html;charset=UTF-8");
            UsuariosDAO Usuarios_DAO = new UsuariosDAO();
            PersonalDAO Personal_DAO = new PersonalDAO();
            //crear el factory para iniciar la validacion
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();
        if (accion == null) {
            request.setAttribute("list",Usuarios_DAO.findAll());
            request.getRequestDispatcher("Usuarios_list.jsp").forward(request, response); 
        } else switch(accion){
            case INSERT:
                c = new Usuarios();
                c.setLoginUsuario(new String(request.getParameter("loginUsuario").getBytes("ISO-8859-1"),"UTF-8"));
                c.setPasswordUsuario(new String(request.getParameter("paswordUsuario").getBytes("ISO-8859-1"),"UTF-8"));
                c.setEstadoUsuario(new String(request.getParameter("estadoUsuario").getBytes("ISO-8859-1"),"UTF-8"));
                c.setRol(request.getParameter("rol"));
                c.setPersonal(Personal_DAO.find(Integer.parseInt(request.getParameter("personal"))));
                Set<ConstraintViolation<Usuarios>> violations = validator.validate(c);
                // enviar mensajes a jsp
                if (violations.size()>0){
                request.setAttribute("mensajes", violations);
                request.getRequestDispatcher("error.jsp").forward(request, response);
                }
                else{
                request.setAttribute("url","UsuariosController");
                Usuarios_DAO.create(c);
                request.getRequestDispatcher("success.jsp").forward(request, response);
                }
                break;
            case DELETE:
                id= request.getParameter("id");
                Usuarios_DAO.delete(Integer.parseInt(id));
                request.setAttribute("url","UsuariosController");
                request.getRequestDispatcher("success.jsp").forward(request, response);
                break;
            case UPDATE:
                c = new Usuarios();
                c.setLoginUsuario(new String(request.getParameter("loginUsuario").getBytes("ISO-8859-1"),"UTF-8"));
                c.setPasswordUsuario(new String(request.getParameter("paswordUsuario").getBytes("ISO-8859-1"),"UTF-8"));
                c.setEstadoUsuario(new String(request.getParameter("estadoUsuario").getBytes("ISO-8859-1"),"UTF-8"));
                c.setRol(request.getParameter("rol"));
                int ass = Integer.parseInt(request.getParameter("personal"));
                c.setPersonal(Personal_DAO.find(ass));
                c.setIdUsuario(Integer.parseInt(request.getParameter("idUsuario")));
                Set<ConstraintViolation<Usuarios>> violations2 = validator.validate(c);
                // enviar mensajes a jsp
                if (violations2.size()>0){
                request.setAttribute("mensajes", violations2);
                request.getRequestDispatcher("error.jsp").forward(request, response);
                }
                else{
                Usuarios_DAO.update(c);
                request.setAttribute("url","UsuariosController");
                request.getRequestDispatcher("success.jsp").forward(request, response);
                }
                break;
            case FIND:
              id= request.getParameter("id");
                id2= request.getParameter("id2");
                c = Usuarios_DAO.find(Integer.parseInt(id));       
                x = Personal_DAO.find(Integer.parseInt(id2)); 
                request.setAttribute("Usuarios",c);
                request.setAttribute("persona",x);
                request.setAttribute("Personal",Personal_DAO.findAll());
                request.getRequestDispatcher("Usuarios_edit.jsp").forward(request, response);
                break;
            case ADD:
                request.setAttribute("Personal",Personal_DAO.findAll());
                request.getRequestDispatcher("Usuarios_add.jsp").forward(request, response);
                break;
            default:
                
        }
        
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
