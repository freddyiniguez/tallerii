/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.uv.controller;


import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import edu.uv.model.dao.ExamenPreguntaDAO;
import edu.uv.model.dao.ExamenesGeneradosDAO;
import edu.uv.model.dao.PreguntaDAO;
import edu.uv.model.dao.TemasDAO;
import edu.uv.model.pojos.ExamenPregunta;
import edu.uv.model.pojos.ExamenesGenerados;
import edu.uv.model.pojos.Pregunta;
import edu.uv.model.pojos.Respuestas;
import edu.uv.model.pojos.Temas;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
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

/**
 *
 * @author Arriaga Bellido
 */
@WebServlet(name = "ExamenPreguntaController", urlPatterns = {"/ExamenPreguntaController"})
public class ExamenPreguntaController extends HttpServlet {
    static final String LIST = "";
    static final String DELETE = "borrar";
    static final String FIND ="buscar";
    static final String ADD = "agregar";
    static final String UPDATE = "actualizar";
    static final String INSERT = "insertar";
    
    private Document pdfExamen;
    private Document clave;
    
    private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,Font.BOLD);
    private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,Font.BOLD);
    private static Font correcta = new Font(Font.FontFamily.TIMES_ROMAN, 18,Font.BOLD,BaseColor.RED);
    
    public int numPre=0;
    public String letras[]= {"a","b","c","d","e","f","g","h","i","j","k","l"};
    


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
            ExamenPregunta c = null;
            Pregunta P = new Pregunta();
            ExamenesGenerados E = new ExamenesGenerados();
            response.setContentType("text/html;charset=UTF-8");
            ExamenPreguntaDAO ExamenPregunta_DAO = new ExamenPreguntaDAO();
            PreguntaDAO Pregunta_DAO = new PreguntaDAO();
            TemasDAO Temas_DAO = new TemasDAO();
            ExamenesGeneradosDAO ExamenesGenerados_DAO = new ExamenesGeneradosDAO();
            //crear el factory para iniciar la validacion
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();
        if (accion == null) {
            
            ExamenesGenerados peto = ExamenesGenerados_DAO.find(Integer.parseInt(request.getParameter("idEx")));
            
            try{
            // Crea una referencia a un documento PDF en el que se va a guardar el examen
            pdfExamen = new Document();
            clave = new Document();
            
            URL resource = getClass().getResource("/");
            String path = resource.getPath();
            path = path.replace("WEB-INF/classes/", "assets/");
            PdfWriter.getInstance(pdfExamen, new FileOutputStream(path+"examen.pdf"));
            PdfWriter.getInstance(clave, new FileOutputStream(path+"clave.pdf"));
            
            pdfExamen.open(); 
            clave.open();
            
            
            
            //pdfExamen.add(new Paragraph(x));
            encabezado(pdfExamen,peto);
            encabezado(clave,peto);
            contenido(pdfExamen,clave,peto);
            
             //encabezado(pdfExamen,examen);
            //encabezado(clave,examen);
        }catch(DocumentException xd){
            System.out.println(xd.getMessage());
        }
        
         pdfExamen.close();
         clave.close();
             
            
            
            request.setAttribute("Examen",peto);
            //request.getRequestDispatcher("ExamenPregunta_list.jsp").forward(request, response); 
            //request.setAttribute("list",preguntasList(Integer.parseInt(request.getParameter("idEx"))));
            request.getRequestDispatcher("ExamenPregunta_list.jsp").forward(request, response);
        } else switch(accion){
            case INSERT:
                c = new ExamenPregunta();
                c.setExamenesGenerados(ExamenesGenerados_DAO.find(Integer.parseInt(request.getParameter("tipoExa"))));
                c.setPregunta(Pregunta_DAO.find(Integer.parseInt(request.getParameter("pregunta"))));
                c.setPuntaje(Double.parseDouble(request.getParameter("puntaje")));
                Set<ConstraintViolation<ExamenPregunta>> violations = validator.validate(c);
                // enviar mensajes a jsp
                if (violations.size()>0){
                request.setAttribute("mensajes", violations);
                request.getRequestDispatcher("error.jsp").forward(request, response);
                }
                else{
                request.setAttribute("url","ExamenPreguntaController");
                ExamenPregunta_DAO.create(c);
                request.getRequestDispatcher("success.jsp").forward(request, response);
                }
                break;
            case DELETE:
                id= request.getParameter("id");
                ExamenPregunta_DAO.delete(Integer.parseInt(id));
                request.setAttribute("url","ExamenPreguntaController");
                request.getRequestDispatcher("success.jsp").forward(request, response);
                break;
            case UPDATE:
                c = new ExamenPregunta();
                String id_examn = request.getParameter("id_examen");
                c = ExamenPregunta_DAO.find(Integer.parseInt(request.getParameter("id")));
                c.setPregunta(Pregunta_DAO.find(Integer.parseInt(request.getParameter("pregunta"))));
                /*
                c.setExamenesGenerados(ExamenesGenerados_DAO.find(Integer.parseInt(request.getParameter("tipoExa"))));
                c.setPregunta(Pregunta_DAO.find(Integer.parseInt(request.getParameter("pregunta"))));
                c.setPuntaje(Double.parseDouble(request.getParameter("puntaje")));
                c.setIdExamenPregunta(Integer.parseInt(request.getParameter("idExamenPregunta")));
                */
                Set<ConstraintViolation<ExamenPregunta>> violations2 = validator.validate(c);
                // enviar mensajes a jsp
                if (violations2.size()>0){
                request.setAttribute("mensajes", violations2);
                request.getRequestDispatcher("error.jsp").forward(request, response);
                }
                else{
                ExamenPregunta_DAO.update(c);
                request.setAttribute("url","ExamenPreguntaController?idEx="+id_examn);
                request.getRequestDispatcher("success.jsp").forward(request, response);
                }
                break;
            case FIND:
                
                List<Pregunta> preg = Pregunta_DAO.findAll();
                List<Pregunta> aux = new ArrayList<Pregunta>();
                id= request.getParameter("pregunta");
                c = ExamenPregunta_DAO.find(Integer.parseInt(id));
                for(Pregunta p:preg){
                    if(p.getTemas().getNombreTema().equals(c.getPregunta().getTemas().getNombreTema())){
                        if(p.getModalidadPregunta().equals(c.getPregunta().getModalidadPregunta())){
                        aux.add(p);
                        }
                    }
                }
                request.setAttribute("ExamenPregunta",c);
                //request.setAttribute("ExamenesGenerados",ExamenesGenerados_DAO.findAll());
                request.setAttribute("Pregunta",aux);
                request.getRequestDispatcher("ExamenPregunta_edit.jsp").forward(request, response);
                
                break;
            case ADD:
                request.setAttribute("ExamenesGenerados",ExamenesGenerados_DAO.findAll());
                request.setAttribute("Pregunta",Pregunta_DAO.findAll());
                request.getRequestDispatcher("Pregunta_add.jsp").forward(request, response);
                break;
            default:
                
        }
        
 }


