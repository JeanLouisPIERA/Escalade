<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>


	<head>
	
		<title>Accord � une demande de Reservation</title>
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
		   				<h5>Confirmation de mon accord � une demande de r�servation du Topo ${demandeReservation.topo.getNomTopo()}</h5>
		   				<h5>faite le ${demandeReservation.dateDemande}</h5>
		  				</div>
		  
				  <div class="panel-body">
		   				<table class="table table-striped table-condensed table-bordered">
		    				<thead>
						        <tr>
						            <th colspan="2"> Nom de l'emprunteur: ${demandeReservation.user.getUsername()}</th>
						        </tr>
						    </thead>
						    <tbody>
						        <tr>
						            <td>Ma d�cision :</td>
						            <td>${demandeReservation.reservationReponse.getText()}</td>
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
