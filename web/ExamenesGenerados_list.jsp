<%@include file="header.jsp" %>
<a href="ExamenesGeneradosController?accion=agregar" class="btn btn-primary">Agregar a ExamenesGenerados</a>
<table class="table table-striped">
  <c:forEach items="${list}" var="item">
    <tr>
      <td><c:out value="${item.idexamenesGenerados}"/></td>
      <td><c:out value="${item.periodo}"/></td>
      <td><c:out value="${item.tipoExamen}"/></td>
      <td><c:out value="${item.fechaCreacion}"/></td>
      <td><c:out value="${item.descripcionExamen}"/></td>
      <td><c:out value="${item.porcTeoria}"/></td>
      <td><c:out value="${item.porcPractica}"/></td>
      <td><c:out value="${item.estadoExamen}"/></td>
      <td><c:out value="${item.personal.nombreProfesor}"/></td>
      <td><c:out value="${item.experieciaEducativa.nombreEe}"/></td>
      <td><a class="btn btn-danger toDelete" data-toggle="modal" data-target="#myModal" id="ExamenesGeneradosController?accion=borrar&id=${item.idexamenesGenerados}" href="#">Borrar</a></td>
      <td><a class="btn btn-warning" href="ExamenesGeneradosController?accion=buscar&id=${item.idexamenesGenerados}">Editar</a></td>
    </tr>
  </c:forEach>
</table>
<%@include file="footer.jsp" %>