<%--<%@include file="header_COORD.jsp" %>--%>

<%--<%    if ((session.getAttribute("user") == null)) {
        request.getRequestDispatcher("login_.jsp").forward(request, response);
    } else {

    }
    if (!session.getAttribute("rol").equals("Coordinador")) {
        request.getRequestDispatcher("index.jsp").forward(request, response);
        }
%>--%>
<% if(session.getAttribute("rol")=="Coordinador"){  
%>  
<%@include file="header_COORD.jsp" %>
<%}%> 

<% if(session.getAttribute("rol")=="Profesor"){  
%>  
<%@include file="header_PROF.jsp" %> 
<%}%>

<h2>Lista de Unidades</h2>
<% if(session.getAttribute("rol")!="Profesor"){  
       %>  
<a href="UnidadesController?accion=agregar" class="btn btn-primary">Agregar Unidades</a>
<%}%> 
<div align="center" style="border: 1px; color: white; background-color:#00AB4F;" id="NavTabla"></div>
<table id="tabla" class="table table-striped sortable">
  
    
    <td>Nombre de la unidad</td>
    <td>Experiencia educativa</td>
    <% if(session.getAttribute("rol")!="Profesor"){  
       %>  
    <td class="unsortable">Borrar</td>
    <td class="unsortable">Editar</td>
    <%}%> 
    
    <c:forEach items="${list}" var="item">
    <tr>
      
      <td><c:out value="${item.nombreUnidad}"/></td>
      <td><c:out value="${item.experieciaEducativa.nombreEe}"/></td>
      
      <% if(session.getAttribute("rol")!="Profesor"){  
       %>  
        <td><a class="btn btn-danger toDelete" data-toggle="modal" data-target="#myModal" id="UnidadesController?accion=borrar&id=${item.idUnidad}" href="#">Borrar</a></td>
      <td><a class="btn btn-warning" href="UnidadesController?accion=buscar&id=${item.idUnidad}">Editar</a></td>
    <%}%> 
      
    </tr>
  </c:forEach>
</table>
<div align = "center" style="border: 1px; color: white; background-color:#00AB4F;" id="NavTabla2"></div>
<%@include file="footer.jsp" %>