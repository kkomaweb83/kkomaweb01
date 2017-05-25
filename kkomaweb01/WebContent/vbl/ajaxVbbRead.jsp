<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="p" tagdir="/WEB-INF/tags" %>
<% String cp = request.getContextPath(); %>

<script type="text/javascript">
	$(function() {
		$("#dialog").dialog({
			autoOpen:true, //자동으로 열리지않게
			width:600,
			height:500,
			modal:false, //모달대화상자
            resizable:false, //크기 조절 못하게
			show : 'slide', hide : 'slide',
			position : [500, 500],
			buttons: {
				"등록": function() {
            		ajaxBtlDetJoin('${vbbContent.vbb_no}');
					$(this).dialog('close');
				},
				"취소": function() {
					$(this).dialog('close');
				}
			}
		});
	});
</script>

<div id="dialog" title="공유견적서 상세" style="display: none; width: 90%;" align="left">
	<table class="lngTable2">
		<tr>
			<th width="10%">번호	</th>
			<th width="30%">글쓴이</th>
			<th width="30%">날짜</th>
			<th width="10%">추천수</th>
			<th width="10%">조회수</th>
			<th width="10%">배틀등록여부</th>
		</tr>
		<tr>
			<td>${vbbContent.vbb_no}</td>
			<td>${vbbContent.mem_id}</td>
			<td>${vbbContent.vbb_date}</td>
			<td>${vbbContent.vbb_recomm}</td>
			<td>${vbbContent.vbb_count}</td>
			<td>${vbbContent.vbb_btr_answer}</td>
		</tr>
		<tr>
			<th>제목</th>
			<td colspan="5">${vbbContent.vbb_title}</td>
		</tr>
		<tr>
			<th>글 내용</th>
			<td colspan="5"><pre>${vbbContent.vbb_content }</pre></td>
		</tr>
	</table>
	
	
	<div class="title_box3" style="width: 90%;">
	<span style="margin-right: 10px;">☞  견적서 상품 목록</span> 
	</div>
	
	<div align="left" style="width: 90%;">
	<c:forEach var="vbbPro" items="${vbbProList}">
		<table width="100%;" align="center" cellpadding="0" cellspacing="0" 
					style="border-bottom: #336699 1px solid; padding-bottom: 5px; padding-top: 5px;">
			<tr>
				<td width="10%" align="left">
					${vbbPro.pcl_name }
				</td>
				<td width="20%" align="center">
					<img src="<%=cp %>/product_img/${vbbPro.pmg_file }" style="width: 60px; height: 60px; border: 0px;" />
				</td>
				<td width="50%">
					<table align="left">
						<tr>
							<td style="font-weight: bold;" align="left">
								${vbbPro.pro_name }
							</td>
						</tr>
						<tr>
							<td style="color: #6666CC;" align="left">
								등록일 : ${vbbPro.pro_regdate }
							</td>
						</tr>
					</table>
				</td>
				<td width="10%">
					${vbbPro.vds_quantity }개 
				</td>
				<td width="1%" align="right" style="color: #FF3333; font-size: 11pt; font-weight: bold;">
					${vbbPro.pro_disprice }
				</td>
			</tr>
		</table>
	</c:forEach>
	</div>
</div>       