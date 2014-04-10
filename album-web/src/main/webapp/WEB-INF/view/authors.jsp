<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>RESTful Album Manager</title>
</head>
<body>

Liste des auteurs :


<ul>
<c:forEach items="${authors}" var="author">
	<li>
		<a href="http://localhost:8080/album-web/author/details?id=${author.id}"> ${author.pseudo}</a>, a.k.a 
		<em>${author.firstname} ${author.lastname}</em>
	</li>
</c:forEach>
</ul>

<a href="http://localhost:8080/album-web/author/new.html">ajouter un artite</a> | 
<a href="http://localhost:8080/album-web/album/list.html">voir liste des albums</a>
</body>
</html>