<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% if(session.getAttribute("rol")=="Coordinador"){  
%>  
<jsp:include page="header_COORD.jsp" flush="true" /> 
<%}%> 

<% if(session.getAttribute("rol")=="Profesor"){  
%>  
<jsp:include page="header_PROF.jsp" flush="true" /> 
<%}%>
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
<h1><B><center>Registro de los exámenes generados </center></b></h1>
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
                                    <label class="col-sm-3 control-label" for="tipoExamen">Tipo de exámen:<span class="required">*</span></label>
                                    <div class="col-sm-12">  
                                        <select name="tipoExamen" class="form-control">
                                            <option value="Parcial">Parcial</option>
                                            <option value="Parcial">Ordinario</option>
                                            <option value="Parcial">Extra</option>
                                        </select>
                                    </div>
                                    </div>
                                    
                                    

                                    <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-3 control-label" for="descripcionExamen">Descripción del examen:<span class="required">*</span></label>
                                    <div class="col-sm-12">                                
                                    <textarea required class="form-control" id="descripcionExamen" name="descripcionExamen"></textarea>
                                    </div>
                                    </div>
                                    

                                    <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-3 control-label" for="porcTeoria">Porcentaje Teórico:<span class="required">*</span></label>
                                    <div class="col-sm-12">  
                                    <input required class ="form-control" id="porcTeoria" type="number" name="porcTeoria" value="" onChange="redirect()"  />
                                    </div>
                                    </div>
                                    

                                    <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-3 control-label" for="porcPractica">Porcentaje Práctico:<span class="required">*</span></label>
                                    <div class="col-sm-12">  
                                    <input required class ="form-control" id="porcPractica" type="number" name="porcPractica" value="" onChange="redirect2()" />
                                    </div>
                                    </div>
                                    

                                    <div class="clearfix"></div>
                                    <div class="form-group">
                                    <div class="col-sm-12">
                                    <input required class ="form-control" id="estadoExamen" type="hidden" name="estadoExamen" value="NoAprobado"  />
                                    </div>
                                    </div>
                                    

                                    <div class="clearfix"></div>
                                    <div class="form-group">
                                    <div class="col-sm-12">
                                      <div class="input-group">
                                      <input type="hidden" name="personal" value="<%=session.getAttribute("idusuario")%>">
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
            <h5><p align="right"><font color="red">Los campos que están marcados con * son obligatorios para el registro  </font>  </p> </h5>
			<div class="pull-right">
				<input type="submit" class="btn btn-primary" name ="accion" value="insertar">
			</div>
		</div>
        </form>
<%@include file="footer.jsp" %>
