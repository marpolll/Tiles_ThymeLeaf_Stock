<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">

<title>테스트</title>

<link href="${rootPath}/static/css/main.css" rel="stylesheet" />
<link href="${rootPath}/static/css/input.css" rel="stylesheet" />

<script>
	var rootPath = "${rootPath}"
</script>

<script src ="${rootPath}/static/js/main_input.js"></script>
<script src ="${rootPath}/static/js/main_input_validation.js"></script>

</head>

<body>

	<header class="main">
		<h1>테스트</h1>
		<p>테스트</p>
	</header>

	<nav class="main">
		<ul>
			<li>Home</li>
			<li>주식정보</li>
			<li>주식차트</li>

			<li>로그인</li>
			<li>회원가입</li>

			<li>로그아웃</li>
			<li>My Page</li>
		</ul>
	</nav>
	<footer>
		<address>CopyRight &copy; marpol.marpol.com All Right Reserved</address>
	</footer>
	
</body>
</html>