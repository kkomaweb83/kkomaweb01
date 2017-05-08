<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String cp = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=Edge" />
<title>꼬마web의 놀이터</title>
<style type="text/css">
.midLayout
{
	position: absolute;
	margin:-100px 0px 0px -200px;
	top: 50%;
	left: 50%;
	text-align: left;
	overflow: auto;
}
.box_top{
 	font-size: 9pt;
 	border-top: gray 1px solid;
 	border-right: gray 1px solid;
 	border-bottom: gray 1px solid;
 	border-left: gray 1px solid;
 	padding: 5px;
 	vertical-align: middle;
 	text-align: center;
 }
</style>
<script type="text/javascript">

</script>
</head> 
<body>
<div style="width: 960px; margin:0 auto;">

	<div class="midLayout">
		<table style="width: 400px; height: 200px;" class="box_top">
		<tbody>
			<tr>
				<td align="center">
					<img src="<%=cp %>/img/index02.gif" alt="꼬마web의 놀이터" />
				</td>
			</tr>
			<tr>
				<td align="center">
					<a href="<%=cp %>/ProController?dana=pro_main_prelist&pro_pcl_no=0101"><img src="<%=cp %>/img/top_main01.gif" alt="다나컴" /></a>
				</td>
			</tr>
		</tbody>
		</table>
	</div>

</div>

</body>
</html>