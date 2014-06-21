<%@include file="header_ADM.jsp"%>
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<h3>
				Lista de Preguntas del Examen
			</h3>
		</div>
	</div>
	<div class="row clearfix">
		<div class="col-md-8 column">
			 <button type="button" class="btn btn-danger">Eliminar preguntas</button>
		</div>
		<div class="col-md-4 column">
		</div>
	</div>
	<div class="row clearfix">
		<div class="col-md-12 column">
		<div align="center" style="border: 1px; color: white; background-color:#00AB4F;" id="NavTabla"></div>
			<table class="table">
				<thead>
					<tr>
			          <th>Aprobar</th>
			          <th>Numero Pregunta</th>
			          <th>Tema</th>        
			          <th>Descripcion Pregunta</th>        
			          <th>Estado</th>
			          <th>Pts.</th>         
			          <th>Respuestas</th>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="item">
					    <tr>
					      <td><input type="checkbox" value="${item.idPregunta}" name="aprobar"></td>
					      <td><c:out value="${item.idPregunta}"/></td>
					      <td><c:out value="${item.temas.nombreTema}"/></td>
					      <td><c:out value="${item.descripcionPregunta}"/></td>
					      <td><c:out value="${item.estado}"/></td>
					      <td><c:out value="${item.puntuacionPregunta}"/></td>
					      <td>
					          <c:forEach items="${item.respuestases}" var="respuesta">
					              R: ${respuesta.descripcionRespuesta}<br>
					          </c:forEach>
					      </td>
					    </tr>
  					</c:forEach>
						
				</tbody>
			</table>
			<div align = "center" style="border: 1px; color: white; background-color:#00AB4F;" id="NavTabla2"></div>
		</div>
	</div>
	<div class="row clearfix">
		<div class="col-md-2 column">
			 <button href="ExamenesGeneradosController" type="button" class="btn btn-default">Regresar a Examenes Generados</button>
		</div>
		<div class="col-md-6 column">
		</div>
		<div class="col-md-4 column">
			 <button type="button" class="btn btn-info">Borrar</button> <button type="button" class="btn btn-danger" href="ExamenesGeneradosController?accion=agregar">Agregar Preguntas</button>
		</div>
	</div>
</div>
<%@include file="footer.jsp" %>
