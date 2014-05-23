<%@include file="header.jsp" %>
<a href="CarreraAcademiaController?accion=agregar" class="btn btn-primary">Agregar a CarreraAcademia</a>
<table class="table table-striped">
  <c:forEach items="${list}" var="item">
    <tr>
      <td><c:out value="${item.idCarreraAcademia}"/></td>
      <td><c:out value="${item.Carrera_idCarrera}"/></td>,<td><c:out value="${item.Academia_idAcademia}"/></td>
      <td><a class="btn btn-danger" href="CarreraAcademiaController?accion=borrar&id=${item.idCarreraAcademia}">Borrar</a></td>
      <td><a class="btn btn-warning" href="CarreraAcademiaController?accion=buscar&id=${item.idCarreraAcademia}">Editar</a></td>
    </tr>
  </c:forEach>
</table>
<%@include file="footer.jsp" %>