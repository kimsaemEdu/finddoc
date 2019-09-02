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
<style type="text/css">
#title {
	text-align: center;
	padding: 40px;
}

body {
	color: black;
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

#write {
	float: right;
	margin-right: 30px;
}

#searchbar {
	width: 300px;
}
</style>
</head>
<body>
	<div id="title">
		<h2>Q&A 게시판</h2>
	</div>

	<div class="container-fluid">
		<form>
			<c:if test="${loginuser.state=='user' }">
				<select class="form-control col-sm-2" name="search">
					<option value="굿닥">굿닥</option>
					<option value="똑닥">똑닥</option>
					<option value="뚝닥">뚝닥</option>
				</select>
			</c:if>
			<br>

			<table class="table table-hover">
				<th>번호</th>
				<th>병원명</th>
				<th>제목</th>
				<th>작성자</th>
				<th>등록일</th>
				<th>조회수</th>

				<c:forEach var="notice" items="${noticelist }">
					<tr>
						<td>${notice.noticeboardnum }</td>
						<td><a
							href="/finddoc/board/noticeBoard_read.do?noticeboardnum=${notice.noticeboardnum}&hname=${hname}">${hname}</a></td>
						<td>${notice.title }</td>
						<td>${loginuser.name }</td>
						<td>${notice.txupdate }</td>
						<td>${notice.noticecount }</td>
					</tr>
				</c:forEach>
			</table>
		</form>
	</div>

	<form action="/finddoc/board/noticeBoard_search.do">
		<select class="form-control col-sm-2" name="category">
			<option value="title">제목</option>
			<option value="text">본문</option>
			<option value="txupdate">작성일</option>
		</select> <input type="text" name="search" class="form-control col-sm-3"
			id="searchbar"> <input type="submit" value="검색"
			class="btn btn-default">
		<c:if test="${loginuser.state=='user' }">
			<input type="button" value="글쓰기" class="btn btn-default" id="write"
				onclick='location.href="/finddoc/board/noticeBoard_writeView.do"'>
		</c:if>
	</form>

</body>
</html>
