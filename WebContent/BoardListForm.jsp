<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%-- JSTL 버전으로 바뀌니,import 번잡함도 사라진다. JAVA 변수 선언도 사라진다 --%>


<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>글 목록</title>
<style>
table {width: 80%;}
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
	text-align: center;
}
</style>
</head>
<body>

		<hr>
		<h2>리스트</h2>
		<table>
			<tr>
				<th>UID</th>
				<th>제목</th>
				<th>작성자</th>
				<th>조회수</th>
				<th>등록일</th>
			</tr>
		<c:choose>
			<c:when test="${empty list || fn:length(list)==0 }">
			</c:when>
			<c:otherwise>
			
			<c:forEach var="dto" items="${list }">
				<tr>
					<td>${dto.num }</td>
					<td><a href="BoardViewForm.bo?num=${dto.num }">${dto.subject }</a></td>
					<td>${dto.id}</td>
					<td>${dto.count }</td>
					<td>${dto.date }</td>
				</tr>
			</c:forEach>
			</c:otherwise>
		</c:choose>

		</table>
		<br>
		<button onclick="location.href='BoardWriteForm.bo'">신규등록</button>
		<button onclick="location.href='MainForm.jsp'">메인화면</button>

</body>
</html>



