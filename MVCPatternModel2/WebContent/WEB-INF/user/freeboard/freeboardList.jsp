<%@ page language="JAVA" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시글 목록</title>
</head>
<body>
<div id="freeboardList_content">
	<div class="panel panel-blue">
    	<div class="panel-heading">게시판 목록</div>
		<table class="table table-bordered table-hover">
			<thead>
				<tr>
					<th scope="col" width="5%">No</th>
					<th scope="col" width="65%">제목</th>
					<th scope="col" width="10%">작성자</th>
					<th scope="col" width="10%">작성일</th>
					<th scope="col" width="10%">조회수</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${testList }" var="testList" varStatus="stat">	
				<tr>
					<td>${testList.bo_no }</td>
					<td>${testList.bo_title }</td>
					<td>${testList.bo_nickname }</td>
					<td>${testList.bo_reg_date }</td>
					<td>${testList.bo_hit }</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<div >
<form action="/user/freeboard/freeboardList.do" method="post" class="form-inline pull-right">
		<input id="search_keyword" type="text" placeholder="검색어 입력..." class="form-control" />
		<select class="form-control" name="search_keycode" >
			<option>검색조건</option>
			<option value="TOTAL">전체</option>
			<option value="TITLE">제목</option>
			<option value="CONTENT">내용</option>
			<option value="WRITER">작성자</option>
		</select>
	    <button type="submit" class="btn btn-primary form-control">검색</button>
	    <button type="button" class="btn btn-info form-control"  id="insertBtn" >게시글 등록</button>
</form>
</div>	
</body>
<script type="text/javascript">
$(function(){
	$('#insertBtn').click(function(){
		$(location).attr('href','/user/freeboard/freeboardForm.do');
	});
});
</script>
</html>