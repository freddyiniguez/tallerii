<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta http-equiv="content-type" content="text/html; charset=UTF-8">
        <title>GED UV</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <link href="${pageContext.request.contextPath}/assets/css/bootstrap.css" rel="stylesheet"/>
        <script src="${pageContext.request.contextPath}/assets/js/jquery.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/bootstrap.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/sortable.js"></script>
        <style>
        <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/paging.js"></script>
        <style>
            body {
                padding-top: 70px;
            }
        </style>
    </head>
    <%
        if (session.getAttribute("user") == null) {
            session.setAttribute("name", "No ha iniciado sesión");
        } else {
            session.setAttribute("name", session.getAttribute("user")+" ("+session.getAttribute("rol")+")");
        }
    %>
    <body>
        <div class="row clearfix">
            <div class="col-md-12 column">
                <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">GEDUV</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span>
                        </button> <a class="navbar-brand" href="/tallerii">GED UV Coord view</a>
                    </div>

                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

                        <ul class="nav navbar-nav navbar-right">
                            <li>
                                <a href="#"><%= session.getAttribute("name")%></a>
                            </li>
                            <li>
                                <a href="logout.jsp">Cerrar sesión</a>
                            </li>
                        </ul>
                    </div>

                </nav>
            </div>
        </div>
        <div class="container">
            <div class="row clearfix">
                <div class="col-md-2 column">
                    <hr>
                    <ul class="list-unstyled">
                        <li class="nav-header">
                            <a href="#" data-toggle="collapse" data-target="#administrar">
                                <h5>Gestionar<i class="glyphicon glyphicon-chevron-right"></i></h5>
                            </a>
                            <ul class="list-unstyled collapse in" id="administrar">

                                <li>
                                    <a href="TemasController">Temas</a>
                                </li>
                                <li>
                                    <a href="UnidadesController">Unidades</a>
                                </li>
                                
                                <li>
                                    <a href="PreguntaController">Preguntas</a>
                                </li>
                                <li>
                                    <a href="ExamenesGeneradosController">Examenes</a>
                                </li>
                                <li class="nav-header">
                                    <a href="#" data-toggle="collapse" data-target="#examenes">
                                        <h5>Examenes<i class="glyphicon glyphicon-chevron-right"></i></h5>
                                    </a>
                                    <ul class="list-unstyled collapse in" id="examenes">
                                        
                                        <li><a href="http://sus.bittsys.com//Statico/GenerarExamen">Generar examen</a>
                                        </li>
                                    </ul>
                                </li>
                            </ul>
                            <hr>

                </div>
                <div class="col-md-10 column">
