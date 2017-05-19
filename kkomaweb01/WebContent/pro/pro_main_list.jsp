<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String cp = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=Edge" />
<title>컴퓨터 쇼핑몰의 최강자 DanaCom</title>
<script type="text/javascript" src="<%=cp %>/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="<%=cp %>/js/kkoma01.js"></script>
<link rel="stylesheet" type="text/css" href="<%=cp %>/css/kkoma_new_01.css" />
<style type="text/css">
#wrapMiniTex {
	position: fixed;
	bottom: 0pt;
	z-index: 99;
}
</style>
<script type="text/javascript">
	$(function() {
		init();

	});
	
	function init(){
		$.ajax({
			url : "<%=cp %>/ProController",
			type : "post",
			data : {dana:'ajax_pro_topSearch',pro_pcl_no:'${param.pro_pcl_no}'},
			dataType : "html",
			success : function(data) {
				$("#proTopSearchDiv").html(data);
			},
			error : function() {
				alert("실패");
			}
		});
		
		$.ajax({
			url : "<%=cp %>/ProController",
			type : "post",
			data : {dana:'ajax_pro_list',pro_pcl_no:'${param.pro_pcl_no}',proOrderCode:'1'},
			dataType : "html",
			success : function(data) {
				$("#proListDiv").html(data);
			},
			error : function() {
				alert("실패");
			}
		});
		
		<c:if test="${login.cmd == 101}">
		$.ajax({
			url : "<%=cp %>/ProController",
			type : "post",
			data : {dana:'ajax_sct_list',sct_mem_no:'${login.mem_no }',sct_part:1},
			dataType : "html",
			success : function(data) {
				$("#miniSctListDiv").html(data);
			},
			error : function() {
				alert("실패");
			}
		});
		</c:if>
	}
	function doList(page){
		$("#cPage").val(page);
		$("#dana").val("ajax_pro_list");
		$.ajax({
			url : "<%=cp %>/ProController",
			type : "post",
			data : $('#pro_pclSearch').serialize(),
			dataType : "html",
			success : function(data) {
				$("#proListDiv").html(data);
			},
			error : function() {
				alert("실패");
			}
		});
	}
	
	function proListPclWrap(part){
		var area = document.getElementById("pclWrap");
		var area2 = document.getElementById("pclListDiv");
		var strHtml = "";

		if(part == 1){
			area2.style.display = "none";
			strHtml += '<a href="javascript:proListPclWrap(2);">';
			strHtml += '<img src="<%=cp %>/img/open_btn.gif" border="0"></a>';
			area.innerHTML = strHtml;
		}else{
			area2.style.display = "inline";
			strHtml += '<a href="javascript:proListPclWrap(1);">';
			strHtml += '<img src="<%=cp %>/img/close_btn.gif" border="0"></a>';
			area.innerHTML = strHtml;
		}
	}
	
	function goMainTopChk(proOrderCode){
		if(proOrderCode != 0){
			$("#proOrderCode").val(proOrderCode);
		} 
		$("#cPage").val(1);
		$("#dana").val("ajax_pro_pclSearch");
		$.ajax({
			url : "<%=cp %>/ProController",
			type : "post",
			data : $('#pro_pclSearch').serialize(),
			dataType : "html",
			success : function(data) {
				$("#proListDiv").html(data);
			},
			error : function() {
				alert("실패");
			}
		});		
	}
	
	function goProMainView(pro_no, pro_pcl_no){
		$.ajax({
			url : "<%=cp %>/ProController",
			type : "post",
			data : {dana:'ajax_pro_mainView',pro_no:pro_no,pro_pcl_no:pro_pcl_no},
			dataType : "html",
			success : function(data) {
				$("#proMainViewDiv").html(data);
			},
			error : function() {
				alert("실패");
			}
		});
	}
	
	function goShopCart(pro_no, mem_no, sct_pro_part, sct_part){
		var sctDiv = "proMainViewDiv";
		if(sct_part == 1) sctDiv = "miniSctListDiv"; 
		
		$.ajax({
			url : "<%=cp %>/ProController",
			type : "post",
			data : {dana:'ajax_sct_insert',sct_pro_no:pro_no,sct_mem_no:mem_no,sct_pro_part:sct_pro_part,sct_part:sct_part},
			dataType : "html",
			success : function(data) {
				$("#"+sctDiv).html(data);
			},
			error : function() {
				alert("실패");
			}
		});
		
	}
	
	function wrapShow(part){
		var area = document.getElementById("wrapMiniTex");
		var area1 = document.getElementById("miniTex_top_clearfix");
		var area2 = document.getElementById("miniTex_body");
		if(part == 1){
			area.style.height = "225px";
			area2.style.display = "inline";
			area1.innerHTML = '<a href="javascript:wrapShow(2);" style="color: white;">장바구니 ▼</a>';
		}else{
			area.style.height = "32px";
			area2.style.display = "none";
			area1.innerHTML = '<a href="javascript:wrapShow(1);" style="color: white;">장바구니 ▲</a>';
		}
	}
</script>
</head>
<body>
	<header id="top_header">
	<%-- 상단 헤더 include 처리 --%>
	<jsp:include page="../top/top_menu.jsp" flush="false" />
	
	</header>
	
	<div id="content">
	
	<!-- 전체 -->
	<div id="proMainViewDiv" style="width: 960px; margin: 0 auto;">
	
	<!-- 검색 -->
	<div id="proTopSearchDiv" style="margin-top: 0px;">
	
	</div>
	<!-- 검색 -->
	
	<!-- 리스트 -->
	<div id="proListDiv">
	
	</div>
	<!-- 리스트 -->
	
	<div style="height: 200px;"></div>
	
	</div>
	
	<c:if test="${login.cmd == 101}">
	<!-- 하단 장바구니 -->
	<div id="wrapMiniTex">
		<div id="miniTex_top_clearfix"><a href="javascript:wrapShow(1);" style="color: white;">장바구니 ▲</a></div>
	<div id="miniTex_body">
		<div id="miniSctListDiv">
		<!-- 하단 장바구니 -->
		</div>
	</div>
	</div>
	<!-- 하단 장바구니 -->
	</c:if>
	
	</div>
	
	<footer>
	
	</footer>
</body>
</html>