<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.4.0/Chart.min.js"></script>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<style>
#buttons {
	width: 800px;
	height: 24px;
	margin-left: auto; 
	margin-right: auto;
}
.button {
	width: 100px;
	height: 20px;
	border: 2px solid black;
	float : left;
	text-align: center
}
</style>
</head>
<body>
<h1 style="text-align: center">스마트 교차로 시스템</h1>

<div id = "buttons">
	<div class="button"><a href="chart1.mc">전체</a></div>
	<div class="button"><a href="chart2.mc">방향</a></div>
	<div class="button"><a href="chart3.mc">과속</a></div>
</div>
<c:choose>
		<c:when test="${centerpage == null}">
		 	<jsp:include page="chart1.jsp"></jsp:include>
		</c:when>
		<c:otherwise>
			<jsp:include page="${centerpage }.jsp"></jsp:include>
		</c:otherwise>
</c:choose>
</body>
</html>