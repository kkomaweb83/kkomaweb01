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
<script type="text/javascript">
	$(function() {

	});
	
	function goProList(pro_pcl_no){
		location.href = "<%=cp %>/ProController?dana=pro_main_prelist&pro_pcl_no="+pro_pcl_no;
	}
</script>
</head>
<body>

<div id="top_title">
<a href="<%=cp %>/ProController?dana=pro_main_prelist&pro_pcl_no=0101"><img src="<%=cp %>/img/top_main01.gif" alt="다나컴" /></a>
</div>
<nav id="top_ltb">
	<ul>
		<li><a href="<%=cp %>/pcl/pcl_list.jsp">관리자모드</a></li>
	</ul>	
</nav>
<nav id="top_gnb">
	<ul>
		<li>
			<span>통합검색</span>
			<input type="text" class="box_input_left3" size="30" name="searchValue" value="" />
			<span class="box_button3">검색</span>
		</li>
	</ul>
</nav>
<nav id="top_lnb">
	<ul>
		<li><a href="#">가상견적서</a></li>
		<li><a href="#">공유견적서</a></li>
		<li><a href="#">베틀견적서</a></li>
	</ul>
</nav>
<nav id="top_rnb">
	<ul>
		<li><span></span></li>
		<li><a href="#">로그인</a></li>
		<li><a href="#">회원가입</a></li>
		<li><a href="#">장바구니</a></li>
		<li><a href="#">마이페이지</a></li>
	</ul>
</nav>

<!-- 상품분류 -->
<div style="width: 960px; margin: 0 auto; position: absolute; top: 93px;">
	<table style="width: 960px; padding: 0; border-spacing: 0;">
	<tr>
		<c:forEach var="bean" items="${class_list}" varStatus="vs">
		<c:if test="${vs.count < 3}">
		<td>
			<table style="width: 480px; padding: 0; border-spacing: 1px;">
			<tr><td style="width: 480px;" class="main_title1">${bean.pcl_name}</td></tr>
			<tr><td>
				<table style="width: 480px; padding: 0; border-spacing: 1px;">
				<tr>
					<c:forEach var="bean2" items="${bean.pcl_list}">
					<td class="main_title2">
						<a href="javascript:goProList('${bean2.pcl_no}');">${bean2.pcl_name}</a>
					</td>
					</c:forEach>
				</tr>
				</table>
			</td></tr>
			</table>
		</td>
		</c:if>
		</c:forEach>

	
	</tr>
	</table>
</div>

</body>
</html>