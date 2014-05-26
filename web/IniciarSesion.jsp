<%-- 
    Document   : IniciarSesion
    Created on : 16/05/2014, 10:39:26 AM
    Author     : CRISTHIAN
--%>
<%    if ((session.getAttribute("user") != null)) {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    } else {

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
            <td>contraseña</td>
            <td><input name="password" type="text"></td>
        </tr>
        <tr>
            <td>&nbsp;</td>
            <td><input name="Submit1" type="submit" value="Iniciar sesión"></td>
        </tr>
    </table>
</form>

<div class="clearfix"></div>
<div class="form-group">
    <label class="col-sm-2 control-label" for="loginUsuario">Usuario<span class="required">*</span></label>
    <div class="col-sm-10">  
        <input required class ="form-control" id="loginUsuario" type="text" name="loginUsuario" value=""  />
    </div>
</div>

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
            alert("Debe escribir su contraseña");
            return false;
        }
    }
</script>


<%@include file="footer.jsp" %>

