<%@include file="header_ADM.jsp" %>

<%--<%    if ((session.getAttribute("user") == null)) {
        request.getRequestDispatcher("login_.jsp").forward(request, response);
    } else {

    }
    if (!session.getAttribute("rol").equals("Administrador")) {
        request.getRequestDispatcher("index.jsp").forward(request, response);
        }
%>--%>
<h2>Lista de Imparte</h2>
<a href="ImparteController?accion=agregar" class="btn btn-primary">Agregar Imparte</a>
<div align="center" style="border: 1px; color: white; background-color:#00AB4F;" id="NavTabla"></div>
<table id="tabla" class="table table-striped sortable">
 
    <td>Profesor</td>
    <td>Experiencia educativa que imparte</td>
    <td class="unsortable">Borrar</td>
    <td class="unsortable">Editar</td>
    
    <c:forEach items="${list}" var="item">
    <tr>
      <td><c:out value="${item.personal.nombreProfesor}"/></td>
      <td><c:out value="${item.experieciaEducativa.nombreEe}"/></td>
      <td><a class="btn btn-danger toDelete" data-toggle="modal" data-target="#myModal" id="ImparteController?accion=borrar&id=${item.idImparte}" href="#">Borrar</a></td>
      <td><a class="btn btn-warning" href="ImparteController?accion=buscar&id=${item.idImparte}">Editar</a></td>
    </tr>
  </c:forEach>
</table>
<div align = "center" style="border: 1px; color: white; background-color:#00AB4F;" id="NavTabla2"></div>
<%@include file="footer.jsp" %>