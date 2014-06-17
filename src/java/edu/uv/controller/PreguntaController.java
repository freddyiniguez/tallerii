package edu.uv.controller;
import edu.uv.model.dao.ExperieciaEducativaDAO;
import edu.uv.model.dao.PreguntaDAO;
import edu.uv.model.dao.RespuestasDAO;
import edu.uv.model.dao.TemasDAO;
import edu.uv.model.dao.UnidadesDAO;
import edu.uv.model.pojos.Pregunta;
import edu.uv.model.pojos.Respuestas;
import edu.uv.model.pojos.Temas;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "PreguntaController", urlPatterns = {"/PreguntaController"})
public class PreguntaController extends HttpServlet {
    static final String LIST = "";
    static final String DELETE = "borrar";
    static final String FIND ="buscar";
    static final String ADD = "agregar";
    static final String UPDATE = "actualizar";
    static final String INSERT = "insertar";
    static final String LIST_APPROVE = "list_aprobar";


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
            Pregunta c = null;
            Respuestas r = null;
            Temas T = new Temas();
            response.setContentType("text/html;charset=UTF-8");
            PreguntaDAO Pregunta_DAO = new PreguntaDAO();
            ExperieciaEducativaDAO EEDAO =new ExperieciaEducativaDAO();
            UnidadesDAO Unidades_DAO = new UnidadesDAO();
            TemasDAO Temas_DAO = new TemasDAO();
            RespuestasDAO Respuestas_DAO = new RespuestasDAO();
        if (accion == null) {
            request.setAttribute("listaEE", EEDAO.findAll());
            request.setAttribute("list",Pregunta_DAO.findAll());
            request.getRequestDispatcher("Pregunta_list.jsp").forward(request, response); 
        } else switch(accion){
            case INSERT:
                c = new Pregunta();
                //c.setTemas(new String(request.getParameter("tema").getBytes("ISO-8859-1"),"UTF-8"));
                c.setTemas(Temas_DAO.find(Integer.parseInt(request.getParameter("tema"))));
                c.setTipoPregunta(request.getParameter("tipoPregunta"));
                c.setDescripcionPregunta(request.getParameter("descripcionPregunta"));
                c.setModalidadPregunta(request.getParameter("modalidadPregunta"));
                c.setComplejidadPregunta(Integer.parseInt(request.getParameter("complejidadPregunta")));
                c.setPuntuacionPregunta(Integer.parseInt(request.getParameter("puntuacionPregunta")));
                c.setComentRetroalimentacion(request.getParameter("ComentRetroalimentacion"));
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
                c.setDescripcionPregunta(request.getParameter("descripcionPregunta"));
                c.setModalidadPregunta(request.getParameter("modalidadPregunta"));
                c.setComplejidadPregunta(Integer.parseInt(request.getParameter("complejidadPregunta")));
                c.setPuntuacionPregunta(Integer.parseInt(request.getParameter("puntuacionPregunta")));
                c.setComentRetroalimentacion(request.getParameter("ComentRetroalimentacion"));
                c.setIdPregunta(Integer.parseInt(request.getParameter("idPregunta")));
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
            case ADD:
                String exp =request.getParameter("idEE");
                request.setAttribute("Temas",Temas_DAO.findAll());
                request.setAttribute("Unidades",Unidades_DAO.findAllby("ExperieciaEducativa_idExperieciaEducativa",exp));
                request.getRequestDispatcher("Pregunta_add.jsp").forward(request, response);
                break;
            case LIST_APPROVE:
                request.setAttribute("list",Pregunta_DAO.findAll());
                request.getRequestDispatcher("Pregunta_list_approve.jsp").forward(request, response);
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
