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

<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <h3>
                Lista de Preguntas del Examen 
            </h3>
        </div>
    </div>

    <div class="row clearfix">
        <div class="col-md-12 column">
            <form action="ExamenPreguntaController" method="POST">
            <div class="row">
                    <div class="col-md-4"><input type="submit" class="btn btn-warning " value="Cambiar pregunta"></div>
            </div>
            <div align="center" style="border: 1px; color: white; background-color:#00AB4F;" id="NavTabla"></div>
            
                <table class="table">
                    <c:set var="counter" value="1" />
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>seleccionar</th>        
                            <th>Tema</th> 
                            <th>Pregunta</th>
                            <th>Respuestas</th>
                            <th>Pts.</th>      
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${Examen.examenPreguntas}" var="item">
                            <tr>
                                <td>${counter}</td>
                                <td>
                                    <input type="radio" value="${item.idExamenPregunta}" name="pregunta">
                                </td>
                                <td>
                                    ${item.pregunta.temas.nombreTema}
                                </td>
                                <td>${item.pregunta.descripcionPregunta}</td>
                                <td>
                                    <c:forEach items="${item.pregunta.respuestases}" var="respuesta">

                                        R: ${respuesta.descripcionRespuesta}
                                        <c:if test="${respuesta.tipoResp == 'Correcta'}">
                                            *
                                        </c:if>
                                        <br>

                                    </c:forEach>
                                </td>
                                <td>${item.puntaje}</td>
                            </tr>
                            <c:set var="counter" value="${counter+1}" />  
                        </c:forEach>

                    </tbody>
                </table>
                <input type="hidden" name="accion" value="buscar">
                
            </form>	
            <div align = "center" style="border: 1px; color: white; background-color:#00AB4F;" id="NavTabla2"></div>
        </div>
    </div>
</div>
<%@include file="footer.jsp" %>
