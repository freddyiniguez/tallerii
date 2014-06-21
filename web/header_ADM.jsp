<%@include file="header.jsp" %>
    <%
        if (session.getAttribute("user") == null) {
            session.setAttribute("name", "No ha iniciado sesión");
        } else {
            session.setAttribute("name", session.getAttribute("user") + " (" + session.getAttribute("rol") + ")");
        }
    %>
    <body>
        <div class="row clearfix">
            <div class="col-md-12 column">
                <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">GEDUV</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span>
                        </button> <a class="navbar-brand" href="/tallerii">GED UV Admin view</a>
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
                                    <a href="AcademiaController">Academia</a>
                                </li>
                                <li>
                                    <a href="CarreraAcademiaController">CarreraAcademias</a>
                                </li>
                                <li>
                                    <a href="CarreraController">Carrera</a>
                                </li>
                                <li>
                                    <a href="ExperieciaEducativaController">ExperienciaEducativa</a>
                                </li>
                                <li>
                                    <a href="ImparteController">Imparte</a>
                                </li>
                                <li>
                                    <a href="PersonalController">Personal</a>
                                </li>
                                <li>
                                    <a href="UsuariosController">Usuarios</a>
                                </li>
                                <li>
                                    <a href="ExamenPreguntaController">ExamenPregunta</a>
                                </li>

                            </ul>
                            <hr>

                            </div>
                            <div class="col-md-10 column">
