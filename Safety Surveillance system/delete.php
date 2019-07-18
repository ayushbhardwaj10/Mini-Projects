<html>
<head>
	<style> 
input[type=text] {
   width: 700px;
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
   body
 { background-image:url(img1.jpg);
 	background-size: cover;
 	background-attachment: fixed;

 }
</style>
</head>
<body>
	<form method="post">
	<input type="text" placeholder="Enter a query" name="deletequery" />
	<input type="submit" class="button2" value="DELETE">
    </form>
<?php
$q = null;
if (!empty($_POST['deletequery'])) {
    $q = $_POST['deletequery'];
}
if(!empty($q))
{
$con=mysqli_connect('localhost','root','','miniproject');
if ($con->connect_error) {
    die("Connection failed: " . $conn->connect_error);
           }

if ($stmt = $con->prepare($q)) {


    /* execute statement */
    $stmt->execute();

   echo "<input type='text' value='1 Row deleted succesfully' />";

    /* close statement */
    $stmt->close();
}
else
{
     echo "<input type='text' value='Wrong query' />";
}
mysqli_close($con);
}
?>
</body>
</html>
