/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.uv.controller;


import edu.uv.model.dao.ExamenPreguntaDAO;
import edu.uv.model.dao.ExamenesGeneradosDAO;
import edu.uv.model.dao.PreguntaDAO;
import edu.uv.model.pojos.ExamenPregunta;
import edu.uv.model.pojos.ExamenesGenerados;
import edu.uv.model.pojos.Pregunta;
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

/**
 *
 * @author Arriaga Bellido
 */
@WebServlet(name = "ExamenPreguntaController", urlPatterns = {"/ExamenPreguntaController"})
public class ExamenPreguntaController extends HttpServlet {
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
            ExamenPregunta c = null;
            Pregunta P = new Pregunta();
            ExamenesGenerados E = new ExamenesGenerados();
            response.setContentType("text/html;charset=UTF-8");
            ExamenPreguntaDAO ExamenPregunta_DAO = new ExamenPreguntaDAO();
            PreguntaDAO Pregunta_DAO = new PreguntaDAO();
            ExamenesGeneradosDAO ExamenesGenerados_DAO = new ExamenesGeneradosDAO();
            //crear el factory para iniciar la validacion
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();
        if (accion == null) {
            request.setAttribute("list",ExamenPregunta_DAO.findAll());
            request.getRequestDispatcher("ExamenPregunta_list.jsp").forward(request, response); 
        } else switch(accion){
            case INSERT:
                c = new ExamenPregunta();
                c.setExamenesGenerados(ExamenesGenerados_DAO.find(Integer.parseInt(request.getParameter("tipoExa"))));
                c.setPregunta(Pregunta_DAO.find(Integer.parseInt(request.getParameter("pregunta"))));
                c.setPuntaje(Integer.parseInt(request.getParameter("puntaje")));
                Set<ConstraintViolation<ExamenPregunta>> violations = validator.validate(c);
                // enviar mensajes a jsp
                if (violations.size()>0){
                request.setAttribute("mensajes", violations);
                request.getRequestDispatcher("error.jsp").forward(request, response);
                }
                else{
                request.setAttribute("url","ExamenPreguntaController");
                ExamenPregunta_DAO.create(c);
                request.getRequestDispatcher("success.jsp").forward(request, response);
                }
                break;
            case DELETE:
                id= request.getParameter("id");
                ExamenPregunta_DAO.delete(Integer.parseInt(id));
                request.setAttribute("url","ExamenPreguntaController");
                request.getRequestDispatcher("success.jsp").forward(request, response);
                break;
            case UPDATE:
                c = new ExamenPregunta();
                c.setExamenesGenerados(ExamenesGenerados_DAO.find(Integer.parseInt(request.getParameter("tipoExa"))));
                c.setPregunta(Pregunta_DAO.find(Integer.parseInt(request.getParameter("pregunta"))));
                c.setPuntaje(Integer.parseInt(request.getParameter("puntaje")));
                c.setIdExamenPregunta(Integer.parseInt(request.getParameter("idExamenPregunta")));
                Set<ConstraintViolation<ExamenPregunta>> violations2 = validator.validate(c);
                // enviar mensajes a jsp
                if (violations2.size()>0){
                request.setAttribute("mensajes", violations2);
                request.getRequestDispatcher("error.jsp").forward(request, response);
                }
                else{
                ExamenPregunta_DAO.update(c);
                request.setAttribute("url","ExamenPreguntaController");
                request.getRequestDispatcher("success.jsp").forward(request, response);
                }
                break;
            case FIND:
                id= request.getParameter("id");
                c = ExamenPregunta_DAO.find(Integer.parseInt(id));           
                request.setAttribute("ExamenPregunta",c);
                request.setAttribute("ExamenesGenerados",ExamenesGenerados_DAO.findAll());
                request.setAttribute("Pregunta",Pregunta_DAO.findAll());
                request.getRequestDispatcher("ExamenPregunta_edit.jsp").forward(request, response);
                break;
            case ADD:
                request.setAttribute("ExamenesGenerados",ExamenesGenerados_DAO.findAll());
                request.setAttribute("Pregunta",Pregunta_DAO.findAll());
                request.getRequestDispatcher("Pregunta_add.jsp").forward(request, response);
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
