package edu.uv.controller;
import edu.uv.model.dao.RolesDAO;
import edu.uv.model.pojos.Roles;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "RolesController", urlPatterns = {"/RolesController"})
public class RolesController extends HttpServlet {
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
            Roles c = null;
            
            response.setContentType("text/html;charset=UTF-8");
            RolesDAO Roles_DAO = new RolesDAO();
            
        if (accion == null) {
            request.setAttribute("list",Roles_DAO.findAll());
            request.getRequestDispatcher("Roles_list.jsp").forward(request, response); 
        } else switch(accion){
            case INSERT:
                c = new Roles();
                c.setNombreRol(request.getParameter("nombreRol"));
                c.setDescripcionRol(request.getParameter("descripcionRol"));
                request.setAttribute("url","RolesController");
                Roles_DAO.create(c);
                request.getRequestDispatcher("success.jsp").forward(request, response);
                break;
            case DELETE:
                id= request.getParameter("id");
                Roles_DAO.delete(Integer.parseInt(id));
                request.setAttribute("url","RolesController");
                request.getRequestDispatcher("success.jsp").forward(request, response);
                break;
            case UPDATE:
                c = new Roles();
                c.setNombreRol(request.getParameter("nombreRol"));
                c.setDescripcionRol(request.getParameter("descripcionRol"));
                c.setIdRol(Integer.parseInt(request.getParameter("idRol")));
                Roles_DAO.update(c);
                request.setAttribute("url","RolesController");
                request.getRequestDispatcher("success.jsp").forward(request, response);
                break;
            case FIND:
                id= request.getParameter("id");
                c = Roles_DAO.find(Integer.parseInt(id));           
                request.setAttribute("Roles",c);
                
                request.getRequestDispatcher("Roles_edit.jsp").forward(request, response);
            case ADD:
                
                request.getRequestDispatcher("Roles_add.jsp").forward(request, response);
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
