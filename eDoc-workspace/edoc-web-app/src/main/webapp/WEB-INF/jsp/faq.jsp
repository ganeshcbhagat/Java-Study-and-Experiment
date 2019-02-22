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
				<div class="col-md-8 container">
          <div class="card my-3">

            <div class="card-header bg-dark text-center">
              <span class="card-img-top fa fa-quote-right text-success my-auto" style="font-size:40px">&nbsp;&nbsp;Frequently Asked Question</span>
            </div>
            
            <div class="card-body">
					<!--Accordion wrapper-->
					<div class="accordion" id="accordionFaq" aria-multiselectable="true">
						
						<!-- Accordion card start-->
						<div class="card">
							<div class="card-header" id="question1">
								<h5 class="mb-0">
									<button class="btn btn-link" data-toggle="collapse" data-target="#collapseQuestion1" aria-expanded="true" aria-controls="collapseQuestion1">
          What is eDOC ?
        </button>
      </h5>
    </div>
    <div id="collapseQuestion1" class="collapse" aria-labelledby="question1" data-parent="#accordionFaq">
      <div class="card-body">
      <p>eDOC is a online document management system.</p>
      </div>
    </div>
  </div> <!-- Accordion card end-->

<!-- Accordion card start-->
  <div class="card">
    <div class="card-header" id="question2">
      <h5 class="mb-0">
        <button class="btn btn-link" data-toggle="collapse" data-target="#collapseQuestion2" aria-expanded="false" aria-controls="collapseQuestion2">How to upload my document in eDoc?
        </button>
      </h5>
    </div>
    <div id="collapseQuestion2" class="collapse show" aria-labelledby="question2" data-parent="#accordionFaq">
      <div class="card-body">
        <p>See the document upload section. Press the upload button, after that you need to browse the file to upload. then press the submit button.</p>
      </div>
    </div>
  </div> <!-- Accordion card end-->
 
 <!-- Accordion card start-->
  <div class="card">
    <div class="card-header" id="question3">
      <h5 class="mb-0">
        <button class="btn btn-link" data-toggle="collapse" data-target="#collapseQuestion3" aria-expanded="false" aria-controls="collapseQuestion3">How to download my document in eDoc?
        </button>
      </h5>
    </div>
    <div id="collapseQuestion3" class="collapse" aria-labelledby="question3" data-parent="#accordionFaq">
      <div class="card-body">
        <p>See the uploaded document view select the document and click download button.</p>
      </div>
    </div>
  </div> <!-- Accordion card end-->
  
</div>
<!--/.Accordion wrapper-->
</div>
</div>
</div>
  </div>
</article><!--main content end-->
</div> <!--page container end -->
</body>

</html>