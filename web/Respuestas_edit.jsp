<%@include file="header.jsp" %>
<h1>Registro de Carreras </h1>
        <form action="RespuestasController" method="POST">
        	<input type="hidden" name="idRespuesta" value="${Respuestas.idRespuesta}" />
            
                                    <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-2 control-label" for="descripcionRespuesta">Respuesta<span class="required">*</span></label>
                                    <div class="col-sm-10">                                
                                    <textarea required class="form-control" id="descripcionRespuesta" name="descripcionRespuesta">${Respuestas.descripcionRespuesta}</textarea>
                                    </div>
                                    </div>
                                    

                                    <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-2 control-label" for="tipoResp">Tipo<span class="required">*</span></label>
                                    <div class="col-sm-10">                                
                                    <select class="form-control" name="tipoResp" id="tipoResp">
                                        <option value=""></option>
                                    <option value="Correcta">Correcta</option>
                                    <option value="Incorrecta">Incorrecta</option>
                                    </select>
                                    </div>
                                    </div>
                                    

                                    <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-2 control-label" for="Pregunta_idPregunta">Pregunta<span class="required">*</span></label>
                                    
                                    <div class="col-sm-10">
                                      <div class="input-group">
                                      <select class="form-control" name="pregunta">
                                        <c:forEach items="${Pregunta}" var="item">
                                                <option value="${item.idPregunta}">${item.idPregunta}</option>
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