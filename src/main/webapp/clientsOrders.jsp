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
    <div class="row">
        <div class="col-lg-1"></div>
        <div class="col-lg-10 mb-4">
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
                <c:forEach items="${presentOffers}" var="offer">
                    <form action="/clients/1/order" method="get">
                        <input id="id_anything123" type="hidden" name="val" value="${offer.id}"/>
                        <tr>
                            <td><c:out value="${offer.beginDay}"/></td>
                            <td><c:out value="${offer.period}"/></td>
                            <td><c:out value="${offer.car.getModel()}"/></td>
                            <td><c:out value="${offer.payment}"/></td>
                            <td><c:out value="${offer.status}"/></td>
                            <td>
                                <button type="submit" class="btn btn-info btn-sm" id="sendMessageButton" name="orderDet"
                                        value="${offer.id}"><fmt:message key="label.edit"/>
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
            <p><fmt:message key="label.checkPast"/></p>
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

                <c:forEach items="${pastOffers}" var="offer">
                    <form action="/clients/1/order" method="get">

                        <tr>
                            <td><c:out value="${offer.beginDay}"/></td>
                            <td><c:out value="${offer.period}"/></td>
                            <td><c:out value="${offer.car.getModel()}"/></td>
                            <td><c:out value="${offer.payment}"/></td>
                            <td><c:out value="${offer.status}"/></td>
                        </tr>
                    </form>
                </c:forEach>

                </tbody>
            </table>

            <!-- Show and pay fines -->
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
                            <c:if test="${!ticket.isPaid}">
                                <form class="registration-form" name="registration-form" method="post">
                                    <input type="hidden" name="currentTicketId" value="${ticket.id}"/>
                                    <button type="submit" class="btn btn-info btn-sm">
                                        <fmt:message key="label.pay"/>
                                    </button>
                                </form>
                            </c:if>
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
