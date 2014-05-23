<%@include file="header.jsp" %>
<a href="UnidadesController?accion=agregar" class="btn btn-primary">Agregar a Unidades</a>
<table class="table table-striped">
  <c:forEach items="${list}" var="item">
    <tr>
      <td><c:out value="${item.idUnidad}"/></td>
      <td><c:out value="${item.experieciaEducativa.nombreEe}"/></td>
      <td><c:out value="${item.nombreUnidad}"/></td>
      <td><a class="btn btn-danger" href="UnidadesController?accion=borrar&id=${item.idUnidad}">Borrar</a></td>
      <td><a class="btn btn-warning" href="UnidadesController?accion=buscar&id=${item.idUnidad}">Editar</a></td>
    </tr>
  </c:forEach>
</table>
<%@include file="footer.jsp" %>