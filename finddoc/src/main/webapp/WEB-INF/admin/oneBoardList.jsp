<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Bootstrap Example</title>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<style>
body {
	color: black;
}

#title {
	text-align: center;
	padding: 40px;
}

table {
	width: 600px;
}

.input-group {
	width: 300px;
}

.form-control {
	width: 100px;
}
</style>
</head>
<body>
	<div id="title">
		<h2>1:1문의 게시판</h2>
	</div>
	<div style="padding-top: 30px">
		<table class="table">
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>등록일</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="board" items="${board }">
					<tr>
						<td>${board.board_no }</td>
						<td><a
							href="/erp/board/read.do?board_no=${board.board_no }&action=read">${board.title}</a></td>
						<td>${board.id }</td>
						<td>${board.write_date }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<form name="search" action="/erp/board/search.do">
		<select class="form-control col-sm-2" name="tag" id="tag">
			<option value="id">작성자</option>
			<option value="title">제목</option>
			<option value="content">본문</option>
			<option value="write_date">작성일</option>
		</select>
		<div class="input-group">
			<input type="text" class="form-control col-sm-2" name="search">
			<span class="input-group-btn">
				<button class="btn btn-default" type="submit">
					<span class="glyphicon glyphicon-search"></span>
				</button>
			</span>
		</div>
	</form>

</body>
</html>
