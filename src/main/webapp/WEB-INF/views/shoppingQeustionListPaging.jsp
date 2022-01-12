<%@ page language="java" contentType="text/html; charsetUTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page session="false"%>
<html>
<script type="text/javascript"
	src="/spring/resources/js/shoppingQeustion.js"></script>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<head>
<title>SHOPPING QEUSTION LIST PAGING</title>
</head>
<body
	onload="javascript:goWriteResultCodeAlert('${resultCode}','${type}')">

	<table border="1px">
		<tr>
			<td>번호</td>
			<td>작성자</td>
			<td>제목</td>
			<td>등록일</td>
			<td>수정일</td>
			<td>기타</td>
		</tr>

		<c:choose>
			<c:when
				test="${questionListPaging ne null && questionListPaging.size() > 0 }">
				<c:forEach items="${questionListPaging}" var="questionListPaging">
					<tr>
						<td>${questionListPaging.rowNumber }</td>
						<td>${questionListPaging.questionUser }</td>
						<td><a
							href="javascript:goShoppingQuestionDetail('${questionListPaging.questionNumber }')">${questionListPaging.questionTitle }</a></td>
						<td><fmt:formatDate
								value="${questionListPaging.questionRegdate}" pattern="yy/MM/dd" /></td>
						<c:if test="${questionListPaging.questionModityRegdate ne null}">
							<td><fmt:formatDate
									value="${questionListPaging.questionModityRegdate}"
									pattern="yy/MM/dd" /></td>
						</c:if>
						<c:if test="${questionListPaging.questionModityRegdate eq null}">
							<td><fmt:formatDate
									value="${questionListPaging.questionRegdate}"
									pattern="yy/MM/dd" /></td>
						</c:if>
						<td><input type="button" value="삭제"
							onclick="javascript:goShoppingQuestionDelete('${questionListPaging.questionNumber }')">
						</td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="7">게시글이 없습니다.</td>
				</tr>
			</c:otherwise>
		</c:choose>
	</table>

	<c:choose>
		<c:when test="${nowPageNumber < 6 && pageNumber > pageTotalQuestionNumber}">
			<table>
				<tr>
					<c:forEach var="pageNumber" begin="1" end="${pageTotalQuestionNumber }">
						<td><input type="button" value="${pageNumber}"
							onclick="javascript:goPage(${pageNumber})"></td>
					</c:forEach>
					<td><input type="button" value="▶"
						onclick="javascript:goPage(6)"></td>
				</tr>
			</table>
		</c:when>
		<c:when test="${nowPageNumber < 6}">
			<table>
				<tr>
					<c:forEach var="pageNumber" begin="1" end="${pageNumber}">
						<td><input type="button" value="${pageNumber}"
							onclick="javascript:goPage(${pageNumber})"></td>
					</c:forEach>
				</tr>
			</table>
		</c:when>
		<c:when test="${nowPageNumber > pageTotalQuestionNumber}">
			<table>
				<tr>
					<td><input type="button" value="◀"
						onclick="javascript:goPage(${(nowPageNumber - ((nowPageNumber % pageTotalQuestionNumber) - 1)) - 1})"></td>
					<c:forEach var="pageNumber"
						begin="${nowPageNumber - ((nowPageNumber % pageTotalQuestionNumber) - 1)}"
						end="${pageNumber}">
						<td><input type="button" value="${pageNumber}"
							onclick="javascript:goPage(${pageNumber})"></td>
					</c:forEach>
				</tr>
			</table>
		</c:when>
		<c:when
			test="${nowPageNumber > pageTotalQuestionNumber && (pageNumber / pageTotalQuestionNumber) > 1 && (pageNumber % pageTotalQuestionNumber) > 0}">
			<table>
				<tr>
					<td><input type="button" value="◀"
						onclick="javascript:goPage(${(nowPageNumber - ((nowPageNumber % pageTotalQuestionNumber) - 1)) + 1})"></td>
					<c:forEach var="pageNumber"
						begin="${nowPageNumber - ((nowPageNumber % pageTotalQuestionNumber) - 1)}"
						end="${(pageTotalQuestionNumber + ((nowPageNumber % pageTotalQuestionNumber) - 1)) + 4}">
						<td><input type="button" value="${pageNumber}"
							onclick="javascript:goPage(${pageNumber})"></td>
					</c:forEach>
					<td><input type="button" value="▶"
						onclick="javascript:goPage(${((pageTotalQuestionNumber + ((nowPageNumber % pageTotalQuestionNumber) - 1)) + 4) + 1})"></td>
				</tr>
			</table>
		</c:when>
	</c:choose>

	<table>
		<tr>
			<td><input type="button" value="글쓰기"
				onclick="javascript:goShoppingQuestionWrite()"></td>
		</tr>
	</table>
	<form name="shoppingQuestionForm" method="post">
		<input type="hidden" id="questionNumber" name="questionNumber" />
		<input type="hidden" id="pageNumber" name="pageNumber" />
	</form>
</body>
</html>
