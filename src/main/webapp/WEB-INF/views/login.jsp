<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
  <title>Login Page</title>
  <link rel="stylesheet" type="text/css" href="../css/nlp2.css'/>"/>
</head>
<body onload='document.loginForm.username.focus();'>

<h1>Spring Security Login Form (Database Authentication)</h1>

<div id="login-box">

  <h3>Login with Username and Password</h3>

  <c:if test="${not empty error}">
    <div class="error">${error}</div>
  </c:if>
  <c:if test="${not empty msg}">
    <div class="msg">${msg}</div>
  </c:if>

  <form name='loginForm'  action="<c:url value='/j_spring_security_check' />" method='POST'>
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
  </form>
</div>

</body>
</html>