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

    <title>Orders</title>

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
                        Orders
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/clients/1/info">
                        Info
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
                        Orders
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/admin/1/customers">
                        Customers
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/admin/1/info">
                        Info
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

        <% if (session.getAttribute("role") == null)  { %>
            <a class="btn btn-success btn-sm" href="/login">
                <fmt:message key="label.signIn"/>
            </a>
        <% } else { %>
            <a class="btn btn-danger btn-sm" href="/logout" method="get">Logout</a>
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
            <h1 class="mt-4 mb-3">Current
                <small>orders</small>
            </h1>
            <p>Here you can check your current orders:</p>
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>Start date</th>
                    <th>End date</th>
                    <th>Car model</th>
                    <th>Payment</th>
                    <th>Status</th>
                    <th>Details</th>
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
                                        value="${offerId}">edit
                                </button>
                            </td>
                        </tr>
                        <c:set var="offerId" value="${offerId + 1}" scope="session"/>
                    </form>
                </c:forEach>
                </tbody>
            </table>

            <a href="/neworder" class="btn btn-success btn-lg btn-block">
                New order
            </a>
            <h1 class="mt-4 mb-3">Past
                <small>orders</small>
            </h1>
            <p>Here you can check your past orders:</p>
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>Start date</th>
                    <th>End date</th>
                    <th>Car model</th>
                    <th>Payment</th>
                    <th>Status</th>
                    <th>Details</th>
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
                        <a href="/clients/1/orders/1" class="btn btn-info btn-sm">edit</a>
                    </td>
                </tr>
                </tbody>
            </table>

            <h1 class="mt-4 mb-3">Your
                <small>fines</small>
            </h1>
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>№</th>
                    <th>Cost</th>
                    <th>Status</th>
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
                                paid
                            </c:if>
                            <c:if test="${!ticket.isPaid}">
                                not paid
                            </c:if>
                        </td>
                        <td>
                            <button type="submit" class="btn btn-info btn-sm">
                                pay
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
