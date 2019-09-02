<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#reco").keyup(function() {
			if (isNaN($("#reco").val()) == true) {
				alert("숫자만 입력하세요.");
			} else {
				if ($("#reco").val() < 0 || $("#reco").val() > 10) {
					alert("0~10 사이의 숫자만 입력하세요.");
				}
			}
		});
	});
</script>
</head>
<body>
	<h4>
		<i class="fa fa-angle-right"></i> 후기 게시판 글작성하기
	</h4>
	<hr>
	<div class="row mt">
		<div class="col-lg-12">
			<div class="form-panel">

				<form class="form-horizontal style-form"
					action="/finddoc/board/reviewBoard_insert.do" method="post">
					<input type="hidden" name="name" value="${loginuser.name}">
					<input type="hidden" name="id" value="${loginuser.userid }">
					<div class="form-group" style="border: 1px solid #eff2f7;">

						<label class="col-sm-2 col-sm-2 control-label">작성자</label>
						<div class="col-sm-10">
							<p class="form-control-static">${loginuser.name }</p>
						</div>
						<div class="form-group">
							<label class="col-sm-2 col-sm-2 control-label">병원 이름</label>

							<div class="col-sm-5">
								<select name="hname" class="form-control">
									<option value="굿닥">굿닥</option>
									<option value="똑닥">똑닥</option>
									<option value="뚝닥">뚝닥</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 col-sm-2 control-label">제목</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" name="title">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 col-sm-2 control-label">후기점수</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" name="reco" id="reco"
									placeholder="숫자만 입력하세요(0~10사이)">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 col-sm-2 control-label">내용</label>
							<div class="col-sm-8">
								<textarea id="text"
									style="width: 100%; border: 1; overflow: visible; text-overflow: ellipsis;"
									rows=15 name="text"></textarea>

							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-6 col-sm-offset-2">
								<input type="submit" value="글등록" class="btn btn-success" id=find />
								<input type="button" value="취소" class="btn btn-success"
									onclick="location.href='/finddoc/board/reviewBoardList.do'" />
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>