package edu.uv.controller;
import edu.uv.model.dao.AcademiaDAO;
import edu.uv.model.dao.ExperieciaEducativaDAO;
import edu.uv.model.dao.ImparteDAO;
import edu.uv.model.dao.PreguntaDAO;
import edu.uv.model.dao.RespuestasDAO;
import edu.uv.model.dao.TemasDAO;
import edu.uv.model.dao.UnidadesDAO;
import edu.uv.model.pojos.Academia;
import edu.uv.model.pojos.ExperieciaEducativa;
import edu.uv.model.pojos.Imparte;
import edu.uv.model.pojos.Pregunta;
import edu.uv.model.pojos.Respuestas;
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

@WebServlet(name = "PreguntaController", urlPatterns = {"/PreguntaController"})
public class PreguntaController extends HttpServlet {
    static final String LIST = "";
    static final String DELETE = "borrar";
    static final String FILTRADO = "filtrar";
    static final String FILTRADOER = "filtrarer";
    static final String FIND ="buscar";
    static final String ADD = "agregar";
    static final String UPDATE = "actualizar";
    static final String INSERT = "insertar";
    static final String LIST_APPROVE = "list_aprobar";
    static final String APPROVE = "aprobar";
    static final String EE = "ee";

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
            String accion = request.getParameter("accion");
            String id ="";
            Pregunta c = null;
            Respuestas r = null;
            Temas T = new Temas();
            response.setContentType("text/html;charset=UTF-8");
            PreguntaDAO Pregunta_DAO = new PreguntaDAO();
            ExperieciaEducativaDAO ExperieciaEducativa_DAO =new ExperieciaEducativaDAO();
            UnidadesDAO Unidades_DAO = new UnidadesDAO();
            TemasDAO Temas_DAO = new TemasDAO();
            RespuestasDAO Respuestas_DAO = new RespuestasDAO();
            
