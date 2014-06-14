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

La accion se realizo correctamente <br>
<a class="btn btn-success" href="${url}">Ok</a>
<%@include file="footer.jsp" %>

