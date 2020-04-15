<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>


<head>

<title>Site Liste Page</title>

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
 <a type="button" class="btn btn-primary btn-md" href="/user/sites/newSite">Ajouter un nouveau Site</a>
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
   <h3>Informations sur les sites</h3>
  </div>
  
  <div class="panel-body">
   <table class="table table-striped table-condensed table-bordered">
    <thead>		  	  	 
    			 <tr>
				      <th>Nom</th>
				      <th>Massif</th>
				      <th>Cotation</th>
				      <th>Niveau</th>
				      <th>Tag</th>
			     </tr>
			     </thead>
			     <tbody>
   				 <c:forEach var="site" items="${sites}">
   				 <tr>
			          <td>${site.nomSite}</td>
			          <td>${site.siteMassif.getText()}</td>
			          <td>${site.siteCotation.getText()}</td>
			          <td>${site.siteNiveauDePratique.getText()}</td>
			          <td>${site.siteTag.getText()}</td>
			          <td>
			          	<a  type="button" class="btn btn-success" 
				        href="/user/sites/${site.numSite}"> + d'infos ? </a>
		        	  </td>
		        	   <td>
				        <a  type="button" class="btn btn-warning" 
				        href="/user/sites/updateSite/${site.numSite}">Mise à jour</a></td>
			          <sec:authorize access="hasRole('ROLE_ADMIN')">
			          <td>
			          	<a type="button"  class="btn btn-danger" 
			        	href="/admin/sites/deleteSite/${site.numSite}">Suppression</a>
			          </td>
			          </sec:authorize>
		        	  
		        	  
    			 </tr>
   				</c:forEach>
				</tbody>
				</table>
				
   		
   	
  
   	
   	
   	
   	
   			
   		
   			
   			
   			<div class="container">
    		<!-- div class="row-lg-2" -->
    			<c:if test="${sites.size() > 0 }">
		            <!-- ul class="pagination-sm"-->
		            <ul class="nav nav-pills">
		                <c:forEach begin="0" end="${totalPages-1}" var="page">
		                    <li class="page-item">
		                        <a class="btn btn-info" href="sitesByNiveau?page=${page}&size=${size}" class="page-target">${page+1}</a>
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
    <h3> A trier</h3>
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
				        href="/user/sitesByNom"> par Nom </a>
		        	  </td>
       	  		</tr>
   				 
   				 <tr>
   				 	 
			          <td>
			          	<a  type="button" class="btn btn-info" 
				        href="/user/sitesByMassif"> par Massif </a>
		        	  </td>
       	  		</tr>
       	  		
       	  		 <tr>
   				 	  
			          <td>
			          	<a  type="button" class="btn btn-info" 
				        href="/user/sitesByCotation"> par Cotation </a>
		        	  </td>
       	  		</tr>
       	  		
       	  		 <tr>
   				 	  
			          <td>
			          	<a  type="button" class="btn btn-info" 
				        href="/user/sitesByNiveau"> par Niveau </a>
		        	  </td>
       	  		</tr>
       	  		
       	  		 <tr>
   				 	 
			          <td>
			          	<a  type="button" class="btn btn-info" 
				        href="/user/sitesByTag"> par Tag </a>
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





