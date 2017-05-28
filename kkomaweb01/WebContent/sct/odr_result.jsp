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
<script src="//code.jquery.com/ui/1.11.0/jquery-ui.js"></script>
<link rel="stylesheet" type="text/css" href="<%=cp %>/css/kkoma_new_01.css" />
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.0/themes/smoothness/jquery-ui.css">
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
	
	<div id="content">
	
	<!-- 전체 -->
	<div id="proMainViewDiv" style="width: 960px; margin: 0 auto; text-align: center;">
	
	<section id="admin_section">
	
	<div class="title_div1">
		<div style="float: left;" >
			<span style="font-size: 5px;">&nbsp;</span><br/>
			<span class="title_box1">☞ 주문결과</span>
			<span style="margin-right: 20px;">&nbsp;</span>
		</div>
	</div>
	
	<table style="width: 100%; border: 1px solid red;">
		<tr>
			<td><span class="span_box2">주문번호</span></td>
			<td colspan="2" style="border: #FF9900 1px solid;font-size: 20px;">
			<input type="text" value="${param.odr_no_max}" readonly="readonly" class="box_input_left" style="width: 90%;" />
			</td>
			<td style="border: #FF9900 1px solid;font-size: 15px;">
				이용하시면서 문의사항이나 문제점이 발생할 경우에는<br/> 
				고객지원실 (<a style="color:red;">02-555-9999</a>) 로<br/> 
				문의 하시기 바랍니다.<br/>
			</td>
		</tr>
		<tr>
			<td colspan="4">
				<span class="span_box2"></span>
			</td>
		</tr>
		<tr>
			<td colspan="4" align="center">
				<div class="box_button1"><a href="<%=cp %>/ProController?dana=orders_det_list&odr_no=${param.odr_no_max}">주문내역 확인</a></div>
			</td>
		</tr>
	</table>
	
	</section>
	
	</div>
	
	</div>
	
	<footer>
	
	</footer>
<!-- 상세보기 dlg -->
<div id="dialog"></div>		
</body>
</html>