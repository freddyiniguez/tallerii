		</div>
	</div>
	<div class="row clearfix">
		<div class="col-md-12 column">
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


