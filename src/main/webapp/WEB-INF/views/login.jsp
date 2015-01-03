<%@page contentType="text/html;charset=UTF-8" language="java" session="true" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
  <title>Login Page</title>
  <link rel="stylesheet" type="text/css" href="<spring:url value='/resources/css/nlp2.css'/>"/>
</head>
<body onload='document.loginForm.username.focus();'>

<h1><spring:message code="label.loginpage"/></h1>

<div id="login-box">

  <h3><spring:message code="label.login"/></h3>

  <c:if test="${not empty error}">
    <div class="error">${error}</div>
  </c:if>
  <c:if test="${not empty msg}">
    <div class="msg">${msg}</div>
  </c:if>
  <spring:url value='/login' var="loginUrl"/>
  <form:form name='loginForm'  action="${loginUrl}" method='post'>
    <table>
      <tr>
        <td><spring:message code="label.user"/></td>
        <td><input type='text' name='username'></td>
      </tr>
      <tr>
        <td><spring:message code="label.password"/></td>
        <td><input type='password' name='password' /></td>
      </tr>
      <tr>
        <spring:message code="label.submit" var="labelSubmit"/>
        <td colspan='2'><input name="submit" type="submit" value="${labelSubmit}" /></td>
      </tr>
    </table>
    <input type="hidden" name="${_csrf.parameterName}"   value="${_csrf.token}" />
  </form:form>
</div>

</body>
</html>