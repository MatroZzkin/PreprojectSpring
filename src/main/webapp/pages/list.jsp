<%@ page import="java.util.List" %>
<%@ page import="common.model.User" %>
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
    <title>List user</title>
</head>
<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-right-align">
    <h1>Java Mentor</h1>
</div>

<div class="w3-container w3-center w3-margin-bottom w3-padding">
    <div class="w3-card-4">
        <div class="w3-container w3-light-blue">
            <h2>Users</h2>
        </div>

        <c:set var="users" value="${usersList}" />


        <c:choose>
            <c:when test="${not empty users}">
                <li class="w3-ul">
                    <c:forEach items="${users}" var="user">
                        <li class="w3-hover-sand">
                            User ID: ${user.id} | User name: ${user.name} | User login: ${user.login} | User role: ${user.role}
                            <button class="w3-btn w3-round-large w3-light-blue\" onclick="location.href='/update?id=${user.id}'">Update</button>
                            <button class="w3-btn w3-round-large w3-light-blue\" onclick="location.href='/delete?id=${user.id}'">Delete</button>
                        </li>
                    </c:forEach>
                </ul>
            </c:when>
            <c:otherwise>
                <div class="w3-panel w3-red w3-display-container w3-card-4 w3-round">
                    <span onclick="this.parentElement.style.display='none'" class="w3-button w3-margin-right w3-display-right w3-round-large w3-hover-red w3-border w3-border-red w3-hover-border-grey"></span>
                    <h5>There are no users yet!</h5>
                </div>
            </c:otherwise>
        </c:choose>


    </div>
</div>

<div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
    <button class="w3-btn w3-round-large" onclick="location.href='/'">Add users</button>
    <button class="w3-btn w3-round-large" onclick="location.href='/admin?sign=out'">Sign out</button>
</div>
</body>
</html>
