<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>RESTful Album Manager</title>
</head>
<body>

<form method="POST" action="http://localhost:8080/album-web/author/insert.html">

	Nom de scène : <input type="text" name="pseudo"/>
	
	Prénom : <input type="text" name="firstname"/>
	Nom : <input type="text" name="lastname"/>
	
	
	<input type="submit" value="enregistrer"/>

</form>


</body>
</html>