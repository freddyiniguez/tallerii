<%@include file="header_ADM.jsp" %>

<%    if ((session.getAttribute("user") == null)) {
        request.getRequestDispatcher("login_.jsp").forward(request, response);
    } else {

    }
    if (!session.getAttribute("rol").equals("Administrador")) {
        request.getRequestDispatcher("index.jsp").forward(request, response);
        }
%>
<h2>Lista de Carrera-Academia</h2>
<a href="CarreraAcademiaController?accion=agregar" class="btn btn-primary">Agregar a CarreraAcademia</a>
<div align="center" style="border: 1px; color: white; background-color:#00AB4F;" id="NavTabla"></div>
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
      <td><a class="btn btn-warning" href="CarreraAcademiaController?accion=buscar&id=${item.idCarreraAcademia}&id2=${item.academia.idAcademia}&id3=${item.carrera.idCarrera}">Editar</a></td>
    </tr>
  </c:forEach>
</table>
<div align = "center" style="border: 1px; color: white; background-color:#00AB4F;" id="NavTabla2"></div>
<%@include file="footer.jsp" %>