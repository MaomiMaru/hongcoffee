<!-- 정규표현식 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>홍커피</title>
<link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/imgs/logo.png" />
<style>
.container{
	height: 500px;
	width: 350px;
	border: 1px solid;
 
}

/* 텍스트 왼쪽 정렬 */
 th{
 	text-align: left;
 } 
</style>
</head>
<body>
<div class="container">
<form>
<h3 style="margin-left: 10px">지점 수정</h3>
<fieldset style="margin-top : 100px; border:0px">
<table>
<tr><th>지점번호</th><td><input type="text" name="num" readonly><td> 
<tr><th>지점명</th><td><input type="text" name="name"><td>
<tr><th>대표자명</th><td><input type="text" name="boss"><td>
<tr><th>연락처</th><td><input type="tel" name="phone"><td>
<tr><th>이메일</th><td><input type="text" name="email"><td>
<tr><th>주소</th><td><input type="text" name="address"><td>
<tr><th>상태</th><td><input type="text" name="state"><td>
<tr><th>적요</th><td><input type="text" name="note"><td>
</table>
<input type="submit" value="수정하기">
</fieldset>
</form>
</div>
</body>
</html>