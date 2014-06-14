<%@include file="header.jsp" %>
<a href="AcademiaController?accion=agregar" class="btn btn-primary">Agregar a Academia</a>



<table id="tabla" class="table table-striped  sortable">
    <tr class="sortbottom">
    <td>Academias</td>
    <td>Profesores que la conforman</td>
    <td class="unsortable">Borrar</td>
    <td class="unsortable">Editar</td>
    </tr>
    <c:forEach items="${list}" var="item">
    <tr>
      <td><c:out value="${item.nombreAcademia}"/></td>
      <!--Esta linea también se agregó-->
      <td><c:out value="${item.personal.nombreProfesor}"/></td>
      
      <td><a class="btn btn-danger toDelete" data-toggle="modal" data-target="#myModal" id="AcademiaController?accion=borrar&id=${item.idAcademia}" href="#">Borrar</a></td>
      <td><a class="btn btn-warning" href="AcademiaController?accion=buscar&id=${item.idAcademia}">Editar</a></td>
    </tr>
  </c:forEach>
</table>
<%@include file="footer.jsp" %>