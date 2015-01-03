<%@page contentType="text/html;charset=UTF-8" language="java" session="true" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
    <title>${title}</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
</head>
<body>
<sec:authorize access="isAuthenticated()">
<div class="table-responsive">
    <table class="table table-hover">
        <tr>
            <td>Date</td>
            <td>Producto</td>
            <td>Amount</td>
            <td>Status</td>
        </tr>
        <c:forEach items="${depots}" var="depot">
        <tr>
            <td>${depot.drawDate}</td>
            <td>${depot.product}</td>
            <td>${depot.amount}</td>
            <td>${depot.status}</td>
        </tr>
        </c:forEach>
    </table>
    </div>

</sec:authorize>
<sec:authorize access="isAnonymous()">
    <a href="<spring:url value="/login"/>">Login</a>
</sec:authorize>
</body>
</html>
