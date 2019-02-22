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
      <div class="col-md-4 container">
      <div class="card">
        <div class="card-header bg-dark">
          <span class="card-img-top fa fa-sign-in text-success text-center my-auto" style="font-size:40px">&nbsp;&nbsp;Registration</span></div>
      <div class="card-body">
        <form action="/#">
        <div class="form-row mb-2">
          <div class="col-md-4">
            <label for="registrationFormFirstName">First Name</label>
            <input type="text" id="registrationFormFirstName" class="form-control" placeholder="Enter First Name" required>
          </div>
          <div class="col-md-4">
            <label for="registrationFormLastName">Last Name</label>
            <input type="text" id="registrationFormLastName" class="form-control" placeholder="Enter Last Name" required>
          </div>
        </div>
        <div class="form-row mb-2">
          <div class="col-md-8">
            <label for="registrationFormEmail">E-mail</label>
            <input type="email" id="registrationFormEmail" class="form-control" placeholder="Enter email" required>
          </div>
          </div>
          <div class="form-row mb-2">
          <div class="col-md-8">
            <label for="registrationFormCountry">Country</label>
            <input type="text" id="registrationFormCountry" class="form-control" placeholder="Enter country Name" required>
          </div>
          </div>
          <div class="form-row mb-2">
          <div class="col-md-8">
            <label for="registrationFormPassword">Password</label>
            <input type="password" id="registrationFormPassword" class="form-control" placeholder="Enter password" required>
          </div>
          </div>
          <div class="form-row mb-2">
          <div class="col-md-8">
            <label for="registrationFormConfirmedPassword">Password Confirmed</label>
            <input type="password" id="registrationFormConfirmedPassword" class="form-control" placeholder="Enter confirmed password" required>
          </div>
          </div>
      <div class="form-group">
            <label for="forgotPasswordFormSecretQuestion">Secret Question</label>
            <select id="forgotPasswordFormSecretAnswer" class="custom-select-md form-control" required>
    <option selected>Select your secret question</option>
    <option value="What Is your favorite book?">What Is your favorite book?</option>
    <option value="What is the name of the road you grew up on?">What is the name of the road you grew up on?</option>
    <option value="What is your mother’s maiden name?">What is your mother’s maiden name?</option>
    <option value="What was the name of your first/current/favorite pet?">What was the name of your first/current/favorite pet?</option>
    <option value="What was the first company that you worked for?">What was the first company that you worked for?</option>
    <option value="Where did you meet your spouse?">Where did you meet your spouse?</option>
    <option value="Where did you go to high school/college?">Where did you go to high school/college?</option>
    <option value="What is your favorite food?">What is your favorite food?</option>
    <option value="What city were you born in?">What city were you born in?</option>
    <option value="Where is your favorite place to vacation?">Where is your favorite place to vacation?</option>
  </select>

          </div>
          <div class="form-group">
            <label for="forgotPasswordFormSecretAnswer">Secret Answer</label>
            <input type="text"  class="form-control" placeholder="Please enter your secret answer" required>
          </div>
          <div class="btn-group">
            <div class="btn-group-justified">
            <button class="btn btn-info" type="reset">Reset</button>
            <button class="btn btn-info" type="submit">Submit</button>
            <button class="btn btn-info" type="submit">Cancel</button>
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