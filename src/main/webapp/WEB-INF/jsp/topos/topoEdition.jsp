<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>


<head>

<title>Topo Creation</title>
<%@ include file="/WEB-INF/jsp/common/header1.jspf"%>
</head>

<body> 

<div id= "header1">

<%@ include file="/WEB-INF/jsp/common/navigation.jspf"%>

<div class="container-fluid">
 <div class="row justify-content-center mb-3">
  <div class="col-md-8 col-md-offset-2 ">
  
   <div class="panel panel-primary">
    <div class="panel-heading">Fiche de création d'un Topo</div>
   
    <div class="panel-body">
    
     <form:form class="form-inline d-flex bd-highlight" method="POST" modelAttribute="topo">
      <form:hidden path="codeTopo"/>
      
       <fieldset class="form-group">
	       <form:label path="nomTopo" class="col-auto col-form-label">Nom du Topo</form:label>
	       <form:input path="nomTopo" type="text" class="form-control"
	        placeholder="e.g Topo du Mont Blanc" required="required" />
	       <form:errors path="nomTopo" cssClass="text-warning" />
      	</fieldset>   
      	
      	<fieldset class="form-group">
	       <form:label path="adresseMailUser" class="col-auto col-form-label">Votre adresse Mail</form:label>
	       <form:input path="adresseMailUser" type="text" class="form-control"
	        placeholder="OBLIGATOIRE pour échanger" required="required" />
	       <form:errors path="adresseMailUser" cssClass="text-warning" />
      	</fieldset>   
       
       <br></br>
      	
      	<fieldset class="form-group">
	       <form:textarea path="descriptionTopo" rows="5" cols="60"
	        placeholder="Thème de la publication" required="required" />
	       <form:errors path="descriptionTopo" cssClass="text-warning" />
      	</fieldset>
      	<br>
      	
      	 <fieldset class="form-group">
	       <form:label path="editeur" class="col-auto col-form-label">Editeur du Topo</form:label>
	       <form:input path="editeur" type="text" class="form-control"
	        placeholder="e.g Grimpeur Editions" required="required" />
	       <form:errors path="editeur" cssClass="text-warning" />
      	</fieldset>
      	
      	<fieldset class="form-group">
	       <form:label path="dateParution" class="col-auto col-form-label">Date d'édition du Topo</form:label>
	       <form:input path="dateParution" type="text" class="form-control"
	        placeholder="e.g Novembre 2010" required="required" />
	       <form:errors path="dateParution" cssClass="text-warning" />
      	</fieldset>
      	
      	 <fieldset class="form-group p-2 flex-fill bd-highlight">
       <form:label path="largeur" class="col-auto col-form-label">Largeur du document</form:label>
	       <form:input path="largeur" type="text" class="form-control"
	        placeholder="entrer un nombre entier" required="required"/>
	         <small id="aideUserName" class="form-text">(unités : en centimètres)</small>
	       <form:errors path="largeur" cssClass="text-warning" >
	       !!! SAISIE A CORRIGER : FORMAT SAISI INVALIDE !!!
	       </form:errors>
       </fieldset>
      	
      	<fieldset class="form-group p-2 flex-fill bd-highlight">
       <form:label path="longueur" class="col-auto col-form-label">Longeur du document</form:label>
	       <form:input path="longueur" type="text" class="form-control"
	        placeholder="entrer un nombre entier" required="required"/>
	         <small id="aideUserName" class="form-text">(unités : en centimètres)</small>
	       <form:errors path="longueur" cssClass="text-warning" >
	       !!! SAISIE A CORRIGER : FORMAT SAISI INVALIDE !!!
	       </form:errors>
       </fieldset>
       
       <fieldset class="form-group">
	       <form:label path="langue" class="col-auto col-form-label">Langue</form:label>
	       <form:input path="langue" type="text" class="form-control"
	        placeholder="e.g Ouvrage en français" required="required" />
	       <form:errors path="langue" cssClass="text-warning" />
      	</fieldset>
      	
      	<fieldset class="form-group p-2 flex-fill bd-highlight">
       <form:label path="nbPages" class="col-auto col-form-label">Nombre de pages</form:label>
	       <form:input path="nbPages" type="text" class="form-control"
	        placeholder="entrer un nombre entier" required="required"/>
	         <small id="aideUserName" class="form-text">(saisir le nombre total de pages)</small>
	       <form:errors path="nbPages" cssClass="text-warning" >
	       !!! SAISIE A CORRIGER : FORMAT SAISI INVALIDE !!!
	       </form:errors>
       </fieldset>
      	
      	<fieldset class="form-group">
      		<form:label path="topoStatut" class="col-auto col-form-label">Disponibilité actuelle</form:label>
	      	<form:select path="topoStatut" class="form-control">
		     	 <c:forEach var="topoStatut" items="${topoStatut}">
				    <option value="${topoStatut.getCode()}">${topoStatut.toString()}</option>
				 </c:forEach>
	        </form:select>
	        </fieldset>
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