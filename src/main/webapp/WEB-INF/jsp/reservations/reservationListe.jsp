<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!DOCTYPE html>
<html>

<head>
	<title>Gestion Reservations Page</title>
	<%@ include file="/WEB-INF/jsp/common/header1.jspf"%>
</head>

<body> 
	<div id= "header1">
	<%@ include file="/WEB-INF/jsp/common/navigation.jspf"%>

<div class="container-fluid">
<div class="row d-flex justify-content-center">

<div class="container col-md-6 col-md-offset-0">

<div class="wrapper">

 <div class="panel panel-primary">
 
  <div class="panel-heading">
   <h3>Réponse à mes demandes de réservation</h3>
  </div>
  
  <div class="panel-body">
   <table class="table table-striped table-condensed table-bordered">
    <thead>		  	  	 
    			 <tr>
				      <th>Annuler</th>
				      <th>Date</th>
				      <th>Topo</th>
				      <th>Disponibilité</th>
				      <th>Réponse</th>
				      <th>Mail du Propriétaire</th>
			     </tr>
			     </thead>
			     <tbody>
   				 <c:forEach var="reservation" items="${reservations}">
   				 <tr>
			          <td>
			          	<a type="button"  class="btn btn-danger" 
			        	href="/user/reservations/deleteReservation/${reservation.numReservation}">Suppression</a>
			          </td>
			          <td>${reservation.dateDemande}</td>
			          <td>${reservation.topo.getNomTopo()}</td>
			          <td>${reservation.topo.topoStatut.getText()}</td>
			          <td>${reservation.reservationReponse}</td>
			          <c:if test="${reservation.reservationReponse.getCode() == 'ACCORD'}">
			          <td>${reservation.topo.getAdresseMailUser()}</td>
			          </c:if>
			          
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
		                        <a class="btn btn-info" href="sites?page=${page}&size=${size}" class="page-target">${page+1}</a>
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
		<div class="container col-md-6 col-md-offset-0">
			<div class="wrapper">
				<div class="panel panel-primary">
					<div class="panel-heading">
					    <h3>Répondre aux demandes de réservation </h3>
					    </div>
   							 <div class="panel-body">
							   <table class="table table-striped table-condensed table-bordered">
							    <thead>		  	  	 
					    			 <tr>
									      <th>Date</th>
									      <th>Topo</th>
									      <th>Emprunteur</th>
									      <th>Disponibilité</th>
									      <th>Décision</th>
								     </tr>
							     </thead>
							     <tbody>
				   				 <c:forEach var="demandeReservation" items="${demandeReservations}">
				   				 <tr>
							          <td>${demandeReservation.dateDemande}</td>
							          <td>${demandeReservation.topo.getNomTopo()}</td>
							          <td>${demandeReservation.user.getUsername()}</td>
							          <td>${demandeReservation.topo.topoStatut.getText()}</td>
							          <td>${demandeReservation.reservationReponse.getText()}</td>
							          <td>
								        <a  type="button" class="btn btn-success" 
								        href="/user/reservations/${demandeReservation.numReservation}">Accord</a></td>
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
				                        <a class="btn btn-info" href="sites?page=${page}&size=${size}" class="page-target">${page+1}</a>
				                    </li>
				                </c:forEach>
				            </ul>
				 	   </c:if>
				   </div>
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





