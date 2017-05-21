<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String cp = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=Edge" />
<title>DanaCom 견적서</title>
</head>
<body>

<div style="text-align: center;">
	<span id="admin_top_title">▷ 견적서 메뉴 ◁</span>
</div>

<span class="box_button2">☞ 견적서관리</span>
<nav id="admin_menu_lnb">
	<ul>
		<li><a href="<%=cp %>/VblController?dana=vbl_main_prelist">- 가상견적서 리스트</a></li>
		<li><a href="<%=cp %>/VblController?dana=vbb_main_prelist">- 공유견적서 리스트</a></li>
		<li><a href="<%=cp %>/VblController?dana=btl_main_prelist">- 베틀견적서 리스트</a></li>
	</ul>
</nav>

<div style="height: 800px;"></div>

</body>
</html>