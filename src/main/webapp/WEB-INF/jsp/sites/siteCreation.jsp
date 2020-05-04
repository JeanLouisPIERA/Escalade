<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>


<head>

<title>Site Creation</title>
<%@ include file="/WEB-INF/jsp/common/header1.jspf"%>
</head>


<body> 

<div id= "header1">
<%@ include file="/WEB-INF/jsp/common/header1.jspf"%>
<%@ include file="/WEB-INF/jsp/common/navigation.jspf"%>

<div class="container-fluid">
 <div class="row justify-content-center mb-3">
  <div class="col-md-8 col-md-offset-2 ">
  
   <div class="panel panel-primary">
    <div class="panel-heading">Fiche de création d'un Site</div>
    
    <div class="panel-body">
    
     <form:form class="form-inline d-flex bd-highlight" method="POST" modelAttribute="site">
      <form:hidden path="numSite"/>    
        
       <fieldset class="form-row">
       <fieldset class="form-group">
	       <form:label path="nomSite" class="col-auto col-form-label">Nom du Site</form:label>
	       <form:input path="nomSite" type="text" class="form-control"
	        placeholder="e.g Mont-Blanc" required="required" />
	       <form:errors path="nomSite" cssClass="text-warning" />
      	</fieldset>
      	      	
      	<fieldset class="form-group">
      		<form:label path="siteMassif" class="col-auto col-form-label">Massif</form:label>
      		<!-- form: path="siteMassif" type="text" class="form-control"
	        placeholder="Massif"/-->
	      	<form:select path="siteMassif" class="form-control">
		     	 <c:forEach var="siteMassif" items="${siteMassif}">
				    <option value="${siteMassif.getCode()}">${siteMassif.toString()}</option>
				 </c:forEach>
	        </form:select>
	        </fieldset>
      	
      	
      	<fieldset class="form-group">
      		<form:label path="siteRegion" class="col-auto col-form-label">Région</form:label>
      		<form:select path="siteRegion" class="form-control">
      		<!-- form:input path="siteRegion" type="text" class="form-control"
	        placeholder="Region" required="required" /-->
		     	 <c:forEach var="siteRegion" items="${siteRegion}">
				    <option value="${siteRegion.getCode()}">${siteRegion.toString()}</option>
				 </c:forEach>
	        </form:select>
       </fieldset>
      	      	
      	<fieldset class="form-group">
      		<form:label path="siteCotation" class="col-auto col-form-label">Cotation</form:label>
	      	<form:select path="siteCotation" class="form-control">
		     	 <c:forEach var="siteCotation" items="${siteCotation}">
				    <option value="${siteCotation.getCode()}">${siteCotation.toString()}</option>
				 </c:forEach>
	        </form:select>
        </fieldset>
        
        </fieldset>
       
        <br>
        <fieldset class="form-row">
         <sec:authorize access="hasAuthority('ADMIN')">
         <fieldset class="form-group">
      		<form:label path="siteTag" class="col-auto col-form-label" >Tag</form:label>
	      	<form:select path="siteTag" class="form-control">
		     	 <c:forEach var="siteTag" items="${siteTag}">
				    <option value="${siteTag.getCode()}">${siteTag.toString()}</option>
				 </c:forEach>
	        </form:select>
        </fieldset>
        </sec:authorize>
        
         <fieldset class="form-group">
      		<form:label path="siteNiveauDePratique" class="col-auto col-form-label">Niveau de Pratique</form:label>
	      	<form:select path="siteNiveauDePratique" class="form-control">
		     	 <c:forEach var="siteNiveauDePratique" items="${siteNiveauDePratique}">
				    <option value="${siteNiveauDePratique.getCode()}">${siteNiveauDePratique.toString()}</option>
				 </c:forEach>
	        </form:select>
	          </fieldset>
        
        <fieldset class="form-group">
      		<form:label path="siteTypeRoche" class="col-auto col-form-label">Type de Roche </form:label>
	      	<form:select path="siteTypeRoche" class="form-control">
		     	 <c:forEach var="siteTypeRoche" items="${siteTypeRoche}">
				    <option value="${siteTypeRoche.getCode()}">${siteTypeRoche.toString()}</option>
				 </c:forEach>
	        </form:select>
        </fieldset>
	   
	   
	    </fieldset>
	    
	    <br>
      
    	 <fieldset class="form-row">
           
      	<fieldset class="form-group">
      		<form:label path="siteOrientation" class="col-auto col-form-label">Orientation</form:label>
	      	<form:select path="siteOrientation" class="form-control">
		     	 <c:forEach var="siteOrientation" items="${siteOrientation}">
				    <option value="${siteOrientation.getCode()}">${siteOrientation.toString()}</option>
				 </c:forEach>
	        </form:select>
	        </fieldset>
      	
      	<fieldset class="form-group">  
	       <form:label path="altitude" class="col-auto col-form-label">Altitude
	       </form:label>
	       <form:input path="altitude" type="text" class="form-control"
	        placeholder="entrer un nombre entier" required="required"/>
	        <!-- span class="input-group-addon">mètres</span-->
	        <small id="aideUserName" class="form-text">(unités : en mètres)</small>
	       <form:errors path="altitude" cssClass="text-danger">
	       !!! SAISIE A CORRIGER : FORMAT SAISI INVALIDE !!!
	      </form:errors>
	        </fieldset>
      	
      		</fieldset>
	    
	    <br>
	    
	    <fieldset class="form-group p-2 flex-fill bd-highlight">
       <form:label path="hauteurMin" class="col-auto col-form-label">Hauteur Minimum</form:label>
	       <form:input path="hauteurMin" type="text" class="form-control"
	        placeholder="entrer un nombre entier" required="required"/>
	         <small id="aideUserName" class="form-text">(unités : en mètres)</small>
	       <form:errors path="hauteurMin" cssClass="text-warning" >
	       !!! SAISIE A CORRIGER : FORMAT SAISI INVALIDE !!!
	       </form:errors>
       </fieldset>
       
      <br></br>
      
        
       <fieldset class="form-group p-2 flex-fill bd-highlight">
	       <form:label path="hauteurMax" class="col-auto col-form-label">Hauteur Maximum</form:label>
	       <form:input path="hauteurMax" type="text" class="form-control"
	        placeholder="entrer un nombre entier" required="required" />
	         <small id="aideUserName" class="form-text">(unités : en mètres)</small>
       <form:errors path="hauteurMax" cssClass="text-warning" >
       !!! SAISIE A CORRIGER : FORMAT SAISI INVALIDE !!!
       </form:errors>
       </fieldset>
	    
      
      <br></br>
            
      <fieldset class="form-group">
	      <form:label path="nbVoies" class="col-auto col-form-label">Nombre de Voies</form:label>
	      <form:input path="nbVoies" type="text" class="form-control"
	       placeholder="entrer un nombre entier" required="required" />
	       <small id="aideUserName" class="form-text">(nombre de voies reconnues)</small>
	      <form:errors path="nbVoies" cssClass="text-warning">
	      !!! SAISIE A CORRIGER : FORMAT SAISI INVALIDE !!!
	      </form:errors>
	        </fieldset>
      
     <br></br>
           
      <fieldset class="form-group">
	      <form:label path="longueurTotaleVoies" class="col-auto col-form-label">Longueur Totale des Voies</form:label>
	      <form:input path="longueurTotaleVoies" type="text" class="form-control"
	      placeholder="entrer un nombre entier" required="required" />
	        <small id="aideUserName" class="form-text">(unités : en mètres)</small>
	      <form:errors path="longueurTotaleVoies" cssClass="text-warning" >
	      !!! SAISIE A CORRIGER : FORMAT SAISI INVALIDE !!!
	      </form:errors>
       </fieldset>
      
      
        <br></br>
     
   	   <button type="submit" class="btn btn-success">Valider</button>
   
     </form:form>
    </div>
   </div>
  </div>
 </div>
</div>

<div id="footer">
<%@ include file="/WEB-INF/jsp/common/footer1.jspf"%>
</div>
</div>


</body>

</html>