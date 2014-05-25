package edu.uv.controller;
import edu.uv.model.dao.AcademiaDAO;
import edu.uv.model.dao.ExperieciaEducativaDAO;
import edu.uv.model.pojos.Academia;
import edu.uv.model.pojos.ExperieciaEducativa;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ExperieciaEducativaController", urlPatterns = {"/ExperieciaEducativaController"})
public class ExperieciaEducativaController extends HttpServlet {
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
            ExperieciaEducativa c = null;
            Academia A = new Academia();
            response.setContentType("text/html;charset=UTF-8");
            ExperieciaEducativaDAO ExperieciaEducativa_DAO = new ExperieciaEducativaDAO();
            AcademiaDAO Academia_DAO = new AcademiaDAO();
        if (accion == null) {
            request.setAttribute("list",ExperieciaEducativa_DAO.findAll());
            request.getRequestDispatcher("ExperieciaEducativa_list.jsp").forward(request, response); 
        } else switch(accion){
            case INSERT:
                c = new ExperieciaEducativa();
                A = Academia_DAO.find(Integer.parseInt(request.getParameter("academia")));
                c.setAcademia(A);
                c.setNombreEe(request.getParameter("nombreEE"));
                request.setAttribute("url","ExperieciaEducativaController");
                ExperieciaEducativa_DAO.create(c);
                request.getRequestDispatcher("success.jsp").forward(request, response);
                break;
            case DELETE:
                id= request.getParameter("id");
                ExperieciaEducativa_DAO.delete(Integer.parseInt(id));
                request.setAttribute("url","ExperieciaEducativaController");
                request.getRequestDispatcher("success.jsp").forward(request, response);
                break;
            case UPDATE:
                c = new ExperieciaEducativa();
                A = Academia_DAO.find(Integer.parseInt(request.getParameter("academia")));
                c.setAcademia(A);
                c.setNombreEe(request.getParameter("nombreEE"));
                c.setIdExperieciaEducativa(Integer.parseInt(request.getParameter("idExperieciaEducativa")));
                ExperieciaEducativa_DAO.update(c);
                request.setAttribute("url","ExperieciaEducativaController");
                request.getRequestDispatcher("success.jsp").forward(request, response);
                break;
            case FIND:
                id= request.getParameter("id");
                c = ExperieciaEducativa_DAO.find(Integer.parseInt(id));           
                request.setAttribute("ExperieciaEducativa",c);
                request.setAttribute("Academia",Academia_DAO.findAll());
                request.getRequestDispatcher("ExperieciaEducativa_edit.jsp").forward(request, response);
            case ADD:
                request.setAttribute("Academia",Academia_DAO.findAll());
                request.getRequestDispatcher("ExperieciaEducativa_add.jsp").forward(request, response);
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