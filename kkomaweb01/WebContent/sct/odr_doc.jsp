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
<script src="//code.jquery.com/ui/1.11.0/jquery-ui.js"></script>
<link rel="stylesheet" type="text/css" href="<%=cp %>/css/kkoma_new_01.css" />
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.0/themes/smoothness/jquery-ui.css">
<style type="text/css">

</style>
<script type="text/javascript">
	$(function() {

	});
	
	function goProDlgView(pro_no, pro_pcl_no, sct_pro_part){
		$("#dialog").dialog({ 
            autoOpen:true, //자동으로 열리지않게
			width:600,
			height:500,
			modal:false, //모달대화상자
            resizable:false, //크기 조절 못하게
			show : 'slide', hide : 'slide',
			position : [500, 500]
		});
		
		$.ajax({
			url : "<%=cp %>/ProController",
			type : "post",
			data : {dana:'ajax_pro_mainView',pro_no:pro_no, pro_pcl_no:pro_pcl_no, view_area:2},
			dataType : "html",
			success : function(data) {
				$("#dialog").html(data);
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
	<div id="proMainViewDiv" style="width: 960px; margin-left: auto; margin-right: auto;">
	<form action="<%=cp %>/odr_doc/odr_doc.ama" method="post" name="odr_doc_form" onsubmit="return doChk();">
		<input type="hidden" value="${login.mem_no }" name="mem_no" />
	
	<div style="font-size: 11pt;
				background-color: #FFFFFF;
				border: #FF9900 1px solid;
				padding-left: 15px;
				padding-right: 5px;
				padding-top: 6px;
				padding-bottom: 5px;
				margin-bottom: 10px;
				vertical-align: middle;
			 	text-align: left;
			 	color: #000000;">
				 	
	<span style="margin-right: 10px;">☞  주문서 작성</span>
	</div>
	
	<!-- 주문 리스트 -->
	<div  style="font-size: 11pt;
						background-color: #FFFFFF;
						border: #FF9900 1px solid;
						padding: 10px;
						margin-bottom: 10px;
						vertical-align: middle;
					 	text-align: left;
					 	color: #000000;">
	<table style="padding-bottom: 5px; padding-top: 5px; width: 940px;">

	<tr style="background-color: #ffdab9;">
		<td colspan="2">
		<span style="padding-left: 5px; margin-right: 150px;">주문리스트</span>
		<span>상품</span>
		</td>
		<td align="center">가격</td>
		<td align="center">수량</td>
		<td align="center">소계</td>
		<td align="center">적립금</td>
	</tr>		
	
	<c:forEach var="bean" items="${sctList}">
		<input type="hidden" value="${bean.sct_proVO.pro_no }" name="s_pro_no" />
		<input type="hidden" value="${bean.sct_mem_no }" name="s_mem_no" />
		<input type="hidden" value="${bean.sct_proVO.pro_milege }" name="s_pro_milege" />
		<input type="hidden" value="${bean.sct_proVO.pro_disprice }" name="s_pro_disprice" />
		<input type="hidden" value="${odr_doc.odr_no }" name="odr_no" />
		<input type="hidden" value="${bean.sct_count }" name="s_odt_count" />
		<input type="hidden" value="${bean.sct_pro_part }" name="s_odt_pro_part" />
	<tr>
		<td width="90" align="center" style="border-bottom: gray 1px dotted;">
		<a href="javascript:goProDlgView(${bean.sct_proVO.pro_no }, '${bean.sct_proVO.pro_pcl_no }', ${bean.sct_pro_part });">
		<img src="<%=cp %>/product_img/${bean.sct_proVO.pmg_file }" style="width: 50px; height: 50px; border: 0px;">
		</a>
		</td>
		<td width="404" style="border-bottom: gray 1px dotted;">
			<table>
			<tr><td>
			<span style="color: blue;">[${bean.sct_proVO.pcl_name }]</span>
			</td></tr>
			<tr><td>
			<a href="javascript:goProDlgView(${bean.sct_proVO.pro_no }, '${bean.sct_proVO.pro_pcl_no }', ${bean.sct_pro_part });">
			${bean.sct_proVO.pro_name }</a>
			</td></tr>
			</table>
		</td>
		<td width="120" align="center" style="color: #FF3333; font-size: 10pt; font-weight: bold; 
			border-bottom: gray 1px dotted;">
		${bean.sct_proVO.pro_ch_price }
		</td>
		<td width="90" align="center" style="border-bottom: gray 1px dotted;">
		${bean.sct_count } 개</td>
		<td width="120" align="center" style="color: #FF3333; font-size: 10pt; 
			font-weight: bold; border-bottom: gray 1px dotted;">
		${bean.sct_proVO.pro_tot_ch_price }
		</td>
		<td width="120" align="center" style="border-bottom: gray 1px dotted;">
		${bean.sct_proVO.pro_ch_milege }
		</td>
	</tr>
	</c:forEach>
	</table>
	</div>
	<div style="text-align:right; 
				font-size: 11pt;
				height: 50px;
				padding-right: 10px;
				margin-bottom: 5px;
				line-height:20px;
				border-bottom: #FF9900 3px solid;">
		총 합계 금액 : <span style="color: red;">${sctTotPrivceVo.sct_tot_ch_disprice }</span><br />
		<span style="color: red;">총 적립금: ${sctTotPrivceVo.sct_tot_ch_milege }</span> 
		<input type="hidden" value="${sctTotPrivceVo.sct_tot_disprice }" name="s_totPrice" />
		<input type="hidden" value="${sctTotPrivceVo.sct_tot_milege }" name="s_totMilege" />
	</div>
	
	</form>
	</div>
	<!-- 주문 리스트 -->
	
	</div>
	
	<footer>
	
	</footer>
<!-- 상세보기 dlg -->
<div id="dialog"></div>	
</body>
</html>