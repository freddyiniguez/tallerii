<%@include file="header.jsp" %>
<h1><B><center>Edición de personal </center></b></h1>
        <form action="PersonalController" method="POST">
        	<input type="hidden" name="idPersonal" value="${Personal.idPersonal}" />
            
                                    <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-3 control-label" for="numeroPersonal">Número de personal:<span class="required">*</span></label>
                                    <div class="col-sm-12">  
                                    <input required class ="form-control" id="numeroPersonal" type="number" name="numeroPersonal" value="${Personal.numeroPersonal}"  />
                                    </div>
                                    </div>
                                    

                                    <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-3 control-label" for="nombreProfesor">Nombre del profesor:<span class="required">*</span></label>
                                    <div class="col-sm-12">  
                                    <input required class ="form-control" id="nombreProfesor" type="text" name="nombreProfesor" value="${Personal.nombreProfesor}"  />
                                    </div>
                                    </div>
                                    
            <h5><p align="right"><font color="red">Los campos que están marcados con * son obligatorios para la edición. </font>  </p> </h5>
            <div class="col-md-12 ">
				<div class="pull-right">
					<input type="submit" class="btn btn-primary" name="accion" value="actualizar" />
				</div>
			</div>
        </form>
        
<%@include file="footer.jsp" %>