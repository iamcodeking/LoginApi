<?php
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "location";
$name=$_POST['username'];
$phone=$_POST['phone'];
$password=$_POST['password'];
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
	echo "error";
    die("Connection failed: " . $conn->connect_error);
}
$sql_u = "SELECT * FROM data WHERE name='$name'";
  	
  	$res_u = $conn->query($sql_u);
  	

  	if ($res_u->num_rows > 0) {
  	  $name_error = "Sorry... username already taken"; 	
  		echo "$name_error";
  	}else{
           $query = "INSERT INTO data 
      	    	  VALUES ('$name','$password','$phone',123,123,'none')";
      	    	  
           $results = $conn->query($query);
           echo "saved";
    }       
?>