<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="ftm" uri="http://java.sun.com/jsp/jstl/fmt" %>
<ftm:setLocale value="${currentLocale}"/>
<ftm:setBundle basename="l10n.front-text"/>
<html>
<head>
    <title>Sign in</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css">

    <!-- Custom styles for this template -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/project.css">
</head>
<body>
<jsp:include page="modules/header.jsp"/>
<div class="container justify-content-center" style="width: 380px; margin-left: auto; margin-right: auto">
    <form action="controller" method="post">
        <div class="form-group">
            <label for="inputLogin"><ftm:message key="login.login"/></label>
            <input type="text" name="login" class="form-control" id="inputLogin" aria-describedby="loginHelp"
                   placeholder="<ftm:message key="login.loginHelper"/>">
            <small id="loginHelp" class="form-text text-muted"><ftm:message key="login.loginHelper"/></small>
        </div>
        <div class="form-group">
            <label for="inputPassword"><ftm:message key="login.password"/></label>
            <input type="password" name="password" class="form-control" id="inputPassword"
                   placeholder="<ftm:message key="login.password"/>">
        </div>
        <label style="color: red">${errorLoginPasMessage}</label>
        <br/>
        <button type="submit" name="command" value="sign_in" class="btn btn-primary">
            <ftm:message key="login.submit"/>
        </button>
    </form>
</div>
<jsp:include page="modules/footer.jsp"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/bootstrap.bundle.min.js"></script>
</body>
</html>
