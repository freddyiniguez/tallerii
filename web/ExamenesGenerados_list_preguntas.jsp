<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% if(session.getAttribute("rol")=="Coordinador"){  
%>  
<jsp:include page="header_COORD.jsp" flush="true" /> 
<%}%> 

<% if(session.getAttribute("rol")=="Profesor"){  
%>  
<jsp:include page="header_PROF.jsp" flush="true" /> 
<%}%>

<h2>Examen Generado con éxito</h2>

<a class="btn btn-primary" href="${pageContext.request.contextPath}/assets/examen.pdf">Descargar examen </a>
<a class="btn btn-primary" href="${pageContext.request.contextPath}/assets/clave.pdf">Descargar clave</a>
<div align = "center" style="border: 1px; color: white; background-color:#00AB4F;" id="NavTabla2"></div>
<%@include file="footer.jsp" %>