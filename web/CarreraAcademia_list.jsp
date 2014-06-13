<%@include file="header.jsp" %>
<a href="CarreraAcademiaController?accion=agregar" class="btn btn-primary">Agregar a CarreraAcademia</a>
<table class="table table-striped">
  
    <td>Carrera</td>
    <td>Academia</td>
    <td>Borrar</td>
    <td>Editar</td>
    
    <c:forEach items="${list}" var="item">
    <tr>
      <td><c:out value="${item.carrera.nombreCarrera}"/></td>
      <td><c:out value="${item.academia.nombreAcademia}"/></td>
      <td><a class="btn btn-danger toDelete" data-toggle="modal" data-target="#myModal" id="CarreraAcademiaController?accion=borrar&id=${item.idCarreraAcademia}" href="#">Borrar</a></td>
      <td><a class="btn btn-warning" href="CarreraAcademiaController?accion=buscar&id=${item.idCarreraAcademia}">Editar</a></td>
    </tr>
  </c:forEach>
</table>
<%@include file="footer.jsp" %>