
<%@include file="header.jsp" %>
<h1>Registro de Carreras </h1>
        <form action="PreguntaController" method="POST">
        	<input type="hidden" name="idPregunta" value="${Pregunta.idPregunta}" />
            
                                    <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-2 control-label" for="temas_idtemas">Tema<span class="required">*</span></label>
                                    
                                    <div class="col-sm-10">
                                      <div class="input-group">
                                      <select class="form-control" name="tema">
                                        <option value="${Pregunta.temas.idTema}">${Pregunta.temas.nombreTema}</option>
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
                                    <option value="${Pregunta.tipoPregunta}">${Pregunta.tipoPregunta}</option>
                                    <option value="Opcion multiple">Opcion multiple</option>
                                    <option value="VF">VF</option>
                                    <option value="Abierta'">Abierta</option>
                                    <option value="Multiple Respuesta">Multiple Respuesta</option>
                                    <option value="Acompletar">Acompletar</option>
                                    </select>
                                    </div>
                                    </div>
                                    

                                    <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-2 control-label" for="descripcionPregunta">Pregunta<span class="required">*</span></label>
                                    <div class="col-sm-10">                                
                                    <textarea required class="form-control" id="descripcionPregunta" name="descripcionPregunta">${Pregunta.descripcionPregunta}</textarea>
                                    </div>
                                    </div>
                                    

                                    <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-2 control-label" for="modalidadPregunta">Modalidad<span class="required">*</span></label>
                                    <div class="col-sm-10">                                
                                    <select class="form-control" name="modalidadPregunta" id="modalidadPregunta">
                                    <option value="${Pregunta.modalidadPregunta}">${Pregunta.modalidadPregunta}</option>
                                    <option value="Teorica">Teorica</option>
                                    <option value="Practica">Practica</option>
                                    </select>
                                    </div>
                                    </div>
                                    

                                    <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-2 control-label" for="complejidadPregunta">Complejidad<span class="required">*</span></label>
                                    <div class="col-sm-10">                                
                                    <select class="form-control" type="number"  name="complejidadPregunta" id="complejidadPregunta">
                                    <option value="">${Pregunta.complejidadPregunta}</option>
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                    <option value="4">4</option>
                                    <option value="5">5</option>
                                    </select>
                                    </div>
                                    </div>
                                    

                                    <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-2 control-label" for="puntuacionPregunta">Puntuación<span class="required">*</span></label>
                                    <div class="col-sm-10">  
                                    <input required class ="form-control" id="puntuacionPregunta" type="number" name="puntuacionPregunta" value="${Pregunta.puntuacionPregunta}"  />
                                    </div>
                                    </div>
                                    

                                    <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-2 control-label" for="ComentRetroalimentacion">Comentarios<span class="required">*</span></label>
                                    <div class="col-sm-10">                                
                                    <textarea required class="form-control" id="ComentRetroalimentacion" name="ComentRetroalimentacion">${Pregunta.comentRetroalimentacion}</textarea>
                                    </div>
                                    </div>
                                    
            
            <div class="col-md-12 ">
				<div class="pull-right">
					<input type="submit" class="btn btn-primary" name="accion" value="actualizar" />
				</div>
			</div>
        </form>
        
>>>>>>> origin/master
<%@include file="footer.jsp" %>
