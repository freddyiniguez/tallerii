package edu.uv.controller;

import edu.uv.model.dao.AcademiaDAO;
import edu.uv.model.dao.PersonalDAO;
import edu.uv.model.dao.UsuariosDAO;
import edu.uv.model.dao.ImparteDAO;
import edu.uv.model.dao.ExperieciaEducativaDAO;
import edu.uv.model.dao.UnidadesDAO;
import edu.uv.model.pojos.Academia;
import edu.uv.model.pojos.Personal;
import edu.uv.model.pojos.Usuarios;
import edu.uv.model.pojos.Imparte;
import edu.uv.model.pojos.ExperieciaEducativa;
import edu.uv.model.pojos.Unidades;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {



    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PersonalDAO personal=new PersonalDAO();
        HttpSession session = request.getSession(true);
        session.invalidate();
        session = request.getSession(true);
        if (request.getParameter("usuario")!=null) {       
        
        String usuario = request.getParameter("usuario");
        String pass = request.getParameter("password");
        Usuarios res = validar(usuario, pass);
        
        if (res!=null) {
            Personal per=res.getPersonal();
            session.setAttribute("idusuario", res.getIdUsuario());
            session.setAttribute("idpersonal", per.getIdPersonal());
            
            if (res.getEstadoUsuario().equals("inactivo")) {
                session.setAttribute("estado", "Su cuenta esta desactivada, consulte al administrador");
                request.getRequestDispatcher("login_.jsp").forward(request, response);
            }else{
                if (res.getRol().equals("Administrador")) {
                    session.setAttribute("rol", "Administrador");
                    //session.setAttribute("academia", null);
                    session.removeAttribute("academia");
                    
                    List<ExperieciaEducativa> mats =buscarMaterias(-50,0);
                    if (mats.size()>0) {
                        session.setAttribute("matslist", mats);
                    }
                    
                }else{/////////////////////////////////////////////////////////////////////////////////////////////////
                    int academia= buscarRol(per.getIdPersonal());
                    List<ExperieciaEducativa> mats =buscarMateriasAcademia(per.getIdPersonal());
                    List<Unidades> auxiliar3 ;

                    if (academia!=-5) {//es coordinador
                        mats = buscarMateriasAcademia(per.getIdPersonal());
                        session.setAttribute("rol", "Coordinador");
                        session.setAttribute("academia", academia);
                        session.setAttribute("matslist", mats);
                        auxiliar3 = buscarUnidades((Integer)session.getAttribute("idpersonal"));
                        if(auxiliar3.size()>0){
                            session.setAttribute("unidadesList", auxiliar3);    
                        }
                        
                        
                    }else{//es profesor
                         mats =buscarMaterias(per.getIdPersonal(),1);
                        session.setAttribute("rol", "Profesor");
                        //session.setAttribute("matslist", mats);
                    }
                }
                
            session.setAttribute("user", res.getLoginUsuario());
            session.setAttribute("estado", "");
            request.getRequestDispatcher("index.jsp").forward(request, response);
            }
           
        }else{
            session.setAttribute("estado", "Su cuenta no existe");
            request.getRequestDispatcher("login_.jsp").forward(request, response);
            
        }
        }else
        {
            session = request.getSession(true);
            String ses=(String)session.getAttribute("user");
            if (ses==null) {
            session.setAttribute("estado", "");
            request.getRequestDispatcher("login_.jsp").forward(request, response);    
            }else{
            session.setAttribute("estado", "");
            request.getRequestDispatcher("index.jsp").forward(request, response);   
            }
        }
    }
    
    protected int buscarRol(int idPersonal){
        AcademiaDAO ac=new AcademiaDAO();
        List<Academia>acs=ac.findAll();
        int idAcademia= -5;
        //ArrayList<Academia>AcademiasR=new ArrayList();
        
        for(Academia a : acs){
            if (a.getPersonal()!=null) 
            if (a.getPersonal().getIdPersonal().equals(idPersonal)) {
                idAcademia=a.getIdAcademia();
            }
        }
        
        return idAcademia;
        
    }
    protected List buscarUnidades(int idPersonal){
            AcademiaDAO acaDao = new AcademiaDAO(); 
            List<Academia> academias = acaDao.findAll();
            List <Academia> pertenece = new ArrayList();
            ExperieciaEducativaDAO expe = new ExperieciaEducativaDAO();
            List <ExperieciaEducativa> experiencias = expe.findAll();
            

            UnidadesDAO unidades = new UnidadesDAO();
            List <Unidades> listaUnidades = unidades.findAll();
            List <Unidades> resultadoUnidades = new ArrayList();


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
            return resultadoUnidades;
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
    
    /*protected List buscarMaterias(int id personal){
        return null;
    }*/

    protected Usuarios validar(String usuario, String password) {
        UsuariosDAO Usuarios_DAO = new UsuariosDAO();
        List<Usuarios> users = Usuarios_DAO.findAll();
        boolean encontrado = false;
        Usuarios u=null;

        for (Usuarios user : users) {
            String userlist = user.getLoginUsuario();
            String passlist = user.getPasswordUsuario();
            //boolean res=userlist.matches(usuario);

            if (userlist.matches(usuario) && passlist.matches(password)) {
                encontrado = true;
                u=user;
            }
        }
        return u;
        /*if (encontrado == false) {
            return u;
        } else {
            return u;
        }*/
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
       // request.getRequestDispatcher("IniciarSesion.jsp").forward(request, response);
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
