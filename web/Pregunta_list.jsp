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
            Seleccione EE
          </h3>
          <div class="btn-group">
             <button class="btn btn-default">Action</button> <button data-toggle="dropdown" class="btn btn-default dropdown-toggle"><span class="caret"></span></button>
            <ul class="dropdown-menu">
              <li>
                <a href="#">EE</a>
              </li>
              <li class="disabled">
                <a href="#">Another action</a>
              </li>
              <li class="divider">
              </li>
              <li>
                <a href="#">Something else here</a>
              </li>
            </ul>
          </div>
        </div>
        <div class="col-md-3 column">
          <h3>
            Seleccione unidad
          </h3>
          <div class="btn-group">
             <button class="btn btn-default">Action</button> <button data-toggle="dropdown" class="btn btn-default dropdown-toggle"><span class="caret"></span></button>
            <ul class="dropdown-menu">
              <li>
                <a href="#">Action</a>
              </li>
              <li class="disabled">
                <a href="#">Another action</a>
              </li>
              <li class="divider">
              </li>
              <li>
                <a href="#">Something else here</a>
              </li>
            </ul>
          </div>
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
            <td><button type="button" class="btn btn-info">Ver</button></td>
            <td><button type="button" class="btn btn-succes">Aprobar</button></td>

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
      </script>
      
      
<%@include file="footer.jsp" %>
