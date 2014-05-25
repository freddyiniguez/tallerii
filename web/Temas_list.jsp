<%@include file="header.jsp" %>
<a href="TemasController?accion=agregar" class="btn btn-primary">Agregar a Temas</a>
<table class="table table-striped">
  <c:forEach items="${list}" var="item">
    <tr>
      <td><c:out value="${item.idTema}"/></td>
      <td><c:out value="${item.nombreTema}"/></td>
      <td><c:out value="${item.temas.nombreTema}"/></td>
      <td><c:out value="${item.unidades.nombreUnidad}"/></td>
      <td><a class="btn btn-danger toDelete" data-toggle="modal" data-target="#myModal" id="TemasController?accion=borrar&id=${item.idTema}" href="#">Borrar</a></td>
      <td><a class="btn btn-warning" href="TemasController?accion=buscar&id=${item.idTema}">Editar</a></td>
    </tr>
  </c:forEach>
</table>
<%@include file="footer.jsp" %>