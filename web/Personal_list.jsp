<%@include file="header_ADM.jsp" %>

<%    if ((session.getAttribute("user") == null)) {
        request.getRequestDispatcher("login_.jsp").forward(request, response);
    } else {

    }
    if (!session.getAttribute("rol").equals("Administrador")) {
        request.getRequestDispatcher("index.jsp").forward(request, response);
        }
%>

<a href="PersonalController?accion=agregar" class="btn btn-primary">Agregar a Personal</a>
<div align="center" style="border: 1px; color: white; background-color:#00AB4F;" id="NavTabla"></div>

<table id="tabla" class="table table-striped sortable">
    <td>Nombre del profesor</td>
    <td class="unsortable">Borrar</td>
    <td class="unsortable">Editar</td>
    
    <c:forEach items="${list}" var="item">
    <tr>
      <td><c:out value="${item.nombreProfesor}"/></td>
      <td><a class="btn btn-danger toDelete" data-toggle="modal" data-target="#myModal" id="PersonalController?accion=borrar&id=${item.idPersonal}" href="#">Borrar</a></td>
      <td><a class="btn btn-warning" href="PersonalController?accion=buscar&id=${item.idPersonal}">Editar</a></td>
    </tr>
  </c:forEach>
</table>
<div align="center" style="border: 1px; color: white; background-color:#00AB4F;" id="NavTabla2"></div>

<%@include file="footer.jsp" %>