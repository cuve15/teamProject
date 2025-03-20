<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../common/common.jsp" %>
UpdateForm.jsp<br>
<%
	String[] area = {"유럽","동남아","일본","중국"};
	String[] style = {"패키지","크루즈","자유여행","골프여행"};
	String[] price = {"100~200","200~300","300~400","400~500"};
	
	pageContext.setAttribute("area", area);
	pageContext.setAttribute("style", style);
	pageContext.setAttribute("price", price);
%>
<style type="text/css">
	.err{
		font-size: 10pt;
		color: red;
		font-weight: bold;
	}
	table {
		width: 650px;
		margin: auto;
	}
</style>
<script type="text/javascript">
function golist() {
	location.href="list.tv";
}
</script>
<h2 align="center">여행 정보 수정 화면</h2>
<form:form commandName="tb" action="update.tv" method="post">
	<input type="hidden" name="num" value="${tb.num }">
	<table border="1">
		<tr>
			<td colspan="2" align="right">
				<a href="list.tv">목록보기</a>
				<input type="button" value="목록보기" onClick="golist()">
			</td>
		</tr>
		<tr>
			<td width="100">이름</td>
			<td>
				<input type="text" name="name" value="${tb.name }">
				<form:errors cssClass="err" path="name"/>
			</td>
		</tr>
		<tr>
			<td width="100">나이</td>
			<td>
				<input type="text" name="age" value="${tb.age }">
				<form:errors cssClass="err" path="age"/>
			</td>
		</tr>
		<tr>
			<td width="100">관심지역</td>
			<td>
				<c:forEach var="ar" items="${area }">
					<input type="checkbox" name="area" value="${ar }" <c:if test="${fn:contains(tb.area,ar) }">checked</c:if>>${ar }
				</c:forEach>
				<form:errors cssClass="err" path="area"/>
			</td>
		</tr>
		<tr>
			<td width="100">여행 타입</td>
			<td>
				<c:forEach var="st" items="${style }">
					<input type="radio" name="style" value="${st }" <c:if test="${tb.style == st }">checked</c:if>>${st }
				</c:forEach>
				<form:errors cssClass="err" path="style"/>
			</td>
		</tr>
		<tr>
			<td width="100">가격</td>
			<td>
				<select name="price">
						<option value="">선택하세요</option>
					<c:forEach var="pr" items="${price }">
						<option value="${pr }" <c:if test="${tb.price == pr }">selected</c:if>>${pr }</option>
					</c:forEach>
				</select>
				<form:errors cssClass="err" path="price"/>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="left">
				<input type="submit" value="수정하기">
			</td>
		</tr>
	</table>
</form:form>