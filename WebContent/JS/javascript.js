function checkValue()
{
	if(!document.userInfo.id.value){
		alert("아이디를 입력하세요.");
		return false;
	}
	
	if(!document.userInfo.password.value){
		alert("비밀번호를 입력하세요.");
		return false;
	}
	
	// 비밀번호와 비밀번호 확인에 입력된 값이 동일한지 확인
	if(document.userInfo.password.value != document.userInfo.passwordcheck.value ){
		alert("비밀번호를 동일하게 입력하세요.");
		return false;
	}
}

// 취소 버튼 클릭시 첫화면으로 이동
function goFirstForm() {
	location.href="MainForm.do";
}