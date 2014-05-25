package edu.uv.controller;
import edu.uv.model.dao.AcademiaDAO;
import edu.uv.model.dao.PersonalDAO;
import edu.uv.model.pojos.Academia;
import edu.uv.model.pojos.Personal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AcademiaController", urlPatterns = {"/AcademiaController"})
public class AcademiaController extends HttpServlet {
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
            Academia c = null;
            Personal P = new Personal();
            response.setContentType("text/html;charset=UTF-8");
            AcademiaDAO Academia_DAO = new AcademiaDAO();
            PersonalDAO Personal_DAO = new PersonalDAO();
        if (accion == null) {
            request.setAttribute("list",Academia_DAO.findAll());
            request.getRequestDispatcher("Academia_list.jsp").forward(request, response); 
        } else switch(accion){
            case INSERT:
                c = new Academia();
                c.setNombreAcademia(request.getParameter("nombreAcademia"));
                c.setPersonal(Personal_DAO.find(Integer.parseInt(request.getParameter("personal"))));
                request.setAttribute("url","AcademiaController");
                Academia_DAO.create(c);
                request.getRequestDispatcher("success.jsp").forward(request, response);
                break;
            case DELETE:
                id= request.getParameter("id");
                Academia_DAO.delete(Integer.parseInt(id));
                request.setAttribute("url","AcademiaController");
                request.getRequestDispatcher("success.jsp").forward(request, response);
                break;
            case UPDATE:
                c = new Academia();
                c.setNombreAcademia(request.getParameter("nombreAcademia"));
                c.setPersonal(Personal_DAO.find(Integer.parseInt(request.getParameter("personal"))));
                c.setIdAcademia(Integer.parseInt(request.getParameter("idAcademia")));
                Academia_DAO.update(c);
                request.setAttribute("url","AcademiaController");
                request.getRequestDispatcher("success.jsp").forward(request, response);
                break;
            case FIND:
                id= request.getParameter("id");
                c = Academia_DAO.find(Integer.parseInt(id));           
                request.setAttribute("Academia",c);
                request.setAttribute("Personal",Personal_DAO.findAll());
                request.getRequestDispatcher("Academia_edit.jsp").forward(request, response);
            case ADD:
                request.setAttribute("Personal",Personal_DAO.findAll());
                request.getRequestDispatcher("Academia_add.jsp").forward(request, response);
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