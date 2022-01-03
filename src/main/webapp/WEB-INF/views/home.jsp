<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charsetUTF-8" pageEncoding="UTF-8" %>
<html>
<script type="text/javascript" src="/spring/resources/js/home.js"></script>
<head>
	<title>Shopping Question Board</title>
	
</head>
<body>
	<table border="1px">
		<tr>
			<td>번호</td>
			<td>작성자</td>
			<td>제목</td>
			<td>등록일</td>
			<td>수정일</td>
			<td>기타</td>
		</tr>
		
		<c:if test="${shoppingQuestionBoardList ne null && shoppingQuestionBoardList.size() > 0 }">
			<c:forEach items="${shoppingQuestionBoardList}" var="shoppingQuestionBoardList" > 
				<c:if test="${shoppingQuestionBoardList.questionDeleteCheck  == 'N'}">
					<tr>
						<td>${shoppingQuestionBoardList.questionNumber }</td>
						<td>${shoppingQuestionBoardList.questionUser }</td>
						<td><a href="javascript:goShoppingQuestionDetail('${shoppingQuestionBoardList.questionNumber }')">${shoppingQuestionBoardList.questionTitle }</a></td>
						<td><fmt:formatDate value="${shoppingQuestionBoardList.questionRegDate}" pattern="yy/MM/dd"/></td>
						
						<c:if test="${shoppingQuestionBoardList.qeustionModityRegDate ne null}">
							<td><fmt:formatDate value="${shoppingQuestionBoardList.qeustionModityRegDate}" pattern="yy/MM/dd"/></td>
						</c:if>
						<c:if test="${shoppingQuestionBoardList.qeustionModityRegDate eq null}">
							<td><fmt:formatDate value="${shoppingQuestionBoardList.questionRegDate}" pattern="yy/MM/dd"/></td>
						</c:if>
						<td>
							<input type="button" value="삭제" onclick="javascript:goShoppingQuestionDelete('${shoppingQuestionBoardList.questionNumber }')">	
						</td>
					</tr>
				</c:if>
			</c:forEach>
		</c:if>
		<c:if test="${shoppingQuestionBoardList eq null || shoppingQuestionBoardList.size() <= 0}">
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
</body>
</html>
