<%@ page language="java" contentType="text/html; charsetUTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page session="false"%>
<html>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript"
	src="/spring/resources/js/shoppingQeustion.js"></script>
<head>
<title>SHOPPING QEUSTION LIST PAGING</title>
</head>
<body onload="javascript:goShoppingQuestionResultCode(${resultCode})">
	<select name="pageTotalQuestionNumber" id="pageTotalQuestionNumber"
		onchange="javascript:goPage(1, '${pageTotalQuestionNumber}', 'select')">
		<option value="페이지">페이지</option>
		<option value="5">5</option>
		<option value="10">10</option>
		<option value="15">15</option>
		<option value="20">20</option>
	</select>

	<select name="searchType" id="searchType">
		<option value="QUESTION_USER">작성자</option>
		<option value="QUESTION_TITLE">제목</option>
		<option value="QUESTION_CONTENT">내용</option>
	</select>

	<c:choose>
		<c:when test="${searchPage == 1 }">
			<input type="text" name="searchKeyword" id="searchKeyword" value="${searchKeyword }">
			<input type="button" value="검색" id="searchButton" 
				onclick="javascript:goPage(1, '${pageTotalQuestionNumber}', 'page')">	
		</c:when>
		<c:otherwise>
			<input type="text" name="searchKeyword" id="searchKeyword">
			<input type="button" value="검색" id="searchButton" 
				onclick="javascript:goPage(1, '${pageTotalQuestionNumber}', 'page')">
		</c:otherwise>
	</c:choose>

	<br>
	<br>
		
	<c:choose>
		<c:when test="${dateSearchPage == 1 }">
			<input type="date" id="startDate" name="startDate" value="${startDate }">
			~
			<input type="date" id="endDate" name="endDate" value="${endDate }">
			<input type="button" value="검색" id="searchButton" 
				onclick="javascript:goPage(1, '${pageTotalQuestionNumber}', 'page')">
		</c:when>
		<c:otherwise>
			<input type="date" id="startDate" name="startDate">
			~
			<input type="date" id="endDate" name="endDate">
			<input type="button" value="검색" id="searchButton" 
				onclick="javascript:goPage(1, '${pageTotalQuestionNumber}', 'reset')">
		</c:otherwise>
	</c:choose>
	<br>
	<br>
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
		<c:when
			test="${nowPageNumber < (pageTotalQuestionNumber + 1) && pageNumber > pageTotalQuestionNumber}">
			<table>
				<tr>
					<c:forEach var="pageNumber" begin="1"
						end="${pageTotalQuestionNumber }">
						<td><input type="button" value="${pageNumber}"
							onclick="javascript:goPage('${pageNumber}', '${pageTotalQuestionNumber}', 'page')"></td>
					</c:forEach>
					<td><input type="button" value="▶"
						onclick="javascript:goPage('${pageTotalQuestionNumber + 1}', '${pageTotalQuestionNumber}', 'page')"></td>
				</tr>
			</table>
		</c:when>
		<c:when test="${nowPageNumber < pageTotalQuestionNumber + 1}">
			<table>
				<tr>
					<c:forEach var="pageNumber" begin="1" end="${pageNumber}">
						<td><input type="button" value="${pageNumber}"
							onclick="javascript:goPage('${pageNumber}', '${pageTotalQuestionNumber}', 'page')"></td>
					</c:forEach>
				</tr>
			</table>
		</c:when>
		<c:when test="${nowPageNumber > pageTotalQuestionNumber}">
			<table>
				<tr>
					<td><input type="button" value="◀"
						onclick="javascript:goPage('${(nowPageNumber - ((nowPageNumber % pageTotalQuestionNumber) - 1)) - 1}', '${pageTotalQuestionNumber}', 'page')"></td>
					<c:forEach var="pageNumber"
						begin="${nowPageNumber - ((nowPageNumber % pageTotalQuestionNumber) - 1)}"
						end="${pageNumber}">
						<td><input type="button" value="${pageNumber}"
							onclick="javascript:goPage('${pageNumber}', '${pageTotalQuestionNumber}')"></td>
					</c:forEach>
				</tr>
			</table>
		</c:when>
		<c:when
			test="${nowPageNumber > pageTotalQuestionNumber && (pageNumber / pageTotalQuestionNumber) > 1 && (pageNumber % pageTotalQuestionNumber) > 0}">
			<table>
				<tr>
					<td><input type="button" value="◀"
						onclick="javascript:goPage('${(nowPageNumber - ((nowPageNumber % pageTotalQuestionNumber) - 1)) + 1}', '${pageTotalQuestionNumber}')"></td>
					<c:forEach var="pageNumber"
						begin="${nowPageNumber - ((nowPageNumber % pageTotalQuestionNumber) - 1)}"
						end="${(pageTotalQuestionNumber + ((nowPageNumber % pageTotalQuestionNumber) - 1)) + (pageTotalQuestionNumber -1)}">
						<td><input type="button" value="${pageNumber}"
							onclick="javascript:goPage('${pageNumber}', '${pageTotalQuestionNumber}', 'page')"></td>
					</c:forEach>
					<td><input type="button" value="▶"
						onclick="javascript:goPage('${((pageTotalQuestionNumber + ((nowPageNumber % pageTotalQuestionNumber) - 1)) + (pageTotalQuestionNumber -1)) + 1}', '${pageTotalQuestionNumber}', 'page')"></td>
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
	<table>
		<tr>
			<td><input type="reset" value="검색 초기화"
				onclick="javascript:goShoppingQuestionListPaging(1, 5)"></td>
		</tr>
	</table>
	<form name="shoppingQuestionForm" method="post">
		<input type="hidden" id="questionNumber" name="questionNumber" /> 
		<input type="hidden" id="pageNumber" name="pageNumber" /> 
		<input type="hidden" id="pageTotalQuestionNumber" name="pageTotalQuestionNumber" />
		<input type="hidden" id="searchType" name="searchType" />
		<input type="hidden" id="searchKeyword" name="searchKeyword" />
		<input type="hidden" id="startDate" name="startDate" />
		<input type="hidden" id="endDate" name="endDate" />
	</form>
</body>
</html>
