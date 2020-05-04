<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html lang="en">
  <head>
      <meta charset="utf-8">
      <title>Login Page</title>
		
		<link href="webjars/bootstrap/3.3.7/css/bootstrap.min.css"
        rel="stylesheet">
		
  </head>

  <body>
  
  	<div id= "header">
	<%@ include file="common/header.jspf"%>
      
    <div class="container">

    <div class="container-fluid d-flex center-block">
    <div class="row d-flex justify-content-center">
  	<div class="col-md-6 col-md-offset-3">
  	<div class="wrapper">
    
      <form method="POST" action="${contextPath}/login" class="form-signin">
        <h2 class="form-heading">Identifiez-vous</h2>

        <div class="form-group ${error != null ? 'has-error' : ''}">
            <span>${message}</span>
            <input name="username" type="text" class="form-control" placeholder="Votre nom d'utilisateur"
                   autofocus="true"/>
                   <br>
            <input name="password" type="password" class="form-control" placeholder="Votre mot de passe"/>
            <span>${error}</span>
            <br>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			
            <button class="btn btn-sm btn-primary btn-block" type="submit">Valider</button>
            <h6 class="text-center"><a href="${contextPath}/registration">Pas encore inscrit ? Cliquez ici pour cr�er votre compte !</a></h6>
        </div>
      </form>
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