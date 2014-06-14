<%@include file="header.jsp" %>
<a href="ExamenesGeneradosController?accion=agregar" class="btn btn-primary">Agregar a ExamenesGenerados</a>
<table id="tabla" class="table table-striped sortable">
  
    
    <td>Tipo de exámen</td>
    <td>Experiencia educativa</td>
    <td>Periodo (Semestre)</td>
    <td>Profesor que lo creó</td>
    <td>Fecha de creación</td>
    <td>Descripción</td>
    <td>% Teoría</td>
    <td>% Práctica</td>
    <td>Estado</td>
    
    <td class="unsortable">Borrar</td>
    <td class="unsortable">Editar</td>
    
    <c:forEach items="${list}" var="item">
    <tr>
      
      <td><c:out value="${item.tipoExamen}"/></td>
      <td><c:out value="${item.experieciaEducativa.nombreEe}"/></td>
      <td><c:out value="${item.periodo}"/></td>
      <td><c:out value="${item.personal.nombreProfesor}"/></td>
      <td><c:out value="${item.fechaCreacion}"/></td>
      <td><c:out value="${item.descripcionExamen}"/></td>
      <td><c:out value="${item.porcTeoria}"/></td>
      <td><c:out value="${item.porcPractica}"/></td>
      <td><c:out value="${item.estadoExamen}"/></td>
      
      
      <td><a class="btn btn-danger toDelete" data-toggle="modal" data-target="#myModal" id="ExamenesGeneradosController?accion=borrar&id=${item.idexamenesGenerados}" href="#">Borrar</a></td>
      <td><a class="btn btn-warning" href="ExamenesGeneradosController?accion=buscar&id=${item.idexamenesGenerados}">Editar</a></td>
    </tr>
  </c:forEach>
</table>
<%@include file="footer.jsp" %>