<%@include file="header_ADM.jsp" %>

<%    if ((session.getAttribute("user") == null)) {
        request.getRequestDispatcher("login_.jsp").forward(request, response);
    } else {

    }
    if (!session.getAttribute("rol").equals("Administrador")) {
        request.getRequestDispatcher("index.jsp").forward(request, response);
        }
%>

<h2>Lista de academias</h2>
<a href="AcademiaController?accion=agregar" class="btn btn-primary">Agregar a Academia</a>


<div align="center" style="border: 1px; color: white; background-color:#00AB4F;" id="NavTabla"></div>
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
       <td><a class="btn btn-warning" href="AcademiaController?accion=buscar&id=${item.idAcademia}&id2=${item.personal.idPersonal}">Editar</a></td>
    </tr>
  </c:forEach>
</table>
<div align = "center" style="border: 1px; color: white; background-color:#00AB4F;" id="NavTabla2"></div>
<%@include file="footer.jsp" %>