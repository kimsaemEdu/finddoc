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
#accept {
	float: right;
	margin-right: 30px;
}
</style>
<title>Insert title here</title>
</head>
<script type="text/javascript">
	$(document).ready(function() {
		$("#allchk").on("click",function(){
			if($('input:checkbox[name="allchk"]').is(":checked")==true){
				$('input:checkbox[name="hosplist"]').each(function() {
					this.checked = true;
				 });
			}
			else{
				$('input:checkbox[name="hosplist"]').each(function() {
					this.checked = false;
				 });
			}
		});
		
		$("#accept").click(function() {
			$('input:checkbox[name="hosplist"]').each(function() {
				if($(this).is(":checked")){
					$.ajax({
						url : "/finddoc/admin/accept_hospital.do",
						type : "get",
						data :{
							"hadminid" : $(this).val()
						},
						success : function(message) {
							location.href="/finddoc/admin/accept_list.do";
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
	<h2>승인 대기 병원목록</h2>
	<div class="container-fluid">
		<form name="myform">
			<table class="table table-hover">
				<th><input type="checkbox" id="allchk" name="allchk" value="allchk">전체선택</th>
				<th>이용자ID</th>
				<th>병원명</th>
				<th>주소</th>
				<c:forEach var="acceptlist" items="${acceptlist}">
					<tr>
						<td><input type="checkbox" name="hosplist"
							value="${acceptlist.hadminid}"></td>
						<td><a>${acceptlist.hadminid}</a></td>
						<td><a>${acceptlist.hname}</a></td>
						<td>${acceptlist.addr}</td>
					</tr>
				</c:forEach>
			</table>
			<br> 
			<input class="btn btn-default" id="accept" type="button" value="가입승인">
		</form>
	</div>
</body>
</html>




