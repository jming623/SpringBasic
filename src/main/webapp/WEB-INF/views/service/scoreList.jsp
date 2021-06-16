<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h3>점수결과</h3>
	<c:forEach var="vo" items="${list }" varStatus="idx">
	
		이름:${vo.name }, 국어:${vo.kor }, 영어:${vo.eng }<br>
		
	</c:forEach>
	
	
	<a href="scoreRegist">점수입력</a>
</body>
</html>