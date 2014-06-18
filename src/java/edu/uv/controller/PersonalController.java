package edu.uv.controller;

import edu.uv.model.dao.AcademiaDAO;
import edu.uv.model.dao.PersonalDAO;
import edu.uv.model.pojos.Academia;
import edu.uv.model.pojos.Personal;
import java.io.IOException;
import java.util.List;
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
             //crear el factory para iniciar la validacion
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();
            
        if (accion == null) {
            request.setAttribute("list",Personal_DAO.findAll());
            request.getRequestDispatcher("Personal_list.jsp").forward(request, response); 
        } else switch(accion){
            case INSERT:
                c = new Personal();
                c.setNombreProfesor(new String(request.getParameter("nombreProfesor").getBytes("ISO-8859-1"),"UTF-8"));
                 Set<ConstraintViolation<Personal>> violations = validator.validate(c);
                // enviar mensajes a jsp
                if (violations.size()>0){
                request.setAttribute("mensajes", violations);
                 if(request.getParameter("nombreProfesor").equals("") ){
                    request.setAttribute("campos", "NOMBRE"); 
                    request.setAttribute("tipo", "INCOMPLETO");
                }else{
                     if(request.getParameter("nombreProfesor").length()<=4 && request.getParameter("nombreAcademia").length()!=0){
                        request.setAttribute("tipo", "TAMAÑO MINIMO");
                        request.setAttribute("campos", "NOMBRE");
                    }
                }
                request.getRequestDispatcher("error.jsp").forward(request, response);
                }
                else{
                request.setAttribute("url","PersonalController");
                Personal_DAO.create(c);
                request.getRequestDispatcher("success.jsp").forward(request, response);
                }
                break;
            case DELETE:
                id= request.getParameter("id");   
                if(!encontrado(id)){
                      request.setAttribute("tipo", "EDITA PRIMERO AL COORDINADOR");
                      request.setAttribute("campos", "COORDINADOR");
                      request.setAttribute("url","PersonalController");
                      request.getRequestDispatcher("error.jsp").forward(request, response);
                }else{
                    Personal_DAO.delete(Integer.parseInt(id));
                    request.setAttribute("url","PersonalController");
                    request.getRequestDispatcher("success.jsp").forward(request, response);   
                }
                break;
            case UPDATE:
                c = new Personal();
                c.setNombreProfesor(new String(request.getParameter("nombreProfesor").getBytes("ISO-8859-1"),"UTF-8"));
                c.setIdPersonal(Integer.parseInt(request.getParameter("idPersonal")));
                 Set<ConstraintViolation<Personal>> violations2 = validator.validate(c);
                // enviar mensajes a jsp
                if (violations2.size()>0){
                request.setAttribute("mensajes", violations2);
                request.getRequestDispatcher("error.jsp").forward(request, response);
                }
                else{
                Personal_DAO.update(c);
                request.setAttribute("url","PersonalController");
                request.getRequestDispatcher("success.jsp").forward(request, response);
                }
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
                ;
        }  
 }

   public boolean encontrado(String id){
        boolean res=true;
        AcademiaDAO Academia_DAO = new AcademiaDAO();
        List <Academia> academias = Academia_DAO.findAll();
        for(Academia aux:academias){
            if(aux.getPersonal()!=null){
                if(aux.getPersonal().getIdPersonal().equals(Integer.parseInt(id))){
                    res= false;
                }
            }
        }
        return res;
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