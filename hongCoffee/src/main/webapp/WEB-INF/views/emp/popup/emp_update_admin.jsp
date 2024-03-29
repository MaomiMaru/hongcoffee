<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<form action="${pageContext.request.contextPath}/emp/popup/emp_updateProAdmin" method="post" class="form">
<h2 style="margin-left: 10px">사원 수정</h2>
<fieldset style="border:0px">
<!-- 중복 되는 내용이 있을 시 해당 div 영역에 표시 -->
<div class="check"></div><br>
<div><b>사원번호</b></div><input type="text" name="emp_num" value="${employeeDTO.emp_num }" readonly><br>
<sub></sub>
<div><b>비밀번호</b></div><input type="password" name="emp_pw" value="${employeeDTO.emp_pw }"><br>
<sub></sub>
<div><b>사원명</b></div><input type="text" name="emp_name" value="${employeeDTO.emp_name }"><br>
<sub></sub>
<div><b>생년월일</b></div><input type="date" name="emp_birth" style="width: 177px" value="${employeeDTO.emp_birth }"><br>
<sub></sub>
<div><b>부서</b></div>
<select name="emp_dept">
<option value="0" <c:if test="${employeeDTO.emp_dept eq '0'}"> selected </c:if>>무소속</option>
<option value="1" <c:if test="${employeeDTO.emp_dept eq '1'}"> selected </c:if>>인사팀</option>
<option value="2" <c:if test="${employeeDTO.emp_dept eq '2'}"> selected </c:if>>영업팀</option>
<option value="3" <c:if test="${employeeDTO.emp_dept eq '3'}"> selected </c:if>>재무팀</option>
</select><br>
<sub></sub>
<div><b>직급</b></div>
<select name="emp_rank">
<option value="0" <c:if test="${employeeDTO.emp_rank eq '0'}"> selected </c:if>>무보직</option>
<option value="4" <c:if test="${employeeDTO.emp_rank eq '4'}"> selected </c:if>>사원</option>
<option value="3" <c:if test="${employeeDTO.emp_rank eq '3'}"> selected </c:if>>대리</option>
<option value="2" <c:if test="${employeeDTO.emp_rank eq '2'}"> selected </c:if>>팀장</option>
<option value="1" <c:if test="${employeeDTO.emp_rank eq '1'}"> selected </c:if>>대표</option>
</select><br>
<sub></sub>
<div><b>권한</b></div>
<select name="emp_right">
<option value="0" <c:if test="${employeeDTO.emp_right eq '0'}"> selected </c:if>>사원</option>
<option value="1" <c:if test="${employeeDTO.emp_right eq '1'}"> selected </c:if>>관리자</option>
</select><br>
<sub></sub>
<div><b>연락처</b></div><input type="tel" name="emp_phone" value="${employeeDTO.emp_phone }"><br>
<sub></sub>
<div><b>이메일</b></div><input type="email" name="emp_email" value="${employeeDTO.emp_email }"><br>
<sub></sub>
<div><b>입사일</b></div><input type="date" name="hire_date" style="width: 177px" value="${employeeDTO.hire_date }"><br>
<sub></sub>
<div><b>상태</b></div>
<select name="emp_state">
<option value="0" <c:if test="${employeeDTO.emp_state eq '0'}"> selected </c:if>>재직</option>
<option value="1" <c:if test="${employeeDTO.emp_state eq '0'}"> selected </c:if>>휴직</option>
<option value="2" <c:if test="${employeeDTO.emp_state eq '0'}"> selected </c:if>>퇴직</option>
</select><br>
<sub></sub>
<b>적요</b><textarea rows="30" cols="37" name="emp_note"></textarea><br>
<sub></sub>
<br>
<span style="float:right; margin-right: 50px">
<input type="submit" value="등록하기" style="background-color: black; color: #EFBDBC;"> | <button type="button" style="background-color: black; color: #EFBDBC;" onclick="location.href='${pageContext.request.contextPath}/emp/popup/close'">취소하기</button>
</span>
</fieldset>
</form>

<script type="text/javascript">



</script>


</body>
</html>