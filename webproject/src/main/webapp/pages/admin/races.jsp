<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="${currentLocale}"/>
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
            <form action="controller" method="post">
                <button type="submit" name="command" value="to_add_race"><fmt:message key="adminRaces.addRace"/></button>
            </form>
            <label style="color: red">${raceDeleted}</label>
            <table class="table table-striped">
                <thead>
                <tr>
                    <th scope="col" style="border-top: none;"><fmt:message key="main.eventTime"/></th>
                    <th scope="col" style="border-top: none;"><fmt:message key="main.eventTitle"/></th>
                    <th scope="col" style="border-top: none;"><fmt:message key="main.eventRound"/></th>
                    <th scope="col" style="border-top: none;"><fmt:message key="main.eventDetails"/></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="race" items="${raceList}" varStatus="status">
                    <tr>
                        <td class="raceDate" data-browse="${race.raceData.date}"></td>
                        <td><c:out value="${race.title}"/></td>
                        <td><c:out value="${race.rounds}"/></td>
                        <td><c:out value="${race.details}"/></td>
                        <td><a href="controller?command=delete_race&raceId=${race.raceId}">
                            <fmt:message key="adminRaces.deleteRace"/>
                            </a></td>
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
