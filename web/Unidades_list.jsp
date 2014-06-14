<%@include file="header.jsp" %>
<a href="UnidadesController?accion=agregar" class="btn btn-primary">Agregar a Unidades</a>
<table class="table table-striped">
  
    
    <td>Nombre de la unidad</td>
    <td>Experiencia educativa</td>
    <td>Borrar</td>
    <td>Editar</td>
    
    <c:forEach items="${list}" var="item">
    <tr>
      
      <td><c:out value="${item.nombreUnidad}"/></td>
      <td><c:out value="${item.experieciaEducativa.nombreEe}"/></td>
      <td><a class="btn btn-danger toDelete" data-toggle="modal" data-target="#myModal" id="UnidadesController?accion=borrar&id=${item.idUnidad}" href="#">Borrar</a></td>
      <td><a class="btn btn-warning" href="UnidadesController?accion=buscar&id=${item.idUnidad}">Editar</a></td>
    </tr>
  </c:forEach>
</table>
<%@include file="footer.jsp" %>