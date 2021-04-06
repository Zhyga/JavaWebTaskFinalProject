<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Header</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css">

    <!-- Custom styles for this template -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/project.css">
</head>
<body>
<jsp:include page="login_modal.jsp"/>
<div class="container" style="width: 980px; margin-left: auto; margin-right: auto">
    <header class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom">
        <a class="navbar-brand" href="#">LYM</a>
        <div class="d-flex flex-row justify-content-end align-items-center pr-0">
            <a href="#" class="deposit mx-1">Ввод/вывод средств</a>
            <button class="btn btn-outline-primary mx-1" data-toggle="modal" data-target="#exampleModal">Login</button>
            <form action="controller" method="post">
                <input type="submit" value="Sign-up" class="btn btn-primary mx-1"/>
                <input type="hidden" name="command" value="to_sign_up">
            </form>
        </div>
    </header>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/bootstrap.bundle.min.js"></script>

</body>
</html>
