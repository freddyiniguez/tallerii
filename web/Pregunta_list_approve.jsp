<%@include file="header.jsp" %>
<a href="PreguntaController?accion=aprobar" class="btn btn-primary">Aprobar Preguntas</a>
<table class="table table-striped">
  <c:forEach items="${list}" var="item">
    <tr>
      <td><input type="checkbox" value="${item.idPregunta}" name="aprobar"></td>
      <td><c:out value="${item.idPregunta}"/></td>
      <td><c:out value="${item.temas.nombreTema}"/></td>
      <td><c:out value="${item.tipoPregunta}"/></td>
      <td><c:out value="${item.descripcionPregunta}"/></td>
      <td><c:out value="${item.modalidadPregunta}"/></td>
      <td><c:out value="${item.complejidadPregunta}"/></td>
      <td><c:out value="${item.estado}"/></td>
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
<%@include file="footer.jsp" %>