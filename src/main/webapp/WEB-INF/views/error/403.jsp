<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<body>
<h1><spring:message code="text.notallowed"/></h1>

<c:choose>
  <c:when test="${empty username}">
    <h2><spring:message code="text.notallowed"/></h2>
  </c:when>
  <c:otherwise>
    <h2><spring:message code="label.user"/> : ${username} <br/>
      <spring:message code="text.notallowed"/></h2>
  </c:otherwise>
</c:choose>

</body>
</html>
