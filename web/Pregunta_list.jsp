<%@page import="java.util.ArrayList"%>
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
<a href="#" class="btn btn-primary" data-toggle="modal" data-target="#modalExp">Agregar Pregunta</a>
<div class="container">
  <div class="row clearfix">
    <div class="col-md-12 column">
      
      <div class="row clearfix">
        <div class="col-md-2 column">
          <h3>
            Seleccione EE Y UNIDAD
          </h3>
                 <body onload="Cargar()">
                  <div id="contenidos">
                 <div id="lista">
                     
                      <select class="form-control"  id="mySelect"  onchange="Seleccionar()">
                                        <% 
                                      java.util.ArrayList<edu.uv.model.pojos.ExperieciaEducativa> list = (java.util.ArrayList)session.getAttribute("matslist");
                                      if(list!=null)
                                      for(edu.uv.model.pojos.ExperieciaEducativa en:list){
                                      %>
 
                                      <option value=<%= en.getIdExperieciaEducativa()%> > <%= en.getNombreEe()%> </option >

                                      <%};%>
             </select>   
                     
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
              
                  </div>
                </body>

            
           
             
           
             
        </div>
        <div class="col-md-3 column">
          <h3>
            Seleccione unidad
          </h3>
          
           
            
            
        </div>
        <div class="col-md-2 column">
           <button type="button" class="btn btn-primary">Default</button>
        </div>
        <div class="col-md-5 column">
          
        </div>
      </div>
      <div class="row clearfix">
        <div class="col-md-12 column">
        </div>
      </div>
      <table class="table">
        <thead>
          <tr>
            <th>
              Tema
            </th>
<th>
              Subtema
            </th>
<th>
              #
            </th>
<th>
              Pregunta
            </th>
<th>
              Comentarios
            </th>
<th>
              Borrar
            </th>
<th>
              Ver
            </th>
<th>
              Aprobar
            </th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>Tema 1</td>
            <td>subtema 1</td>
            <td>1</td>
            <td>pregunta1</td>
            <td>mmmkkjdpdjo</td>
            <td><button type="button" class="btn btn-danger">Borrar</button></td>
            <%--Esta parte solo es para probar el envío de parametros al jsp de footer --%>
            <c: var="mensaje" items="${men.mensaje}">
                    <c:out value="${hola}"/> 0
            </c:>
            <td><a data-toggle="modal" data-target="#myModal2" class="btn btn-primary" href="${men.mensaje}" >Ver</a></td>
            <td><button type="button" class="btn btn-success">Aprobar</button></td>

          </tr>
        </tbody>
      </table>
    
    </div>
  </div>

</div>



<script>
       function redirect(){
        
	var x = document.getElementById("mySelect").selectedIndex;
	var y = document.getElementById("mySelect").options;
        var z = document.getElementById("mySelect").valueOf(x).toString();
	location.replace("PreguntaController?accion=agregar&idEE="+y[x].value);

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
      
      
<%@include file="footer.jsp" %>
