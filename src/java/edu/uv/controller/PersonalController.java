package edu.uv.controller;
import edu.uv.model.dao.PersonalDAO;
import edu.uv.model.pojos.Personal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "PersonalController", urlPatterns = {"/PersonalController"})
public class PersonalController extends HttpServlet {
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
            Personal c = null;
            
            response.setContentType("text/html;charset=UTF-8");
            PersonalDAO Personal_DAO = new PersonalDAO();
            
        if (accion == null) {
            request.setAttribute("list",Personal_DAO.findAll());
            request.getRequestDispatcher("Personal_list.jsp").forward(request, response); 
        } else switch(accion){
            case INSERT:
                c = new Personal();
                c.setNumeroPersonal(Integer.parseInt(request.getParameter("numeroPersonal")));
                c.setNombreProfesor(request.getParameter("nombreProfesor"));
                request.setAttribute("url","PersonalController");
                Personal_DAO.create(c);
                request.getRequestDispatcher("success.jsp").forward(request, response);
                break;
            case DELETE:
                id= request.getParameter("id");
                Personal_DAO.delete(Integer.parseInt(id));
                request.setAttribute("url","PersonalController");
                request.getRequestDispatcher("success.jsp").forward(request, response);
                break;
            case UPDATE:
                c = new Personal();
                c.setNumeroPersonal(Integer.parseInt(request.getParameter("numeroPersonal")));
                c.setNombreProfesor(request.getParameter("nombreProfesor"));
                c.setIdPersonal(Integer.parseInt(request.getParameter("idPersonal")));
                Personal_DAO.update(c);
                request.setAttribute("url","PersonalController");
                request.getRequestDispatcher("success.jsp").forward(request, response);
                break;
            case FIND:
                id= request.getParameter("id");
                c = Personal_DAO.find(Integer.parseInt(id));           
                request.setAttribute("Personal",c);
                
                request.getRequestDispatcher("Personal_edit.jsp").forward(request, response);
                break;
            case ADD:
                
                request.getRequestDispatcher("Personal_add.jsp").forward(request, response);
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
