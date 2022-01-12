<%@ page language="java" contentType="text/html; charsetUTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<script type="text/javascript" src="/spring/resources/js/shoppingUser.js"></script>
<script src="http://code.jquery.com/jquery-latest.js"></script> 
<head>
<meta charset="EUC-KR">
<title>SHOPPING JOIN PAGE</title>
</head>
<body>
	<form name="shoppingUserJoinForm" method="post" action="javascript:goUserJoin()">
		<table>
			<tr>
				<td>이름 : </td>
				<td><input type="text" name="userName" id="userName"></td>
			</tr>
			<tr>
				<td>ID : </td>
				<td><input type="text" name="userId" id="userId"/> <input type="button" value="중복확인" onclick="javascript:goShoppingJoinIdCheck()"></td>
			</tr>
			<tr>
				<td>PW : </td>
				<td><input type="password" name="userPassword" id="userPassword"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="가입"></td>
			</tr>
		</table>
		
	</form>
</body>
</html>