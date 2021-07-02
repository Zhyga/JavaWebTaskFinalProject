<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${currentLocale}" scope="session"/>
<fmt:setBundle basename="l10n.front-text"/>
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
            <label for="inputEmail"><fmt:message key="login.email"/></label>
            <input type="email" name="email" class="form-control" id="inputEmail" aria-describedby="emailHelp"
                   placeholder="Enter email" required>
            <small id="emailHelp" class="form-text text-muted"><fmt:message key="login.emailHelper"/></small>
        </div>
        <div class="form-group">
            <label for="inputLogin"><fmt:message key="login.login"/></label>
            <input type="text" name="login" class="form-control" id="inputLogin" aria-describedby="loginHelp"
                   placeholder="Enter login" required pattern="^(?=.*[A-Za-z0-9]$)[A-Za-z][\w.-]{0,19}$"
                   title="Login must start with a letter and ends with a letter or a digit">
            <small id="loginHelp" class="form-text text-muted"><fmt:message key="login.loginHelper"/></small>
        </div>
        <div class="form-group">
            <label for="inputPassword"><fmt:message key="login.password"/></label>
            <input type="password" name="password" class="form-control" id="inputPassword"
                   placeholder="<fmt:message key="login.password"/>" required pattern="^[\w]{3,20}$">
        </div>
        <div class="form-group">
            <label for="inputConfirmPassword"><fmt:message key="login.password"/></label>
            <input type="password" name="confirmedPassword" class="form-control" id="inputConfirmPassword"
                   placeholder="<fmt:message key="login.password"/>" required pattern="^[\w]{3,20}$">
        </div>
        <label style="color: red">${errorSignUpMessage}</label>
        <br/>
        <button type="submit" class="btn btn-primary" id="signUpButton"><fmt:message key="login.register"/></button>
        <input type="hidden" name="command" value="sign_up">
    </form>
</div>
<jsp:include page="modules/footer.jsp"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/project.js"></script>
<script>
    document.getElementById('signUpButton').addEventListener(
        'click', ansValidation, false
    );
</script>
</body>
</html>
