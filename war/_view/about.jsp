<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
	<head>
		<title>About</title>
		<link rel="stylesheet" href="about.css">
		</head>
		<body>
		<c:if test="${sessionScope.login == true}">
		<div class="header">
			<ul>
				<li><b class="navbar-brand" href="index">Cicero</b></li>
				<li class="active"><a href="index">Home</a></li>
				<li><a href="searchPage">Search</a></li>
				<li><a href="tedTalkPage">Begin New TedTalk</a></li>
				<li style="float:right"><a href="accountManagement">Account Management</a></li>
				<li><a href="logout">Logout</a></li>
				<li><a href="about">About</a></li>
			</ul>
		</div>
		</c:if>
		<c:if test="${sessionScope.login != true}">
		<div class="header">
			<ul>
				<li><b class="navbar-brand" href="index">Cicero</b></li>
				<li class="active"><a href="index">Home</a></li>
				<li><a href="searchPage">Search</a></li>
				<li><a href="accountCreation">Create Account</a></li>
				<li><a href="login">Login</a></li>
				<li><a href="about">About</a></li>
			</ul>
		</div>
		</c:if>
		<div class="about">
		 <img src="https://www.google.com/url?sa=i&rct=j&q=&esrc=s&source=images&cd=&cad=rja&uact=8&ved=0ahUKEwjU2ce7kePTAhXB6oMKHTe_CeUQjRwIBw&url=https%3A%2F%2Fcommons.wikimedia.org%2Fwiki%2FFile%3ACicero.PNG&psig=AFQjCNGwKivSQordD2xQnrJ7MZTdQTcYGg&ust=1494430467050880"/>
		<h1>"Never stop learning,<br>
		 because life never <br>
		 stops teaching."</h1>
		 <div class="text">
			<p>YCP TEDTalk Reviews is a website utilized by the Civil Engineering Department <br> at the York College of Pennsylvania. Redesigned by Aaron Roby, Terell Clark, and Chihea
			Locke, this website allows users to create forum-like posts on <br>their favorite TEDTalks and review them. </p>
	
			<p>Named after the Greek philosopher, Cicero, this site is meant for sharing valuable<br> opinions and learning 
		new things not only from the videos, but from the whole community.</p>
		</div>
		 </div>
	</body>
</html>