protected void contenido(Document pdfExamen,Document clave,ExamenesGenerados examen){
   Set<ExamenPregunta> todas = examen.getExamenPreguntas();
   numPre =0;
   for(ExamenPregunta x:todas){
       try {
           pdfExamen.add(new Paragraph(numPre+"-. "+x.getPregunta().getDescripcionPregunta()+" "+x.getPuntaje()+"Pts"));
           clave.add(new Paragraph(numPre+"-. "+x.getPregunta().getDescripcionPregunta()+" "+x.getPuntaje()+"Pts"));
           numPre++;
           if(x.getPregunta().getTipoPregunta().equals("VF")){
                    pdfExamen.add(new Paragraph("a) Verdadero"));
                    pdfExamen.add(new Paragraph("b) Falso"));
                    clave.add(new Paragraph("a) Verdadero"));
                    clave.add(new Paragraph("b) Falso"));
             }else{
                 if(x.getPregunta().getTipoPregunta().equals("Acompletar")){
                    pdfExamen.add(new Paragraph("a)________________")); 
                    clave.add(new Paragraph("a)________________")); 
                 }else{
                        Set <Respuestas> set  = x.getPregunta().getRespuestases();
                        int a=0;
                        for(Respuestas r:set){
                            if(r.getTipoResp().equals("Correcta")){
                                pdfExamen.add(new Paragraph(letras[a]+") "+r.getDescripcionRespuesta()));    
                                clave.add(new Paragraph(letras[a]+") "+r.getDescripcionRespuesta(),correcta));    
                            }else{
                                pdfExamen.add(new Paragraph(letras[a]+") "+r.getDescripcionRespuesta()));    
                                clave.add(new Paragraph(letras[a]+") "+r.getDescripcionRespuesta()));    
                            }
                            a++;
                        }
                        pdfExamen.add(new Paragraph("\n"));
                        clave.add(new Paragraph("\n"));
                 }
           }  
        } catch (DocumentException ex) {
                                
    }     
   }
}

