<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html lang="en">
  <head>
      <meta charset="utf-8">
      <title>Creation Utilisateur</title>

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
        <form:form method="POST" modelAttribute="userForm" class="form-signin">
            <h2 class="form-signin-heading">Créez votre espace personnel</h2>
            <spring:bind path="username">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="username" class="form-control" placeholder="votre nom d'utilisateur"
                                autofocus="true"></form:input>
                    <form:errors path="username"></form:errors>
                </div>
            </spring:bind>

            <spring:bind path="password">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="password" path="password" class="form-control" placeholder="votre mot de passe"></form:input>
                    <form:errors path="password"></form:errors>
                </div>
            </spring:bind>

            <spring:bind path="passwordConfirm">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="password" path="passwordConfirm" class="form-control"
                                placeholder="confirmation"></form:input>
                    <form:errors path="passwordConfirm"></form:errors>
                </div>
            </spring:bind>

            <button class="btn btn-sm btn-primary btn-block" type="submit">Valider</button>
        </form:form>

    </div>
   
	</div>
	</div>
	<div id="footer">
	<%@ include file="common/footer1.jspf"%>
	</div>
	</div>
	
	</div>

    <script src="webjars/jquery/3.2.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
  </div>
  </body>
</html>