	<?php 
	$username="etravi_php";
	$password="tkX5s474TmW3Ccck";//password
	$servername="localhost";
	$database="etravi_php";

	//Create connection
	$conn = new mysqli ($servername, $username, $password, $database);

	//Check connection
	if ($conn->connect_error){
		die("Connection failed: " . $conn->connect_error);
	}

    $veiksmas = $_POST['veiksmas'];

	if (!strcmp("ieskoti", $veiksmas)) {

		$search = $_POST['searchQuery'];
		
		$sql = "SELECT * FROM pica WHERE pavadinimas LIKE '%$search%'";

		$res = $conn->query($sql);
		
		$result = array();
			while($row = $res->fetch_assoc()) {
				$result[] = $row;
			}
			echo json_encode($result);

		if($res === TRUE){
			// grąžinsime duomenis json formatu
		}else{
			echo "no rows";
		}
	}

    if (!strcmp("kurti", $veiksmas)) {
        $pavadinimas = $_POST['pavadinimas'];
        $dydis = $_POST['dydis'];
        $mesa = $_POST['mesa'];
        $padazas = $_POST['padazas'];
        $kaina = $_POST['kaina'];

        $sql = "INSERT INTO pica (pavadinimas, dydis, gerimas, padazas, kaina) VALUES ('$pavadinimas', '$dydis', '$mesa', '$padazas', '$kaina')";
        if($conn->query($sql) === TRUE){
            echo "Naujas irasas sukurtas sekmingai";
        }else{
            echo "Naujo iraso kurimo klaida: " . $sql . "<br>" . $conn ->error;
        }
    }
	if (!strcmp("registruoti", $veiksmas)) {

  $vardas = $_POST['vardas'];
        $elpastas = $_POST['elpastas'];
        $slaptazodis = $_POST['slaptazodis'];

        $sql = "INSERT INTO nariai (vardas, elpastas, slaptazodis) VALUES ('$vardas ', '$elpastas ', '$slaptazodis ')";
        if($conn->query($sql) === TRUE){
            echo "Naujas irasas sukurtas sekmingai";
        }else{
            echo "Naujo iraso kurimo klaida: " . $sql . "<br>" . $conn ->error;
        }

	}


	$conn->close();
?> 