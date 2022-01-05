<%@ page language="java" contentType="text/html; charsetUTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html>
<html>
<script type="text/javascript" src="/spring/resources/js/home.js"></script>
<head>
<meta charset="EUC-KR">
<title>Shopping QUuestion Board Detail</title>
</head>
<body>
	<form action = "/spring/shopping/questionUpdatePage" method="post">
		<input type="hidden" id="questionNumber" name="questionNumber" value="${shoppingQuestionDetail.questionNumber }">
		<table border="1px">
			<tr>
				<td>번호</td>
				<td>제목</td>
				<td>내용</td>
				<td>작성자</td>
				<td>등록일</td>
				<td>수정일</td>
				<td>기타</td>
			</tr>
			<tr>
				<td>${shoppingQuestionDetail.questionNumber }</td>
				<td>${shoppingQuestionDetail.questionTitle }</td>
				<td>${shoppingQuestionDetail.questionContent }</td>
				<td>${shoppingQuestionDetail.questionUser }</td>
				<td><fmt:formatDate value="${shoppingQuestionDetail.questionRegdate}" pattern="yy/MM/dd"/></td>
				<c:if test="${shoppingQuestionDetail.questionModityRegdate ne null}">
					<td><fmt:formatDate value="${shoppingQuestionDetail.questionModityRegdate}" pattern="yy/MM/dd"/></td>
				</c:if>
				<c:if test="${shoppingQuestionDetail.questionModityRegdate eq null}">
					<td><fmt:formatDate value="${shoppingQuestionDetail.questionRegdate}" pattern="yy/MM/dd"/></td>
				</c:if>
				<td><input type="submit" value="수정"></td>
			</tr>
		</table>
		<table>
			<tr>
				<td><input type="button" value="뒤로" onclick="javascript:goShoppingQuestionList()"></td>
			</tr>
		</table>
	</form>
	
</body>
</html>