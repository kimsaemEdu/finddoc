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

#paging {
	text-align: center;
	padding: 5px;
	width: 100%;
	font-size: 15px;
}
#censearch {
	text-align: center;
	padding: 5px;
	width: 100%;
	font-size: 15px;
}
</style>
<script type="text/javascript">
	function link(noticeboardnum,hname) {
		location.href="/finddoc/board/noticeBoard_read.do?noticeboardnum="+noticeboardnum+"&hname="+encodeURI(hname)
	}
	function fn_paging(curPage) {
		searchVal=$("#resultsearch").text();
		state="${loginuser.state}";
		if(state=='user'){
			if(searchVal==""){
			if($("#myhospital").val()=='all'){
				location.href = "/finddoc/board/noticeBoardList.do?curPage=" + curPage
					+ "&category=" + $("#category").val();
			}else{
				location.href = "/finddoc/board/noticeBoard_hospitalsearch.do?hadminid=" +encodeURI(hadminid)+"&curPage="+curPage+ "&category=" + $("#category").val();
			}
			}else{
				location.href = "/finddoc/board/noticeBoard_search.do?category="
					+$("#category").val()+"&search="+'${search}'+"&curPage=" + curPage+"&hadminid=" +encodeURI(hadminid)
			}
		}else{
			if(searchVal==""){
				location.href = "/finddoc/board/noticeBoardList.do?curPage=" + curPage
						+ "&category=" + $("#category").val();
			}else{
				location.href = "/finddoc/board/noticeBoard_search.do?category="
				+$("#category").val()+"&search="+'${search}'+"&curPage=" + curPage
			}
		}
	}
	$(document).ready(function() {
		$("#myhospital").change(function() {
			location.href = "/finddoc/board/noticeBoard_hospitalsearch.do?hadminid=" + $(this).val()
		})
	})
	$(document).ready(function() {

	 	hadminid="${hadminid}";
	 	if(hadminid==""){
	 		$("#myhospital").closest().attr("selected", "selected");
	 	}
	 	else{
			$("#myhospital").val(hadminid).attr("selected", "selected");
		}
	 	
	 	var category="${category}";
	 	if(category==""){
	 		$("#category").closest().attr("selected", "selected");
	 	}
	 	else{
			$("#category").val(category).attr("selected", "selected");
		}
		$("#searchB").click(function() {
			state="${loginuser.state}";
			if(state=='user'){
			location.href = "/finddoc/board/noticeBoard_search.do?hadminid="+encodeURI($("#myhospital").val())+
					"&category="+$("#category").val()+"&search="+$("#searchbar").val()
			}else{
				location.href = "/finddoc/board/noticeBoard_search.do?category="+
				$("#category").val()+"&search="+$("#searchbar").val()
			}
			})
		document.getElementById("resultsearch").innerHTML="${resultsearch}";

	})
	
</script>
</head>
<body>
	<div id="title">
		<h2>공지사항 게시판</h2>
	</div>

	<div class="container-fluid">
		<form>
			<c:if test="${loginuser.state=='user' }">
				<select class="form-control col-sm-3" name="myhospital" id="myhospital">
					<option value="all">전체</option>
					<c:forEach var="myhospitallist" items="${myhospitallist }">
						<option value="${myhospitallist.hadminid }">${myhospitallist.hname }</option>
					</c:forEach>
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
						<td>${notice.rn }</td>
						<td><a href="#" onClick="link('${notice.noticeboardnum}','${notice.hname}')">${notice.hname}</a></td>
						<td>${notice.title }</td>
						<td>${notice.name }</td>
						<td>${notice.txupdate }</td>
						<td>${notice.noticecount }</td>
					</tr>
				</c:forEach>
			</table>
			<div id="paging">
				<c:if test="${pagedto.curPage ne 1}"> 
					<a href="#" onClick="fn_paging('${pagedto.prevPage }')">[이전]</a>
				 </c:if>

				<c:forEach var="pageNum" begin="${pagedto.startPage }"
					end="${pagedto.endPage }">
					<c:choose>
						<c:when test="${pageNum eq  pagedto.curPage}">
							<span style="font-weight: bold;"><a href="#"
								onClick="fn_paging('${pageNum }')">${pageNum }</a></span>
						</c:when>
						<c:otherwise>
							<a href="#" onClick="fn_paging('${pageNum }')">${pageNum }</a>
						</c:otherwise>
					</c:choose>
				</c:forEach>

				<c:if test="${pagedto.curPage ne pagedto.pageCnt}">
					<a href="#" onClick="fn_paging('${pagedto.nextPage }')">[다음]</a>
				</c:if>
			</div>
		</form>
	</div>

	<form action="/finddoc/board/noticeBoard_search.do" method="get">
		<select class="form-control col-sm-2" name="category" id="category">
			<option value="title">제목</option>
			<option value="text">본문</option>
			<option value="txupdate">작성일</option>
		</select> <input type="text" name="search" class="form-control col-sm-3"
			id="searchbar"> <input type="button" value="검색" id="searchB"
			class="btn btn-default"><div class="form-group" id="censearch">
			<div class="col-md-2 text-right">
				<label for="id" class="control-label" >검색어 : </label>
			</div>
			<div class="col-md-2 text-reft" id="resultsearch"></div>
		</div>
		<c:if test="${loginuser.state=='hadmin' }">
			<input type="button" value="글쓰기" class="btn btn-default" id="write"
				onclick='location.href="/finddoc/board/noticeBoard_writeView.do"'>
		</c:if>
	</form>

</body>
</html>
