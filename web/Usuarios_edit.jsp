<%@include file="header.jsp" %>
<h1>Registro de Carreras </h1>
        <form action="UsuariosController" method="POST">
        	<input type="hidden" name="idUsuario" value="${Usuarios.idUsuario}" />
            
                                    <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-2 control-label" for="loginUsuario">Usuario<span class="required">*</span></label>
                                    <div class="col-sm-10">  
                                    <input required class ="form-control" id="loginUsuario" type="text" name="loginUsuario" value="${Usuarios.loginUsuario}"  />
                                    </div>
                                    </div>
                                    

                                    <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-2 control-label" for="passwordUsuario">Contraseña<span class="required">*</span></label>
                                    <div class="col-sm-10">  
                                    <input required class ="form-control" id="passwordUsuario" type="password" name="passwordUsuario" value="${Usuarios.passwordUsuario}"  />
                                    </div>
                                    </div>
                                    <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-2 control-label" for="estadoUsuario">Rol<span class="required">*</span></label>
                                    <div class="col-sm-10">                                
                                    <select class="form-control" name="rol" id="estadoUsuario">
                                    <option value="Administrador">Administrador</option>
                                    <option value="Usuario">Usuario</option>
                                    </select>
                                    </div>
                                    </div>
                                    

                                    <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-2 control-label" for="estadoUsuario">Estado<span class="required">*</span></label>
                                    <div class="col-sm-10">                                
                                    <select class="form-control" name="estadoUsuario" id="estadoUsuario">
                                    <option value="activo">activo</option>
                                    <option value="inactivo">inactivo</option>
                                    </select>
                                    </div>
                                    </div>
                                    

                                    <div class="clearfix"></div>
                                    <div class="form-group">
                                    <label class="col-sm-2 control-label" for="Personal_idPersonal">Personal<span class="required">*</span></label>
                                    
                                    <div class="col-sm-10">
                                      <div class="input-group">
                                      <select class="form-control" name="personal">
                                        <c:forEach items="${Personal}" var="item">
                                                <option value="${item.idPersonal}">${item.nombreProfesor}</option>
                                        </c:forEach>
                                       </select>
                                       <span class="input-group-btn">
                                        <a class="btn btn-primary" href="#"><span class="glyphicon glyphicon-plus"></span></a>
                                       </span>
                                       </div>
                                    </div>
                                    
                                    </div>

                                    
            
            <div class="col-md-12 ">
				<div class="pull-right">
					<input type="submit" class="btn btn-primary" name="accion" value="actualizar" />
				</div>
			</div>
        </form>
        
<%@include file="footer.jsp" %>