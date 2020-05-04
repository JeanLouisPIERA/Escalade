<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>


<head>

<title>Confirmation de la disponibilité de votre Topo</title>
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
	  	 <h5>Votre Topo ${topo.getNomTopo()} est à nouveau disponible</h5>
	  	</div>
		  <div class="panel-body">
	    	<br></br> <a href="/user/topos/mesTopos">Cliquer ici</a> pour retourner vers la liste de vos topos mis à jour. 
	  	  </div>
	  </div>
	 </div>
	</div>
</div>

<div id="footer">
	<%@ include file="/WEB-INF/jsp/common/footer1.jspf"%>
</div>

</div>
