<%@include file="header_ADM.jsp" %>

<%    if ((session.getAttribute("user") == null)) {
        request.getRequestDispatcher("login_.jsp").forward(request, response);
    } else {

    }
    if (!session.getAttribute("rol").equals("Administrador")) {
        request.getRequestDispatcher("index.jsp").forward(request, response);
        }
%>


<h1><B><center>Registro de personal </center></b></h1>
        <form action="PersonalController" method="POST">
        
                                    <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-3 control-label" for="numeroPersonal">N�mero de personal:<span class="required">*</span></label>
                                    <div class="col-sm-12">  
                                    <input required class ="form-control" id="numeroPersonal" type="number" name="numeroPersonal" value=""  />
                                    </div>
                                    </div>
                                    

                                    <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-3 control-label" for="nombreProfesor">Nombre del profesor:<span class="required">*</span></label>
                                    <div class="col-sm-12">  
                                    <input required class ="form-control" id="nombreProfesor" type="text" name="nombreProfesor" value=""  />
                                    </div>
                                    </div>
                                    <h5><p align="right"><font color="red">Los campos que est�n marcados con * son obligatorios para el registro  </font>  </p> </h5>
                                    
        <div class="col-md-12 ">
			<div class="pull-right">
				<input type="submit" class="btn btn-primary" name ="accion" value="insertar">
			</div>
		</div>
        </form>
<%@include file="footer.jsp" %>