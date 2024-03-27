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
</head>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.7.1.min.js"></script>
<body>
<form>
<h2 style="margin-left: 10px">재료 수정</h2>
<fieldset style="border:0px">
<!-- 중복 되는 내용이 있을 시 해당 div 영역에 표시 -->
<div class="check"></div><br>
<div><b>재료명</b></div><input type="text" name="item_name"><br>
<sub></sub>
<div><b>유형</b></div>
<select name="item_type" class="item_type">
<option value="100">유형를 선택해주세요</option>
<option value="0">식품</option>
<option value="1">비식품</option>
</select><br>
<sub></sub>
<div><b>단가</b></div><input type="text" name="item_price" class="item_price"><br>
<sub></sub>
<div><b>적요</b></div><input type="text" name="od_note"><br>
<sub></sub>
<br>
<span style="float:right; margin-right: 50px">
<input type="submit" value="수정하기" style="background-color: black; color: #EFBDBC;"> | <button type="button" style="background-color: black; color: #EFBDBC;" onclick="location.href='${pageContext.request.contextPath}/emp/popup/close'">취소하기</button>
</span>
</fieldset>
</form>

<script type="text/javascript">
$('.form').submit(function(){

	if($('.item_name').val()=='' || $('.item_name').val()==null||$('.item_name').val()==undefined){
		alert('재료명을 입력해주세요.');
		$('.item_name').focus();
		return false;
	}
	
	if($('.item_type').val() == "100"){
		alert("유형을 선택하세요.");
		$('.item_type').focus();
		return false;
	}
	
	if($('.item_price').val()=='' || $('.item_price').val()==null||$('.item_price').val()==undefined){
		alert('단가를 입력해주세요.');
		$('.item_price').focus();
		return false;
	}
	
});

//화폐단위 ','
const input = document.querySelector('.item_price');
input.addEventListener('keyup', function(e) {
  let value = e.target.value;
  value = Number(value.replaceAll(',', ''));
  if(isNaN(value)) {
    input.value = 0;
  }else {
    const formatValue = value.toLocaleString('ko-KR');
    input.value = formatValue;
  }
})


</script>

</body>
</html>