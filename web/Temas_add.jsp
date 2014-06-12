<%@include file="header.jsp" %>
        <form action="TemasController" method="POST">
            <h3> Experiencia Educativa:   </h3>
            
                                    <div id="unidades">
	<div id="uni">
            <br> <br>
		<div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-2 control-label" for="nombreTema">Nombre del tema<span class="required">*</span></label>
                                    <div class="col-sm-10">  
                                    <input required class ="form-control" id="nombreTema" type="text" name="nombreTema" value=""  />
                                    </div>
                                    </div>
                                    

                                    <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-2 control-label" for="Temas_idTema">Es subtema de <span class="required">*</span></label>
                                    
                                    <div class="col-sm-10">
                                      <div class="input-group">
                                      <select class="form-control" name="tema">
                                      <option value=""></option>
                                        <c:forEach items="${Temas}" var="item">
                                                <option value="${item.idTema}">${item.nombreTema}</option>
                                        </c:forEach>
                                       </select>
                                       <span class="input-group-btn">
                                        <a class="btn btn-primary" href="#"><span class="glyphicon glyphicon-plus"></span></a>
                                       </span>
                                       </div>
                                    </div>

                                    </div>
                                    

                                    <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-2 control-label" for="Unidades_idUnidad">De la unidad<span class="required">*</span></label>
                                    
                                    <div class="col-sm-10">
                                      <div class="input-group">
                                      <select class="form-control" name="unidad">
                                        <c:forEach items="${Unidades}" var="item">
                                            <% 
                                            
                                            
                                            %>
                                                <option value="${item.idUnidad}">${item.nombreUnidad}</option>
                                        </c:forEach>
                                       </select>
                                       <span class="input-group-btn">
                                        <a class="btn btn-primary" href="#"><span class="glyphicon glyphicon-plus"></span></a>
                                       </span>
                                       </div>
                                    </div>

                                    </div>
	</div>
	
</div>
                                    <a href="#" id="agregarU" class="btn btn-success">Agregar Tema</a>
                                    
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