<?php
$q = null;
if (!empty($_POST['myquery'])) {
    $q = $_POST['myquery'];
}
if(!empty($q))
{
$con=mysqli_connect('localhost','root','');
if ($con->connect_error) {
    die("Connection failed: " . $conn->connect_error);
           }

mysqli_select_db($con,'miniproject');

mysqli_query($con,"$q");
mysqli_close($con);
}
?>

<!DOCTYPE html>
<html>
<head>
<style> 
input[type=text] {
   width: 1000px;
    height: 100px;
    padding: 12px 20px;
    box-sizing: border-box;
    border: 2px solid #ccc;
    border-radius: 4px;
    background-color: #f8f8f8;
    font-size: 16px;
    resize: none;
}
input[type="submit"]
{
    background-color: #4CAF50;
    border: none;
    color: white;
    padding: 16px 32px;
    text-decoration: none;
    margin: 4px 2px;
    cursor: pointer;
}
.button2:hover {
    box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24),0 17px 50px 0 rgba(0,0,0,0.19);
   }
 h1 {
    color: white;
    text-align: center;
    font-family: verdana;
    font-size: 300%;
    padding: 14px 25px;
}
a:link, a:visited {
    background-color: #f44336;
    color: white;
    padding: 14px 25px;
    text-align: center; 
    text-decoration: none;
    display: inline-block;
}

a:hover, a:active {
    background-color: red;
}
 body
 { background-image:url(img2.jpg);
 	background-size: cover;
 	background-attachment: fixed;

 }
</style>
</head>
<body>
	
	<br/><br/><br/>
	<form method="post">
	<input type="text" placeholder="Enter a query" name="myquery" />
    <br/>
    <br/>
	<input type="submit" class="button2" value="EXECUTE">
    </form>
    <br/><br/><br/><br/>
    
    <ul>
  <li><a href="select.php">Select Data</a></li>
  <br/><br/>
  <li><a href="insert.php">Insert Data</a></li>
    <br/><br/>
  <li><a href="update2.php">Update Data</a></li>
    <br/><br/>
  <li><a href="delete.php">Delete Data</a></li>
  <br/><br/>
    <br/><br/>
    <br/><br/>

    <form action="logout.php" method="post">
	
	<input style=" background-color:grey;  color: black" type="submit" class="button3" value="LOGOUT">
    </form> 
    </ul>


</body>
</html>