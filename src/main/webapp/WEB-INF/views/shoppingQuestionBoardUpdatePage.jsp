<%@ page language="java" contentType="text/html; charsetUTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html>
<html>
<script type="text/javascript" src="/spring/resources/js/home.js"></script>
<head>
<title>Shopping QUuestion Board Update Page</title>
</head>
<body>

	<form action="/spring/shoppingQuestion/boardUpdate" method="post">
		<input type="hidden" id="questionNumber" name="questionNumber" value="${shoppingQuestionBoardDetail.questionNumber }">
		<table border="1px">
			<tr>
				<td>번호</td>
				<td>작성자</td>
				<td>제목</td>
				<td>내용</td>
			</tr>
			<tr>
				<td>${shoppingQuestionBoardDetail.questionNumber }</td>
				<td>${shoppingQuestionBoardDetail.questionUser }</td>
				<td><input type="text" name="questionTitle" value="${shoppingQuestionBoardDetail.questionTitle }"></td>
				<td><input type="text" name="questionContent" value="${shoppingQuestionBoardDetail.questionContent }"></td>
			</tr>
		</table>
		<table>
			<tr>
				<td><input type="submit" value="등록"></td>
			</tr>
		</table>
	</form>
</body>
</html>