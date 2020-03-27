<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@include file="common/header.jspf"%>
<%@include file="common/navigation.jspf"%>
<div class="container">
 <div class="row">
  <div class="col-md-6 col-md-offset-3 ">
   <div class="panel panel-primary">
    <div class="panel-heading">Nouveau Site</div>
    <div class="panel-body">
     <form:form method="post" modelAttribute="site">
      <form:hidden path="numSite" />
      
      <fieldset class="form-group">
       <form:label path="nomSite">Nom du Site</form:label>
       <form:input path="nomSite" type="text" class="form-control"
        required="required" />
       <form:errors path="nomSite" cssClass="text-warning" />
      </fieldset>

      <fieldset class="form-group">
       <form:label path="altitude">Altitude</form:label>
       <form:input path="altitude" type="text" class="form-control"
        required="required" />
       <form:errors path="altitude" cssClass="text-warning" />
      </fieldset>

      <button type="submit" class="btn btn-success">Valider</button>
     </form:form>
    </div>
   </div>
  </div>
 </div>
</div>
<%@ include file="common/footer.jspf"%>