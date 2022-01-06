// 글쓰기 페이지로 가는 함수
function goShoppingQuestionWrite(){
	document.shoppingQuestionForm.action = "/spring/shopping/questionWrite";
	document.shoppingQuestionForm.submit();
}

// 글 상세정보 페이지로 가는 함수
function goShoppingQuestionDetail(questionNumber){
	
	document.shoppingQuestionForm.questionNumber.value = questionNumber;
	document.shoppingQuestionForm.action = "/spring/shopping/questionDetail";
	document.shoppingQuestionForm.submit();
}

// 글 목록으로 가는 함수
function goShoppingQuestionList(){
	location.href="/spring/shopping/questionList";
}

// 글 삭제 컨트롤러로 가는 함수
function goShoppingQuestionDelete(questionNumber){
	
	document.shoppingQuestionForm.questionNumber.value = questionNumber;
	document.shoppingQuestionForm.action = "/spring/shopping/questionDelete";
	document.shoppingQuestionForm.submit();
	
}