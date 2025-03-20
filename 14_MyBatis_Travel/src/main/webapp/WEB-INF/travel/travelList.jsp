<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../common/common.jsp" %>
list.jsp<br>
<script type="text/javascript">
function insert() {
	location.href = "insert.tv";
}
function update(num) {
	location.href = "update.tv?num=" + num;
}
</script>
<style type="text/css">
	table,form {
		width: 700;
		margin: auto;
	}
</style>
<h2>여행 리스트 화면(${totalCount} / ${fn:length(lists) })</h2>
<form action="list.tv" method="get">
	<select name="whatColumn">
		<option value="">전체검색</option>
		<option value="area" <c:if test="${whatColumn == 'area' }">selected</c:if>>지역</option>
		<option value="style" <c:if test="${whatColumn == 'style' }">selected</c:if>>여행 타입</option>
	</select>
	<input type="text" name="keyword" value="${keyword }">
	<input type="submit" value="검색">
</form>
<br>
<table border="1">
	<tr>
		<td colspan="8" align="right">
			<input type="button" value="추가하기" onClick="insert()">
		</td>
	</tr>
	<tr>
		<th>번호</th>
		<th>이름</th>
		<th>나이</th>
		<th>지역</th>
		<th>여행 타입</th>
		<th>가격</th>
		<th>수정</th>
		<th>삭제</th>
	</tr>
	<c:if test="${fn:length(lists) == 0 }">
		<tr align="center">
			<td colspan="8">
				레코드가 없습니다.
			</td>
		</tr>
	</c:if>
	<c:forEach var="tv" items="${lists }">
		<tr align="center">
			<td>${tv.num }</td>
			<td>${tv.name }</td>
			<td>${tv.age }</td>
			<td>${tv.area }</td>
			<td>${tv.style }</td>
			<td>${tv.price }</td>
			<td><input type="button" value="수정" onClick="update(${tv.num})"></td>
			<td><a href="delete.tv?num=${tv.num }">삭제</a></td>
		</tr>
	</c:forEach>
</table>
<br><br>
<p align="center">
${pageInfo.pagingHtml }
</p>
