<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
	<%@include file="/styles/w3.css"%>
</style>

<%--
  Created by IntelliJ IDEA.
  User: Artyom
  Date: 23.08.2019
  Time: 1:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
	<title>Add user</title>
</head>
<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-right-align">
	<h1>Java Mentor</h1>
</div>

<div class="w3-container w3-padding">

	<div class="w3-card-4">
		<div class="w3-container w3-center w3-green">
			<h2>Add user</h2>
		</div>
		<form method="post" class="w3-selection w3-light-grey w3-padding">
			<label>Name:
				<input type="text" name="name" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%" required><br />
			</label>
			<label>Login:
				<input type="text" name="login" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%" required><br />
			</label>
			<label>Password:
				<input type="password" name="password" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%" required><br />
			</label>
			<p>Role:<Br>
				<input type="radio" name="role" value="user" checked> user<Br>
				<input type="radio" name="role" value="admin"> admin
			</p>
			<button type="submit" class="w3-btn w3-green w3-round-large w3-margin-bottom">Submit</button>
		</form>
		<c:choose>
			<c:when test="${message eq 'success'}">
				<div class="w3-panel w3-green w3-display-container w3-card-4 w3-round">
					<span onclick="this.parentElement.style.display='none'"class="w3-button w3-margin-right w3-display-right w3-round-large w3-hover-red w3-border w3-border-red w3-hover-border-grey">×</span>
					<h5>User successfully added</h5>
				</div>
			</c:when>
			<c:when test="${message eq 'exception'}">
				<div class="w3-panel w3-red w3-display-container w3-card-4 w3-round">
					<span onclick="this.parentElement.style.display='none'"class="w3-button w3-margin-right w3-display-right w3-round-large w3-hover-red w3-border w3-border-red w3-hover-border-grey">×</span>
					<h5>Login is already taken. Please choose a different login!</h5>
				</div>
			</c:when>
		</c:choose>
	</div>
</div>

<div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
	<button class="w3-btn w3-round-large" onclick="location.href='/list'">List of users</button>
</div>
</body>
</html>
