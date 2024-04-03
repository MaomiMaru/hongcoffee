<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>홍커피</title>
<style>
.container{
text-align: center;
}
.inner{
text-align: center;
}
.employee_num, .employee_pw{
background-color: #EEEEEE;
}
</style>
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.7.1.min.js"></script>
<link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/imgs/logo.png" />
</head>
<body>
<div class="container">
<img src="${pageContext.request.contextPath}/resources/imgs/logo.png" width="265" height="265" alt="Hong Coffee"><br>
<div class="loginform">
<form action="${pageContext.request.contextPath}/emp/loginPro" method="post" id="login">
<label></label>
<div id="checkdiv"></div>
<div class="inner">
<label>사원번호</label>
<input type="text" name="emp_num" class="emp_num"><br>
<label>비밀번호</label>
<input type="password" name="emp_pw" class="emp_pw"><br>
<input type="submit" value="로그인" class="submit" style="margin-left: 70px; width: 177px; background-color: #C9DAF8">
<hr width="315">
<input type="checkbox" class="rememberCheck">사원번호 기억하기
</div>
</form>
</div>
</div>




<script type="text/javascript">

	$(function(){
		$('#login').submit(function(){
		if($('.emp_num').val() === ''|| $('.emp_num').val === null || $('.emp_num').val === undefined){
			$('#checkdiv').html("사원번호를 입력해주세요.").css("color","red");
			$('.emp_num').focus();
			return false;
		}
		if($('.emp_pw').val() === ''|| $('.emp_pw').val === null || $('.emp_pw').val === undefined){
			$('#checkdiv').html("비밀번호를 입력해주세요.").css("color","red");
			$('.emp_pw').focus();
			return false;
		}
	});
});




</script>

</body>
</html>