<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="${currentLocale}" scope="session"/>
<fmt:setBundle basename="l10n.front-text"/>
<html>
<head>
    <title>Participants</title>
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
                <button type="submit" name="command" value="to_add_participant"><fmt:message key="adminParticipants.addParticipant"/></button>
            </form>
            <label style="color: red">${participantDeleted}</label>
            <table class="table table-striped">
                <thead>
                <tr>
                    <th scope="col" style="border-top: none;"><fmt:message key="adminParticipants.jockey"/></th>
                    <th scope="col" style="border-top: none;"><fmt:message key="adminParticipants.horse"/></th>
                    <th scope="col" style="border-top: none;"><fmt:message key="adminParticipants.weight"/></th>
                </tr>
                </thead>
                <tbody>
                <label style="color: red">${errorAdminUser}</label>
                <c:forEach var="participant" items="${raceParticipants}" varStatus="status">
                    <tr>
                        <td><C:out value="${participant.jockey}"/></td>
                        <td><c:out value="${participant.horse}"/></td>
                        <td><c:out value="${participant.weight}"/></td>
                        <td><a href="controller?command=to_edit_participant&participant_id=${participant.participantID}">
                            <fmt:message key="adminParticipants.edit"/></a>
                        </td>
                        <td><a href="controller?command=delete_participant&participant_id=${participant.participantID}">
                            <fmt:message key="adminParticipants.delete"/></a>
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
