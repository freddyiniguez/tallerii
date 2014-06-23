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
<!--
<%="id de usuario= "+session.getAttribute("idusuario")%>
<br>
<%="rol= "+session.getAttribute("rol")%>
<br>
<%="id de academia= "+session.getAttribute("academia")%>
<br>
<h3>DEBUG de Materias</h3>
<select name="tabla1" id="tabla1">
 -->
<%@include file="footer.jsp" %>