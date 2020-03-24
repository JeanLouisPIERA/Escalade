<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css"
 href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />

</head>
<body>
 <div class="container">
  <header>
   <h1>Affichage des Sites</h1>
  </header>
  <div class="starter-template">
   <h1>Liste des sites</h1>
   <table
    class="table table-striped table-hover table-condensed table-bordered">
    <tr>
   	<th>Numéro</th>
      <th>Nom</th>
      <th>Altitude</th>
      <th>NbVoies</th>
      <th>HauteurMin</th>
      <th>HauteurMax</th>
      <th>LongueurVoies</th>
      <th>NiveauDePratique</th>
      <th>Cotation</th>
      <th>Orientation</th>
      <th>Région</th>
      <th>Roche</th>
      <th>Tag</th>
    </tr>
    <c:forEach var="site" items="${sites}">
     <tr>
     <td>${site.numSite}</td>
          <td>${site.nomSite}</td>
          <td>${site.altitude}</td>
          <td>${site.nbVoies}</td>
          <td>${site.hauteurMin}</td>
          <td>${site.hauteurMax}</td>
          <td>${site.longueurTotaleVoies}</td>
          <td>${site.siteNiveauDePratique}</td>
          <td>${site.siteCotation}</td>
          <td>${site.siteOrientation}</td>
           <td>${site.siteRegion}</td>
          <td>${site.siteTypeRoche}</td>
          <td>${site.siteTag}</td>
     </tr>
    </c:forEach>
   </table>
  </div>

 </div>

 <script type="text/javascript"
  src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>

</html>