<%@include file="header_ADM.jsp" %>

<%    if ((session.getAttribute("user") == null)) {
        request.getRequestDispatcher("login_.jsp").forward(request, response);
    } else {

    }
    if (!session.getAttribute("rol").equals("Administrador")) {
        request.getRequestDispatcher("index.jsp").forward(request, response);
        }
%>

<h1><B><center>Registro de carrera </center></b></h1>
        <form action="CarreraController" method="POST">
        
                                    <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-2 control-label" for="nombreCarrera">Nombre de la carrera<span class="required">*</span></label>
                                    <div class="col-sm-10">  
                                    <input required class ="form-control" id="nombreCarrera" type="text" name="nombreCarrera" value="" maxlength="60" />
                                    </div>
                                    </div>
                                    <h5><p align="right"><font color="red">El campo que est� marcado con * es obligatorio para el registro  </font>  </p> </h5>
        <div class="col-md-12 ">
			<div class="pull-right">
				<input type="submit" class="btn btn-primary" name ="accion" value="insertar">
			</div>
		</div>
        </form>
<%@include file="footer.jsp" %>