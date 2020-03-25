<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>

<head>
<title>SITE ESCALADE</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
 rel="stylesheet">

</head>

<body>

<div class="container">

 <div class="panel panel-primary">
     <div class="panel-heading">SITE DES AMIS DE L'ESCALADE</div>
        <div class="panel-body">
           Bienvenue ${name}!! <a href="/SiteVue">Cliquer ici</a> pour consulter 
           tous les sites d'escalade.
        </div>
     </div>
 </div>

</body>
</html>