<?php
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "location";
$username=$_POST['username'];
$pass1=$_POST['password'];
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}
$sql="Select password from data where name='$username'";
$ans=$conn->query($sql);
$row=$ans->fetch_assoc();
$pass=$row['password'];
//echo "$pass1";
if($pass1==$pass)
{
	echo "yes";
}
else 
{
	echo "nope";
}
?>