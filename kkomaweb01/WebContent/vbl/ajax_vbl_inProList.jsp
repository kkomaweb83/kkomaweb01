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
<title></title>
</head>
<body>

<div style="height: 22px; padding-top: 3px; padding-right: 3px; text-align: right;">
	<input type="radio" name="pro_order" value="1" onclick="goMainProOrder(this);" 
	<c:if test="${orderCode == 1}">checked="checked"</c:if> />인기상품순
	<input type="radio" name="pro_order" value="2" onclick="goMainProOrder(this);" 
	<c:if test="${orderCode == 2}">checked="checked"</c:if> />신상품순
	<input type="radio" name="pro_order" value="3" onclick="goMainProOrder(this);" 
	<c:if test="${orderCode == 3}">checked="checked"</c:if> />낮은가격순
	<input type="radio" name="pro_order" value="4" onclick="goMainProOrder(this);" 
	<c:if test="${orderCode == 4}">checked="checked"</c:if> />높은가격순
</div>

<div style="height: 23px; background-color: #b6d0e8; padding-left: 5px; padding-top: 5px;">
<span style="margin-right: 10px;">☞  상품 리스트</span>
총 (<span style="color: red;">${total_cnt}</span>) 개 상품 
</div>

<div style="border: 1px solid rgb(204, 204, 204); height: 297px; overflow-y: scroll; overflow-x: hidden;">

<table style="border-spacing: 0; padding: 0; background-color:white; width: 97%; border: 0;" id="TABLE_ProdInfo">
<tr>
<td bgcolor="#cfd2d7" width="1"/>
<td>
<table style="border-spacing: 0; padding: 0; width: 100%;">
<tbody>
	<c:forEach var="bean" items="${proMainList}">
	<tr id="${bean.pro_no }">
	<td width="56">
	<table style="border-spacing: 0; padding: 0; width: 100%;">
	<tbody><tr>
	<td width="2"/>
	<td>
	<a href="javascript:goProDlgView(${bean.pro_no }, '${bean.pro_pcl_no }', 1);">
	<img height="50" width="50" src="<%=cp %>/product_img/${bean.pmg_file }" border="0"/></a></td>
	<td width="2"/>
	</tr>
	</tbody></table>
	</td>
	
	<td>
		<table style="border-spacing: 0; padding: 0; width: 100%;">
		<tbody>
		<tr><td align="left">
		<a href="javascript:goProDlgView(${bean.pro_no }, '${bean.pro_pcl_no }', 1);">
		${bean.ppt_pro_name}</a><br />
		<span style="display: inline; color: red; padding-left: 10px;">${bean.pro_ch_price}</span>
		<span style="display: none;">${bean.pro_disprice}</span>
		</td>	</tr>
		</tbody></table>
	</td>
	
	<td align="right">
	<input type="hidden" value="${bean.pro_disprice}" name="price_${bean.pro_no}"/>
	<input type="hidden" value="${bean.pro_ch2_price}" name="pricech_${bean.pro_no}"/>
	<input type="hidden" value="${bean.ppt_pro_name }" name="pname_${bean.pro_no }"/>
	<input type="hidden" value="${bean.pro_no }" name="prono_${bean.pro_no }"/>
	
	<a href="javascript:row_tgl(${bean.pro_no }, '${bean.pro_pcl_no }')">
	<img border="0" vspace="2" src="<%=cp %>/img/btn_choice.gif" /></a> 
	</td>
	</tr>
	<tr><td height="1" bgcolor="#cfd2d7" colspan="3"/></tr>
	</c:forEach>
</tbody>
</table>
</td>
<td bgcolor="#cfd2d7" width="1"/>
</tr>
</table>

</div>

<div style="height: 20px; text-align: center; padding-top: 5px;">

<p:page p_totalPage="${p_totalPage}" p_nowPage="${p_nowPage}" p_list="${p_list}" p_pagePerBlock="${p_pagePerBlock}" />

</div>	

</body>
</html>