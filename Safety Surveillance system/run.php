<?php
	$servername = "localhost";
	$username = "root";
	$password = "root123"; 
	$db       = "just_deliver";

	$conn = new mysqli($servername, $username, $password,$db);

	if ($conn->connect_error) {
		die("Connection failed: " . $conn->connect_error);
	} 

//Get the query entered by the user in the query box. 

$query = $_POST["queryBox"];
$piece = explode(" ", $query);
echo $piece[0];
$s="select";
if($piece[0]==$s)
{
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
		foreach ($i as &$j) {
			echo"<td>".$j."</td>";
		}
		echo"</tr>";
	}
	echo "</table>";
}
else
{
	echo"connection failure";
}
}
else
{

if ($stmt = $conn->prepare($query)) {


    /* execute statement */
    $stmt->execute();

    echo "rows inserted: ".$stmt->affected_rows;

    /* close statement */
    $stmt->close();
}
}
