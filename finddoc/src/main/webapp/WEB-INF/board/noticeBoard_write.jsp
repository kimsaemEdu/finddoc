<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

</head>
<body>
	<h4>
		<i class="fa fa-angle-right"></i> 공지사항 게시판 글작성하기
	</h4>
	<hr>
	<div class="row mt">
		<div class="col-lg-12">
			<div class="form-panel">

				<form class="form-horizontal style-form"
					action="/finddoc/board/noticeBoard_insert.do" method="post">
					<input type="hidden" name="name" value="${loginuser.name}">
					<input type="hidden" name="hname" value="${loginuser.hname }">
					<input type="hidden" name="hadminid" value="${loginuser.hadminid }">
					<div class="form-group" style="border: 1px solid #eff2f7;">
						<div class="form-group">
							<label class="col-sm-2 col-sm-2 control-label">작성자</label>
							<div class="col-sm-3">
								<label class="control-label col-sm-6" for="tags">${loginuser.name}</label>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 col-sm-2 control-label">병원 이름</label>
							<div class="col-sm-6">
								<label class="control-label col-sm-6" for="tags">${loginuser.hname }</label>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 col-sm-2 control-label">제목</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" name="title">
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
									onclick="location.href='/finddoc/board/noticeBoardList.do" />
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>