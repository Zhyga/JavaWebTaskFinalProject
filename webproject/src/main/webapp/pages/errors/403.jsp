<%@ page isErrorPage="true" contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>Error 403</title>
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/assets/css/project.css">
</head>
<body>
<jsp:include page="../modules/header.jsp"/>
<section class="masthead">
    <div class="intro-body">
        <div class="container">
            <h5>Access forbidden</h5>
            <br/>
            <h5>Status code: 403</h5>
            <br/>
        </div>
    </div>
</section>
<jsp:include page="../modules/footer.jsp"/>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/assets/js/project.js"></script>
</body>
</html>