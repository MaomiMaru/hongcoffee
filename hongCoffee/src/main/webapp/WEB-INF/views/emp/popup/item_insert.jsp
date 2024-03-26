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
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.7.1.min.js"></script>
</head>
<body>
<form action="${pageContext.request.contextPath}/emp/popup/item_insertPro" method="post" class="form">
<h2 style="margin-left: 10px">품목 추가</h2>
<fieldset style="border:0px">
<!-- 중복 되는 내용이 있을 시 해당 div 영역에 표시 -->
<div class="check"></div><br>
<div>재료명</div><input type="text" name="item_name"><br>
<sub></sub>
<div>유형</div><input type="text" name="item_type"><br>
<sub></sub>
<div>단가</div><input type="text" name="item_price"><br>
<sub></sub>
<div>적요</div><input type="text" name="od_note"><br>
<sub></sub>
<br>
<input type="submit" value="추가하기" style="float:right; margin-right: 50px; background-color: black; color: #EFBDBC;">
</fieldset>
</form>

<script type="text/javascript">



</script>

</body>
</html>