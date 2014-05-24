<%@include file="header.jsp" %>
<h1>Registro de Carreras </h1>
        <form action="ExamenesGeneradosController" method="POST">
        	<input type="hidden" name="idexamenesGenerados" value="${ExamenesGenerados.idexamenesGenerados}" />
            
                                    <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-2 control-label" for="periodo">Periodo<span class="required">*</span></label>
                                    <div class="col-sm-10">  
                                    <input required class ="form-control" id="periodo" type="text" name="periodo" value="${ExamenesGenerados.periodo}"  />
                                    </div>
                                    </div>
                                    

                                    <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-2 control-label" for="tipoExamen">TipoExamen<span class="required">*</span></label>
                                    <div class="col-sm-10">  
                                    <input required class ="form-control" id="tipoExamen" type="text" name="tipoExamen" value="${ExamenesGenerados.tipoExamen}"  />
                                    </div>
                                    </div>
                                    
                                    

                                    <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-2 control-label" for="descripcionExamen">Descripcion<span class="required">*</span></label>
                                    <div class="col-sm-10">                                
                                    <textarea required class="form-control" id="descripcionExamen" name="descripcionExamen">${ExamenesGenerados.descripcionExamen}</textarea>
                                    </div>
                                    </div>
                                    

                                    <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-2 control-label" for="porcTeoria">% Teoria<span class="required">*</span></label>
                                    <div class="col-sm-10">  
                                    <input required class ="form-control" id="porcTeoria" type="number" name="porcTeoria" value="${ExamenesGenerados.porcTeoria}"  />
                                    </div>
                                    </div>
                                    

                                    <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-2 control-label" for="porcPractica">% Practica<span class="required">*</span></label>
                                    <div class="col-sm-10">  
                                    <input required class ="form-control" id="porcPractica" type="number" name="porcPractica" value="${ExamenesGenerados.porcPractica}"  />
                                    </div>
                                    </div>
                                    

                                    <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-2 control-label" for="estadoExamen">Estado<span class="required">*</span></label>
                                    <div class="col-sm-10">  
                                    <input required class ="form-control" id="estadoExamen" type="text" name="estadoExamen" value="${ExamenesGenerados.estadoExamen}"  />
                                    </div>
                                    </div>
                                    

                                    <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-2 control-label" for="Personal_idPersonal">Personal<span class="required">*</span></label>
                                    
                                    <div class="col-sm-10">
                                      <div class="input-group">
                                      <select class="form-control" name="personal">
                                        <c:forEach items="${Personal}" var="item">
                                                <option value="${item.idPersonal}">${item.idPersonal}</option>
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
                                    <label class="col-sm-2 control-label" for="ExperieciaEducativa_idExperieciaEducativa">Experiencia educativa<span class="required">*</span></label>
                                    
                                    <div class="col-sm-10">
                                      <div class="input-group">
                                      <select class="form-control" name="ee">
                                        <c:forEach items="${ExperieciaEducativa}" var="item">
                                                <option value="${item.idExperieciaEducativa}">${item.nombreEe}</option>
                                        </c:forEach>
                                       </select>
                                       <span class="input-group-btn">
                                        <a class="btn btn-primary" href="#"><span class="glyphicon glyphicon-plus"></span></a>
                                       </span>
                                       </div>
                                    </div>
                                    
                                    </div>

                                    
            
            <div class="col-md-12 ">
				<div class="pull-right">
					<input type="submit" class="btn btn-primary" name="accion" value="actualizar" />
				</div>
			</div>
        </form>
        
<%@include file="footer.jsp" %>