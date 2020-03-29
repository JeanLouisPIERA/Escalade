<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
 <!--<div class="container">-->
 <div class="wrapper">
    <div class="container-fluid d-flex center-block">
    <div class="row d-flex justify-content-center">
  	<div class="col-md-6 col-md-offset-3">
		  <div>
			  <a type="button" class="btn btn-primary btn-md" href="/NewSite">Ajouter un nouveau Site</a>
		  </div>
 		  <br>
		  <div class="panel panel-primary center-block d-flex">
			  <div class="panel-heading center-block">
			   <h3>Informations sur les sites</h3>
			  </div>
		  	  <div class="panel-body" style="text-align:center">
  
			 <table
			 class="table table-striped table-hover table-condensed table-bordered center-block" style="text-align:center" >
    			 <tr>
				      <th>Nom</th>
				      <th>Massif</th>
				      <th>Région</th>
				      <th>Altitude</th>
			     </tr>
   				 <c:forEach var="site" items="${sites}">
   				 <tr>
			          <td>${site.nomSite}</td>
			          <td>${site.siteMassif.getText()}</td>
			          <td>${site.siteRegion.getText()}</td>
			          <td>${site.altitude}</td>
			          <td>
			          	<a type="button" class="btn btn-success"
				        href="/SiteVue/${site.numSite}"> + d'infos ? </a>
		        	  </td>
			          <td>
				        <a type="button" class="btn btn-warning"
				        href="/SiteVue/${site.numSite}">Mise à jour</a></td>
			          <td>
			          	<a type="button" class="btn btn-danger"
			        	href="/SiteVue/${site.numSite}">Suppression</a>
			          </td>
    			 </tr>
   				 </c:forEach>
   			</table>
  </div>
  </div>
 </div>
 </div>
 </div>
 </div>
 <script type="text/javascript"
  src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<%@ include file="common/footer.jspf"%>

