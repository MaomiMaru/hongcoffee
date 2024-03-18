<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
<style>

</style>
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.7.1.min.js"></script>
</head>
<body>
<article>
<h1 align="center">회원가입</h1>
<form action="${pageContext.request.contextPath}/main/insertPro" method="post" id="insert">
<fieldset>
<legend>Main Info</legend>
<div id="logo"><img src="${pageContext.request.contextPath}/resources/imgs/logo.png" width="265" height="265" alt="Hong Coffee"></div>
<label></label>
<div id="checkdiv"></div>
<label>부서</label>
<select name="department_id">
<option value="1">미정</option>
<option value="2">판매</option>
<option value="3">인사</option>
<option value="4">관리</option>
</select>
<label>직급</label>
<select name="grade">
<option value="1">미정</option>
<option value="2">사원</option>
<option value="3">대리</option>
<option value="4">과장</option>
<option value="5">부장</option>
</select>
<label>사원번호</label>
<input type="text" name="employee_num" class="employee_num"><br>
<label>비밀번호</label>
<input type="password" name="employee_pw" class="employee_pw"><br>
<label>비밀번호 확인</label>
<input type="password" name="employee_pw2" class="employee_pw2"><br>
<label>이름</label>
<input type="text" name="employee_name" class="employee_name"><br>

</fieldset>
<div class="clear"></div>
<div id="buttons">
<input type="submit" value="로그인" class="submit">
</div>
</form>
</article>

<script type="text/javascript">



</script>
</body>
</html>