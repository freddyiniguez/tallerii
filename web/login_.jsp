<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta http-equiv="content-type" content="text/html; charset=UTF-8">
        <title>GED UV</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <link href="${pageContext.request.contextPath}/assets/css/bootstrap.css" rel="stylesheet"/>
        <script src="${pageContext.request.contextPath}/assets/js/jquery.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/bootstrap.js"></script>
        <style>
            body {
                padding-top: 70px;
            }
        </style>
    </head>
    <!-- HTML code from Bootply.com editor -->
    
    <%    if ((session.getAttribute("user") != null)) {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    } 
    if (session.getAttribute("estado")==null) {
               session.setAttribute("estado", "");
            }
    
    
    
%>
    
    <body  >
        
        <!--login modal-->
        <form name="Flogin" method="post" action="LoginController">
<div id="loginModal" class="modal show" tabindex="-1" role="dialog" aria-hidden="true">
  <div class="modal-dialog">
  <div class="modal-content">
      <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
          <h1 class="text-center">Login</h1>
          <h3 class="text-center">GEDUV</h3>
          <h1 class="text-center"><img src="./assets/images/uv_logo.png" alt=""></h1>
          <h3 class="text-center">Generador de examenes departamentales</h3>
      </div>
      <div class="modal-body">
          <form class="form col-md-12 center-block">
            <div class="form-group">
              <input name="usuario" type="text" class="form-control input-lg" placeholder="Usuario">
            </div>
            <div class="form-group">
              <input name="password" type="password" class="form-control input-lg" placeholder="Contraseña">
            </div>
            <div class="form-group">
                <input type="submit" value="Enviar" class="btn btn-primary">
                <br>
                <%= session.getAttribute("estado")%>
            </div>
          </form>
      </div>
      <div class="modal-footer">
      </div>
  </div>
  </div>
</div>
      </form>  
        <script type='text/javascript' src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>


        <script type='text/javascript' src="./assets/js/bootstrap.min.js"></script>





        
        <!-- JavaScript jQuery code from Bootply.com editor -->
        
        <script type='text/javascript'>
        
        $(document).ready(function() {
        
            
        
        });
        
        </script>
        
    </body>
</html>