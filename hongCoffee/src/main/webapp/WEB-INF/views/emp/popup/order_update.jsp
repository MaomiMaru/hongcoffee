<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
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
<form action="${pageContext.request.contextPath}/emp/popup/order_updatePro" method="post" class="form">
<h2 style="margin-left: 10px">수주 수정</h2>
<fieldset style="border:0px">
<!-- 중복 되는 내용이 있을 시 해당 div 영역에 표시 -->
<div class="check"></div><br>
<input type="hidden" name="od_num" value="${orderDTO.od_num}"> 
<div><b>지점명</b></div><input type="text" name="name" value="${orderDTO.name}"><br>
<sub></sub>
<div><b>재료명</b></div><input type="text" name="item_name" value="${orderDTO.item_name}"><br>
<sub></sub>
<div><b>수주량</b></div><input type="text" name="od_amount" value="${orderDTO.od_amount}"><br>
<sub></sub>
<div><b>수주일시</b></div><input type="text" name="od_time" value="<fmt:formatDate value="${orderDTO.od_time}" pattern="yyyy-MM-dd HH:mm:ss"/>" readonly><br>
<sub></sub>
<div><b>입고여부</b></div>
<select name="received_not" style="width: 177px">
<option value="0" <c:if test="${storeDTO.received_not eq '0'}"> selected </c:if>>미입고</option>
<option value="1" <c:if test="${storeDTO.received_not eq '1'}"> selected </c:if>>입고완료</option>
</select><br>
<sub></sub>
<b>적요</b><br><textarea rows="30" cols="37" name="ob_note">${orderDTO.ob_note}</textarea><br>
<sub></sub>
<br>
<span style="float:right; margin-right: 50px">
<input type="submit" value="수정하기" style="background-color: black; color: #EFBDBC;"> | <button type="button" style="background-color: black; color: #EFBDBC;" onclick="location.href='${pageContext.request.contextPath}/emp/popup/close'">취소하기</button>
</span>
</fieldset>
</form>

<script type="text/javascript">



</script>

</body>
</html>