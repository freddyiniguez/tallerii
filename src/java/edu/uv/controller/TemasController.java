package edu.uv.controller;
import edu.uv.model.dao.AcademiaDAO;
import edu.uv.model.dao.ExperieciaEducativaDAO;
import edu.uv.model.dao.ImparteDAO;
import edu.uv.model.dao.TemasDAO;
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

@WebServlet(name = "TemasController", urlPatterns = {"/TemasController"})
public class TemasController extends HttpServlet {
    static final String LIST = "";
    static final String DELETE = "borrar";
    static final String FIND ="buscar";
    static final String ADD = "agregar";
    static final String UPDATE = "actualizar";
    static final String INSERTA = "Insertar tema";
    static final String INSERTB = "Insertar subtema";

protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            //validar que el usuario tenga la sesion iniciada
            HttpSession session = request.getSession(true);
            
            int modo=-5;
            
            if (session.getAttribute("rol").equals("Coordinador")) {
                modo=0;
            }
            if (session.getAttribute("rol").equals("Profesor")) {
                modo=1;
            }
            
            
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
            Temas c = null;
            Temas T = new Temas();
            Unidades U = new Unidades();
            response.setContentType("text/html;charset=UTF-8");
            TemasDAO Temas_DAO = new TemasDAO();
            ExperieciaEducativaDAO EEDAO =new ExperieciaEducativaDAO();
            UnidadesDAO Unidades_DAO = new UnidadesDAO();
            
