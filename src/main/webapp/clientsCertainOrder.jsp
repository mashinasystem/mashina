<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Certain order</title>

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
      <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item active">
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
  <div class="row">
	<div class="col-lg-2"></div>
    <div class="col-lg-8 mb-4">
    <!-- Page Heading/Breadcrumbs -->
      <h1 class="py-4"></h1>
      <h1 class="mt-4 mb-3">Certain
        <small>order</small>
      </h1>
      <p>Here you can find information about order:</p>
      <table class="table table-hover">
        <thead>
          <tr>
            <th>Start date</th>
            <th>End date</th>
            <th>Car model</th>
            <th>Payment</th>
			<th>Status</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>21.05.19</td>
            <td>23.05.19</td>
            <td>Tesla Model X</td>
			<td>Confirmed</td>
			<td>Approved</td>
          </tr>
        </tbody>
      </table>
      <h1 class="mt-2 mb-3">Fines</h1>
	  <h4>20$ <span class="badge badge-success">paid</span></h4>
	  <h4>50$ <span class="badge badge-danger">not paid</span></h4>
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
