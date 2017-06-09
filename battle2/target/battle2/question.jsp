<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Question</title>
</head>
<body>
	<form action="QuestionServlet" method="post">
		ENGLISH BATTLE Joueur: ${joueur.prenom } !, meilleur score ${score }, verbes
		<a href="index.jsp">déconnexion</a>
		<h1>Question : le verbe ${question.verbe.baseVerbale}</h1>
		<br> Base verbale : ${question.verbe.baseVerbale}<br> <input
			type="text" name="PRETERIT" placeHolder="Prétérit" /> <input
			type="text" name="PARTICIPE_PASSE" placeHolder="Participe passé" />
		<input type="submit" value="Valider" />
	</form>
</body>
</html>