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
		insertCommaAll();
		
	});
	
	function selProPclList(sel_pcl_no){
		if(sel_pcl_no.value.length > 3){  
			location.href = "<%=cp %>/ProAdminController?dana=propdtpresel&pcl_no="+sel_pcl_no.value;
		}
	}
	function selProMkr(sel_pcl_mkr){
		document.pro_insert.pro_mkr_no.value = sel_pcl_mkr.value; 
	}
	function selPdtStep(pdtStep, i, j){
		var a = document.getElementsByName("pdt_step51_" + i + "_" + j);
		a[0].value = pdtStep.value;
	}
	function goProInsert(){
		if (document.pro_insert.pro_pcl_no.value == "")  {
	        alert("분류코드를 선택하세요!");
	        document.pro_insert.pro_pcl_no.focus();
	        return;
	 	}

		if (document.pro_insert.pro_stockcount.value == "")  {
	        alert("재고수량을 입력하세요!");
	        document.pro_insert.pro_stockcount.focus();
	        return;
	 	}

		if (document.pro_insert.pro_name.value == "")  {
	        alert("상품명을 입력하세요!");
	        document.pro_insert.pro_name.focus();
	        return;
	 	}

		if (document.pro_insert.pro_mkr_no.value == "")  {
	        alert("제조사코드를 선택하세요!");
	        document.pro_insert.pro_mkr_no.focus();
	        return;
	 	}   

	 	if (document.pro_insert.pro_disprice.value == "")  {
	        alert("판매가격을 입력하세요!");
	        document.pro_insert.pro_disprice.focus();
	        return;
	 	}

	 	if (document.pro_insert.psm_conent.value == "")  {
	        alert("요약정보를 입력하세요!");
	        document.pro_insert.psm_conent.focus();
	        return;
	 	}

	 	if (document.getElementsByName("pmg_file_s1")[0].value == "")  {
	        alert("작은이미지를 선택하세요!");
	        document.getElementsByName("pmg_file_s1")[0].focus();
	        return;
	 	}

	 	if (document.getElementsByName("pmg_file_s2")[0].value == "")  {
	        alert("큰이미지를 선택하세요!");
	        document.getElementsByName("pmg_file_s2")[0].focus();
	        return;
	 	}
	 	
	 	removeCommaAll();

		document.pro_insert.action = "<%=cp %>/ProAdminController?dana=pro_insert";
		document.pro_insert.submit();
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
	<form method="post" name="pro_insert" enctype="multipart/form-data">
	
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
	<option value="${bean.pcl_no }" class="select_title1">☞ ${bean.pcl_name }</option>
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
		<input type="text" name="pro_stockcount" class="box_input_left changeAmount ar" style="width: 80px; ime-mode: disabled;"
		       onfocus="this.select();" maxlength="13" onKeyDown="onOnlyNumber(this);" onkeyup="removeComma(this);insertComma(this);" value="0" />
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
	<input type="text" name="pro_mkr_no" class="box_input_left" style="width: 150px;" readonly="readonly" />
	
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
	<input type="text" name="pro_disprice" class="box_input_left changeAmount ar" style="width: 95%; ime-mode: disabled;" 
		   onfocus="this.select();" maxlength="13" onKeyDown="onOnlyNumber(this);" onkeyup="removeComma(this);insertComma(this);" value="0" />
	</td>
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
	
	<div style="text-align: left;">
		<c:forEach var="bean" items="${pclList}" varStatus="no">
		<table>
		<tr>
			<td colspan="3">
			<span class="box_button1">${bean.pcl_name }</span>
			</td>
		</tr>
		<c:forEach var="bean2" items="${bean.pcl_list}" varStatus="no2">
		<tr>
			<td class="title_box2" style="width: 150px;">
			${bean2.pcl_name }
			<input type="hidden" name="step" value="${no.count },${no2.count }">
			<input type="hidden" name="pdt_step4_${no.count }_${no2.count }" value="${bean2.pcl_no }" />
			</td>
			<td>
				<input type="text" name="pdt_step51_${no.count }_${no2.count }" class="box_input_left" value="NULL" style="width: 200px;" readonly="readonly" />
			</td>
			<td>
				<select name="pdt_step52_${no.count }_${no2.count }" onchange="selPdtStep(this, ${no.count}, ${no2.count })">
					<option value="NULL">선택안함</option>
					<c:forEach var="bean3" items="${bean2.pcl_list}">
					<option value="${bean3.pcl_no }">${bean3.pcl_name }</option>
					</c:forEach>
				</select>
			</td>
		</tr>
		</c:forEach>
		</table>
		</c:forEach>
	</div>		
	
	</form>
	</section>
	
	</div>
	
	<footer>
	
	</footer>
</body>
</html>