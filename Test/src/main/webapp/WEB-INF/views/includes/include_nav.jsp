<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<header class="main">
	<h1>테스트</h1>
</header>

<nav class="main">

	<ul>
		
		<li class="home"><a href="${rootPath}/">HOME</a></li>

		<li class="rent"><a href="${rootPath}/">주식정보</a></li>

		<li class="book"><a href="${rootPath}/">주식차트</a></li>
		<li class="member"><a href="${rootPath}/">회원정보</a></li>
		
		<sec:authorize access="isAnonymous()">
		<li class="login"><a href="${rootPath}/login">로그인</a></li>
		</sec:authorize>
		
		<sec:authorize access="isAuthenticated()">
			<form:form action="${rootPath}/logout">
				<button>로그아웃</button>
			</form:form>
		</sec:authorize>
		<sec:authorize access="hasRole('ADMIN')">		
		<li class="admin"><a href="${rootPath}/admin">관리자</a></li>
		</sec:authorize>
	</ul>

</nav>

