<%@page contentType="text/html;charset=UTF-8" language="java"  session="true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<body>
<h1><spring:message code="label.title"/> : ${title}</h1>
<h1><spring:message code="label.message"/> : ${message}</h1>

<spring:url value="/login?logout" var="logoutUrl" />
<form action="${logoutUrl}" method="post" id="logoutForm">
  <input type="hidden" name="${_csrf.parameterName}"   value="${_csrf.token}" />
</form>

<c:if test="${pageContext.request.userPrincipal.name != null}">
  <h2>
    <spring:message code="label.welcome"/> : ${pageContext.request.userPrincipal.name} |
      <a href="javascript:formSubmit()"> <spring:message code="label.logout"/></a>
  </h2>
</c:if>

<script>function formSubmit() {     document.getElementById("logoutForm").submit();}</script>
</body>
</html>
