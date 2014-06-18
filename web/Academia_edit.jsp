<%@include file="header_ADM.jsp" %>

<%    if ((session.getAttribute("user") == null)) {
        request.getRequestDispatcher("login_.jsp").forward(request, response);
    } else {

    }
    if (!session.getAttribute("rol").equals("Administrador")) {
        request.getRequestDispatcher("index.jsp").forward(request, response);
        }
%>
<h1><B><center>Edición de academias </center></b></h1>
        <form action="AcademiaController" method="POST" name="academia">
        	<input type="hidden" name="idAcademia" value="${Academia.idAcademia}" />
                <input type="hidden" name="idPersonal" value="${Personal.idPersonal}" />
            
                                    <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-2 control-label" for="nombreAcademia" >Nombre de la academia<span class="required">*</span></label>
                                    <div class="col-sm-10">  
                                    <input required class ="form-control" id="nombreAcademia" type="text" name="nombreAcademia" value="${Academia.nombreAcademia}" maxlength="60" />
                                    </div>
                                    </div>
                                    
                                   
             <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-2 control-label" for="Personal_idPersonal" >Lista de coordinadores<span class="required">*</span></label>
                                    
                                    <div class="col-sm-10">
                                      <div class="input-group">
                                      <select class="form-control" name="personal" text="${Personal.nombreProfesor}">
                                        
                                        <c:forEach items="${Maestros}" var="item" >
                                                <option value="${item.idPersonal}">${item.nombreProfesor}</option>
                                        </c:forEach>
                                                                                               
                                                   <script>
                                                        var i=0;
                                                        var nombre="";
                                           for(i=0;i<=document.academia.personal.options.length;i++){
                                               nombre=academia.personal.options[i].value;
                                               var n=${Personal.idPersonal};
                                               var s= n.toString();
                                             if(nombre === s){
                                                 academia.personal.options[i].selected = true;
                                               return false;
                                            }
                                            }
                                                     </script>
                                                
                                       </select>
                                       <span class="input-group-btn">
                                        <a class="btn btn-primary" href="#"><span class="glyphicon glyphicon-question-sign"></span></a>
                                       </span>
                                       </div>
                                    </div>
                                    <h5><p align="right"><font color="red">Los campos que están marcados con * son obligatorios para la edición  </font>  </p> </h5>
                                    </div>  
            
            <div class="col-md-12 ">
				<div class="pull-right">
					<input type="submit" class="btn btn-primary" name="accion" value="actualizar" />
				</div>
			</div>
        </form>
        
<%@include file="footer.jsp" %>