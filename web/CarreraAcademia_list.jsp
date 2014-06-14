<%@include file="header_ADM.jsp" %>

<%    if ((session.getAttribute("user") == null)) {
        request.getRequestDispatcher("login_.jsp").forward(request, response);
    } else {

    }
    if (!session.getAttribute("rol").equals("Administrador")) {
        request.getRequestDispatcher("index.jsp").forward(request, response);
        }
%>

<a href="CarreraAcademiaController?accion=agregar" class="btn btn-primary">Agregar a CarreraAcademia</a>
<table id="tabla" class="table table-striped sortable">
  
    <td>Carrera</td>
    <td>Academias que la conforman</td>
    <td class="unsortable">Borrar</td>
    <td class="unsortable">Editar</td>
    
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