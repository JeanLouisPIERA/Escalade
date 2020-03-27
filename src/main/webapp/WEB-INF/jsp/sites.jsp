<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
 <div class="container">
  <header>
   <h1>Informations sur les Sites</h1>
  </header>
  <div class="starter-template">
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
        <td>
        <a type="button" class="btn btn-warning"
        href="/SiteVue/${site.numSite}">Delete</a></td>
     </tr>
    </c:forEach>
   </table>
  </div>

 </div>

 <script type="text/javascript"
  src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<%@ include file="common/footer.jspf"%>

