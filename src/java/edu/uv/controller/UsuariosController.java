package edu.uv.controller;
import edu.uv.model.dao.PersonalDAO;
import edu.uv.model.dao.UsuariosDAO;
import edu.uv.model.pojos.Personal;
import edu.uv.model.pojos.Usuarios;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
            String accion = request.getParameter("accion");
            String id ="";
            Usuarios c = null;
            Personal P = new Personal();
            response.setContentType("text/html;charset=UTF-8");
            UsuariosDAO Usuarios_DAO = new UsuariosDAO();
            PersonalDAO Personal_DAO = new PersonalDAO();
        if (accion == null) {
            request.setAttribute("list",Usuarios_DAO.findAll());
            request.getRequestDispatcher("Usuarios_list.jsp").forward(request, response); 
        } else switch(accion){
            case INSERT:
                c = new Usuarios();
                c.setLoginUsuario(request.getParameter("loginUsuario"));
                c.setPasswordUsuario(request.getParameter("passwordUsuario"));
                c.setEstadoUsuario(request.getParameter("estadoUsuario"));
                c.setPersonal(Personal_DAO.find(Integer.parseInt(request.getParameter("personal"))));
                request.setAttribute("url","UsuariosController");
                Usuarios_DAO.create(c);
                request.getRequestDispatcher("success.jsp").forward(request, response);
                break;
            case DELETE:
                id= request.getParameter("id");
                Usuarios_DAO.delete(Integer.parseInt(id));
                request.setAttribute("url","UsuariosController");
                request.getRequestDispatcher("success.jsp").forward(request, response);
                break;
            case UPDATE:
                c = new Usuarios();
                c.setLoginUsuario(request.getParameter("loginUsuario"));
                c.setPasswordUsuario(request.getParameter("passwordUsuario"));
                c.setEstadoUsuario(request.getParameter("estadoUsuario"));
                int ass = Integer.parseInt(request.getParameter("personal"));
                c.setPersonal(Personal_DAO.find(ass));
                c.setIdUsuario(Integer.parseInt(request.getParameter("idUsuario")));
                Usuarios_DAO.update(c);
                request.setAttribute("url","UsuariosController");
                request.getRequestDispatcher("success.jsp").forward(request, response);
                break;
            case FIND:
                id= request.getParameter("id");
                c = Usuarios_DAO.find(Integer.parseInt(id));           
                request.setAttribute("Usuarios",c);
                request.setAttribute("Personal",Personal_DAO.findAll());
                request.getRequestDispatcher("Usuarios_edit.jsp").forward(request, response);
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
