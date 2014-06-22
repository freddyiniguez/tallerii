<%@include file="header_ADM.jsp" %>
<div class="row">
 <form action="ExamenesGeneradosController?accion=examen" method="POST">
    <input type="hidden" name="examen" value="${examen.idexamenesGenerados}">
    <h4>Escoja los temas que desea incluir en su examen de la Experiencia 
    ${ee.nombreEe}</h4>
    <c:forEach items="${ee.unidadeses}" var="item">
        <c:forEach items="${item.temases}" var="tema">
            <c:if test="${tema.temas != null}">
                <label><input type="checkbox" name="tema" value="${tema.idTema}" style="margin-left:6px;">${tema.nombreTema}</label><br>
            </c:if>
            <c:if test="${tema.temas == null}">
                </div>
                <div class="grupo">
                    <label><input type="checkbox" id="select_all" name="tema_1" value="${tema.idTema}">${tema.nombreTema}</label><br>
               
            </c:if>
        </c:forEach>
  </c:forEach>
                </div>
<input type="submit" value="Generar">
</form>
</div>
<script>
        $(document).on('change','#select_all',function() {
            console.log("ok");
            var checkboxes = $(this).closest('.grupo').find(':checkbox');
            if($(this).is(':checked')) {
                checkboxes.prop('checked',true);
            } else {
                checkboxes.prop('checked',false);
            }
        });
</script>
<%@include file="footer.jsp" %>