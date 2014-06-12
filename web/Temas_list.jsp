<%@include file="header.jsp" %>
<h2>Lista de temas</h2>
<a href="#" class="btn btn-primary" data-toggle="modal" data-target="#modalExp" >Agregar a Temas</a>
<table class="table table-striped">
    <tr>
        <td>Nombre tema</td>
        <td>Nombre subtema</td>
        <td>Nombre unidad</td>
        <td>Borrar</td>
        <td>Editar</td>
    </tr>
  <c:forEach items="${list}" var="item">
    <tr>
      
      <td><c:out value="${item.nombreTema}"/></td>
      <td><c:out value="${item.temas.nombreTema}"/></td>
      <td><c:out value="${item.unidades.nombreUnidad}"/></td>
      
      <td><a class="btn btn-danger toDelete" data-toggle="modal" data-target="#myModal" id="TemasController?accion=borrar&id=${item.idTema}" href="#">Borrar</a></td>
      <td><a class="btn btn-warning" href="TemasController?accion=buscar&id=${item.idTema}&uni=${item.unidades.idUnidad}">Editar</a></td>
    </tr>
  </c:forEach>
</table>
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
          <c:forEach items="${listaEE}" var="itemE">
              <a href="TemasController?accion=agregar&idEE=${itemE.idExperieciaEducativa}" id="" class="list-group-item" >
                <c:out value="${itemE.nombreEe}"/>
              </a>
                  
        
            </c:forEach>

        </div>
        
        
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
        
      </div>
    </div>
  </div>
</div>
<%@include file="footer.jsp" %>