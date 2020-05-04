<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>

<head>

<title>Accueil</title>
<%@ include file="common/header1.jspf"%>
</head>

<body> 

<div id= "header1">

<%@ include file="common/navigation.jspf"%>


<div class="container">

    <div class="container-fluid d-flex center-block">
    <div class="row d-flex justify-content-center">
  	<div class="col-md-6 col-md-offset-3">
  	<div class="wrapper">

 <div class="panel panel-primary">
     <div class="panel-heading">Bienvenue dans votre Espace Personnel</div>
        <div class="panel-body">
           Bonjour ${name}!!<br></br> <a href="/user/sites/trisites">Cliquer ici</a> pour accéder aux sites d'escalade. 
           <br></br> <a href="/user/topos">Cliquer ici</a> pour consulter tous les topos. 
           <br></br> <a href="/user/reservations">Cliquer ici</a> pour gérer toutes vos réservations de topos. 
                      
        </div>
     </div>
 </div>
 </div>
 </div>
 </div>
 </div>
 
<div id="footer">
<%@ include file="common/footer1.jspf"%>
</div>
</div>

</body>

</html>