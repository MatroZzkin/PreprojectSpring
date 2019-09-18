<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
    <%@include file="/styles/w3.css"%>
</style>

<%--
  Created by IntelliJ IDEA.
  User: Artyom
  Date: 03.09.2019
  Time: 13:39
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Authorization</title>
</head>
<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-right-align">
    <h1>Java Mentor</h1>
</div>

<div class="w3-container w3-padding">

    <div class="w3-card-4">
        <div class="w3-container w3-center w3-green">
            <h2>Authorization</h2>
        </div>
        <form method="post" action="/auth" class="w3-selection w3-light-grey w3-padding">
            <label>Login:
                <input type="text" name="login" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%" required><br />
            </label>
            <label>Password:
                <input type="password" name="pass" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%" required><br />
            </label>
            <button type="submit" class="w3-btn w3-green w3-round-large w3-margin-bottom">Submit</button>
        </form>


            <c:if test="${pageContext.response.status eq 400}">
                <div class="w3-panel w3-red w3-display-container w3-card-4 w3-round">
                    <span onclick="this.parentElement.style.display='none'"class="w3-button w3-margin-right w3-display-right w3-round-large w3-hover-red w3-border w3-border-red w3-hover-border-grey">×</span>
                    <h5>User not registered or wrong password!  </h5>
                </div>
            </c:if>


    </div>
</div>

</body>
</html>
