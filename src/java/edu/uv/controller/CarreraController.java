package edu.uv.controller;
import edu.uv.model.dao.CarreraDAO;
import edu.uv.model.pojos.Carrera;
import edu.uv.model.pojos.CarreraAcademia;
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
            //validar que el usuario tenga la sesion iniciada
            HttpSession session = request.getSession(true);
            
            if ((session.getAttribute("user") == null)) {
            request.getRequestDispatcher("login_.jsp").forward(request, response);
            return;
            } 
            
            if (!session.getAttribute("rol").equals("Administrador")) {
            request.getRequestDispatcher("index.jsp").forward(request, response);
            return;
            }
            
            String accion = request.getParameter("accion");
            String id ="";
            Carrera c = null;
            response.setContentType("text/html;charset=UTF-8");
            CarreraDAO Carrera_DAO = new CarreraDAO();
             //crear el factory para iniciar la validacion
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();
            
        if (accion == null) {
            request.setAttribute("list",Carrera_DAO.findAll());
            request.getRequestDispatcher("Carrera_list.jsp").forward(request, response); 
        } else switch(accion){
            case INSERT:
                c = new Carrera();
                c.setNombreCarrera(new String(request.getParameter("nombreCarrera").getBytes("ISO-8859-1"),"UTF-8"));
                         
                Set<ConstraintViolation<Carrera>> violations = validator.validate(c);
                // enviar mensajes a jsp
                if (violations.size()>0){
                request.setAttribute("mensajes", violations);
                request.getRequestDispatcher("error.jsp").forward(request, response);
                }
                else{
                request.setAttribute("url","CarreraController");
                Carrera_DAO.create(c);
                request.getRequestDispatcher("success.jsp").forward(request, response);
                }
                break;
            case DELETE:
                id= request.getParameter("id");
                Carrera_DAO.delete(Integer.parseInt(id));
                request.setAttribute("url","CarreraController");
                request.getRequestDispatcher("success.jsp").forward(request, response);
                break;
            case UPDATE:
                c = new Carrera();
                c.setNombreCarrera(new String(request.getParameter("nombreCarrera").getBytes("ISO-8859-1"),"UTF-8"));
                c.setIdCarrera(Integer.parseInt(request.getParameter("idCarrera")));
                Set<ConstraintViolation<Carrera>> violations2 = validator.validate(c);
                // enviar mensajes a jsp
                if (violations2.size()>0){
                request.setAttribute("mensajes", violations2);
                request.getRequestDispatcher("error.jsp").forward(request, response);
                }
                else{
                Carrera_DAO.update(c);
                request.setAttribute("url","CarreraController");
                request.getRequestDispatcher("success.jsp").forward(request, response);
                }
                break;
            case FIND:
                id= request.getParameter("id");
                c = Carrera_DAO.find(Integer.parseInt(id));                
                request.setAttribute("Carrera",c);
                request.getRequestDispatcher("Carrera_edit.jsp").forward(request, response);
                break;
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