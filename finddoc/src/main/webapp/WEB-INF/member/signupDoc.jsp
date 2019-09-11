<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<style type="text/css">
#title {
	text-align: center;
	padding: 40px;
}

</style>
<script type="text/javascript">
	$(document).ready(function() {
		var result="${result}";
		if(result!=""){
			var con=confirm(result);
			if(con==true){
				location.href="/finddoc/login/loginView.do";
			}
		}
		$("#hadminid").keyup(function() {
			$.ajax({
				url : "/finddoc/member/idcheck.do",
				type : "get",
				data : {
					"id" : $("#hadminid").val()
				},
				dataType : "text",
				success : function(data) {
					$("#idcheck").text(data);
				}
			});
		});
		$("#email").keyup(function() {
			$.ajax({
				url : "/finddoc/member/emailcheck.do",
				type : "get",
				data : {
					"email" : $("#email").val()
				},
				dataType : "text",
				success : function(data) {
					$("#emailcheck").text(data);
				}
			});
		});
		
		$("#hnameb").click(function() {
			hspname=$("#hname").val();
			haddr=$("#haddr").val();
			var url= "/finddoc/member/hnameSearchPopup.do?hospname="+encodeURI(hspname)+"&pageno="+1+"&rows="+10+"&haddr="+haddr;    //팝업창 페이지 URL
		    var popupOption= "width=600,height=700,location=no,status=no,toolbars=no,top=70,left=800";    //팝업창 옵션(optoin)
			openWin=window.open(url,"child",popupOption);
		/* 	$.ajax({
				url : "/finddoc/member/hnameSearch.do",
				type : "get",
				data : {
					"hospname" : $("#hname").val()
				},
				dataType : "json",
				success : function(data) {
					
					hosall=data.response.body.items.item;
					list="";
					var values=new Array(hosall.length);
					var values1=new Array(hosall.length);
					var values2=new Array(hosall.length);
					var values3=new Array(hosall.length);
							for (var i = 0; i < hosall.length; i++) {								
									list=list+"<div><div  id='hospital"+i+"'>병원명:"+hosall[i].yadmNm+"</div><div id='hospitaladdr"+i+"'>병원주소:"+hosall[i].addr+
									"<span>"+hosall[i].ykiho+"</span>"+"<span>"+hosall[i].postNo+"</span>"
									"</div>";
									values[i]=hosall[i].yadmNm;
									values1[i]=hosall[i].addr;
									values2[i]=hosall[i].ykiho;
									values3[i]=hosall[i].postNo;
									$(document).on("click","#hospital"+i,function(){
										clicklist=$(this).attr("id");
										num=parseInt(clicklist.substr(8,clicklist.length-8));
										$("#hname").val(values[num]);
										$("#addr").val(values1[num]);
										$("#ykiho").val(values2[num]);
										$("#postno").val(values3[num]);
									})
								}
				
							$("#info").empty();
							$("#info").append("해당 병원명을 클릭하세요"+list);
							$("#info span").hide();
							popup(list);

				}
			}); */
			
		})
	});
	/* function popup(list){
		alert(list)
	var url= "/finddoc/member/hnameSearchPopup.do";    //팝업창 페이지 URL
    var popupOption= "width=400,height=600,location=no,status=no,toolbars=no,top=100,left=800";    //팝업창 옵션(optoin)
	openWin=window.open(url,"child",popupOption);
    alert(document.getElementById("info").value)
    openWin.document.getElementById("childText").value=list
	}
		 */
</script>
</head>
<body>
	<div id="title">
		<h2>병원관계자 회원가입</h2>
	</div>
	<div class="container-fluid" id="con1">
		<form role="form" class="form-horizontal" name="myform" method="post"
			action="/finddoc/member/insert.do">
			<input type="hidden" name="action" value="doc">
			<div class="form-group">
				<label class="control-label col-sm-2" for="tags">병원명</label>
				<div class="col-sm-3">
					<input type="text" id="hname" name="hname" placeholder="병원명"
						class="form-control" minlength="3" required>
				</div>
				
				<div class="col-sm-1">
					<input type="button" id="hnameb" class="btn btn-round btn-primary form-control" value="검색">
				</div>
				
			</div>
			
			<div class="form-group">
				<label class="control-label col-sm-2" for="tags">병원 위치(도시)</label>
				<div class="col-sm-3">
					<input type="text" id="haddr" name="haddr" placeholder="도시"
						class="form-control" minlength="2" required>
				</div>
			</div>
			
			<div class="form-group">
				<label class="control-label col-sm-2" for="orgtel">아이디</label>
				<div class="col-sm-3">
					<input type="text" id="hadminid" name="hadminid" placeholder="아이디"
						class="form-control" minlength="3" required>
				</div>
				<div id="idcheck"></div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="orgtel">비밀번호</label>
				<div class="col-sm-3">
					<input type="password" id="pw" name="pw" placeholder="비밀번호"
						class="form-control" minlength="4" required>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="orgtel">이름</label>
				<div class="col-sm-3">
					<input type="text" id="name" name="name" placeholder="이름"
						class="form-control" minlength="3" required>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="phonehome">핸드폰번호</label>
				<div class="col-sm-3">
					<input type="text" id="cp" name="cp" placeholder="예)010-1234-5678"
						class="form-control" minlength="13" required>

				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="grade">이메일</label>
				<div class="col-sm-3">
					<input type="text" id="email" name="email" placeholder="이메일"
						class="form-control" minlength="4" required>

				</div>
					<div id="emailcheck"></div>
			</div>
			
			<div id="hiddendata">
			<div class="form-group">
				<label class="control-label col-sm-2" for="tags">주소</label>
				<div class="col-sm-3">
					<input type="text" id="addr" name="addr">
				</div>
			</div><div class="form-group">
				<label class="control-label col-sm-2" for="tags">x좌표</label>
				<div class="col-sm-3">
					<input type="text" id="xpos" name="xpos" >
				</div>
			</div><div class="form-group">
				<label class="control-label col-sm-2" for="tags">y좌표</label>
				<div class="col-sm-3">
					<input type="text" id="ypos" name="ypos">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="tags">ykiho</label>
				<div class="col-sm-3">
					<input type="text" id="ykiho" name="ykiho">
				</div>
			</div>
			</div>

			<br />
			<div class="form-group">
				<div class="col-sm-2 col-sm-offset-2">
					<input type="submit" value="회원가입" class="btn btn-success"
						id="insert" /> <input type="button" value="취소"
						class="btn btn-success"
						onclick="location.href='/finddoc/login/loginView.do'" />
				</div>
			</div>
		</form>
	</div>
</body>
</html>