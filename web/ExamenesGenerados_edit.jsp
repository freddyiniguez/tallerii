<% if(session.getAttribute("rol")=="Coordinador"){  
%>  
<jsp:include page="header_COORD.jsp" flush="true" /> 
<%}%> 

<% if(session.getAttribute("rol")=="Profesor"){  
%>  
<jsp:include page="header_PROF.jsp" flush="true" /> 
<%}%>

<%--<%    if ((session.getAttribute("user") == null)) {
        request.getRequestDispatcher("login_.jsp").forward(request, response);
    } else {

    }
    if (session.getAttribute("rol").equals("Administrador")) {
        request.getRequestDispatcher("index.jsp").forward(request, response);
        }
%>--%>


<h1><B><center>Edición de exámenes generados </center></b></h1>
        <form action="ExamenesGeneradosController" method="POST">
        	<input type="hidden" name="idexamenesGenerados" value="${ExamenesGenerados.idexamenesGenerados}" />
            
                                    <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-3 control-label" for="periodo">Periodo escolar:<span class="required">*</span></label>
                                    <div class="col-sm-12">  
                                    <input required class ="form-control" id="periodo" type="text" name="periodo" value="${ExamenesGenerados.periodo}"  />
                                    </div>
                                    </div>
                                    

                                    <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-3 control-label" for="tipoExamen">Tipo de exámen:<span class="required">*</span></label>
                                    <div class="col-sm-12">  
                                        <select name="tipoExamen" class="form-control">
                                            <option value="${ExamenesGenerados.estadoExamen}">${ExamenesGenerados.tipoExamen}</option>
                                            <option value="Parcial">Parcial</option>
                                            <option value="Parcial">Ordinario</option>
                                            <option value="Parcial">Extra</option>
                                        </select>
                                   </div>
                                    </div>
                                    
                                    

                                    <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-3 control-label" for="descripcionExamen">Descripción del exámen:<span class="required">*</span></label>
                                    <div class="col-sm-12">                                
                                    <textarea required class="form-control" id="descripcionExamen" name="descripcionExamen">${ExamenesGenerados.descripcionExamen}</textarea>
                                    </div>
                                    </div>
                                    
                                    <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-3 control-label" for="estadoExamen">Estado:<span class="required">*</span></label>
                                    <div class="col-sm-12">  
                                        <select name="estadoExamen" class="form-control">
                                            <option value="${ExamenesGenerados.estadoExamen}">${ExamenesGenerados.estadoExamen}</option>
                                            <option value="Aprobado">Aprobado</option>
                                            <option value="NoAprobado">NoAprobado</option>
                                        </select>
                                    </div>
                                    </div>
           <h5><p align="right"><font color="red">Los campos que están marcados con * son obligatorios para la edición  </font>  </p> </h5>                         
            
            <div class="col-md-12 ">
				<div class="pull-right">
					<input type="submit" class="btn btn-primary" name="accion" value="actualizar" />
				</div>
			</div>
        </form>
        
<%@include file="footer.jsp" %>