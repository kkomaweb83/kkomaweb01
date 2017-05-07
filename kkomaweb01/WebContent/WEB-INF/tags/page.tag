<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ tag trimDirectiveWhitespaces="true" %>
<%@ attribute name="p_pagePerBlock" required="true" type="java.lang.Integer" %>
<%@ attribute name="p_nowPage" required="true" type="java.lang.Integer" %>
<%@ attribute name="p_totalPage" required="true" type="java.lang.Integer" %>
<%@ attribute name="p_list" required="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	int nowPage = 1; // 현재페이지
	int pagePerBlock = p_pagePerBlock; // 블럭당 표현되는 페이지의 수
	int totalPage = 0; // 전체 페이지의수
	int totalBlock = 0; // 전체 블럭의 수
	int begin = 0; // 시작번호
	int end = 0;  // 끝번호
	
	// 1. 전체 페이지 설정
	totalPage = p_totalPage;
	
	// 2. 현재 페이지 설정
	nowPage = p_nowPage;
	
	// 현재 페이지를 이용한 블록의 시작번호 와 끝번호
	int beginPage = (int)((nowPage-1)/pagePerBlock)*pagePerBlock+1;
	int endPage = beginPage + pagePerBlock - 1;
	
	// 주의사항 : endPage 가 totalPage 보다 클수가 있다.
	if(endPage > totalPage) endPage = totalPage;
%>
<c:set var="beginPage" value="<%= beginPage %>" />
<c:set var="pagePerBlock" value="<%= pagePerBlock %>" />
<c:set var="endPage" value="<%= endPage %>" />
<c:set var="nowPage" value="<%= nowPage %>" />
<c:set var="totalPage" value="<%= totalPage %>" />

<ol class="paging">
	<c:choose>
		<c:when test="${beginPage <= pagePerBlock}">
		<li class="disable">이전으로9</li>
		</c:when>
		<c:otherwise>
		<li><a href="${p_list}&cPage=${beginPage-pagePerBlock}" >이전으로</a></li>
		</c:otherwise>
	</c:choose>
	<c:forEach var="i" begin="${beginPage}" end="${endPage}" step="1" varStatus="vs">
		<c:choose>
			<c:when test="${i == nowPage}">
			<li class="now">${i}</li>
			</c:when>
			<c:otherwise>
			<li><a href="${p_list}&cPage=${i}">${i}</a></li>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	<c:choose>
		<c:when test="${endPage >= totalPage}">
		<li class="disable">다음으로9</li>
		</c:when>
		<c:otherwise>
		<li><a href="${p_list}&cPage=${beginPage+pagePerBlock}" >다음으로</a></li>
		</c:otherwise>
	</c:choose>
</ol>