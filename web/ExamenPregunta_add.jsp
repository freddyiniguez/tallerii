<%@include file="header_ADM.jsp" %>
<h1><B><center>Elección de preguntas a examen</center></b></h1>
        <form action="ExamenPreguntaController" method="POST">
        
                                    <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-3 control-label" for="examenesGenerados_idexamenesGenerados">Examenes Generados:<span class="required">*</span></label>
                                    
                                    <div class="col-sm-12">
                                      <div class="input-group">
                                      <select class="form-control" name="EG">
                                        <c:forEach items="${ExamenesGenerados}" var="item">
                                                <option value="${item.idexamenesGenerados}">${item.tipoExamen}</option>
                                                
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
                                    <label class="col-sm-3 control-label" for="Pregunta_idPregunta">Preguntas:<span class="required">*</span></label>
                                    
                                    <div class="col-sm-12">
                                      <div class="input-group">
                                      <select class="form-control" name="personal">
                                        <c:forEach items="${Preguntas}" var="item">
                                                <option value="${item.idPregunta}">${item.descripcionPregunta}</option>
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
                                    <label class="col-sm-2 control-label" for="puntaje">Puntaje
                                        <span class="required">*</span>
                                    </label>
                                    <div class="col-sm-10">                       
                                    <input required class ="form-control" id="puntaje" type="text" name="puntaje" value="" maxlength="11" />
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