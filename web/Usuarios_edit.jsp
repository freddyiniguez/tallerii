<%@include file="header_ADM.jsp" %>

<%    if ((session.getAttribute("user") == null)) {
        request.getRequestDispatcher("login_.jsp").forward(request, response);
    } else {

    }
    if (!session.getAttribute("rol").equals("Administrador")) {
        request.getRequestDispatcher("index.jsp").forward(request, response);
        }
%>

<h1><B><center>Edici�n de usuario  </center></b></h1>
        <form action="UsuariosController" method="POST" name="usuarios">
        	<input type="hidden" name="idUsuario" value="${Usuarios.idUsuario}" />
                <input type="hidden" name="idUPersonal" value="${persona.idPersonal}" />
            
                                    <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-3 control-label" for="loginUsuario">Nombre de usuario:<span class="required">*</span></label>
                                    <div class="col-sm-12">  
                                    <input required class ="form-control" id="loginUsuario" type="text" name="loginUsuario" value="${Usuarios.loginUsuario}"  />
                                    </div>
                                    </div>
                                    

                                    <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-3 control-label" for="passwordUsuario">Contrase�a:<span class="required">*</span></label>
                                    <div class="col-sm-12">  
                                    <input required class ="form-control" id="passwordUsuario" type="password" name="passwordUsuario" value="${Usuarios.passwordUsuario}"  />
                                    </div>
                                    </div>
                                    <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-3 control-label" for="estadoUsuario">Rol:<span class="required">*</span></label>
                                    <div class="col-sm-12">                                
                                    <select class="form-control" name="rol" id="estadoUsuario">
                                    <option value="Administrador">Administrador</option>
                                    <option value="Usuario">Usuario</option>
                                    </select>
                                        
                                        
                                    </div>
                                    </div>
                                    

                                    <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-3 control-label" for="estadoUsuario">Estado:<span class="required">*</span></label>
                                    <div class="col-sm-12">                                
                                    <select class="form-control" name="estadoUsuario" id="estadoUsuario">
                                    <option value="activo">Activo</option>
                                    <option value="inactivo">Inactivo</option>
                                    </select>
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
                                    
                                     <script>
                                                        var i=0;
                                                        var nombre="";
                                           for(i=0;i<=document.usuarios.personal.options.length;i++){
                                               nombre=usuarios.personal.options[i].value;
                                               var n=${persona.idPersonal};
                                               var s= n.toString();
                                             if(nombre === s){
                                                 usuarios.personal.options[i].selected = true;
                                               return false;
                                            }
                                            }
                                                     </script>
                                                     
                                                      <script>
                                                        var j=0;
                                                        var nombre2="";
                                           for(j=0;j<=document.usuarios.estadoUsuario.options.length;j++){
                                               nombre2=usuarios.estadoUsuario.options[j].value;
                                               var n2=${Usuarios.estadoUsuario};
                                             if(nombre === n2){
                                                 usuarios.estadoUsuario.options[j].selected = true;
                                               return false;
                                            }
                                            }
                                                     </script>
                                    
                                    </div>

                                    <h5><p align="right"><font color="red">Los campos que est�n marcados con * son obligatorios para la edici�n.  </font>  </p> </h5>
            
            <div class="col-md-12 ">
				<div class="pull-right">
					<input type="submit" class="btn btn-primary" name="accion" value="actualizar" />
				</div>
			</div>
        </form>
        
<%@include file="footer.jsp" %>