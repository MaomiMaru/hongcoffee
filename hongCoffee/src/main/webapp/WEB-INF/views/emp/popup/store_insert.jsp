<!-- 정규표현식 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
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
<form action="${pageContext.request.contextPath}/emp/popup/store_insertPro" method="post" class="form">
<h2 style="margin-left: 10px">지점 추가</h2>
<fieldset style="border:0px">
<!-- 중복 되는 내용이 있을 시 해당 div 영역에 표시 -->
<div class="check"></div><br>
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
<div><b>상태</b></div>
<select name="state">
<option>상태를 선택해주세요</option>
<option value="0">정상영업</option>
<option value="1">미영업</option>
<option value="2">폐업</option>
</select><br>
<sub></sub>
<div><b>적요</b></div><input type="text" name="note"><br>
<sub></sub>
<br>
<input type="submit" value="추가하기" style="float:right; margin-right: 50px; background-color: black; color: #EFBDBC;">
</fieldset>
</form>

<script type="text/javascript">
$(function(){
	$('.join').submit(function(){

		//지점명 : 한글 2자 이상 20자 이하	
		var nameCheck = RegExp(/^[가-핳]{4,20}$/);
		if( ! nameCheck.test($('.name').val()) ){
				alert("한글 2자이상 20자이하만 입력 가능합니다.");
				$('.name').focus();
				return false;
			}
			
		
		//비밀번호 : 영문 대소문자 + 숫자 + 특수문자 1개 이상씩 4자 이상 20자 이하
		var pwCheck = RegExp(/^(?=.*[a-zA-Z])(?=.*\d)(?=.*[@$!%*?&#.~_-])[A-Za-z\d@$!%*?&#.~_-]{4,20}$/);
			if( ! pwCheck.test($('.pw').val()) ){
				alert("영문 대소문자 하나, 숫자 하나, 특수문자 1개가 포함되어야합니다.");
				$('.pw').focus();
				return false;
			}	
			
		//이름 : 한글 2~20자
		var bossCheck = RegExp(/^[가-힣]{2,6}$/);
			if( ! bossCheck.test($('.boss').val()) ){
				alert("한글 2자 이상 6자 이하만 입력가능합니다.");
				$('.boss').focus();
				return false;
			}
			
		//이메일 => 아이디@주소
		var emailCheck = RegExp(/^[a-zA-Z0-9_\.\-]+@[a-zA-Z0-9\-]+\.[a-zA-Z0-9\-]/);
			if( ! emailCheck.test($('.email').val()) ){
				alert("이메일 형식이 아닙니다.");
				$('.email').focus();
				return false;
			}
			
		//select 상자
		if($('.state').val() == ""){
				alert("상태를 선택하세요.");
				$('.state').focus();
				return false;
			}

		
	});
	
});
	
	$(".phone").on('keydown keyup',function() {
        this.value = this.value.replace(/[^0-9]/g, '');

        var str = this.value;
        var tmp = '';
        var bullet = '-';

        if (str.length > 3 && str.length < 8) {
            tmp += str.substr(0, 3);
            tmp += bullet;
            tmp += str.substr(3);
            this.value = tmp;
        } else if (str.length == 8) {
            tmp += str.substr(0, 4);
            tmp += bullet;
            tmp += str.substr(4);
            this.value = tmp;
        } else if (str.length == 10) {
            tmp += str.substr(0, 2);
            tmp += bullet;
            tmp += str.substr(2, 4);
            tmp += bullet;
            tmp += str.substr(6); // 10자리일때
            this.value = tmp;
        } else if (str.length > 8) {
            tmp += str.substr(0, 3);
            tmp += bullet;
            tmp += str.substr(3, 4);
            tmp += bullet;
            tmp += str.substr(7, 4);
            this.value = tmp;
        } else {
            this.value = str;
        }
    });

</script>

</body>
</html>