<%@include file="header_COORD.jsp" %>

<%    if ((session.getAttribute("user") == null)) {
        request.getRequestDispatcher("login_.jsp").forward(request, response);
    } else {

    }
    if (!session.getAttribute("rol").equals("Coordinador")) {
        request.getRequestDispatcher("index.jsp").forward(request, response);
        }
%>

<h2>Lista de Temas</h2>
<a href="#" class="btn btn-primary" data-toggle="modal" data-target="#modalExp" >Agregar a Temas</a>
<div align="center" style="border: 1px; color: white; background-color:#00AB4F;" id="NavTabla"></div>
<table id="tabla" class="table table-striped sortable">
    <tr>
        
        <td>Nombre tema</td>
        <td>Nombre subtema</td>
        <td>Nombre unidad</td>
        <td class="unsortable">Borrar</td>
        <td class="unsortable">Editar</td>
    </tr>
  <c:forEach items="${list}" var="item">
    <tr>
        <c:if test="${item.temas.nombreTema!=null}">
            <td><c:out value="${item.temas.nombreTema}"/></td>   
            <td><c:out value="${item.nombreTema}"/></td>
            <td><c:out value="${item.unidades.nombreUnidad}"/></td>
        
            <td><a class="btn btn-danger toDelete" data-toggle="modal" data-target="#myModal" id="TemasController?accion=borrar&id=${item.idTema}" href="#">Borrar</a></td>
            <td><a class="btn btn-warning" href="TemasController?accion=buscar&id=${item.idTema}&uni=${item.unidades.idUnidad}">Editar</a></td>
            
        </c:if>
        <c:if test="${item.temas.nombreTema==null}">
            <td><c:out value="${item.nombreTema}"/></td>
            <td><c:out value="${item.temas.nombreTema}"/></td>   
            <td><c:out value="${item.unidades.nombreUnidad}"/></td>
        
            <td><a class="btn btn-danger toDelete" data-toggle="modal" data-target="#myModal" id="TemasController?accion=borrar&id=${item.idTema}" href="#">Borrar</a></td>
            <td><a class="btn btn-warning" href="TemasController?accion=buscar&id=${item.idTema}&uni=${item.unidades.idUnidad}">Editar</a></td>
        
        </c:if>
    </tr>
  </c:forEach>
</table>
<div align = "center" style="border: 1px; color: white; background-color:#00AB4F;" id="NavTabla2"></div>
<!-- Modal elegir experiencia -->
<div class="modal fade" id="modalExp" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel">Seleccione Experiencia Educativa</h4>
      </div>
        <h5> Selecciona una Experiencia Educativa<span class="label label-default">;)</span></h5>
      <div class="modal-body">
        
        <div class="list-group">
            
          <select class="form-control"  id="mySelect">
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
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
        <button type="button" class="btn btn-default" onclick="redirect()">Agregar</button>
      </div>
    </div>
  </div>
</div>

  <script>
       function redirect(){
        
	var x = document.getElementById("mySelect").selectedIndex;
	var y = document.getElementById("mySelect").options;
        var z = document.getElementById("mySelect").valueOf(x).toString();
	location.replace("TemasController?accion=agregar&idEE="+y[x].value);

        }
      </script>


<%@include file="footer.jsp" %>