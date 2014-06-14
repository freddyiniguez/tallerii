
<%@include file="header.jsp" %>
<h1><B><center>Edición de pregunta </center></b></h1>
        <form action="PreguntaController" method="POST">
        	<input type="hidden" name="idPregunta" value="${Pregunta.idPregunta}" />
            
                                    <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-3 control-label" for="temas_idtemas">Tema:<span class="required">*</span></label>
                                    
                                    <div class="col-sm-12">
                                      <div class="input-group">
                                      <select class="form-control" name="tema">
                                        <option value="${Pregunta.temas.idTema}">${Pregunta.temas.nombreTema}</option>
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

                                    

                                    <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-3 control-label" for="tipoPregunta">Tipo de pregunta:<span class="required">*</span></label>
                                    <div class="col-sm-12">                                
                                    <select class="form-control" name="tipoPregunta" id="tipoPregunta">
                                    <option value="${Pregunta.tipoPregunta}">${Pregunta.tipoPregunta}</option>
                                    <option value="Opcion multiple">Opción multiple</option>
                                    <option value="VF">Falso-Verdadero</option>
                                    <option value="Abierta'">Abierta</option>
                                    <option value="Multiple Respuesta">Multiple Respuesta</option>
                                    <option value="Acompletar">Acompletar</option>
                                    </select>
                                    </div>
                                    </div>
                                    

                                    <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-3 control-label" for="descripcionPregunta">Pregunta:<span class="required">*</span></label>
                                    <div class="col-sm-12">                                
                                    <textarea required class="form-control" id="descripcionPregunta" name="descripcionPregunta">${Pregunta.descripcionPregunta}</textarea>
                                    </div>
                                    </div>
                                    

                                    <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-3 control-label" for="modalidadPregunta">Modalidad:<span class="required">*</span></label>
                                    <div class="col-sm-12">                                
                                    <select class="form-control" name="modalidadPregunta" id="modalidadPregunta">
                                    <option value="${Pregunta.modalidadPregunta}">${Pregunta.modalidadPregunta}</option>
                                    <option value="Teorica">Teórica</option>
                                    <option value="Practica">Practica</option>
                                    </select>
                                    </div>
                                    </div>
                                    

                                    <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-3 control-label" for="complejidadPregunta">Complejidad:<span class="required">*</span></label>
                                    <div class="col-sm-12">                                
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
                                    
                                    <h5><p align="right">1= Nada complejo 5= Complejo  </p> </h5>
                                    <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-3 control-label" for="puntuacionPregunta">Puntuación:<span class="required">*</span></label>
                                    <div class="col-sm-12">  
                                    <input required class ="form-control" id="puntuacionPregunta" type="number" name="puntuacionPregunta" value="${Pregunta.puntuacionPregunta}"  />
                                    </div>
                                    </div>
                                    

                                    <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-3 control-label" for="ComentRetroalimentacion">Comentarios:<span class="required">*</span></label>
                                    <div class="col-sm-12">                                
                                    <textarea required class="form-control" id="ComentRetroalimentacion" name="ComentRetroalimentacion">${Pregunta.comentRetroalimentacion}</textarea>
                                    </div>
                                    </div>
                                  <h5><p align="right"><font color="red">Los campos que están marcados con * son obligatorios para la edición.  </font>  </p> </h5>  
            
            <div class="col-md-12 ">
				<div class="pull-right">
					<input type="submit" class="btn btn-primary" name="accion" value="actualizar" />
				</div>
			</div>
        </form>
<%@include file="footer.jsp" %>
