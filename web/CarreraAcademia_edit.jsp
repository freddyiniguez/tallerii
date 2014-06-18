<%@include file="header_ADM.jsp" %>

<%--<%    if ((session.getAttribute("user") == null)) {
        request.getRequestDispatcher("login_.jsp").forward(request, response);
    } else {

    }
    if (!session.getAttribute("rol").equals("Administrador")) {
        request.getRequestDispatcher("index.jsp").forward(request, response);
        }
%>--%>

<h1><B><center>Edición de una carrera en academia </center></b></h1>
        <form action="CarreraAcademiaController" method="POST" name="carreraacademia">
        	<input type="hidden" name="idCarreraAcademia" value="${CarreraAcademia.idCarreraAcademia}" />
                <input type="hidden" name="idCarrera" value="${carrera.idCarrera}" />
                <input type="hidden" name="idAcademia" value="${academia.idAcademia}" />
            
                                    <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-2 control-label" for="Carrera_idCarrera">Carrera<span class="required">*</span></label>
                                    
                                    <div class="col-sm-10">
                                      <div class="input-group">
                                      <select class="form-control" name="carrera">
                                        <c:forEach items="${Carrera}" var="item">
                                                <option value="${item.idCarrera}">${item.nombreCarrera}</option>
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
                                    <label class="col-sm-2 control-label" for="Academia_idAcademia">Academia<span class="required">*</span></label>
                                    
                                    <div class="col-sm-10">
                                      <div class="input-group">
                                      <select class="form-control" name="academia">
                                        <c:forEach items="${Academia}" var="item">
                                                <option index="${item.idAcademia}" value="${item.idAcademia}">${item.nombreAcademia}</option>
                                        </c:forEach>
                                                 
                                                     
                                                     <script>
                                                       
                                                        var j=0;
                                                        var nombre2="";
                                            for(j=0;j<=document.carreraacademia.carrera.options.length;j++){
                                               nombre2=carreraacademia.carrera.options[j].value;
                                               var t=${carrera.idCarrera};
                                               var s2= t.toString();
                                             if(nombre2 === s2){
                                                 carreraacademia.carrera.options[j].selected = true;
                                               return false;
                                            }
                                            }
                                                     </script>
                                       </select>
                                               
                                                  <script>
                                                        var i=0;
                                                        var nombre="";
                                           for(i=0;i<=document.carreraacademia.academia.options.length;i++){
                                               nombre=carreraacademia.academia.options[i].value;
                                               var n=${academia.idAcademia};
                                               var s= n.toString();
                                             if(nombre === s){
                                                 carreraacademia.academia.options[i].selected = true;
                                               return false;
                                            }
                                            }
                                                     </script>
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