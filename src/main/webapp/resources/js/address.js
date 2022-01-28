/**
 * 주소 스크립트
 */

// onkeydown 속성에 대한 함수
function enterSearch() {
	// 파이어폭스에서 키이벤트 얻는 코드 => 크롬에서도 사용 가능
	// ev.which, event.keyCode : 키 고유의 값 얻기
	var evt_code = (window.netscape) ? ev.which : event.keyCode;0
	
	// evt_code == 13 : Enter
	if (evt_code == 13) {    
		event.keyCode = 0;  
		getAddr(); 
	} 
}

// 크로스도메인
function getAddr(){

	// 특수문자 제거 함수
	if (!checkSearchedWord(document.form.keyword)) {
		return ;
	}

	// # : id명 쓸 때 사용
	// .serialize() : "confmKey=값&keyword=값&..."
	$.ajax({
		 url :"https://www.juso.go.kr/addrlink/addrLinkApiJsonp.do"  // 도로명 주소
		,type:"post"
		,data:$("#form").serialize()
		,dataType:"jsonp"
		,crossDomain:true
		,success:function(jsonStr){
			$("#list").html("");
			// 결과에서 에러코드와 에러메세지 가져오기
			var errCode = jsonStr.results.common.errorCode;
			var errDesc = jsonStr.results.common.errorMessage;
			if(errCode != "0"){
				alert(errCode+"="+errDesc);
			}else{
				if(jsonStr != null){
					makeListJson(jsonStr);
				}
			}
		}
	    ,error: function(xhr, status, error){
	    	alert("에러발생");
	    }
	});
}

// 특수문자 체크
function checkSearchedWord(obj){
	
	if(obj.value.length >0){
		//특수문자 제거 정규식 => /이 안에 있는 문자 제거/
		var expText = /[%=><]/ ;
		
		// expText.test(obj.value) : 받아온 값에 특수문자가 존재하는지 안하는지 체크
		if(expText.test(obj.value) == true){
			alert("특수문자를 입력 할수 없습니다.") ;
			
			// .join() : 이어 붙이기
			obj.value = obj.value.split(expText).join(""); 
			
			// 기존에 있던 기능들이 없어지고 원래 있던 곳으로 돌아간다.
			return false;
		}
		
		//특정문자열(sql예약어의 앞뒤공백포함) 제거
		var sqlArray = new Array(
			//sql 예약어
			"OR", "SELECT", "INSERT", "DELETE", "UPDATE", "CREATE", "DROP", "EXEC",
             		 "UNION",  "FETCH", "DECLARE", "TRUNCATE" 
		);
		
		var regex;
		for(var i=0; i<sqlArray.length; i++){
			regex = new RegExp( sqlArray[i] ,"gi") ;
			
			// 예약어가 있는지 없는지 체크
			if (regex.test(obj.value) ) {
			    alert("\"" + sqlArray[i]+"\"와(과) 같은 특정문자로 검색할 수 없습니다.");

				// .replace() : 값 변경
				obj.value = obj.value.replace(regex, "");
				return false;
			}
		}
	}
	return true ;
}

// 결과 출력
function makeListJson(jsonStr){
	var htmlStr = "";
	htmlStr += "<table>";
	
	$(jsonStr.results.juso).each(function(){
		htmlStr += "<tr>";
		htmlStr += "<td>"+this.roadAddr+"</td>";
		htmlStr += "<td>"+this.roadAddrPart1+"</td>";
		htmlStr += "<td>"+this.roadAddrPart2+"</td>";
		htmlStr += "<td>"+this.jibunAddr+"</td>";
		htmlStr += "<td>"+this.engAddr+"</td>";
		/*htmlStr += "<td>"+this.zipNo+"</td>";*/
		/*htmlStr += "<td>"+this.admCd+"</td>";*/
		/*htmlStr += "<td>"+this.rnMgtSn+"</td>";
		htmlStr += "<td>"+this.bdMgtSn+"</td>";
		htmlStr += "<td>"+this.detBdNmList+"</td>";*/
		/** API 서비스 제공항목 확대 (2017.02) **/
		/*htmlStr += "<td>"+this.bdNm+"</td>";
		htmlStr += "<td>"+this.bdKdcd+"</td>";
		htmlStr += "<td>"+this.siNm+"</td>";
		htmlStr += "<td>"+this.sggNm+"</td>";
		htmlStr += "<td>"+this.emdNm+"</td>";
		htmlStr += "<td>"+this.liNm+"</td>";
		htmlStr += "<td>"+this.rn+"</td>";
		htmlStr += "<td>"+this.udrtYn+"</td>";
		htmlStr += "<td>"+this.buldMnnm+"</td>";
		htmlStr += "<td>"+this.buldSlno+"</td>";
		htmlStr += "<td>"+this.mtYn+"</td>";
		htmlStr += "<td>"+this.lnbrMnnm+"</td>";
		htmlStr += "<td>"+this.lnbrSlno+"</td>";
		htmlStr += "<td>"+this.emdNo+"</td>";*/
		/** API 서비스 제공항목 확대 (2020.12) **/
		/*htmlStr += "<td>"+this.hstryYn+"</td>";
		htmlStr += "<td>"+this.relJibun+"</td>";
		htmlStr += "<td>"+this.hemdNm+"</td>";
		htmlStr += "</tr>";*/
	});
	htmlStr += "</table>";
	$("#list").html(htmlStr);
}

