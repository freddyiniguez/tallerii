<%    if ((session.getAttribute("user") == null)) {
        request.getRequestDispatcher("IniciarSesion.jsp").forward(request, response);
    } else {

    }
%>

<%@include file="header.jsp" %>
Bienvenido al sistema!
<%@include file="footer.jsp" %>