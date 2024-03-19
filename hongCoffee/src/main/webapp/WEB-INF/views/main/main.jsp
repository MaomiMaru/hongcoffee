<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<style>
.top{
width: 100%;
height: 70px;
background: red;
}

.sidebar{
width: 280px;
height: 1500px;
float: left;
background: blue;
}

.main{
width: calc(100% - 280px);
height: 1450px;
float: left;
background: yellow;
}

.footer{
width: calc(100% - 280px);
height: 50px;
float: left;
background: purple;
}

</style>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<div class="top">
a

</div>

<div class="sidebar">
b

</div>

<div class="main">
c
</div>

<div class="footer">
d
</div>

</body>
</html>