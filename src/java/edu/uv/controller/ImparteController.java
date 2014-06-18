package edu.uv.controller;
import edu.uv.model.dao.ExperieciaEducativaDAO;
import edu.uv.model.dao.ImparteDAO;
import edu.uv.model.dao.PersonalDAO;
import edu.uv.model.pojos.ExperieciaEducativa;
import edu.uv.model.pojos.Imparte;
import edu.uv.model.pojos.Personal;
import java.io.IOException;
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

@WebServlet(name = "ImparteController", urlPatterns = {"/ImparteController"})
public class ImparteController extends HttpServlet {
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
            Imparte c = null;
            ExperieciaEducativa E = new ExperieciaEducativa();
            Personal P = new Personal();
            response.setContentType("text/html;charset=UTF-8");
            ImparteDAO Imparte_DAO = new ImparteDAO();
            ExperieciaEducativaDAO ExperieciaEducativa_DAO = new ExperieciaEducativaDAO();
            PersonalDAO Personal_DAO = new PersonalDAO();
            //crear el factory para iniciar la validacion
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();
        if (accion == null) {
            request.setAttribute("list",Imparte_DAO.findAll());
            request.getRequestDispatcher("Imparte_list.jsp").forward(request, response); 
        } else switch(accion){
            case INSERT:
                c = new Imparte();
                c.setExperieciaEducativa(ExperieciaEducativa_DAO.find(Integer.parseInt(request.getParameter("Ee"))));
                c.setPersonal(Personal_DAO.find(Integer.parseInt(request.getParameter("personal"))));
                Set<ConstraintViolation<Imparte>> violations = validator.validate(c);
                // enviar mensajes a jsp
                if (violations.size()>0){
                request.setAttribute("mensajes", violations);
                request.getRequestDispatcher("error.jsp").forward(request, response);
                }
                else{
                request.setAttribute("url","ImparteController");
                Imparte_DAO.create(c);
                request.getRequestDispatcher("success.jsp").forward(request, response);
                }
                break;
            case DELETE:
                id= request.getParameter("id");
                Imparte_DAO.delete(Integer.parseInt(id));
                request.setAttribute("url","ImparteController");
                request.getRequestDispatcher("success.jsp").forward(request, response);
                break;
            case UPDATE:
                c = new Imparte();
                c.setExperieciaEducativa(ExperieciaEducativa_DAO.find(Integer.parseInt(request.getParameter("Ee"))));
                c.setPersonal(Personal_DAO.find(Integer.parseInt(request.getParameter("personal"))));
                c.setIdImparte(Integer.parseInt(request.getParameter("idImparte")));
                Set<ConstraintViolation<Imparte>> violations2 = validator.validate(c);
                // enviar mensajes a jsp
                if (violations2.size()>0){
                request.setAttribute("mensajes", violations2);
                request.getRequestDispatcher("error.jsp").forward(request, response);
                }
                else{
                Imparte_DAO.update(c);
                request.setAttribute("url","ImparteController");
                request.getRequestDispatcher("success.jsp").forward(request, response);
                }
                break;
            case FIND:
                id= request.getParameter("id");
                c = Imparte_DAO.find(Integer.parseInt(id));           
                request.setAttribute("Imparte",c);
                request.setAttribute("ExperieciaEducativa",ExperieciaEducativa_DAO.findAll());
                request.setAttribute("Personal",Personal_DAO.findAll());
                request.getRequestDispatcher("Imparte_edit.jsp").forward(request, response);
                break;
            case ADD:
                request.setAttribute("ExperieciaEducativa",ExperieciaEducativa_DAO.findAll());
                request.setAttribute("Personal",Personal_DAO.findAll());
                request.getRequestDispatcher("Imparte_add.jsp").forward(request, response);
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
