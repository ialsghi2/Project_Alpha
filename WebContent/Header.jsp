<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>상단 영역</title>
	
	<link rel="stylesheet" href="CSS/bootstrap_min.css">
	
	<style type="text/css">
		#wrap{
			text-align: center;
			width: 800px;
			height: 150px;
		}
	</style>
	
	<script type="text/javascript">
		
		function changeView(value){
			
			if(value == "0") // HOME 버튼 클릭시 첫화면으로 이동
			{
				location.href="MainForm.do";
			}
			else if(value == "1") // 로그인 버튼 클릭시 로그인 화면으로 이동
			{
				location.href="LoginForm.do";
			}
			else if(value == "2") // 회원가입 버튼 클릭시 회원가입 화면으로 이동
			{
				location.href="JoinForm.do";
			}
			else if(value == "3") // 로그아웃 버튼 클릭시 로그아웃 처리
			{
				location.href="MemberLogoutAction.do";
			}
			else if(value == "4") // 내정보 버튼 클릭시 회원정보 보여주는 화면으로 이동
			{
				location.href="MemberInfoAction.do";
			}
			else if(value == "5")
			{
				location.href="MemberListAction.do";		
			}
			else if(value == "6")
            {
                location.href="BoardListForm.bo";
            }


		}
	</script>
	
</head>
<body>
	<div id = "wrap">
		<p>
			<button class="btn btn-success" onclick="changeView(0)">HOME</button>
		<%
			// 로그인 안되었을 경우 - 로그인, 회원가입 버튼을 보여준다.
			if(session.getAttribute("sessionID")==null){ 
		%>
			<button id="loginBtn" class="btn btn-primary" onclick="changeView(1)">로그인</button>
			<button id="joinBtn" class="btn btn-primary" onclick="changeView(2)">회원가입</button>
			
		<%
			// 로그인 되었을 경우 - 로그아웃, 내정보 버튼을 보여준다.
			}else{ 
		%>
			<button id="logoutBtn" class="btn btn-primary" onclick="changeView(3)">로그아웃</button>
			<button id="updateBtn" class="btn btn-primary" onclick="changeView(4)">내정보</button>
		<%	}	%>	
		
		    <button id="joinBtn" class="btn btn-info" onclick="changeView(6)">게시판</button>
		
        <%
            // 관리자 로그인
            if(session.getAttribute("sessionID")!=null && session.getAttribute("sessionID").equals("admin")){ 
        %>
			<button id="memberViewBtn" class="btn btn-warning" onclick="changeView(5)">회원보기</button>
			
		<% 	} %>
		</p>
	</div>
</body>
</html>