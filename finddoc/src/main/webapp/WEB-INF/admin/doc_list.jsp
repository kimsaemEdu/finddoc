<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
<title>Insert title here</title>
</head>
<body>
	<h2>승인된 병원목록</h2>
	<div class="container-fluid">
		<form name="myform">
			<table class="table table-hover">
				<th>이용자ID</th>
				<th>병원명</th>
				<th>병원 주소</th>
				<c:forEach var="hoslist" items="${hoslist}">
					<tr> 
						<td><a>${hoslist.hadminid}</a></td>
						<td><a>${hoslist.hname}</a></td>
						<td>${hoslist.addr}</td>
					</tr>
				</c:forEach>
			</table>
		</form>
		<br>
		<form name="search" action="/finddoc/admin/acceptsearch.do">
			<select class="form-control col-sm-2" name="tag" id="tag">
				<option value="hname">병원명</option>
				<option value="addr">병웑 주소</option>
			</select>
			<div class="input-group">
				<input type="text" class="form-control col-sm-2" name="search"> <span
					class="input-group-btn">
					<button class="btn btn-default" type="submit">
						<span class="glyphicon glyphicon-search"></span>
					</button>
				</span>
			</div>
			</form>
	</div>
</body>
</html>




