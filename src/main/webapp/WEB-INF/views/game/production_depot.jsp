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
            <td>Product_id</td>
            <td>Product_type_id</td>
            <td>Payment_State_id</td>
            <td>first_draw_id</td>
            <td>last_draw_id</td>
            <td>external_id</td>
            <td>amount</td>
            <td>duration</td>
        </tr>
        <c:forEach items="${depots}" var="depot">
        <tr>
            <td>${depot.productId}</td>
            <td>${depot.productTypeId}</td>
            <td>${depot.paymentStateId}</td>
            <td>${depot.firstDrawId}</td>
            <td>${depot.lastDrawId}</td>
            <td>${depot.external}</td>
            <td>${depot.amount}</td>
            <td>${depot.duration}</td>
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
