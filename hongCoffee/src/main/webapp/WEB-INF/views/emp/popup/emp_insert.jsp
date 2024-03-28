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
select{
	width: 177px;
}

</style>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.7.1.min.js"></script>
</head>
<body>
<form action="${pageContext.request.contextPath}/emp/popup/emp_insertPro" method="post" class="form">
<h2 style="margin-left: 10px">사원 추가</h2>
<fieldset style="border:0px">
<!-- 중복 되는 내용이 있을 시 해당 div 영역에 표시 -->
<div class="check"></div><br>
<div><b>사원번호</b></div><input type="text" name="emp_num"><br>
<sub></sub>
<div><b>비밀번호</b></div><input type="password" name="emp_pw"><br>
<sub></sub>
<div><b>사원명</b></div><input type="text" name="emp_name"><br>
<sub></sub>
<div><b>생년월일</b></div><input type="date" name="emp_birth" style="width: 177px"><br>
<sub></sub>
<div><b>부서</b></div>
<select name="emp_dept">
<option value="">선택해주세요.</option>
<option value="1">인사팀</option>
<option value="2">영업팀</option>
<option value="3">재무팀</option>
</select><br>
<sub></sub>
<div><b>직급</b></div>
<select name="emp_rank">
<option value="" >선택해주세요.</option>
<option value="사원">사원</option>
<option value="대리">대리</option>
<option value="팀장">팀장</option>
<option value="대표">대표</option>
</select><br>
<sub></sub>
<div><b>권한</b></div>
<select name="emp_right">
<option value="">선택해주세요.</option>
<option value="1">관리자</option>
<option value="0">사원</option>
</select><br>
<sub></sub>
<div><b>연락처</b></div><input type="tel" name="emp_phone"><br>
<sub></sub>
<div><b>이메일</b></div><input type="email" name="emp_email"><br>
<sub></sub>
<div><b>입사일</b></div><input type="date" name="hire_date" style="width: 177px"><br>
<sub></sub>
<div><b>적요</b></div><input type="text" name="emp_note"><br>
<sub></sub>
<br>
<input type="submit" value="등록하기" style="float:right; margin-right: 50px; background-color: black; color: #EFBDBC;"> | <button type="button" style="background-color: black; color: #EFBDBC;" onclick="location.href='${pageContext.request.contextPath}/emp/popup/close'">취소하기</button>
</fieldset>
</form>

<script type="text/javascript">



</script>

</body>
</html>