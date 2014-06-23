<%@include file="header_ADM.jsp" %>
<h2><B><center>Edición de la adignacion de preguntas a examen</center></b></h2>
<form action="ExamenPreguntaController?accion=actualizar" method="POST">
<input type="text" value="${ExamenPregunta.idExamenPregunta}" name="id">
<table class="table table-striped">
    <thead>
        <tr>
            <td>seleccion</td>
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
            <td>${item.descripcionPregunta}</td>
            <td>
                <c:forEach items="${item.respuestases}" var="respuesta">
                    ${respuesta.descripcionRespuesta}
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