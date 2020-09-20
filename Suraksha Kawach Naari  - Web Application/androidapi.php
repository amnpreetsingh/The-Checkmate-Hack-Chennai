<?php
 
$conn = mysqli_connect("localhost", "root", "root", "naari");
 
 $name = $_POST['name'];
 $image = $_POST['image'];
 $location = $_POST['location'];
 $contact = $_POST['contact'];
 $contactem1 = $_POST['contact1'];
 $contactem2 = $_POST['contact2'];
  $contactngo1 = $_POST['contactngo1'];
 $contactngo2 = $_POST['contactngo2'];
 $contactngo3 = $_POST['contactngo3'];
 $email = $_POST['email'];



 $Sql_Query = "insert into hab59 (name,image,location,contact,contactem1,contactem2,contactngo1,contactngo2,contactngo3,email) values ('$name','$image','$location','$contact','$contactem1','$contactem2','$contactngo1','$contactngo2','$contactngo3','$email')";
 
 if(mysqli_query($conn,$Sql_Query)){
 
 echo 'Data Submit Successfully';
 
 }
 else{
 
 echo 'Try Again';
 
 }
 mysqli_close($conn);
?>