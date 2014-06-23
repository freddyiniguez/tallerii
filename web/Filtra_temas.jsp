<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% if(session.getAttribute("rol")=="Coordinador"){  
%>  
<jsp:include page="header_COORD.jsp" flush="true" /> 
<%}%> 

<% if(session.getAttribute("rol")=="Profesor"){  
%>  
<jsp:include page="header_PROF.jsp" flush="true" /> 
<%}%>
<div class="row">
 <form action="ExamenesGeneradosController?accion=examen" method="POST">
    <input type="hidden" name="examen" value="${examen.idexamenesGenerados}">
    <h4>Escoja los temas que desea incluir en su examen de la Experiencia 
    ${ee.nombreEe}</h4>
    <c:forEach items="${ee.unidadeses}" var="item">
        <c:forEach items="${item.temases}" var="tema">
            <c:if test="${tema.temas == null}">
                <div class="grupo">
                    <label><input type="checkbox" id="select_all" name="tema_1" value="${tema.idTema}">${tema.nombreTema}</label><br>

                    <c:forEach items="${tema.temases}" var="subtema">
                        <label>
                            <c:if test="${subtema.preguntas != null}">
                                <input type="checkbox" name="tema" value="${subtema.idTema}" style="margin-left:6px;">
                            </c:if>
                            ${subtema.nombreTema}</label><br>
                    </c:forEach>
                </div>
            </c:if>
        </c:forEach>
  </c:forEach>
                </div>
<input class="btn btn-primary" type="submit" value="Generar">
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