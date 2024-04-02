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
<form action="${pageContext.request.contextPath}/store/popup/stock_updatePro" method="post" class="form">
<h2 style="margin-left: 10px">재고 수정</h2>
<fieldset style="border:0px">
<!-- 중복 되는 내용이 있을 시 해당 div 영역에 표시 -->

				<div>
					<b>유형</b>
				</div>
					<input type="text" value="${stockDTO.item_type}" name="item_type" readonly ><br>
				<div>
					<b>재료명</b>
				</div>
					<input type="text" value="${stockDTO.item_name}" name="item_name" readonly ><br>
			<div>
				<b>단가</b>
			</div>
			<input type="text" name="item_price" id="item_price" value="${stockDTO.item_price}" readonly><br>
			<div>
				<b>보유량</b>
			</div>
			<input type="text" name="amount" class="amount" value="${stockDTO.amount}"><br>
			<div>
				<b>적요</b>
			</div>
			<textarea name="stock_note" cols="" rows="">${stockDTO.stock_note }</textarea><br>

<span style="float:right; margin-right: 50px">
<input type="submit" value="수정하기" style="background-color: black; color: #EFBDBC;"> | <button type="button" style="background-color: black; color: #EFBDBC;" onclick="location.href='${pageContext.request.contextPath}/store/popup/close'">취소하기</button>
</span>
</fieldset>
</form>

<script type="text/javascript">

</script>
</body>
</html>