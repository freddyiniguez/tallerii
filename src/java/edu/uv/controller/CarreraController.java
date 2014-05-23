package edu.uv.controller;
import edu.uv.model.dao.CarreraDAO;
import edu.uv.model.pojos.Carrera;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CarreraController", urlPatterns = {"/CarreraController"})
public class CarreraController extends HttpServlet {
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
            Carrera c = null;
            response.setContentType("text/html;charset=UTF-8");
            CarreraDAO Carrera_DAO = new CarreraDAO();
        if (accion == null) {
            request.setAttribute("list",Carrera_DAO.findAll());
            request.getRequestDispatcher("Carrera_list.jsp").forward(request, response); 
        } else switch(accion){
            case INSERT:
                c = new Carrera();
                c.setNombreCarrera(request.getParameter("nombreCarrera"));
                request.setAttribute("url","CarreraController");
                Carrera_DAO.create(c);
                request.getRequestDispatcher("success.jsp").forward(request, response);
                break;
            case DELETE:
                id= request.getParameter("id");
                Carrera_DAO.delete(Integer.parseInt(id));
                request.setAttribute("url","CarreraController");
                request.getRequestDispatcher("success.jsp").forward(request, response);
                break;
            case UPDATE:
                c = new Carrera();
                c.setNombreCarrera(request.getParameter("nombreCarrera"));
                c.setIdCarrera(Integer.parseInt(request.getParameter("idCarrera")));
                Carrera_DAO.update(c);
                request.setAttribute("url","CarreraController");
                request.getRequestDispatcher("success.jsp").forward(request, response);
                break;
            case FIND:
                id= request.getParameter("id");
                c = Carrera_DAO.find(Integer.parseInt(id));                
                request.setAttribute("Carrera",c);
                request.getRequestDispatcher("Carrera_edit.jsp").forward(request, response);
            case ADD:
                //request.setAttribute("Academias",AcademiaDAO.findAll());
                request.getRequestDispatcher("Carrera_add.jsp").forward(request, response);
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