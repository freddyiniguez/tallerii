package edu.uv.controller;
import edu.uv.model.dao.CarreraAcademiaDAO;
import edu.uv.model.dao.CarreraDAO;
import edu.uv.model.dao.AcademiaDAO;

import edu.uv.model.pojos.Academia;
import edu.uv.model.pojos.Carrera;
import edu.uv.model.pojos.CarreraAcademia;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "CarreraAcademiaController", urlPatterns = {"/CarreraAcademiaController"})
public class CarreraAcademiaController extends HttpServlet {
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
            CarreraAcademia c = null;
            Carrera C = new Carrera();
            Academia A = new Academia();
            response.setContentType("text/html;charset=UTF-8");
            CarreraAcademiaDAO CarreraAcademia_DAO = new CarreraAcademiaDAO();
            CarreraDAO Carrera_DAO = new CarreraDAO();
            AcademiaDAO Academia_DAO = new AcademiaDAO();
            
        if (accion == null) {
            request.setAttribute("list",CarreraAcademia_DAO.findAll());
            request.getRequestDispatcher("CarreraAcademia_list.jsp").forward(request, response); 
        } else switch(accion){
            case INSERT:
                c = new CarreraAcademia();
                c.setCarrera(Carrera_DAO.find(Integer.parseInt(request.getParameter("carrera"))));
                c.setAcademia(Academia_DAO.find(Integer.parseInt(request.getParameter("academia"))));
                request.setAttribute("url","CarreraAcademiaController");
                CarreraAcademia_DAO.create(c);
                request.getRequestDispatcher("success.jsp").forward(request, response);
                break;
            case DELETE:
                id= request.getParameter("id");
                CarreraAcademia_DAO.delete(Integer.parseInt(id));
                request.setAttribute("url","CarreraAcademiaController");
                request.getRequestDispatcher("success.jsp").forward(request, response);
                break;
            case UPDATE:
                c = new CarreraAcademia();
                c = new CarreraAcademia();
                c.setCarrera(Carrera_DAO.find(Integer.parseInt(request.getParameter("carrera"))));
                c.setAcademia(Academia_DAO.find(Integer.parseInt(request.getParameter("academia"))));
                c.setIdCarreraAcademia(Integer.parseInt(request.getParameter("idCarreraAcademia")));
                CarreraAcademia_DAO.update(c);
                request.setAttribute("url","CarreraAcademiaController");
                request.getRequestDispatcher("success.jsp").forward(request, response);
                break;
            case FIND:
                id= request.getParameter("id");
                c = CarreraAcademia_DAO.find(Integer.parseInt(id));           
                request.setAttribute("CarreraAcademia",c);
                request.setAttribute("Carrera",Carrera_DAO.findAll());
                request.setAttribute("Academia",Academia_DAO.findAll());
                request.getRequestDispatcher("CarreraAcademia_edit.jsp").forward(request, response);
                break;
            case ADD:
                request.setAttribute("Carrera",Carrera_DAO.findAll());
                request.setAttribute("Academia",Academia_DAO.findAll());
                request.getRequestDispatcher("CarreraAcademia_add.jsp").forward(request, response);
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
