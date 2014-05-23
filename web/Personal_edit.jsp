<%@include file="header.jsp" %>
<h1>Registro de Carreras </h1>
        <form action="PersonalController" method="POST">
        	<input type="hidden" name="idPersonal" value="${Personal.idPersonal}" />
            
                                    <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-2 control-label" for="numeroPersonal">Numero de personal<span class="required">*</span></label>
                                    <div class="col-sm-10">  
                                    <input required class ="form-control" id="numeroPersonal" type="number" name="numeroPersonal" value="${Personal.numeroPersonal}"  />
                                    </div>
                                    </div>
                                    

                                    <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-2 control-label" for="nombreProfesor">Nombre del profesor<span class="required">*</span></label>
                                    <div class="col-sm-10">  
                                    <input required class ="form-control" id="nombreProfesor" type="text" name="nombreProfesor" value="${Personal.nombreProfesor}"  />
                                    </div>
                                    </div>
                                    
            
            <div class="col-md-12 ">
				<div class="pull-right">
					<input type="submit" class="btn btn-primary" name="accion" value="actualizar" />
				</div>
			</div>
        </form>
        
<%@include file="footer.jsp" %>