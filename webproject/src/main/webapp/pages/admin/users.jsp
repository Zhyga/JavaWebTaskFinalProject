<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="${currentLocale}" scope="session"/>
<fmt:setBundle basename="l10n.front-text"/>
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
                    <th scope="col" style="border-top: none;"><fmt:message key="adminUsers.email"/></th>
                    <th scope="col" style="border-top: none;"><fmt:message key="adminUsers.login"/></th>
                    <th scope="col" style="border-top: none;"><fmt:message key="adminUsers.amountOfBets"/></th>
                    <th scope="col" style="border-top: none;"><fmt:message key="adminUsers.balance"/></th>
                    <th scope="col" style="border-top: none;"><fmt:message key="adminUsers.role"/></th>
                    <th scope="col" style="border-top: none;"><fmt:message key="adminUsers.isApproved"/></th>
                </tr>
                </thead>
                <tbody>
                <label style="color: red">${errorAdminUser}</label>
                <c:forEach var="user" items="${usersList}" varStatus="status">
                    <tr>
                        <td><C:out value="${user.email}"/></td>
                        <td><c:out value="${user.login}"/></td>
                        <td><c:out value="${user.amountOfBets}"/></td>
                        <td><input type="text" value="<c:out value="${user.wallet.balance}"/>" name="userBalance" form="user_${user.userId}_form">
                        </td>
                        <td>
                            <select class="form-select" name="role" aria-label="Default select example" form="user_${user.userId}_form">
                                <c:choose>
                                    <c:when test="${user.role.roleName.equals('admin')}">
                                        <option selected  value="admin">Admin</option>
                                        <option  value="user">User</option>
                                        <option  value="bookmaker">Bookmaker</option>
                                    </c:when>
                                    <c:when test="${user.role.roleName.equals('user')}">
                                        <option  value="admin">Admin</option>
                                        <option selected value="user">User</option>
                                        <option  value="bookmaker">Bookmaker</option>
                                    </c:when>
                                    <c:when test="${user.role.roleName.equals('bookmaker')}">
                                        <option selected  value="bookmaker">Bookmaker</option>
                                        <option  value="admin">Admin</option>
                                        <option  value="user">User</option>
                                    </c:when>
                                </c:choose>
                            </select>
                        </td>
                        <td><c:out value="${user.isApproved}"/></td>
                        <td>
                            <form id="user_${user.userId}_form">
                                <button type="submit" name="command" value="change_role"><fmt:message
                                        key="adminUsers.changeRole"/></button>
                                <input type="hidden" name="userId" value="${user.userId}">
                            </form>
                        </td>
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
