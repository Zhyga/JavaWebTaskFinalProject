<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="ftm" uri="http://java.sun.com/jsp/jstl/fmt" %>
<ftm:setLocale value="${currentLocale}"/>
<ftm:setBundle basename="l10n.front-text"/>
<html>
<head>
    <title>Sign up</title>
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
            <label for="inputEmail"><ftm:message key="login.email"/></label>
            <input type="email" name="email" class="form-control" id="inputEmail" aria-describedby="emailHelp"
                   placeholder="Enter email" required>
            <small id="emailHelp" class="form-text text-muted"><ftm:message key="login.emailHelper"/></small>
        </div>
        <div class="form-group">
            <label for="inputLogin"><ftm:message key="login.login"/></label>
            <input type="text" name="login" class="form-control" id="inputLogin" aria-describedby="loginHelp"
                   placeholder="Enter login" required pattern="^(?=.*[A-Za-z0-9]$)[A-Za-z][\w.-]{0,19}$"
                   title="Login must start with a letter and ends with a letter or a digit">
            <small id="loginHelp" class="form-text text-muted"><ftm:message key="login.loginHelper"/></small>
        </div>
        <div class="form-group">
            <label for="inputPassword"><ftm:message key="login.password"/></label>
            <input type="password" name="password" class="form-control" id="inputPassword" placeholder="<ftm:message key="login.password"/>" required>
        </div>
        <label style="color: red">${errorSignUpMessage}</label>
        <br/>
        <button type="submit" class="btn btn-primary"><ftm:message key="login.register"/></button>
        <input type="hidden" name="command" value="sign_up">
    </form>
</div>
<jsp:include page="modules/footer.jsp"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/bootstrap.bundle.min.js"></script>
</body>
</html>
