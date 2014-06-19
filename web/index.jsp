<% if(session.getAttribute("rol")=="Administrador"){  
%>  
<jsp:include page="header_ADM.jsp" flush="true" /> 
<%}%>  

<% if(session.getAttribute("rol")=="Coordinador"){  
%>  
<jsp:include page="header_COORD.jsp" flush="true" /> 
<%}%> 

<% if(session.getAttribute("rol")=="Profesor"){  
%>  
<jsp:include page="header_PROF.jsp" flush="true" /> 
<%}%>

<%    if ((session.getAttribute("user") == null)) {
        request.getRequestDispatcher("login_.jsp").forward(request, response);
    } else {

    }
%>

Bienvenido al sistema!
<br>
<%="id de usuario= "+session.getAttribute("idusuario")%>
<br>
<%="rol= "+session.getAttribute("rol")%>
<br>
<%="id de academia= "+session.getAttribute("academia")%>
<br>
<h3>DEBUG de Materias</h3>
<select name="tabla1" id="tabla1">
 
<% 
java.util.ArrayList<edu.uv.model.pojos.ExperieciaEducativa> list = (java.util.ArrayList)session.getAttribute("matslist");
if(list!=null)
for(edu.uv.model.pojos.ExperieciaEducativa en:list){
%>
<option value=<%= en.getIdExperieciaEducativa()%> > <%= en.getNombreEe()%> </option >
<%};%>
</select>

<h3>DEBUG de Unidades ${idpersonal}</h3>
<select name="tabla1" id="tabla2">
<% 
java.util.ArrayList<edu.uv.model.pojos.Unidades> list2 = (java.util.ArrayList)session.getAttribute("unidadesList");
if(list2!=null)
for(edu.uv.model.pojos.Unidades en:list2){
%>
<option value=<%= en.getIdUnidad()%> > <%= en.getNombreUnidad()%> </option >
<%};%>
</select>




<%@include file="footer.jsp" %>