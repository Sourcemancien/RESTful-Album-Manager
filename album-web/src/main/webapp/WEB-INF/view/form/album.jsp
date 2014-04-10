<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

Ajout d'album

<form method="post" action="http://localhost:8080/album-web/album/insert.html">
	nom : <input type="text" name="name"/>
	nombre de disques : <input type="text" name="cdNumber"/>

	type :	<select name="type">
				<option value="ALBUM">Album</option>
				<option value="BESTOF">BestOf</option>
				<option value="COLLECTION">Collection</option>
				<option value="SINGLE">Single</option>
			</select>
			
	<input type="submit" value="enregistrer"/>
</form>


</body>
</html>