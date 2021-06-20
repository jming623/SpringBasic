<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table{border-box:box-sizing;}
	
	td{
	text-align:center;
	padding:0px;	
	border:1px solid  #777;
	border-spacing: 0px;
	}
</style>
</head>
<body>
	<%--다음 화면을 처리하는 메서드를 컨트롤러에 생성하세요 --%>
	<h2>게시글 목록</h2>
	
	<table>
		<tr>
			<td>번호</td>
			<td>작성자</td>
			<td>제목</td>
			<td>내용</td>
			<td>비고</td>
		</tr>
		<c:forEach var="vo" items="${list }" varStatus="idx">
		<tr>
			<td>${vo.bno }</td>
			<td>${vo.name }</td>
			<td>${vo.title }</td>
			<td>${vo.content }</td>
			<!-- 
			1. boardDelete로 삭제 처리하세요. 
			2. 삭제 후엔 목록화면으로 리다이렉트 하세요.
			-->
			<td><input type="button" value="삭제" onclick="location.href='delete?num=${vo.bno}'"></td>
		</tr>
		</c:forEach>
	</table>
	
	<%--게시글 작성페이지로 이동시키세요. --%>
	<a href="boardRegister">게시글 작성</a>

	
	<script type="text/javascript">
		
		(function(){
			var msg1 = "<c:out value='${msg}'/>"
			if(msg1 != ''){
				alert(msg1);
			}
		})();	
	</script>
	
</body>
</html>