<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

</style>
<script type="text/javascript">
	$(function() {
		init();

	});
	
	function init(){
		$.ajax({
			url : "<%=cp %>/ProController",
			type : "post",
			data : {dana:'ajax_sct_list',sct_mem_no:'${login.mem_no}'},
			dataType : "html",
			success : function(data) {
				$("#proMainViewDiv").html(data);
			},
			error : function() {
				alert("실패");
			}
		});
	}
	function sct_count_ch(sct_no, part, mem_no, prono, sct_part){
		var cnt = document.getElementsByName("cnt_"+prono);
		var temp = 0;

		if(part == "PLUS"){
			temp = parseInt(cnt[0].value);
			temp = temp+1;
		}else if(part == "MINUS"){
			temp = parseInt(cnt[0].value);
			if(temp > 1) temp = temp-1;
		}
		
		$.ajax({
			url : "<%=cp %>/ProController",
			type : "post",
			data : {dana:'ajax_sct_update',sct_no:sct_no, sct_count: temp, sct_mem_no: mem_no, sct_part:sct_part},
			dataType : "html",
			success : function(data) {
				$("#proMainViewDiv").html(data);
			},
			error : function() {
				alert("실패");
			}
		});
	}
	function goSctDelete(sct_no, mem_no, sct_part){
		$.ajax({
			url : "<%=cp %>/ProController",
			type : "post",
			data : {dana:'ajax_sct_delete',sct_no:sct_no, sct_mem_no: mem_no, sct_part:sct_part},
			dataType : "html",
			success : function(data) {
				$("#proMainViewDiv").html(data);
			},
			error : function() {
				alert("실패");
			}
		});
	}
	function goSctAllDelete(mem_no, sct_part){
		$.ajax({
			url : "<%=cp %>/ProController",
			type : "post",
			data : {dana:'ajax_sct_alldelete',sct_mem_no: mem_no, sct_part:sct_part},
			dataType : "html",
			success : function(data) {
				$("#proMainViewDiv").html(data);
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
	
	</div>
	
	</div>
	
	<footer>
	
	</footer>
</body>
</html>