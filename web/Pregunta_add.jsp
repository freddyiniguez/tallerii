<% if(session.getAttribute("rol")=="Coordinador"){  
%>  
<jsp:include page="header_COORD.jsp" flush="true" /> 
<%}%> 

<% if(session.getAttribute("rol")=="Profesor"){  
%>  
<jsp:include page="header_PROF.jsp" flush="true" /> 
<%}%>

<%    if ((session.getAttribute("user") == null)) {
        request.getRequestDispatcher("login_.jsp").forward(request, response);
    } else {

    }
    if (session.getAttribute("rol").equals("Administrador")) {
        request.getRequestDispatcher("index.jsp").forward(request, response);
        }
%>


<h1><B><center>Registro de pregunta </center></b></h1>
        <form action="PreguntaController" method="POST">
            <div class="clearfix"></div>
            <div class="form-group">
                <label class="col-sm-2 control-label" for="Unidades_idUnidad">De la unidad<span class="required">*</span></label>
                <!--combo unidades --> 
                <div class="col-sm-10">
                  <div class="input-group">
                  <select id="cunidades" onchange="verTemas()" class="form-control" name="unidad">
                    <% 
                    java.util.ArrayList<edu.uv.model.pojos.Unidades> list2 = (java.util.ArrayList)session.getAttribute("unidadesList");
                    if(list2!=null)
                    for(edu.uv.model.pojos.Unidades en:list2){
                    %>
                    <option value=<%= en.getIdUnidad()%> > <%= en.getNombreUnidad()%> </option >
                    <%};%>
                   </select>
                   <span class="input-group-btn">
                    <a class="btn btn-primary" href="#"><span class="glyphicon glyphicon-question-sign"></span></a>
                   </span>
                   </div>
                </div>
            </div>
                   <!--combo temas --> 
            <div class="clearfix"></div>
            <div class="form-group">
                <label class="col-sm-3 control-label" for="temas_idtemas">Tema:<span class="required">*</span></label>
                <div class="col-sm-12">
                  <div class="input-group">
                        <select name="tema" class="form-control">
                                        <option value=""></option>
                                        
                                                <option value="1">tema 1</option>
                                        
                                                <option value="2">tema 4</option>
                                        
                                                <option value="3">Loving Script</option>
                                        
                                                <option value="4">script del amor</option>
                                        
                                                <option value="5">PythonInLove</option>
                                        
                                                <option value="6">mierdaLover</option>
                                        
                                                <option value="7">lola1</option>
                                        
                                                <option value="8">lola2</option>
                                        
                                                <option value="9">lola3</option>
                                        
                                                <option value="10">lolalab1</option>
                                        
                                                <option value="11">lolalab2</option>
                                        
                                                <option value="12">lolalab3</option>
                                        
                                                <option value="13">llla2</option>
                                        
                                                <option value="14">llla3</option>
                                        
                                                <option value="15">tema1</option>
                                        
                                                <option value="16">tema2</option>
                                        
                                                <option value="17">tema3</option>
                                        
                                                <option value="18">dsdsdsdsds</option>
                                        
                                                <option value="19">sdsdsdsdsdd</option>
                                        
                                                <option value="20">jojojo1</option>
                                        
                                                <option value="21">jojojo2</option>
                                        
                                                <option value="22">jojojo3</option>
                                        
                                       </select>
                        <span class="input-group-btn">
                         <a class="btn btn-primary" href="#"><span class="glyphicon glyphicon-question-sign"></span></a>
                        </span>
                   </div>
                </div>
            </div>
            <!--combo tipo pregunta -->
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
                                    
            <!-- descripicion de pregunta -->
            <div class="clearfix"></div>
            <div class="form-group">
                <label class="col-sm-3 control-label" for="descripcionPregunta">Pregunta:<span class="required">*</span></label>
                <div class="col-sm-12">                                
                <textarea required class="form-control" id="descripcionPregunta" name="descripcionPregunta"></textarea>
            </div>
            </div>
                                    
            <!--combo modalidad pregunta -->
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
                                    
            <!--combo complejidad -->
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
            <!-- puntaje -->
            <div class="clearfix"></div>
            <div class="form-group">
                <label class="col-sm-3 control-label" for="puntuacionPregunta">Puntaje asignado:<span class="required">*</span></label>
                <div class="col-sm-12">  
                <input required class ="form-control" id="puntuacionPregunta" type="number" name="puntuacionPregunta" value=""  />
            </div>
            </div>
                                    
            <!--comentarios -->
            <div class="clearfix"></div>
            <div class="form-group">
                <label class="col-sm-3 control-label" for="ComentRetroalimentacion">Comentarios:<span class="required"></span></label>
                <div class="col-sm-12">                                
                <textarea required class="form-control" id="ComentRetroalimentacion" name="ComentRetroalimentacion"></textarea>
            </div>
            </div>
            
            <!--respuestas -->
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
         function verTemas(){
                //obtiene los objetos productCode, y obtiene el valor del objeto
                var uni=$("#cunidades").val(); //ya se tiene el objeto select
                //llama al servlet con el parametro seleccionado
                $("#ctemas").load("PreguntaControoller?accion=temas", {cunidades:uni})
            }
        });
        </script>
<%@include file="footer.jsp" %>
