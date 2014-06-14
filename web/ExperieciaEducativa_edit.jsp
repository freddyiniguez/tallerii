<%@include file="header.jsp" %>
<h1><B><center>Edici�n de experiencia educativa </center></b></h1>
        <form action="ExperieciaEducativaController" method="POST">
        	<input type="hidden" name="idExperieciaEducativa" value="${ExperieciaEducativa.idExperieciaEducativa}" />
            
                                    <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-3 control-label" for="Academia_idAcademia">Academia:<span class="required">*</span></label>
                                    
                                    <div class="col-sm-12">
                                      <div class="input-group">
                                      <select class="form-control" name="academia">
                                        <c:forEach items="${Academia}" var="item">
                                                <option value="${item.idAcademia}">${item.nombreAcademia}</option>
                                        </c:forEach>
                                       </select>
                                       <span class="input-group-btn">
                                        <a class="btn btn-primary" href="#"><span class="glyphicon glyphicon-question-sign"></span></a>
                                       </span>
                                       </div>
                                    </div>
                                    
                                    </div>

                                    

                                    <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-4 control-label" for="nombreEE">Nombre de la experiencia educativa:<span class="required">*</span></label>
                                    <div class="col-sm-12">  
                                    <input required class ="form-control" id="nombreEE" type="text" name="nombreEE" value="${ExperieciaEducativa.nombreEe}"  />
                                    </div>
                                    </div>
                                    
            
            <div class="col-md-12 ">
                <h5><p align="right"><font color="red">Los campos que est�n marcados con * son obligatorios para la edici�n </font>  </p> </h5>
				<div class="pull-right">
					<input type="submit" class="btn btn-primary" name="accion" value="actualizar" />
				</div>
			</div>
        </form>
        
<%@include file="footer.jsp" %>