            //crear el factory para iniciar la validacion
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();
        if (accion == null) {
            List<Temas> temasD = buscarTemas((int)session.getAttribute("idpersonal"),modo);
            request.setAttribute("listaEE", EEDAO.findAll());
            request.setAttribute("list",temasD);
            request.getRequestDispatcher("Temas_list.jsp").forward(request, response); 
        } else switch(accion){
            case INSERTA:
                if (session.getAttribute("rol").equals("Profesor")) {
                    request.setAttribute("listaEE", EEDAO.findAll());
                    request.setAttribute("list",Temas_DAO.findAll());
                    request.getRequestDispatcher("Temas_list.jsp").forward(request, response); 
                return;
                }
                String[] nombreTemasList= request.getParameterValues("nombreTema");
                String[] unidadesList=request.getParameterValues("unidad");
                    
                int aux1=unidadesList.length;
                for(int i=0;i<aux1;i++){
                    c=null;
                    c = new Temas();
                    Unidades_DAO = new UnidadesDAO();
                    c.setNombreTema(nombreTemasList[i]);
                    c.setTemas(null);
                    c.setUnidades(Unidades_DAO.find(Integer.parseInt(unidadesList[i])));
                    request.setAttribute("url","TemasController");
                    Set<ConstraintViolation<Temas>> violations = validator.validate(c);
                // enviar mensajes a jsp
                    if (violations.size()>0){
                        request.setAttribute("mensajes", violations);
                        request.getRequestDispatcher("error.jsp").forward(request, response);
                    }
                    else{
                        Temas_DAO.create(c);
                        
                    }
                }
                request.getRequestDispatcher("success.jsp").forward(request, response);
                break;
            case INSERTB:
                if (session.getAttribute("rol").equals("Profesor")) {
                    request.setAttribute("listaEE", EEDAO.findAll());
                    request.setAttribute("list",Temas_DAO.findAll());
                    request.getRequestDispatcher("Temas_list.jsp").forward(request, response); 
                return;
                }
                
                String[] nombreTemasList2= request.getParameterValues("nombreTema");
                String[] temas2List=request.getParameterValues("tema");
                String[] unidadesList2=request.getParameterValues("unidad");
                    
                int aux2=unidadesList2.length;
                
                for(int i=0;i<aux2;i++){
                    c=null;
                    c = new Temas();
                    Unidades_DAO = new UnidadesDAO();
                    Temas_DAO = new TemasDAO();
                
                    c.setNombreTema(nombreTemasList2[i]);
                    c.setTemas(Temas_DAO.find(Integer.parseInt(temas2List[i])));
                    c.setUnidades(Unidades_DAO.find(Integer.parseInt(unidadesList2[i])));
                    request.setAttribute("url","TemasController");
                    Set<ConstraintViolation<Temas>> violations3 = validator.validate(c);
                // enviar mensajes a jsp
                    if (violations3.size()>0){
                        request.setAttribute("mensajes", violations3);
                        request.getRequestDispatcher("error.jsp").forward(request, response);
                    }
                    else{
                        Temas_DAO.create(c);
                    }
                }
                request.getRequestDispatcher("success.jsp").forward(request, response);
                break;
            case DELETE:
                if (session.getAttribute("rol").equals("Profesor")) {
                    request.setAttribute("listaEE", EEDAO.findAll());
                    request.setAttribute("list",Temas_DAO.findAll());
                    request.getRequestDispatcher("Temas_list.jsp").forward(request, response);
                return;
                }
                
                id= request.getParameter("id");
                Temas_DAO.delete(Integer.parseInt(id));
                request.setAttribute("url","TemasController");
                request.getRequestDispatcher("success.jsp").forward(request, response);
                break;
            case UPDATE:
                if (session.getAttribute("rol").equals("Profesor")) {
                    request.setAttribute("listaEE", EEDAO.findAll());
                    request.setAttribute("list",Temas_DAO.findAll());
                    request.getRequestDispatcher("Temas_list.jsp").forward(request, response);
                return;
                }
                
                c = new Temas();
                c.setNombreTema(new String(request.getParameter("nombreTema").getBytes("ISO-8859-1"),"UTF-8"));
                if(!request.getParameter("tema").equals("")){
                c.setTemas(Temas_DAO.find(Integer.parseInt(request.getParameter("tema"))));
                }else{
                c.setTemas(null);
                }
                c.setUnidades(Unidades_DAO.find(Integer.parseInt(request.getParameter("unidad"))));
                c.setIdTema(Integer.parseInt(request.getParameter("idTema")));
                Set<ConstraintViolation<Temas>> violations2 = validator.validate(c);
                // enviar mensajes a jsp
                if (violations2.size()>0){
                request.setAttribute("mensajes", violations2);
                request.getRequestDispatcher("error.jsp").forward(request, response);
                }
                else{
                Temas_DAO.update(c);
                request.setAttribute("url","TemasController");
                request.getRequestDispatcher("success.jsp").forward(request, response);
                }
                break;
            case FIND:
                if (session.getAttribute("rol").equals("Profesor")) {
                    request.setAttribute("listaEE", EEDAO.findAll());
                    request.setAttribute("list",Temas_DAO.findAll());
                    request.getRequestDispatcher("Temas_list.jsp").forward(request, response);
                return;
                }
                
                id= request.getParameter("id");
                c = Temas_DAO.find(Integer.parseInt(id)); 
                String uni=request.getParameter("uni");
                request.setAttribute("Temas",c);
                request.setAttribute("Temas_list",Temas_DAO.findAll());
                //request.setAttribute("Temas_list",Temas_DAO.findAllby("Unidades_idUnidad",uni));
                //personalizar lista de unidades segun la EE
                
                //request.setAttribute("Unidades",Unidades_DAO.findAllby("Unidades",uni));
                request.setAttribute("Unidades",Unidades_DAO.findAll());
                request.getRequestDispatcher("Temas_edit.jsp").forward(request, response);
                break;
            case ADD:
                if (session.getAttribute("rol").equals("Profesor")) {
                    request.setAttribute("listaEE", EEDAO.findAll());
                    request.setAttribute("list",Temas_DAO.findAll());
                    request.getRequestDispatcher("Temas_list.jsp").forward(request, response);
                return;
                }
                
                request.setAttribute("Temas",Temas_DAO.findAll());
                String exp =request.getParameter("idEE");
                request.setAttribute("Unidades",Unidades_DAO.findAllby("ExperieciaEducativa_idExperieciaEducativa",exp));
                request.setAttribute("EE", request.getParameter("idEE"));
                request.getRequestDispatcher("Temas_add.jsp").forward(request, response);
                break;
            default:
                
        }
        
 }

    
     protected List buscarTemas(int idPersonal, int modo){
            AcademiaDAO acaDao = new AcademiaDAO(); 
            List<Academia> academias = acaDao.findAll();
            List <Academia> pertenece = new ArrayList();
            ExperieciaEducativaDAO expe = new ExperieciaEducativaDAO();
            List <ExperieciaEducativa> experiencias = expe.findAll();
            

            UnidadesDAO unidades = new UnidadesDAO();
            List <Unidades> listaUnidades = unidades.findAll();
            List <Unidades> resultadoUnidades = new ArrayList();
            TemasDAO temas_dao = new TemasDAO();
            List <Temas> temas= temas_dao.findAll();
            List <Temas> res = new ArrayList();

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
                                        //resultadoUnidades.add(ex);
                                        for(Temas ayu:temas){
                                            if(ayu.getUnidades().getIdUnidad().equals(ex.getIdUnidad())){
                                                res.add(ayu);
                                            }
                                        }
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
                            //resultadoUnidades.add(u
                            for(Temas ayu:temas){
                                if(ayu.getUnidades().getIdUnidad().equals(u.getIdUnidad())){
                                    res.add(ayu);
                                }
                            }        
                        }
                    }
                }
                
            }
            return res;
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
