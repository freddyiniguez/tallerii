package edu.uv.controller;
import edu.uv.model.dao.ExamenesGeneradosDAO;
import edu.uv.model.dao.ExperieciaEducativaDAO;
import edu.uv.model.dao.PersonalDAO;
import edu.uv.model.pojos.ExamenesGenerados;
import edu.uv.model.pojos.ExperieciaEducativa;
import edu.uv.model.pojos.Personal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ExamenesGeneradosController", urlPatterns = {"/ExamenesGeneradosController"})
public class ExamenesGeneradosController extends HttpServlet {
    static final String LIST = "";
    static final String DELETE = "borrar";
    static final String FIND ="buscar";
    static final String ADD = "agregar";
    static final String UPDATE = "actualizar";
    static final String INSERT = "insertar";
    Date date;

protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String accion = request.getParameter("accion");
            String id ="";
            ExamenesGenerados c = null;
            Personal P = new Personal();
            ExperieciaEducativa E = new ExperieciaEducativa();
            response.setContentType("text/html;charset=UTF-8");
            ExamenesGeneradosDAO ExamenesGenerados_DAO = new ExamenesGeneradosDAO();
            PersonalDAO Personal_DAO = new PersonalDAO();
            ExperieciaEducativaDAO ExperieciaEducativa_DAO = new ExperieciaEducativaDAO();
        if (accion == null) {
            request.setAttribute("list",ExamenesGenerados_DAO.findAll());
            request.getRequestDispatcher("ExamenesGenerados_list.jsp").forward(request, response); 
        } else switch(accion){
            case INSERT:
                c = new ExamenesGenerados();
                c.setPeriodo(request.getParameter("periodo"));
                c.setTipoExamen(request.getParameter("tipoExamen"));
                c.setDescripcionExamen(request.getParameter("descripcionExamen"));
                c.setPorcTeoria(Integer.parseInt(request.getParameter("porcTeoria")));
                c.setPorcPractica(Integer.parseInt(request.getParameter("porcPractica")));
                c.setEstadoExamen(request.getParameter("estadoExamen"));
                date = new Date();
                c.setFechaCreacion(date);
                c.setPersonal(Personal_DAO.find(Integer.parseInt(request.getParameter("personal"))));
                c.setExperieciaEducativa(ExperieciaEducativa_DAO.find(Integer.parseInt(request.getParameter("ee"))));
                request.setAttribute("url","ExamenesGeneradosController");
                ExamenesGenerados_DAO.create(c);
                request.getRequestDispatcher("success.jsp").forward(request, response);
                break;
            case DELETE:
                id= request.getParameter("id");
                ExamenesGenerados_DAO.delete(Integer.parseInt(id));
                request.setAttribute("url","ExamenesGeneradosController");
                request.getRequestDispatcher("success.jsp").forward(request, response);
                break;
            case UPDATE:
                c = new ExamenesGenerados();
                c.setPeriodo(request.getParameter("periodo"));
                c.setTipoExamen(request.getParameter("tipoExamen"));
                c.setDescripcionExamen(request.getParameter("descripcionExamen"));
                c.setPorcTeoria(Integer.parseInt(request.getParameter("porcTeoria")));
                c.setPorcPractica(Integer.parseInt(request.getParameter("porcPractica")));
                c.setEstadoExamen(request.getParameter("estadoExamen"));
                c.setPersonal(Personal_DAO.find(Integer.parseInt(request.getParameter("personal"))));
                c.setExperieciaEducativa(ExperieciaEducativa_DAO.find(Integer.parseInt(request.getParameter("ee"))));
                c.setIdexamenesGenerados(Integer.parseInt(request.getParameter("idexamenesGenerados")));
                date = new Date();
                c.setFechaCreacion(date);
                ExamenesGenerados_DAO.update(c);
                request.setAttribute("url","ExamenesGeneradosController");
                request.getRequestDispatcher("success.jsp").forward(request, response);
                break;
            case FIND:
                id= request.getParameter("id");
                c = ExamenesGenerados_DAO.find(Integer.parseInt(id));           
                request.setAttribute("ExamenesGenerados",c);
                request.setAttribute("Personal",Personal_DAO.findAll());
                request.setAttribute("ExperieciaEducativa",ExperieciaEducativa_DAO.findAll());
                request.getRequestDispatcher("ExamenesGenerados_edit.jsp").forward(request, response);
            case ADD:
                request.setAttribute("Personal",Personal_DAO.findAll());
                request.setAttribute("ExperieciaEducativa",ExperieciaEducativa_DAO.findAll());
                request.getRequestDispatcher("ExamenesGenerados_add.jsp").forward(request, response);
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
