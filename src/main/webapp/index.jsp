<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${param.lang}"/>
<fmt:setBundle basename="messages"/>

<!DOCTYPE html>
<html lang="${param.lang}">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <meta name="description" content=""/>
    <meta name="author" content=""/>

    <title><fmt:message key="label.title"/></title>
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
        <a class="navbar-brand" href="/">Mashina</a>

        <p class="navbar-nav text-white">
            Username: <%= session.getAttribute("login") %>, Role: <%= session.getAttribute("role") %>
        </p>
        <a class="btn btn-danger btn-sm" href="/logout" method="get">Logout</a>
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

<header>
    <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
            <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner" role="listbox">
            <!-- Slide One - Set the background image for this slide in the line below -->
            <div class="carousel-item active" style="background-image: url('img/slide1.jpg')">
                <div class="carousel-caption d-none d-md-block">
                    <h3>Tesla Model X</h3>
                    <p><fmt:message key="label.eco-friendly"/></p>
                </div>
            </div>
            <!-- Slide Two - Set the background image for this slide in the line below -->
            <div class="carousel-item" style="background-image: url('img/slide2.jpg')">
                <div class="carousel-caption d-none d-md-block">
                    <h3>Porsche Cayman GT4</h3>
                    <p><fmt:message key="label.setOfEmotions"/></p>
                </div>
            </div>
            <!-- Slide Three - Set the background image for this slide in the line below -->
            <div class="carousel-item" style="background-image: url('img/slide3.jpg')">
                <div class="carousel-caption d-none d-md-block">
                    <h3>Ferrari 488</h3>
                    <p><fmt:message key="label.refined"/></p>
                </div>
            </div>
        </div>
        <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only"><fmt:message key="label.previous"/></span>
        </a>
        <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only"><fmt:message key="label.next"/></span>
        </a>
    </div>
</header>

<!-- Page Content -->
<div class="container">

    <h1 class="my-4"><fmt:message key="label.mashinaIs"/></h1>

    <!-- Marketing Icons Section -->
    <div class="row">
        <div class="col-lg-3 my-4 mb-4"></div>
        <div class="col-lg-6 my-4 mb-4">
            <div class="card h-100">
                <h4 class="card-header"><fmt:message key="label.hasAccount"/></h4>
                <div class="card-body">
                    <p class="card-text">
                        <fmt:message key="text.youCanBook"/>
                    </p>
                </div>
                <div class="card-footer">
                    <a href="login" class="btn btn-primary">
                        <fmt:message key="label.signIn"/>
                    </a>
                </div>
            </div>
        </div>
    </div>
    <!-- /.row -->

    <!-- Portfolio Section -->
    <h2><fmt:message key="label.ourCars"/></h2>

    <div class="row">
        <div class="col-lg-4 col-sm-6 portfolio-item">
            <div class="card h-100">
                <a href="#"><img class="card-img-top" src="img/card1.jpg" alt=""></a>
                <div class="card-body">
                    <h4 class="card-title">
                        <a href="#">Porsche 911 Carrera</a>
                    </h4>
                    <p class="card-text">
                        <fmt:message key="text.Porsche911Carrera"/>
                    </p>
                </div>
            </div>
        </div>
        <div class="col-lg-4 col-sm-6 portfolio-item">
            <div class="card h-100">
                <a href="#"><img class="card-img-top" src="img/card2.jpg" alt=""></a>
                <div class="card-body">
                    <h4 class="card-title">
                        <a href="#">Jaguar F-Type</a>
                    </h4>
                    <p class="card-text">
                        <fmt:message key="text.JaguarFType"/>
                    </p>
                </div>
            </div>
        </div>
        <div class="col-lg-4 col-sm-6 portfolio-item">
            <div class="card h-100">
                <a href="#"><img class="card-img-top" src="img/card3.jpg" alt=""></a>
                <div class="card-body">
                    <h4 class="card-title">
                        <a href="#">Lotus Evora</a>
                    </h4>
                    <p class="card-text">
                        <fmt:message key="text.LotusEvora"/>
                    </p>
                </div>
            </div>
        </div>
        <div class="col-lg-4 col-sm-6 portfolio-item">
            <div class="card h-100">
                <a href="#"><img class="card-img-top" src="img/card4.jpg" alt=""></a>
                <div class="card-body">
                    <h4 class="card-title">
                        <a href="#">BMW i8</a>
                    </h4>
                    <p class="card-text">
                        <fmt:message key="text.BMWi8"/>
                    </p>
                </div>
            </div>
        </div>
        <div class="col-lg-4 col-sm-6 portfolio-item">
            <div class="card h-100">
                <a href="#"><img class="card-img-top" src="img/card5.jpg" alt=""></a>
                <div class="card-body">
                    <h4 class="card-title">
                        <a href="#">Nissan GT-R</a>
                    </h4>
                    <p class="card-text">
                        <fmt:message key="text.NissanGTR"/>
                    </p>
                </div>
            </div>
        </div>
        <div class="col-lg-4 col-sm-6 portfolio-item">
            <div class="card h-100">
                <a href="#"><img class="card-img-top" src="img/card6.jpg" alt=""></a>
                <div class="card-body">
                    <h4 class="card-title">
                        <a href="#">Lexus LC</a>
                    </h4>
                    <p class="card-text">
                        <fmt:message key="text.LexusLC"/>
                    </p>
                </div>
            </div>
        </div>
    </div>
    <!-- /.row -->

    <!-- Features Section -->
    <div class="row">
        <div class="col-lg-6">
            <h2><fmt:message key="label.premium"/></h2>
            <p>
                <fmt:message key="label.premiumIncludes"/>
            </p>
            <ul>
                <li><fmt:message key="label.fast"/></li>
                <li><fmt:message key="label.best"/></li>
                <li><fmt:message key="label.tech"/></li>
            </ul>
            <p>
                <fmt:message key="text.premium"/>
            </p>
        </div>
        <div class="col-lg-6">
            <img class="img-fluid rounded" src="img/customer-support.jpg" alt="">
        </div>
    </div>
    <!-- /.row -->

    <hr>

    <!-- Call to Action Section -->
    <div class="row mb-4">
        <div class="col-md-8">
            <p>
                <fmt:message key="label.registerNow"/>
            </p>
        </div>
        <div class="col-md-4">
            <a class="btn btn-lg btn-success btn-block" href="registration">
                <fmt:message key="label.createAccaunt"/>
            </a>
        </div>
    </div>

</div>
<!-- /.container -->

<!-- Footer -->
<footer class="py-3 bg-dark">
    <div class="container">
        <p class="m-0 text-center text-white">
            Copyright &copy; Mashina Inc 2019
        </p>
    </div>
    <!-- /.container -->
</footer>

<!-- Bootstrap core JavaScript -->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>
