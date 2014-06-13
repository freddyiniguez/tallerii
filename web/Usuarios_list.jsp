<%@include file="header.jsp" %>
<a href="UsuariosController?accion=agregar" class="btn btn-primary">Agregar a Usuarios</a>
<table class="table table-striped">
  
    <td>Usuario</td>
    <td>Rol</td>
    <td>Estado</td>
    <td>Profesor</td>
    <td>Borrar</td>
    <td>Editar</td>
    
    <c:forEach items="${list}" var="item">
    <tr>
      <td><c:out value="${item.loginUsuario}"/></td>
      <td><c:out value="${item.rol}"/></td>
      <td><c:out value="${item.estadoUsuario}"/></td>
      <td><c:out value="${item.personal.nombreProfesor}"/></td>
      <td><a class="btn btn-danger toDelete" data-toggle="modal" data-target="#myModal" id="UsuariosController?accion=borrar&id=${item.idUsuario}" href="#">Borrar</a></td>
      <td><a class="btn btn-warning" href="UsuariosController?accion=buscar&id=${item.idUsuario}">Editar</a></td>
    </tr>
  </c:forEach>
</table>
<%@include file="footer.jsp" %>