<%@include file="header_ADM.jsp" %>
 <form action="ExamenesGeneradosController?accion=examen" method="POST">
<table id="tabla"  class="table table-striped sortable">
    <input type="hidden" name="examen" value="${examen.idexamenesGenerados}">
    ${ee.nombreEe}
    <td>Subtemas</td>
    <c:forEach items="${ee.unidadeses}" var="item">
        <c:forEach items="${item.temases}" var="tema">
        <tr>
            <td>
            <input type="checkbox" name="tema" value="${tema.idTema}">${tema.nombreTema}<br>
            </td>
        </tr>
        </c:forEach>
  </c:forEach>
</table>
<input type="submit" value="Generar">
</form>
<%@include file="footer.jsp" %>