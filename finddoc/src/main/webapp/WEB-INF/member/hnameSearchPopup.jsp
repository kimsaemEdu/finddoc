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
	
<style type="text/css">
#cen{
	margin: auto;
	margin-top: 10px;
	width: 50%;
}
#close{
	text-align:center;
    padding: 5px;
    width: 100%;
}
#paging{
	text-align:center;
    padding: 5px;
    width: 100%;
}
#top{
	text-align: center;
}
a:hover {
	text-decoration: none;
}
</style>
<script type="text/javascript">
	$(document).ready(function() {
	var hosplist = '${hospital}'
	var data = JSON.parse(hosplist)
	hosall = data.response.body.items.item;
	tot=data.response.body.totalCount;
	values = new Array(tot);
	values1 = new Array(tot);
	values2 = new Array(tot);
	values3 = new Array(tot);
	values4 = new Array(tot);
	list = "";
	if(tot==1){
	 	list = list + "<div><div id='hname'>병원명 :" + hosall.yadmNm
		+ "</div><div>병원주소 : " + hosall.addr
		+ "</div><br><span>"+ hosall.ykiho+"</span>"
		+"<span>" + hosall.XPos+"</span><span>"+ hosall.YPos+"</span></div>" 
		values[0] = hosall.yadmNm;
		values1[0] = hosall.addr;
		values2[0] = hosall.ykiho;
		values3[0] = hosall.XPos;
		values4[0] = hosall.YPos;
		$(document).on("click", "#hname", function() {
			clicklist = $(this).attr("id");
			num = parseInt(clicklist.substr(5, clicklist.length - 5));
			opener.document.getElementById("hname").value=values[num];
			opener.document.getElementById("addr").value=values1[num];
			opener.document.getElementById("ykiho").value=values2[num];
			opener.document.getElementById("xpos").value=values3[num];
			opener.document.getElementById("ypos").value=values4[num];
		})
	}else{
	for (var i = 0; i < hosall.length; i++) {
		list = list + "<div><div id='hname"+i+"'>병원명 :" + hosall[i].yadmNm
				+ "</div><div>병원주소 : " + hosall[i].addr
				+ "</div><br><span>"+ hosall[i].ykiho+"</span>"
				+"<span>" + hosall[i].XPos+"</span><span>"+ hosall[i].YPos+"</span></div>"
		values[i] = hosall[i].yadmNm;
		values1[i] = hosall[i].addr;
		values2[i] = hosall[i].ykiho;
		values3[i] = hosall[i].XPos;
		values4[i] = hosall[i].YPos;
		//for문돌면서 각 배열값(아이디)에 콜백함수로 정의 해주는것
		$(document).on("click", "#hname" + i, function() {
			clicklist = $(this).attr("id");
			num = parseInt(clicklist.substr(5, clicklist.length - 5));
			opener.document.getElementById("hname").value=values[num];
			opener.document.getElementById("addr").value=values1[num];
			opener.document.getElementById("ykiho").value=values2[num];
			opener.document.getElementById("xpos").value=values3[num];
			opener.document.getElementById("ypos").value=values4[num];
		})
	};
	}
	
	//페이징처리
	nowPage=data.response.body.pageNo;
	totPage=tot/10;
	totPage=Math.floor(totPage);
	if(tot%10!=0){
		totPage+=1;
	}
	pagelist="";
	hspname=opener.document.getElementById("hname").value;
	haddr="${haddr}";
	
	if(nowPage==1){
		prelink="/finddoc/member/hnameSearchPopup.do?hospname="+encodeURI(hspname)+"&pageno="+1+"&rows="+10+"&haddr="+encodeURI(haddr);
	}else{
		prelink="/finddoc/member/hnameSearchPopup.do?hospname="+encodeURI(hspname)+"&pageno="+(nowPage-1)+"&rows="+10+"&haddr="+encodeURI(haddr);
	}
	if(nowPage==totPage){
		postlink="/finddoc/member/hnameSearchPopup.do?hospname="+encodeURI(hspname)+"&pageno="+nowPage+"&rows="+10+"&haddr="+encodeURI(haddr);	
	}else{
		postlink="/finddoc/member/hnameSearchPopup.do?hospname="+encodeURI(hspname)+"&pageno="+(nowPage+1)+"&rows="+10+"&haddr="+encodeURI(haddr);
	}
	
	pre="<a href='"+prelink+"'>[이전]</a>";
	post="<a href='"+postlink+"'>[다음]</a>";
	if(totPage<=10){
		link=new Array(totPage);
		for (var i = 0; i < totPage; i++) {
			link[i]="/finddoc/member/hnameSearchPopup.do?hospname="+encodeURI(hspname)+"&pageno="+(i+1)+"&rows="+10+"&haddr="+encodeURI(haddr);
			pagelist=pagelist+"<span><a href='"+link[i]+"' id='"+(i+1)+"'>"+" [ "+(i+1)+ " ] "+"</a></span>"
		}
		$("#paging").append(pre+pagelist+post);
	}else{
		link=new Array(totPage);
		pageno="${pageno}";
		if(pageno%10==0){
			interpage=Math.floor(pageno/10);
		}else{
			interpage=Math.floor(pageno/10)+1;
		}
		if(tot%10==0){
			totinter=Math.floor(tot/100);
		}else{
			totinter=Math.floor(tot/100)+1;
		}
		
		if(interpage==totinter){
			for (var i = (interpage-1)*10; i <totPage; i++) {
				link[i]="/finddoc/member/hnameSearchPopup.do?hospname="+encodeURI(hspname)+"&pageno="+(i+1)+"&rows="+10+"&haddr="+encodeURI(haddr);
				pagelist=pagelist+"<span><a href='"+link[i]+"' id='"+(i+1)+"'>"+" [ "+(i+1)+ " ] "+"</a></span>"
			}
		}else{
			for (var i = (interpage-1)*10; i <(interpage-1)*10+10; i++) {
				link[i]="/finddoc/member/hnameSearchPopup.do?hospname="+encodeURI(hspname)+"&pageno="+(i+1)+"&rows="+10+"&haddr="+encodeURI(haddr);
				pagelist=pagelist+"<span><a href='"+link[i]+"' id='"+(i+1)+"'>"+" [ "+(i+1)+ " ] "+"</a></span>"
			}
		}
		$("#paging").empty();
		$("#paging").append(pre+pagelist+post);
	}
	
	$("#info").append("해당 병원명을 클릭하세요."+list);
	$("#info span").hide();
	
		$("#close").click(function(){
			window.close();	
		})
	
		$("#"+pageno).css("color","red");
		
		});
	
</script>
</head>
<body>
	<div id="info"></div>
		
	<div class="form-group">
		<div class="col-sm-3" id="paging">
			
		</div>
	</div>
	
	<div class="form-group" id="cen">
			<div class="col-sm-3">
				<input type="button" id="close" value="닫기" class="btn btn-success">
			</div>
		</div>
</body>
</html>