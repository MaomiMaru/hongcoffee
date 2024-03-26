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
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.7.1.min.js"></script>
</head>
<body>
<div class="container">
<form>
<h3 style="margin-left: 10px">재고 수정</h3>
<fieldset style="margin-top : 100px; border:0px">
<table>
<tr><th>유형</th><td><input type="text" name="item_type" readonly><td> 
<tr><th>재료명</th><td><input type="text" name="item_name" readonly><td>
<tr><th>단가</th><td><input type="text" name="item_price" readonly><td>
<tr><th>재고량</th><td><input type="text" name="amount"><td>
<tr><th>적요</th><td><input type="text" name="stock_note"><td><br>
</table>
<input type="submit" value="수정하기">
</fieldset>
</form>
</div>
<!-- 버튼 -->
<!-- <button onclick="window.open('http://www.naver.com','_blank','width=700, height=600, top=50, left=50, scrollbars=yes')">팝업 열기</button> -->
</body>
</html>