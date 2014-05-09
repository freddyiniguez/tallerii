<%-- 
    Document   : salida.jsp
    Created on : 06-may-2014, 21:14:37
    Author     : Angeles
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Control de Carreras</title>
    </head>
    <body>
        <jsp:useBean id="Carrera" scope="request" class="edu.uv.modelo.pojos.Carrera" />
        <h1> Registro <jsp:getProperty name="Carrera" property="nombreCarrera" />
            Agregado </h1>
    </body>
</html>
