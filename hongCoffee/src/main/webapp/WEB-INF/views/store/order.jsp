<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
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

ul{
	list-style:none;
}

#search {
	height: 250px;
	padding-top: 30px;
	width: 100%;
	border: 1px solid black;
}

.search_name {
	width: 100px;
	text-align: left;
	font-size: 15px;
}

.search_div {
 	margin: 0 0 0 50px;
}

.choose {
	width: 300px;
	height: 29.63px;
	font-size: 15px;
}

#search li {
	width: 600px;
	height: 30px;
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
  <title>사원</title>
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
<body>
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
    
    
         
      <!--     include left -->
		<jsp:include page="inc/left.jsp"/>
		
		
      <!-- partial -->
      <div class="main-panel">
        <div class="content-wrapper">
		<h2>발주 관리</h2>
		
		<form action="">
			<div id="search">
				<ul>
					<li><div class="search_div"><label class="search_name"><b>재료명</b></label>
						<input type="text"></div></li>
						
					<li><div class="search_div"><label class="search_name"><b>단가</b></label>
						<input type="text"></div></li>
						
					<li><div class="search_div"><label class="search_name"><b>발주일시</b></label>
						<input type="text"></div></li>
						
					<li><div class="search_div"><label class="search_name"><b>입고여부</b></label>
						<select class="choose">
							<option value="">-----------------------------------------------</option>
							<option value="미입고">미입고</option>
							<option value="입고완료">입고완료</option>
						</select>
							
					<span class="button"><button type="button">조회</button></span></div></li>
				</ul>	
			</div>
		</form>

		<hr>
   	
		<div style="width:50%; height:50px; float: left; vertical-align: bottom !important; "><h3 style="margin-top: 15px;">수주 목록</h3></div>
		<div style="width:50%; height:50px; float: left; text-align: right !important; padding-top: 15px;" >
		<button>추가</button>
		<button>수정</button>
		<button>삭제</button></div>
		
<!-- 		목록 -->
		<div style="width:100%;  height:700px; border: black 1px solid; float: left; text-align: center;">
		<table class="table">
  			<tr style="background-color: transparent !important;">
    		<th style=" font-size:20px !important; color: black;">거래번호</th>
    	
    		<th style=" font-size:20px !important; color: black;">재료명</th>
    		<th style=" font-size:20px !important; color: black;">단가</th>
    		<th style=" font-size:20px !important; color: black;">발주일시</th>
    		<th style=" font-size:20px !important; color: black;">입고여부</th>
 		 </tr>
 		 <c:forEach var="OrderDTO" items="${orderList}">
  <tr>
    <td style="text-align: center !important; font-size:20px !important;">${OrderDTO.od_num}</td>

   	<td style="text-align: center !important; font-size:20px !important;">${OrderDTO.item_name}</td>
    <td style="text-align: center !important; font-size:20px !important;">${OrderDTO.item_price}</td>
   	<td style="text-align: center !important; font-size:20px !important;">${OrderDTO.od_time}</td>
	<c:if test="${OrderDTO.received_not eq 0}">
      <td style="text-align: center !important; font-size:20px !important; color:red; ">미입고</td>
  	</c:if>
  	<c:if test="${OrderDTO.received_not eq 1}">
      <td style="text-align: center !important; font-size:20px !important; color:green; ">입고완료</td>
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
</body>

</html>

