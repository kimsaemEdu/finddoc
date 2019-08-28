<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
</style>
<title>Insert title here</title>
</head>
<body>
	<h2>승인한 병원목록</h2>
	<div class="container-fluid">
		<table class="table table-hover">
			<th>회원번호</th>
			<th>병원명</th>
			<th>주소</th>
			<th>대표</th>
			<tr>
				<td>000001</td>
				<td>방배소아과</td>
				<td>서울특별시 방배동 효성로 193</td>
				<td>김사과</td>
			</tr>
		</table>
	</div>
	<form action="">
		<select name="search">
			<option>회원번호</option>
			<option>병원명</option>
			<option>주소</option>
			<option>대표</option>
		</select> <input type="text"> <input type="button" value="검색">
	</form>
</body>
</html>



