<%    if ((session.getAttribute("user") == null)) {
        request.getRequestDispatcher("login_.jsp").forward(request, response);
    } else {

    }
%>

<%@include file="header.jsp" %>
Bienvenido al sistema!
<br>
<%="id de usuario= "+session.getAttribute("idusuario")%>
<br>
<%="rol= "+session.getAttribute("rol")%>
<br>
<%="id de academia= "+session.getAttribute("academia")%>
<br>
<%@include file="footer.jsp" %>