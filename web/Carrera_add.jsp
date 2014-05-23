<%@include file="header.jsp" %>
        <form action="CarreraController" method="POST">
        
                                    <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-2 control-label" for="nombreCarrera">Nombre de la carrera<span class="required">*</span></label>
                                    <div class="col-sm-10">  
                                    <input required class ="form-control" id="nombreCarrera" type="text" name="nombreCarrera" value=""  />
                                    </div>
                                    </div>
                                    
        <div class="col-md-12 ">
			<div class="pull-right">
				<input type="submit" class="btn btn-primary" name ="accion" value="insertar">
			</div>
		</div>
        </form>
<%@include file="footer.jsp" %>