<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>


<head>

<title>Topo Liste Page</title>

</head>

<body> 

<div id= "header1">
<%@ include file="/WEB-INF/jsp/common/header1.jspf"%>
<%@ include file="/WEB-INF/jsp/common/navigation.jspf"%>


<div class="container-fluid">
<div class="row d-flex justify-content-center">

<div class="container col-md-12 col-md-offset-1">

<div class="wrapper">

 <div>
 <a type="button" class="btn btn-primary btn-md" href="/user/topos/newTopo">Ajouter un nouveau Topo</a>
 </div>
 </div>
 </div>
</div>
</div>

<br></br>


<div class="container-fluid">
<div class="row d-flex justify-content-center">

<div class="container col-md-8 col-md-offset-1">

<div class="wrapper">

 

 
 <div class="panel panel-primary">
 
  <div class="panel-heading">
   <h3>Tous les topos des Amis de l'Escalade</h3>
  </div>
  
  <div class="panel-body">
   <table class="table table-striped table-condensed table-bordered">
    <thead>		  	  	 
    			 <tr>
				      <th>Nom</th>
				      <th>Site</th>
				      <th>Membre</th>
				      <th>Editeur</th>
				      <th>Statut</th>
			     </tr>
			     </thead>
			     <tbody>
   				 <c:forEach var="topo" items="${topos}">
   				 <tr>
			          <td>${topo.nomTopo}</td>
			          <td>${topo.site.getNomSite()}</td>
			          <td>${topo.utilisateur.getNomUtilisateur()}</td>
			          <td>${topo.editeur}</td>
			          <td>${topo.topoStatut.getText()}</td>
			          <td>
			          	<a  type="button" class="btn btn-success" 
				        href="#"> + d'infos ? </a>
		        	  </td>
		        	   <td>
				        <a  type="button" class="btn btn-warning" 
				        href="#">Mise à jour</a></td>
			          <sec:authorize access="hasRole('ROLE_ADMIN')">
			          <td>
			          	<a type="button"  class="btn btn-danger" 
			        	href="#">Suppression</a>
			          </td>
			          </sec:authorize>
		        	  
		        	  
    			 </tr>
   				</c:forEach>
				</tbody>
				</table>
				
   		
   	
  
   	
   	
   	
   	
   			
   		
   			
   			
   			<div class="container">
    		<!-- div class="row-lg-2" -->
    			<c:if test="${topos.size() > 0 }">
		            <!-- ul class="pagination-sm"-->
		            <ul class="nav nav-pills">
		                <c:forEach begin="0" end="${totalPages-1}" var="page">
		                    <li class="page-item">
		                        <a class="btn btn-info" href="topos?page=${page}&size=${size}" class="page-target">${page+1}</a>
		                    </li>
		                </c:forEach>
		            </ul>
		 	   </c:if>
		   </div>
		   
		    </div>
		    </div>
   		
 </div>
</div>


	
	<div class="container-fluid">
	
	<div class="container col-md-2 col-md-offset-0">



<div class="wrapper">


<div class="panel panel-primary">
	<div class="panel-heading">
    <h3>Sélection </h3>
    </div>
    
    <br>
    
    <div class="panel-body">
    
     <table class="table table-striped table-condensed table-bordered">
    <thead>		  	  	 
    			
			     </thead>
			     
			     <tbody>
   				 
   				 <tr>
   				 	 
			          <td>
			          	<a  type="button" class="btn btn-info" 
				        href="#"> par Site </a>
		        	  </td>
       	  		</tr>
       	  		
       	  		 <tr>
   				 	  
			          <td>
			          	<a  type="button" class="btn btn-info" 
				        href="#"> par Utilisateur </a>
		        	  </td>
       	  		</tr>
       	  		
       	  		 <tr>
   				 	  
			          <td>
			          	<a  type="button" class="btn btn-info" 
				        href="#"> par Disponibilité </a>
		        	  </td>
       	  		</tr>
       	  		
       	  		 
		        	  
		        	  
				</tbody>
				</table>
     
     
     
    </div>
   </div>


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





