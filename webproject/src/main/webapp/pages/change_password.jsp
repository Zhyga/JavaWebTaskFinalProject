<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${currentLocale}"/>
<fmt:setBundle basename="l10n.front-text"/>
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
            <label for="inputOldPassword"><fmt:message key="changePassword.oldPassword"/></label>
            <input type="password" name="oldPassword" class="form-control" id="inputOldPassword"
                   placeholder="<fmt:message key="changePassword.oldPasswordHelper"/>" pattern="^[\w]{3,20}$" required>
        </div>
        <div class="form-group">
            <label for="inputPassword"><fmt:message key="changePassword.newPassword"/></label>
            <input type="password" name="newPassword" class="form-control" id="inputPassword"
                   placeholder="<fmt:message key="login.password"/>" pattern="^[\w]{3,20}$" required>
        </div>
        <div class="form-group">
            <label for="inputConfirmPassword"><fmt:message key="changePassword.repeatPassword"/></label>
            <input type="password" class="form-control" id="inputConfirmPassword"
                   placeholder="<fmt:message key="login.password"/>" pattern="^[\w]{3,20}$" required>
        </div>
        <label style="color: red">${errorChangePasMessage}</label>
        <br/>
        <button type="submit" name="command" value="change_password" class="btn btn-primary" id="changePasswordButton">
            <fmt:message key="login.submit"/>
        </button>
    </form>
</div>
<jsp:include page="modules/footer.jsp"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/project.js"></script>
<script>
    document.getElementById('changePasswordButton').addEventListener(
        'click', ansValidation, false
    );
</script>
</body>
</html>
