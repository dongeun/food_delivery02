# 예제 - 음식배달

본 예제는 MSA/DDD/Event Storming/EDA 를 포괄하는 분석/설계/구현/운영 전단계를 커버하도록 구성한 예제입니다.
이는 클라우드 네이티브 애플리케이션의 개발에 요구되는 체크포인트들을 통과하기 위한 예시 답안을 포함합니다.

# 서비스 시나리오

기능적 요구사항
1. 고객이 메뉴를 선택하여 주문한다.
1. 고객이 선택한 메뉴에 대해 결제한다.
1. 주문이 되면 주문 내역이 입점상점주인에게 주문정보가 전달된다
1. 상점주는 주문을 수락하거나 거절할 수 있다
1. 상점주는 요리시작때와 완료 시점에 시스템에 상태를 입력한다
1. 고객은 아직 요리가 시작되지 않은 주문은 취소할 수 있다
1. 요리가 완료되면 고객의 지역 인근의 라이더들에 의해 배송건 조회가 가능하다
1. 라이더가 해당 요리를 Pick한 후, 앱을 통해 통보한다.
1. 고객이 주문상태를 중간중간 조회한다
1. 주문상태가 바뀔 때 마다 카톡으로 알림을 보낸다
1. 고객이 요리를 배달 받으면 배송확인 버튼을 탭하여, 모든 거래가 완료된다
1. 배달 시간이 1시간 이상 초과 시 고객에게 금액 환불 한다.(추가)
1. 주문 시 주소를 주문 가능 지역인지 확인하고, 주문 불가 지역이면 주문을 취소 한다.(추가)


비기능적 요구사항
1. 장애격리
    1. 상점관리 기능이 수행되지 않더라도 주문은 365일 24시간 받을 수 있어야 한다  Async (event-driven), Eventual Consistency
    1. 결제시스템이 과중되면 사용자를 잠시동안 받지 않고 결제를 잠시후에 하도록 유도한다  Circuit breaker, fallback
1. 성능
    1. 고객이 자주 상점관리에서 확인할 수 있는 배달상태를 주문시스템(프론트엔드)에서 확인할 수 있어야 한다  CQRS
    1. 배달상태가 바뀔때마다 카톡 등으로 알림을 줄 수 있어야 한다  Event driven


## Model
![image](https://user-images.githubusercontent.com/2777247/206419368-b06c80cf-456b-4d9d-8a27-5f0ac71222e9.png)


요구사항을 커버하는지 검증

![image](https://user-images.githubusercontent.com/2777247/206425903-c9043653-8bc2-4aa5-aa39-d5be1b403764.png)
    
    1.고객이 메뉴를 선택하여 주문한다. (ok)
    2.주문 시 주소를 주문 가능 지역인지 확인하고, 주문 불가 지역이면 주문을 취소 한다.(추가)(ok)
    3.고객이 선택한 메뉴에 대해 결제한다.(ok)
    4.주문이 되면 주문 내역이 입점상점주인에게 주문정보가 전달된다(ok)
    5.상점주는 주문을 수락하거나 거절할 수 있다.(ok)
    6.상점주는 요리시작때와 완료 시점에 시스템에 상태를 입력한다.(ok)
    7.고객은 아직 요리가 시작되지 않은 주문은 취소할 수 있다.(ok)
    
    
![image](https://user-images.githubusercontent.com/2777247/206602730-6836c558-d001-4be4-98fd-b6b9ad2296d8.png)

    8.요리가 완료되면 고객의 지역 인근의 라이더들에 의해 배송건 조회가 가능하다.(ok)
    9.라이더가 해당 요리를 Pick한 후, 앱을 통해 통보한다.(ok)
    10.고객이 주문상태를 중간중간 조회한다.(ok)
    11.주문상태가 바뀔 때 마다 카톡으로 알림을 보낸다.(ok)
    12.고객이 요리를 배달 받으면 배송확인 버튼을 탭하여, 모든 거래가 완료된다.(ok)
    13.배달 시간이 1시간 이상 초과 시 고객에게 금액 환불 한다.(추가)(ok)
     

# 체크포인트
## 1. Saga(Pub/Sub)
 - 시나리오 1. orders로 post 요청 시 OrderPlaced로 Adress Check에 있는 Check커맨드로 요청을 전달한다.(req/res : 동기)
 - 그 주소 체크 후에 Paid이벤트를 거쳐 store에 있는 OrderAccepted정책으로 이벤트를 전달한다.(Pub/Sub : 비동기)
### 구현 : Order.
![image](https://user-images.githubusercontent.com/2777247/206457386-35420888-2917-402d-b6f6-1e604d0ca1d8.png)

### Order 실행.
![image](https://user-images.githubusercontent.com/2777247/206459163-0403f2be-0d05-486a-a802-d24befe67242.png)

### kafka 확인.
![image](https://user-images.githubusercontent.com/2777247/206459463-c3f55051-f2de-40a8-ac71-c4a29ee01475.png)

## 2. CQRS
 - 시나리오 3. 고객이 중간에 주문상태를 조회 하도록 CQRS를 구현한다.
### 속성
![image](https://user-images.githubusercontent.com/2777247/206460267-ea8d4156-81ed-474c-ac45-d84dc218a05d.png)

### 구현
![image](https://user-images.githubusercontent.com/2777247/206460958-ff74a663-ecb9-4eec-8cd3-3ee1106bd620.png)

### 확인
![image](https://user-images.githubusercontent.com/2777247/206465960-e32f103a-b38b-4293-a069-0c3c0ff03b89.png)

## 3. Compensation/Correlation
 - 시나리오 7. 고객이 취소 이벤트(OrderCanceled) 발생 시 Compensation 으로 상태 변경한다.
 ### 구현
 ![image](https://user-images.githubusercontent.com/2777247/206602976-02b7bc50-693d-43e8-ae95-9f024250637c.png)
 ![image](https://user-images.githubusercontent.com/2777247/206603380-dd2cbb0b-b2d3-4369-9701-1bf4fee15725.png)
  
 ### kafka 확인
 ![image](https://user-images.githubusercontent.com/2777247/206603644-6ef900bb-23e4-417e-a8a3-83dec7b5418b.png)

## 4. Request / Response
 - 시나리오 1. orders로 post 요청 시 OrderPlaced로 Adress Check에 있는 Check커맨드로 요청을 전달한다.(req/res : 동기)

### Order 실행.
![image](https://user-images.githubusercontent.com/2777247/206459163-0403f2be-0d05-486a-a802-d24befe67242.png)

## 5. Circuit Breaker
 - 시나리오 13. 주문 시 배달 시간을 Timeout 을 적용하여 구현한다.
### 구현
![image](https://user-images.githubusercontent.com/2777247/206606469-189cae69-35e2-4c05-a073-1c61dd096dd2.png)

## 6.Gateway / Ingress

### 구현
![image](https://user-images.githubusercontent.com/2777247/206467613-6180b191-5572-41fe-9435-9529bdfd136b.png)

