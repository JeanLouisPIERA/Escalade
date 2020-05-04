<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %><c:set var="contextPath" value="${pageContext.request.contextPath}"/>


<!DOCTYPE html>
<html lang="en">
  <head>
      <meta charset="utf-8">
      <title>Enregistrement OK</title>

      <link href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
  </head>
  
  <body>
  
  <div id= "header">
	<%@ include file="common/header.jspf"%>
      
    <div class="container">

    <div class="container-fluid d-flex center-block">
    <div class="row d-flex justify-content-center">
  	<div class="col-md-6 col-md-offset-3">
  	<div class="wrapper">
  
	  <h2 class="panel-heading">Votre enregistrement a été validé</h2>
	  <div class="panel panel-primary">
     
        <div class="panel-body">
   
           <a href="/login"> <button class="btn btn-sm btn-primary btn-block" type="submit">Pour vous connecter, cliquer ici</button></a>
            
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
    	<script src="webjars/jquery/3.2.1/jquery.min.js"></script>
        <script src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </div>
  </body>
</html>