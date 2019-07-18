<?php
$q=$_POST['myquery'];
$con=mysqli_connect('localhost','root','');

mysqli_select_db($con,'ayush');
mysqli_query($con,"$q");
mysqli_close($con);
?>