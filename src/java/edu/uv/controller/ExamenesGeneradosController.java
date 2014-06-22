
package edu.uv.controller;
import edu.uv.model.dao.ExamenPreguntaDAO;
import edu.uv.model.dao.ExamenesGeneradosDAO;
import edu.uv.model.dao.ExperieciaEducativaDAO;
import edu.uv.model.dao.PersonalDAO;
import edu.uv.model.dao.TemasDAO;
import edu.uv.model.dao.UnidadesDAO;
import edu.uv.model.pojos.ExamenPregunta;
import edu.uv.model.pojos.ExamenesGenerados;
import edu.uv.model.pojos.ExperieciaEducativa;
import edu.uv.model.pojos.Personal;
import edu.uv.model.pojos.Pregunta;
import edu.uv.model.pojos.Temas;
import edu.uv.model.pojos.Unidades;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
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

@WebServlet(name = "ExamenesGeneradosController", urlPatterns = {"/ExamenesGeneradosController"})
public class ExamenesGeneradosController extends HttpServlet {
    static final String LIST = "";
    static final String DELETE = "borrar";
    static final String FIND ="buscar";
    static final String ADD = "agregar";
    static final String UPDATE = "actualizar";
    static final String INSERT = "insertar";
    static final String EE = "ee";
    static final String TEMAS = "temas";
    static final String GENERA_EXAMEN = "examen";
    Date date;

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
            ExamenesGenerados c = null;
            Personal P = new Personal();
            ExperieciaEducativa E = new ExperieciaEducativa();
            response.setContentType("text/html;charset=UTF-8");
            ExamenesGeneradosDAO ExamenesGenerados_DAO = new ExamenesGeneradosDAO();
            PersonalDAO Personal_DAO = new PersonalDAO();
            UnidadesDAO Unidades_DAO = new UnidadesDAO();
            TemasDAO Temas_DAO = new TemasDAO();
            
