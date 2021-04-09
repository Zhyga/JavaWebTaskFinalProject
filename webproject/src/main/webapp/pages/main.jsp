<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="ftm" uri="http://java.sun.com/jsp/jstl/fmt" %>
<ftm:setLocale value="${currentLocale}"/>
<ftm:setBundle basename="l10n.front-text"/>
<html>
<head>
    <title>LYM</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css">

    <!-- Custom styles for this template -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/project.css">
</head>
<body>
<jsp:include page="header.jsp"/>

<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/bootstrap.bundle.min.js"></script>
</body>
</html>
