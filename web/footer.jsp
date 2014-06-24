		</div>
	</div>
	<div class="row clearfix">
		<div class="col-md-12 column">
                     <td><a  data-toggle="modal" data-target="#myModal3" href="#">Acerca de GEDUV v1.0</a></td>
                </div>
	</div>
</div>
</body>
</html>
<script>
$(document).ready(function(){
    $('.toDelete').click(function(){
        $('a.borrar').attr('href',$(this).attr('id'));
    });
});
</script>
<script type="text/javascript">
  var pager = new Pager('tabla',5);
  pager.init();
  pager.showPageNav('pager','NavTabla');
  pager.showPageNav('pager','NavTabla2');
  pager.showPage(1);
</script>
<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel">Alerta</h4>
      </div>
      <div class="modal-body">
        Seguro que desea continuar con la acción?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
        <a class="btn btn-primary borrar" href="#" >Si</a>
      </div>
    </div>
  </div>
</div>

<div class="modal fade" id="myModal3" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header" style="background-color:#317eac;border-radius:4px">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel" style="color: white">Equipo de desarrollo GEDUV v1.0</h4>
      </div>
      <div class="modal-body">
          Arriaga Bellido Ariana<br>
    Figueroa Gutierrez Santiago<br>
    Hernández Hernández Enrique<br>
    Iñiguez Lopez Freddy<br>
    Maldonado Navarro Alejandro<br>
    Manzanares Avila Ricardo<br>
    Marin Pérez Cristhian Jahir<br>
    Medina Hernández Carol María<br> 
    Morales Luna Cinthia Selene<br>
    Rodríguez Hernández Jesús Alberto<br>
      </div>
      <div class="modal-footer">
        
        <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
      </div>
    </div>
  </div>
</div>

