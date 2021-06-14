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
    <form action="controller" method="post">
        <p>
            <label>Jockey:</label>
            <input type="text" name="jockey" required pattern="^[A-Za-z]{3,45}|[A-Za-z]*\s[A-Za-z]{3,45}$">
        </p>
        <p>
            <label>Horse:</label>
            <input type="text" name="horse" required pattern="^[A-Za-z]{3,45}$">
        </p>
        <p>
            <label>Weight:</label>
            <input type="text" name="weight" required pattern="^[1-9]{1,3}$">
        </p>
        <p>
            <button type="submit" name="command" value="add_participant"><fmt:message key="adminParticipants.addParticipant"/></button>
        </p>

    </form>
    <label style="color: red">${errorParticipantCreated}</label>
</div>
<jsp:include page="../modules/footer.jsp"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/project.js"></script>
</body>
</html>
