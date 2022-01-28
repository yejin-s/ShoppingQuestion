<%@ page language="java" contentType="text/html; charsetUTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript"
	src="/spring/resources/js/address.js"></script>
<head>
<meta charset="EUC-KR">
<title>ADDRESS PAGE</title>
</head>
<body>
	<form name="form" id="form" method="post">
		<!-- 현재 페이지 -->
		<input type="hidden" name="currentPage" value="1"/> 
		<!-- 페이지당 출력 개수 -->
		<input type="hidden" name="countPerPage" value="5"/>
		<!-- 검색 결과 형식 설정 -->
		<input type="hidden" name="resultType" value="json"/>
		<!-- 요청 변수 설정 (승인키) -->
		<input type="hidden" name="confmKey" value="신청한 승인키"/>
		<!-- 요청 변수 설정 (키워드) : text 에 키보드를 눌러 작성할 때 -->
		주소 : <input type="text" name="keyword" value="" onkeydown="javascript:enterSearch();"/>
		<!-- 검색 js로 -->
		<input type="button" onClick="javascript:getAddr();" value="주소검색하기"/>
		
		<!-- 결과 나오는 곳 -->
		<div id="list" ></div>
		
	</form>
</body>
</html>