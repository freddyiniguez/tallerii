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
<table class="table table-striped">
    <thead>
        <tr>
          <th>Aprobar</th>
          <th>Numero Pregunta</th>
          <th>Tema</th>        
          <th>Descripcion Pregunta</th>        
          <th>Estado</th>
          <th>Pts.</th>         
          <th>Respuestas</th>
        </tr>
    </thead>
 <c:forEach items="${list}" var="item">
    <tr>
      <td><input type="checkbox" value="${item.idPregunta}" name="aprobar"></td>
      <td><c:out value="${item.idPregunta}"/></td>
      <td><c:out value="${item.temas.nombreTema}"/></td>
      <td><c:out value="${item.descripcionPregunta}"/></td>
      <td><c:out value="${item.estado}"/></td>
      <td><c:out value="${item.puntuacionPregunta}"/></td>
      <td>
          <c:forEach items="${item.respuestases}" var="respuesta">
              R: ${respuesta.descripcionRespuesta}<br>
          </c:forEach>
      </td>
    </tr>
  </c:forEach>
</table>

  

 <div class="col-md-12 ">
        <div class="pull-right">
                <input type="submit" class="btn btn-primary" name ="accion" value="aprobar">
        </div>
</div>
</form>
<%@include file="footer.jsp" %>