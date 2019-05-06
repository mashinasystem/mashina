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

    <title><fmt:message key="label.logIn"/></title>

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

    <!-- Custom styles for this template -->
    <link href="css/modern-business.css" rel="stylesheet">
    <script src="js/passanim.js"></script>

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
            <a class="btn btn-danger btn-sm" href="/logout" method="get">Logout</a>
        <% } %>
    </div>
</nav>

<!-- Page Content -->
<div class="container">

    <!-- Contact Form -->
    <!-- In order to set the email address and subject line for the contact form go to the bin/contact_me.php file. -->
    <div class="row">
        <div class="col-lg-3"></div>
        <div class="col-lg-6 mb-4">
            <!-- Page Heading/Breadcrumbs -->
            <h1 class="pt-5"><fmt:message key="label.loginForm"/>
                <small><fmt:message key="label.form"/></small>
            </h1>
            <h4><fmt:message key="label.fillTheFields"/></h4>
            <form class="login-form" action="login" method="post">
                <c:set var="isFail" scope="session" value="${fail}"/>
                <c:if test="${isFail > 0}">
                    <p class="text-danger"><fmt:message key="label.invalidCredentials"/></p>
                </c:if>
                <div class="control-group form-group">
                    <div class="controls">
                        <input type="text" class="form-control" id="text" placeholder="Login" name="username" required
                               data-validation-required-message="Please enter your email address.">
                    </div>
                </div>
                <!-- Password -->
                <div class="control-group form-group">
                    <div class="controls">
                        <input type="password" class="form-control" required="required" type="password" id="password"
                               name="password" placeholder="Password" required
                               data-validation-required-message="Please enter your email address.">
                    </div>
                </div>
                <div id="success"></div>
                <!-- For success/fail messages -->
                <button type="submit" class="btn btn-dark" id="text" value="login">
                    <fmt:message key="label.login"/>
                </button>
                <p class="mt-2 mb-4 message">
                    <fmt:message key="label.notRegistered"/>
                    <a href="/registration">
                        <fmt:message key="label.createAccaunt"/>
                    </a>
                </p>
            </form>
        </div>
    </div>
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