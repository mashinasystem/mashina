<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages"/>

<!DOCTYPE html>

<html lang="${sessionScope.lang}">
<head>
    <c:if test="${not empty param.lang}">
        <c:set var="lang" scope="session" value="${param.lang}"/>
    </c:if>
    <script>
        (function setLangParameterToSessionScope() {
            if (window.location.search === '?lang=en' || window.location.search === '?lang=ru') {
                window.location.search = '';
            }
        })()
    </script>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title><fmt:message key="label.newOrder"/></title>

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

    <!-- Custom styles for this template -->
    <link href="css/modern-business.css" rel="stylesheet">

</head>

<body>

<!-- Navigation -->
<nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
        <a href="/"><img src="/img/m.png" class="navbar-brand rounded"></a>
        <a class="navbar-brand" href="/">Mashina</a>

        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse"
                data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false"
                aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">

            <% if (session.getAttribute("role") == null) {%>

            <ul class="navbar-nav ml-auto">

                    <%} else if (session.getAttribute("role").toString().equals("CUSTOMER")) {%>

                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="/clients/1/profile">
                            <fmt:message key="label.profile"/>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/clients/1/orders">
                            <fmt:message key="label.orders"/>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/clients/1/info">
                            <fmt:message key="label.Info"/>
                        </a>
                    </li>

                        <% } else if (session.getAttribute("role").toString().equals("ADMIN")) {%>

                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="/admin/1/profile">
                                <fmt:message key="label.profile"/>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/admin/1/orders">
                                <fmt:message key="label.orders"/>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/admin/1/customers">
                                <fmt:message key="label.customers"/>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/admin/1/info">
                                <fmt:message key="label.Info"/>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/admin/1/cars">
                                <fmt:message key="label.cars"/>
                            </a>
                        </li>
                        <% }%>
                    </ul>
        </div>

        <div class="btn-group">
            <button type="button" class="btn btn-secondary btn-sm dropdown-toggle" data-toggle="dropdown">
                <fmt:message key="label.language"/>
            </button>
            <div class="dropdown-menu dropdown-menu-right">
                <a class="dropdown-item" href="?lang=en"><fmt:message key="label.English"/></a>
                <a class="dropdown-item" href="?lang=ru"><fmt:message key="label.Russian"/></a>
            </div>
        </div>
        <a class="text-dark">.</a>
        <% if (session.getAttribute("role") == null) { %>
        <a class="btn btn-success btn-sm" href="/login">
            <fmt:message key="label.signIn"/>
        </a>
        <% } else { %>
        <a class="btn btn-danger btn-sm" href="/logout" method="get"><fmt:message key="label.logout"/></a>
        <% } %>
    </div>
</nav>

<!-- Contact Form -->
<div class="row">
    <div class="col-lg-4"></div>
    <div class="col-lg-4 mb-4">
        <!-- Page Heading/Breadcrumbs -->
        <h1 class="pt-5"><fmt:message key="label.create"/>
            <small><fmt:message key="label.order"/></small>
        </h1>
        <h4><fmt:message key="label.fillTheFields"/></h4>
        <form class="registration-form" name="registration-form" method="post">
            <div class="control-group form-group">
                <div class="controls">
                    <input type="text" class="form-control" id="name" placeholder="carId" name="carId" required
                           data-validation-required-message="Please enter your name.">
                    <p class="help-block"></p>
                </div>
            </div>
            <div class="control-group form-group">
                <div class="controls">
                    <input type="text" class="form-control" id="text" placeholder="period" name="period" required
                           data-validation-required-message="Please enter your phone number.">
                </div>
            </div>
            <div id="success"></div>
            <!-- For success/fail messages -->
            <button type="submit" class="btn btn-dark"><fmt:message key="label.create"/></button>
        </form>
    </div>
</div>

<!-- Footer -->
<footer class="py-3 bg-dark">
    <div class="container">
        <p class="m-0 text-center text-white">Copyright &copy; Mashina Inc 2019</p>
    </div>
    <!-- /.container -->
</footer>
</body>

</html>