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
<form action="${pageContext.request.contextPath}/store/popup/receive_insertPro" method="post" class="form">
<h2 style="margin-left: 10px">입고 추가</h2>
<fieldset style="border:0px">
<!-- 중복 되는 내용이 있을 시 해당 div 영역에 표시 -->
<input type="hidden" name="od_num" value="${orderDTO.od_num}">
<input type="hidden" name="num" value="${orderDTO.num}">
<div class="check"></div><br>
<div><b>유형</b></div>
<input type="text" name="item_type" value="${orderDTO.item_type}" readonly>
<sub></sub><br>
<div><b>재료명</b></div><input type="text" name="item_name" value="${orderDTO.item_name}" readonly><br>
<sub></sub>
<div><b>단가</b></div><input type="text" name="item_price" value="${orderDTO.item_price}" readonly><br>
<sub></sub>
<div><b>입고량</b></div><input type="text" name="rc_amount" value="${orderDTO.od_amount}"><br>
<sub></sub>
<div><b>적요</b></div><input type="text" name="rc_note" value="${orderDTO.od_note}"><br>
<sub></sub>
<span style="float:right; margin-right: 50px">
<input type="submit" value="추가하기" style="background-color: black; color: #EFBDBC;"> | <button type="button" style="background-color: black; color: #EFBDBC;" onclick="location.href='${pageContext.request.contextPath}/emp/popup/close'">취소하기</button>
</span>
</fieldset>
</form>

<script type="text/javascript">
$(function() {
	$('.form').submit(
			function() {
				if ($('.rc_amount').val() == ""
						|| $('.rc_amount').val() == null
						|| $('.rc_amount').val() == undefined) {
					alert("입고량을 입력해주세요");
					$('.rc_amount').focus();
					return false;
				}
			});
});
</script>
</body>
</html>