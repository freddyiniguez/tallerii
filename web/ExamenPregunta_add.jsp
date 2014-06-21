<%@include file="header_ADM.jsp" %>
<form method="POST">
    <div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<h3>
				Agregar Preguntas a examen
			</h3>
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
		</div>
		<div class="col-md-6 column">
		</div>
		<div class="col-md-4 column">
			 <button type="button" class="btn btn-success">Agregar</button>
		</div>
	</div>
</div>
</form>
<%@include file="footer.jsp" %>