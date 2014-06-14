<%@include file="header_COORD.jsp" %>

<%    if ((session.getAttribute("user") == null)) {
        request.getRequestDispatcher("login_.jsp").forward(request, response);
    } else {

    }
    if (!session.getAttribute("rol").equals("Coordinador")) {
        request.getRequestDispatcher("index.jsp").forward(request, response);
        }
%>

<a href="UnidadesController?accion=agregar" class="btn btn-primary">Agregar a Unidades</a>
<table id="tabla" class="table table-striped sortable">
  
    
    <td>Nombre de la unidad</td>
    <td>Experiencia educativa</td>
    <td class="unsortable">Borrar</td>
    <td class="unsortable">Editar</td>
    
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