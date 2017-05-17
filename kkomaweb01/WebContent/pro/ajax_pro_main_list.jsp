<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="p" tagdir="/WEB-INF/tags" %>
<% String cp = request.getContextPath(); %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=Edge" />
<title>Insert title here</title>
</head>
<body>

<nav id="pro_order_lnb">
	<ul>
		<li><a href="#">인기상품순</a></li>
		<li><a href="#">신상품순</a></li>
		<li><a href="#">낮은가격순</a></li>
		<li><a href="#">높은가격순</a></li>
		<li><span>
			<span style="margin-left: 20px;">☞  상품 리스트 총 <span style="color: red;">${total_cnt}</span> 개</span>
			</span>
		</li>
	</ul>
</nav>

<c:forEach var="bean" items="${proMainList}" varStatus="no">
<table style="width: 960px; padding: 0; border-spacing: 0; border-bottom: #336699 1px solid; padding-bottom: 5px; padding-top: 5px;">
<tr>
	<td width="50" align="center">
		<input type="checkbox" name="" />
	</td>
	<td width="100" align="center">
		<img id="${bean.pro_no }" src="<%=cp %>/product_img/${bean.pmg_file}" style="width: 80px; height: 80px; cursor: move;">
	</td>
	<td width="570">
		<table>
		<tr>
			<td style="font-weight: bold;">
			<a href="javascript:goProMainView(${bean.pro_no},'${bean.pro_pcl_no}')">${bean.pro_name}</a>
			</td>
		</tr>
		<tr>
			<td style="color: #999999;">${bean.psm_conent}</td>
		</tr>
		<tr>
			<td style="color: #6666CC;">등록일 : ${bean.pro_regdate}</td>
		</tr>
		</table>
	</td>
	<td width="140" align="right" style="color: #FF3333; font-size: 11pt; font-weight: bold;">${bean.pro_ch_price}</td>
	<td width="100" align="center">
		<c:if test="${login.cmd != 101}">
		<span class="box_button5">바로구매</span>
		</c:if>
		<c:if test="${login.cmd == 101}">
		<a href="<%=cp %>/sct/sct_odr_doc.ama?sct_pro_no=${bean.pro_no }&sct_pro_part=1&sct_pro_muti=2&sct_mem_no=${login.mem_no }" class="box_button5">바로구매</a>
		</c:if>
		
		<c:if test="${login.cmd != 101}">
		<span class="box_button7">장바구니</span>
		</c:if>
		<c:if test="${login.cmd == 101}">
		<a href="javascript:goShopCart(${bean.pro_no }, ${login.mem_no}, 1, 0);" class="box_button7">장바구니</a>
		</c:if>
	</td>
</tr>
</table>
</c:forEach>

<p:page p_totalPage="${p_totalPage}" p_nowPage="${p_nowPage}" p_list="${p_list}" p_pagePerBlock="${p_pagePerBlock}" />

</body>
</html>