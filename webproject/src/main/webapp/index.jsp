<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
    <jsp:forward page="/controller">
        <jsp:param name="command" value="to_main"/>
    </jsp:forward>
</body>
</html>