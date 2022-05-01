<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://unpkg.com/bulmaswatch/darkly/bulmaswatch.min.css">
<title>Steam Dump</title>
</head>
<body>
<section id="main" class="section">
<div class="container">
	<div class="columns is-mobile is-centered">
		<div class="column is-half has-text-left is-size-4">
		<form action="login" method="post">
			<Label>Enter Steam Name or ID: </Label>
			<input type="text" id="STEAM_NAME_ID" name="STEAM_NAME_ID">
			<br>
			<input type="radio" id="STEAM_NAME" name="search-option" value="STEAM_NAME" checked="checked">
			<label for="STEAM_NAME">Steam Name</label>
			<br>
			<input type="radio" id="STEAM_ID" name="search-option" value="STEAM_ID">
			<label for="STEAM_ID">Steam ID</label>
			<br>
			<input type="submit" value="Submit">
			<br>
		<%String error = (String)request.getSession().getAttribute("error"); %>
		<%if(error!=null){
			out.println("<label>"+ error +"</label>");
		}
		%>
		</form>
		</div>
	</div>
</div>
</section>
</body>
</html>