            ExperieciaEducativaDAO ExperieciaEducativa_DAO = new ExperieciaEducativaDAO();
             //crear el factory para iniciar la validacion
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();
        if (accion == null) {
            request.setAttribute("list",ExamenesGenerados_DAO.findAll());
            request.getRequestDispatcher("ExamenesGenerados_list.jsp").forward(request, response); 
        } else switch(accion){
            case INSERT:
                c = new ExamenesGenerados();
                c.setPeriodo(new String(request.getParameter("periodo").getBytes("ISO-8859-1"),"UTF-8"));
                c.setTipoExamen(new String(request.getParameter("tipoExamen").getBytes("ISO-8859-1"),"UTF-8"));
                c.setDescripcionExamen(new String(request.getParameter("descripcionExamen").getBytes("ISO-8859-1"),"UTF-8"));
                c.setPorcTeoria(Integer.parseInt(request.getParameter("porcTeoria")));
                c.setPorcPractica(Integer.parseInt(request.getParameter("porcPractica")));
                c.setEstadoExamen(new String(request.getParameter("estadoExamen").getBytes("ISO-8859-1"),"UTF-8"));
                date = new Date();
                c.setFechaCreacion(date);
                c.setPersonal(Personal_DAO.find(Integer.parseInt(request.getParameter("personal"))));
                E = ExperieciaEducativa_DAO.find(Integer.parseInt(request.getParameter("ee")));
                c.setExperieciaEducativa(E);

                Set<ConstraintViolation<ExamenesGenerados>> violations = validator.validate(c);
                // enviar mensajes a jsp
                if (violations.size()>0){
                request.setAttribute("mensajes", violations);
                request.getRequestDispatcher("error.jsp").forward(request, response);
                }
                else{
                request.setAttribute("url","ExamenesGeneradosController");
                ExamenesGenerados_DAO.create(c);
                request.setAttribute("ee",E);
                List<ExamenesGenerados> eg =  ExamenesGenerados_DAO.findAll();
                c = eg.get(eg.size()-1);
                request.setAttribute("examen",c);
                request.getRequestDispatcher("Filtra_temas.jsp").forward(request, response);
                }
                break;
            case DELETE:
                id= request.getParameter("id");
                ExamenesGenerados_DAO.delete(Integer.parseInt(id));
                request.setAttribute("url","ExamenesGeneradosController");
                request.getRequestDispatcher("success.jsp").forward(request, response);
                break;
            case UPDATE:
                c = new ExamenesGenerados();
                c.setPeriodo(new String(request.getParameter("periodo").getBytes("ISO-8859-1"),"UTF-8"));
                c.setTipoExamen(new String(request.getParameter("tipoExamen").getBytes("ISO-8859-1"),"UTF-8"));
                c.setDescripcionExamen(new String(request.getParameter("descripcionExamen").getBytes("ISO-8859-1"),"UTF-8"));
                c.setPorcTeoria(Integer.parseInt(request.getParameter("porcTeoria")));
                c.setPorcPractica(Integer.parseInt(request.getParameter("porcPractica")));
                c.setEstadoExamen(new String(request.getParameter("estadoExamen").getBytes("ISO-8859-1"),"UTF-8"));
                c.setPersonal(Personal_DAO.find(Integer.parseInt(request.getParameter("personal"))));
                c.setExperieciaEducativa(ExperieciaEducativa_DAO.find(Integer.parseInt(request.getParameter("ee"))));
                c.setIdexamenesGenerados(Integer.parseInt(request.getParameter("idexamenesGenerados")));
                date = new Date();
                c.setFechaCreacion(date);
                request.setAttribute("url","ExamenesGeneradosController");
                Set<ConstraintViolation<ExamenesGenerados>> violations2 = validator.validate(c);
                // enviar mensajes a jsp
                if (violations2.size()>0){
                request.setAttribute("mensajes", violations2);
                request.getRequestDispatcher("error.jsp").forward(request, response);
                }
                else{
                ExamenesGenerados_DAO.update(c);
                request.setAttribute("url","ExamenesGeneradosController");
                request.getRequestDispatcher("success.jsp").forward(request, response);
                }
                break;
            case FIND:
                id= request.getParameter("id");
                c = ExamenesGenerados_DAO.find(Integer.parseInt(id));           
                request.setAttribute("ExamenesGenerados",c);
                request.setAttribute("Personal",Personal_DAO.findAll());
                request.setAttribute("ExperieciaEducativa",ExperieciaEducativa_DAO.findAll());
                request.getRequestDispatcher("ExamenesGenerados_edit.jsp").forward(request, response);
                break;
            case ADD:
                request.setAttribute("Personal",Personal_DAO.findAll());
                request.setAttribute("ExperieciaEducativa",ExperieciaEducativa_DAO.findAll());
                request.getRequestDispatcher("ExamenesGenerados_add.jsp").forward(request, response);
                break;
            case EE:
                request.setAttribute("ExperieciaEducativa",ExperieciaEducativa_DAO.findAll());
                request.getRequestDispatcher("Filtra_ee.jsp").forward(request, response);
                break;
            case TEMAS:
                id= request.getParameter("id");
                ExperieciaEducativa e = ExperieciaEducativa_DAO.find(Integer.parseInt(id));
                request.setAttribute("ee",e);
                request.setAttribute("list",Unidades_DAO.findAllby("ExperieciaEducativa_idExperieciaEducativa",id));
                request.getRequestDispatcher("Filtra_temas.jsp").forward(request, response);
                break;
            case GENERA_EXAMEN:
                String examen_id = request.getParameter("examen");
                String[] temas = request.getParameterValues("tema"); 
                // Recupera el examen que se generó previamente
                ExamenesGeneradosDAO examenesGenerados_DAO = new ExamenesGeneradosDAO();
                ExamenesGenerados examen = examenesGenerados_DAO.find(Integer.parseInt(examen_id));
                
                // Almacena el porcentaje de teoría y de práctica que tiene el examen
                //int iPorcTeoria = examen.getPorcTeoria();
                //int iPorcPractica = examen.getPorcPractica();
                
                ExamenPreguntaDAO ep = new ExamenPreguntaDAO(); // El DAO para hacer los insert                                
                List<Temas> tems = Temas_DAO.findAll(); // Lista de temas en general
                List<Temas> aux = new ArrayList(); // Lista de temas auxiliar donde van las que el usuario ha seleccionado 
                for(Temas t:tems){                          
                    for(int i=0;i<temas.length;i++){
                        if(t.getIdTema().equals(Integer.parseInt(temas[i]))){
                        aux.add(t); // Si el usuario la seleccionó, la agrega a la lista
                        }
                    }
                }
                // Se crean las listas de preguntas por tema que llevará el examen
                // considerando que una es para preguntas teóricas y otro para las prácticas.
                List<Pregunta> preguntasTemaTeoria = new ArrayList();
                List<Pregunta> preguntasTemaPractica = new ArrayList();
                List<Pregunta> preguntasTema = new ArrayList();
                for(Temas t2:aux){
                    // Se obtiene por tema todas las preguntas (teóricas y prácticas)
                    Object[] preguntas = t2.getPreguntas().toArray();                    
                    // Se hace un recorrido por todas las preguntas de ese tema y se van
                    // clasificando según sean preguntas de teoría o de práctica.
                    // Se registran en las listas correspondientes.                    
                    for(int x =0; x<preguntas.length; x++){
                        Pregunta auxiliar = (Pregunta)preguntas[x];
                        if(auxiliar.getModalidadPregunta().equals("Teoria"))
                            preguntasTemaTeoria.add(auxiliar);
                        else
                            preguntasTemaPractica.add(auxiliar);
                    }
                    // Se elige una pregunta de teoría y otra de práctica para cada tema.
                    // Se crea un ExamenPregunta para registrar la pregunta de Teoría y
                    // Se crea un ExamenPregunta para registrar la pregunta de Práctica
                   
                    // Pregunta de Teoría
                    ExamenPregunta epTeoria = new ExamenPregunta();
                    epTeoria.setExamenesGenerados(examen);
                    int getRandom = (int)Math.floor(Math.random()*preguntasTemaTeoria.size());
                    epTeoria.setPregunta(preguntasTemaTeoria.get(getRandom));
                    ep.create(epTeoria);
                    // Agrega la pregunta a la lista para mostrarlo en pantalla
                    preguntasTema.add(preguntasTemaTeoria.get(getRandom));
                    
                    //Pregunta de Práctica
                    ExamenPregunta epPractica = new ExamenPregunta();
                    epPractica.setExamenesGenerados(examen);
                    getRandom = (int)Math.floor(Math.random()*preguntasTemaPractica.size());
                    epPractica.setPregunta(preguntasTemaPractica.get(getRandom));
                    ep.create(epPractica); 
                    // Agrega la pregunta a la lista para mostrarlo en pantalla
                    preguntasTema.add(preguntasTemaPractica.get(getRandom));
                }    
                request.setAttribute("list", preguntasTema);
                request.getRequestDispatcher("ExamenesGenerados_list_preguntas.jsp").forward(request, response);
                break;
            default:
               ;
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
