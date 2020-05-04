<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>


<head>

<title>Topo View</title>
<%@ include file="/WEB-INF/jsp/common/header1.jspf"%>
</head>

<body> 

<div id= "header1">

<%@ include file="/WEB-INF/jsp/common/navigation.jspf"%>

<div class="container-fluid">

<div class="row d-flex justify-content-center">
  <div class="container col-md-6 col-md-offset-3">
	 <div class="panel panel-primary ">
	  <div class="panel-heading">
	   <h5>Fiche d'information du Topo ${topo.nomTopo}</h5>
	  </div>
		  <div class="panel-body">
		   <table class="table table-striped table-condensed table-bordered">
		    <thead>
		        <tr>
		            <th colspan="2"> Nom du topo : ${topo.nomTopo}</th>
		        </tr>
		    </thead>
		    <tbody>
		    	 <tr>
		            <td>Nom du Topo</td>
		            <td>${topo.nomTopo}</td>
		        </tr>
		         <tr>
		            <td>Description du Topo</td>
		            <td>${topo.descriptionTopo}</td>
		        </tr>
		        <tr>
		            <td>Editeur</td>
		            <td>${topo.editeur}</td>
		        </tr>
		        <tr>
		            <td>Date de Parution</td>
		            <td>${topo.dateParution}</td>
		        </tr>
		          <tr>
		            <td>Largeur du document</td>
		            <td>${topo.largeur} centimètres</td>
		        </tr>
		         <tr>
		            <td>Longueur du document</td>
		            <td>${topo.longueur} centimètres</td>
		        </tr>       
		        <tr>
		            <td>Langue</td>
		            <td>${topo.langue}</td>
		        </tr>
		        <tr>
		            <td>Nombre de Pages</td>
		            <td>${topo.nbPages} pages</td>
		        </tr>
		        <tr>
		            <td>Disponibilité</td>
		            <td>${topo.topoStatut.getText()} </td>
		        </tr>
		        <tr>
		            <td>Propiétaire</td>
		            <td>${topo.user.getUsername()}</td>
		        </tr>
		        <tr>
		            <td>Site</td>
		            <td>${topo.site.getNomSite()}</td>
		        </tr>
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
