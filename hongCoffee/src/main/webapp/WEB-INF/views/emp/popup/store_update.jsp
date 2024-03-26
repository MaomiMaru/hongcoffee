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
div{
	display: inline-block; width: 100px
}
</style>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.7.1.min.js"></script>
</head>
<body>
<form action="${pageContext.request.contextPath}/emp/popup/store_updatePro" method="post" class="form">
<h2 style="margin-left: 10px">지점 수정</h2>
<fieldset style="border:0px">
<div class="check"></div><br>
<div><b>지점번호</b></div><input type="text" name="num" readonly><br>
<sub></sub>
<div><b>지점명</b></div><input type="text" name="name" class="name"><br>
<sub></sub>
<div><b>비밀번호</b></div><input type="password" name="pw" class="pw"><br>
<sub></sub>
<div><b>대표자명</b></div><input type="text" name="boss" class="boss"><br>
<sub></sub>
<div><b>연락처</b></div><input type="tel" name="phone" class="phone"><br>
<sub></sub>
<div><b>이메일</b></div><input type="text" name="email" class="email"><br>
<sub></sub>
<div><b>주소</b></div><input type="text" name="address" class="address"><br>
<sub></sub>
<div><b>상태</b></div><input type="text" name="state"><br>
<sub></sub>
<div><b>적요</b></div><input type="text" name="note"><br>
<sub></sub>
<br>
<input type="submit" value="수정하기" style="float:right; margin-right: 50px; background-color: black; color: #EFBDBC;">
</fieldset>
</form>

<script type="text/javascript">


</script>


</body>
</html>