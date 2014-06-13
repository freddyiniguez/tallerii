<%@include file="header.jsp" %>
<a href="ImparteController?accion=agregar" class="btn btn-primary">Agregar a Imparte</a>
<table class="table table-striped">
 
    <td>Experiencia educativa</td>
    <td>Profesor</td>
    <td>Borrar</td>
    <td>Editar</td>
    
    <c:forEach items="${list}" var="item">
    <tr>
      <td><c:out value="${item.experieciaEducativa.nombreEe}"/></td>
      <td><c:out value="${item.personal.nombreProfesor}"/></td>
      <td><a class="btn btn-danger toDelete" data-toggle="modal" data-target="#myModal" id="ImparteController?accion=borrar&id=${item.idImparte}" href="#">Borrar</a></td>
      <td><a class="btn btn-warning" href="ImparteController?accion=buscar&id=${item.idImparte}">Editar</a></td>
    </tr>
  </c:forEach>
</table>
<%@include file="footer.jsp" %>