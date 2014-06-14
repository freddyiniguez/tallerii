<%@include file="header.jsp" %>
<h1><B><center>Asignación de experiencia educativa a personal </center></b></h1>
        <form action="ImparteController" method="POST">
        
                                    <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-3 control-label" for="ExperieciaEducativa_idExperieciaEducativa">Experiencia Educativa:<span class="required">*</span></label>
                                    
                                    <div class="col-sm-12">
                                      <div class="input-group">
                                      <select class="form-control" name="Ee">
                                        <c:forEach items="${ExperieciaEducativa}" var="item">
                                                <option value="${item.idExperieciaEducativa}">${item.nombreEe}</option>
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
                                    <label class="col-sm-3 control-label" for="Personal_idPersonal">Personal:<span class="required">*</span></label>
                                    
                                    <div class="col-sm-12">
                                      <div class="input-group">
                                      <select class="form-control" name="personal">
                                        <c:forEach items="${Personal}" var="item">
                                                <option value="${item.idPersonal}">${item.nombreProfesor}</option>
                                        </c:forEach>
                                       </select>
                                       <span class="input-group-btn">
                                        <a class="btn btn-primary" href="#"><span class="glyphicon glyphicon-question-sign"></span></a>
                                       </span>
                                       </div>
                                    </div>

                                    </div>
                                    
        <div class="col-md-12 ">
            <h5><p align="right"><font color="red">Los campos que están marcados con * son obligatorios para el registro  </font>  </p> </h5>
			<div class="pull-right">
				<input type="submit" class="btn btn-primary" name ="accion" value="insertar">
			</div>
		</div>
        </form>
<%@include file="footer.jsp" %>