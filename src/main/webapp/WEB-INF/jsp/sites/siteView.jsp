<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>


<head>

<title>Site Vue</title>

</head>

<body> 

<div id= "header1">
<%@ include file="/WEB-INF/jsp/common/header1.jspf"%>
<%@ include file="/WEB-INF/jsp/common/navigation.jspf"%>





<div class="container-fluid">


<div class="row d-flex justify-content-center">



  
  <div class="container col-md-4 col-md-offset-0">
 <div class="panel panel-primary ">
 
  <div class="panel-heading">
   <h5>Fiche d'information du site N° ${site.numSite}</h5>
  </div>
  
  <div class="panel-body">
   <table class="table table-striped table-condensed table-bordered">
    <thead>
        <tr>
            <th colspan="2"> Nom du site : ${site.nomSite}</th>
        </tr>
    </thead>
    <tbody>
         <tr>
            <td>Massif</td>
            <td>${site.siteMassif.getText()}</td>
        </tr>
        <tr>
            <td>Région</td>
            <td>${site.siteRegion.getText()}</td>
        </tr>
        <tr>
            <td>Cotation</td>
            <td>${site.siteCotation.getText()}</td>
        </tr>
          <tr>
            <td>Tag</td>
            <td>${site.siteTag.getText()}</td>
        </tr>
         <tr>
            <td>Niveau de Pratique</td>
            <td>${site.siteNiveauDePratique.getText()}</td>
        </tr>       
        <tr>
            <td>Type de Roche</td>
            <td>${site.siteTypeRoche.getText()}</td>
        </tr>
        <tr>
            <td>Orientation</td>
            <td>${site.siteOrientation.getText()}</td>
        </tr>
        <tr>
            <td>Altitude</td>
            <td>${site.altitude} mètres</td>
        </tr>
        <tr>
            <td>Hauteur Minimum</td>
            <td>${site.hauteurMin} mètres</td>
        </tr>
        <tr>
            <td>Hauteur Maximum :</td>
            <td>${site.hauteurMax} mètres</td>
        </tr>
        <tr>
            <td>Nombre de Voies</td>
            <td>${site.nbVoies}</td>
        </tr>
        <tr>
            <td>Longueur Totale des Voies</td>
            <td>${site.longueurTotaleVoies} mètres</td>
        </tr>
 		
    </tbody>
</table>
  
 </div>
  </div>
  </div>
   





 

  <div class="container col-md-5 col-md-offset-0" >
  
  
 <div class="panel panel-primary ">
 
  <div class="panel-heading">
   <h5>Commentaires sur le site</h5>
  </div>
  
  <div class="panel-body">
   <table class="table table-striped table-condensed table-bordered">
    <thead>		  	  	 
    			 <tr>
				      
				      <th>Titre</th>
				      <th>Contenu</th>
				      <th>Date</th>
			     </tr>
			     </thead>
			     <tbody>
   				 <c:forEach var="commentaire" items="${commentaires}">
   				 <tr>
			          
			          <td class="col-md-1">${commentaire.titreCommentaire}</td>
			          <td class="col-md-2">${commentaire.contenuCommentaire}</td>
			          <td class="col-md-1">${commentaire.dateCommentaire}</td>
			        
			          
		        	  <sec:authorize access="hasRole('ROLE_ADMIN')">
		        	  <td class="col-md-1">
		        	  	
			          	<a type="button"  class="btn btn-danger" 
			        	href="/user/sites/${site.numSite}/${commentaire.numCommentaire}">Suppression</a>
			        	
			         </td>
			          </sec:authorize>
		        	   
		        	  
    			 </tr>
   				</c:forEach>
				</tbody>
</table>
  

  
  
  
  
 </div>
 
  </div>
  
  
  <div class="panel panel-primary">
    <div class="panel-heading">Déposer un nouveau commentaire</div>
    
    
    <div class="panel-body">
    
    
    
     <form:form class="form-inline d-flex bd-highlight" method="POST" modelAttribute="commentaire">
      <form:hidden path="site"/>
      
      <fieldset class="form-row">
       <fieldset class="form-group">
	       <form:label path="titreCommentaire" class="col-auto col-form-label">Titre</form:label>
	       <form:input path="titreCommentaire" type="text" class="form-control"
	        placeholder="e.g Un site Whaouh !" required="required" maxlength="20"/>
	       <form:errors path="titreCommentaire" cssClass="text-warning" />
      	</fieldset>
        
        <br></br>
        
       <fieldset class="form-group">
	       <form:textarea path="contenuCommentaire" rows="2" cols="80"
	        placeholder="Merci de votre commentaire" required="required" maxlength="100"/>
	       <form:errors path="contenuCommentaire" cssClass="text-warning" />
      	</fieldset>
      	<br>
      	</fieldset>
      	
      	<button type="submit" class="btn-sm btn-success">Validation</button>
  </form:form>
  </div>
  </div>
  
  
  
  </div>
  
  
    <div class="container col-md-3 col-md-offset-0" >
  
  
 <div class="panel panel-primary ">
 
  <div class="panel-heading">
   <h5>Liste des Topos du site</h5>
  </div>
  
  <div class="panel-body">
   <table class="table table-striped table-condensed table-bordered">
    <thead>		  	  	 
    			 <tr>
				      
				      <th>Nom</th>
				      <th>Statut</th>
				      
			     </tr>
			     </thead>
			     <tbody>
   				 <c:forEach var="topo" items="${topos}">
   				 <tr>
			          
			          <td class="col-md-1">${topo.nomTopo}</td>
			          <td class="col-md-1">${topo.topoStatut.getText()}</td>
			          
			        
			          
		        	  
		        	  <td class="col-md-1">
		        	  	
			          	<a type="button"  class="btn btn-success" 
			        	href="/user/sites">? + d'infos</a>
			        	
			         </td>
			          
		        	   
		        	  
    			 </tr>
   				</c:forEach>
				</tbody>
</table>
  

  
  
  
  
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
