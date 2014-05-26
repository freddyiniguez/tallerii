<%@include file="header.jsp" %>
<a href="PreguntaController?accion=agregar" class="btn btn-primary">Agregar a Pregunta</a>
<div class="row">
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
<%@include file="footer.jsp" %>