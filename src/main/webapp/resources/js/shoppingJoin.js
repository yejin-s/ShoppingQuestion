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





