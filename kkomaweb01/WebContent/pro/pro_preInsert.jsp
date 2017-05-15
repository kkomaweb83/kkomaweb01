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
<title>상품 admin 리스트</title>
<script type="text/javascript" src="<%=cp %>/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="<%=cp %>/js/kkoma01.js"></script>
<link rel="stylesheet" type="text/css" href="<%=cp %>/css/kkoma_new_01.css" />
<style type="text/css">

</style>
<script type="text/javascript">
	$(function() {

	});
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
		<span class="title_box1">☞ 상품 등록</span><br/>
		<span style="font-size: 0px;">&nbsp;</span>
	</div>
	
	<div class="title_div2">
	<table style="width: 800px; padding: 0; border-spacing: 5px;">
	<tr>
	<td><span class="span_box2">분류코드</span></td>
	<td align="left" colspan="2">
	<input type="text" name="pro_pcl_no" id="pro_pcl_no" class="box_input_left" value="${proCom.pro_pcl_no }" 
			style="width: 150px;" readonly="readonly" />							
	
	<span style="display: inline;">
	<select style="vertical-align: middle;" onchange="selProPclList(this);">
	<c:forEach var="bean" items="${class_list}">
	<option value="${bean.pcl_no }" disabled="disabled" class="select_title1">☞ ${bean.pcl_name }</option>
	<c:forEach var="bean2" items="${bean.pcl_list}">
	<option value="${bean2.pcl_no }" <c:if test="${proCom.pro_pcl_no == bean2.pcl_no}"> selected="selected" </c:if>>
	${bean2.pcl_name }</option>
	</c:forEach>
	</c:forEach>
	</select>
	</span>
	</td>
	
	<td align="right">
		<table style="border-spacing: 3px;">
		<tr>
		<td width="70"><span class="span_box2">재고</span></td>
		<td>
		<input type="text" name="pro_stockcount" OnkeyPress = "NumObj(this)" value="100"  
			class="box_input_left" style="width: 80px; ime-mode: disabled;" />
		</td>
		<td width="50"></td>
		<td><span onclick="javascript:goProInsert();" class="dana_button01">등록</span></td>
		</tr>
		</table>
	</td>
	</tr>
	<tr>
	<td><span class="span_box2">상품명</span></td>
	<td align="left" colspan="3">
	<input type="text" name="pro_name" class="box_input_left" style="width: 98%;" /></td>
	</tr>
	
	<tr>
	<td><span class="span_box2">제조사</span></td>
	<td align="left" width="300">
	<input type="text" name="pro_mkr_no" class="box_input_left" style="width: 97%;" readonly="readonly" />
	
	<c:if test="${!empty mkrList}">
	<select onchange="selProMkr(this);">
		<option value="">제조사 선택</option>
		<c:forEach var="bean" items="${mkrList}">
		<option value="${bean.mkr_no }">${bean.mkr_name }</option>
		</c:forEach>
	</select>
	</c:if>

	</td>
	<td width="90"><span class="span_box2">판매가격</span></td>
	<td align="left" width="300">
	<input type="text" name="pro_disprice" OnkeyPress="NumObj(this)" class="box_input_left" style="width: 95%; ime-mode: disabled;" /></td>
	</tr>
	<tr>
	<td><span class="span_box2">요약정보</span></td>
	<td align="left" colspan="3">
	<textarea rows="3" name="psm_conent" class="box_input_left" style="width: 98%;"></textarea></td>
	</tr>
	<tr>
	<td><span class="span_box2">작은 이미지</span></td>
	<td align="left" colspan="3">
	<input type="file" name="pmg_file_s1" size="70" class="box_input_left" /></td>
	</tr>
	<tr>
	<td><span class="span_box2">큰 이미지</span></td>
	<td align="left" colspan="3">
	<input type="file" name="pmg_file_s2" size="70" class="box_input_left" /></td>
	</tr>
	</table>
	</div>		
	
	</section>
	
	</div>
	
	<footer>
	
	</footer>
</body>
</html>