<%-- 
    Document   : logout
    Created on : 25/05/2014, 04:36:34 PM
    Author     : CRISTHIAN
--%>
cerrar sesion
<% session.invalidate();
        request.getRequestDispatcher("login_.jsp").forward(request, response);
            
%>