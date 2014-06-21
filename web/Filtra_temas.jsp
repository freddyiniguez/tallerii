<%@include file="header_ADM.jsp" %>
    ${ee.nombreEe}
    Experiencia educativa<br>
    <c:forEach items="${list}" var="item">
        <c:out value="${item.nombreUnidad}"/><br>
    
        <c:forEach items="${item.temases}" var="tema">
            ${tema.nombreTema}<br>
        </c:forEach>
  </c:forEach>
<%@include file="footer.jsp" %>