<!DOCTYPE html>
<html lang="en">
<head>
    <title>Registration</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/example.css">
    <script src="js/bootstrap.min.js"></script>
    <script src="js/passanim.js"></script>

</head>

<body>

<div class="login-page">
    <div class="form">
        <form class="register-form">
            <input type="text" placeholder="full name"/>
            <input type="text" placeholder="passport data"/>
            <input type="text" placeholder="phone number"/>
            <input type="text" placeholder="drive card number"/>
            <input type="text" placeholder="login"/>
            <input type="password" id="paslog" placeholder="password"/>
            <div class="container">
                <div class="left">
                    <input type="checkbox" class="checkbox" id="check1" onclick="passanim()" />
                </div>
                <div class="right">
                    <label for="check1">show password</label>
                </div>
            </div>
            <button>create</button>
            <p class="message">Already registered? <a href="login">Sign In</a></p>
        </form>
    </div>
</div>

</body>

</html>