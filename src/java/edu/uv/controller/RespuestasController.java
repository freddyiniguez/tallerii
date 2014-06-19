package edu.uv.controller;
import edu.uv.model.dao.PreguntaDAO;
import edu.uv.model.dao.RespuestasDAO;
import edu.uv.model.pojos.Pregunta;
import edu.uv.model.pojos.Respuestas;
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

@WebServlet(name = "RespuestasController", urlPatterns = {"/RespuestasController"})
public class RespuestasController extends HttpServlet {
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
            Respuestas c = null;
            Pregunta P = new Pregunta();
            response.setContentType("text/html;charset=UTF-8");
            RespuestasDAO Respuestas_DAO = new RespuestasDAO();
            PreguntaDAO Pregunta_DAO = new PreguntaDAO();
            //crear el factory para iniciar la validacion
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();
        if (accion == null) {
            request.setAttribute("list",Respuestas_DAO.findAll());
            request.getRequestDispatcher("Respuestas_list.jsp").forward(request, response); 
        } else switch(accion){
            case INSERT:
                c = new Respuestas();
                c.setDescripcionRespuesta(new String(request.getParameter("descricionRespuesta").getBytes("ISO-8859-1"),"UTF-8"));
                
                c.setTipoResp(request.getParameter("tipoResp"));
                c.setPregunta(Pregunta_DAO.find(Integer.parseInt(request.getParameter("pregunta"))));
                Set<ConstraintViolation<Respuestas>> violations = validator.validate(c);
                // enviar mensajes a jsp
                if (violations.size()>0){
                request.setAttribute("mensajes", violations);
                request.getRequestDispatcher("error.jsp").forward(request, response);
                }
                else{
                request.setAttribute("url","RespuestasController");
                Respuestas_DAO.create(c);
                request.getRequestDispatcher("success.jsp").forward(request, response);
                }
                break;
            case DELETE:
                id= request.getParameter("id");
                Respuestas_DAO.delete(Integer.parseInt(id));
                request.setAttribute("url","RespuestasController");
                request.getRequestDispatcher("success.jsp").forward(request, response);
                break;
            case UPDATE:
                c = new Respuestas();
                c.setDescripcionRespuesta(new String(request.getParameter("descricionRespuesta").getBytes("ISO-8859-1"),"UTF-8"));
                c.setTipoResp(request.getParameter("tipoResp"));
                c.setPregunta(Pregunta_DAO.find(Integer.parseInt(request.getParameter("pregunta"))));
                c.setIdRespuesta(Integer.parseInt(request.getParameter("idRespuesta")));
                Set<ConstraintViolation<Respuestas>> violations2 = validator.validate(c);
                // enviar mensajes a jsp
                if (violations2.size()>0){
                request.setAttribute("mensajes", violations2);
                request.getRequestDispatcher("error.jsp").forward(request, response);
                }
                else{
                Respuestas_DAO.update(c);
                request.setAttribute("url","RespuestasController");
                request.getRequestDispatcher("success.jsp").forward(request, response);
                }
                break;
            case FIND:
                 id= request.getParameter("id");
                c = Respuestas_DAO.find(Integer.parseInt(id));           
                request.setAttribute("Respuestas",c);
                request.setAttribute("Pregunta",Pregunta_DAO.findAll());
                request.getRequestDispatcher("Respuestas_edit.jsp").forward(request, response);
                break;
            case ADD:
                request.setAttribute("Pregunta",Pregunta_DAO.findAll());
                request.getRequestDispatcher("Respuestas_add.jsp").forward(request, response);
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
