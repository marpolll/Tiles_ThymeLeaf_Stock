<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>테스트</title>
<link href="${rootPath}/static/css/main.css" rel="stylesheet">

<link href="${rootPath}/static/css/list.css" rel="stylesheet">

<script>
	var rootPath = "${rootPath}"
</script>

<script src="${rootPath}/static/js/main.js"></script>
<script src="${rootPath}/static/js/book.js"></script>
<script src="${rootPath}/static/js/member.js"></script>


</head>