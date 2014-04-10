<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

Liste des albums :


<ul>
<c:forEach items="${albums}" var="album">
	<li> 
		<a href="http://localhost:8080/album-web/album/details?id=${album.id}">
			${album.name}
		</a> 
	</li>
</c:forEach>
</ul>

<a href="http://localhost:8080/album-web/album/new.html">ajouter un album</a> | 
<a href="http://localhost:8080/album-web/author/list.html">voir liste des auteurs</a>
</body>
</html>