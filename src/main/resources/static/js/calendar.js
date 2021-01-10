// ----------------날짜 선택용 달력 ----------------
(function () {
    calendarMaker($("#calendarForm"), new Date());
})();

var nowDate = new Date();
//-----calendarMaker 시작 --------------------------
var bookDate = 0;
function calendarMaker(target, date) {
    if (date == null || date == undefined) {
        date = new Date();
    }
    nowDate = date;
    if ($(target).length > 0) {
        var year = nowDate.getFullYear();
        var month = nowDate.getMonth() + 1;
        $(target).empty().append(assembly(year, month));
    } else {
        console.error("custom_calendar Target is empty!!!");
        return;
    }

    var thisMonth = new Date(nowDate.getFullYear(), nowDate.getMonth(), 1);
    var thisLastDay = new Date(nowDate.getFullYear(), nowDate.getMonth() + 1, 0);


    var tag = "<tr>";
    var cnt = 0;
    //빈 공백 만들어주기
    for (i = 0; i < thisMonth.getDay(); i++) {
        tag += "<td></td>";
        cnt++;
    }

    //날짜 채우기
    for (i = 1; i <= thisLastDay.getDate(); i++) {
        if (cnt % 7 == 0) { tag += "<tr>"; }

        tag += "<td>" + i + "</td>";
        cnt++;
        if (cnt % 7 == 0) {
            tag += "</tr>";
        }
    }
    $(target).find("#custom_set_date").append(tag);
    calMoveEvtFn();

    function assembly(year, month) {
        var calendar_html_code =
            "<table class='custom_calendar_table'>" +
            "<colgroup>" +
            "<col style='width:81px'/>" +
            "<col style='width:81px'/>" +
            "<col style='width:81px'/>" +
            "<col style='width:81px'/>" +
            "<col style='width:81px'/>" +
            "<col style='width:81px'/>" +
            "<col style='width:81px'/>" +
            "</colgroup>" +
            "<thead class='cal_date'>" +
            "<th><button type='button' class='prev'><</button></th>" +
            "<th colspan='5'><p><span>" + year + "</span>년 <span>" + month + "</span>월</p></th>" +
            "<th><button type='button' class='next'>></button></th>" +
            "</thead>" +
            "<thead  class='cal_week'>" +
            "<th>일</th><th>월</th><th>화</th><th>수</th><th>목</th><th>금</th><th>토</th>" +
            "</thead>" +
            "<tbody id='custom_set_date'>" +
            "</tbody>" +
            "</table>";
        return calendar_html_code;
    }
 var selectDate= 0;
    function calMoveEvtFn() {
        //전달 클릭
        $(".custom_calendar_table").on("click", ".prev", function () {
            nowDate = new Date(nowDate.getFullYear(), nowDate.getMonth() - 1, nowDate.getDate());
            calendarMaker($(target), nowDate);
        });
        //다음날 클릭
        $(".custom_calendar_table").on("click", ".next", function () {
            nowDate = new Date(nowDate.getFullYear(), nowDate.getMonth() + 1, nowDate.getDate());
            calendarMaker($(target), nowDate);
        });
        //일자 선택 클릭
        $(".custom_calendar_table").on("click", "td", function () {
            $(".custom_calendar_table .select_day").removeClass("select_day");
            $(this).removeClass("select_day").addClass("select_day");
			selectDate = $(this).text();
			console.log(selectDate);
			console.log(year);
			console.log(month);
			bookDate = year+"-"+month+"-"+selectDate;
			$(".reserve_info").text(year+"."+month+"."+selectDate);
			
        });
    }
}  //-----calendarMaker() 종료 --------------------------


//----------------시간 선택 시작---------------------------
//4시 클릭 후 9시 클릭하면 중간에 5-8시도 자동 클릭되게
var min = 24;
var max = -1;
var selectTime =0;
var revTime=0;
var totalPrice =0;
var user =1;

//원하는 시간 클릭 시 함수 적용 ----------------------
$(".time_list li").click(function() {	
	selectTime = parseInt($(this).children().find(".time").text());
	console.log("select : " + selectTime); //선택한 시간
	user =1;
	$("#users").val("1"); //인원수 초기화
	
	if(!$(this).hasClass("selected")) {
		for(var i=0; i<24; i++) {
			if( selectTime > max - 1 ) { 
				max = selectTime + 1;
				$(this).addClass("selected");
				$(this).children().find(".price").css("background-color", "#704de4");
			}
			if( selectTime < min ) {
				min = selectTime;
				$(this).addClass("selected");
				$(this).children().find(".price").css("background-color","#704de4");
			}
		} //for문 종료
		css();
	} else if($(this).hasClass("selected")) {   //이미 선택된 시간이 시작시간-종료시간 사이에있는 값이면
		if (min<=selectTime<=max){
		//alert("선택된시간: "+selectTime);
			$('.time').each(function(){  //모든 시간(24h)값을 반복해서 체크, 선택된 시작시간, 종료시간 범위안의 값이라면 적용된 css없애기
  				var test = $(this).text();
					if(min<=test<selectTime || test>selectTime){
						console.log("여기까지옴");
						$(this).parents('li').removeClass("selected");
						$(this).siblings().css("background-color", "#ffd014");
						}
			});
			$(this).addClass("selected");  //위에 each로 반복되면서 선택되어야할 값도 css가 없어지므로 다시 선언해줌
			$(this).children().find(".price").css("background-color","#704de4");
			min = selectTime;
			max = selectTime + 1;
			} //if문 종료
		};  //else if 종료
		
	console.log(min + " - " + max);
	revTime = max-min;		//예약할 총 시간
	$(".time_info").text(min+":00 ~"+max+":00  "+revTime+"시간");  //html에 출력해줌
	
	//총 금액 계산하기
	totalPrice = 1500 * revTime;  
	console.log("totalPrice : "+totalPrice);
	console.log("기본 인원: "+user);  //기본값 1인임.
	$(".totalPrice").text(totalPrice +" 원");  //선택된 시간*1인으로 먼저 html에 총금액 출력
});  //시간 선택 end!!

