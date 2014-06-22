<%@include file="header_ADM.jsp" %>
<script>
    
     function redirect(){
         
         var valor = document.getElementById("porcTeoria").value;
         document.getElementById("porcPractica").value = 100-valor;
         //alert(valor);
        
     }
      function redirect2(){
         
         var valor = document.getElementById("porcPractica").value;
         document.getElementById("porcTeoria").value = 100-valor;
         //alert(valor);
        
     }
    
</script>
<h1><B><center>Registro de los ex�menes generados </center></b></h1>
        <form action="ExamenesGeneradosController" method="POST">
                                    <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-3 control-label" for="periodo">Periodo escolar:<span class="required">*</span></label>
                                    <div class="col-sm-12">  
                                    <input required class ="form-control" id="periodo" type="text" name="periodo" value=""  />
                                    </div>
                                    </div>
                                    

                                    <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-3 control-label" for="tipoExamen">Tipo de ex�men:<span class="required">*</span></label>
                                    <div class="col-sm-12">  
                                    <input required class ="form-control" id="tipoExamen" type="text" name="tipoExamen" value=""  />
                                    </div>
                                    </div>
                                    
                                    

                                    <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-3 control-label" for="descripcionExamen">Descripci�n del examen:<span class="required">*</span></label>
                                    <div class="col-sm-12">                                
                                    <textarea required class="form-control" id="descripcionExamen" name="descripcionExamen"></textarea>
                                    </div>
                                    </div>
                                    

                                    <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-3 control-label" for="porcTeoria">Porcentaje Te�rico:<span class="required">*</span></label>
                                    <div class="col-sm-12">  
                                    <input required class ="form-control" id="porcTeoria" type="number" name="porcTeoria" value="" onChange="redirect()"  />
                                    </div>
                                    </div>
                                    

                                    <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-3 control-label" for="porcPractica">Porcentaje Pr�ctico:<span class="required">*</span></label>
                                    <div class="col-sm-12">  
                                    <input required class ="form-control" id="porcPractica" type="number" name="porcPractica" value="" onChange="redirect2()" />
                                    </div>
                                    </div>
                                    

                                    <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-3 control-label" for="estadoExamen">Estado:<span class="required">*</span></label>
                                    <div class="col-sm-12">  
                                    <input required class ="form-control" id="estadoExamen" type="text" name="estadoExamen" value=""  />
                                    </div>
                                    </div>
                                    

                                    <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-3 control-label" for="Personal_idPersonal">Personal:<span class="required">*</span></label>
                                    
                                    <div class="col-sm-12">
                                      <div class="input-group">
                                      <select class="form-control" name="personal">
                                          
                                        <c:forEach items="${Personal}" var="item">
                                                <option value="${item.idPersonal}">${item.idPersonal}</option>
                                        </c:forEach>
                                       </select>
                                       <span class="input-group-btn">
                                           <%--
                                        <a class="btn btn-primary" href="#"><span class="glyphicon glyphicon-question-sign"></span></a>
                                           --%>
                                       </span>
                                       </div>
                                    </div>

                                    </div>
                                    

                                    <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-3 control-label" for="ExperieciaEducativa_idExperieciaEducativa">Experiencia educativa:<span class="required">*</span></label>
                                    
                                    <div class="col-sm-12">
                                      <div class="input-group">
                                      <select class="form-control" name="ee">
                                        <c:forEach items="${ExperieciaEducativa}" var="item">
                                                <option value="${item.idExperieciaEducativa}">${item.nombreEe}</option>
                                        </c:forEach>
                                       </select>
                                       <span class="input-group-btn">
                                           <%--
                                        <a class="btn btn-primary" href="#"><span class="glyphicon glyphicon-question-sign"></span></a>
                                           --%>
                                       </span>
                                       </div>
                                    </div>
                                   
                                    </div>
                                    
        <div class="col-md-12 ">
            <h5><p align="right"><font color="red">Los campos que est�n marcados con * son obligatorios para el registro  </font>  </p> </h5>
			<div class="pull-right">
				<input type="submit" class="btn btn-primary" name ="accion" value="insertar">
			</div>
		</div>
        </form>
<%@include file="footer.jsp" %>
