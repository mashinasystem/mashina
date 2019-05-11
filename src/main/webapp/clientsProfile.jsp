<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${param.lang}"/>
<fmt:setBundle basename="messages"/>

<!DOCTYPE html>
<html lang="${param.lang}">

<head>

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

        <% if (session.getAttribute("role") != null)  { %>
            <p class="navbar-nav text-white">
                Username: <%= session.getAttribute("login") %>, Role: <%= session.getAttribute("role") %>
            </p>
        <% } %>

        <a class="navbar-brand"></a>
        <a class="navbar-brand" href="/clients/1/profile">CLIENT</a>
        <a class="navbar-brand" href="/admin/1/profile">ADMIN</a>

        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse"
                data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false"
                aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link" href="#">
                        <fmt:message key="label.profile"/>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">
                        <fmt:message key="label.services"/>
                    </a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownPortfolio" data-toggle="dropdown"
                       aria-haspopup="true" aria-expanded="false">
                        <fmt:message key="label.brands"/>
                    </a>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownPortfolio">
                        <a class="dropdown-item" href="#">Tesla</a>
                        <a class="dropdown-item" href="#">Porsche</a>
                        <a class="dropdown-item" href="#">Jaguar</a>
                        <a class="dropdown-item" href="#">Lexus</a>
                        <a class="dropdown-item" href="#">BMW</a>
                    </div>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">
                        <fmt:message key="label.faq"/>
                    </a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownBlog" data-toggle="dropdown"
                       aria-haspopup="true" aria-expanded="false">
                        <fmt:message key="label.language"/>
                    </a>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownBlog">
                        <a class="dropdown-item" href="?lang=en"><fmt:message key="label.English"/></a>
                        <a class="dropdown-item" href="?lang=ru"><fmt:message key="label.Russian"/></a>
                    </div>
                </li>
            </ul>
        </div>
        <% if (session.getAttribute("role") == null)  { %>
            <a class="btn btn-success btn-sm" href="login">
                <fmt:message key="label.signIn"/>
            </a>
        <% } else { %>
            <a class="btn btn-danger btn-sm" href="/logout" method="get">
                <fmt:message key="label.logout"/>
            </a>
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
        <div class="col-lg-6 portfolio-item">
            <div class="card h-100">
                <a href="/clients/1/orders"><img class="card-img-top" src="htp://placehold.it/700x400" alt=""></a>
                <div class="card-body">
                    <h4 class="card-title">
                        <a href="/clients/1/orders"><fmt:message key="label.orders"/></a>
                    </h4>
                    <p class="card-text">
                        <fmt:message key="text.bookACar"/>
                    </p>
                </div>
            </div>
        </div>
        <div class="col-lg-6 portfolio-item">
            <div class="card h-100">
                <a href="/clients/1/info"><img class="card-img-top" src="htp://placehold.it/700x400" alt=""></a>
                <div class="card-body">
                    <h4 class="card-title">
                        <a href="/clients/1/info">
                            <fmt:message key="label.personal"/> <fmt:message key="label.area"/>
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
