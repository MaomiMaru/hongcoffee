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
<form action="${pageContext.request.contextPath}/emp/popup/emp_updatePro" method="post" class="form">
<h2 style="margin-left: 10px">사원 수정</h2>
<fieldset style="border:0px">
<!-- 중복 되는 내용이 있을 시 해당 div 영역에 표시 -->
<div class="check"></div><br>
<div><b>사원번호</b></div><input type="text" name="emp_num" value="${employeeDTO.emp_num}" readonly><br>
<sub></sub>
<div><b>비밀번호</b></div><input type="password" name="emp_pw" value="${employeeDTO.emp_pw }"><br>
<sub></sub>
<div><b>사원명</b></div><input type="text" name="emp_name" value="${employeeDTO.emp_name}"><br>
<sub></sub>
<div><b>생년월일</b></div><input type="text" name="emp_birth" value="${employeeDTO.emp_birth}" readonly style="width: 177px"><br>
<sub></sub>
<div><b>부서</b></div><input type="text" name="emp_dept" value="${employeeDTO.emp_dept}" readonly><br>
<sub></sub>
<div><b>직급</b></div><input type="text" name="emp_rank" value="${employeeDTO.emp_rank}" readonly><br>
<sub></sub>
<div><b>연락처</b></div><input type="tel" name="emp_phone" value="${employeeDTO.emp_phone}"><br>
<sub></sub>
<div><b>이메일</b></div><input type="email" name="emp_email" value="${employeeDTO.emp_email }"><br>
<sub></sub>
<div><b>입사일</b></div><input type="text" name="hire_date" value="${employeeDTO.hire_date }" readonly ><br>
<sub></sub>
<br>
<span style="float:right; margin-right: 50px">
<input type="submit" value="수정하기" style="background-color: black; color: #EFBDBC;"> | <button type="button" style="background-color: black; color: #EFBDBC;" onclick="location.href='${pageContext.request.contextPath}/emp/popup/close'">취소하기</button>
</span>
</fieldset>
</form>
</body>
</html>