<%@include file="header.jsp" %>
 <h1><B><center>Edici�n de academias </center></b></h1>
        <form action="AcademiaController" method="POST">
        	<input type="hidden" name="idAcademia" value="${Academia.idAcademia}" />
            
                                    <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-2 control-label" for="nombreAcademia">Nombre de la academia<span class="required">*</span></label>
                                    <div class="col-sm-10">  
                                    <input required class ="form-control" id="nombreAcademia" type="text" name="nombreAcademia" value="${Academia.nombreAcademia}"  />
                                    </div>
                                    </div>
                                    

                                    <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-2 control-label" for="Personal_idPersonal">Coordionador<span class="required">*</span></label>
                                    
                                    <div class="col-sm-10">
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
                                    <h5><p align="right"><font color="red">Los campos que est�n marcados con * son obligatorios para la edici�n  </font>  </p> </h5>
                                    </div>

                                    
            
            <div class="col-md-12 ">
				<div class="pull-right">
					<input type="submit" class="btn btn-primary" name="accion" value="actualizar" />
				</div>
			</div>
        </form>
        
<%@include file="footer.jsp" %>