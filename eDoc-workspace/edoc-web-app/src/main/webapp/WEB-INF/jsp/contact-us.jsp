
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
		<article>
			<!--main content start -->
			<div class="row">
      <div class="col-md-3 container">
            <div class="card">
                    <div class="card-header bg-dark text-center">
                <span class="card-img-top fa fa-quote-right text-success my-auto" style="font-size:40px">&nbsp;&nbsp;Contact Us</span>
                </div>
                 <div class="card-body">
                    <form action="/#">
                    <div class="form-group">
                      <label for="contactUsFormName">Your Name</label>
                      <input type="text" id="contactUsFormName" class="form-control" placeholder="Enter your name" required>
                    </div>
                    <div class="form-group">
                      <label for="contactUsFormEmail">E-mail</label>
                      <input type="email" id="contactUsFormEmail" class="form-control" placeholder="Enter email" required>
                    </div>
                    <div class="form-group">
                      <label for="contactUsFormContactNumber">Contact Number</label>
                      <input type="number" id="contactUsFormContactNumber" class="form-control" required>
                    </div>
                      <div class="form-group">
                          <label for="contactUsFormMessage">Message</label>
                        <textarea class="form-control rounded-0" id="contactUsFormMessage" rows="3" placeholder="Message"></textarea>
                    </div>

                    <div class="form-group">
                          <div class="custom-control custom-checkbox">
                  <input type="checkbox" class="custom-control-input" id="defaultContactFormCopy">
                  <label class="custom-control-label" for="defaultContactFormCopy">Send me a copy of this message</label>
                 </div>
                      <button class="btn btn-info btn-block my-3" type="submit">Send</button>
                      <p class="form-text text-muted" href="#"><small>Our toll free number 1800-00-000</small></p>
                      
                    </div>
                  </form>
              </div>
          </div>
				</div>
			</div>
		</article>
		<!--main content end-->
	</div>
	<!--page container end -->
</body>

</html>