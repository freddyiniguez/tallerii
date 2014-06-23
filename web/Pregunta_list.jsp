<%@page import="java.util.ArrayList"%>
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
<h2>Lista de Preguntas</h2>
<a href="PreguntaController?accion=ee" class="btn btn-primary">Agregar Pregunta</a>
<a href="PreguntaController?accion=list_aprobar" class="btn btn-success">Aprobar Pregunta</a>
 <div class="row clearfix">
     <body onload="Cargar()">
         
        <div class="col-md-3 column">
        
          <h3>
            Elija EE
          </h3>
          <div id="contenidos">
             <div id="lista">
                <select class="form-control"  id="mySelect"  onchange="Seleccionar()">
                    <option value=0 selected="True" > Elije EE </option >
                    <% 
                    java.util.ArrayList<edu.uv.model.pojos.ExperieciaEducativa> list = (java.util.ArrayList)session.getAttribute("matslist");
                        if(list!=null)
                            for(edu.uv.model.pojos.ExperieciaEducativa en:list){
                    %>
 
                    <option value=<%= en.getIdExperieciaEducativa()%> > <%= en.getNombreEe()%> </option >

                    <%};%>
                    
                </select>   
          </div>  
         </div>
        </div>
                
          <div class="col-md-3 column">
          <h3>
            Elija Unidad
          </h3>
            <select class="form-control" id="listbox" >
                    
            </select>
             <select id="unidadesActuales" hidden="True">
                                    <% 
                java.util.ArrayList<edu.uv.model.pojos.Unidades> list2 = (java.util.ArrayList)session.getAttribute("unidadesList");
                if(list2!=null)
                for(edu.uv.model.pojos.Unidades en:list2){
                %>
                <option value=<%= en.getExperieciaEducativa().getIdExperieciaEducativa() %> > <%= en.getNombreUnidad()%> </option >
                <%};%>
             </select>
                
                 
             <select id="valores" hidden="True">
                                    <% 
                java.util.ArrayList<edu.uv.model.pojos.Unidades> list3 = (java.util.ArrayList)session.getAttribute("unidadesList");
                if(list3!=null)
                for(edu.uv.model.pojos.Unidades en:list3){
                %>
                <option value=<%= en.getIdUnidad()%> > <%= en.getNombreUnidad()%> </option >
                <%};%>
                </select>
             
                </div>
        
        <div class="col-md-6 column" with="200" heigt="200">
            <h3>
            Filtrar por:
          </h3>
            <div class="row clearfix">
				<div class="col-md-4 column">
                                    <button type="button" class="btn btn-primary" onClick="redirect3()">Experiencia Edu</button>
				</div>
				<div class="col-md-4 column">
                                    <button type="button" class="btn btn-primary" onClick="redirect()">       Unidades      </button>
				</div>
				<div class="col-md-4 column">
                                    <button type="button" class="btn btn-primary" onClick="redirect2()"> Mostrar todas </button>
				</div>
			</div>
            
           
           
           
           
           
        </div>
        
        </body>             
         </div>  
    
      
      
        
      
     
<div class="container">
<div class="row clearfix">
<div class="col-md-12 column">
    <br/>
    <div class="col-md-3 column"></div>
    <div class="col-md-3 column"></div>
    <div class="col-md-3 column"></div>
    <td><a data-toggle="modal" data-target="#myModal2" class="btn btn-primary" href="${item}" align="left">Ver preguntas a detalle</a></td>
    <div align="center" style="border: 1px; color: white; background-color:#00AB4F;" id="NavTabla"></div>
    <table id="tabla" class="table table-striped sortable">
        <thead>
          <tr>
            <th>Tema</th>
            <th>Número</th>
            <th>Pregunta</th>
            <th>Estado</th>
            <th>Comentarios</th>
          </tr>
        </thead>
        <c:forEach items="${list}" var="item">
            <tr>
             
            <div class="row clearfix">
                
                <td>
                    <c:out value="${item.temas.nombreTema}"/>
                </td>
                
                <td>
                    <c:out value="${item.idPregunta}"/>
                </td>
                <td>
                    <c:out value="${item.descripcionPregunta}"/>
                </td>
                <td>
                    <c:out value="${item.estado}"/>
                </td>
                <td>
                    <c:out value="${item.comentRetroalimentacion}"/>
                </td>
                <td><a class="btn btn-danger toDelete" data-toggle="modal" data-target="#myModal" id="PreguntaController?accion=borrar&id=${item.idPregunta}" href="#">Borrar</a></td>
                <%--Esta parte solo es para probar el envío de parametros al jsp de footer --%>
                
      
            </tr>
           </c:forEach>
       
     
       </table>
    <div align = "center" style="border: 1px; color: white; background-color:#00AB4F;" id="NavTabla2"></div>
 </div>
            </div></div>


