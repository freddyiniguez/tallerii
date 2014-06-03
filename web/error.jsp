<%-- 
    Document   : error
    Created on : 28/05/2014, 10:57:45 AM
    Author     : kiike
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>

        <div class="jumbotron " > 
        <form name="forma1" action="AcademiaController" method="POST">
            <c:if  test="${!empty mensajes}">
    <div class="panel panel-default">
 
        <div class="panel-heading"><h3><span class="label label-danger">Ha ocurrido un error :(</span></h3></div>

                <table class="table">
                    
                    <tr>
                        <td> <span class="label label-primary">Campo</span></td>
                        <td> <span class="label label-primary">Error</span></td>
                    </tr>
                    <c:forEach items="${mensajes}" var="error">

                        <tr >
                            <td><span class="label label-info">${error.getPropertyPath()}</span> </td>
                            <td><span class="label label-warning">${error.getMessage()}</span></td>
                             
                        </tr>
                        
                    </c:forEach>
                       <tr>
                            <td>   
                                <a class="btn btn-success" href="${url}">Volver</a>
                            </td>
                        </tr>


                </table>

            </c:if>
        </form>
        </div>
        </div>
<%@include file="footer.jsp" %>