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
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
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
	
	function addr_serarch(){
		new daum.Postcode({
			oncomplete: function(data) {
				$("#mem_zonecode").val(data.zonecode);
				$("#mem_addr").val(data.address);
				$("#mem_addr2").focus();
			}
		}).open();
	}
	function onMemJoin(f){
		alert("회원가입");
	}
	
</script>
</head>
<body>
	<header id="top_header">
	<%-- 상단 헤더 include 처리 --%> <%-- <%=cp %>/PclController?dana=member_join --%>
	<jsp:include page="../top/top_menu.jsp" flush="false" />
	
	</header>
	
	<div id="content">
	
	<!-- 전체 -->
	<div id="proMainViewDiv" style="width: 960px; margin-left: 5px;">
	
	<form method="post">
	
	<table style="border: 1px dotted black; border-spacing:0px; padding: 10px 5px 20px 5px; margin: auto;">
	<tr>
		<td>
		<img src="<%=cp %>/img/member_danacom_top02.jpg" />
		</td>
	</tr>
	<tr>
		<td style="960px;">
			<table style="width: 863px; border-spacing:0px; margin: auto;">
			<tr>
			<td width="863" height="10">			
				<p><img src="<%=cp %>/img/member_agreement_01-08.gif" /></p>
			</td>
			</tr>
			<tr><td style="background-color: #1A6BAB;width: 863px; height: 3px;"><p></p></td></tr>
			</table>
		</td>
	</tr>
	<tr>
		<td>
		<table style="width: 863px; border-spacing:0px; margin: auto;">
		<tr>
			<td style="border-left: rgb(226,226,226) 1px solid;  border-bottom: rgb(226,226,226) 1px solid" width="36" bgColor=#f6f7f9 height=30>
				<p align="right"><img src="<%=cp %>/img/member_n_icon.gif" border="0"> </p></td>
			<td style="border-bottom: rgb(226,226,226) 1px solid" width="18" bgColor=#f6f7f9 height=30><p align=center>&nbsp;</p></td>
			<td style="border-right: rgb(226,226,226) 1px solid; border-bottom: rgb(226,226,226) 1px solid" width="117" bgColor=#f6f7f9 height=30>
				<p align="left"><b><font color=black face="돋움"><span style="font-size:9pt;">이름</span></font></b></p></td>
			<td style="border-right: rgb(226,226,226) 1px solid; border-bottom: rgb(226,226,226) 1px solid" width="689" bgColor=white height=30>
				<p align="left">&nbsp;&nbsp;
				<input type="text" style="border-right: rgb(204,204,204) 1px solid; border-top: rgb(204,204,204) 1px solid; 
					border-left: rgb(204,204,204) 1px solid; border-bottom: rgb(204,204,204) 1px solid" size="15" name="mem_name" maxlength="30" /></p></td>
		</tr>
		<tr>
			<td style="border-left: rgb(226,226,226) 1px solid;  border-bottom: rgb(226,226,226) 1px solid" width="36" bgColor=#f6f7f9 height=30>
				<p align="right"><img src="<%=cp %>/img/member_n_icon.gif" border="0"></p></td>
			<td style="border-bottom: rgb(226,226,226) 1px solid" width="18" bgColor=#f6f7f9 height=30><p align=center>&nbsp;</p></td>
			<td style=" border-right: rgb(226,226,226) 1px solid; border-bottom: rgb(226,226,226) 1px solid" width="117" bgColor=#f6f7f9 height=30>
				<p align="left"><b><font color=black face="돋움"><span style="font-size:9pt;">회원 아이디</span></font></b></p></td>
			<td style="border-right: rgb(226,226,226) 1px solid; border-bottom: rgb(226,226,226) 1px solid" width="689" bgColor=white height=30>
				<p align="left">&nbsp;&nbsp;
				<input type="text" style="border-right: rgb(204,204,204) 1px solid; border-top: rgb(204,204,204) 1px solid; 
					border-left: rgb(204,204,204) 1px solid; border-bottom: rgb(204,204,204) 1px solid" size="15" name="mem_id" maxlength="30" /></p></td>
		</tr>
		<tr>
			<td style="border-left: rgb(226,226,226) 1px solid;  border-bottom: rgb(226,226,226) 1px solid" width="36" bgColor=#f6f7f9 height=30>
				<p align="right"><img src="<%=cp %>/img/member_n_icon.gif" border="0"> </p></td>
			<td style="border-bottom: rgb(226,226,226) 1px solid" width="18" bgColor=#f6f7f9 height=30><p align=center>&nbsp;</p></td>
			<td style=" border-right: rgb(226,226,226) 1px solid; border-bottom: rgb(226,226,226) 1px solid" width="117" bgColor=#f6f7f9 height=30>
				<p align="left"><b><font color=black face="돋움"><span style="font-size:9pt;">비밀번호</span></font></b></p></td>
			<td style="border-right: rgb(226,226,226) 1px solid; border-bottom: rgb(226,226,226) 1px solid" width="689" bgColor=white height=30>
				<p align="left">&nbsp;&nbsp;
				<input style="border-right: rgb(204,204,204) 1px solid; border-top: rgb(204,204,204) 1px solid; 
					border-left: rgb(204,204,204) 1px solid; border-bottom: rgb(204,204,204) 1px solid" size="19" name="mem_pass" type="password" maxlength="30" /></p></td>
		</tr>
		<tr>
			<td style="border-left: rgb(226,226,226) 1px solid;  border-bottom: rgb(226,226,226) 1px solid" width="36" bgColor=#f6f7f9 height=30>
				<p align="right"><img src="<%=cp %>/img/member_n_icon.gif" border="0"></p></td>
			<td style="border-bottom: rgb(226,226,226) 1px solid" width="18" bgColor=#f6f7f9 height=30><p align=center>&nbsp; </p></td>
			<td style=" border-right: rgb(226,226,226) 1px solid; border-bottom: rgb(226,226,226) 1px solid" width="117" bgColor=#f6f7f9 height=30>
				<p align="left"><b><font color=black face="돋움"><span style="font-size:9pt;">비밀번호확인</span></font></b></p></td>
			<td style="border-right: rgb(226,226,226) 1px solid; border-bottom: rgb(226,226,226) 1px solid" width="689" bgColor=white height=30>
				<p align="left">&nbsp;&nbsp;
				<input style="border-right: rgb(204,204,204) 1px solid; border-top: rgb(204,204,204) 1px solid; 
					border-left: rgb(204,204,204) 1px solid; border-bottom: rgb(204,204,204) 1px solid" size="19" name="mem_repass" type="password" maxlength="30" /></p></td>
		</tr>
		<tr>
			<td style="border-left: rgb(226,226,226) 1px solid;  border-bottom: rgb(226,226,226) 1px solid" width="36" bgColor=#f6f7f9 height=30>
				<p align="right"><img src="<%=cp %>/img/member_n_icon.gif" border="0"></p></td>
			<td style="border-bottom: rgb(226,226,226) 1px solid" width="18" bgColor=#f6f7f9 height=30><p>&nbsp;</p></td>
			<td style=" border-right: rgb(226,226,226) 1px solid; border-bottom: rgb(226,226,226) 1px solid" width="117" bgColor=#f6f7f9 height=30>
				<p align="left"><b><font color=black face="돋움"><span style="font-size:9pt;">이메일</span></font></b></p></td>
			<td style="border-right: rgb(226,226,226) 1px solid; border-bottom: rgb(226,226,226) 1px solid" width="689" bgColor=white height=30>
				<p align="left">&nbsp;&nbsp;
				<input type="text" style="border-right: rgb(204,204,204) 1px solid; border-top: rgb(204,204,204) 1px solid; 
					border-left: rgb(204,204,204) 1px solid; border-bottom: rgb(204,204,204) 1px solid" size="25" name="mem_email" maxlength="40" /></p></td>
		</tr>
		<tr>
			<td style="border-left: rgb(226,226,226) 1px solid;  border-bottom: rgb(226,226,226) 1px solid" width="36" bgColor=#f6f7f9 height=30>
				<p align="right"><img src="<%=cp %>/img/member_n_icon.gif" border="0"> </p></td>
			<td style="  border-bottom: rgb(226,226,226) 1px solid" width="18" bgColor=#f6f7f9 height=30><p align=center>&nbsp; </p></td>
			<td style=" border-right: rgb(226,226,226) 1px solid; border-bottom: rgb(226,226,226) 1px solid" width="117" bgColor=#f6f7f9 height=30>
				<p align="left"><b><font color=black face="돋움"><span style="font-size:9pt;">휴대폰 번호</span></font></b></p></td>
			<td style="border-right: rgb(226,226,226) 1px solid; border-bottom: rgb(226,226,226) 1px solid" width="689" bgColor=white height=30>
				<p align="left">&nbsp;&nbsp;
				<input type="text" style="border-right: rgb(204,204,204) 1px solid; border-top: rgb(204,204,204) 1px solid; 
					border-left: rgb(204,204,204) 1px solid; border-bottom: rgb(204,204,204) 1px solid" size="25" name="mem_hp" maxlength="30" /></p></td>
		</tr>
		<tr>
			<td style="border-left: rgb(226,226,226) 1px solid;  border-bottom: rgb(226,226,226) 1px solid" width="36" bgColor=#f6f7f9 height=30><p align="right">&nbsp;</p></td>
			<td style="border-bottom: rgb(226,226,226) 1px solid" width="18" bgColor=#f6f7f9 height=30><p>&nbsp;</p></td>
			<td style=" border-right: rgb(226,226,226) 1px solid; border-bottom: rgb(226,226,226) 1px solid" width="117" bgColor=#f6f7f9 height="30">
				<p align="left"><b><font color=black face="돋움"><span style="font-size:9pt;">일반주소</span></font></b>
				</p></td>
			<td style="border-right: rgb(226,226,226) 1px solid; border-bottom: rgb(226,226,226) 1px solid"width="689" bgColor=white height=30>
				<p align="left">&nbsp;&nbsp;
				<input type="text" style="border-right: rgb(204,204,204) 1px solid; border-top: rgb(204,204,204) 1px solid; 
					border-left: rgb(204,204,204) 1px solid; border-bottom: rgb(204,204,204) 1px solid; width: 60px; text-align: center;" 
					name="mem_zonecode" id="mem_zonecode" readonly="readonly" />
				<input type="text" style="border-right: rgb(204,204,204) 1px solid; border-top: rgb(204,204,204) 1px solid; 
					border-left: rgb(204,204,204) 1px solid; border-bottom: rgb(204,204,204) 1px solid; width: 500px;" name="mem_addr" id="mem_addr" readonly="readonly" />
				<span style="display: inline-block; margin-top: 5px; margin-left: 12px;">
				<input type="text" style="border-right: rgb(204,204,204) 1px solid; border-top: rgb(204,204,204) 1px solid; 
					border-left: rgb(204,204,204) 1px solid; border-bottom: rgb(204,204,204) 1px solid; width: 525px;" name="mem_addr2" id="mem_addr2" maxlength="50" />
				</span>	
				<span style="padding: 4px 9px 3px 9px; border: 1px solid #8BBDFF; color: #ffffff; background: #8BBDFF; cursor: pointer;" onclick="addr_serarch();">검색</span>
				</p>
			</td>
		</tr>
		<tr>
			<td style="border-left: rgb(226,226,226) 1px solid; border-bottom: rgb(226,226,226) 1px solid" width="36" bgColor=#f6f7f9 height=30><p align="right">&nbsp;</p></td>
			<td style="border-bottom: rgb(226,226,226) 1px solid" width="18" bgColor=#f6f7f9 height=30><p align=center>&nbsp;</p></td>
			<td style=" border-right: rgb(226,226,226) 1px solid; border-bottom: rgb(226,226,226) 1px solid" width="117" bgColor=#f6f7f9 height=30>
				<p align="left"><b><font color=black face="돋움"><span style="font-size:9pt;">일반 전화번호</span></font></b></p></td>
			<td style="border-right: rgb(226,226,226) 1px solid; border-bottom: rgb(226,226,226) 1px solid" width="689" bgColor=white height=30>
				<p align="left">&nbsp;&nbsp;
				<input type="text" style="border-right: rgb(204,204,204) 1px solid; border-top: rgb(204,204,204) 1px solid; 
					border-left: rgb(204,204,204) 1px solid; border-bottom: rgb(204,204,204) 1px solid" size="25" name="mem_tel" maxlength="15" /></p></td>
		</tr>
		</table>
		</td>
	</tr>
	</table>
	<p align="center"><img src="<%=cp %>/img/member_agreement_ok1.gif" onclick="onMemJoin(this.form);" style="cursor: pointer;" /></p>
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