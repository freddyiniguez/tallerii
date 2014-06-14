<%@include file="header.jsp" %>
<a href="PersonalController?accion=agregar" class="btn btn-primary">Agregar a Personal</a>
<table id="tabla" class="table table-striped sortable">
  
    <td>N�mero de personal</td>
    <td>Nombre del profesor</td>
    <td class="unsortable">Borrar</td>
    <td class="unsortable">Editar</td>
    
    <c:forEach items="${list}" var="item">
    <tr>
      <td><c:out value="${item.numeroPersonal}"/></td>
      <td><c:out value="${item.nombreProfesor}"/></td>
      <td><a class="btn btn-danger toDelete" data-toggle="modal" data-target="#myModal" id="PersonalController?accion=borrar&id=${item.idPersonal}" href="#">Borrar</a></td>
      <td><a class="btn btn-warning" href="PersonalController?accion=buscar&id=${item.idPersonal}">Editar</a></td>
    </tr>
  </c:forEach>
</table>
<%@include file="footer.jsp" %>