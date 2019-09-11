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

#delete {
	float: right;
	margin-right: 30px;
}
</style>
<title>Insert title here</title>
</head>
<script type="text/javascript">
	$(document).ready(function() {
		$(".ykiho").hide();
		
		$("#allchk").on("click",function(){
			//id로 해도 좋고 name으로 해도 좋아요 - allchk가 체크되면 
			if($('input:checkbox[name="allchk"]').is(":checked")==true){
				$('input:checkbox[name="myhosplist"]').each(function() {
					this.checked = true;
				 });
			}
			else{
				$('input:checkbox[name="myhosplist"]').each(function() {
					this.checked = false;
				 });
			}
		});
		
		$("#delete").click(function() {
			$('input:checkbox[name="myhosplist"]').each(function() {
				if($(this).is(":checked")){
					$.ajax({
						url : "/finddoc/mypage/delete_bookmark.do",
						type : "get",
						data :{
							"ykiho" : $(this).val()
						},
						success : function(message) {
							location.href="/finddoc/mypage/bookmark.do";
						},
						error : function() {
							alert("에러");
						}
					});
			}
		});
	});
})
</script>
<body>
	<div id="title">
		<h2>자주가는 병원 목록</h2>
	</div>

	<div class="container-fluid">
		<form name="search" action="/finddoc/mypage/search_bookmark.do">
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
			<br>
			<form name="myform">
			<table class="table table-hover">
				<th><input type="checkbox" id="allchk" name="allchk" value="allchk">전체선택</th>
				<th>병원명</th>
				<th>병원 주소</th>
				<th>예약/접수하기</th>
				<c:forEach var="bookmark" items="${bookmarklist}">
					<tr> 
						<td><input type="checkbox" name="myhosplist" value="${bookmark.ykiho}">
						</td>
						<td><a>${bookmark.hname}</a></td>
						<td>${bookmark.addr}</td>
						<td><input type="button" value="예약" onclick="location.href='/finddoc/user/book.do?action=mypage&hname=${bookmark.hname}&ykiho=${bookmark.ykiho}'"> 
						<input type="button" value="접수"></td>
					</tr>
				</c:forEach>
			</table>
			<br> <input class="btn btn-default" id="delete" type="button"
				value="삭제">
		</form>
	</div>
</body>
</html>




