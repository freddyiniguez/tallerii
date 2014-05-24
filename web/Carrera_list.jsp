<%@include file="header.jsp" %>
<a href="CarreraController?accion=agregar" class="btn btn-primary">Agregar carrera</a>
<table class="table table-striped">
  <c:forEach items="${list}" var="item">
    <tr>
      <td><c:out value="${item.idCarrera}"/></td>
      <td><c:out value="${item.nombreCarrera}"/></td>
      <td><a class="btn btn-danger toDelete" data-toggle="modal" data-target="#myModal" id="CarreraController?accion=borrar&id=${item.idCarrera}" href="#">Borrar</a></td>
      <td><a class="btn btn-warning" href="CarreraController?accion=buscar&id=${item.idCarrera}">Editar</a></td>
    </tr>
  </c:forEach>
</table>
<%@include file="footer.jsp" %>