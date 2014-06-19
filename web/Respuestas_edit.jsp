<%@include file="header.jsp" %>
<h1><B><center>Edici�n de pregunta</center></b></h1>
        <form action="RespuestasController" method="POST">
        	<input type="hidden" name="idRespuesta" value="${Respuestas.idRespuesta}" />
            
                                    <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-3 control-label" for="descripcionRespuesta">Respuesta:<span class="required">*</span></label>
                                    <div class="col-sm-12">                                
                                    <textarea required class="form-control" id="descripcionRespuesta" name="descripcionRespuesta">${Respuestas.descripcionRespuesta}</textarea>
                                    </div>
                                    </div>
                                    

                                    <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-3 control-label" for="tipoResp">Tipo:<span class="required">*</span></label>
                                    <div class="col-sm-12">                                
                                    <select class="form-control" name="tipoResp" id="tipoResp">
                                        <option value=""></option>
                                    <option value="Correcta">Correcta</option>
                                    <option value="Incorrecta">Incorrecta</option>
                                    </select>
                                    </div>
                                    </div>
                                    

                                    <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-3 control-label" for="Pregunta_idPregunta">Pregunta:<span class="required">*</span></label>
                                    
                                    <div class="col-sm-12">
                                      <div class="input-group">
                                      <select class="form-control" name="pregunta">
                                        <c:forEach items="${Pregunta}" var="item">
                                                <option value="${item.idPregunta}">${item.idPregunta}</option>
                                        </c:forEach>
                                       </select>
                                       <span class="input-group-btn">
                                           <%--
                                        <a class="btn btn-primary" href="#"><span class="glyphicon glyphicon-question-sign"></span></a>
                                           --%>
                                       </span>
                                       </div>
                                    </div>
                                    
                                    </div>
                                    <h5><p align="right"><font color="red">Los campos que est�n marcados con * son obligatorios para la edici�n.  </font>  </p> </h5>
                                    
            
            <div class="col-md-12 ">
				<div class="pull-right">
					<input type="submit" class="btn btn-primary" name="accion" value="actualizar" />
				</div>
			</div>
        </form>
        
<%@include file="footer.jsp" %>