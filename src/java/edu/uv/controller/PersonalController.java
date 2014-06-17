package edu.uv.controller;

import edu.uv.model.dao.PersonalDAO;
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

/**
 * Clase PersonalController
 * @see HttpServlet
 * @author Freddy
 */
@WebServlet(name = "PersonalController", urlPatterns = {"/PersonalController"})
public class PersonalController extends HttpServlet {
    static final String LIST = "";
    static final String DELETE = "borrar";
    static final String FIND = "buscar";
    static final String ADD = "agregar";
    static final String UPDATE = "actualizar";
    static final String INSERT = "insertar";
    String id = "";
    Personal c = null;

    /**
     * Método encargado de manejar los eventos para actualizar el catálogo personal
     * @see ServletException
     * @see IOException
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Verifica que el usuario haya iniciado sesión.
        // En caso de que no lo haya hecho, lo manda a la página de login.
        HttpSession session = request.getSession(true);

        if ((session.getAttribute("user") == null)) {
            request.getRequestDispatcher("login_.jsp").forward(request, response);
            return;
        }
        String accion = request.getParameter("accion");

        response.setContentType("text/html;charset=UTF-8");
        PersonalDAO Personal_DAO = new PersonalDAO();
        // Crea el factory para iniciar la validación.
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        if (accion == null) {
            request.setAttribute("list", Personal_DAO.findAll());
            request.getRequestDispatcher("Personal_list.jsp").forward(request, response);
        } else {
            switch (accion) {
                case INSERT:
                    c = new Personal(); 
                    c.setNombreProfesor(new String(request.getParameter("nombreProfesor").getBytes("ISO-8859-1"),"UTF-8"));
                    //c.setNombreProfesor(request.getParameter("nombreProfesor"));
                    Set<ConstraintViolation<Personal>> violations = validator.validate(c);
                    // Enviar mensajes a jsp
                    if (violations.size() > 0) {
                        request.setAttribute("mensajes", violations);
                        request.getRequestDispatcher("error.jsp").forward(request, response);
                    } else {
                        request.setAttribute("url", "PersonalController");
                        Personal_DAO.create(c);
                        request.getRequestDispatcher("success.jsp").forward(request, response);
                    }
                    break;
                case DELETE:
                    id = request.getParameter("id");
                    Personal_DAO.delete(Integer.parseInt(id));
                    request.setAttribute("url", "PersonalController");
                    request.getRequestDispatcher("success.jsp").forward(request, response);
                    break;
                case UPDATE:
                    c = new Personal();
                    c.setNombreProfesor(request.getParameter("nombreProfesor"));
                    c.setIdPersonal(Integer.parseInt(request.getParameter("idPersonal")));
                    Set<ConstraintViolation<Personal>> violations2 = validator.validate(c);
                    // enviar mensajes a jsp
                    if (violations2.size() > 0) {
                        request.setAttribute("mensajes", violations2);
                        request.getRequestDispatcher("error.jsp").forward(request, response);
                    } else {
                        Personal_DAO.update(c);
                        request.setAttribute("url", "PersonalController");
                        request.getRequestDispatcher("success.jsp").forward(request, response);
                    }
                    break;
                case FIND:
                    id = request.getParameter("id");
                    c = Personal_DAO.find(Integer.parseInt(id));
                    request.setAttribute("Personal", c);
                    request.getRequestDispatcher("Personal_edit.jsp").forward(request, response);
                    break;
                case ADD:
                    request.getRequestDispatcher("Personal_add.jsp").forward(request, response);
                    break;
                default:
                ;
            }
        }
    }
}
