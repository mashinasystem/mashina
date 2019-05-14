<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="ftm" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

    <title><fmt:message key="label.customers"/></title>

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

<!-- Page Content -->
<div class="container">
    <div class="row">
        <div class="col-lg-12 mb-4">
            <!-- Page Heading/Breadcrumbs -->
            <h1 class="py-4"></h1>
            <h1 class="mt-4 mb-3"><fmt:message key="label.current"/>
                <small><fmt:message key="label._customers"/></small>
            </h1>
            <p><fmt:message key="label.checkCurrentCustomers"/></p>
            <table class="table table-hover">
                <thead>
                <tr>
                    <th><fmt:message key="label.id"/></th>
                    <th><fmt:message key="label.name"/></th>
                    <th><fmt:message key="label.phoneNumber"/></th>
                    <th><fmt:message key="label.passport"/></th>
                    <th><fmt:message key="label.lisence"/></th>
                </tr>
                </thead>
                <c:forEach items="${clients}" var="client">
                    <form action="/clients/1/order" method="get">
                        <tr>
                            <td><c:out value="${client.id}"/></td>
                            <td><c:out value="${client.fullName}"/></td>
                            <td><c:out value="${client.phoneNumber}"/></td>
                            <td><c:out value="${client.passport}"/></td>
                            <td><c:out value="${client.driverCard}"/></td>
                        </tr>
                    </form>
                </c:forEach>
            </table>

            <!-- Show and create fines -->
            <h1 class="mt-4 mb-3"><fmt:message key="label.allThe"/>
                <small><fmt:message key="label.fines"/></small>
            </h1>
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>№</th>
                    <th><fmt:message key="label.cost"/></th>
                    <th><fmt:message key="label.name"/></th>
                    <th><fmt:message key="label.status"/></th>
                </tr>
                </thead>
                <c:set var="ticketId" value="0" scope="session"/>
                <c:forEach items="${tickets}" var="ticket" varStatus="t">
                    <tr>
                        <td><c:out value="${ticket.id}"/></td>
                        <td><c:out value="${ticket.cost}"/> $</td>
                        <td><c:out value="${names.get(t.index)}"/></td>
                        <td>
                            <c:if test="${ticket.isPaid}">
                                <fmt:message key="label.paid"/>
                            </c:if>
                            <c:if test="${!ticket.isPaid}">
                                <fmt:message key="label.notPaid"/>
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
            </table>

            <h1 class="mt-4 mb-3"><fmt:message key="label.create"/>
                <small><ftm:message key="label.new"/> <fmt:message key="label.fines"/></small>
            </h1>
            <h4><fmt:message key="label.fillTheFields"/></h4>
            <form class="registration-form" name="registration-form" method="post">
                <div class="control-group form-group">
                    <div class="controls">
                        <input type="text" class="form-control" id="name" placeholder="Driver ID" name="driverId"
                               required data-validation-required-message="Enter the driver ID">
                        <p class="help-block"></p>
                    </div>
                </div>
                <div class="control-group form-group">
                    <div class="controls">
                        <input type="text" class="form-control" id="text" placeholder="Ticket cost" name="ticketCost"
                               required data-validation-required-message="Enter the fine cost">
                    </div>
                </div>
                <div id="success"></div>
                <!-- For success/fail messages -->
                <button type="submit" class="btn btn-dark"><fmt:message key="label.create"/></button>
            </form>

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
