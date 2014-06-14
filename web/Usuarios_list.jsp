<%@include file="header_ADM.jsp" %>

<%    if ((session.getAttribute("user") == null)) {
        request.getRequestDispatcher("login_.jsp").forward(request, response);
    } else {

    }
    if (!session.getAttribute("rol").equals("Administrador")) {
        request.getRequestDispatcher("index.jsp").forward(request, response);
        }
%>

<a href="UsuariosController?accion=agregar" class="btn btn-primary">Agregar a Usuarios</a>
<table id="tabla" class="table table-striped sortable">
  
    <td>Id usuario</td>
    <td>Nombre del profesor</td>
    <td>Rol</td>
    <td>Estado</td>
    <td class="unsortable">Borrar</td>
    <td class="unsortable">Editar</td>
    
    <c:forEach items="${list}" var="item">
    <tr>
      <td><c:out value="${item.loginUsuario}"/></td>
      <td><c:out value="${item.personal.nombreProfesor}"/></td>
      <td><c:out value="${item.rol}"/></td>
      <td><c:out value="${item.estadoUsuario}"/></td>
      
      <td><a class="btn btn-danger toDelete" data-toggle="modal" data-target="#myModal" id="UsuariosController?accion=borrar&id=${item.idUsuario}" href="#">Borrar</a></td>
      <td><a class="btn btn-warning" href="UsuariosController?accion=buscar&id=${item.idUsuario}">Editar</a></td>
    </tr>
  </c:forEach>
</table>
<%@include file="footer.jsp" %>