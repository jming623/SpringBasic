<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>첫번째 페이지</h3>
	
	<!--현재 페이지 주소 http://localhost:8181/basic/request/req_ex01 -->
	<!--그럼으로 http://localhost:8181/basic/request/ 여기까지 들어와있는 상태라  바로 메서드요청경로를 적어준다.-->
	<a href="basic01">basic01(Get)</a>
	<a href="basic02">basic02(Post)</a>
	<a href="basic03">basic03(둘 다)</a>
	
	<form action="basic03" method="post">
		<input type="submit" value="확인">
	</form>
	
</body>
</html>