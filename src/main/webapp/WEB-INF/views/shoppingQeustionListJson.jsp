<%@page import="org.apache.ibatis.reflection.SystemMetaObject"%>
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
<body>

	<table border="1px" id="jsonTable">
		<tr>
			<td>번호</td>
			<td>작성자</td>
			<td>제목</td>
			<td>내용</td>
			<td>등록일</td>
			<td>수정일</td>
		</tr>
		
	</table>

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
