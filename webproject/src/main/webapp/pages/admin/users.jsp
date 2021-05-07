<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="ftm" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<ftm:setLocale value="${currentLocale}"/>
<ftm:setBundle basename="l10n.front-text"/>
<html>
<head>
    <title>Profile</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css">

    <!-- Custom styles for this template -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/project.css">
</head>
<body>
<jsp:include page="../modules/header.jsp"/>
<div class="container" style="width: 980px; margin-left: auto; margin-right: auto">
    <div class="row">
        <div class="col">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th scope="col" style="border-top: none;" ><ftm:message key="adminUsers.email"/></th>
                    <th scope="col" style="border-top: none;"><ftm:message key="adminUsers.login"/></th>
                    <th scope="col" style="border-top: none;"><ftm:message key="adminUsers.amountOfBets"/></th>
                    <th scope="col" style="border-top: none;"><ftm:message key="adminUsers.balance"/></th>
                    <th scope="col" style="border-top: none;"><ftm:message key="adminUsers.role"/></th>
                    <th scope="col" style="border-top: none;"><ftm:message key="adminUsers.isApproved"/></th>
                </tr>
                </thead>
                <tbody>
                <label style="color: red">${errorEmptyBetInfoList}</label>
                <c:forEach var="user" items="${usersList}" varStatus="status">
                    <tr>
                        <td><C:out value="${user.email}"/></td>
                        <td><c:out value="${user.login}"/></td>
                        <td><c:out value="${user.amountOfBets}"/></td>
                        <td><c:out value="${user.wallet.balance}"/></td>
                        <td><c:out value="${user.role.roleName}"/></td>
                        <td><c:out value="${user.isApproved}"/></td>
                        <td><form><button><ftm:message key="adminUsers.changeRole"/></button></form></td><!--Использую get запрос-->
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<jsp:include page="../modules/footer.jsp"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/project.js"></script>
</body>
</html>
