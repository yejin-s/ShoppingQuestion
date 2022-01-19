<%@ page language="java" contentType="text/html; charsetUTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<script type="text/javascript" src="/spring/resources/js/shoppingQeustion.js"></script>
<head>
<meta charset="EUC-KR">
<title>SHOPPING QUESTION WRITE PAGE</title>
</head>
<body>
	<form action="/spring/shopping/questionWriteEnrollment" method="post">
		<table border="1px">
		<tr>
			<th>작성자</th>
			<td><input type="text" name="userId"></td>
		</tr>
		<tr>
			<th>제목</th>
			<td><input type="text"  name="questionTitle"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><input type="text"  name="questionContent"></td>
		</tr>
	</table>
	
	<input type="submit" value="등록">
	<input type="reset" value="취소">
	</form>
	
</body>
</html>