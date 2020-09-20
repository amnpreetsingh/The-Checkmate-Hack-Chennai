<?php

if(isset($_POST['submit']))
{
	$number=$_POST['phone'];
	$message=$_POST['message'];
	
	


$fields = array(
    "sender_id" => "Naari",
    "message" => $message,
    "language" => "english",
    "route" => "p",
    "numbers" => $number,
);

$curl = curl_init();

curl_setopt_array($curl, array(
  CURLOPT_URL => "https://www.fast2sms.com/dev/bulk",
  CURLOPT_RETURNTRANSFER => true,
  CURLOPT_ENCODING => "",
  CURLOPT_MAXREDIRS => 10,
  CURLOPT_TIMEOUT => 30,
  CURLOPT_SSL_VERIFYHOST => 0,
  CURLOPT_SSL_VERIFYPEER => 0,
  CURLOPT_HTTP_VERSION => CURL_HTTP_VERSION_1_1,
  CURLOPT_CUSTOMREQUEST => "POST",
  CURLOPT_POSTFIELDS => json_encode($fields),
  CURLOPT_HTTPHEADER => array(
    "authorization: jvlSHRXg53VEQATFM2nCIuwiKN71ys4Oqm0rJzbe6k8PYUaphooU8WH9YZgKAIijdTlPVNS0D7FGMxJ4",
    "accept: */*",
    "cache-control: no-cache",
    "content-type: application/json"
  ),
));

$response = curl_exec($curl);
$err = curl_error($curl);

curl_close($curl);

if ($err) {
  echo "cURL Error #:" . $err;
} else {
  echo $response;
}



 }
 
 ?>