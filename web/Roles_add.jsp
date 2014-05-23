<%@include file="header.jsp" %>
        <form action="RolesController" method="POST">
        
                                    <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-2 control-label" for="nombreRol">Nombre del rol<span class="required">*</span></label>
                                    <div class="col-sm-10">  
                                    <input required class ="form-control" id="nombreRol" type="text" name="nombreRol" value=""  />
                                    </div>
                                    </div>
                                    

                                    <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-2 control-label" for="descripcionRol">Descripción del rol<span class="required">*</span></label>
                                    <div class="col-sm-10">                                
                                    <textarea required class="form-control" id="descripcionRol" name="descripcionRol"></textarea>
                                    </div>
                                    </div>
                                    
        <div class="col-md-12 ">
			<div class="pull-right">
				<input type="submit" class="btn btn-primary" name ="accion" value="insertar">
			</div>
		</div>
        </form>
<%@include file="footer.jsp" %>