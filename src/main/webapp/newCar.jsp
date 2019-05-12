<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<html lang="en">
<head>
    <title>Registration</title>

</head>

<body>

<div class="login-page">
    <div class="form">
        <form action = "/admin/1/newcar" method = "post">
            <input type="text" placeholder="model" name = "model"/>
            <input type="text" placeholder="number" name = "number"/>
            <input type="text" placeholder="marque" name  = "marque"/>
            <div class="container">
            </div>
            <button type="submit" value="newcar">Create</button>
        </form>
    </div>
</div>

</body>

</html>