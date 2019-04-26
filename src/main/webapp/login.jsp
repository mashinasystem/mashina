<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset = UTF-8" language="java" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setBundle basename="messages"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Login</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/example.css">
    <script src="js/bootstrap.min.js"></script>
    <script src="js/passanim.js"></script>
</head>

<body>

<div class="login-page">
    <div class="form">
        <form class="login-form" action="login" method="post">
            <c:set var="isFail" scope="session" value="${fail}"/>
            <c:if test="${isFail > 0}">
                <fmt:message key="label.invalidCredentials"/>
            </c:if>
            <input type="text" placeholder="username" name="username"/>
            <input type="password" id="paslog" placeholder="password" name="password"/>
            <div class="container">
                <div class="left">
                    <input type="checkbox" class="checkbox" id="check1" onclick="passanim()"/>
                </div>
                <div class="right">
                    <label for="check1"><fmt:message key="label.showPassword"/></label>
                </div>
            </div>
            <button type="submit" value="login">
                <fmt:message key="label.login"/>
            </button>
            <p class="message">
                <fmt:message key="label.notRegistered"/>
                <a href="/registration"> <fmt:message key="label.createAnAccount"/> </a>
            </p>
        </form>
    </div>
</div>

</body>

</html>