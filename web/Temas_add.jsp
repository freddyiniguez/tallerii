<%@include file="header.jsp" %>
<h1><B><center>Registro de temas </center></b></h1>
        <form action="TemasController" method="POST">
            
                                    <div id="unidades">
	<div id="uni">
            <br> <br>
		<div class="clearfix"></div>
                                 <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-3 control-label" for="Unidades_idUnidad">Nombre de la unidad:<span class="required">*</span></label>
                                    
                                    <div class="col-sm-12">
                                    <div class="input-group">
                                    <select class="form-control" name="unidad">
                                    <c:forEach items="${Unidades}" var="item">
                                            

                                            <% 
                                            
                                            
                                            %>
                                                <option value="${item.idUnidad}">${item.nombreUnidad}</option>
                                        </c:forEach>
                                       </select>
                                       <span class="input-group-btn">
                                        <a class="btn btn-primary" href="#"><span class="glyphicon glyphicon-question-sign"></span></a>
                                       </span>
                                       </div>
                                    </div>

                                    </div>

                                    <div class="form-group">
                                    <label class="col-sm-3 control-label" for="nombreTema">Nombre del tema:<span class="required">*</span></label>
                                    <div class="col-sm-12">  
                                    <input required class ="form-control" id="nombreTema" type="text" name="nombreTema" value=""  />
                                    </div>
                                    </div>
                                    

                                    <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-3 control-label" for="Temas_idTema">Nombre del subtema: <span class="required">*</span></label>
                                    
                                    <div class="col-sm-12">
                                      <div class="input-group">
                                      <select class="form-control" name="tema">
                                      <option value=""></option>
                                        <c:forEach items="${Temas}" var="item">
                                                <option value="${item.idTema}">${item.nombreTema}</option>
                                        </c:forEach>
                                       </select>
                                       <span class="input-group-btn">
                                        <a class="btn btn-primary" href="#"><span class="glyphicon glyphicon-question-sign"></span></a>
                                       </span>
                                       </div>
                                    </div>

                                    </div>
	</div>
	<h5><p align="right"><font color="red">Los campos que est�n marcados con * son obligatorios para el registro.  </font>  </p> </h5>
</div>                         
        <div class="col-md-12 ">
			<div class="pull-right">
				<input type="submit" class="btn btn-primary" name ="accion" value="insertar">
			</div>
		</div>
        </form>
<script>
    
        $(document).ready(function(){
         $("#agregarU").click(function(){
           var unidad = $("#uni").clone();
           
           $(unidad).appendTo("#unidades");
           console.log("ok");
           
         });
        });
        </script>
<%@include file="footer.jsp" %>