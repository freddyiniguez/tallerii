<%@include file="header_COORD.jsp" %>

<%    if ((session.getAttribute("user") == null)) {
        request.getRequestDispatcher("login_.jsp").forward(request, response);
    } else {

    }
    if (!session.getAttribute("rol").equals("Coordinador")) {
        request.getRequestDispatcher("index.jsp").forward(request, response);
        }
%>

<form action="PreguntaController" method="POST">  
<table class="table table-striped">
    <thead>
        <tr>
          <th>Numero Pregunta</th>
          <th>Tema</th>
          <th>Tipo de pregunta</th>
          <th>Descripcion Pregunta</th>
          <th>Modalidad Pregunta</th>
          <th>Complejidad de la pregunta</th>
          <th>Estado</th>
          <th>Putuacion</th>
          <th>Retroalimentacion</th>
          <th>Respuestas</th>
        </tr>
    </thead>
  <c:forEach items="${list}" var="item">
    <tr>
      
      <td><c:out value="${item.idPregunta}"/></td>
      <td><c:out value="${item.temas.nombreTema}"/></td>
      <td><c:out value="${item.tipoPregunta}"/></td>
      <td><c:out value="${item.descripcionPregunta}"/></td>
      <td><c:out value="${item.modalidadPregunta}"/></td>
      <td><c:out value="${item.complejidadPregunta}"/></td>
      <td>	
        <select name="aprobado" id="aprobado">
            <option value="${item.idPregunta}">NoAprobado</option>
            <option value="${item.idPregunta}">Aprobado</option>	
        </select></td>
      <td><c:out value="${item.puntuacionPregunta}"/></td>
      <td><c:out value="${item.comentRetroalimentacion}"/></td>
      <td>
          <c:forEach items="${item.respuestases}" var="respuesta">
              R: ${respuesta.descripcionRespuesta}<br>
          </c:forEach>
      </td>
    </tr>
  </c:forEach>
</table>
</form>
<a href="PreguntaController?accion=aprobar" class="btn btn-primary">Aprobar Preguntas</a>
<%@include file="footer.jsp" %>