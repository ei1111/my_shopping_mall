// 구매자 정보
const useremail = "ei1111@naver.com"
const username = "manjae"

var IMP = window.IMP;
var isLogin = true;

function generateMerchantUid() {
  var today = new Date();
  var hours = today.getHours(); // 시
  var minutes = today.getMinutes();  // 분
  var seconds = today.getSeconds();  // 초
  var milliseconds = today.getMilliseconds(); // 밀리초

  // 시, 분, 초, 밀리초를 결합하여 고유한 문자열 생성
  var makeMerchantUid = `${hours}${minutes}${seconds}${milliseconds}`;

  return makeMerchantUid;
}


function paymentProcess(orderId, memberName, itemName ,price, count) {
  if (confirm("구매 하시겠습니까?")) {
    if(isLogin){ // 회원만 결제 가능
      IMP.init("imp76736845"); // 고객사 식별코드
      IMP.request_pay({
        pg: 'kakaopay.TC0ONETIME', // PG사 코드표에서 선택
        pay_method: 'card', // 결제 방식
        merchant_uid: "IMP" + generateMerchantUid(), // 결제 고유 번호(우리가 만들기)
        name: itemName, // 제품명
        amount: price * count, // 가격


        /* 구매자 정보 */
        buyer_email: `${useremail}`,
        buyer_name: memberName,
        // buyer_tel : '010-1234-5678',
        // buyer_addr : '서울특별시 강남구 삼성동',
        // buyer_postcode : '123-456'
      }, async function (rsp) { // callback
        if (rsp.success) { //결제 성공시

          // 필요한 데이터를 추가
/*          rsp.partnerId = 12345;  // partnerId 값 설정 (필요시 동적으로 가져올 수 있음)
          rsp.userId = 67890;     // userId 값 설정 (현재 로그인한 사용자 정보로 설정 가능)
           // orderId 값 설정 (주문 관련 정보로 설정 가능)*/
          rsp.orderId = orderId;
          rsp.paymentDate = new Date().toISOString().split('T')[0];  // paymentDate를 현재 날짜로 설정 (yyyy-mm-dd 형식)

          console.log(rsp);
          // Send the payment details to your Spring Boot backend
          const response = await fetch('/payments/v1/save', {
            method: 'POST',
            headers: {
              'Content-Type': 'application/json'
            },
            body: JSON.stringify(rsp) // Send the response object
          });

          const result = await response.json();
          console.log(result)

          if (rsp.status == 200) { // DB저장 성공시
            alert('결제 완료!')
            window.location.reload();
          } else { // 결제완료 후 DB저장 실패시
            alert(`error:[${rsp.status}]\n결제요청이 승인된 경우 관리자에게 문의바랍니다.`);
            // DB저장 실패시 status에 따라 추가적인 작업 가능성
          }
        } else if (rsp.success == false) { // 결제 실패시
          alert(rsp.error_msg)
        }
      });
    }

    else { // 비회원 결제 불가
      alert('로그인이 필요합니다!')
    }
  } else { // 구매 확인 알림창 취소 클릭시 돌아가기
    return false;
  }
}