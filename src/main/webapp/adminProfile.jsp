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

    <title><fmt:message key="label.profile"/></title>

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
                        <a class="nav-link" href="/clients/profile">
                            <fmt:message key="label.profile"/>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/clients/orders">
                            <fmt:message key="label.orders"/>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/clients/info">
                            <fmt:message key="label.Info"/>
                        </a>
                    </li>

                        <% } else if (session.getAttribute("role").toString().equals("ADMIN")) {%>

                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="/admin/profile">
                                <fmt:message key="label.profile"/>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/admin/orders">
                                <fmt:message key="label.orders"/>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/admin/customers">
                                <fmt:message key="label.customers"/>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/admin/info">
                                <fmt:message key="label.Info"/>
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

<!-- Page Content -->
<div class="container">

    <!-- Page Heading/Breadcrumbs -->
    <h1 class="py-4"></h1>
    <h1 class="mt-4 mb-3"><fmt:message key="label.personal"/>
        <small><fmt:message key="label.area"/></small>
    </h1>

    <div class="row">
        <div class="col-lg-4 portfolio-item">
            <div class="card h-100">
                <a href="/admin/orders"><img class="card-img-top" src="htp://placehold.it/700x400" alt=""></a>
                <div class="card-body">
                    <h4 class="card-title">
                        <a href="/admin/orders"><fmt:message key="label.orders"/></a>
                    </h4>
                    <p class="card-text">
                        <fmt:message key="text.bookACar"/>
                    </p>
                </div>
            </div>

        </div>
        <div class="col-lg-4 portfolio-item">
            <div class="card h-100">
                <a href="/admin/customers"><img class="card-img-top" src="htp://placehold.it/700x400" alt=""></a>
                <div class="card-body">
                    <h4 class="card-title">
                        <a href="/admin/customers">
                            <fmt:message key="label.customers"/>
                        </a>
                    </h4>
                    <p class="card-text">
                        <fmt:message key="text.checkOrEdit"/>
                    </p>
                </div>
            </div>
        </div>
        <div class="col-lg-4 portfolio-item">
            <div class="card h-100">
                <a href="/admin/info"><img class="card-img-top" src="htp://placehold.it/700x400" alt=""></a>
                <div class="card-body">
                    <h4 class="card-title">
                        <a href="/admin/info">
                            <fmt:message key="label.personal"/> <fmt:message key="label.area"/>
                        </a>
                    </h4>
                    <p class="card-text">
                        <fmt:message key="text.checkOrEdit"/>
                    </p>
                </div>
            </div>
        </div>
                <div class="col-lg-4 portfolio-item">
                    <div class="card h-100">
                        <a href="/admin/customers"><img class="card-img-top" src="htp://placehold.it/700x400" alt=""></a>
                        <div class="card-body">
                            <h4 class="card-title">
                                <a href="/admin/cars">
                                    <fmt:message key="label.cars"/>
                                </a>
                            </h4>
                            <p class="card-text">
                                <fmt:message key="text.checkOrEdit"/>
                            </p>
                        </div>
                    </div>
                </div>
    </div>
    <h1 class="py-4"></h1>
    <!-- /.row -->

</div>
<!-- /.container -->

<!-- Footer -->
<footer class="py-3 bg-dark">
    <div class="container">
        <p class="m-0 text-center text-white">Copyright &copy; Mashina Inc 2019</p>
    </div>
    <!-- /.container -->
</footer>
</body>

</html>
