<%@include file="header.jsp" %>
        <form action="PreguntaController" method="POST">
        
                                    <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-2 control-label" for="temas_idtemas">Tema<span class="required">*</span></label>
                                    
                                    <div class="col-sm-10">
                                      <div class="input-group">
                                      <select class="form-control" name="tema">
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
                                    <label class="col-sm-2 control-label" for="tipoPregunta">Tipo de pregunta<span class="required">*</span></label>
                                    <div class="col-sm-10">                                
                                    <select class="form-control" name="tipoPregunta" id="tipoPregunta">
                                    <option value="Opcion multiple">Opcion multiple</option>
                                    <option value="VF">VF</option>
                                    <option value="Abierta">Abierta</option>
                                    <option value="Multiple Respuesta">Multiple Respuesta</option>
                                    <option value="Acompletar">Acompletar</option>
                                    </select>
                                    </div>
                                    </div>
                                    

                                    <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-2 control-label" for="descripcionPregunta">Pregunta<span class="required">*</span></label>
                                    <div class="col-sm-10">                                
                                    <textarea required class="form-control" id="descripcionPregunta" name="descripcionPregunta"></textarea>
                                    </div>
                                    </div>
                                    

                                    <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-2 control-label" for="modalidadPregunta">Modalidad<span class="required">*</span></label>
                                    <div class="col-sm-10">                                
                                    <select class="form-control" name="modalidadPregunta" id="modalidadPregunta">
                                    <option value=""></option>
                                    <option value="Teorica">Teorica</option>
                                    <option value="Practica">Practica</option>
                                    </select>
                                    </div>
                                    </div>
                                    

                                    <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-2 control-label" for="complejidadPregunta">Complejidad<span class="required">*</span></label>
                                    <div class="col-sm-10">  
                                    <input required class ="form-control" id="complejidadPregunta" type="number" name="complejidadPregunta" value=""  />
                                    </div>
                                    </div>
                                    

                                    <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-2 control-label" for="puntuacionPregunta">Puntuación<span class="required">*</span></label>
                                    <div class="col-sm-10">  
                                    <input required class ="form-control" id="puntuacionPregunta" type="number" name="puntuacionPregunta" value=""  />
                                    </div>
                                    </div>
                                    

                                    <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-2 control-label" for="ComentRetroalimentacion">Comentarios<span class="required">*</span></label>
                                    <div class="col-sm-10">                                
                                    <textarea required class="form-control" id="ComentRetroalimentacion" name="ComentRetroalimentacion"></textarea>
                                    </div>
                                    </div>
                                    
        <div class="col-md-12 ">
			<div class="pull-right">
				<input type="submit" class="btn btn-primary" name ="accion" value="insertar">
			</div>
		</div>
        </form>
<%@include file="footer.jsp" %>