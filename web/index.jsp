<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Registro de Carreras </h1>
         <jsp:include page="gatito.jsp" />
        <form action="CarreraController" method="POST">
            <table border="0">
                <tbody>
                    <tr>
                        <td>Nombre de la carrera</td>
                        <td><input type="text" name="nombreCarrera" value="" /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Insertar" /></td>
                    </tr>
                </tbody>
            </table>

        </form>
    </body>
</html>