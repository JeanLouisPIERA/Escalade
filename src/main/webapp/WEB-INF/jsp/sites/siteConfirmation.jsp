<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>


<head>

<title>Site Confirmation</title>
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
   <h5>Confirmation de la création de la fiche du site N° ${site.numSite}</h5>
  </div>
  
  <div class="panel-body">
   <table class="table table-striped table-condensed table-bordered">
    <thead>
        <tr>
            <th colspan="2"> Nom du site : ${site.nomSite}</th>
        </tr>
    </thead>
    <tbody>
         <tr>
            <td>Massif</td>
            <td>${site.siteMassif.getText()}</td>
        </tr>
        <tr>
            <td>Région</td>
            <td>${site.siteRegion.getText()}</td>
        </tr>
        <tr>
            <td>Cotation</td>
            <td>${site.siteCotation.getText()}</td>
        </tr>
          <tr>
            <td>Tag</td>
            <td>${site.siteTag.getText()}</td>
        </tr>
         <tr>
            <td>Niveau de Pratique</td>
            <td>${site.siteNiveauDePratique.getText()}</td>
        </tr>       
        <tr>
            <td>Type de Roche</td>
            <td>${site.siteTypeRoche.getText()}</td>
        </tr>
        <tr>
            <td>Orientation</td>
            <td>${site.siteOrientation.getText()}</td>
        </tr>
        <tr>
            <td>Altitude</td>
            <td>${site.altitude} mètres</td>
        </tr>
        <tr>
            <td>Hauteur Minimum</td>
            <td>${site.hauteurMin} mètres</td>
        </tr>
        <tr>
            <td>Hauteur Maximum :</td>
            <td>${site.hauteurMax} mètres</td>
        </tr>
        <tr>
            <td>Nombre de Voies</td>
            <td>${site.nbVoies}</td>
        </tr>
        <tr>
            <td>Longueur Totale des Voies</td>
            <td>${site.longueurTotaleVoies} mètres</td>
        </tr>
 		
    </tbody>
</table>
  
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
