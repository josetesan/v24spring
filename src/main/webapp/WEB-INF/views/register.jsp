<%@page contentType="text/html;charset=UTF-8" language="java" session="true" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
  <title>Registration Page</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
</head>
<html>
<body>
<div class="container">
  <spring:url value="/register" var="regUrl"/>
  <form:form class="form-signin" commandName="user" action="${regUrl}" method="post">
    <form:errors path="*" cssClass="alert alert-warning" element="div" />
    <h2 class="form-signin-heading">Please register</h2>
    <form:label path="username" for="username" class="sr-only">Username</form:label>
    <form:input path="username"  class="form-control" placeholder="User name" />
    <form:errors cssClass="alert  alert-warning" path="username"/>
    <form:label path="password" for="password" class="sr-only">Password</form:label>
    <form:password path="password"  class="form-control" placeholder="Password" />
    <form:errors cssClass="alert  alert-warning" path="password"/>
    <form:button class="btn btn-lg btn-primary btn-block" type="submit">Register</form:button>
  </form:form>

</div> <!-- /container -->


</body>
</html>
