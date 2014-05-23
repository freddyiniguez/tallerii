<%@include file="header.jsp" %>
<a href="AcademiaController?accion=agregar" class="btn btn-primary">Agregar a Academia</a>
<table class="table table-striped">
  <c:forEach items="${list}" var="item">
    <tr>
      <td><c:out value="${item.idAcademia}"/></td>
      <td><c:out value="${item.nombreAcademia}"/></td>
      <!--Esta linea también se agregó-->
      <td><c:out value="${item.personal.nombreProfesor}"/></td>
      
      <td><a class="btn btn-danger" href="AcademiaController?accion=borrar&id=${item.idAcademia}">Borrar</a></td>
      <td><a class="btn btn-warning" href="AcademiaController?accion=buscar&id=${item.idAcademia}">Editar</a></td>
    </tr>
  </c:forEach>
</table>
<%@include file="footer.jsp" %>