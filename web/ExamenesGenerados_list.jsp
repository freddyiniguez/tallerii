<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% if(session.getAttribute("rol")=="Coordinador"){  
%>  
<jsp:include page="header_COORD.jsp" flush="true" /> 
<%}%> 

<% if(session.getAttribute("rol")=="Profesor"){  
%>  
<jsp:include page="header_PROF.jsp" flush="true" /> 
<%}%>

<%--<%    if ((session.getAttribute("user") == null)) {
        request.getRequestDispatcher("login_.jsp").forward(request, response);
    } else {

    }
    if (session.getAttribute("rol").equals("Administrador")) {
        request.getRequestDispatcher("index.jsp").forward(request, response);
        }
%>--%>

<h2>Lista de Ex�menes</h2>
<a href="ExamenesGeneradosController?accion=agregar" class="btn btn-primary">Agregar Examen</a>
<div align="center" style="border: 1px; color: white; background-color:#00AB4F;" id="NavTabla"></div>
<table id="tabla" class="table table-striped sortable">
  
    
    <td>Tipo de ex�men</td>
    <td>Experiencia educativa</td>
    <td>Periodo (Semestre)</td>
    <td>Profesor que lo cre�</td>
    <td>Fecha de creaci�n</td>
    <td>Descripci�n</td>
    <td>% Teor�a</td>
    <td>% Pr�ctica</td>
    <td>Estado</td>
    
    <td class="unsortable">Borrar</td>
    <td class="unsortable">Editar</td>
    <td class="unsortable">EditarPreguta</td>
    
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
      <td><a class="btn btn-warning" href="ExamenesGeneradosController?accion=buscar&id=${item.idexamenesGenerados}">Examen</a></td>
      <td><a class="btn btn-success" href="ExamenPreguntaController?idEx=${item.idexamenesGenerados}">Preguntas</a></td>
    </tr>
  </c:forEach>
</table>
<div align = "center" style="border: 1px; color: white; background-color:#00AB4F;" id="NavTabla2"></div>
<%@include file="footer.jsp" %>