getUsers();  //인원수 선택 후 총금액 다시 계산해서 html에 금액 출력하는 함수!

 //공간사용료 최종 금액: 인원선택 후 계산 시작--------
var totalPrice2 =0; 
function getUsers() {
	$("#users").blur(function(){
	 user = $("#users").val();
	console.log("f안에 인원: "+user);
	console.log("total가격: "+totalPrice) //기본값1인으로 계산한 금액
	totalPrice2 = totalPrice*user; //인원수가 수정되면 수정된 인원을 곱해서 총금액 다시 계산!
	console.log("total가격2: "+totalPrice2)
	$(".totalPrice").text(totalPrice2 +" 원");  //최종금액으로 html에 출력시키기.
		})
}  //getUsers() END --------------------------
	

// //선택 시간의 최소값과 최대값 만큼 반복해서 중간에 낀 시간에 css를 자동 적용하는 함수
function css(){
for(var i=min; i<max-1; i++){  
	console.log("반복문최소:" +min)
	console.log("최대: "+ max)
			var restTime = i+1;     //중간에 낀 시간 반복문으로 알아내기 2-9시 면 3,4,5,6,7
			 //전체 시간 list중 3,4,5,6,7 과 일치하는 태그를 찾아 css를 주려고함.
			console.log("Restime"+restTime) //여기까지는 의도한대로 잘 나옴..
			
			$('.time').each(function(){
  					var test = $(this).text();
 			//	 console.log(test);
				if(restTime == test){
				$(this).parents('li').addClass("selected");
				$(this).siblings().css("background-color","#704de4");
				}
			});
		}
	} //----------CSS()함수 END -------


// 스터디룸 이미지를 보고 인원수에 맞는 룸 선택(1~5 번 방)
var roomType =1;
$(".room").click(function() {
	roomType= $(this).val();
	console.log("룸타입: "+roomType);
})
	

 //파라미터를 받아야되는데 어케받지 :선택한 날짜 + 시간
   
 $('#myModal').on('shown.bs.modal', function () {
	$(".reserveRoom").val(roomType);
	$(".reserveDate").val(bookDate);
	$(".startTime").val(min+"시");
	$(".endTime").val(max+"시");
	$(".reserveUser").val(user+"명");
	if(totalPrice2==0){
		$("#roomPrice").val(totalPrice)
	}else{
		$("#roomPrice").val(totalPrice2)
	}
	

console.log("예약확정----");
});
    
$("#storePay").click(function(){
	console.log("파라미터보내장------") 
console.log("룸타입: "+roomType);
//날짜 year, month, date
console.log("예약일: "+bookDate);
// 시간 selectTime
console.log("시작시간:" + min);
console.log("종료시간: "+ max);
console.log("예약시간: "+ revTime);
// 인원 
console.log("인원수 : "+ user);
//총금액 totalPrice
console.log("총금액" +totalPrice2);
var id = "<c:out value='${id}' />";
var email= $("#email").val();
console.log(id)
console.log(email)
console.log("파라미터값-----------------")
})
 //룸타입 roomType

//예약 확정 버튼 누르면 DB로 보내서 저장하기.
$("#confirmRes").click(function(){
	//예약번호 만들기
	var revNum= Math.floor(Math.random() * 100000);
	//id, email 정보 session 에서 받아오기
	var id = $("#id").val();
	var email= $("#email").val();
	var roomPrice = $("#roomPrice").val();
	var payment = $("#payment").val();
	$.ajax({
		url:"./roomConfirm",
		type:"post",
		data:{
			revNum:revNum, 
		
			roomType: roomType,
			roomDate: bookDate,
			startTime: min,
			endTime: max,
			roomTime: revTime,
			roomUser: user,
			roomPrice: roomPrice,
			payment: payment
			},
		success: function(data){
			alert("예약완료");
		}
	}); //ajax완료
	
	
})


/*$(".price").click(function(){
	var time = $(this).siblings().text();
	console.log(time);
	//$(this).addClass("selected");
	//
	if($(this).hasClass("selected")){
		$(this).removeClass("selected");
		$(this).css("background-color", "#ffd014");
	}else{
		$(this).addClass("selected");
		$(this).css("background-color", "#704de4");
	} 
});*/