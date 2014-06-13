<%@include file="header.jsp" %>
<h1><B><center>Registro de pregunta </center></b></h1>
        <form action="PreguntaController" method="POST">
        
                                    <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-3 control-label" for="temas_idtemas">Tema:<span class="required">*</span></label>
                                    
                                    <div class="col-sm-12">
                                      <div class="input-group">
                                      <select class="form-control" name="tema">
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
                                    <option value="Opcion multiple">Opción multiple</option>
                                    <option value="VF">Falso-Verdadero</option>
                                    <option value="Abierta">Abierta</option>
                                    <option value="Multiple Respuesta">Multiple Respuesta</option>
                                    <option value="Acompletar">Acompletar</option>
                                    </select>
                                    </div>
                                    </div>
                                    

                                    <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-3 control-label" for="descripcionPregunta">Pregunta:<span class="required">*</span></label>
                                    <div class="col-sm-12">                                
                                    <textarea required class="form-control" id="descripcionPregunta" name="descripcionPregunta"></textarea>
                                    </div>
                                    </div>
                                    

                                    <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-3 control-label" for="modalidadPregunta">Modalidad:<span class="required">*</span></label>
                                    <div class="col-sm-12">                                
                                    <select class="form-control" name="modalidadPregunta" id="modalidadPregunta">
                                    <option value=""></option>
                                    <option value="Teorica">Teórica</option>
                                    <option value="Practica">Practica</option>
                                    </select>
                                    </div>
                                    </div>
                                    

                                    <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-3 control-label" for="complejidadPregunta">Complejidad:<span class="required">*</span></label>
                                    <div class="col-sm-12">                                
                                    <select class="form-control" type="number" name="complejidadPregunta" id="complejidadPregunta">
                                    <option value=""></option>
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
                                    <label class="col-sm-3 control-label" for="puntuacionPregunta">Puntaje asignado:<span class="required">*</span></label>
                                    <div class="col-sm-12">  
                                    <input required class ="form-control" id="puntuacionPregunta" type="number" name="puntuacionPregunta" value=""  />
                                    </div>
                                    </div>
                                    

                                    <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-3 control-label" for="ComentRetroalimentacion">Comentarios:<span class="required"></span></label>
                                    <div class="col-sm-12">                                
                                    <textarea required class="form-control" id="ComentRetroalimentacion" name="ComentRetroalimentacion"></textarea>
                                    </div>
                                    </div>
                                    <h5><p align="right"><font color="red">Los campos que están marcados con * son obligatorios para el registro  </font>  </p> </h5>
                                    <div id="respuestas">
                                    <div id="respuesta">
                                        <label for="1">Respuesta:<div id="letter">A</div></label>
                                          <div class="input-group">
                                             <span class="input-group-addon">
                                             <input name="correct" type="radio" value="0">
                                             </span>
                                             <textarea required class="form-control" id="descripcionRespuesta" name="descripcionRespuesta"></textarea>
                                          </div>
                                    </div>
                                    
                                    </div>
                                    <a href="#" id="agregar" class="btn btn-success">Agregar respuesta:</a>
                                    
        <div class="col-md-12 ">
			<div class="pull-right">
				<input type="submit" class="btn btn-primary" name ="accion" value="insertar">
			</div>
		</div>
        </form>
<script>
    var letters = ['B','C','D','E'];
    var n=0;
        $(document).ready(function(){
         $("#agregar").click(function(){
           var respuesta = $("#respuesta").clone();
           $(respuesta).find('#letter').text(letters[n]);
           $(respuesta).find('input[type=radio]').attr('value',n+1);
           $(respuesta).appendTo("#respuestas");
           console.log("ok");
           n++;
         });
        });
        </script>
<%@include file="footer.jsp" %>