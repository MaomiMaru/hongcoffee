<!-- 보류 -->
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
 } gyeolje
</style>
</head>
<body>
<div class="container">
<form>
<h3 style="margin-left: 10px">결제</h3>
<fieldset style="margin-top : 100px; border:0px">
<table>
<tr><th>재료명</th><td><input type="text" name="item_name"><td>
<tr><th>수량</th><td><input type="text" name="od_amount"><td>
<tr><th>단가</th><td><input type="text" name="item_price"><td><br>
</table>
<input type="submit" value="결제하기">
</fieldset>
</form>
</div>
<!-- 버튼 -->
<!-- <button onclick="window.open('http://www.naver.com','_blank','width=700, height=600, top=50, left=50, scrollbars=yes')">팝업 열기</button> -->
</body>
</html>