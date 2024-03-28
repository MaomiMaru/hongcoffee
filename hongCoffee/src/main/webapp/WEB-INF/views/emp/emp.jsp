<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<!DOCTYPE html>
<html lang="ko">
<!-- 목록 스타일 템플릿 -->
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

<style>
/* 항목 스타일 */
.sidebar .nav:not(.sub-menu) > .nav-item.active{
   background: #EFBDBC !important;
}
.sidebar .nav .nav-item.active > .nav-link
{
    background: #EFBDBC !important;
}
.sidebar .nav.sub-menu {
    margin-bottom: 0;
    margin-top: 0;
    list-style: none;
    padding: 0.25rem 0 0 3.07rem;
    background: #EFBDBC !important;
    padding-bottom: 12px;
}

.sidebar .nav:not(.sub-menu) > .nav-item > .nav-link[aria-expanded="true"] {
    border-radius: 8px 8px 0 0;
  	background: #EFBDBC !important;
    color: #fff;
}


.sidebar-icon-only .sidebar .nav .nav-item .nav-link .menu-title{
  	background: #EFBDBC !important;
}

.sidebar .nav:not(.sub-menu) > .nav-item:hover > .nav-link, .sidebar .nav:not(.sub-menu) > .nav-item:hover[aria-expanded="true"]
{ 	background: #EFBDBC !important;
}
#settings-trigger{
  	background: #EFBDBC !important;
}

#search {
	height: 300px;
	margin: 0 auto;
}

ul{
	list-style:none;
}

#search {
	height: 250px;
	width: 100%;
	border: 1px solid black;
}

.name {
	width: 100px;
	margin: 35px 0 20px 50px;
	text-align: left;
	font-size: 15px;
}

.choose {
	width: 300px;
		font-size: 15px;
}

#search li {
	width: 600px;
	height: 50px;
}

input[type=text]{
	width: 300px;
	margin-bottom: 10px;
}

.button{
	margin-left: 10px;
}

/* 항목 스타일 끝 */
/* 목록 스타일 */
table {
  border-collapse: collapse;
  width: 100%;
}

th, td {
  padding: 8px;
  text-align: left;
  border-bottom: 1px solid #ddd;
}

