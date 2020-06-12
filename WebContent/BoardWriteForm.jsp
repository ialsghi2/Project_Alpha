<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
    <title>게시판 - 글쓰기</title>
    
    <style type="text/css">
        #title{
            height : 16;
            font-family :'돋움';
            font-size : 12;
            text-align :center;
        }
    </style>
    
</head>
<script>
function chkSubmit() { // 폼 검증
	frm = document.forms["frm"];
	
	
	var subject = frm["subject"].value.trim();
	
	
	if(subject == "") {
		alert("제목은 반드시 작성해야 합니다");
		frm["subject"].focus();
		return false;
	}
	
	return true;
}

</script>
<body>
 
    <br>
    <b><font size="6" color="gray">글쓰기</font></b>
    <br>
    
 	<form method="post" action="BoardWriteOk.bo" name="frm" onsubmit="return chkSubmit()">
    <input type="hidden" name="id" value="${sessionScope.sessionID}">
    <table width="700" border="3" bordercolor="lightgray" align="center">
        <tr>
            <td id="title">작성자</td>
            <td>${sessionScope.sessionID}</td>
        </tr>
            <tr>
            <td id="title">
                제 목
            </td>
            <td>
                <input name="subject" type="text" size="70" maxlength="100" value=""/>
            </td>        
        </tr>
        <tr>
            <td id="title">
                내 용
            </td>
            <td>
                <textarea name="content" cols="72" rows="20"></textarea>            
            </td>        
        </tr>
     
 
        <tr align="center" valign="middle">
            <td colspan="5">
                <input type="submit" value="등록" >
            </td>
        </tr>
    </table>    
    </form>
	<button onclick="history.back()">이전으로</button>
	<button type="button" onclick="location.href='BoardListForm.bo'">목록으로</button>
    
</body>
</html>