protected void encabezado(Document pdfExamen,ExamenesGenerados examen){
    
    try {
       Paragraph titulo = new Paragraph("UNIVERSIDAD VERACRUZANA", catFont);
       titulo.setAlignment(Paragraph.ALIGN_CENTER);
        pdfExamen.add(titulo);
        titulo = new Paragraph(examen.getPeriodo(), smallBold);
        titulo.setAlignment(Paragraph.ALIGN_CENTER);
        pdfExamen.add(titulo);
        titulo = new Paragraph("Examen "+examen.getTipoExamen(), smallBold);
        titulo.setAlignment(Paragraph.ALIGN_CENTER);
        pdfExamen.add(titulo);
        titulo = new Paragraph(examen.getExperieciaEducativa().getNombreEe(),smallBold);
         titulo.setAlignment(Paragraph.ALIGN_CENTER);
        pdfExamen.add(titulo);
        pdfExamen.add(new Paragraph("Porcentajes : Teoria "+examen.getPorcTeoria() + "%  Practica "+examen.getPorcPractica()+" %",smallBold));
        pdfExamen.add(new Paragraph("Profesor: ________________________________________________________________________ ",smallBold));
        pdfExamen.add(new Paragraph("Alumno: __________________________________________________________________________ ",smallBold));
        pdfExamen.add(new Paragraph(" ",smallBold));
    } catch (DocumentException ex) {
                                
    } 
}



protected List preguntasDisponibles(int id, List <Pregunta> actuales){ 
    List <Pregunta> resultado = new ArrayList(); 
    PreguntaDAO preDao = new PreguntaDAO();
    List <Pregunta> preTotales = preDao.findAll(); 
    ExamenPreguntaDAO exaGe = new ExamenPreguntaDAO(); 
    List <ExamenPregunta> totExa = exaGe.findAll(); 
    for(ExamenPregunta aux:totExa){ 
        if(aux.getExamenesGenerados().getIdexamenesGenerados().equals(id)){ 
            int y = aux.getPregunta().getIdPregunta();
            for(Pregunta todas:preTotales){ 
                if((todas.getIdPregunta().equals(y))&&(todas.getEstado().equals("Aprobado"))){ 
                    resultado.add(todas); 
                } 
            } 
        } 
    } 
    return resultado; 
}

//Mostrar preguntas 
protected List preguntasList(int id){ 
    List <Pregunta> resultado = new ArrayList(); 
    PreguntaDAO preDao = new PreguntaDAO(); 
    List <Pregunta> preTotales = preDao.findAll();
    ExamenPreguntaDAO exaGe = new ExamenPreguntaDAO();
    List <ExamenPregunta> totExa = exaGe.findAll();
    for(ExamenPregunta aux:totExa){ 
        if(aux.getExamenesGenerados().getIdexamenesGenerados().equals(id)){ 
            int y = aux.getPregunta().getIdPregunta(); 
            for(Pregunta todas:preTotales){
                if(todas.getIdPregunta().equals(y)){ 
                    resultado.add(todas); 
                } 
            } 
        } 
    } 
    return resultado; 
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