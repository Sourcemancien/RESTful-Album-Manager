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

La récupération des auteurs s'est à peu près déroulée comme voulu, mais on en sait pas trop, peut être, peut être pas.
Voici la liste des auteurs connus :


<ul>
<c:forEach items="${authors}" var="author">
	<li>
		<a href="http://localhost:8080/album-web/author/details?id=${author.id}"> ${author.pseudo}</a>
		, a.k.a ${author.firstname} ${author.lastname}
	</li>
</c:forEach>
</ul>


</body>
</html>