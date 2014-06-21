<%@include file="header_ADM.jsp" %>
<h2>Lista de Experiencias Educativas</h2>
<a href="ExperieciaEducativaController?accion=agregar" class="btn btn-primary">Agregar Experiencia Educativa</a>
<div align="center" style="border: 1px; color: white; background-color:#00AB4F;" id="NavTabla"></div>
<table id="tabla"  class="table table-striped sortable">
  
    <td>Experiencia educativa</td>
    <c:forEach items="${ExperieciaEducativa}" var="item">
    <tr>
        <td><a href="ExamenesGeneradosController?accion=temas&id=${item.idExperieciaEducativa}"><c:out value="${item.nombreEe}"/></a></td>
    </tr>
  </c:forEach>
</table>
<div align = "center" style="border: 1px; color: white; background-color:#00AB4F;" id="NavTabla2"></div>
<%@include file="footer.jsp" %>