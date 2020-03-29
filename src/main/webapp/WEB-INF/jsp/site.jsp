<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<%@include file="common/header.jspf"%>
<%@include file="common/navigation.jspf"%>
<div class="container-fluid">
 <div class="row justify-content-center mb-3">
  <div class="col-md-6 col-md-offset-3 ">
   <div class="panel panel-primary">
    <div class="panel-heading">Nouveau Site</div>
    <div class="panel-body">
     <form:form class="form-inline d-flex bd-highlight" method="post" modelAttribute="site">
      <form:hidden path="numSite" />
       
       <fieldset class="form-group">
	       <form:label path="nomSite">Nom du Site</form:label>
	       <form:input path="nomSite" type="text" class="form-control"
	        placeholder="Nom du site" required="required" />
	       <form:errors path="nomSite" cssClass="text-warning" />
      	</fieldset>
      	<br></br>
      	<br></br>
      	
      	<fieldset class="form-group">
      		<form:label path="siteMassif">Massif</form:label>
	      	<form:select path="siteMassif">
		     	 <c:forEach var="siteMassif" items="${siteMassif}">
				    <option value="${siteMassif.getCode()}">${siteMassif.toString()}</option>
				 </c:forEach>
	        </form:select>
        </fieldset>
      	
      	<fieldset class="form-group">
      		<form:label path="siteRegion">Région</form:label>
	      	<form:select path="siteRegion">
		     	 <c:forEach var="siteRegion" items="${siteRegion}">
				    <option value="${siteRegion.getCode()}">${siteRegion.toString()}</option>
				 </c:forEach>
	        </form:select>
        </fieldset>
	    
	    <fieldset class="form-group">
      		<form:label path="siteCotation">Cotation</form:label>
	      	<form:select path="siteCotation">
		     	 <c:forEach var="siteCotation" items="${siteCotation}">
				    <option value="${siteCotation.getCode()}">${siteCotation.toString()}</option>
				 </c:forEach>
	        </form:select>
        </fieldset>
	    <br></br> 
	    <br></br>
      
       <fieldset class="form-group">
	       <form:label path="altitude">Altitude</form:label>
	       <form:input path="altitude" type="text" class="form-control"
	        placeholder="Altitude" required="required" />
	       <form:errors path="altitude" cssClass="text-warning" />
       </fieldset>
        <br></br> 
      
       <fieldset class="form-group p-2 flex-fill bd-highlight">
	       <form:label path="hauteurMax">Hauteur Maximum</form:label>
	       <form:input path="hauteurMax" type="text" class="form-control"
	        placeholder="Hauteur Maximum" required="required" />
       <form:errors path="hauteurMax" cssClass="text-warning" />
       
       <form:label path="hauteurMin">Hauteur Minimum</form:label>
	       <form:input path="hauteurMin" type="text" class="form-control"
	        placeholder="Hauteur Minimum" required="required" />
	       <form:errors path="hauteurMin" cssClass="text-warning" />
       </fieldset>
      
      <br></br>
           
      <fieldset class="form-group">
	      <form:label path="nbVoies">Nombre de Voies</form:label>
	      <form:input path="nbVoies" type="text" class="form-control"
	       placeholder="Nombre de voies" required="required" />
	      <form:errors path="hauteurMax" cssClass="text-warning" />
	   </fieldset>
	   
	    <fieldset class="form-group">
	      <form:label path="longueurTotaleVoies">Longueur Totale des Voies</form:label>
	      <form:input path="longueurTotaleVoies" type="text" class="form-control"
	       placeholder="Longueur Totale des Voies" required="required" />
	      <form:errors path="longueurTotaleVoies" cssClass="text-warning" />
       </fieldset>
      
      <br></br>
       <br></br>
      
       
      
	                 
       <fieldset class="form-group">
      		<form:label path="siteOrientation">Orientation</form:label>
	      	<form:select path="siteOrientation">
		     	 <c:forEach var="siteOrientation" items="${siteOrientation}">
				    <option value="${siteOrientation.getCode()}">${siteOrientation.toString()}</option>
				 </c:forEach>
	        </form:select>
        </fieldset>
	    
       
       <fieldset class="form-group">
      		<form:label path="siteTypeRoche">Type de Roche </form:label>
	      	<form:select path="siteTypeRoche">
		     	 <c:forEach var="siteTypeRoche" items="${siteTypeRoche}">
				    <option value="${siteTypeRoche.getCode()}">${siteTypeRoche.toString()}</option>
				 </c:forEach>
	        </form:select>
        </fieldset>
	    <br></br>
	    
	     <fieldset class="form-group">
      		<form:label path="siteNiveauDePratique">Niveau de Pratique</form:label>
	      	<form:select path="siteNiveauDePratique">
		     	 <c:forEach var="siteNiveauDePratique" items="${siteNiveauDePratique}">
				    <option value="${siteNiveauDePratique.getCode()}">${siteNiveauDePratique.toString()}</option>
				 </c:forEach>
	        </form:select>
        </fieldset>
	   
	    
	                             
       <fieldset class="form-group">
      		<form:label path="siteTag">Tag</form:label>
	      	<form:select path="siteTag">
		     	 <c:forEach var="siteTag" items="${siteTag}">
				    <option value="${siteTag.getCode()}">${siteTag.toString()}</option>
				 </c:forEach>
	        </form:select>
        </fieldset>
	    <br></br>

      <button type="submit" class="btn btn-success">Valider</button>
     </form:form>
    </div>
   </div>
  </div>
 </div>
</div>
<%@ include file="common/footer.jspf"%>
<!-- </body>

</html>-->