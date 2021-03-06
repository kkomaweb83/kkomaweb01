<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String cp = request.getContextPath(); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=Edge" />
<title>주문내역 관리</title>
<script type="text/javascript" src="<%=cp %>/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="<%=cp %>/js/kkoma01.js"></script>
<link rel="stylesheet" type="text/css" href="<%=cp %>/css/kkoma_new_01.css" />
<style type="text/css">

</style>
<script type="text/javascript">
	$(function() {
		init();
		
	});
	
	function init(){
		$.ajax({
			url : "<%=cp %>/ProController",
			type : "post",
			data : {dana:'ajax_orders_admin_list',reurl:'admin'},
			dataType : "html",
			success : function(data) {
				$("#pclListDiv").html(data);
			},
			error : function() {
				alert("실패");
			}
		});
	}
	function doList(page){
		$.ajax({
			url : "<%=cp %>/ProController",
			type : "post",
			data : {dana:'ajax_orders_admin_list',reurl:'admin',cPage:page},
			dataType : "html",
			success : function(data) {
				$("#pclListDiv").html(data);
			},
			error : function() {
				alert("실패");
			}
		});
	}
</script>
</head>
<body>
	<header id="top_header">
	<%-- 상단 헤더 include 처리 --%>
	<jsp:include page="../top/top_menu.jsp" flush="false" />
	
	</header>
	
	<div id="admin_content">
	
	<aside id="admin_aside">
	<%-- 관리자 외편 메뉴 include 처리 --%>
	<jsp:include page="../left/admin_left.jsp" flush="false" />
	
	</aside>
	
	<section id="admin_section">
	
	<!-- pcl_insert -->
	<div id="pclListDiv">
	
	<!-- ajax_pcl_list -->
	
	</div>
	<!-- pcl_list -->
	
	</section>
	
	</div>
	
	<footer>
	
	</footer>
</body>
</html>