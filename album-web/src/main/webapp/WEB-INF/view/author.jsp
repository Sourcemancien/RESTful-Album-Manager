<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>RESTful Album Manager</title>
</head>
<body>



<p>ref : ${author.id}</p>
<p>pr�nom : ${author.firstname}</p>
<p>nom : ${author.lastname}</p>
<p>nom d'artiste : ${author.pseudo}</p>

<a href="http://localhost:8080/album-web/author/list.html">retour � la liste</a>
</body>
</html>