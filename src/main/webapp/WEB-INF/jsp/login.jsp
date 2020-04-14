<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>


<head>

<title>Login Page</title>

</head>

<body> 

<div id= "header1">
<%@ include file="common/header1.jspf"%>



<div class="container">

    <div class="container-fluid d-flex center-block">
    <div class="row d-flex justify-content-center">


<div class="col-md-3 col-md-offset-4 spacer40">
<div class="panel panel-primary">
<div class="panel-heading">Authentification</div>
<div class="panel-body">
<form action="/login" method="post">  

  <div>

   <input type="text" name="username"

    placeholder="User Name" />

  </div>

  <div>

   <input type="password" name="password"

    placeholder="Password" />

  </div>

  <div>

   <input type="submit" value="Sign In" class="button red small" />

  </div>

  <c:if test="${param.error ne null}">

   <div class="alert-danger">Invalid username and password.</div>

  </c:if>

  <c:if test="${param.logout ne null}">

   <div class="alert-normal">You have been logged out.</div>

  </c:if>  

  <input type="hidden" name="${_csrf.parameterName}"

   value="${_csrf.token}" />

 </form>

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

</body>

</html>