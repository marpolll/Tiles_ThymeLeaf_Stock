<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<!DOCTYPE html>
<html>

<tiles:insertAttribute name="head" />
<body>

	<tiles:insertAttribute name="nav" />
	<section class="main">
		<tiles:insertAttribute name="main-content" />
	</section>

	<footer>
		<address>CopyRight &copy; All right Reserved</address>
	</footer>

</body>

</html>