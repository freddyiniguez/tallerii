<%@include file="header_ADM.jsp"%>
<h2>Lista de Examenes</h2>
<a href="ExamenPreguntaController?accion=agregar" class="btn btn-primary">Agregar Preguntas a Examen</a>
<div align="center" style="border: 1px; color: white; background-color:#00AB4F;" id="NavTabla"></div>
<table class="table table-striped">
    <thead>
        <tr>
          <th>Aprobar</th>
          <th>Numero Pregunta</th>
          <th>Tema</th>        
          <th>Descripcion Pregunta</th>        
          <th>Estado</th>
          <th>Pts.</th>         
          <th>Respuestas</th>
        </tr>
    </thead>
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
</table>
<div align="center" style="border: 1px; color: white; background-color:#00AB4F;" id="NavTabla2"></div>
<%@include file="footer.jsp" %>
