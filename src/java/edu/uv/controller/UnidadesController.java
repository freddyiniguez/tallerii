package edu.uv.controller;
import edu.uv.model.dao.AcademiaDAO;
import edu.uv.model.dao.ExperieciaEducativaDAO;
import edu.uv.model.dao.ImparteDAO;
import edu.uv.model.dao.UnidadesDAO;
import edu.uv.model.pojos.Academia;
import edu.uv.model.pojos.ExperieciaEducativa;
import edu.uv.model.pojos.Imparte;
import edu.uv.model.pojos.Temas;
import edu.uv.model.pojos.Unidades;
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

@WebServlet(name = "UnidadesController", urlPatterns = {"/UnidadesController"})
public class UnidadesController extends HttpServlet {
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
            
           
            if (session.getAttribute("rol").equals("Administrador")) {
            request.getRequestDispatcher("index.jsp").forward(request, response);
            return;
            }
            
            
            String accion = request.getParameter("accion");
            String id ="";
            String id2="";
            ExperieciaEducativa y=null;
            Unidades c = null;
            Unidades x = null;
            ExperieciaEducativa E = new ExperieciaEducativa();
            response.setContentType("text/html;charset=UTF-8");
            UnidadesDAO Unidades_DAO = new UnidadesDAO();
            ExperieciaEducativaDAO ExperieciaEducativa_DAO = new ExperieciaEducativaDAO();
            //crear el factory para iniciar la validacion
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();
        if (accion == null) {
            List<Unidades> ListU=buscarUnidades((int)session.getAttribute("idpersonal"),1);
            request.setAttribute("unidadesList", ListU);
            request.setAttribute("list",ListU);
            
            
            request.getRequestDispatcher("Unidades_list.jsp").forward(request, response); 
        } else switch(accion){
            case INSERT:
                if (session.getAttribute("rol").equals("Profesor")) {
                    request.setAttribute("list",Unidades_DAO.findAll());            
                    request.getRequestDispatcher("Unidades_list.jsp").forward(request, response);
                    return;
                }
                String[] eeList= request.getParameterValues("Ee");
                String[] unidadesList=request.getParameterValues("nombreUnidad");
                int aux1=unidadesList.length;
                int i=0;
                while(i<aux1){
                    x=null;
                    x = new Unidades();
                    ExperieciaEducativa_DAO = new ExperieciaEducativaDAO();
                    x.setExperieciaEducativa(ExperieciaEducativa_DAO.find(Integer.parseInt(eeList[i])));
                    x.setNombreUnidad(unidadesList[i]);
                    
                    Set<ConstraintViolation<Unidades>> violations = validator.validate(x);
                    // enviar mensajes a jsp
                    if (violations.size()>0){
                        request.setAttribute("mensajes", violations);
                        request.getRequestDispatcher("error.jsp").forward(request, response);
                    }
                    else{
                        Unidades_DAO.create(x);
                        i++;
                    }
                }
                List<Unidades> auxiliar = buscarUnidades((Integer)session.getAttribute("idpersonal"),1);
                if(auxiliar.size()>0){
                    session.setAttribute("unidadesList", auxiliar);    
                }
                request.getRequestDispatcher("success.jsp").forward(request, response);
                break;
            case DELETE:
                if (session.getAttribute("rol").equals("Profesor")) {
                    request.setAttribute("list",Unidades_DAO.findAll());            
                    request.getRequestDispatcher("Unidades_list.jsp").forward(request, response);
                    return;
                }
                id= request.getParameter("id");
                Unidades_DAO.delete(Integer.parseInt(id));
                List<Unidades> auxiliar2 = buscarUnidades((Integer)session.getAttribute("idpersonal"),1);
                if(auxiliar2.size()>0){
                    session.setAttribute("unidadesList", auxiliar2);    
                }
                request.setAttribute("url","UnidadesController");
                request.getRequestDispatcher("success.jsp").forward(request, response);
                break;
            case UPDATE:
                if (session.getAttribute("rol").equals("Profesor")) {
                    request.setAttribute("list",Unidades_DAO.findAll());            
                    request.getRequestDispatcher("Unidades_list.jsp").forward(request, response);
                    return;
                }
                
                c = new Unidades();
                c.setExperieciaEducativa(ExperieciaEducativa_DAO.find(Integer.parseInt(request.getParameter("Ee"))));
                c.setNombreUnidad(new String(request.getParameter("nombreUnidad").getBytes("ISO-8859-1"),"UTF-8"));
                c.setIdUnidad(Integer.parseInt(request.getParameter("idUnidad")));
                 Set<ConstraintViolation<Unidades>> violations2 = validator.validate(c);
                // enviar mensajes a jsp
                if (violations2.size()>0){
                request.setAttribute("mensajes", violations2);
                request.getRequestDispatcher("error.jsp").forward(request, response);
                }
                else{
                    Unidades_DAO.update(c);
                    List<Unidades> auxiliar3 = buscarUnidades((Integer)session.getAttribute("idpersonal"),1);
                    if(auxiliar3.size()>0){
                        session.setAttribute("unidadesList", auxiliar3);    
                    }
                    request.setAttribute("url","UnidadesController");
                    request.getRequestDispatcher("success.jsp").forward(request, response);
                }
                break;
            case FIND:
                if (session.getAttribute("rol").equals("Profesor")) {
                    request.setAttribute("list",Unidades_DAO.findAll());            
                    request.getRequestDispatcher("Unidades_list.jsp").forward(request, response);
                    return;
                }
                
                id= request.getParameter("id");
                id2= request.getParameter("id2");
                c = Unidades_DAO.find(Integer.parseInt(id));
                y = ExperieciaEducativa_DAO.find(Integer.parseInt(id2));
                request.setAttribute("Unidades",c);
                request.setAttribute("Experiencia",y);
                request.setAttribute("ExperieciaEducativa",ExperieciaEducativa_DAO.findAll());
                request.getRequestDispatcher("Unidades_edit.jsp").forward(request, response);
                break;
            case ADD:
                if (session.getAttribute("rol").equals("Profesor")) {
                    request.setAttribute("list",Unidades_DAO.findAll());            
                    request.getRequestDispatcher("Unidades_list.jsp").forward(request, response);
                    return;
                }
                
                request.setAttribute("ExperieciaEducativa",ExperieciaEducativa_DAO.findAll());
                request.getRequestDispatcher("Unidades_add.jsp").forward(request, response);
                break;
            default:
                
        }
        
 }
    protected List buscarUnidades(int idPersonal, int modo){
            AcademiaDAO acaDao = new AcademiaDAO(); 
            List<Academia> academias = acaDao.findAll();
            List <Academia> pertenece = new ArrayList();
            ExperieciaEducativaDAO expe = new ExperieciaEducativaDAO();
            List <ExperieciaEducativa> experiencias = expe.findAll();
            

            UnidadesDAO unidades = new UnidadesDAO();
            List <Unidades> listaUnidades = unidades.findAll();
            List <Unidades> resultadoUnidades = new ArrayList();

            if(modo==0){//es coordinador
                    for(Academia aux:academias){
                        if(aux.getPersonal()!=null)
                        if(aux.getPersonal().getIdPersonal().equals(idPersonal)){
                            pertenece.add(aux);
                        }
                    }
                    for(ExperieciaEducativa aux:experiencias){
                        for(Academia auy:pertenece){
                            if(aux.getAcademia().getIdAcademia().equals(auy.getIdAcademia())){
                                for(Unidades ex:listaUnidades){
                                    if(ex.getExperieciaEducativa().getIdExperieciaEducativa().equals(aux.getIdExperieciaEducativa())){
                                        resultadoUnidades.add(ex);
                                    }
                                }
                            }
                        }
                    }
            }else{//es profesor
                List<ExperieciaEducativa> Mats=buscarMaterias(idPersonal,1);
                
                for(ExperieciaEducativa exp:Mats){
                    for(Unidades u:listaUnidades){
                        if (exp.getIdExperieciaEducativa().equals(u.getExperieciaEducativa().getIdExperieciaEducativa())) {
                            resultadoUnidades.add(u);
                        }
                    }
                }
                
            }
            return resultadoUnidades;
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
