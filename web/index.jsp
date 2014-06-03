<%    if ((session.getAttribute("user") == null)) {
        request.getRequestDispatcher("login_.jsp").forward(request, response);
    } else {

    }
%>

<%@include file="header.jsp" %>
Bienvenido al sistema!
<%@include file="footer.jsp" %>