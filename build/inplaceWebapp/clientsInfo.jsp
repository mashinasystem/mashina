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

    <title>Personal info</title>

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
        <a class="navbar-brand" href="/">Mashina Inc.</a>
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
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownBlog" data-toggle="dropdown"
                       aria-haspopup="true" aria-expanded="false">
                        <fmt:message key="label.offices"/>
                    </a>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownBlog">
                        <a class="dropdown-item" href="#"><fmt:message key="label.USA"/></a>
                        <a class="dropdown-item" href="#"><fmt:message key="label.Germany"/></a>
                        <a class="dropdown-item" href="#"><fmt:message key="label.France"/></a>
                        <a class="dropdown-item" href="#"><fmt:message key="label.Canada"/></a>
                        <a class="dropdown-item" href="#"><fmt:message key="label.Belarus"/></a>
                        <a class="dropdown-item" href="#"><fmt:message key="label.Russia"/></a>
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownBlog" data-toggle="dropdown"
                       aria-haspopup="true" aria-expanded="false">
                        <fmt:message key="label.investors"/>
                    </a>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownBlog">
                        <a class="dropdown-item" href="#"><fmt:message key="label.about"/></a>
                        <a class="dropdown-item" href="#"><fmt:message key="label.infoDisclosure"/></a>
                        <a class="dropdown-item" href="#"><fmt:message key="label.sponsorship"/></a>
                        <a class="dropdown-item" href="#"><fmt:message key="label.publicRelations"/></a>
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
    </div>
</nav>

<!-- Page Content -->
<div class="container">
    <div class="row">
        <div class="col-lg-3"></div>
        <div class="col-lg-6 mb-4">
            <!-- Page Heading/Breadcrumbs -->
            <h1 class="py-4"></h1>
            <h1 class="mt-4 mb-3"><fmt:message key="label.personal"/>
                <small><fmt:message key="label.info"/></small>
            </h1>

            <p><fmt:message key="text.hereYouCheck"/></p>
            <table class="table table-hover">
                <thead>
                <tr>
                    <th><fmt:message key="label.graph"/></th>
                    <th><fmt:message key="label.info"/></th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td><fmt:message key="label.name"/></td>
                    <td>John Snow</td>
                </tr>
                <tr>
                    <td><fmt:message key="label.passport"/>Passport number</td>
                    <td>7826 487624</td>
                </tr>
                <tr>
                    <td><fmt:message key="label.license"/></td>
                    <td>785 658 71</td>
                </tr>
                <tr>
                    <td><fmt:message key="label.phone"/></td>
                    <td>+7 (921) 365-34-81</td>
                </tr>
                <tr>
                    <td><fmt:message key="label.email"/></td>
                    <td>johnnysnowysnow@mail.ru</td>
                </tr>
                <tr>
                    <td><fmt:message key="label.password"/></td>
                    <td>*******</td>
                </tr>
                </tbody>
            </table>
            <button type="submit" class="btn btn-warning" id="sendMessageButton"><fmt:message key="label.edit"/></button>
        </div>
    </div>
</div>
<!-- /.container -->

<!-- Footer -->
<footer class="py-3 bg-dark">
    <div class="container">
        <p class="m-0 text-center text-white">Copyright &copy; Mashina Inc 2019</p>
    </div>
    <!-- /.container -->
</footer>

<!-- Bootstrap core JavaScript -->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>
