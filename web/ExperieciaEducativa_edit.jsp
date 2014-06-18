<%@include file="header_ADM.jsp" %>

<%--<%    if ((session.getAttribute("user") == null)) {
        request.getRequestDispatcher("login_.jsp").forward(request, response);
    } else {

    }
    if (!session.getAttribute("rol").equals("Administrador")) {
        request.getRequestDispatcher("index.jsp").forward(request, response);
        }
%>--%>

<h1><B><center>Edición de experiencia educativa </center></b></h1>
        <form action="ExperieciaEducativaController" method="POST" name="ExperienciaE">
        	<input type="hidden" name="idExperieciaEducativa" value="${ExperieciaEducativa.idExperieciaEducativa}" />
                <input type="hidden" name="idExperieciaEducativa" value="${academia.idAcademia}" />
            
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
                                    <input required class ="form-control" id="nombreEE" type="text" name="nombreEE" value="${ExperieciaEducativa.nombreEe}" maxlength="60"  />
                                    </div>
                                    </div>
                                    
                                         <script>
                                                        var i=0;
                                                        var nombre="";
                                           for(i=0;i<=document.ExperienciaE.academia.options.length;i++){
                                               nombre=ExperienciaE.academia.options[i].value;
                                               var n=${academia.idAcademia};
                                               var s= n.toString();
                                             if(nombre === s){
                                                 ExperienciaE.academia.options[i].selected = true;
                                               return false;
                                            }
                                            }
                                                     </script>
                                    
            
            <div class="col-md-12 ">
                <h5><p align="right"><font color="red">Los campos que están marcados con * son obligatorios para la edición </font>  </p> </h5>
				<div class="pull-right">
					<input type="submit" class="btn btn-primary" name="accion" value="actualizar" />
				</div>
			</div>
        </form>
        
<%@include file="footer.jsp" %>