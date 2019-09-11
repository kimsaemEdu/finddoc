<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>jQuery UI Datepicker - Default functionality</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<style>
body {
	color: black;
}

#title {
	text-align: center;
	padding: 40px;
}
</style>
<script>
	var dtNow = new Date();
	$(document).ready(function() {
		$(".ykiho").hide();
		EvtChangeMonthYear(dtNow.getFullYear(), dtNow.getMonth());
	});

	$(function() {
		$("#datepicker").datepicker(
				{
					dateFormat : 'yy-mm-dd', // 데이터는 yyyy-MM-dd로 나옴
					closeText : '닫기',
					prevText : '이전달',
					nextText : '다음달',
					monthNames : [ '1월', '2월', '3월', '4월', '5월', '6월', '7월',
							'8월', '9월', '10월', '11월', '12월' ],
					monthNamesShort : [ '1월', '2월', '3월', '4월', '5월', '6월',
							'7월', '8월', '9월', '10월', '11월', '12월' ],
					dayNames : [ '일', '월', '화', '수', '목', '금', '토' ],
					dayNamesShort : [ '일', '월', '화', '수', '목', '금', '토' ],
					dayNamesMin : [ '일', '월', '화', '수', '목', '금', '토' ],
					weekHeader : 'Wk',
					firstDay : 0,
					isRTL : false,
					duration : 200,
					showAnim : 'show',
					showMonthAfterYear : true,
					yearSuffix : '년',
					showOtherMonths : true, // 나머지 날짜도 화면에 표시
					selectOtherMonths : true, // 나머지 날짜에도 선택을 하려면 true

					onChangeMonthYear : function(year, month, inst) {
						EvtChangeMonthYear(year, month);
					},

					beforeShow : function(input, inst) {
						// 일자 선택되기전 이벤트 발생
					},
					onSelect : function(dateText, inst) {
					}

				});
		$.datepicker.setDefaults($.datepicker.regional['ko']);
		// 월이나 년이 바뀔때의 이벤트
	});

	function EvtChangeMonthYear(Year, Month) {
		$(".ui-datepicker-current-day").attr("style",
				"background-color:#ff0000;"); // 선택된 날자에 테두리를 만든다.

		var vDt = new Date();
		var Day = getStrDay(vDt.getDate());
		var dtMin = new Date(Year, Month - 1, 1);

		dtMin = new Date(Year, Month - 1, 1 - dtMin.getDay()); // 달력의 최초 날자를 구하기 위해
		var strMin = dtMin.getFullYear() + "-"
				+ getStrMonth(dtMin.getMonth() + 1) + "-"
				+ getStrDay(dtMin.getDate());
		var dtMax = new Date(new Date(Year, Month, 1) - 86400000);

		var dtMax = new Date(Year, Month - 1, dtMax.getDate() + 6
				- dtMax.getDay()); // 달력의 마지막 날자를 구하기 위해
		var strMax = dtMax.getFullYear() + "-"
				+ getStrMonth(dtMax.getMonth() + 1) + "-"
				+ getStrDay(dtMax.getDate());
	}

	function getStrMonth(Month) {
		Month = Month + "";
		if (Month.length == 1) {
			Month = "0" + Month;
		}
		return Month;
	}

	function getStrDay(Day) {
		Day = Day + "";
		if (Day.length == 1) {
			Day = "0" + Day;
		}
		return Day;
	}
	
</script>
</head>
<body>
	<div id="title">
		<h2>예약하기</h2>
	</div>
	<div class="container-fluid">
		<form role="form" class="form-horizontal" name="myform" method="get"
			action="/finddoc/user/insertbook.do">
			<div class="form-group">
				<input type="text" class="ykiho" name="ykiho" value="${ykiho}">
				<label class="control-label col-sm-2" for="orgtel">병원명</label>
				<div class="col-sm-3">
					<input type="text" id="hosname" class="form-control" name="hname" value="${book}"
						placeholder="병원명" required>
				</div>
				<div class="col-sm-3">
					<button type="button" class="btn btn-round btn-primary form-control">방문했던
						병원목록에서 선택
					</button>
				</div>
				<div class="col-sm-3">
					<button type="button"
						class="btn btn-round btn-primary form-control">자주가는 병원목록에서 선택
					</button>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="orgtel">진료과</label>
				<div class="col-sm-3">
					<select class="form-control" name="major">
						<option>소아과</option>
						<option>정형외과</option>
						<option>피부과</option>
						<option>내과</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 col-sm-2 control-label">예약 날짜</label>
				<div class="col-sm-3">
					<input type="text" id="datepicker" class="form-control" name="bookdate"
						placeholder="예약날짜">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 col-sm-2 control-label">예약 시간</label>
				<div class="col-sm-3">
					<select name="hour" class="form-control">
						<option value="default">진료시간 선택</option>
						<option value="오전 12시">오전 12시</option>
						<option value="오전 1시">오전 1시</option>
						<option value="오전 2시">오전 2시</option>
						<option value="오전 3시">오전 3시</option>
						<option value="오전 4시">오전 4시</option>
						<option value="오전 5시">오전 5시</option>
						<option value="오전 6시">오전 6시</option>
						<option value="오전 7시">오전 7시</option>
						<option value="오전 8시">오전 8시</option>
						<option value="오전 9시">오전 9시</option>
						<option value="오전 10시">오전 10시</option>
						<option value="오전 11시">오전 11시</option>
						<option value="오후 12시">오후 12시</option>
						<option value="오후 1시">오후 1시</option>
						<option value="오후 2시">오후 2시</option>
						<option value="오후 3시">오후 3시</option>
						<option value="오후 4시">오후 4시</option>
						<option value="오후 5시">오후 5시</option>
						<option value="오후 6시">오후 6시</option>
						<option value="오후 7시">오후 7시</option>
						<option value="오후 8시">오후 8시</option>
						<option value="오후 9시">오후 9시</option>
						<option value="오후 10시">오후 10시</option>
						<option value="오후 11시">오후 11시</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 col-sm-2 control-label"></label>
				<div class="col-sm-6">
					<input type="radio" name="mint" value="0">0분 &nbsp;&nbsp;&nbsp;
					<input type="radio" name="mint" value="10">10분&nbsp;&nbsp;&nbsp;
					<input type="radio" name="mint" value="20">20분&nbsp;&nbsp;&nbsp;
					<input type="radio" name="mint" value="30">30분&nbsp;&nbsp;&nbsp;
					<input type="radio" name="mint" value="40">40분&nbsp;&nbsp;&nbsp;
					<input type="radio" name="mint" value="50">50분
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="orgtel">예약자</label>
				<div class="col-sm-3">
					<input type="text" id="name" name="name" placeholder="예약자"
						class="form-control" required>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="ssn">생년월일</label>
				<div class="col-sm-3">
					<input type="text" name="birthday" class="form-control"
						placeholder="2019-09-06">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="phonehome">연락처</label>
				<div class="col-sm-5">
					<input type="text" id="tel" name="cp"
						placeholder="010-1234-1234" class="form-control" minlength="15" required>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="phonehome">비고</label>
				<div class="col-sm-5">
					<input type="text" id="text" name="text" placeholder="증상 또는 주의사항"
						class="form-control">
				</div>
			</div>
			<br />
			<div class="form-group">
				<div class="col-sm-3 col-sm-offset-2">
					<input type="submit" value="예약하기" class="btn btn-success" id="book" />
					<input type="button" value="취소" class="btn btn-success"
						onclick="location.href='/finddoc/user/booklist.do'" />
				</div>
			</div>
		</form>
	</div>
</body>
</html>