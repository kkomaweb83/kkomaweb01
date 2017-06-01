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
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet" type="text/css" href="<%=cp %>/css/kkoma_new_01.css" />
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css" />
<style type="text/css">
input {
	padding: 3px;
}
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
	<div id="proMainViewDiv" style="width: 960px; margin: 0 auto;">
	
	<form action="<%=cp %>/PclController?dana=member_join" method="post">
	
	<table style="border: 1px dotted black;">
	
	<tr><td width="960" height="10"><p></p></td></tr>
	<tr><td><img src="<%=cp %>/img/member_danacom_top.jpg" /></td></tr>
	<tr>
		<td width="970">
	    <p align="center"></p>
		<table style="width: 863px;">
		<tr>
		<td width="863" height="10">			
			<p><img src="<%=cp %>/img/member_agreement_01-08.gif" /></p>
		</td>
		</tr>
		<tr><td width="863" height="3"></td></tr>
		<tr><td width="863" height="3" bgcolor="1A6BAB"><p></p></td></tr>
		</table>
		</td>
	</tr>
	<tr>
		<td>
		<table style="width: 863px;">
		<tr>
			<td style="border-left: rgb(226,226,226) 1px solid;  border-bottom: rgb(226,226,226) 1px solid" width="36" bgColor=#f6f7f9 height=30>
				<p align="right"><img src="<%=cp %>/img/member_n_icon.gif" border="0"> </p></td>
			<td style="border-bottom: rgb(226,226,226) 1px solid" width="18" bgColor=#f6f7f9 height=30><p align=center>&nbsp;</p></td>
			<td style="border-right: rgb(226,226,226) 1px solid; border-bottom: rgb(226,226,226) 1px solid" width="117" bgColor=#f6f7f9 height=30>
				<p align="left"><B><FONT color=black face="돋움"><span style="font-size:9pt;">이름</span></FONT></B></p></td>
			<td style="border-right: rgb(226,226,226) 1px solid; border-bottom: rgb(226,226,226) 1px solid" width="689" bgColor=white height=30>
				<p align="left">&nbsp;&nbsp;
				<input type="text" style="border-right: rgb(204,204,204) 1px solid; border-top: rgb(204,204,204) 1px solid; 
					border-left: rgb(204,204,204) 1px solid; border-bottom: rgb(204,204,204) 1px solid" size="15" name="mem_name" value="" /></p></td>
		</tr>
		<tr>
			<td style="border-left: rgb(226,226,226) 1px solid;  border-bottom: rgb(226,226,226) 1px solid" width="36" bgColor=#f6f7f9 height=30>
				<p align="right"><img src="<%=cp %>/img/member_n_icon.gif" border="0"></p></td>
			<td style="border-bottom: rgb(226,226,226) 1px solid" width="18" bgColor=#f6f7f9 height=30><p align=center>&nbsp;</p></td>
			<td style=" border-right: rgb(226,226,226) 1px solid; border-bottom: rgb(226,226,226) 1px solid" width="117" bgColor=#f6f7f9 height=30>
				<p align="left"><B><FONT color=black face="돋움"><span style="font-size:9pt;">회원 아이디</span></FONT></B></p></td>
			<td style="border-right: rgb(226,226,226) 1px solid; border-bottom: rgb(226,226,226) 1px solid" width="689" bgColor=white height=30>
				<p align="left">&nbsp;&nbsp;
				<input type="text" style="border-right: rgb(204,204,204) 1px solid; border-top: rgb(204,204,204) 1px solid; 
					border-left: rgb(204,204,204) 1px solid; border-bottom: rgb(204,204,204) 1px solid" size="15" name="mem_id" value="" /></p></td>
		</tr>
		<tr>
			<td style="border-left: rgb(226,226,226) 1px solid;  border-bottom: rgb(226,226,226) 1px solid" width="36" bgColor=#f6f7f9 height=30>
				<p align="right"><img src="<%=cp %>/img/member_n_icon.gif" border="0"> </p></td>
			<td style="border-bottom: rgb(226,226,226) 1px solid" width="18" bgColor=#f6f7f9 height=30><p align=center>&nbsp;</p></td>
			<td style=" border-right: rgb(226,226,226) 1px solid; border-bottom: rgb(226,226,226) 1px solid" width="117" bgColor=#f6f7f9 height=30>
				<p align="left"><B><FONT color=black face="돋움"><span style="font-size:9pt;">비밀번호</span></FONT></B></p></td>
			<td style="border-right: rgb(226,226,226) 1px solid; border-bottom: rgb(226,226,226) 1px solid" width="689" bgColor=white height=30>
				<p align="left">&nbsp;&nbsp;
				<input style="border-right: rgb(204,204,204) 1px solid; border-top: rgb(204,204,204) 1px solid; 
					border-left: rgb(204,204,204) 1px solid; border-bottom: rgb(204,204,204) 1px solid" size="19" name="mem_pass" type="password" value="" /></p></td>
		</tr>
		<tr>
			<td style="border-left: rgb(226,226,226) 1px solid;  border-bottom: rgb(226,226,226) 1px solid" width="36" bgColor=#f6f7f9 height=30>
				<p align="right"><img src="<%=cp %>/img/member_n_icon.gif" border="0"></p></td>
			<td style="border-bottom: rgb(226,226,226) 1px solid" width="18" bgColor=#f6f7f9 height=30><p align=center>&nbsp; </p></td>
			<td style=" border-right: rgb(226,226,226) 1px solid; border-bottom: rgb(226,226,226) 1px solid" width="117" bgColor=#f6f7f9 height=30>
				<p align="left"><B><FONT color=black face="돋움"><span style="font-size:9pt;">비밀번호 확인</span></FONT></B></p></td>
			<td style="border-right: rgb(226,226,226) 1px solid; border-bottom: rgb(226,226,226) 1px solid" width="689" bgColor=white height=30>
				<p align="left">&nbsp;&nbsp;
				<input style="border-right: rgb(204,204,204) 1px solid; border-top: rgb(204,204,204) 1px solid; 
					border-left: rgb(204,204,204) 1px solid; border-bottom: rgb(204,204,204) 1px solid" size="19" name="mem_repass" type="password" value="" /></p></td>
		</tr>
		<tr>
			<td style="border-left: rgb(226,226,226) 1px solid;  border-bottom: rgb(226,226,226) 1px solid" width="36" bgColor=#f6f7f9 height=30>
				<p align="right"><img src="<%=cp %>/img/member_n_icon.gif" border="0"></p></td>
			<td style="border-bottom: rgb(226,226,226) 1px solid" width="18" bgColor=#f6f7f9 height=30><p>&nbsp;</p></td>
			<td style=" border-right: rgb(226,226,226) 1px solid; border-bottom: rgb(226,226,226) 1px solid" width="117" bgColor=#f6f7f9 height=30>
				<p align="left"><B><FONT color=black face="돋움"><span style="font-size:9pt;">이메일</span></FONT></B></p></td>
			<td style="border-right: rgb(226,226,226) 1px solid; border-bottom: rgb(226,226,226) 1px solid" width="689" bgColor=white height=30>
				<p align="left">&nbsp;&nbsp;
				<input type="text" style="border-right: rgb(204,204,204) 1px solid; border-top: rgb(204,204,204) 1px solid; 
					border-left: rgb(204,204,204) 1px solid; border-bottom: rgb(204,204,204) 1px solid" size="25" name="mem_email" value="" /></p></td>
		</tr>
		<tr>
			<td style="border-left: rgb(226,226,226) 1px solid;  border-bottom: rgb(226,226,226) 1px solid" width="36" bgColor=#f6f7f9 height=30>
				<p align="right"><img src="<%=cp %>/img/member_n_icon.gif" border="0"> </p></td>
			<td style="  border-bottom: rgb(226,226,226) 1px solid" width="18" bgColor=#f6f7f9 height=30><p align=center>&nbsp; </p></td>
			<td style=" border-right: rgb(226,226,226) 1px solid; border-bottom: rgb(226,226,226) 1px solid" width="117" bgColor=#f6f7f9 height=30>
				<p align="left"><B><FONT color=black face="돋움"><span style="font-size:9pt;">휴대폰 번호</span></FONT></B></p></td>
			<td style="border-right: rgb(226,226,226) 1px solid; border-bottom: rgb(226,226,226) 1px solid" width="689" bgColor=white height=30>
				<p align="left">&nbsp;&nbsp;
				<input type="text" style="border-right: rgb(204,204,204) 1px solid; border-top: rgb(204,204,204) 1px solid; 
					border-left: rgb(204,204,204) 1px solid; border-bottom: rgb(204,204,204) 1px solid" size="25" name="mem_hp" value="" /></p></td>
		</tr>
		<tr>
			<td style="border-left: rgb(226,226,226) 1px solid;  border-bottom: rgb(226,226,226) 1px solid" width="36" bgColor=#f6f7f9 height=30>
				<p align="right"><img src="<%=cp %>/img/member_n_icon.gif" border="0"></p></td>
			<td style="border-bottom: rgb(226,226,226) 1px solid" width="18" bgColor=#f6f7f9 height=30><p>&nbsp;</p></td>
			<td style=" border-right: rgb(226,226,226) 1px solid; border-bottom: rgb(226,226,226) 1px solid" width="117" bgColor=#f6f7f9 height="30">
				<p align="left"><B><FONT color=black face="돋움"><span style="font-size:9pt;">일반주소</span></FONT></B></p></td>
			<td style="border-right: rgb(226,226,226) 1px solid; border-bottom: rgb(226,226,226) 1px solid"width="689" bgColor=white height=30>
				<p align="left">&nbsp;&nbsp;
				<input type="text" style="border-right: rgb(204,204,204) 1px solid; border-top: rgb(204,204,204) 1px solid; 
					border-left: rgb(204,204,204) 1px solid; border-bottom: rgb(204,204,204) 1px solid" size="70" name="mem_addr" value="" /></p></td>
		</tr>
		<tr>
			<td style="border-left: rgb(226,226,226) 1px solid; border-bottom: rgb(226,226,226) 1px solid" width="36" bgColor=#f6f7f9 height=30><p align="right">&nbsp;</p></td>
			<td style="border-bottom: rgb(226,226,226) 1px solid" width="18" bgColor=#f6f7f9 height=30><p align=center>&nbsp;</p></td>
			<td style=" border-right: rgb(226,226,226) 1px solid; border-bottom: rgb(226,226,226) 1px solid" width="117" bgColor=#f6f7f9 height=30>
				<p align="left"><B><FONT color=black face="돋움"><span style="font-size:9pt;">일반 전화번호</span></FONT></B> </p></td>
			<td style="border-right: rgb(226,226,226) 1px solid; border-bottom: rgb(226,226,226) 1px solid" width="689" bgColor=white height=30>
				<p align="left">&nbsp;&nbsp;
				<input type="text" style="border-right: rgb(204,204,204) 1px solid; border-top: rgb(204,204,204) 1px solid; 
					border-left: rgb(204,204,204) 1px solid; border-bottom: rgb(204,204,204) 1px solid" size="25" name="mem_tel" value="" /></p></td>
		</tr>
		</table>
		</td>
		</tr>
		</table>
		<p align="center"><input type="image"  src="<%=cp %>/img/member_agreement_ok1.gif"  value="회원가입" /></p>
		</form>	
	
	</div>
	<!-- 전체 -->
	
	</div>
	
	<footer>
	
	</footer>
<!-- 상세보기 dlg -->
<div id="dialog"></div>			
</body>
</html>