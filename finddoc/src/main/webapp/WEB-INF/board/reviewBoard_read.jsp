<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</head>
<body>

	<form class="form-horizontal"
		action="/finddoc/board/reviewBoard_update.do" method="post">
		<input type="hidden" name="action" value="read"> <input
			type="hidden" name="reviewboardnum"
			value="${reviewread.reviewboardnum}"> <input type="hidden"
			name="hname" value="${reviewread.hname}">
		<div class="form-group">
			<div class="col-md-2 text-right">
				<label for="id" class="control-label">번호</label>
			</div>
			<div class="col-md-8">${reviewread.reviewboardnum}</div>
		</div>
		<div class="form-group">
			<div class="col-md-2 text-right">
				<label for="id" class="control-label">조회수</label>
			</div>
			<div class="col-md-8">${reviewread.reviewcount}</div>
		</div>
		<div class="form-group">
			<div class="col-md-2 text-right">
				<label for="id" class="control-label">병원명</label>
			</div>
			<div class="col-md-8">${reviewread.hname}</div>
		</div>
		<div class="form-group">
			<div class="col-md-2 text-right">
				<label for="id" class="control-label">작성자</label>
			</div>
			<div class="col-md-8">${reviewread.name}</div>
		</div>
		<div class="form-group">
			<div class="col-md-2 text-right">
				<label for="title" class="control-label">제목</label>
			</div>
			<div class="col-md-8">${reviewread.title}</div>
		</div>
		<div class="form-group">
			<div class="col-md-2 text-right">
				<label for="title" class="control-label">작성날짜</label>

			</div>
			<div class="col-md-8">${reviewread.txupdate }</div>
		</div>
		<div class="form-group">
			<div class="col-md-2 text-right">
				<label for="text" class="control-label">내용</label>
			</div>
			<div class="col-md-8"
				style="width: 500px; height: 400px; border: solid 1px;">
				${reviewread.text }</div>
		</div>

		<div class="form-group">
			<div class="col-md-10 text-center">
				<input type="submit" class="btn btn-lg btn-primary" value="수정">

				<button type="button" class="btn btn-danger btn-lg"
					onclick="location.href='/erp/board/list.do?category=all'">
					<i class="fa fa-fw fa-close"></i> 목록
				</button>
				<button type="button" class="btn btn-danger btn-lg" id="deletebtn"
					onclick="location.href='/erp/board/delete.do?board_no=${board.board_no}'">
					<i class="fa fa-fw fa-close"></i> 삭제
				</button>
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-3 col-sm-offset-2">
				<c:if test="${reviewread.id==loginuser.userid }">
					<input type="submit" value="수정" class="btn btn-success" id="update" />
				</c:if>
				<input type="button" value="취소" class="btn btn-success"
					onclick="location.href='/finddoc/board/noticeBoardList.do'" />
				<c:if test="${reviewread.id==loginuser.userid }">
					<input type="button" value="삭제" class="btn btn-success"
						onclick="location.href='/finddoc/board/noticeBoard_delete.do?noticeboardnum=${noticeread.noticeboardnum}'" />
				</c:if>
			</div>
		</div>
	</form>

</body>
</html>