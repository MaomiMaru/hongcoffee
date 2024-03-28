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
<form action="${pageContext.request.contextPath}/emp/popup/shipment_insertPro" method="post" class="form">
<h2 style="margin-left: 10px">출하 추가</h2>
<fieldset style="border:0px">
<!-- 중복 되는 내용이 있을 시 해당 div 영역에 표시 -->
<div class="check"></div><br>
<div><b>지점명</b></div><input type="text" name="name" class="name"><br>
<sub></sub>
<div><b>재료명</b></div><input type="text" name="item_name" class="item_name"><br>
<sub></sub>
<div><b>출하량</b></div><input type="text" name="" class=""><br>
<sub></sub>
<div><b>단가</b></div><input type="text" name="item_price" class="item_price"><br>
<sub></sub>
<div><b>출하일시</b></div><input type="date" name="" class="" style="width: 177px"><br>
<sub></sub>
<div><b>적요</b></div><input type="text" name="" class=""><br>
<sub></sub>
<br>
<input type="submit" value="추가하기" style="float:right; margin-right: 50px; background-color: black; color: #EFBDBC;">
</fieldset>
</form>

<script type="text/javascript">

</script>

</body>
</html>