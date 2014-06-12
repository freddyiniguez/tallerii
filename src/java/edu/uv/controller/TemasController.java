package edu.uv.controller;
import edu.uv.model.dao.ExperieciaEducativaDAO;
import edu.uv.model.dao.TemasDAO;
import edu.uv.model.dao.UnidadesDAO;
import edu.uv.model.pojos.Temas;
import edu.uv.model.pojos.Unidades;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "TemasController", urlPatterns = {"/TemasController"})
public class TemasController extends HttpServlet {
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
            Temas c = null;
            Temas T = new Temas();
            Unidades U = new Unidades();
            response.setContentType("text/html;charset=UTF-8");
            TemasDAO Temas_DAO = new TemasDAO();
            ExperieciaEducativaDAO EEDAO =new ExperieciaEducativaDAO();
            UnidadesDAO Unidades_DAO = new UnidadesDAO();
        if (accion == null) {
            request.setAttribute("listaEE", EEDAO.findAll());
            request.setAttribute("list",Temas_DAO.findAll());
            request.getRequestDispatcher("Temas_list.jsp").forward(request, response); 
        } else switch(accion){
            case INSERT:
                c = new Temas();
                c.setNombreTema(request.getParameter("nombreTema"));
                if(!request.getParameter("tema").equals("")){
                c.setTemas(Temas_DAO.find(Integer.parseInt(request.getParameter("tema"))));
                }else{
                c.setTemas(null);
                }
                c.setUnidades(Unidades_DAO.find(Integer.parseInt(request.getParameter("unidad"))));
                request.setAttribute("url","TemasController");
                Temas_DAO.create(c);
                request.getRequestDispatcher("success.jsp").forward(request, response);
                break;
            case DELETE:
                id= request.getParameter("id");
                Temas_DAO.delete(Integer.parseInt(id));
                request.setAttribute("url","TemasController");
                request.getRequestDispatcher("success.jsp").forward(request, response);
                break;
            case UPDATE:
                c = new Temas();
                c.setNombreTema(request.getParameter("nombreTema"));
                if(!request.getParameter("tema").equals("")){
                c.setTemas(Temas_DAO.find(Integer.parseInt(request.getParameter("tema"))));
                }else{
                c.setTemas(null);
                }
                c.setUnidades(Unidades_DAO.find(Integer.parseInt(request.getParameter("unidad"))));
                c.setIdTema(Integer.parseInt(request.getParameter("idTema")));
                Temas_DAO.update(c);
                request.setAttribute("url","TemasController");
                request.getRequestDispatcher("success.jsp").forward(request, response);
                break;
            case FIND:
                id= request.getParameter("id");
                c = Temas_DAO.find(Integer.parseInt(id));           
                request.setAttribute("Temas",c);
                request.setAttribute("Temas_list",Temas_DAO.findAll());
                request.setAttribute("Unidades",Unidades_DAO.findAll());
                request.getRequestDispatcher("Temas_edit.jsp").forward(request, response);
                break;
            case ADD:
                request.setAttribute("Temas",Temas_DAO.findAll());
                String exp =request.getParameter("idEE");
                request.setAttribute("Unidades",Unidades_DAO.findAllby("ExperieciaEducativa_idExperieciaEducativa",exp));
                request.setAttribute("EE", request.getParameter("idEE"));
                request.getRequestDispatcher("Temas_add.jsp").forward(request, response);
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
