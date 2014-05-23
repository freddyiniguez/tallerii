<%@include file="header.jsp" %>
<h1>Registro de Carreras </h1>
        <form action="CarreraController" method="POST">
        	<input type="hidden" name="idCarrera" value="${Carrera.idCarrera}" />
            
                                    <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-2 control-label" for="nombreCarrera">Nombre de la carrera<span class="required">*</span></label>
                                    <div class="col-sm-10">  
                                    <input required class ="form-control" id="nombreCarrera" type="text" name="nombreCarrera" value="${Carrera.nombreCarrera}"  />
                                    </div>
                                    </div>
                                    
            
            <div class="col-md-12 ">
				<div class="pull-right">
					<input type="submit" class="btn btn-primary" name="accion" value="actualizar" />
				</div>
			</div>
        </form>
        
<%@include file="footer.jsp" %>