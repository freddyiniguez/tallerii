<%@include file="header_COORD.jsp" %>

<%    if ((session.getAttribute("user") == null)) {
        request.getRequestDispatcher("login_.jsp").forward(request, response);
    } else {

    }
    if (!session.getAttribute("rol").equals("Coordinador")) {
        request.getRequestDispatcher("index.jsp").forward(request, response);
        }
%>

<form action="PreguntaController" method="POST">  
<div class="container">
<div class="row clear">
		<div class="col-md-2 column">
			# pregunta
		</div>
		<div class="col-md-4 column">
			Tema
		</div>
		<div class="col-md-4 column">
			Pregunta
		</div>
		<div class="col-md-2 column">
			Estado
		</div>
</div>
<c:forEach items="${list}" var="item">
	<div class="row clear">
		<div class="col-md-2 column">
			<input disabled="true" id="idP" name="idP2" value="${item.idPregunta}"/>
		</div>
		<div class="col-md-4 column">
			<c:out value="${item.temas.nombreTema}"/>
		</div>
		<div class="col-md-4 column">
			<c:out value="${item.descripcionPregunta}"/>
		</div>
		<div class="col-md-2 column">
			<select name="aprobado2" id="aprobado">
                            <option value="NoAprobado">NoAprobado</option>
                            <option value="Aprobado">Aprobado</option>	
                        </select>
		</div>
	</div>
</c:forEach>

    </div>

 <div class="col-md-12 ">
        <div class="pull-right">
                <input type="submit" class="btn btn-primary" name ="accion" value="aprobar">
        </div>
</div>
</form>
<%@include file="footer.jsp" %>