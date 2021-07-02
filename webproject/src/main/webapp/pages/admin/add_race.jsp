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
    <form action="controller" method="post">
        <p>
            <label>Title:</label>
            <input type="text" name="raceTitle" required pattern="^[A-Za-z]*|[A-Za-z]*\s[A-Za-z]*$">
        </p>
        <p>
            <label>Round:</label>
            <input type="text" name="raceRounds" required pattern="^[1-9]{1,2}$">
        </p>
        <p>
            <label>Details:</label>
            <input type="text" name="raceDetails" required>
        </p>
        <p>
            <label>Race data:</label>
            <input type="date" name="raceDate" required>
            <input type="time" name="raceTime" required>
        </p>
        <p>
            <select class="form-select" multiple name="raceParticipants">
                <c:forEach var="participant" items="${raceParticipants}" varStatus="status">
                    <option><c:out value="${participant.horse}"/></option>
                </c:forEach>
            </select>
        </p>
        <p>
            <button type="submit" name="command" value="create_race">Add race</button>
        </p>

    </form>
    <label style="color: red">${errorRaceCreated}</label>
</div>
<jsp:include page="../modules/footer.jsp"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/project.js"></script>
</body>
</html>
