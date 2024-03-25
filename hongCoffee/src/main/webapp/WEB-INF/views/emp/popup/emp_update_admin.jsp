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
<h3 style="margin-left: 10px">사원 수정</h3>
<fieldset style="margin-top : 100px; border:0px">
<table>
<tr><th>사원번호</th><td><input type="text" name="emp_num"></tr> 
<tr><th>비밀번호</th><td><input type="password" name="emp_pw"></tr> 
<tr><th>사원명</th><td><input type="text" name="emp_name"></td>
<tr><th>생년월일</th><td><input type="date" name="emp_birth"><td>
<tr><th>부서</th><td>
<select name="emp_dept">
<option value="">선택해주세요.</option>
<option value="1">인사팀</option>
<option value="2">영업팀</option>
<option value="3">재무팀</option>
</select>
<tr><th>직급</th><td>
<select name="emp_rank">
<option value="">선택해주세요.</option>
<option value="사원">사원</option>
<option value="대리">대리</option>
<option value="팀장">팀장</option>
<option value="대표">대표</option>
</select>
<tr><th>권한</th><td>
<select name="emp_right">
<option value="">선택해주세요.</option>
<option value="1">관리자</option>
<option value="0">사원</option>
</select>
<tr><th>연락처</th><td><input type="tel" name="emp_phone"></tr>
<tr><th>이메일</th><td><input type="email" name="emp_email"></tr>
<tr><th>입사일</th><td><input type="date" name="hire_date"></tr>
<tr><th>상태</th><td>
<select name="emp_state">
<option value="">선택해주세요.</option>
<option value="0">재직</option>
<option value="1">휴직</option>
<option value="2">퇴직</option>
</select>
</tr>
<tr><th>적요</th><td><input type="text" name="emp_note"><td>
</table>
<input type="submit" value="등록하기">
</fieldset>
</form>
</div>
</body>
</html>