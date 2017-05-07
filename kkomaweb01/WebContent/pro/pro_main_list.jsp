<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=Edge" />
<title>컴퓨터 쇼핑몰의 최강자 DanaCom</title>
<script type="text/javascript" src="../js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="../js/kkoma01.js"></script>
<link rel="stylesheet" type="text/css" href="../css/kkoma_old.css" />
<style type="text/css">
li { list-style: none; }
a { text-decoration: none; }
a:hover { text-decoration: none; }
img { border: 0; }

#top_header {
	width: 960px;
	margin: 0 auto;
	height: 115px;
	position: relative;
}
#top_header > #top_title {
	position: absolute;
	left: 270px; top: 10px;
}
#top_header > #top_gnb {
	position: absolute;
	right: 0; top: 0;
}
#top_header > #top_lnb {
	position: absolute;
	left: 0; bottom: 10px;
}

#top_gnb > ul { overflow: hidden; }
#top_gnb > ul > li { float: left; }

#top_lnb > ul { overflow: hidden; }
#top_lnb > ul > li { float: left; }
#top_lnb > ul > li > a {
	display: block;
	padding: 7px 12px 5px 12px;
	border: 1px solid #3163C9;
	margin-left: 1px;
	color: #3163C9;
}
#top_lnb > ul > li > a:hover {
	background: #8BBDFF;
	color: white;
}
#top_lnb > ul > li:first-child > a { border-radius : 10px 0 0 10px; }
#top_lnb > ul > li:last-child > a { border-radius : 0 10px 10px 0; }

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
	
	</div>
	
	<footer>
	
	</footer>
</body>
</html>