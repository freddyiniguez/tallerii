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

<h2><B><center>Edición de la asignación de preguntas a examen</center></b></h2>
<form action="ExamenPreguntaController?accion=actualizar" method="POST">
<input type="hidden" value="${ExamenPregunta.idExamenPregunta}" name="id">
<input type="hidden" value="${ExamenPregunta.examenesGenerados.idexamenesGenerados}" name="id_examen">
<table class="table table-striped">
    <thead>
        <tr>
            <td>seleccion</td>
            <td>Tema</td>
            <td>Pregunta</td>
            <td>Respuestas
            </td>
            <td>Complejidad</td>
        </tr>
    </thead>
<c:forEach items="${Pregunta}" var="item">
    <tbody>
        <tr>
            <td><input type="radio" name="pregunta" value="${item.idPregunta}"</td>
            <td>${item.temas.nombreTema}</td>
            <td>${item.descripcionPregunta}</td>
            <td>
                <c:forEach items="${item.respuestases}" var="respuesta">
                    R: ${respuesta.descripcionRespuesta}
                    <c:if test="${respuesta.tipoResp=='Correcta'}">
                        *
                    </c:if>
                    <br>
                </c:forEach>
            </td>
            <td>${item.complejidadPregunta}</td>
        </tr>
    </tbody>
</c:forEach>
</table>
<input type="submit" class="btn btn-primary" value="cambiar">
</form>
<%@include file="footer.jsp" %>