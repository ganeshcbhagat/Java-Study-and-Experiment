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
  <article><!--main content start -->
  <div class="row my-5">
      <div class="col-md-6 container">
      <div class="card">
        <div class="card-header bg-dark">
          <span class="card-img-top fa fa-globe text-success text-center my-auto" style="font-size:40px">&nbsp;&nbsp;Forgot Password</span></div>
      <div class="card-body">
        <form action="/#">
          <div class="form-group">
            <label for="forgotPasswordFormEmail">E-mail</label>
            <div class="row">
              <div class="col-md-4">
            <input type="email" id="forgotPasswordFormEmail" class="form-control" placeholder="Enter email" required>
              </div>
              <div class="col-md-4">
            <button class="btn btn-info" type="submit">Verify</button>
            </div>
            </div>
            
          </div>
          <div class="form-group">
            <label for="forgotPasswordFormSecretQuestion">Secret Question</label>
            <input type="text" id="forgotPasswordFormSecretQuestion" class="form-control" placeholder="Your secret question will come soon" readonly>
          </div>
          <div class="form-group">
            <label for="forgotPasswordFormSecretAnswer">Secret Answer</label>
            <input type="text" id="forgotPasswordFormSecretAnswer" class="form-control" placeholder="Please enter your secret answer">
          </div>
          <div class="btn-group">
            <div class="btn-group-justified">
            <button class="btn btn-info" type="submit">Submit</button>
            <button class="btn btn-info" type="submit"><a href="/edoc">Cancel</a></button>
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