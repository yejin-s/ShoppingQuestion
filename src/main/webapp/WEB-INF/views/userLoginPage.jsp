<%@ page language="java" contentType="text/html; charsetUTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="/spring/resources/js/shoppingUser.js"></script>
<script src="http://code.jquery.com/jquery-latest.js"></script> 
<meta charset="EUC-KR">
<title>USER LOGIN PAGE</title>
</head>
<body onload="javascript:goLoginPageJoinCheck(${resultCode})">
	<form action="javascript:goUserLogin()" name="shoppingUserForm" method="post">
		<table>
			<tr>
				<td>ID : </td>
				<td><input type="text" name="userId" id="userId"></td>
			</tr>
			<tr>
				<td>PW : </td>
				<td><input type="password" name="userPassword" id=:userPassword></td>
			</tr>
			<tr>
				<td><input type="submit" value="로그인"></td>
				<td><input type="button" value="회원가입" onclick="javascript:goJoinPage()"></td>
			</tr>
		</table>
		
	</form>
</body>
</html>