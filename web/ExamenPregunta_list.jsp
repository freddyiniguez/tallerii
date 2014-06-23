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
		<div class="col-md-12 column">
		<div align="center" style="border: 1px; color: white; background-color:#00AB4F;" id="NavTabla"></div>
                <form action="ExamenPreguntaController" method="POST">
                <table class="table">
				<thead>
				  <tr>
                                    <th>seleccionar</th>        
                                    <th>Tema</th> 
                                    <th>Pregunta</th>
                                    <th>Respuestas</th>
                                    <th>Pts.</th>      
                                  </tr>
				</thead>
				<tbody>
					<c:forEach items="${Examen.examenPreguntas}" var="item">
					    <tr>
					      <td>
                                                  <input type="radio" value="${item.idExamenPregunta}" name="pregunta">
                                               </td>
                                              <td>
                                                  ${item.pregunta.temas.nombreTema}
                                              </td>
                                              <td>${item.pregunta.descripcionPregunta}</td>
                                              <td>
                                                  <c:forEach items="${item.pregunta.respuestases}" var="respuesta">
                                                      
                                                      R: ${respuesta.descripcionRespuesta}
                                                      <c:if test="${respuesta.tipoResp == 'Correcta'}">
                                                          *
                                                      </c:if>
                                                      <br>
                                                      
                                                  </c:forEach>
                                              </td>
                                              <td>${item.puntaje}</td>
					    </tr>
  					</c:forEach>
						
				</tbody>
			</table>
                    <input type="hidden" name="accion" value="buscar">
                    <div class="col-md-6 column">
                    </div>
                    <div class="col-md-4 column">
                        <input type="submit" class="btn btn-warning" value="editar">
                    </div>
                    </form>	
			<div align = "center" style="border: 1px; color: white; background-color:#00AB4F;" id="NavTabla2"></div>
		</div>
	</div>
                <div class="row clearfix">
		<div class="col-md-2 column">
		<a href="ExamenesGeneradosController" class="btn btn-default">Regresar a Examenes Generados</a>
		</div>
		
	</div>
</div>
<%@include file="footer.jsp" %>
