## CORS

### *Same Origin Policy*, 동일 출처 정책

---

동일 출처 정책은 웹 브라우저에서 보안을 강화하기 위해 동일한 출처에서만 리소스를 주고 받도록 하는 정책이다.

- 여기서 ‘출처’는 URL 주소를 의미한다.
- 하지만 ‘동일한 출처’는 정확히 똑같은 URL을 의미하는 것이 아니다.
    - 동일한 출처는 URL 중에서도 *프로토콜*, *도메인 주소*, *포트 번호* 가 같은 것을 의미한다.

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/c33fee58-8f40-4523-b222-c56099de30a9/a4da0a6e-97f7-4973-aa91-4bfa912216b3/Untitled.png)

---

<aside>
📌 즉, *동일한 출처* 란 위의 구성 요소 중 *Protocol + Host + Port* 3가지가 같을 경우를 의미한다.

</aside>

### 동일 출처 정책이 생긴 이유

---

*동일 출처 정책(Same Origin Policy, SOP)* 은 말 그대로, 동일한 출처에서만 리소스를 공유할 수 있다.

때문에 서버에 있는 리소스는 자유롭게 가져올 수 있지만, 다른 서버에 있는 이미지, 비디오 등은 가져올 수 없다.

**[ 다른 출처 요청의 위험성 ]**

---

동일 출처 정책이 생긴 이유는 결국 보안상의 이유이다.

누군가 좋은 목적으로 다른 서버에 있는 리소스를 가져오는 것이면 문제가 없지만, 그렇지 않은 경우도 존재한다.

*<img>, <script>, <frame>, <video>* 등이 웹에 등장하면서, 페이지 로딩 이후 브라우저에서 이러한 하위 자원들을 가져올 수 있게 되었다. 그러므로 ‘동일 출처’, ‘다른 출처’ 모두 호출이 가능하게 되었다.

예를 들어, *CORS* 정책이 없고 모두 다른 출처 요청이 가능한 브라우저가 있다고 가정해보자.

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/c33fee58-8f40-4523-b222-c56099de30a9/d223cfa8-2601-40a5-808b-f88696975c45/Untitled.png)

---

1. 사용자가 홈페이지를 서핑하고 있는데, *<script>* 가 심어진 [*evil.com*](http://evil.com) 페이지를 열었다.
2. 유용한 정보들을 담고 있던 사이트 페이지가 열리면서 *<script>* 가 실행되고, 은행에서는 *Delete /account* 를 요청하도록 설정되어 있다.
3. 그로 인한 AJAX 호출로 은행 API를 호출하게 되고, 사용자의 은행 계좌를 삭제해버리는 사고가 발생한다.

위와 같은 이유로 인해서, 다른 출처의 접근을 막기 위해서 ‘*동일 출처 정책*’ 이 등장하게 된다.

### *Cross-Origin Resource Sharing*, *CORS* 란?

---

*CORS*는 *Cross-Origin Resource Sharing* 의 약자로 직역하면 ‘*교차 출처 리소스 공유*’ 이다.

쉽게 말하면 동일한 출처가 아닌 다른 출처에서 데이터를 주고 받는 것을 허용하는 정책이다.

<aside>
📌 즉, *SOP* 정책을 위반하더라도 *CORS* 정책을 따르면 다른 출처의 리소스는 허용된다.

</aside>

그렇다면 어떠한 원리로 위의 취약점 문제를 해결하며 *SOP* 정책을 회피할 수 있었는지, *CORS* 동작을 살펴보자.

### *CORS* 기본 동작 과정

---

1. 클라이언트에서 HTTP 요청 헤더에 *Origin(출처)* 을 담아서 전달한다.
    - HTTP 프로토콜을 이용해 서버에 *Request* 메시지를 보낸다.
        - 이 때, 여러 헤더들도 보내지만, *Origin* 필드에 출처를 포함하여 전송한다.

   ![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/c33fee58-8f40-4523-b222-c56099de30a9/fe856513-4f09-4aa7-aab3-c0867c1f0844/Untitled.png)

2. 서버는 응답 헤더에 *Access-Control-Allow-Origin* 을 담아서 클라이언트에게 전달한다.
    - 서버가 응답을 할 때, *Access-Control-Allow-Origin* 필드를 추가하고,
    - 값으로는 해당 리소스에 접근하는 것이 허용된 *Origin URL* 을 같이 보낸다.

   ![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/c33fee58-8f40-4523-b222-c56099de30a9/b235d2e9-1baf-4ed1-8557-c236774f2c99/Untitled.png)

3. 클라이언트는 *Origin* 과 서버가 보내준 *Access-Control-Allow-Origin* 을 비교한다.
    - 응답을 받은 클라이언트는 자신이 보냈던 요청의 *Origin* 과
      서버가 보내준 응답의 *Access-Control-Allow-Origin* 을 비교한 후 차단할지 말지를 결정한다.
        - 만약 유효하지 않다면, 해당 응답을 사용하지 않고 CORS 에러를 발생시킨다.
        - 만약 유효하다면, 다른 출처의 리소스를 문제없이 사용할 수 있게 된다.

결론은 *CORS* 정책을 따르기 위해서는 결국 서버 측에서 *Access-Control-Allow-Origin* 헤더에 허용 가능한 리소스 주소를 추가해주어야 *CORS* 문제를 해결할 수 있는 것이다.