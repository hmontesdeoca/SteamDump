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
<title>Steam Dump</title>
</head>
<body>	
<section id="information" class="section">
<div class="container is-centered">
	<h1 class="is-size-1">Profile Info</h1>
	<div class="columns is-mobile is-centered">
		<div class="column is-half has-text-left is-size-4">
			<div class="box">
				<label>Name: <c:out value="${player.getName()}"></c:out></label>
				<br>
				<label>Steam ID:<c:out value="${player.getId()}"></c:out></label>
			</div>
		</div>
	</div>
</div>
</section>
<section id="games"class="section">
	<div class="container is-centered">
	<h1 class="is-size-1">Recently Played Games</h1>
		<div class="columns is-mobile is-centered">
			<div class="column is-half has-text-left is-size-4">
				<div class="box">
				<c:forEach var="game" items="${player.getGames()}">
					${game.key}  -  ${game.value.getHours()} Hours
					<br>
				</c:forEach>
				</div>
			</div>
		</div>
	</div>
</section>

	
</body>
</html>