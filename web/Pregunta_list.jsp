<% if(session.getAttribute("rol")=="Coordinador"){  
%>  
<jsp:include page="header_COORD.jsp" flush="true" /> 
<%}%> 

<% if(session.getAttribute("rol")=="Profesor"){  
%>  
<jsp:include page="header_PROF.jsp" flush="true" /> 
<%}%>
 
<%    if ((session.getAttribute("user") == null)) {
        request.getRequestDispatcher("login_.jsp").forward(request, response);
    } else {

    }
    if (session.getAttribute("rol").equals("Administrador")) {
        request.getRequestDispatcher("index.jsp").forward(request, response);
        }
%>
<h2>Lista de Preguntas</h2>
<a href="#" class="btn btn-primary" data-toggle="modal" data-target="#modalExp">Agregar Pregunta</a>
<div align="center" style="border: 1px; color: white; background-color:#00AB4F;" id="NavTabla"></div>
<div class="row">
    
    <td>Id pregunta</td>
    <td>Estado de la pregunta</td>
    <td>Tema al que pertenece</td>
    <td>Tipo de pregunta</td>
    <td>Modalidad pregunta</td>
    <td>Complejidad de la pregunta</td>
    <td>Puntuación</td>
    <td class="unsortable">Borrar</td>
    <td class="unsortable">Editar</td>
    
<c:forEach items="${list}" var="item">
    
    <div class="row clearfix">
		<div class="col-md-12 column">
			<div class="row clearfix">
				<div class="col-md-3 column">
                                    id: <c:out value="${item.idPregunta}"/><br>
                                    Estado: <c:out value="${item.estado}"/><br>
				</div>
				<div class="col-md-3 column">
                                    Tema: <c:out value="${item.temas.nombreTema}"/>
				</div>
				<div class="col-md-3 column">
                                    Tipo de pregunta: <c:out value="${item.tipoPregunta}"/> <br>
				</div>
				<div class="col-md-3 column">
                                    Modalidad: <c:out value="${item.modalidadPregunta}"/><br>
                                    Complejidad: <c:out value="${item.complejidadPregunta}"/><br>
                                    Puntuacion: <c:out value="${item.puntuacionPregunta}"/><br>
				</div>
			</div>
		</div>
                <div class="col-md-12 column">
                Pregunta: <br>
                <c:out value="${item.descripcionPregunta}"/><br>
                Respuestas:<br><br>
                <table class="table">
                <c:forEach items="${item.respuestases}" var="respuesta">
                    <tr>
                        <td>${respuesta.descripcionRespuesta}</td>
                        <td>${respuesta.tipoResp}</td>
                    </tr>
                </c:forEach>
                </table>
                <br>
                Comentarios: <br>
                <c:out value="${item.comentRetroalimentacion}"/><br>
                 <a class="btn btn-danger" href="PreguntaController?accion=borrar&id=${item.idPregunta}">Borrar</a>
                 <a class="btn btn-warning" href="PreguntaController?accion=buscar&id=${item.idPregunta}">Editar</a>
               </div>
	</div>
        <hr>
  </c:forEach>
</div>
<!-- Modal elegir pregunta -->
<div class="modal fade" id="modalExp" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel">Seleccione Experiencia Educativa</h4>
      </div>
        <h5> Selecciona una Experiencia Educativa<span class="label label-default">;)</span></h5>
      <div class="modal-body">
        
          
        <div class="list-group">
            
            <select class="form-control"  id="mySelect">
                                        <% 
                                      java.util.ArrayList<edu.uv.model.pojos.ExperieciaEducativa> list = (java.util.ArrayList)session.getAttribute("matslist");
                                      if(list!=null)
                                      for(edu.uv.model.pojos.ExperieciaEducativa en:list){
                                      %>
 
                                      <option value=<%= en.getIdExperieciaEducativa()%> > <%= en.getNombreEe()%> </option >

                                      <%};%>
             </select>   
          
            
        

        </div>
        
        
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
        <button type="button" class="btn btn-default" onclick="redirect()">Agregar</button>
        
        
      </div>
    </div>
  </div>
</div>
<div align = "center" style="border: 1px; color: white; background-color:#00AB4F;" id="NavTabla2"></div>

<script>
       function redirect(){
        
	var x = document.getElementById("mySelect").selectedIndex;
	var y = document.getElementById("mySelect").options;
        var z = document.getElementById("mySelect").valueOf(x).toString();
	location.replace("PreguntaController?accion=agregar&idEE="+y[x].value);

        }
      </script>
      
      
<%@include file="footer.jsp" %>
