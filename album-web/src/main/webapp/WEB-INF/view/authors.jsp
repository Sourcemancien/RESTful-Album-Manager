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

La r�cup�ration des auteurs s'est � peu pr�s d�roul�e comme voulu, mais on en sait pas trop, peut �tre, peut �tre pas.
Voici la liste des auteurs connus :

${authors.toString}


<c:forEach items="${authors}" var="author">
	
	<p>artiste : ${author.pseudo}</p>
	
</c:forEach>

</body>
</html>