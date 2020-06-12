<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>회원가입 화면</title>

<head>
<style>
table{
	margin-left:auto; 
	margin-right:auto;
	border:3px solid skyblue;
}

td{
	border:1px solid skyblue
}

#title{
	background-color:skyblue
}
</style>
   <script>
    function checkValue()
    {
    	
    	
    	if(!document.userInfo.id.value){
    		alert("아이디를 입력하지 않았습니다.");
    		userInfo.id.focus();
    		return false;
    	}
    	
        //아이디 유효성 검사 (영문소문자, 숫자만 허용)
        for(var i = 0; i < document.userInfo.id.value.length; i++) {
            ch = document.userInfo.id.value.charAt(i)
            if(!(ch >= '0' && ch <= '9') && !(ch >= 'a' && ch <= 'z')&&!(ch >= 'A' && ch <= 'Z')) {
                alert("아이디는 영문 대소문자, 숫자만 입력가능합니다.");
                document.userInfo.id.focus();
                document.userInfo.id.select();
                return false;
            }
        }
        
        //아이디 공백 사용하지 않기
        if(document.userInfo.id.value.indexOf(" ") >= 0) {
            alert("아이디에 공백을 사용할 수 없습니다.")
            document.userInfo.id.focus();
            document.userInfo.id.select()
            return false;
        }
        
        //아이디 길이 체크(4~12자)
        if(document.userInfo.id.value.length<4 || document.userInfo.id.value.length>12) {
            alert("아이디를 4~12자까지 입력해주세요.")
            document.userInfo.id.focus();
            document.userInfo.id.select();
            return false;
        }
        
    	if(!document.userInfo.password.value){
    		alert("비밀번호를 입력하지 않았습니다.");
    		userInfo.password.focus();
    		userInfo.password.select();
    		return false;
    	}
    		
    	// 비밀번호와 비밀번호 확인에 입력된 값이 동일한지 확인
    	if(document.userInfo.password.value != document.userInfo.passwordcheck.value ){
    		alert("비밀번호가 일치하지 않습니다.");
    		userInfo.passwordcheck.focus();
    		return false;
    	}
    	
        //비밀번호 길이 체크(4~8자 까지 허용)
        if (document.userInfo.password.value.length<4 || document.userInfo.password.value.length>12) {
            alert("비밀번호를 4~12자까지 입력해주세요.")
            document.userInfo.password.focus();
            document.userInfo.password.select();
            return false;
        }
        
        if (!document.userInfo.mail1.value) {
            alert("이메일을 입력하지 않았습니다.")
            document.userInfo.mail1.focus();
            return false;
        }
        
        for (var i = 0; i < document.userInfo.mail1.value.length; i++) {
            chm = document.userInfo.mail1.value.charAt(i)
            if (!(chm >= '0' && chm <= '9') && !(chm >= 'a' && chm <= 'z')&&!(chm >= 'A' && chm <= 'Z')) {
                alert("이메일은 영문 대소문자, 숫자만 입력가능합니다.")
                document.userInfo.mail1.focus();
                document.userInfo.mail1.select();
                return false;
            }
        }
        
        if(!document.userInfo.birthyy.value){
            alert("년도를 입력하세요.");
            return false;
        }
        
        if(isNaN(document.userInfo.birthyy.value)){
            alert("년도는 숫자만 입력가능합니다.");
            return false;
        }
        
        if(document.userInfo.birthmm.value == "00"){
            alert("월을 선택하세요.");
            return false;
        }
        
        if(!document.userInfo.birthdd.value){
            alert("날짜를 입력하세요.");
            return false;
        }
        
        if(isNaN(document.userInfo.birthdd.value)){
            alert("날짜는 숫자만 입력가능합니다.");
            return false;
        }
        
        if(!document.userInfo.phone.value){
            alert("전화번호를 입력하세요.");
            return false;
        }
        
        if(isNaN(document.userInfo.phone.value)){
            alert("전화번호는 - 제외한 숫자만 입력해주세요.");
            return false;
        }
        
        if(!document.userInfo.address.value){
            alert("주소를 입력하세요.");
            return false;
        }


    }

    // 취소 버튼 클릭시 첫화면으로 이동
    function goFirstForm() {
    	location.href="MainForm.do";
    }
    
   

 
    
   </script>	
</head>
<body>
		<br><br>
		<b><font size="6" color="gray">회원가입</font></b>
		<br><br><br>
		
		
		<!-- 입력한 값을 전송하기 위해 form 태그를 사용한다 -->
		<!-- 값(파라미터) 전송은 POST 방식, 전송할 페이지는 JoinPro.jsp -->
		<form method="post" action="MemberJoinAction.do" 
				name="userInfo" onsubmit="return checkValue()">
			<table>
				<tr>
					<td id="title">아이디</td>
					<td>
						<input type="text" name="id" maxlength="50" >
						<input type="button" value="중복확인"  >
					</td>
				</tr>
						
				<tr>
					<td id="title">비밀번호</td>
					<td>
						<input type="password" name="password" maxlength="50">
					</td>
				</tr>
				
				<tr>
					<td id="title">비밀번호 확인</td>
					<td>
						<input type="password" name="passwordcheck" maxlength="50">
					</td>
				</tr>
					
				<tr>
					<td id="title">이름</td>
					<td>
						<input type="text" name="name" maxlength="50">
					</td>
				</tr>
					
				<tr>
					<td id="title">성별</td>
					<td>
						<input type="radio" name="gender" value="남" checked>남
						<input type="radio" name="gender" value="여" >여
					</td>
				</tr>
					
				<tr>
					<td id="title">생일</td>
					<td>
						<input type="text" name="birthyy" maxlength="4" placeholder="년(4자)" size="6" >
						<select name="birthmm">
							<option value="">월</option>
							<option value="01" >1</option>
							<option value="02" >2</option>
							<option value="03" >3</option>
							<option value="04" >4</option>
							<option value="05" >5</option>
							<option value="06" >6</option>
							<option value="07" >7</option>
							<option value="08" >8</option>
							<option value="09" >9</option>
							<option value="10" >10</option>
							<option value="11" >11</option>
							<option value="12" >12</option>
						</select>
						<input type="text" name="birthdd" maxlength="2" placeholder="일" size="4" >
					</td>
				</tr>
					
				<tr>
					<td id="title">이메일</td>
					<td>
						<input type="text" name="mail1" maxlength="50">@
						<select name="mail2">
							<option>naver.com</option>
							<option>daum.net</option>
							<option>gmail.com</option>
							<option>nate.com</option>						
						</select>
					</td>
				</tr>
					
				<tr>
					<td id="title">휴대전화</td>
					<td>
						<input type="text" name="phone" />
					</td>
				</tr>
				<tr>
					<td id="title">주소</td>
					<td>
						<input type="text" size="50" name="address"/>
					</td>
				</tr>
			</table>
			<br>
			<input type="submit" value="가입"/>  
			<input type="button" value="취소" onclick="goFirstForm()">
		</form>
</body>
</html>