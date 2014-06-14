<%@include file="header.jsp" %>
<a href="#" class="btn btn-primary" data-toggle="modal" data-target="#modalExp">Agregar a Pregunta</a>
<div class="row">
    
    <td>Id pregunta</td>
    <td>Estado de la pregunta</td>
    <td>Tema al que pertenece</td>
    <td>Tipo de pregunta</td>
    <td>Modalidad pregunta</td>
    <td>Complejidad de la pregunta</td>
    <td>Puntuación</td>
    <td>Borrar</td>
    <td>Editar</td>
    
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
          <c:forEach items="${listaEE}" var="itemE">
              <a href="PreguntaController?accion=agregar&idEE=${itemE.idExperieciaEducativa}" id="" class="list-group-item" >
                <c:out value="${itemE.nombreEe}"/>
              </a>
                  
        
            </c:forEach>

        </div>
        
        
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
        
      </div>
    </div>
  </div>
</div>
<%@include file="footer.jsp" %>
