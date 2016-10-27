<?php
 	
 	$hostname = "mysql.hostinger.com.br";
 	$username = "u967868433_app";
 	$password = "123456";
 	$db_employee = "u967868433_app";

	//open connection to mysql db
    $connection = mysqli_connect($hostname,$username,$password,$db_employee) or die("Error " . mysqli_error($connection));

    //fetch table rows from mysql db
    $sql = "select * from Carona";
    $result = mysqli_query($connection, $sql) or die("Error in Selecting " . mysqli_error($connection));

    //create an array
    $emparray = array();
    while($row =mysqli_fetch_assoc($result))
    {
        $emparray[] = $row;
    }

    echo json_encode($emparray);

    //close the db connection
    mysqli_close($connection);

 
?>