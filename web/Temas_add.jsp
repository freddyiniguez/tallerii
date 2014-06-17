<%@include file="header_COORD.jsp" %>

<%    if ((session.getAttribute("user") == null)) {
        request.getRequestDispatcher("login_.jsp").forward(request, response);
    } else {

    }
    if (!session.getAttribute("rol").equals("Coordinador")) {
        request.getRequestDispatcher("index.jsp").forward(request, response);
        }
%>


<h1><B><center>Registro de temas </center></b></h1>

<ul class="nav nav-tabs">
  <li class="active"><a href="#tema" data-toggle="tab">Registrar Temas</a></li>
  <li><a href="#subtema" data-toggle="tab">Registrar Subtemas</a></li>
</ul>
<div class="tab-content">
  <div class="tab-pane" id="tema">
  <form action="TemasController" method="POST">
            
                                    <div id="unidades">
  <div id="uni">
            <br> <br>
    <div class="clearfix"></div>
                                 <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-3 control-label" for="Unidades_idUnidad">Seleccione de la unidad:<span class="required">*</span></label>
                                    
                                    <div class="col-sm-12">
                                    <div class="input-group">
                                    <select class="form-control" name="unidad">
                                    <c:forEach items="${Unidades}" var="item">
                                            

                                            <% 
                                            
                                            
                                            %>
                                                <option value="${item.idUnidad}">${item.nombreUnidad}</option>
                                        </c:forEach>
                                       </select>
                                       <span class="input-group-btn">
                                        <a class="btn btn-primary" href="#"><span class="glyphicon glyphicon-plus"></span></a>
                                       </span>
                                       </div>
                                    </div>

                                    </div>


                                     <div class="form-group">
                                    <label class="col-sm-3 control-label" for="nombreTema">Ingrese el nombre del tema:<span class="required">*</span></label>
                                    <div class="col-sm-12">  
                                    <input required class ="form-control" id="nombreTema" type="text" name="nombreTema" value=""  />
                                    </div>
                                    </div>
                                 <br>
                                  <div  aria-hidden="true">
  <input  type="hidden" id="Temas_idTema" type="text" name="Tema" value=""/>
                                 </div>
  
</div>             
            <h5><p align="right"><font color="red">Los campos que están marcados con * son obligatorios para el registro.  </font>  </p> </h5>
        <div class="col-md-12 ">
      <div class="pull-right">
        <input type="submit" class="btn btn-primary" name ="accion" value="insertart">
      </div>
    </div>
        </form>
  </div>
        </div>
  <div class="tab-pane" id="subtema">




    <form action="TemasController" method="POST">
            
                                    <div id="unidades">
  <div id="uni">
            <br> <br>
    <div class="clearfix"></div>
                                 <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-3 control-label" for="Unidades_idUnidad">Seleccione la unidad:<span class="required">*</span></label>
                                    
                                    <div class="col-sm-12">
                                    <div class="input-group">
                                    <select class="form-control" name="unidad">
                                    <c:forEach items="${Unidades}" var="item">
                                            

                                            <% 
                                            
                                            
                                            %>
                                                <option value="${item.idUnidad}">${item.nombreUnidad}</option>
                                        </c:forEach>
                                       </select>
                                       <span class="input-group-btn">
                                        <a class="btn btn-primary" href="#"><span class="glyphicon glyphicon-plus"></span></a>
                                       </span>
                                       </div>
                                    </div>

                                    </div>

                                    <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-3 control-label" for="Temas_idTema">Seleccione el tema: <span class="required">*</span></label>
                                    
                                    <div class="col-sm-12">
                                      <div class="input-group">
                                      <select class="form-control" name="tema">
                                      <option value=""></option>
                                        <c:forEach items="${Temas}" var="item">
                                                <option value="${item.idTema}">${item.nombreTema}</option>
                                        </c:forEach>
                                       </select>
                                       <span class="input-group-btn">
                                        <a class="btn btn-primary" href="#"><span class="glyphicon glyphicon-plus"></span></a>
                                       </span>
                                       </div>
                                    </div>

                                    </div>

                                     <div class="form-group">
                                    <label class="col-sm-3 control-label" for="nombreTema">Ingrese el  nombre del subtema:<span class="required">*</span></label>
                                    <div class="col-sm-12">  
                                    <input required class ="form-control" id="nombreTema" type="text" name="nombreTema" value=""  />
                                    </div>
                                    </div>
  </div>
  
</div>                         
                    <h5><p align="right"><font color="red">Los campos que están marcados con * son obligatorios para el registro.  </font>  </p> </h5>
        <div class="col-md-12 ">
      <div class="pull-right">
        <input type="submit" class="btn btn-primary" name ="accion" value="insertarst">
      </div>
    </div>
        </form>
  </div>
</div>

        
<script>
    
        $(document).ready(function(){
         $("#agregarU").click(function(){
           var unidad = $("#uni").clone();
           
           $(unidad).appendTo("#unidades");
           console.log("ok");
           
         });
        });
        </script>
<%@include file="footer.jsp" %>