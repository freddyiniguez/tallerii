<%@include file="header_ADM.jsp" %>

<%--<%    if ((session.getAttribute("user") == null)) {
        request.getRequestDispatcher("login_.jsp").forward(request, response);
    } else {

    }
    if (!session.getAttribute("rol").equals("Administrador")) {
        request.getRequestDispatcher("index.jsp").forward(request, response);
        }
%>--%>
<h2>Lista de Experiencias Educativas</h2>
<a href="ExperieciaEducativaController?accion=agregar" class="btn btn-primary">Agregar Experiencia Educativa</a>
<div align="center" style="border: 1px; color: white; background-color:#00AB4F;" id="NavTabla"></div>
<table id="tabla"  class="table table-striped sortable">
  
    <td>Experiencia educativa</td>
    <td>Academia a la que pertenece</td>
    <td class="unsortable">Borrar</td>
    <td class="unsortable">Editar</td>
    
    <c:forEach items="${list}" var="item">
    <tr>
        <td><c:out value="${item.nombreEe}"/></td>
        <td><c:out value="${item.academia.nombreAcademia}"/></td>
      <td><a class="btn btn-danger toDelete" data-toggle="modal" data-target="#myModal" id="ExperieciaEducativaController?accion=borrar&id=${item.idExperieciaEducativa}" href="#">Borrar</a></td>
      <td><a class="btn btn-warning" href="ExperieciaEducativaController?accion=buscar&id=${item.idExperieciaEducativa}&id2=${item.academia.idAcademia}">Editar</a></td>
    </tr>
  </c:forEach>
</table>
<div align = "center" style="border: 1px; color: white; background-color:#00AB4F;" id="NavTabla2"></div>
<%@include file="footer.jsp" %>