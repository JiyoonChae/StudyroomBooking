
var phone =null;
var name = null;
$("#cardPay").click(function(){
	phone = $("#phone").val();
	name=$("#name").val();
	payment=$(this).attr("title");
	console.log("폰번호: "+phone);
	console.log("구매자이름: "+name)
	console.log("페이까지옴")
	requestPay();
	//결제 api 사용
	
})

function requestPay(){
	IMP.request_pay({
    pg : 'html5_inicis',
    pay_method : 'card',
    merchant_uid : 'SR_' + new Date().getTime(),
    name : '스터디룸 예약',
    amount : finalPrice,
    buyer_name : name,
    buyer_tel : phone
}, function(rsp) {
    if ( rsp.success ) { //결제 성공시 
	var msg = '결제가 완료되었습니다.';
        msg += '고유ID : ' + rsp.imp_uid;
        msg += '상점 거래ID : ' + rsp.merchant_uid;
		msg += '결제 방법 :' +rsp.pay_method;
        msg += '결제 금액 : ' + rsp.paid_amount;
        msg += '카드 승인번호 : ' + rsp.apply_num;
		msg += '결제승인 시각: ' +rsp.paid_at;
	//jquery로 http 요청
		$.ajax({
			url: "../pay/payComplete",
			method: "POST",
			//headers: {"Content-Type": "application/json"},
			data: {
				//imp_uid: rsp.imp_uid,
				revNum:revNum,
				amount:finalPrice,
				merchant_uid: rsp.merchant_uid,
				pay_method: rsp.pay_method,
				paid_amount: rsp.paid_amount,
				apply_num: rsp.apply_num,
				status: rsp.status,
				pg_provider: rsp.pg_provider
				},
				success: function(result) {
					console.log(result);
					confirmRes();
				}			
		}).done(function(data){
			alert("서버로 잘 넘어감!")
			//여기서 예약 정보들을 예약테이블에 저장해줘야함. function호출하면될듯
		})
        
    } else {
        var msg = '결제에 실패하였습니다.';
        msg += '에러내용 : ' + rsp.error_msg;
    }

    alert(msg);
});
}
	
	
	


//예약 확정하기