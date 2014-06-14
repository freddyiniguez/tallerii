<%@include file="header.jsp" %>
<a href="RespuestasController?accion=agregar" class="btn btn-primary">Agregar a Respuestas</a>
<table class="table table-striped">
  
    <td>Respuesta</td>
    <td>Tipo de respuesta</td>
    <td>Pregunta</td>
    <td>Borrar</td>
    <td>Editar</td>
    
    <c:forEach items="${list}" var="item">
    <tr>
      <td><c:out value="${item.descripcionRespuesta}"/></td>
      <td><c:out value="${item.tipoResp}"/></td>
      <td><c:out value="${item.pregunta.descripcionPregunta}"/></td>
      
      <td><a class="btn btn-danger" href="RespuestasController?accion=borrar&id=${item.idRespuesta}">Borrar</a></td>
      <td><a class="btn btn-warning" href="RespuestasController?accion=buscar&id=${item.idRespuesta}">Editar</a></td>
    </tr>
  </c:forEach>
</table>
<%@include file="footer.jsp" %>