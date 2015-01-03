<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<body>
<h1><spring:message code="label.title"/> : ${title}</h1>
<h1><spring:message code="label.message"/> : ${message}</h1>

<sec:authorize access="isAnonymous()">
  <a href="<spring:url value="/login"/>">Login</a>
</sec:authorize>

<sec:authorize access="isAuthenticated()">
  <!-- For login user -->
  <spring:url value="/login?logout" var="logoutUrl" />
  <form action="${logoutUrl}" method="post" id="logoutForm">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
  </form>

  <a href="<spring:url value='/game/depot/0'/>">
    <spring:message code="depot.title" arguments="0"/>
  </a>

  <script>    function formSubmit() {      document.getElementById("logoutForm").submit();    }  </script>

  <c:if test="${pageContext.request.userPrincipal.name != null}">
    <h2>
      <spring:message code="label.user"/> : ${pageContext.request.userPrincipal.name} |
      <a href="javascript:formSubmit()"> <spring:message code="label.logout"/></a>
    </h2>
  </c:if>
</sec:authorize>
</body>
</html>
