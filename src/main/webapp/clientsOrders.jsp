<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${param.lang}"/>
<fmt:setBundle basename="messages"/>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title><fmt:message key="label.orders"/></title>

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

        <% if (session.getAttribute("role") != null) { %>
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
        <% if (session.getAttribute("role") == null) { %>
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
    <div class="row">
        <div class="col-lg-2"></div>
        <div class="col-lg-8 mb-4">
            <!-- Page Heading/Breadcrumbs -->
            <h1 class="py-4"></h1>
            <h1 class="mt-4 mb-3"><fmt:message key="label.current"/>
                <small><fmt:message key="label._orders"/></small>
            </h1>
            <p><fmt:message key="label.checkCurrentOrders"/></p>
            <table class="table table-hover">
                <thead>
                <tr>
                    <th><fmt:message key="label.startDate"/></th>
                    <th><fmt:message key="label.period"/></th>
                    <th><fmt:message key="label.carModel"/></th>
                    <th><fmt:message key="label.payment"/></th>
                    <th><fmt:message key="label.status"/></th>
                    <th><fmt:message key="label.details"/></th>
                </tr>
                </thead>
                <tbody>
                <c:set var="offerId" value="0" scope="session"/>
                <c:forEach items="${offers}" var="offer">
                    <form action="/clients/1/order" method="get">
                        <input id="id_anything123" type="hidden" name="val" value="${offerId}"/>
                        <tr>
                            <td><c:out value="${offer.beginDay}"/></td>
                            <td><c:out value="${offer.period}"/></td>
                            <td><c:out value="${offer.car.getModel()}"/></td>
                            <td><c:out value="${offer.payment}"/></td>
                            <td><c:out value="${offer.status}"/></td>
                            <td>
                                <button type="submit" class="btn btn-info btn-sm" id="sendMessageButton" name="orderDet"
                                        value="${offerId}"><fmt:message key="label.details"/>
                                </button>
                            </td>
                        </tr>
                        <c:set var="offerId" value="${offerId + 1}" scope="session"/>
                    </form>
                </c:forEach>
                </tbody>
            </table>

            <a href="/neworder" class="btn btn-success btn-lg btn-block">
                <fmt:message key="label.newOrder"/>
            </a>
            <h1 class="mt-4 mb-3"><fmt:message key="label.past"/>
                <small><fmt:message key="label._orders"/></small>
            </h1>
            <p>Here you can check your past orders:</p>
            <table class="table table-hover">
                <thead>
                <tr>
                    <th><fmt:message key="label.startDate"/></th>
                    <th><fmt:message key="label.period"/></th>
                    <th><fmt:message key="label.carModel"/></th>
                    <th><fmt:message key="label.payment"/></th>
                    <th><fmt:message key="label.status"/></th>
                    <th><fmt:message key="label.details"/></th>
                </tr>
                </thead>
                <tbody>

                <tr>
                    <td>21.05.19</td>
                    <td>23.05.19</td>
                    <td>Tesla Model X</td>
                    <td>Confirmed</td>
                    <td>Finished</td>
                    <td>
                        <a href="/clients/1/orders/1" class="btn btn-info btn-sm">details</a>
                    </td>
                </tr>
                <tr>
                    <td>21.05.19</td>
                    <td>23.05.19</td>
                    <td>Tesla Model X</td>
                    <td>No payment</td>
                    <td>Declined</td>
                    <td>
                        <a href="/clients/1/orders/1" class="btn btn-info btn-sm">details</a>
                    </td>
                </tr>

                </tbody>
            </table>

            <h1 class="mt-4 mb-3"><fmt:message key="label.your"/>
                <small><fmt:message key="label.fines"/></small>
            </h1>
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>№</th>
                    <th><fmt:message key="label.cost"/></th>
                    <th><fmt:message key="label.status"/></th>
                    <th></th>
                </tr>
                </thead>
                <c:set var="ticketId" value="0" scope="session"/>
                <c:forEach items="${tickets}" var="ticket">
                    <tr>
                        <td><c:out value="${ticket.id}"/></td>
                        <td><c:out value="${ticket.cost}"/> $</td>
                        <td>
                            <c:if test="${ticket.isPaid}">
                                <fmt:message key="label.paid"/>
                            </c:if>
                            <c:if test="${!ticket.isPaid}">
                                <fmt:message key="label.notPaid"/>
                            </c:if>
                        </td>
                        <td>
                            <button type="submit" class="btn btn-info btn-sm">
                                <fmt:message key="label.pay"/>
                            </button>
                        </td>

                    </tr>
                </c:forEach>
            </table>

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

</body>

</html>
