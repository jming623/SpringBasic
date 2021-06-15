<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form action="param" method="post">
		아이디:<input type="text" name="id"><br/>
		비밀번호:<input type="password" name="pw"> <br/>
		이름:<input type="text" name="name"> <br/>
		관심목록
		<input type="checkbox" name="inter" value="jsp">jsp
		<input type="checkbox" name="inter" value="spring">spring
		<input type="checkbox" name="inter" value="java">java
		
		<input type="submit" value="확인">		
		
	</form>
	
</body>
</html>