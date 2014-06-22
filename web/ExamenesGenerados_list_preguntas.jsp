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

<table>
    <td>
        <c:forEach items="${listaExamenPregunta}" var="item">
            <c:out value="${item.pregunta.descripcionPregunta}"/>
            <c:out value="${item.puntaje}"/>
            <br>
        </c:forEach>
    </td>
</table>
<a href="${pageContext.request.contextPath}/assets/examen.pdf">Descargar </a>
<div align = "center" style="border: 1px; color: white; background-color:#00AB4F;" id="NavTabla2"></div>
<%@include file="footer.jsp" %>