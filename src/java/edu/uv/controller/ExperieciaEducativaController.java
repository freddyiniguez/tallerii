package edu.uv.controller;
import edu.uv.model.dao.AcademiaDAO;
import edu.uv.model.dao.ExperieciaEducativaDAO;
import edu.uv.model.dao.ImparteDAO;
import edu.uv.model.pojos.Academia;
import edu.uv.model.pojos.ExperieciaEducativa;
import edu.uv.model.pojos.Imparte;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
            ExperieciaEducativa c = null;
            Academia A = new Academia();
            response.setContentType("text/html;charset=UTF-8");
            ExperieciaEducativaDAO ExperieciaEducativa_DAO = new ExperieciaEducativaDAO();
            AcademiaDAO Academia_DAO = new AcademiaDAO();
            //crear el factory para iniciar la validacion
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();
        if (accion == null) {
            request.setAttribute("list",ExperieciaEducativa_DAO.findAll());
            List<ExperieciaEducativa> mats =buscarMaterias(-50,0);
                    request.removeAttribute("matslist");
                    request.setAttribute("matslist", mats); 
                    request.removeAttribute("list");
                    request.setAttribute("list",mats);
            request.getRequestDispatcher("ExperieciaEducativa_list.jsp").forward(request, response); 
        } else switch(accion){
            case INSERT:
                c = new ExperieciaEducativa();
                c.setNombreEe(new String(request.getParameter("nombreEE").getBytes("ISO-8859-1"),"UTF-8"));
                A = Academia_DAO.find(Integer.parseInt(request.getParameter("academia")));
                c.setAcademia(A);
                //c.setNombreEe(request.getParameter("nombreEE"));
                request.setAttribute("url","ExperieciaEducativaController");
                Set<ConstraintViolation<ExperieciaEducativa>> violations = validator.validate(c);
                // enviar mensajes a jsp
                if (violations.size()>0){
                request.setAttribute("mensajes", violations);
                request.getRequestDispatcher("error.jsp").forward(request, response);
                }
                else{
                    ExperieciaEducativa_DAO.create(c);
                    
                    List<ExperieciaEducativa> mats =buscarMaterias(-50,0);
                    request.removeAttribute("matslist");
                    request.setAttribute("matslist", mats); 
                    
                    /*if(request.getAttribute("rol").equals("Coordinador")){
                        List<ExperieciaEducativa> mats =buscarMateriasAcademia((Integer)session.getAttribute("idpersonal"));
                        request.setAttribute("matslist", mats);   
                    }else{
                        if (request.getAttribute("rol").equals("Administrador")) {
                             List<ExperieciaEducativa> mats =buscarMaterias(-50,0);
                             request.setAttribute("matslist", mats);   
                        }
                    }*/
                    request.getRequestDispatcher("success.jsp").forward(request, response);
                }
                
                break;
            case DELETE:
                id= request.getParameter("id");
                ExperieciaEducativa_DAO.delete(Integer.parseInt(id));
                /*if(session.getAttribute("rol").equals("Coordinador")){
                    List<ExperieciaEducativa> mats =buscarMateriasAcademia((Integer)session.getAttribute("idpersonal"));
                    request.setAttribute("matslist", mats);   
                }else{
                    if (session.getAttribute("rol").equals("Administrador")) {
                         List<ExperieciaEducativa> mats =buscarMaterias(-50,0);
                         request.setAttribute("matslist", mats);   
                    }
                }*/
                request.setAttribute("url","ExperieciaEducativaController");
                request.getRequestDispatcher("success.jsp").forward(request, response);
                break;
            case UPDATE:
                c = new ExperieciaEducativa();
                A = Academia_DAO.find(Integer.parseInt(request.getParameter("academia")));
                c.setAcademia(A);
                c.setNombreEe(new String(request.getParameter("nombreEE").getBytes("ISO-8859-1"),"UTF-8"));
                c.setIdExperieciaEducativa(Integer.parseInt(request.getParameter("idExperieciaEducativa")));
                
                Set<ConstraintViolation<ExperieciaEducativa>> violations2 = validator.validate(c);
                // enviar mensajes a jsp
                if (violations2.size()>0){
                request.setAttribute("mensajes", violations2);
                request.getRequestDispatcher("error.jsp").forward(request, response);
                }
                else{
                ExperieciaEducativa_DAO.update(c);
                 if(session.getAttribute("rol").equals("Coordinador")){
                        List<ExperieciaEducativa> mats =buscarMateriasAcademia((Integer)session.getAttribute("idpersonal"));
                        request.setAttribute("matslist", mats);   
                    }else{
                        if (session.getAttribute("rol").equals("Administrador")) {
                             List<ExperieciaEducativa> mats =buscarMaterias(-50,0);
                             request.setAttribute("matslist", mats);   
                        }
                    }
                request.setAttribute("url","ExperieciaEducativaController");
                request.getRequestDispatcher("success.jsp").forward(request, response);
                }
                
                break;
            case FIND:
                id= request.getParameter("id");
                c = ExperieciaEducativa_DAO.find(Integer.parseInt(id));           
                request.setAttribute("ExperieciaEducativa",c);
                request.setAttribute("Academia",Academia_DAO.findAll());
                request.getRequestDispatcher("ExperieciaEducativa_edit.jsp").forward(request, response);
               break;
            case ADD:
                request.setAttribute("Academia",Academia_DAO.findAll());
                request.getRequestDispatcher("ExperieciaEducativa_add.jsp").forward(request, response);
                break;
            default:
                
        }
        
 }

 protected List buscarMateriasAcademia(int idPersonal){
        AcademiaDAO acaDao = new AcademiaDAO(); 
        List<Academia> academias = acaDao.findAll();
        List <Academia> pertenece = new ArrayList();
        ExperieciaEducativaDAO expe = new ExperieciaEducativaDAO();
        List <ExperieciaEducativa> experiencias = expe.findAll();
        List <ExperieciaEducativa> resultado = new ArrayList();
        
        for(Academia aux:academias){
            if(aux.getPersonal()!=null)
            if(aux.getPersonal().getIdPersonal().equals(idPersonal)){
                pertenece.add(aux);
            }
        }
        for(ExperieciaEducativa aux:experiencias){
            for(Academia auy:pertenece){
                if(aux.getAcademia().getIdAcademia().equals(auy.getIdAcademia())){
                    resultado.add(aux);
                }
            }
        }
        return resultado;
    }
     
 
 protected List buscarMaterias(int idPersonal, int modo){
        ImparteDAO im=new ImparteDAO();
        ExperieciaEducativaDAO expDAO=new ExperieciaEducativaDAO();
        List<ExperieciaEducativa> ExpsAll=expDAO.findAll();
        List<Imparte>imparteAll=im.findAll();
        List<ExperieciaEducativa> mats=new ArrayList();
        if (modo==0) {
            //mats=matsAll;
            mats=expDAO.findAll();
        }else{
        for (Imparte imp:imparteAll) {
            if(imp.getPersonal()!=null)
            if (imp.getPersonal().getIdPersonal().equals(idPersonal)) {
                
                for (ExperieciaEducativa e1:ExpsAll) {
                    if (e1.getIdExperieciaEducativa().equals(imp.getExperieciaEducativa().getIdExperieciaEducativa())) {
                        mats.add(e1);
                    }
                }
//mats.add(imp);
            }
        }
        }
        
        return mats;
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
