<%@include file="header.jsp" %>
<h1>Registro de Carreras </h1>
        <form action="RolesController" method="POST">
        	<input type="hidden" name="idRol" value="${Roles.idRol}" />
            
                                    <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-2 control-label" for="nombreRol">Nombre del rol<span class="required">*</span></label>
                                    <div class="col-sm-10">  
                                    <input required class ="form-control" id="nombreRol" type="text" name="nombreRol" value="${Roles.nombreRol}"  />
                                    </div>
                                    </div>
                                    

                                    <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-2 control-label" for="descripcionRol">Descripción del rol<span class="required">*</span></label>
                                    <div class="col-sm-10">                                
                                    <textarea required class="form-control" id="descripcionRol" name="descripcionRol">${Roles.descripcionRol}</textarea>
                                    </div>
                                    </div>
                                    
            
            <div class="col-md-12 ">
				<div class="pull-right">
					<input type="submit" class="btn btn-primary" name="accion" value="actualizar" />
				</div>
			</div>
        </form>
        
<%@include file="footer.jsp" %>