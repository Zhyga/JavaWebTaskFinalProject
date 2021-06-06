<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="ftm" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ctg" uri="customTags" %>
<ftm:setLocale value="${currentLocale}"/>
<ftm:setBundle basename="l10n.front-text"/>
<html>
<head>
    <title>${currentRace.title}</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css">

    <!-- Custom styles for this template -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/project.css">
</head>
<body>
<jsp:include page="modules/header.jsp"/>
<div class="container" style="width: 980px; margin-left: auto; margin-right: auto">
    <label><c:out value="${currentRace.title}"/></label>
    <p><c:out value="${currentRace.raceData.date}"/></p>
    <p><c:out value="${currentRace.rounds}"/> rounds</p>
    <p><c:out value="${currentRace.details}"/></p>
    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col" style="border-top: none;"><ftm:message key="race.jockey"/></th>
            <th scope="col" style="border-top: none;"><ftm:message key="race.horse"/></th>
            <th scope="col" style="border-top: none;"><ftm:message key="race.weight"/></th>
            <th scope="col" style="border-top: none;"><ftm:message key="race.odds"/></th>
            <th scope="col" style="border-top: none;"></th>
        </tr>
        </thead>
        <tbody>
        <ctg:bets-table participants="${currentRace.raceData.participantsId}" bets="${raceBets}"/>
        </tbody>
    </table>
</div>
<jsp:include page="modules/footer.jsp"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/project.js"></script>
</body>
</html>
