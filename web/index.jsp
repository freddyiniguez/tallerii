<% if(session.getAttribute("rol")=="Administrador"){  
%>  
<jsp:include page="header_ADM.jsp" flush="true" /> 
<%}%>  

<% if(session.getAttribute("rol")=="Coordinador"){  
%>  
<jsp:include page="header_COORD.jsp" flush="true" /> 
<%}%> 

<% if(session.getAttribute("rol")=="Profesor"){  
%>  
<jsp:include page="header_PROF.jsp" flush="true" /> 
<%}%>

<%    if ((session.getAttribute("user") == null)) {
        request.getRequestDispatcher("login_.jsp").forward(request, response);
    } else {

    }
%>

Bienvenido al sistema!
<br>
<%="id de usuario= "+session.getAttribute("idusuario")%>
<br>
<%="rol= "+session.getAttribute("rol")%>
<br>
<%="id de academia= "+session.getAttribute("academia")%>
<br>

<table id="tabla" class="table table-striped sortable">
 
    <td>Profesor</td>
    <td>Experiencia educativa que imparte</td>
    <td class="unsortable">Borrar</td>
    <td class="unsortable">Editar</td>
    
    <c:forEach items="${session.getAttribute("matslist")}" var="item">
    <tr>
      <td><c:out value="${item.idExperieciaEducativa}"/></td>
      <td><c:out value="${item.nombreEe}"/>  </td>
      <td><a class="btn btn-danger toDelete" data-toggle="modal" data-target="#myModal" id="ImparteController?accion=borrar&id=${item.idImparte}" href="#">Borrar</a></td>
      <td><a class="btn btn-warning" href="ImparteController?accion=buscar&id=${item.idImparte}">Editar</a></td>
    </tr>
  </c:forEach>
</table>
    <select name="tabla1" id="tabla1">
    <% 
      java.util.ArrayList<edu.uv.model.pojos.ExperieciaEducativa> list = (java.util.ArrayList)session.getAttribute("matslist");
      if(list!=null)
      for(edu.uv.model.pojos.ExperieciaEducativa en:list){
      %>
      
      <option value=<%= en.getIdExperieciaEducativa()%> > <%= en.getNombreEe()%> </option >
    
      <%};%>
       
    </select>
      
  
      
    
    

<%@include file="footer.jsp" %>