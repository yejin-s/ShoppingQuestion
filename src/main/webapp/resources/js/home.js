// 글쓰기 페이지로 가는 함수
function goShoppingQuestionWrite(){
	location.href="/spring/shoppingQuestion/boardWrite";
}

// 글 상세정보 페이지로 가는 함수
function goShoppingQuestionDetail(questionNumber){
	
	document.shoppingQuestionBoardForm.questionNumber.value = questionNumber;
	document.shoppingQuestionBoardForm.action = "/spring/shoppingQuestion/boardDetail";
	document.shoppingQuestionBoardForm.submit();
}

// 글 목록으로 가는 함수
function goShoppingQuestionList(){
	location.href="/spring/shoppingQuestion/boardList";
}

// 글 삭제 컨트롤러로 가는 함수
function goShoppingQuestionDelete(questionNumber){
	
	document.shoppingQuestionBoardForm.questionNumber.value = questionNumber;
	document.shoppingQuestionBoardForm.action = "/spring/shoppingQuestion/boardDelete";
	document.shoppingQuestionBoardForm.submit();
	
}