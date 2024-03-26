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
<form action="${pageContext.request.contextPath}/emp/popup/order_insertPro" method="post" class="form">
<h2 style="margin-left: 10px">발주 추가</h2>
<fieldset style="border:0px">
<!-- 중복 되는 내용이 있을 시 해당 div 영역에 표시 -->
<div class="check"></div><br>
<div><b></b></div>
<sub></sub>

<tr><th>재료명</th><td><input type="text" name="item_name"><td> 
<tr><th>단가</th><td><input type="text" name="item_price"><td>
<tr><th>발주량</th><td><input type="text" name="od_amount"><td>
<tr><th>적요</th><td><input type="text" name="od_note"><td>
</table>
<input type="submit" value="추가하기">
</fieldset>
</form>

<script type="text/javascript">

</script>
</body>
</html>