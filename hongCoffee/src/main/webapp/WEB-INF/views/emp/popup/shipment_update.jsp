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
<form action="${pageContext.request.contextPath}/emp/popup/shipment_updatePro" method="post" class="form">
<h2 style="margin-left: 10px">출하 수정</h2>
<fieldset style="border:0px">
<!-- 중복 되는 내용이 있을 시 해당 div 영역에 표시 -->
<div class="check"></div><br>
<input type="hidden" name="od_num" value="${shipmentDTO.od_num}">
<input type="hidden" name="num" value="${shipmentDTO.num}">
<input type="hidden" name="item_num" value="${shipmentDTO.item_num}">
<div><b>지점명</b></div><input type="text" name="name" value="${shipmentDTO.name }" class="name" readonly><br>
<sub></sub>
<div><b>재료명</b></div><input type="text" name="item_name" value="${shipmentDTO.item_name }" class="item_name" readonly><br>
<sub></sub>
<div><b>출하량</b></div><input type="text" name="sh_amount" value="${shipmentDTO.sh_amount }" class="sh_amount"><br>
<sub></sub>
<div><b>단가</b></div><input type="text" name="item_price" value="${shipmentDTO.item_price }" class="item_price" readonly><br>
<sub></sub>
<div><b>출하일시</b></div><input type="datetime-local" name="sh_time" class="sh_time" style="width: 177px"><br>
<sub></sub>
<div><b>적요</b></div><input type="text" name="sh_note" class="sh_note"><br>
<sub></sub>
<br>
<span style="float:right; margin-right: 50px">
<input type="submit" value="수정하기" style="background-color: black; color: #EFBDBC;"> | <button type="button" style="background-color: black; color: #EFBDBC;" onclick="location.href='${pageContext.request.contextPath}/emp/popup/close'">취소하기</button>
</span>
</fieldset>
</form>

<script type="text/javascript">

$('.form').submit(function(){
	
	if($('.sh_amount').val()=='' || $('.sh_amount').val()==null||$('.sh_amount').val()==undefined){
		alert('출하량을 입력해주세요.');
		$('.sh_amount').focus();
		return false;
	}
	
	if($('.sh_time').val()=='' || $('.sh_time').val()==null||$('.sh_time').val()==undefined){
		alert('출하일시를 입력해주세요.');
		$('.sh_time').focus();
		return false;
	}
	
});


</script>

</body>
</html>