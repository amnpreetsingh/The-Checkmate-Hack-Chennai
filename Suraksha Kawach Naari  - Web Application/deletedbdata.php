<?php

$conn = mysqli_connect("localhost", "root", "root", "naari");
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
} 

$sql = "DELETE FROM hab59";
$conn->query($sql);


$conn->close();
?>