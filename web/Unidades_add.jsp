<%--<%@include file="header_COORD.jsp" %>--%>

<%--<%    if ((session.getAttribute("user") == null)) {
        request.getRequestDispatcher("login_.jsp").forward(request, response);
    } else {

    }
    if (!session.getAttribute("rol").equals("Coordinador")) {
        request.getRequestDispatcher("index.jsp").forward(request, response);
        }
%>--%>
<% if(session.getAttribute("rol")=="Coordinador"){  
%>  
<%@include file="header_COORD.jsp" %>
<%}%> 

<% if(session.getAttribute("rol")=="Profesor"){  
%>  
<%@include file="header_PROF.jsp" %> 
<%}%>

<h1><B><center>Registro de unidades </center></b></h1>
        <form action="UnidadesController" method="POST">
            <div id="unidades">
                <div id="uni">
        
                                    <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-3 control-label" for="ExperieciaEducativa_idExperieciaEducativa">Experiencia educativa:<span class="required">*</span></label>
                                    
                                    <div class="col-sm-12">
                                      <div class="input-group">
                                      <select class="form-control" name="Ee">
                                        <% 
                                      java.util.ArrayList<edu.uv.model.pojos.ExperieciaEducativa> list = (java.util.ArrayList)session.getAttribute("matslist");
                                      if(list!=null)
                                      for(edu.uv.model.pojos.ExperieciaEducativa en:list){
                                      %>
 
                                      <option value=<%= en.getIdExperieciaEducativa()%> > <%= en.getNombreEe()%> </option >

                                      <%};%>
                                       </select>
                                       <span class="input-group-btn">
                                        <a class="btn btn-primary" href="#"><span class="glyphicon glyphicon-question-sign"></span></a>
                                       </span>
                                       </div>
                                    </div>

                                    </div>
                                    

                                    <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-3 control-label" for="nombreUnidad">Nombre de la unidad:<span class="required">*</span></label>
                                    <div class="col-sm-12">  
                                    <input required class ="form-control" id="nombreUnidad" type="text" name="nombreUnidad" value=""  />
                                    </div>
                                    </div>
                                    <h5><p align="right"><font color="red">Los campos que están marcados con * son obligatorios para el registro.  </font>  </p> </h5>
                </div>
            </div>
            <br>

            <a href="#" id="agregarU" class="btn btn-success" > Agregar Unidad</a>
                                    
        <div class="col-md-12 ">
			<div class="pull-right">
				<input type="submit" class="btn btn-primary" name ="accion" value="insertar">
			</div>
		</div>
        </form>
<script>
    
        $(document).ready(function(){
         $("#agregarU").click(function(){
           var unidad = $("#uni").clone();
           
           $(unidad).appendTo("#unidades");
           console.log("ok");
           
         });
        });
</script>
<%@include file="footer.jsp" %>
