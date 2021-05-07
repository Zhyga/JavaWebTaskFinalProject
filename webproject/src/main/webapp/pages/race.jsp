<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="ftm" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<ftm:setLocale value="${currentLocale}"/>
<ftm:setBundle basename="l10n.front-text"/>
<html>
<head>
    <title>${raceTitle}</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css">

    <!-- Custom styles for this template -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/project.css">
</head>
<body>
<jsp:include page="modules/header.jsp"/>
<div class="container" style="width: 980px; margin-left: auto; margin-right: auto">
    <label><c:out value="${raceTitle}"/></label>
    <p><c:out value="${raceTime}"/></p>
    <p><c:out value="${raceRounds}"/> rounds</p>
    <p><c:out value="${raceDetails}"/></p>
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
        <c:forEach var="participant" items="${raceParticipants}" varStatus="status">
            <tr>
                <td><c:out value="${participant.jockey}"/></td>
                <td><c:out value="${participant.horse}"/></td>
                <td><c:out value="${participant.weight}"/></td>
                <td><c:out value="${raceBets[0].firstMultiplier}"/></td>
                <td>
                    <form action="controller" method="post">
                        <input type="text" name="betSize" title="Bet size">
                        <button type="submit" name="command" value="place_bet">Bet</button>
                        <input type="hidden" name="multiplier" value="${raceBets[0].firstMultiplier}">
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<jsp:include page="modules/footer.jsp"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/project.js"></script>
</body>
</html>
