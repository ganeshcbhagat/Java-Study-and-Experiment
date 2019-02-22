<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<title>eDOC</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
	</script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js">
	</script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js">
	</script>
</head>

<body>
<!--page container start -->
	<div class="container-fluid">
	<!--page header start -->
  <header>
  <div class="row">
    <div class="col-md-12">
       <!-- navbar start -->
       <nav class="navbar fixed-top sticky-top navbar-expand-md navbar-dark bg-dark">
        <!-- navbar brand start -->
          <blockquote class="navbar-brand blockquote">
  <p class="mb-0"><a class="navbar-brand" href="/edoc"><span class="fa fa-globe font-weight-light text-success" style="font-size:50px">&nbsp;eDOC</span></a>
  </p>
  <footer class="blockquote-footer text-info">Your document in <cite title="digital world">digital world</cite></footer>
</blockquote><!-- navbar brand end -->
        <!-- navbar right content start -->
        <div class="nav navbar-text navbar-collapse justify-content-end">
          <span aria-label="breadcrumb">
            <ol class="breadcrumb" style="background-color:inherit;">
            <li class="breadcrumb-item"><a href="/edoc/faq">FAQ</a></li>
            <li class="breadcrumb-item"><a href="/edoc/contact-us">Contact Us</a></li>
            <li class="breadcrumb-item active" aria-current="page"><a href="/edoc/about-us">About Us</a></li>
          </ol>
          </span>
        </div> <!-- navbar right content end -->
    </nav> <!-- navbar end -->
    </div>
</div>
</header>  <!--page header end -->

  <article><!--main content start -->
  <div class="row my-5">
      <div class="col-md-3 container">
      <div class="card">
        <div class="card-header bg-dark">
          <span class="card-img-top fa fa-sign-in text-success text-center my-auto" style="font-size:40px">&nbsp;&nbsp;Sign in</span></div>
      <div class="card-body">
        <form action="/#">
          <div class="form-group">
            <label for="loginFormEmail">E-mail</label>
            <input type="email" id="loginFormEmail" class="form-control" placeholder="Enter email" required>
          </div>
          <div class="form-group">
            <label for="loginFormPassword">Password</label>
            <input type="password" id="loginFormPassword" class="form-control" placeholder="Enter password" required>
            <div class="d-flex align-items-center justify-content-between">
              <a href="/edoc/forgot-password">Forgot password?</a>
            </div>
          </div>
          <div class="form-group">
            <button class="btn btn-outline-info btn-block my-3" type="submit">Sign in</button>
            <div class="text-center">
                <p><span>Not a member? <a href="/edoc/register">Register</a></span>
                </p>
            </div>
          </div>
        </form>
      </div>
    </div>
    </div>
  </div>
</article><!--main content end-->

<!--page footer start -->
<footer>
  <div class="row">
      <nav class="navbar fixed-bottom justify-content-center navbar-light bg-light" style="height: 2rem;">
        <div class="navbar-text text-muted">
              <span class="nav-link form-text text-muted" href="#"><small>&copy; Copyright 2018, Cognizant India. All Rights Reserved.</small></span>
      </div>
    </nav>
  </div>
  </footer> <!--page footer end -->
</div> <!--page container end -->
</body>

</html>