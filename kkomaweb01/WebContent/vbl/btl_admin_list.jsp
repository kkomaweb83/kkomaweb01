<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="p" tagdir="/WEB-INF/tags" %>
<% String cp = request.getContextPath(); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=Edge" />
<title>베틀 admin 리스트</title>
<script type="text/javascript" src="<%=cp %>/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="<%=cp %>/js/kkoma01.js"></script>
<link rel="stylesheet" type="text/css" href="<%=cp %>/css/kkoma_new_01.css" />
<style type="text/css">

</style>
<script type="text/javascript">
	$(function() {

	});
	
	function doList(page){
		location.href = "<%=cp %>/VblController?dana=btl_admin_list&cPage="+page;
	}
	function doPreInsert(){
		location.href = "<%=cp %>/VblController?dana=btl_admin_preInsert";
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
	
	<div class="title_div1">
		<span style="font-size: 5px;">&nbsp;</span><br/>
		<span class="title_box1">☞ 베틀 리스트</span><br/>
		<span style="font-size: 0px;">&nbsp;</span>
	</div>
	
	<div style="width: 70px; text-align: center; float: right;">
	<span onclick="javascript:doPreInsert();" class="dana_button01">베틀등록</span>
	</div>		

	
	<!-- pro_admin_list -->
	<div style="width: 800px;">
	
	<div style="text-align: left; height: 30px;">
	전체 갯수<span style="color: red;">${total_cnt}</span> 개
	</div>
	
	<table style="width: 800px;" class="lngTable">
	<tr>
		<th>번호</th>
		<th>배틀명</th>
		<th>배틀 시작일</th>
		<th>배틀 마감일</th>
		<th>관리</th>
		<th>수정</th>
		<th>삭제</th>
	</tr>
	<c:forEach var="btl" items="${btlList}">
	<tr>
		<td>${btl.btl_no}</td>
		<td>
		<a href="<%=cp %>/VblController?dana=btlDetList&btl_no=${btl.btl_no}">${btl.btl_title}</a>
		</td>
		<td>${btl.btl_sdate}</td>
		<td>${btl.btl_cdate}</td>
		<td>
		<a href="<%=cp %>/VblController?dana=btlDetPrejoin&btl_no=${btl.btl_no}"><img src="<%=cp %>/img/btn_manage.jpg" /></a>
		</td>
		<td>
		<a href="<%=cp %>/VblController?dana=groundPreupdate&btl_no=${btl.btl_no}"><img src="<%=cp %>/img/cpmodify.jpg" /></a>
		</td>
		<td>
		<a href="<%=cp %>/VblController?dana=groundDelete&btl_no=${btl.btl_no}"><img src="<%=cp %>/img/cpdelete.jpg" /></a>
		</td>
	</tr>
	</c:forEach>
	</table>
	
	<p:page p_totalPage="${p_totalPage}" p_nowPage="${p_nowPage}" p_list="${p_list}" p_pagePerBlock="${p_pagePerBlock}" />
	 
	</div>
	
	</section>
	
	</div>
	
	<footer>
	
	</footer>
</body>
</html>