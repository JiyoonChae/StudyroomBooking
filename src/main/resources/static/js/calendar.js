(function () {
    calendarMaker($("#calendarForm"), new Date());
})();

var nowDate = new Date();
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
			
			$(".reserve_info").text(year+"."+month+"."+selectDate);
			
        });
    }
}

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

//4시 클릭 후 9시 클릭하면 중간에 5-8시도 자동 클릭되게
var min = 24;
var max = -1;
var selectTime =0;
var revTime=0;
$(".time_list li").click(function() {	
	selectTime = parseInt($(this).children().find(".time").text());
	console.log("select : " + selectTime);
	
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
	} else if($(this).hasClass("selected")) {
		if (min<=selectTime<=max){
		//alert("선택된시간: "+selectTime);
			$('.time').each(function(){
  				var test = $(this).text();
					if(min<=test<selectTime || test>selectTime){
						console.log("여기까지옴");
						$(this).parents('li').removeClass("selected");
						$(this).siblings().css("background-color", "#ffd014");
						}
			});
			$(this).addClass("selected");
			$(this).children().find(".price").css("background-color","#704de4");
			min = selectTime;
			max = selectTime + 1;
			} //if문 종료
		};  //else if 종료
	console.log(min + " - " + max);
	revtime = max-min;
	$(".time_info").text(min+":00 ~"+max+":00  "+revtime+"시간");
	
	var totalPrice = 1500 * revtime;
 $(".totalPrice").text(totalPrice +" 원");
});  //시간 선택 end!!


 //공간사용료


function css(){
for(var i=min; i<max-1; i++){ //선택 시간의 최소값과 최대값 만큼 반복해서 중간에 낀 시간에 css를 주려고함..
	console.log("반복문최소:" +min)
	console.log("최대: "+ max)
			var restTime = i+1;     //중간에 낀 시간 반복문으로 알아내기 2-9시 면 3,4,5,6,7
			 //전체 시간 list중 3,4,5,6,7 과 일치하는 태그를 찾아 css를 주려고함.
			console.log("Restime"+restTime) //여기까지는 의도한대로 잘 나옴..
			
			$('.time').each(function(){
  					var test = $(this).text();
 				 console.log(test);
				if(restTime == test){
				$(this).parents('li').addClass("selected");
				$(this).siblings().css("background-color","#704de4");
				}
			});
		}
	}



	

 //파라미터를 받아야되는데 어케받지 :선택한 날짜 + 시간
 