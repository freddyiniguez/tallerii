<%@include file="header_ADM.jsp"%>
<h2>Lista de Examenes</h2>
<a href="ExamenPreguntaController?accion=agregar" class="btn btn-primary">Agregar Preguntas a Examen</a>
<div align="center" style="border: 1px; color: white; background-color:#00AB4F;" id="NavTabla"></div>
<table id="tabla" class="table table-striped sortable">
 
    <td>Puntaje</td>
    <td>Tipo Examen</td>
    <td>Preguntas</td>
    <td class="unsortable">Borrar</td>
    <td class="unsortable">Editar</td>
    
    <c:forEach items="${list}" var="item">
    <tr>
      <td><c:out value="${item.puntaje}"/></td>
      <td><c:out value="${item.examenesGenerados.descripcionExamen}"/></td>
      <td><c:out value="${item.preguntas.descripcionPregunta}"/></td>
      <td><a class="btn btn-danger toDelete" data-toggle="modal" data-target="#myModal" id="ExamenPreguntaController?accion=borrar&id=${item.idExamenPregunta}" href="#">Borrar</a></td>
      <td><a class="btn btn-warning" href="ExamenPreguntaController?accion=buscar&id=${item.idExamenPregunta}">Editar</a></td>
    </tr>
  </c:forEach>
</table>
<div align = "center" style="border: 1px; color: white; background-color:#00AB4F;" id="NavTabla2"></div>
<%@include file="footer.jsp" %>
