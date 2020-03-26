<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>

<head>
<title>SITE ESCALADE</title>
 <meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css"
 href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />

</head>

<body>
<nav role="navigation" class="navbar navbar-default">
 <div class="navbar-collapse">
     <ul class="nav navbar-nav">
          <li class="active"><a href="/">Accueil</a></li>
          <li><a href="/SiteVue">Sites</a></li>
     </ul>
     <ul class="nav navbar-nav navbar-right">
         <li><a href="/logout">Logout</a></li>
     </ul>
 </div>
</nav>
<div class="container">

 <div class="panel panel-primary">
     <div class="panel-heading">MON ESPACE PERSONNEL</div>
        <div class="panel-body">
           Bienvenue ${name}!! <a href="/SiteVue">Cliquer ici</a> pour consulter 
           tous les sites d'escalade.
        </div>
     </div>
 </div>

</body>
</html>