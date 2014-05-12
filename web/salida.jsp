<%-- 
    Document   : salida
    Created on : 12/05/2014, 09:45:27 AM
    Author     : alex
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Control de Carreras</title>
    </head>
    <body>
        <jsp:useBean id="Carrera" scope="request" class="edu.uv.model.pojos.Carrera" />
        
        <h1> Registro <jsp:getProperty name="Carrera" property="nombreCarrera" />
            Agregado </h1>
    </body>
</html>