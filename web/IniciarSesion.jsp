<%-- 
    Document   : IniciarSesion
    Created on : 16/05/2014, 10:39:26 AM
    Author     : CRISTHIAN
--%>
<%    if ((session.getAttribute("user") != null)) {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    } 
    if (session.getAttribute("estado")==null) {
               session.setAttribute("estado", "");
            }
%>

<%@include file="header.jsp" %>

<table style="width: 100%">
    <tr>
        <td><center><h1>Iniciar sesion</h1></center></td>
</tr>
</table>

<br>

<form name="Flogin" method="post" action="LoginController" onsubmit="return validateForm()">

    <table style="width: 100%">
        <tr>
            <td>usuario</td>
            <td><input name="usuario" type="text"  onchange=""></td>
        </tr>
        <tr>
            <td>contrase�a</td>
            <td><input name="password" type="password"></td>
        </tr>
        <tr>
            <td>&nbsp;</td>
            <td><input name="Submit1" type="submit" value="Iniciar sesi�n"></td>
        </tr>
        <tr>
            <td colspan="2"><center><%= session.getAttribute("estado")%></center></td>
        </tr>
    </table>
</form>


<script type="text/javascript" >
    function validateForm()
    {
        var user = document.Flogin.usuario.value;
        var pass = document.Flogin.password.value;

        if ((user == null || user == "") && (pass == null || pass == "")) {
            alert("Debe llenar todos los campos");
            return false;
        } else
        if ((user == null || user == "")) {
            alert("Debe escribir su nombre de usuario");
            return false;
        } else
        if (pass == null || pass == "") {
            alert("Debe escribir su contraseÃ±a");
            return false;
        }
    }
</script>


<%@include file="footer.jsp" %>

