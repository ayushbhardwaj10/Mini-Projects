<?php
	$servername = "localhost";
	$username = "root";
	$password = ""; //default password
	$db       = "miniproject";

	// Create connection. Note taht we are using the OOP style here for PHP. $conn is now an object.
	$conn = new mysqli($servername, $username, $password,$db);
	   $query="select * from sharemessages;";
  	// Check connection
	if ($conn->connect_error) 
{
		die("Connection failed: " . $conn->connect_error);
}
if($conn->multi_query($query))
{
	echo"<table border='1'>";
	$res=$conn->store_result();
	$field=$res->fetch_fields();
	echo"<tr>";
	foreach($field as &$head)
	{
		echo"<th>".$head->name."</th>";
	}
	echo"</tr>";
	while($i=$res->fetch_row())
	{
		echo"<tr>";
		foreach ($i as &$j) 
	{
			echo"<td>".$j."</td>";
	}
		echo"</tr>";
	}
	echo "</table>";
}
else
{
	echo"inccorect query";
}
?> 