<?php
$q = null;
if (!empty($_POST['deletequery'])) {
    $q = $_POST['deletequery'];
}
if(!empty($q))
{
$con=mysqli_connect('localhost','root','');
if ($con->connect_error) {
    die("Connection failed: " . $conn->connect_error);
           }

mysqli_select_db($con,'ayush');

mysqli_query($con,"$q");
mysqli_close($con);
}
?>
<html>
<head>Deletion Of data..!!
</head>
<body>
	<form method="post">
	<input type="text" placeholder="Enter a query" name="deletequery" />
	<input type="submit" class="button2" value="INSERT">
    </form>
</body>
</html>