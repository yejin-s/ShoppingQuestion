// 페이지 로드될 때
function goShoppingQuestionResultCode(resultCode){
	if(resultCode == "0001"){
		alert("작성 성공");
		
	}else if(resultCode == "9991"){
		alert("작성 실패");
		
	}else if(resultCode == "0002"){
		alert("삭제 성공");
		
	}else if(resultCode == "9992"){
		alert("삭제 실패");
		
	}else if(resultCode == "0003"){
		alert("수정 성공");
		
	}else if(resultCode == "9993"){
		alert("수정 실패");
		
	}
}

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

// 검색 사용 후 초기화하고 리스트로 돌아오는 코드
function goShoppingQuestionListPaging(pageNumber, pageTotalQuestionNumber){
	
	$("#pageTotalQuestionNumber").val(pageTotalQuestionNumber).remove();
	$("#searchType").val(searchType).remove();
	$("#startDate").val(startDate).remove();
	$("#endDate").val(endDate).remove();
	document.shoppingQuestionForm.pageNumber.value = pageNumber;
	document.shoppingQuestionForm.pageTotalQuestionNumber.value = pageTotalQuestionNumber;
	document.shoppingQuestionForm.action = "/spring/shopping/questionListPaging";
	document.shoppingQuestionForm.submit();
}

// 글 삭제 컨트롤러로 가는 함수
function goShoppingQuestionDelete(questionNumber){
	
	document.shoppingQuestionForm.questionNumber.value = questionNumber;
	document.shoppingQuestionForm.action = "/spring/shopping/questionDelete";
	document.shoppingQuestionForm.submit();
	
}

// 페이지 이동
function goPage(pageNumber, pageTotalQuestionNumber, pageType){
	
	// 페이지 이동 버튼눌렀는지, selectbox 버튼 눌렀는지 타입 체크
	if(pageType == 'select'){
		pageTotalQuestionNumber = $("#pageTotalQuestionNumber").val();
	}
	
	// 검색기능
	var searchType = $("#searchType").val();
	var searchKeyword = $("#searchKeyword").val();
	
	// 날짜
	var startDate = $("#startDate").val();
	var endDate = $("#endDate").val();
	
	$("#pageTotalQuestionNumber").val(pageTotalQuestionNumber).prop("selected", true);
	$("#searchType").val(searchType).prop("selected", true);
	document.shoppingQuestionForm.pageNumber.value = pageNumber;
	document.shoppingQuestionForm.pageTotalQuestionNumber.value = pageTotalQuestionNumber;
	document.shoppingQuestionForm.searchType.value = searchType;
	document.shoppingQuestionForm.searchKeyword.value = searchKeyword;
	document.shoppingQuestionForm.startDate.value = startDate;
	document.shoppingQuestionForm.endDate.value = endDate;
	document.shoppingQuestionForm.action = "/spring/shopping/questionListPaging";
	document.shoppingQuestionForm.submit();
}

// json 데이터로 값 받아오기
function goJsonData(){
	
	$.ajax({
		url : "/spring/shopping/questionListJson",
		method : "post",
		dataType : "json",
		success : function(data){
			
			var html;
			if(data != ""){
				for(var i in data){
					html = html + "<tr>";
					html = html + "<td>" + data[i].questionNumber + "</td>";
					html = html + "<td>" + data[i].userId + "</td>";
					html = html + "<td>" + data[i].questionTitle + "</td>";
					html = html + "<td>" + data[i].questionContent + "</td>";
					html = html + "<td>" + changeDate(data[i].questionRegdate) + "</td>";
					html = html + "<td>" + changeDate(data[i].questionModityRegdate) + "</td>";
					html = html + "</tr>";
				}
			}else{
				html = html + "<tr>";
				html = html + "<td colspan='6'> 조회 된 데이터가 없습니다. </td>";
				html = html + "</tr>";
			}
			
			$('#jsonTable').append(html);
		},
		error : function(){
			alert("JSON ERROR")
		}
	});
}

// 날짜 포멧
function changeDate(date){
	
	const today = new Date(date);
	
	return today.toDateString();
}
