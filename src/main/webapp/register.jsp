<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Registration</title>

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
      <a class="navbar-brand" href="/">Mashina</a>
      <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item">
            <a class="nav-link" href="#">Profile</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Services</a>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownPortfolio" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              Brands
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
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownBlog" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              Offices
            </a>
            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownBlog">
              <a class="dropdown-item" href="#">USA</a>
              <a class="dropdown-item" href="#">Germany</a>
              <a class="dropdown-item" href="#">France</a>
              <a class="dropdown-item" href="#">Canada</a>
              <a class="dropdown-item" href="#">Belarus</a>
              <a class="dropdown-item" href="#">Russia</a>
            </div>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownBlog" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              Investors
            </a>
            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownBlog">
              <a class="dropdown-item" href="#">About</a>
              <a class="dropdown-item" href="#">Information disclosure</a>
              <a class="dropdown-item" href="#">Sponsorship</a>
              <a class="dropdown-item" href="#">Public relations</a>
            </div>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">FAQ</a>
          </li>
        </ul>
      </div>
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
	    <h1 class="pt-5">Registration <small>form</small></h1>
        <h4>Fill in the following fields:</h4>
        <form name="sentMessage" id="contactForm" novalidate>
          <div class="control-group form-group">
            <div class="controls">
              <input type="text" class="form-control" id="name" placeholder="Full name" required data-validation-required-message="Please enter your name.">
			  <p class="help-block"></p>
            </div>
          </div>
          <div class="control-group form-group">
            <div class="controls">
              <input type="text" class="form-control" id="text" placeholder="Passport number" required data-validation-required-message="Please enter your phone number.">
            </div>
          </div>
		  <div class="control-group form-group">
            <div class="controls">
              <input type="text" class="form-control" id="text" placeholder="Driving license number" required data-validation-required-message="Please enter your phone number.">
            </div>
          </div>
		  <div class="control-group form-group">
            <div class="controls">
              <input type="tel" class="form-control" id="phone" placeholder="Phone number" required data-validation-required-message="Please enter your phone number.">
            </div>
          </div>
          <div class="control-group form-group">
            <div class="controls">
              <input type="email" class="form-control" id="email" placeholder="Your@email.com" required data-validation-required-message="Please enter your email address.">
			</div>
          </div>
		  <div class="control-group form-group">
            <div class="controls">
              <input type="text" class="form-control" id="text" placeholder="Login" required data-validation-required-message="Please enter your email address.">
            </div>
          </div>
		  <!-- Password and confirmation -->
		  <div class="control-group form-group">
            <div class="controls">
              <input type="password" class="form-control" required="required" type="password" id="password" placeholder="Password" required data-validation-required-message="Please enter your email address.">
            </div>
          </div>
		  <div class="control-group form-group">
            <div class="controls">
              <input type="password" class="form-control" required="required" type="password" id="confirm_password" placeholder="Confirm password" required data-validation-required-message="Please enter your email address."/>
            </div>
          </div>
          <div id="success"></div>
          <!-- For success/fail messages -->
          <button type="submit" class="btn btn-dark" id="sendMessageButton">Create an account</button>
		  <p class="mt-2 mb-4 message">Already registered? <a href="login">Sign in</a></p>
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

  <!-- Bootstrap core JavaScript -->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Contact form JavaScript -->
  <!-- Do not edit these files! In order to set the email address and subject line for the contact form go to the bin/contact_me.php file. -->
  <script src="js/jqBootstrapValidation.js"></script>
  <script src="js/contact_me.js"></script>

</body>

</html>
