function goJoinPage(){
	document.shoppingUserForm.action = "/spring/shopping/joinPage";
	document.shoppingUserForm.submit();
}

function goShoppingJoinIdCheck(){

	var userId = document.shoppingUserJoinForm.userId.value;

	$.ajax({
		url : "/spring/shopping/joinIdCheck",
		data : {userId : userId},
		method : "post",
		dataType : "text",
		success : function(idCheckResult){
			if(idCheckResult == "Y"){
				alert("사용 가능한 아이디 입니다.")
			}else{
				alert("이미 사용중인 아이디 입니다.")
			}
		},
		error : function(){
			alert("ID CHECK ERROR")
		}
	});
}

function goUserJoin(){
	document.shoppingUserJoinForm.action = "/spring/shopping/userJoin";
	document.shoppingUserJoinForm.submit();
}

function goUserLogin(){
	
	var form = document.shoppingUserForm;
	
	var userId = form.userId.value;
	var userPassword = form.userPassword.value;
	
	var loginUserData = {
		userId : userId,
		userPassword : userPassword
	}
	
	$.ajax({
		url : "/spring/shopping/loginCheck",
		data : loginUserData,
		method : "post",
		dataType : "text",
		success : function(resultLoginCheck){
			if(resultLoginCheck == "Y"){
				location.href="/spring/shopping/questionList";
			}else{
				alert("로그인 정보가 잘못되었습니다.")
			}
		},
		error : function(){
			alert("LOGIN ERROR")
		}
	});
}