tr:hover {background-color: #F0F0F0;}
/* 목록 스타일 끝 */
</style>
<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>홍커피</title>
  <!-- plugins:css -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/vendors/feather/feather.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/vendors/ti-icons/css/themify-icons.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/vendors/css/vendor.bundle.base.css">
  <!-- endinject -->
  <!-- Plugin css for this page -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/vendors/datatables.net-bs4/dataTables.bootstrap4.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/vendors/ti-icons/css/themify-icons.css">
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/js/select.dataTables.min.css">
  <!-- End plugin css for this page -->
  <!-- inject:css -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/vertical-layout-light/style.css">
  <!-- endinject -->
  <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/imgs/logo.png" />
</head>

<body onload="cola()">
  <div class="container-scroller">
    <!-- partial:partials/_navbar.html -->


	<!--     include top -->
	<jsp:include page="inc/top.jsp"/>

	
    <!-- partial -->
    <div class="container-fluid page-body-wrapper">
      <!-- partial:partials/_settings-panel.html -->
      <div class="theme-setting-wrapper">
        <div id="settings-trigger"><i class="ti-settings"></i></div>
        <div id="theme-settings" class="settings-panel">
          <i class="settings-close ti-close"></i>
          <p class="settings-heading">사이드바 색상</p>
          <div class="sidebar-bg-options selected" id="sidebar-light-theme"><div class="img-ss rounded-circle bg-light border mr-3"></div>Light</div>
          <div class="sidebar-bg-options" id="sidebar-dark-theme"><div class="img-ss rounded-circle bg-dark border mr-3"></div>Dark</div>
          <p class="settings-heading mt-2">헤더 색상</p>
          <div class="color-tiles mx-0 px-4">
            <div class="tiles success"></div>
            <div class="tiles warning"></div>
            <div class="tiles danger"></div>
            <div class="tiles info"></div>
            <div class="tiles dark"></div>
            <div class="tiles default"></div>
          </div>
        </div>
      </div>

      <!-- partial -->
      <!-- partial:partials/_sidebar.html -->
      <nav class="sidebar sidebar-offcanvas" id="sidebar">
        <ul class="nav">
        <ul class="logo-nav">
			<img src="${pageContext.request.contextPath}/resources/imgs/logo.png" style="max-width: 100%; height: auto;"/>
		</ul>
          <li class="nav-item" id="pjh1">
            <a class="nav-link" href="${pageContext.request.contextPath}/emp/main">
              <i class="icon-grid menu-icon"></i>
              <span class="menu-title">대시 보드</span>
            </a>
          </li>
          <li class="nav-item" id="pjh2">
            <a class="nav-link" data-toggle="collapse" href="#ui-basic" aria-expanded="false" aria-controls="ui-basic">
              <i class="icon-layout menu-icon"></i>
              <span class="menu-title">기준 정보 관리</span>
              <i class="menu-arrow"></i>
            </a>
          <div class="collapse" id="ui-basic">
              <ul class="nav flex-column sub-menu">
                <li class="nav-item"> <a class="nav-link" href="${pageContext.request.contextPath}/emp/store">지점 관리</a></li>
                <li class="nav-item"> <a class="nav-link" href="${pageContext.request.contextPath}/emp/item">재료 관리</a></li>
              </ul>
            </div>
          </li>
          <li class="nav-item" id="pjh3">
            <a class="nav-link" data-toggle="collapse" href="#form-elements" aria-expanded="false" aria-controls="form-elements">
              <i class="icon-columns menu-icon"></i>
              <span class="menu-title">영업 관리</span>
              <i class="menu-arrow"></i>
            </a>
            <div class="collapse" id="form-elements">
              <ul class="nav flex-column sub-menu">
                <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/emp/order">수주 관리</a></li>
                <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/emp/shipment">출하 관리</a></li>
              </ul>
            </div>
          </li>
          <li class="nav-item">
            <a class="nav-link" data-toggle="collapse" href="#charts" aria-expanded="false" aria-controls="charts">
              <i class="icon-bar-graph menu-icon"></i>
              <span class="menu-title">사원 관리</span>
              <i class="menu-arrow"></i>
            </a>
            <div class="collapse" id="charts">
              <ul class="nav flex-column sub-menu">
                <li class="nav-item"> <a class="nav-link" href="${pageContext.request.contextPath}/emp/emp">사원 관리</a></li>
              </ul>
            </div>
          </li>
 		</ul>
      </nav>
      <!-- partial -->
      <div class="main-panel">
        <div class="content-wrapper">
		<h2>사원 관리</h2>
		
		<form action="">
			<div id="search">
				<ul>
					<li><label class="name">부서</label>
					<select class="choose">
					<option value="">-----------------------------------------------</option>
					<option value="인사">인사</option>
					<option value="관리">관리</option></select></li>
				
					<li><label class="name">직급</label>
					<select class="choose">
					<option value="">-----------------------------------------------</option>
					<option>사원</option>
					<option>관리</option></select></li>
				
				<li><label class="name">사원번호</label>
					<input type="text"></li>
				<li><label class="name">사원이름</label>
					<input type="text">
					<span class="button"><button type="button" style="background-color: black; color: #EFBDBC;">조회</button></span></li>
				</ul>	
			</div>
		</form>

		<hr>
   	
		<div style="width:50%; height:50px; float: left; vertical-align: bottom !important; "><h3 style="margin-top: 15px;">사원 목록</h3></div>
		<div style="width:50%; height:50px; float: left; text-align: right !important; padding-top: 15px;" >
		
		<c:if test="${sessionScope.emp_right eq 1 }">
		<button style="background-color: black; color: #EFBDBC;" onclick="window.open('${pageContext.request.contextPath}/emp/popup/emp_insert','홍커피','width=370,height=520')">추가</button>
		<button style="background-color: black; color: #EFBDBC;" onclick="window.open('${pageContext.request.contextPath}/emp/popup/emp_update_admin','홍커피','width=370,height=520')">수정</button>
		</c:if>
		<c:if test="${sessionScope.emp_right eq 0 }">
		<button style="background-color: black; color: #EFBDBC;" onclick="window.open('${pageContext.request.contextPath}/emp/popup/emp_update','홍커피','width=370,height=520')">수정</button>
		</c:if>
		</div>
		
		
<!-- 		목록 -->
		<div style="width:100%;  height:700px; border: black 1px solid; float: left; text-align: center;">
		<table class="table">
  			<tr style="background-color: transparent !important;">
    		<th style=" font-size:20px !important; color: black;">선택</th>
    		<th style=" font-size:20px !important; color: black;">사원번호</th>
    		<th style=" font-size:20px !important; color: black;">이름</th>
    		<th style=" font-size:20px !important; color: black;">생년월일</th>
    		<th style=" font-size:20px !important; color: black;">부서</th>
    		<th style=" font-size:20px !important; color: black;">직급</th>
    		<th style=" font-size:20px !important; color: black;">권한</th>
    		<th style=" font-size:20px !important; color: black;">연락처</th>
    		<th style=" font-size:20px !important; color: black;">이메일</th>
    		<th style=" font-size:20px !important; color: black;">입사일</th>
    		<th style=" font-size:20px !important; color: black;">상태</th>
 		 </tr>
 		 <c:forEach var="EmployeeDTO" items="${empList}">
  <tr>
    <td style="text-align: center !important; font-size:20px !important;"><input type="checkbox" name="checkcheck"></td>
    <td style="text-align: center !important; font-size:20px !important;">${EmployeeDTO.emp_num}</td>
   	<td style="text-align: center !important; font-size:20px !important;">${EmployeeDTO.emp_name}</td>
   	<td style="text-align: center !important; font-size:20px !important;"><fmt:formatDate value="${EmployeeDTO.emp_birth}" pattern="yyyy.MM.dd"/></td>
    <td style="text-align: center !important; font-size:20px !important;">${EmployeeDTO.emp_dept}</td>
   	<td style="text-align: center !important; font-size:20px !important;">${EmployeeDTO.emp_rank}</td>
   	<td style="text-align: center !important; font-size:20px !important;"><c:if test="${EmployeeDTO.emp_right eq 1}">관리자</c:if>
   		<c:if test="${EmployeeDTO.emp_right eq 0}">일반</c:if></td>
 	<td style="text-align: center !important; font-size:20px !important;">${EmployeeDTO.emp_phone}</td>
 	<td style="text-align: center !important; font-size:20px !important;">${EmployeeDTO.emp_email}</td>
 	<td style="text-align: center !important; font-size:20px !important;"><fmt:formatDate value="${EmployeeDTO.hire_date}" pattern="yyyy.MM.dd"/></td>

 		<c:if test="${EmployeeDTO.emp_state eq 0}">
 		<td style="text-align: center !important; font-size:20px !important; color:green; ">재직</td>
 		</c:if>
 		
 		<c:if test="${EmployeeDTO.emp_state eq 1}">
 		<td style="text-align: center !important; font-size:20px !important; color:orange; ">휴직</td>
 		</c:if>
 		
 		<c:if test="${EmployeeDTO.emp_state eq 2}">
 		<td style="text-align: center !important; font-size:20px !important; color:red; ">휴직</td>
 		</c:if>

  </tr>
  		</c:forEach>
  
 		 </table>
		</div>
        
        
        </div>
        <!-- content-wrapper ends -->
        <!-- partial:partials/_footer.html -->
        
        <!--     include bottom -->
		<jsp:include page="inc/bottom.jsp"/>
        
        <!-- partial -->
      </div>
      <!-- main-panel ends -->
    </div>   
    <!-- page-body-wrapper ends -->
  </div>
  <!-- container-scroller -->

  <!-- plugins:js -->
  <script src="${pageContext.request.contextPath}/resources/vendors/js/vendor.bundle.base.js"></script>
  <!-- endinject -->
  <!-- Plugin js for this page -->
  <script src="${pageContext.request.contextPath}/resources/vendors/chart.js/Chart.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/vendors/datatables.net/jquery.dataTables.js"></script>
  <script src="${pageContext.request.contextPath}/resources/vendors/datatables.net-bs4/dataTables.bootstrap4.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/dataTables.select.min.js"></script>

  <!-- End plugin js for this page -->
  <!-- inject:js -->
  <script src="${pageContext.request.contextPath}/resources/js/off-canvas.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/hoverable-collapse.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/template.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/settings.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/todolist.js"></script>
  <!-- endinject -->
  <!-- Custom js for this page-->
  <script src="${pageContext.request.contextPath}/resources/js/dashboard.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/Chart.roundedBarCharts.js"></script>
  <!-- End custom js for this page-->
  
  <!-- nav mouseover 고유색 -->
<%--   <script src="${pageContext.request.contextPath}/resources/js/navByJaeHwan.js"></script> --%>

<script>
function cola() {
	document.querySelector("#ui-basic").className = 'collapse';
	document.querySelector("#form-elements").className = 'collapse';
	document.querySelector("#pjh1").className = 'nav-item';
	document.querySelector("#pjh2").className = 'nav-item';
	document.querySelector("#pjh3").className = 'nav-item';
}
</script>

</body>


</html>