<script>
       function redirect(){
        
	var x = document.getElementById("mySelect").selectedIndex;
	var y = document.getElementById("mySelect").options;
        var x2 = document.getElementById("listbox").selectedIndex;
	var y2 = document.getElementById("listbox").options;
        //var z = document.getElementById("mySelect").valueOf(x).toString();
	//location.replace("PreguntaController?accion=filtrado&aExp="+y[x].value+"&auxUni="+y2[x2].value);
        //location.replace("PreguntaController?accion=filtrar");
        location.replace("PreguntaController?accion=filtrar&auxUni="+y2[x2].value);
    
        }
        
         function redirect2(){
        
	var x = document.getElementById("mySelect").selectedIndex;
	var y = document.getElementById("mySelect").options;
        var x2 = document.getElementById("listbox").selectedIndex;
	var y2 = document.getElementById("listbox").options;
        //var z = document.getElementById("mySelect").valueOf(x).toString();
	//location.replace("PreguntaController?accion=filtrado&aExp="+y[x].value+"&auxUni="+y2[x2].value);
        //location.replace("PreguntaController?accion=filtrar");
        location.replace("PreguntaController");
    
        }
        
          function redirect3(){
        
	var x = document.getElementById("mySelect").selectedIndex;
	var y = document.getElementById("mySelect").options;
        var x2 = document.getElementById("listbox").selectedIndex;
	var y2 = document.getElementById("listbox").options;
        //var z = document.getElementById("mySelect").valueOf(x).toString();
	location.replace("PreguntaController?accion=filtrarer&aExp="+y[x].value);
        //location.replace("PreguntaController?accion=filtrar");
        //location.replace("PreguntaController");
    
        }
        
        function Cargar(){
               var lista=document.getElementById("listbox");
               lista.options.add(new Option("Selecciona ER primero","0"));
         }

        function Seleccionar(){
            Eliminar();
            Agregar();
          }

        function Agregar(){
            var lista=document.getElementById("listbox");
            var valor = document.getElementById("valores").options;
            
            var x = document.getElementById("mySelect").selectedIndex;
            var y = document.getElementById("mySelect").options;
            
            //alert("EXPERIENCIA SELECCIONADA"+y[x].value); //BIEN
            
            var unidadesTotales = document.getElementById("unidadesActuales").options;
            var longitud = document.getElementById("unidadesActuales").options.length;
            //alert(longitud);
            var aux=0;
            lista.options[lista.selectedIndex]=null;
            while(aux<longitud){
                //alert(unidadesTotales[aux].value+"valor"+y[x].value);
                if(unidadesTotales[aux].value == y[x].value){
                    //alert("igual" +unidadesTotales[aux].text+" "+valor[aux].value);
                    lista.options.add(new Option(unidadesTotales[aux].text,valor[aux].value));
                }
                aux=aux+1;
                
            }
         
         
         
          }
          
       function Eliminar(){
            var lista=document.getElementById("listbox");
            lista.options[lista.selectedIndex]=null;
        }
         
        
      </script>
<div class="modal" id="myModal2" style="size: letter">
  <div class="modal-content" style="size: auto">
        <div class="modal-header" style="background-color:#317eac;border-radius: 4px; size: auto"  >
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true" style="color:cornsilk; size: auto">&times;</button>
            <h4 class="modal-title" id="myModalLabel" style="color: white" >Detalles pregunta</h4>
        </div>
        <div class="modal-body" style="overflow-y:auto;max-height: 400px">
            
            <div align="center" style="border: 1px; color: white; background-color:#00AB4F;" id="NavTabla"></div>
                <table id="tabla" class="table table-striped sortable">
  
                    <td>No. Preg.</td>
                    <td>Tema</td>
                    <td>Tipo</td>
                    <td>Descripción</td>
                    <td>Modalidad</td>
                    <td>Complejidad</td>
                    <td>Estado</td>
                    <td>Puntuación</td>
                    <td>Retroalimentación</td>
                    <td>Respuesta</td>
                    <td/>
                    <c:forEach items="${list}" var="item">
    <tr>
      <td><c:out value="${item.idPregunta}"/></td>
      <td><c:out value="${item.temas.nombreTema}"/></td>
      <td><c:out value="${item.tipoPregunta}"/></td>
      <td><c:out value="${item.descripcionPregunta}"/></td>
      <td><c:out value="${item.modalidadPregunta}"/></td>
      <td><c:out value="${item.complejidadPregunta}"/></td>
      <td><c:out value="${item.estado}"/></td>
      <td><c:out value="${item.puntuacionPregunta}"/></td>
      <td><c:out value="${item.comentRetroalimentacion}"/></td>
      <td>
          <c:forEach items="${item.respuestases}" var="respuesta">
              R: ${respuesta.descripcionRespuesta}<br>
          </c:forEach>
      </td>
      <td><a class="btn btn-warning" href="PreguntaController?accion=buscar&id=${item.idPregunta}">Editar</a></td>
                    </tr>
  </c:forEach>
                
                </table>
        </div>  
            
            <div class="modal-footer">
        
        
        <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
      </div>
    </div>
  </div>      
      
<%@include file="footer.jsp" %>
