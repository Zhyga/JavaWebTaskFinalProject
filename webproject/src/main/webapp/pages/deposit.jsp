<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="${currentLocale}" scope="session"/>
<fmt:setBundle basename="l10n.front-text"/>
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
<jsp:include page="modules/header.jsp"/>
<div class="container" style="width: 980px; margin-left: auto; margin-right: auto">
    <ul class="nav nav-tabs">
        <li class="nav-item">
            <button class="nav-link tabLink pastEventsBut" id="defaultOpen" onclick="openTab(event,'deposit')" >
                <fmt:message key="balanceEnrich.deposit"/>
            </button>
        </li>
        <li class="nav-item">
            <button class="nav-link pastEventsBut tabLink" onclick="openTab(event,'withdraw')">
                <fmt:message key="balanceEnrich.withdraw"/>
            </button>
        </li>

    </ul>
    <form action="controller" method="post" class="tabContent" id="deposit">
        <div class="form-group">
            <label for="inputCardNumber"><fmt:message key="balanceEnrich.cardNumber"/></label>
            <input type="text" name="cardNumber" class="form-control" id="inputCardNumber" required
                   pattern="^[0-9]{16}$">
        </div>
        <div class="form-group">
            <label for="inputAmount"><fmt:message key="balanceEnrich.depositAmount"/></label>
            <input type="text" name="refillAmount" class="form-control" required>
        </div>
        <label style="color: red">${errorIncorrectCarNumber}</label>
        <br/>
        <button type="submit" name="command" value="deposit" class="btn btn-primary">
            <fmt:message key="balanceEnrich.deposit"/>
        </button>
    </form>
    <form action="controller" method="post" class="tabContent" id="withdraw">
        <div class="form-group">
            <label for="inputCardNumber"><fmt:message key="balanceEnrich.cardNumber"/></label>
            <input type="text" name="cardNumber" class="form-control" required
                   pattern="^[0-9]{16}$">
        </div>
        <div class="form-group">
            <label for="inputAmount"><fmt:message key="balanceEnrich.withdrawAmount"/></label>
            <input type="text" name="withdrawAmount" class="form-control" id="inputAmount" required>
        </div>
        <label style="color: red">${errorIncorrectCarNumber}</label>
        <br/>
        <button type="submit" name="command" value="withdraw" class="btn btn-primary">
            <fmt:message key="balanceEnrich.withdraw"/>
        </button>
    </form>
</div>
<jsp:include page="modules/footer.jsp"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/project.js"></script>
<script>
    openTab(event,'deposit');
    document.getElementById('defaultOpen').className += " active";
</script>
</body>
</html>
