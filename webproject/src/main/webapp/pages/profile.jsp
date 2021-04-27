<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="ftm" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<jsp:include page="modules/header.jsp"/>
<div class="container" style="width: 980px; margin-left: auto; margin-right: auto">
    <div class="row">
        <div class="col">
            <h4><ftm:message key="profile.user"/></h4>
            <h5>${login}</h5>
            <form action="controller" method="post">
                <button class="btn btn-primary mx-0" type="submit" name="command" value="change_password">
                    <ftm:message key="profile.changePassword"/>
                </button>
            </form>
            <form action="controller" method="post">
                <button class="btn btn-primary mx-0" type="submit" name="command" value="log_out">
                    <ftm:message key="profile.logOut"/>
                </button>
            </form>
        </div>
        <div class="col-9">
            <h4><ftm:message key="profile.betsHistory"/></h4>
            <div class="row text-center">
                <h6 class="col"><ftm:message key="profile.personalStat"/></h6>
                <h6 class="col"><ftm:message key="profile.numberOfBets"/></h6>
                <h6 class="col"><ftm:message key="profile.winrate"/></h6>
                <h6 class="col"><ftm:message key="profile.betsWin"/></h6>
            </div>
            <table class="table table-striped">
                <thead>
                <tr>
                    <th scope="col" ><ftm:message key="profile.eventTime"/></th>
                    <th scope="col" ><ftm:message key="profile.bet"/></th>
                    <th scope="col" ><ftm:message key="profile.betSize"/></th>
                    <th scope="col" ><ftm:message key="profile.multiplier"/></th>
                    <th scope="col" ><ftm:message key="profile.prize"/></th>
                    <th scope="col"><ftm:message key="profile.betStatus"/></th>
                </tr>
                </thead>
                <tbody>
                <label style="color: red">${emptyBetInfoList}</label>
                <c:forEach var="betsInfo" items="${betsInfoList}" varStatus="status">
                    <tr class="clickable-row" data-href="newTab">
                        <td class="raceDate" data-browse="${betsInfo.date}"></td>
                        <td><c:out value="${betsInfo.betInfo}"/></td>
                        <td><c:out value="${betsInfo.betSize}"/></td>
                        <td><c:out value="${betsInfo.multiplier}"/></td>
                        <td><c:out value="${betsInfo.prize}"/></td>
                        <td><c:out value="${betsInfo.betStatus}"/></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<jsp:include page="modules/footer.jsp"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/project.js"></script>
</body>
</html>
