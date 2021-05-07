<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ftm" uri="http://java.sun.com/jsp/jstl/fmt" %>
<ftm:setLocale value="${currentLocale}"/>
<ftm:setBundle basename="l10n.front-text"/>
<!DOCTYPE html>
<html lang="en">
<head>
</head>
<body>
<div class="container" style="width: 980px; margin-left: auto; margin-right: auto">
    <header class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom">
        <div class="d-flex flex-row justify-content-start align-items-center pr-0">
            <form action="controller" method="post" class="my-auto">
                <button class="btn navbar-brand" style="color: #007bff;" name="command" value="to_main">
                    <ftm:message key="header.brand"/>
                </button>
            </form>
            <div class="d-flex justify-content-start dropdown">
                <a class="nav-link dropdown-toggle language-choice" href="#" id="navbarDropdown" role="button"
                   data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">
                    <ftm:message key="header.language"/>
                </a>
                <form action="controller" method="post">
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <button class="dropdown-item" type="submit" name="newLocale" value="en_US">
                            <ftm:message key="header.language_en"/></button>
                        <button class="dropdown-item" type="submit" name="newLocale" value="ru_RU">
                            <ftm:message key="header.language_ru"/></button>
                        <input type="hidden" name="command" value="switch_locale">
                    </div>
                </form>
            </div>
        </div>
        <c:choose>
            <c:when test="${role.equals('admin')}">
                <div class="d-flex flex-row justify-content-end align-items-center pr-0">
                    <form action="controller" method="post" class="my-auto">
                        <button class="btn btn-outline-primary mx-1" type="submit" name="command"
                                value="to_admin_users">
                            <ftm:message key="profile.adminUsers"/>
                        </button>
                    </form>
                    <form action="controller" method="post" class="my-auto">
                        <button class="btn btn-outline-primary mx-1" type="submit" name="command"
                                value="to_admin_races">
                            <ftm:message key="profile.adminRaces"/>
                        </button>
                    </form>
                    <form action="controller" method="post"  class="my-auto">
                        <button type="submit" name="command" value="to_add_balance" class="deposit mx-1 btn btn-link">
                            <ftm:message key="header.balance"/>${balance}
                        </button>
                    </form>
                    <form action="controller" method="post" class="my-auto">
                        <button class="btn btn-outline-primary mx-1" type="submit" name="command" value="to_profile">
                            <ftm:message key="header.profile"/>
                        </button>
                    </form>
                </div>
            </c:when>
            <c:when test="${role.equals('user')}">
                <div class="d-flex flex-row justify-content-end align-items-center pr-0">
                    <form action="controller" method="post"  class="my-auto">
                        <button type="submit" name="command" value="to_add_balance" class="deposit mx-1 btn btn-link">
                            <ftm:message key="header.balance"/>${balance}
                        </button>
                    </form>
                    <form action="controller" method="post" class="my-auto">
                        <button class="btn btn-outline-primary mx-1" type="submit" name="command" value="to_profile">
                            <ftm:message key="header.profile"/>
                        </button>
                    </form>
                </div>
            </c:when>
            <c:otherwise>
                <div class="d-flex flex-row justify-content-end align-items-center pr-0">
                    <a href="#" class="deposit mx-1"><ftm:message key="header.deposit"/></a>
                    <form action="controller" method="post" class="my-auto">
                        <button class="btn btn-outline-primary mx-1" type="submit" name="command" value="to_sign_in">
                            <ftm:message key="header.login"/>
                        </button>
                    </form>
                    <form action="controller" method="post" class="my-auto">
                        <button type="submit" name="command" value="to_sign_up" class="btn btn-primary mx-1">
                            <ftm:message key="header.sign_up"/>
                        </button>
                    </form>
                </div>
            </c:otherwise>
        </c:choose>
    </header>
</div>
</body>
</html>
