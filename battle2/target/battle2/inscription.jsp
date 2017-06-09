<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Inscription battle2</title>
</head>
<body>
	<form action="InscriptionServlet" method="post">
		<input type="text" name="NOM" placeHolder="Nom" /> <input type="text"
			name="PRENOM" placeHolder="Prénom" /> <input type="text"
			name="EMAIL" placeHolder="Email" /> <input type="text"
			name="MOT_DE_PASSE" placeHolder="Mot de passe" /> <input
			type="submit" value="Inscription" />
	</form>
</body>
</html>
