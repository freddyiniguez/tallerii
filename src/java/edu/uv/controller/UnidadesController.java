package edu.uv.controller;
import edu.uv.model.dao.ExperieciaEducativaDAO;
import edu.uv.model.dao.UnidadesDAO;
import edu.uv.model.pojos.ExperieciaEducativa;
import edu.uv.model.pojos.Unidades;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
            String accion = request.getParameter("accion");
            String id ="";
            Unidades c = null;
            ExperieciaEducativa E = new ExperieciaEducativa();
            response.setContentType("text/html;charset=UTF-8");
            UnidadesDAO Unidades_DAO = new UnidadesDAO();
            ExperieciaEducativaDAO ExperieciaEducativa_DAO = new ExperieciaEducativaDAO();
        if (accion == null) {
            request.setAttribute("list",Unidades_DAO.findAll());
            request.getRequestDispatcher("Unidades_list.jsp").forward(request, response); 
        } else switch(accion){
            case INSERT:
                c = new Unidades();
                c.setExperieciaEducativa(ExperieciaEducativa_DAO.find(Integer.parseInt(request.getParameter("Ee"))));
                c.setNombreUnidad(request.getParameter("nombreUnidad"));
                request.setAttribute("url","UnidadesController");
                Unidades_DAO.create(c);
                request.getRequestDispatcher("success.jsp").forward(request, response);
                break;
            case DELETE:
                id= request.getParameter("id");
                Unidades_DAO.delete(Integer.parseInt(id));
                request.setAttribute("url","UnidadesController");
                request.getRequestDispatcher("success.jsp").forward(request, response);
                break;
            case UPDATE:
                c = new Unidades();
                c.setExperieciaEducativa(ExperieciaEducativa_DAO.find(Integer.parseInt(request.getParameter("Ee"))));
                c.setNombreUnidad(request.getParameter("nombreUnidad"));
                c.setIdUnidad(Integer.parseInt(request.getParameter("idUnidad")));
                Unidades_DAO.update(c);
                request.setAttribute("url","UnidadesController");
                request.getRequestDispatcher("success.jsp").forward(request, response);
                break;
            case FIND:
                id= request.getParameter("id");
                c = Unidades_DAO.find(Integer.parseInt(id));           
                request.setAttribute("Unidades",c);
                request.setAttribute("ExperieciaEducativa",ExperieciaEducativa_DAO.findAll());
                request.getRequestDispatcher("Unidades_edit.jsp").forward(request, response);
            case ADD:
                request.setAttribute("ExperieciaEducativa",ExperieciaEducativa_DAO.findAll());
                request.getRequestDispatcher("Unidades_add.jsp").forward(request, response);
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
