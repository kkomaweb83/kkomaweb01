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
<title>가상견적서 관리</title>
<script type="text/javascript" src="<%=cp %>/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="<%=cp %>/js/kkoma01.js"></script>
<link rel="stylesheet" type="text/css" href="<%=cp %>/css/kkoma_new_01.css" />
<style type="text/css">

</style>
<script type="text/javascript">
	$(function() {
		init("0101");
		
	});
	
	function init(pcl_no){
		$.ajax({
			url : "<%=cp %>/VblController",
			type : "post",
			data : {dana:'ajax_vbl_inMkrPcl',pcl_no:pcl_no},
			dataType : "html",
			success : function(data) {
				$("#LAY_TopPart").html(data);
			},
			error : function() {
				alert("실패");
			}
		});
		
		$.ajax({
			url : "<%=cp %>/VblController",
			type : "post",
			data : {dana:'ajax_vbl_inProList',pcl_no:pcl_no, proOrderCode:1},
			dataType : "html",
			success : function(data) {
				$("#LAY_OnlyProdList").html(data);
			},
			error : function() {
				alert("실패");
			}
		});
	}
	
	function goPptProChk(object){
		document.getElementsByName("cPage")[0].value = 1;
		
		$("#dana").val("ajax_vbl_inProList");
		$.ajax({
			url : "<%=cp %>/VblController",
			type : "post",
			data : $('#vblPro_Search').serialize(),
			dataType : "html",
			success : function(data) {
				$("#LAY_OnlyProdList").html(data);
			},
			error : function() {
				alert("실패");
			}
		});
	}
	function goMainProOrder(main_order){
		document.getElementsByName("cPage")[0].value = 1;
		document.getElementsByName("proOrderCode")[0].value = main_order.value;
		
		$("#dana").val("ajax_vbl_inProList");
		$.ajax({
			url : "<%=cp %>/VblController",
			type : "post",
			data : $('#vblPro_Search').serialize(),
			dataType : "html",
			success : function(data) {
				$("#LAY_OnlyProdList").html(data);
			},
			error : function() {
				alert("실패");
			}
		});
	}
	
	function row_tgl(pro_no, pro_pcl_no){
		var prono = document.getElementsByName("prono_"+pro_no)[0].value;
		var pname = document.getElementsByName("pname_"+pro_no)[0].value;
		var price = document.getElementsByName("price_"+pro_no)[0].value;
		var pricech = document.getElementsByName("pricech_"+pro_no)[0].value;
		var pcl_no = document.getElementById("LAY_MSG_"+pro_pcl_no);
		var div_totalPrice = document.getElementById("LAY_TotalPrice");
		
		var strHtml = '<table cellspacing="0" cellpadding="0" border="0" width="307">';
			strHtml += '<tbody>';
			strHtml += '<tr id="ROW_832058">';
			strHtml += '<td width="164">';
			strHtml += '<a href="javascript:goProDlgView('+prono+',\''+pro_pcl_no+'\', 1);">';
			strHtml += pname+'</a>';
			strHtml += '<input name="pst_pro_no" value="'+prono+'" type="hidden">';
			strHtml += '<input name="pro_disprice" value="'+price+'" type="hidden">';
			strHtml += '</td>';
			strHtml += '<td width="1" bgcolor="#cfd2d7"></td>';
			strHtml += '<td width="53" align="center">';
			strHtml += '<input name="cnt_'+prono+'" value="1" size="2" type="text" readonly="readonly">';
			strHtml += '<img src="<%=cp%>/img/btn_cnt.gif" usemap="#MAP_BtnCnt_'+prono+'"'; 
			strHtml += ' hspace="1" />';
			strHtml += '<map name="MAP_BtnCnt_'+prono+'">';
			strHtml += '<area shape="rect" coords="0,0,9,10" href="javascript:count_change('+prono+','+"'PLUS'"+')">';
			strHtml += '<area shape="rect" coords="0,10,9,20" href="javascript:count_change('+prono+','+"'MINUS'"+')">	</map>';
			strHtml += '</td>';
			strHtml += '<td width="1" bgcolor="#cfd2d7"></td>';
			strHtml += '<td width="88" align="right">'+pricech; 
			strHtml += '<a href="javascript:row_Delete('+"'"+pro_pcl_no+"'"+')">';
			strHtml += '<img src="<%=cp%>/img/btn_del.gif" /></a>';
			strHtml += '&nbsp;</td></tr></tbody>';
			strHtml += '</table>';
		pcl_no.innerHTML = strHtml;

		var price = document.getElementsByName("pro_disprice");
		var pst_pro_no = document.getElementsByName("pst_pro_no");
		var temp = 0;
		var cnt = 1;
		var temp_prono = "";
		for(var i =0; i<price.length; i++){
			temp_prono = pst_pro_no[i].value;
			cnt = document.getElementsByName("cnt_"+temp_prono)[0].value;
			temp += parseInt(price[i].value)*cnt; 
		}
		div_totalPrice.innerHTML= '<b>'+commaNum(temp)+' 원</b>';
		
	}

	function row_Delete(pro_pcl_no){
		var pcl_no = document.getElementById("LAY_MSG_"+pro_pcl_no);
		
		pcl_no.innerHTML = '<span style="color: #999999">☜ 항목을 클릭하세요.</span>';

		pstProTotal();
	}

	function count_change(prono, part){
		var cnt = document.getElementsByName("cnt_"+prono);
		var temp = 0;

		if(part == "PLUS"){
			temp = parseInt(cnt[0].value);
			cnt[0].value = temp+1;
		}else if(part == "MINUS"){
			temp = parseInt(cnt[0].value);
			if(temp > 1) cnt[0].value = temp-1;
		}

		pstProTotal();
	}

	function pstProTotal(){
		var div_totalPrice = document.getElementById("LAY_TotalPrice");
		var price = document.getElementsByName("pro_disprice");
		var pst_pro_no = document.getElementsByName("pst_pro_no");
		var temp = 0;
		var cnt = 1;
		var temp_prono = "";
		for(var i =0; i<price.length; i++){
			temp_prono = pst_pro_no[i].value;
			cnt = document.getElementsByName("cnt_"+temp_prono)[0].value;
			temp += parseInt(price[i].value)*cnt; 
		}
		div_totalPrice.innerHTML= '<b>'+commaNum(temp)+' 원</b>';
	}

	function commaNum(num) {  
	    if (num < 0) { num *= -1; var minus = true} 
	    else var minus = false      
	    var dotPos = (num+"").split(".")
	    var dotU = dotPos[0] 
	    var dotD = dotPos[1] 
	    var commaFlag = dotU.length%3 

	    if(commaFlag) { 
	            var out = dotU.substring(0, commaFlag)  
	            if (dotU.length > 3) out += "," 
	    } 
	    else var out = "" 
	    for (var i=commaFlag; i < dotU.length; i+=3) { 
	            out += dotU.substring(i, i+3)  
	            if( i < dotU.length-3) out += "," 
	    } 
	    if(minus) out = "-" + out 
	    if(dotD) return out + "." + dotD 
	    else return out 
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
	<%-- 견적서 외편 메뉴 include 처리 --%>
	<jsp:include page="../left/vbl_left.jsp" flush="false" />
	
	</aside>
	
	<section id="admin_section">
	
	<form method="post" id="vblPro_Search" name="vblPro_Search">
		<input type="hidden" name="vbl_mem_no" value="${login.mem_no}" />
		<input type="hidden" name="vbl_bor_answer" value="N" />
		<input type="hidden" name="sct_pro_part" value="1" />
		<input type="hidden" name="sct_pro_muti" value="3" />
		<input name="proOrderCode" type="hidden" value="1" />
		<input name="dana" id="dana" type="hidden" value="" />

	<div class="title_div1">
		<div style="float: left;" >
			<span style="font-size: 5px;">&nbsp;</span><br/>
			<span class="title_box1">☞ 가상견적서 리스트</span>
			<span style="margin-right: 20px;">&nbsp;</span>
		</div>	
		
		<div style="width: 70px; text-align: center; float: right;" class="vbl_btn01">
			<span onclick="javascript:goPptInsert();" class="dana_button01"><span>등록</span></span>
		</div>
	</div>
	
	<div class="title_div2">
		<table style="width: 800px; padding: 0; border-spacing: 5px;">
		<tr>
		<td width="110"><span class="title_box2_o">가상견적서 제목</span></td>
		<td align="left">
		<input type="text" name="vbl_title" class="box_input_left" style="width: 97%;" /></td>
		</tr>
		</table>
	</div>
	
	<div style="width: 800px;">
	
	<table style="width: 800px; padding: 0; border-spacing: 0; border-top: 1px solid black;">
	<tbody>
	<tr>
	<td style="width: 390px; background-color: #f3f3f3; vertical-align: top;">
		<!-- 왼쪽 검색 -->
		<div style="border: 0px solid rgb(204, 204, 204); width: 390px;" id="LAY_TopPart">
			
		</div>
		<!-- 상품 리스트 -->
		<div id="LAY_OnlyProdList">
		
		</div>	
		<!-- 상품 리스트 -->
	</td>
	<!-- 왼쪽 끝 -->
	<td style="width: 4px; background-color: #f3f3f3;"/>
	
	<!-- 오른쪽 시작 -->
	<td style="width: 396px; vertical-align: top;">
	<div id="LAY_ChangeB">
	<!-- 가격 총합계 -->
	<table style="width: 396px; padding: 0; border-spacing: 0;">
	<tbody><tr height="3">
	<td bgcolor="#cfd2d7" width="1"/>
	<td bgcolor="#4a4a4a" width=394/>
	<td bgcolor="#cfd2d7" width="1"/>
	</tr>
	<tr height="3">
	<td bgcolor="#cfd2d7" width="1"/>
	<td height="30" bgcolor="#f6f6f6" width="396">
	<div style="padding: 7px 0pt 0pt 5px; float: left; height: 30px;">
	<img height="6" width="6" src="<%=cp %>/img/plus_icon.gif"/>
	<b>총합 : </b>
	</div>
	<div style="padding: 7px 27px 0pt 5px; float: right; height: 30px; color: rgb(245, 98, 0);" id="LAY_TotalPrice"><b>0 원</b></div>
	</td>
	<td bgcolor="#cfd2d7" width="1"/>
	</tr>
	<tr height="1">
	<td bgcolor="#cfd2d7" width="1"/>
	<td bgcolor="#cfd2d7" width="394"/>
	<td bgcolor="#cfd2d7" width="1"/>
	</tr>
	</tbody></table>
	<!-- 가격 총합계 -->
	<!-- 선택된 상품 -->
	<div style="height: 443px; overflow-y: scroll; overflow-x: hidden; " id="LAY_Right">
		<c:forEach var="bean" items="${class_list}" varStatus="class9">
		<table style="width: 396px; padding: 0; border-spacing: 0;">
		<tbody><tr>
		<td colspan="3">
		<table style="width: 394px; padding: 0; border-spacing: 0;">
		<tbody><tr height="39" bgcolor="#254284">
		<td class="title1"><span style="color: #ffffff; padding-left: 5px;">${bean.pcl_name }</span></td>
		</tr>	</tbody></table>
		</td>
		</tr>
		</tbody></table>
		
		<div id="LAY_VH_${class9.count }">
		<table style="width: 394px; padding: 0; border-spacing: 0;">
		<tbody>	<tr>
		<td bgcolor="#cfd2d7" width="1"/>
		<td bgcolor="#ffffff" width="394">
		<table style="width: 394px; padding: 0; border-spacing: 0;">
		<tbody>
			<c:forEach var="bean2" items="${bean.pcl_list}" varStatus="class2">
			<tr height="30">
			<td bgcolor="#f1f4f9" align="center" width="77">
			<a href="javascript:init('${bean2.pcl_no }')">${bean2.pcl_name }</a>
			</td>
			<td bgcolor="#cfd2d7" width="1"/>
			<td width="317" align="left">
			<div style="display: block; visibility: visible;" id="LAY_MSG_${bean2.pcl_no }">
			<span style="color: #999999">☜ 항목을 클릭하세요.</span>
			</div>
			</td>
			</tr>
			<tr height="1" bgcolor="#cfd2d7"><td colspan="3"/></tr>
			</c:forEach>
		</tbody>
		</table>
		</td>
		<td bgcolor="#cfd2d7" width="1"/>
		</tr></tbody></table>
		</div>
	</c:forEach>	
	
	</div>
	<!-- 선택된 상품 -->
	
	</div>
	</td>
	<!-- 오른쪽 끝 -->
	
	<td bgcolor="#f3f3f3" width="5"/>
	</tr>	
	
	<tr><td height="4" bgcolor="#f3f3f3" colspan="5"/></tr>
	<tr><td height="1" bgcolor="#cacaca" colspan="5"/></tr>
	</tbody>
	</table>
	
	</div>		
	
	<div style="margin-top: 10px; text-align: right; padding-right: 10px; height: 150px;">
	<a href="javascript:goSctOdr();">	
	<img src="<%=cp %>/img/btn_buy.gif" border="0"></a>&nbsp;
	<a href="javascript:goSctmultiInsert();">
	<img src="<%=cp %>/img/btn_cart.gif" border="0"></a>
	</div>
	
	</form>
	</section>
	
	</div>
	
	<footer>
	
	</footer>
</body>
</html>