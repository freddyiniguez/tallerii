<%@include file="header.jsp" %>
<a href="PreguntaController?accion=agregar" class="btn btn-primary">Agregar a Pregunta</a>
<table class="table table-striped">
  <c:forEach items="${list}" var="item">
    <tr>
      <td><c:out value="${item.idPregunta}"/></td>
      <td><c:out value="${item.temas.nombreTema}"/></td>
      <td><c:out value="${item.tipoPregunta}"/></td>
      <td><c:out value="${item.descripcionPregunta}"/></td>
      <td><c:out value="${item.modalidadPregunta}"/></td>
      <td><c:out value="${item.complejidadPregunta}"/></td>
      <td><c:out value="${item.puntuacionPregunta}"/></td>
      <td><c:out value="${item.comentRetroalimentacion}"/></td>
      <td><a class="btn btn-danger" href="PreguntaController?accion=borrar&id=${item.idPregunta}">Borrar</a></td>
      <td><a class="btn btn-warning" href="PreguntaController?accion=buscar&id=${item.idPregunta}">Editar</a></td>
    </tr>
  </c:forEach>
</table>
<%@include file="footer.jsp" %>