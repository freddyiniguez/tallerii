<%@include file="header.jsp" %>
<h1>Registro de Carreras </h1>
        <form action="TemasController" method="POST">
        	<input type="hidden" name="idTema" value="${Temas.idTema}" />
            
                                    <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-2 control-label" for="nombreTema">Nombre del tema<span class="required">*</span></label>
                                    <div class="col-sm-10">  
                                    <input required class ="form-control" id="nombreTema" type="text" name="nombreTema" value="${Temas.nombreTema}"  />
                                    </div>
                                    </div>
                                    

                                    <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-2 control-label" for="Temas_idTema">Es subtema de <span class="required">*</span></label>
                                    
                                    <div class="col-sm-10">
                                      <div class="input-group">
                                      <select class="form-control" name="academia">
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
                                      <select class="form-control" name="academia">
                                        <c:forEach items="${Unidades}" var="item">
                                                <option value="${item.idUnidad}">${item.nombreUnidad}</option>
                                        </c:forEach>
                                       </select>
                                       <span class="input-group-btn">
                                        <a class="btn btn-primary" href="#"><span class="glyphicon glyphicon-plus"></span></a>
                                       </span>
                                       </div>
                                    </div>
                                    
                                    </div>

                                    
            
            <div class="col-md-12 ">
				<div class="pull-right">
					<input type="submit" class="btn btn-primary" name="accion" value="actualizar" />
				</div>
			</div>
        </form>
        
<%@include file="footer.jsp" %>