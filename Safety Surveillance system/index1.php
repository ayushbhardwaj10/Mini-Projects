
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<style>
		h1 {
    color: white;
    text-align: center;
    font-family: Georgia;


    font-size: 55px;
    padding: 14px 100px;
}
a:link, a:visited {
    background-color: brown;
    color: white;
    padding: 14px 25px;
    text-align: center; 
    text-decoration: none;
    display: inline-block;
}

a:hover, a:active {
    background-color: green;
}
	</style>
	
	<meta charset="utf-8">
	<title>Safety Surveillance</title>

	<!-- Google Fonts -->
	<link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700|Lato:400,100,300,700,900' rel='stylesheet' type='text/css'>

	<link rel="stylesheet" href="css/animate.css">
	<!-- Custom Stylesheet -->
	<link rel="stylesheet" href="css/style.css">

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
</head>

<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a style="background-color: grey; color:black" class="navbar-brand" href="#">Welcome</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
      <li><a style="background-color: grey; color:black" href="#">About</a></li>
      <li><a style="background-color: black; color:white"href="#">Legal Framework</a></li>
    </ul>
    <form class="navbar-form navbar-left" action="/action_page.php">
      <div class="input-group">
        <input type="text" class="form-control" placeholder="Search" name="search">
        <div class="input-group-btn">
          <button class="btn btn-default" type="submit">
            <i class="glyphicon glyphicon-search"></i>
          </button>
        </div>
      </div>
    </form>
  </div>
</nav>

	<div class="container">
		<div class="top">
			<h1>SAFETY SURVEILLANCE SYSTEM</h1>
		</div>
		<br/><br/><br/><br/><br/><br/><br/><br/>

		<ul>
  <li><a href="adminlogin.php">Admin Login</a></li>
  <br/><br/><br/><br/><br/><br/>

  <li><a href="employeelogin.php">Surveillance Employees Login</a></li>
    <br/><br/>
    </ul>
	</div>
</body>

<script>
	$(document).ready(function () {
    	$('#logo').addClass('animated fadeInDown');
    	$("input:text:visible:first").focus();
	});
	$('#username').focus(function() {
		$('label[for="username"]').addClass('selected');
	});
	$('#username').blur(function() {
		$('label[for="username"]').removeClass('selected');
	});
	$('#password').focus(function() {
		$('label[for="password"]').addClass('selected');
	});
	$('#password').blur(function() {
		$('label[for="password"]').removeClass('selected');
	});
</script>

</html>