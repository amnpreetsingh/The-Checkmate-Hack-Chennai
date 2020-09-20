<?php

$conn = mysqli_connect("localhost", "root", "root", "naari");
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
} 

$sql = "SELECT * FROM hab59";
$result = $conn->query($sql);

echo $result->num_rows;

$conn->close();
?>