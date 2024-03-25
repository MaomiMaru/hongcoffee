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
<form action="${pageContext.request.contextPath}/emp/popup/emp_updatePro" method="post" class="form">
<h3 style="margin-left: 10px">사원 추가</h3>
<fieldset style="margin-top : 70px; border:0px">
<table>
<tr><th>사원번호</th><td><input type="text" name="emp_num" readonly></tr> 
<tr><th>비밀번호</th><td><input type="password" name="emp_pw"></tr> 
<tr><th>사원명</th><td><input type="text" name="emp_name"></td>
<tr><th>생년월일</th><td><input type="date" name="emp_birth" readonly><td>
<tr><th>부서</th><td><input type="text" name="emp_dept" value="${sessionScope.emp_dept}" readonly>
<tr><th>직급</th><td><input type="text" name="emp_rank" value="${sessionScope.emp_rank}" readonly>
<tr><th>연락처</th><td><input type="tel" name="emp_phone"></tr>
<tr><th>이메일</th><td><input type="email" name="emp_email"></tr>
<tr><th>입사일</th><td><input type="date" name="hire_date" readonly></tr>
</table>
<br>
<input type="submit" value="수정하기" style="float:right; margin-right: 75px; background-color: black; color: #EFBDBC;">
</fieldset>
</form>
</div>
</body>
</html>