            //crear el factory para iniciar la validacion
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();
        if (accion == null) {
            List<Pregunta> lista = buscarTemasPreguntasTotal((int)session.getAttribute("idpersonal"),modo);
            request.setAttribute("listaEE", ExperieciaEducativa_DAO.findAll());
            request.setAttribute("list",lista);
            request.getRequestDispatcher("Pregunta_list.jsp").forward(request, response); 
        } else switch(accion){
            case FILTRADO:
                //String aExp = request.getParameter("auxExp");
                String aUnidad = request.getParameter("auxUni");
                request.setAttribute("listaEE", ExperieciaEducativa_DAO.findAll());
                List<Pregunta> lista = buscarTemasPreguntas((int)session.getAttribute("idpersonal"),modo,Integer.parseInt(aUnidad));
                request.setAttribute("list",lista);
                request.getRequestDispatcher("Pregunta_list.jsp").forward(request, response);    
                break;
            case FILTRADOER:
                String aExp = request.getParameter("aExp");
                request.setAttribute("listaEE", ExperieciaEducativa_DAO.findAll());
                List<Pregunta> lista2 = buscarTemasPreguntasER((int)session.getAttribute("idpersonal"),modo,Integer.parseInt(aExp));
                request.setAttribute("list",lista2);
                request.getRequestDispatcher("Pregunta_list.jsp").forward(request, response);    
                break;
            case INSERT:
                c = new Pregunta();
                //Linea corrección NullPointerException
                if (!request.getParameter("tema").equals("")){
                    c.setTemas(Temas_DAO.find(Integer.parseInt(request.getParameter("tema"))));
                }else{
                    c.setTemas(null);
                }
                //c.setTemas(Temas_DAO.find(Integer.parseInt(request.getParameter("tema"))));
                c.setTipoPregunta(request.getParameter("tipoPregunta"));
                c.setDescripcionPregunta(new String(request.getParameter("descripcionPregunta").getBytes("ISO-8859-1"),"UTF-8"));
                c.setModalidadPregunta(new String(request.getParameter("modalidadPregunta").getBytes("ISO-8859-1"),"UTF-8"));
                c.setComplejidadPregunta(Integer.parseInt(request.getParameter("complejidadPregunta")));
                c.setPuntuacionPregunta(Integer.parseInt(request.getParameter("puntuacionPregunta")));
                c.setComentRetroalimentacion(new String(request.getParameter("comentRetroalimentacion").getBytes("ISO-8859-1"),"UTF-8"));
                c.setEstado("NoAprobado");
                Pregunta_DAO.create(c);
                // se agregan las respuestas
                String[] descripciones = request.getParameterValues("descripcionRespuesta");
                String correcta = request.getParameter("correct");
                for(int i=0;i<descripciones.length;i++){
                r = new Respuestas();
                r.setDescripcionRespuesta(descripciones[i]);
                        if(i==Integer.parseInt(correcta)){
                            r.setTipoResp("Correcta");
                        }else{
                            r.setTipoResp("Incorrecta");
                        }
                r.setPregunta(c);
                Respuestas_DAO.create(r);
                }
                
                request.setAttribute("url","PreguntaController");
                
                request.getRequestDispatcher("success.jsp").forward(request, response);
                break;
            case DELETE:
                id= request.getParameter("id");
                Pregunta_DAO.delete(Integer.parseInt(id));
                request.setAttribute("url","PreguntaController");
                request.getRequestDispatcher("success.jsp").forward(request, response);
                break;
            case UPDATE:
                c = new Pregunta();
                c.setTemas(Temas_DAO.find(Integer.parseInt(request.getParameter("tema"))));
                c.setTipoPregunta(request.getParameter("tipoPregunta"));
                c.setDescripcionPregunta(new String(request.getParameter("descripcionPregunta").getBytes("ISO-8859-1"),"UTF-8"));
                c.setModalidadPregunta(new String(request.getParameter("modalidadPregunta").getBytes("ISO-8859-1"),"UTF-8"));
                c.setComplejidadPregunta(Integer.parseInt(request.getParameter("complejidadPregunta")));
                c.setPuntuacionPregunta(Integer.parseInt(request.getParameter("puntuacionPregunta")));
                c.setComentRetroalimentacion(new String(request.getParameter("ComentRetroalimentacion").getBytes("ISO-8859-1"),"UTF-8"));
                c.setEstado("NoAprobado");
                Pregunta_DAO.update(c);
                request.setAttribute("url","PreguntaController");
                request.getRequestDispatcher("success.jsp").forward(request, response);
                break;
            case FIND:
                id= request.getParameter("id");
                c = Pregunta_DAO.find(Integer.parseInt(id));           
                request.setAttribute("Pregunta",c);
                request.setAttribute("Temas",Temas_DAO.findAll());
                request.getRequestDispatcher("Pregunta_edit.jsp").forward(request, response);
                break;
            case EE:
                request.setAttribute("ExperieciaEducativa",ExperieciaEducativa_DAO.findAll());
                request.getRequestDispatcher("Pregunta_list_ee.jsp").forward(request, response);
                break;
            case ADD:
                String exp =request.getParameter("id");
                request.setAttribute("Unidades",Unidades_DAO.findAllby("ExperieciaEducativa_idExperieciaEducativa",exp));
                request.getRequestDispatcher("Pregunta_add.jsp").forward(request, response);
                break;
            case LIST_APPROVE:
                request.setAttribute("list",Pregunta_DAO.findAllby("estado","NoAprobado"));
                request.getRequestDispatcher("Pregunta_list_approve.jsp").forward(request, response);
                break;
            case APPROVE:
                if(request.getParameter("aprobar") != null){
                    String[] ItemNames;
                    ItemNames = request.getParameterValues("aprobar");
                    for(int i = 0; i < ItemNames.length; i++){
                        c=null;
                        c= new Pregunta();
                        Pregunta_DAO = new PreguntaDAO();
                        c = Pregunta_DAO.find(Integer.parseInt(ItemNames[i]));
                    
                        c.setEstado("Aprobado");
                        Pregunta_DAO.update(c);


                        Set<ConstraintViolation<Pregunta>> violations3 = validator.validate(c);
                        // enviar mensajes a jsp
                        if (violations3.size() > 0) {
                            request.setAttribute("mensajes", violations3);
                            request.getRequestDispatcher("error.jsp").forward(request, response);
                        } else {
                            Pregunta_DAO.update(c);

                        }
                    }
                    request.setAttribute("url","PreguntaController?accion=list_aprobar");
                    request.getRequestDispatcher("success.jsp").forward(request, response);
                }
                
                
                break;
            default:
                
        }
        
 }
            //////////////////////
        protected List filtrarPreguntas(List <Pregunta> lista,String aExp, String aUnidad){
             List<Pregunta> preguntas= new ArrayList();
             for(Pregunta aux:lista){
                 if(aux.getTemas().getUnidades().getIdUnidad().equals(Integer.parseInt(aUnidad))){
                     preguntas.add(aux);
                 }
             }
             return preguntas;
         }

       protected List buscarTemasPreguntasTotal(int idPersonal, int modo){
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
            
            
            PreguntaDAO preDao = new PreguntaDAO();
            List <Pregunta> preguntas = preDao.findAll();
            List <Pregunta> resPre = new ArrayList();

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
                                                
                                                for(Pregunta z:preguntas){
                                                    if(z.getTemas().getIdTema().equals(ayu.getIdTema())){
                                                        resPre.add(z);
                                                    }
                                                }
                                                
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
                                    
                                    for(Pregunta z:preguntas){
                                                    if(z.getTemas().getIdTema().equals(ayu.getIdTema())){
                                                        resPre.add(z);
                                                    }
                                                }
                                    
                                }
                            }        
                        }
                    }
                }
                
            }
            return resPre;
        }
        
         protected List buscarTemasPreguntas(int idPersonal, int modo,int unidad){
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
            
            PreguntaDAO preDao = new PreguntaDAO();
            List <Pregunta> preguntas = preDao.findAll();
            List <Pregunta> resPre = new ArrayList();

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
                                            if((ayu.getUnidades().getIdUnidad().equals(ex.getIdUnidad()))&&(ex.getIdUnidad().equals(unidad))){
                                                
                                                for(Pregunta z:preguntas){
                                                    if(z.getTemas().getIdTema().equals(ayu.getIdTema())){
                                                        resPre.add(z);
                                                    }
                                                }
                                                
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
                                    
                                    for(Pregunta z:preguntas){
                                                    if(z.getTemas().getIdTema().equals(ayu.getIdTema())){
                                                        resPre.add(z);
                                                    }
                                                }
                                    
                                }
                            }        
                        }
                    }
                }
                
            }
            return resPre;
        }

       
       protected List buscarTemasPreguntasER(int idPersonal, int modo,int exper){
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
            
            PreguntaDAO preDao = new PreguntaDAO();
            List <Pregunta> preguntas = preDao.findAll();
            List <Pregunta> resPre = new ArrayList();

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
                                    if((ex.getExperieciaEducativa().getIdExperieciaEducativa().equals(aux.getIdExperieciaEducativa()))&&(aux.getIdExperieciaEducativa().equals(exper))){
                                        //resultadoUnidades.add(ex);
                                        for(Temas ayu:temas){
                                            if(ayu.getUnidades().getIdUnidad().equals(ex.getIdUnidad())){
                                                
                                                for(Pregunta z:preguntas){
                                                    if(z.getTemas().getIdTema().equals(ayu.getIdTema())){
                                                        resPre.add(z);
                                                    }
                                                }
                                                
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
                                    
                                    for(Pregunta z:preguntas){
                                                    if(z.getTemas().getIdTema().equals(ayu.getIdTema())){
                                                        resPre.add(z);
                                                    }
                                                }
                                    
                                }
                            }        
                        }
                    }
                }
                
            }
            return resPre;
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
