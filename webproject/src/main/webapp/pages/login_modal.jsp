<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

</head>
<body>
<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Sign in</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form action="controller" method="post" id="authorizeForm">
                    <div class="form-group">
                        <label for="inputEmail">Email</label>
                        <input type="text" name="login" class="form-control" id="inputEmail" required>
                    </div>
                    <div class="form-group">
                        <label for="inputPassword">Password</label>
                        <input type="password" name="password" class="form-control" id="inputPassword" required>
                    </div>
                    <input type="hidden" name="command" value="sign_in">
                    <label style="color: red">${errorLoginPasMessage}</label>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <button form="authorizeForm" type="submit" class="btn btn-primary">Sign In</button>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/project.js"></script>
</body>
</html>
