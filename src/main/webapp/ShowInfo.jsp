<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import = "com.bean.Player"%>
<%@page import = "java.util.HashMap"%>
<%@page import = "java.util.Map" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://unpkg.com/bulmaswatch/darkly/bulmaswatch.min.css">
<title>Profile Info</title>
</head>
<body>

	<h1>Success</h1>
	<h2><c:out value="${player.getName()}"></c:out></h2>
	<h2><c:out value="${player.getId()}"></c:out></h2>

	
</body>
</html>