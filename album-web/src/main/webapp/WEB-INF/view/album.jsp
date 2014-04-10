<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<p>ref album : ${album.id}</p>
<p>nom d'album : ${album.name}</p>
<p>date (de l'instance) : ${album.releaseDate}</p>
<p>format : ${album.type}</p>

<a href="http://localhost:8080/album-web/album/list.html">retour à la liste</a>
</body>
</html>