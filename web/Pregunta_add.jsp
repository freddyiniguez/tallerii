<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<script>
var array =[];
<c:forEach items="${Unidades}" var="unidad">
<c:forEach items="${unidad.temases}" var="tema">
    <c:if test="${tema.temas != null}">
var obj = [];
obj["unidad"] ="${unidad.idUnidad}";
obj["tema"]="${tema.nombreTema}";
obj["id_tema"]="${tema.idTema}";
array.push(obj);
    </c:if>
</c:forEach>
</c:forEach>
$(document).on('change','#unidad',function(){
    $("#tema").empty();
    for(var i=0;i<array.length;i++){
        if(array[i]["unidad"]==$(this).find('option:selected').val()){
            console.log(array[i]["tema"]);
            $("#tema").append("<option value='"+array[i]["id_tema"]+"'>"+array[i]["tema"]+"</option>");
        }
    }
    //console.log($(this).find('option:selected').val());
    
});
</script>
<h1><B><center>Registro de pregunta </center></b></h1>
        <form action="PreguntaController" method="POST">
            
            <div class="clearfix"></div>
            <div class="form-group">
                <label class="col-sm-2 control-label" for="unidad">De la unidad<span class="required">*</span></label>
                <div class="col-sm-12">
                  <div class="input-group">
                        <select id="unidad"  class="form-control" name="unidad">
                            <c:forEach items="${Unidades}" var="unidad">
                                <option value="${unidad.idUnidad}">${unidad.nombreUnidad}</option>
                            </c:forEach>
                           </select>
                        <span class="input-group-btn">
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
                        <select name="tema" id="tema" class="form-control">
                            <option></option>
                        </select>
                        <span class="input-group-btn">
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
                    <option value="Teoria">Teórica</option>
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
                <label class="col-sm-3 control-label" for="comentRetroalimentacion">Comentarios:<span class="required"></span></label>
                <div class="col-sm-12">                                
                <textarea required class="form-control" id="comentRetroalimentacion" name="comentRetroalimentacion"></textarea>
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
                $("#ctemas").load("PreguntaController?accion=temas", {cunidades:uni})
            }
        });
        </script>
<%@include file="footer.jsp" %>
