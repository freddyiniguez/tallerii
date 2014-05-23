<%@include file="header.jsp" %>
<a href="RolesController?accion=agregar" class="btn btn-primary">Agregar a Roles</a>
<table class="table table-striped">
  <c:forEach items="${list}" var="item">
    <tr>
      <td><c:out value="${item.idRol}"/></td>
      <td><c:out value="${item.nombreRol}"/></td>,<td><c:out value="${item.descripcionRol}"/></td>
      <td><a class="btn btn-danger" href="RolesController?accion=borrar&id=${item.idRol}">Borrar</a></td>
      <td><a class="btn btn-warning" href="RolesController?accion=buscar&id=${item.idRol}">Editar</a></td>
    </tr>
  </c:forEach>
</table>
<%@include file="footer.jsp" %>