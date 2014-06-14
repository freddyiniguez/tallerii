<%@include file="header.jsp" %>
<a href="ExperieciaEducativaController?accion=agregar" class="btn btn-primary">Agregar a ExperieciaEducativa</a>
<table class="table table-striped">
  
    <td>Experiencia educativa</td>
    <td>Academia a la que pertenece</td>
    <td>Borrar</td>
    <td>Editar</td>
    
    <c:forEach items="${list}" var="item">
    <tr>
        <td><c:out value="${item.nombreEe}"/></td>
        <td><c:out value="${item.academia.nombreAcademia}"/></td>
      <td><a class="btn btn-danger toDelete" data-toggle="modal" data-target="#myModal" id="ExperieciaEducativaController?accion=borrar&id=${item.idExperieciaEducativa}" href="#">Borrar</a></td>
      <td><a class="btn btn-warning" href="ExperieciaEducativaController?accion=buscar&id=${item.idExperieciaEducativa}">Editar</a></td>
    </tr>
  </c:forEach>
</table>
<%@include file="footer.jsp" %>