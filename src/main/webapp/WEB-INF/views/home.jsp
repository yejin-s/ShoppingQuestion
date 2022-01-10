<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charsetUTF-8" pageEncoding="UTF-8" %>
<html>
<script type="text/javascript" src="/spring/resources/js/shoppingQeustion.js"></script>
<head>
	<title>Shopping Question Board</title>
	
</head>
<body onload="javascript:goWriteResultCodeAlert('${resultCode}','${type}')">
	<table border="1px">
		<tr>
			<td>번호</td>
			<td>작성자</td>
			<td>제목</td>
			<td>등록일</td>
			<td>수정일</td>
			<td>기타</td>
		</tr>
		
		<c:if test="${shoppingQuestionList ne null && shoppingQuestionList.size() > 0 }">
			<c:forEach items="${shoppingQuestionList}" var="shoppingQuestionList" > 
				<tr>
					<td>${shoppingQuestionList.questionNumber }</td>
					<td>${shoppingQuestionList.questionUser }</td>
					<td><a href="javascript:goShoppingQuestionDetail('${shoppingQuestionList.questionNumber }')">${shoppingQuestionList.questionTitle }</a></td>
					<td><fmt:formatDate value="${shoppingQuestionList.questionRegdate}" pattern="yy/MM/dd"/></td>
					<c:if test="${shoppingQuestionList.questionModityRegdate ne null}">
						<td><fmt:formatDate value="${shoppingQuestionList.questionModityRegdate}" pattern="yy/MM/dd"/></td>
					</c:if>
					<c:if test="${shoppingQuestionList.questionModityRegdate eq null}">
						<td><fmt:formatDate value="${shoppingQuestionList.questionRegdate}" pattern="yy/MM/dd"/></td>
					</c:if>
					<td>
						<input type="button" value="삭제" onclick="javascript:goShoppingQuestionDelete('${shoppingQuestionList.questionNumber }')">	
					</td>
				</tr>
			</c:forEach>
		</c:if>
		<c:if test="${shoppingQuestionList eq null || shoppingQuestionList.size() <= 0}">
			<tr>
				<td colspan="7">게시글이 없습니다.</td>
			</tr>
		</c:if>
	</table>
	<table>
		<tr>
			<td><input type="button" value="글쓰기" onclick="javascript:goShoppingQuestionWrite()"></td>
		</tr>
	</table>
	<form name="shoppingQuestionForm" method="post">
		<input type="hidden" id="questionNumber" name="questionNumber"/>
	</form>
</body>
</html>
