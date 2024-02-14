## HTTP & HTTPS

### HyperText Transfer Protocol, HTTP 란?

---

<aside>
📌 HTTP는 **‘서버/클라이언트 모델을 따라 데이터(요청/응답)를 주고 받기 위한 프로토콜’**이다.

이를 간단히 말하면, 웹 상에서 서버와 클라이언트 간에 데이터를 주고 받기 위한 규약이라고 할 수 있다.

</aside>

### HTTP 특징

---

- **주로 HTML 문서**를 주고 받으며, Plain Text로부터 JSON 및 XML과 형태의 정보도 주고 받을 수 있다.
    - 보통 클라이언트가 어떤 정보를 HTML 혹은 JSON 형태로 받고 싶은지 명시해주는 경우가 많다.
- HTTP 메세지에는 **요청과 응답** 두 가지 유형이 있는데, HTTP 요청 및 응답은 일반 텍스트로 전송된다.
    - 때문에 연결을 모니터링하는 모든 사람이 이러한 일반 텍스트를 읽을 수 있다는 문제가 있다.
- HTTP는 기본적으로 TCP/IP 기반의 프로토콜로 TCP를 사용하며, **80번 포트**를 사용하고 있다.
    - HTTP 서버가 80번 포트에서 요청을 기다리고 있으며, 클라이언트는 80번 포트로 요청을 보낸다.
- HTTP는 연결 상태를 유지하지 않는 **‘비연결성(Connectionless)’ 프로토콜**이다.
    - **비연결:** 클라이언트가 요청을 서버에 보내고, 서버가 적절한 응답을 보내면 바로 연결이 끊어진다.
    - 이러한 한계를 해결하기 위해 Cookie와 Session이 등장하게 된다.
- HTTP는 연결을 유지하지 않는 **‘무상태(Stateless)’** 프로토콜이므로 요청/응답 방식으로 동작한다.
    - **무상태:** 연결을 끊는 순간 클라이언트와 서버의 통신은 끝나며 상태 정보를 유지하지 않는다.

### HyperText Transfer Protocol Secure, HTTPS 란?

---

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/c33fee58-8f40-4523-b222-c56099de30a9/257d7c4b-f74f-403d-b62c-f8248b734404/Untitled.png)

<aside>
📌 HTTPS는 **‘HTTP와 동일한 프로토콜이지만 보안 기능을 강화한 프로토콜’**이다.

</aside>

### HTTPS 특징

---

- HTTPS 역시 HTTP의 보안 버전이므로 TCP를 사용하며, **443번 포트**를 사용하고 있다.
    - HTTPS는 암호화와 인증을 위한 추가적인 작업 때문에, 443번 포트를 사용해 보안 연결을 수행한다.
- HTTPS는 일반 텍스트를 이용하는 대신, 웹 상에서 정보를 암호화하는 **SSL**이나 **TLS** 프로토콜을 사용한다.
    - 따라서 ‘HTTP over SSH’ 또는 ‘HTTP over TLS’ 라고도 부른다.
- HTTPS는 SSL 프로토콜 기반의 **대칭 키 암호화** 방식과 **비대칭 키 암호화** 방식을 혼합해서 사용하고 있다.

- SSL과 TLS 프로토콜


    HTTPS는 SSL과 TLS, 두 가지 보안 프로토콜을 통해 클라이언트와 서버가 보안이 향상된 통신을 하는 것을 말한다.
    
    **[ Secure Socket Layer, SSL ]**
    
    ---
    
    - 개인 정보 보호, 인증 그리고 데이터 무결성을 보장하기 위해서 Netscape가 개발했다.
    - SSL의 인지도가 월등히 높고 사용량이 많아 SSL/TLS를 SSL로 부르기도 한다.
    
    **[ Transport Layer Security, TLS ]**
    
    ---
    
    - TLS는 SSL의 이후 버전으로, SSL이 업데이트가 되지 않아 IETF에서 업데이트를 개발하고 이름을 TLS로 변경했다.

### HTTPS를 사용하는 이유

---

1. 클라이언트는 웹 브라우저를 통해 서버에 HTTP를 사용하여 웹 페이지나 이미지 정보 등을 요청한다.
2. 서버는 클라이언트의 요청에 응답하여 요구하는 정보를 제공한다.
    1. 이 정보는 주로 웹 페이지(HTML)의 텍스트이고, HTTP를 통해 텍스트 정보를 교환하게 된다.
3. 이때, 주고받는 텍스트 정보에 주민등록번호나 비밀번호와 같이 민감한 정보가 포함될 수 있다.
    1. 만약, 이러한 민감한 정보를 네트워크 상에서 중간에 제3자가 가로챈다면 보안상 큰 문제가 발생된다.
4. 이렇게 중간에서 주고 받는 정보를 볼 수 없도록 암호화하는 방법인 HTTPS를 사용하게 되었다.

### HTTPS 원리

---

HTTPS는 암호화, 복호화시킬 수 있는 서로 다른 키(공개 키, 개인 키)를 이용해 암호화를 한다.

- 대칭 키 암호화:
    - 클라이언트와 서버가 동일한 키를 사용하여 암호화와 복호화를 진행한다.
    - 키가 노출되면 매우 위험하지만 연산 속도가 빠르다.
- 비대칭 키 암호화:
    - 1개의 쌍으로 구성된 **공개키(public key)**와 **개인키(private key)**를 암호화와 복호화 하는데 사용한다.
    - 키가 노출되어도 비교적 안전하지만 연산 속도가 느리다.

> **비대칭 키 암호화는 공개 키 / 개인 키 암호화 방식을 이용해서 데이터를 암호화한다.
대칭 키는 이해하기 쉬우므로 넘어가고, 비대칭 키에 대해서 살펴보자.**
>

---

- **공개 키(public key)**:
    - 모두에게 공개가 가능한 키이다.
    - 공개 키 저장소에 등록된다.
    - 공개 키로 암호화를 하면, 개인 키로만 복호화할 수 있다. (공개키 암호화 → 개인키 복호화)
- **개인 키(private key)**:
    - 개인에게만 공개가 가능한 키이다.
    - 클라이언트-서버 구조에서는 서버가 가지고 있는 비공개 키이다.
    - 개인 키로 암호화를 하면, 공개 키로만 복호화할 수 있다. (개인키 암호화 → 공개키 복호화)

---

**[ 클라이언트 → 서버 간의 통신 과정 ] ❌**

1. 클라이언트는 서버로부터 공개 키를 얻는다. 공개 키는 서버의 디지털 인증서에 포함되어 있다.
    1. 디지털 인증서는 신뢰할 수 있는 제 3자로부터 서버의 신원을 확인하는데 사용된다.
2. 클라이언트는 사용자의 데이터를 **공개 키로 암호화**한다.
3. 클라이언트는 암호화된 데이터를 HTTPS로 서버에 전송한다.
    1. 이때, 데이터가 중간에 가로채어져도 암호화되어 있으므로 제3자가 내용을 확인할 수 없다.
4. 서버는 클라이언트로부터 전송받은 암호화된 데이터를 **개인 키를 사용하여 복호화**한다.
    1. 개인 키는 서버에만 존재하므로 제3자는 복호화할 수 없다.
5. 서버는 복호화된 데이터를 사용해서 클라이언트의 요청을 처리한다.

### HTTPS 장/단점

**[ HTTPS 장점 ]**

---

- **보안성:** HTTPS는 데이터 암호화를 통해 통신 내용을 안전하게 보호한다.
    - 이는 중간에 제3자가 데이터를 엿보거나 조작하는 것을 방지한다.
- **신원 보증:** HTTPS는 SSL 인증서를 사용하여 웹 사이트의 신원을 보증한다.
    - 이는 사용자가 신뢰할 수 있는 웹 사이트와 통신하고 있음을 확인할 수 있다.
- **검색 엔진 최적화(SEO):** HTTPS는 검색 엔진 최적화에 도움을 준다.
    - 구글과 같은 검색 엔진은 HTTPS를 사용하는 웹 사이트를 선호하고, 안전한 사이트로 간주한다.
    - 따라서 HTTPS를 사용하면 검색 결과에서 더 높은 순위를 얻을 수 있다.

**[ HTTPS 단점 ]**

---

- **성능 저하:** HTTPS는 데이터를 암/복호화하는 과정이 추가되기 때문에 약간의 성능 저하가 발생할 수 있다.
- **비용:** HTTPS를 구현하기 위해서는 SSL 인증서를 구매해야 한다.
    - 인증서의 가격은 발급 기간과 인증서 유형에 따라 다를 수 있다.
- **설정 및 유지 보수의 복잡성:** HTTPS를 구현하려면 웹 서버에서 SSL 인증서를 설치하고 설정해야 한다.
    - 또한, 인증서의 유효 기간이 만료(인터넷 연결이 끊긴 경우)되면 갱신(재인증) 작업이 필요하다.
    - HTTP는 **‘비연결형’**으로 웹 페이지를 보는 도중 인터넷 연결이 끊겼다가 다시 연결되어도 페이지를 계속해서 볼 수 있다.
    - HTTPS는 **‘Socket(데이터를 주고 받는 경로)’** 자체에서 인증을 하기 때문에, 인터넷 연결이 끊기면 소켓 또한 끊어져서 다시 HTTPS 인증이 필요하다.
- **속도:** HTTP 보다 속도가 느리다.

## HTTP와 HTTPS 동작 과정

### HTTP 동작 과정

---

1. **서버 접속:**
    - **클라이언트가 서버에 접속을 시도**한다. 서버의 IP 주소와 포트 번호를 사용하여 접속한다.
    - 클라이언트와 서버 간에 **TCP/IP 연결이 수립되며, 3-way handshaking** 과정을 진행한다.
2. **클라이언트의 요청:**
    - 연결이 수립된 후, 클라이언트는 HTTP 요청을 생성하고 서버로 전송한다.
        - `HTTP Request Message` = `Request Header` + `빈 줄` + `Request Body`
    - 요청 메서드(GET, POST 등)와 요청 URL, 헤더 등의 정보를 포함한다.

   | Request, 요청 | 설명 |
       | --- | --- |
   | Request Header | 요청 메서드 + 요청 URL + HTTP 프로토콜 버전 = POST https://www.google.com HTTP/1.0
    Header 정보는 Key-Value 구조로 이루어져 있다. |
   | 빈 줄 | 요청에 대한 모든 메타 정보가 전송되었음을 알리는 용도이다. |
   | Request Body | 데이터 업데이트 요청과 관련된 내용은 바디에 포함된다. (HTML 폼 컨텐츠 등)
    GET, HEAD, DELETE, OPTIONS 처럼 리소스를 가져오는 요청은 바디에 미포함된다. |
3. **서버의 요청 처리:**
    - 서버는 클라이언트로부터 받은 요청을 처리한다. 요청에 따라 필요한 데이터를 검색하거나, 동적인 처리를 수행한다.
    - 서버는 요청에 대한 응답을 생성한다.
        - `HTTP Response Message` = `Response Header` + `빈 줄` + `Response Body`
4. **응답 전송:**
    - 서버는 생성한 응답을 클라이언트에게 전송한다.
    - 응답은 상태 코드, 헤더, 본문 등의 정보를 포함한다.

   | Response, 응답 | 설명 |
       | --- | --- |
   | Response Header | HTTP 프로토콜 버전 + 응답 코드(상태 코드) + 응답 메세지 = HTTP/1.1 404 Not Found. |
   | 빈 줄 | 요청에 대한 모든 메타 정보가 전송되었음을 알리는 용도이다. |
   | Response Body | 응답 리소스 데이터가 바디에 포함된다.
    201, 204 상태 코드는 바디에 포함되지 않는다. |
5. **클라이언트 응답 처리:**
    - 클라이언트는 서버로부터 받은 응답을 처리한다.
    - 응답의 상태 코드를 확인하여 요청이 성공적으로 처리되었는지를 판단할 수 있다.
    - 응답의 본문을 통해 서버로부터 받은 데이터를 이용할 수 있다.
6. **연결 종료:**
    - 클라이언트와 서버 간의 HTTP 통신이 완료되면 TCP/IP 연결을 닫고, 통신이 종료된다.
        - 4-way handshaking 과정을 진행한다.

### HTTPS 동작 과정

---

HTTPS 통신 과정에서 송신자와 수신자가 암호화 통신을 하기 위한 방법과 수단에 대해 공유한다.

즉, 데이터를 암호화할 대칭키(비밀키)를 타인에게 노출시키지 않고 Client가 Server에게 전송하기 위해 것이다.

먼저, SSL Handshake는 송신자와 수신자가 암호화된 데이터를 교환하기 위한 일련의 협상과정을 알아보자.

**[ SSL Handshake ]**

---

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/c33fee58-8f40-4523-b222-c56099de30a9/fe9f7090-f3c7-4de8-8deb-16a6feab7484/Untitled.png)

---

다음은 SSL Handshake의 과정을 그린 그림으로, 파란색 칸과 노란색 칸은 네트워크 상에서 전달되는 IP 패킷을 표현한 것이다.

여기서 맨 윗줄의 SYN, SYN ACK, ACK는 TCP의 3-way handshake 과정으로 HTTPS가 TCP 기반의 프로토콜이기 때문에 암호화 협상(SSL Handshake)보다 먼저 연결을 생성하기 위한 과정이고,
아래 노란색 칸의 패킷들이 SSL Handshake이다.

1. **SSL Handshake 과정**

   [ 1.1. **Client Hello**: 암호화 알고리즘 나열 및 전달 ]
    
   ---

    - Client는 SSL/TLS 연결을 위해 Server에게 “Client Hello” 메시지(패킷)에 아래 정보를 보낸다.
        - 클라이언트(브라우저)가 사용하는 SSL 혹은 TLS 버전 정보
        - 클라이언트가 사용할 수 있는 **암호화 방식 모음 (Cipher Suite)**
        - 클라이언트가 순간적으로 생성한 **임의의 난수 (랜덤한 데이터)**
        - 이전에 SSL Handshake가 완료된 상태라면, 그때 생성된 **세션 ID**
        - 기타 정보

   [ 1.2. **Server Hello**: 암호화 알고리즘 선택 ]
    
   ---

    - Server는 Client에게 “Server Hello” 메시지에 아래 정보를 보낸다.
        - 클라이언트의 암호화 방식 정보 중에서 **서버가 지원하고 선택한 암호화 방식 (Cipher Suite)**
            - 서버는 클라이언트가 전송한 방식 중 서버가 지원하는 암호화 방식을 선택한다.
        - **서버의 공개키가 담긴 SSL 인증서**. 인증서는 CA의 비밀키로 암호화되어 발급된 상태이다.
        - 서버가 순간적으로 생성한 **임의의 난수 (랜덤한 데이터)**
        - 클라이언트 인증서 요청 (선택사항)
    - SSL 인증서 발급 과정 및 원리


        ![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/c33fee58-8f40-4523-b222-c56099de30a9/c4768dc4-c988-4a92-9278-41c063f8b0a6/Untitled.png)
        
        ---
        
        서버에서 HTTPS 프로토콜을 사용하기 위해서는 인증 기관(CA)로부터 SSL 인증서를 발급받아야 한다.
        
        1. Server는 **공개 키(public key)**와 **비밀 키(private key)**를 생성한다.
        2. Server는 인증서를 발급받기 위해 CA에 **공개 키(public key)**와 Server의 각종 정보를 전달한다.
        3. CA는 Server로부터 전달받은 정보들을 담아서 SSL 인증서를 발급한다.
        4. CA는 **인증서를 암호화**하기 위해서, CA의 **공개 키(public key)**와 **비밀 키(private key)를 생성**한다.
            - CA는 **비밀 키(private key)를 이용해서 SSL 인증서를 암호화**한다.
        5. CA는 암호화한 SSL 인증서를 다시 Server에 전달한다.
        
    
    [ 1.3. **Certificate** → **Server Key Exchange**: 인증서 전달 → 공개키 여부 확인 ]
    
    ---
    
    - Server는 자신의 SSL 인증서를 Client에게 전달한다. 인증서 내부에는 Server가 발행한 공개키가 들어있다. (대부분의 브라우저는 신뢰성 있는 CA들의 정보와 CA가 만든 공개키가 이미 있다.)
        - Server의 **공개키가 SSL 인증서 내부에 없는 경우**, Server가 “Server Key Exchange” 메시지를 통해 직접 공개키를 전달한다.
        - Server의 **공개키가 SSL 인증서 내부에 있을 경우**, Server Key Exchange는 생략되고, Client가 CA의 공개키를 통해 인증서를 복호화한 후 Server의 공개키를 확보할 수 있다.
    - Client는 Server가 보낸 CA의 개인 키로 암호화된 SSL 인증서를 이미 모두에게 공개된 CA의 공개키를 사용하여 암호화된 SSL 인증서를 복호화한다.
        - 정상적으로 복호화되었다면 CA가 발급한 것이 증명되는 셈이고,
        - 만약 등록된 CA가 아니거나, 등록된 CA가 만든 인증서처럼 꾸몄다면 이 과정에서 발각이 되며 브라우저가 경고를 보낸다.
    
    [ 1.4. **ServerHello Done**: 정보 전달 완료 ]
    
    ---
    
    - ServerHello Done은 Server가 Client에게 SSL/TLS 연결을 수립하고 행동을 마쳤음을 전달한다.
    
    [ 1.5. **Client Key Exchange**: 데이터를 암호화할 대칭키 전달 ]
    
    ---
    
    1. Client는 Client와 Server 각각의 랜덤 데이터를 조합하여 **pre-master secret**(데이터 송수신 시 대칭키 암호화에 사용될 키) **값을 생성**한다.
    2. Client가 생성한 pre-master secret 값을 SSL 인증서 내부에서 추출한 Server의 공개키를 이용해서 암호화한 **대칭키(비밀키, 데이터를 실제로 암호화하는 키)**를 Server에 전달한다.
        - 여기서 전달된 ‘대칭키’가 바로 **SSL Handshake의 목적**이자 가장 중요한 수단인 데이터를 실제로 암호화할 **대칭키(비밀키)** 또는 세션 키이다.
    3. Server는 Client로부터 전달받은 암호화된 pre-master secret 값을 Server 개인키를 사용해서 복호화하여 Client와 동일한 세션 키를 생성한다.
        - 이렇게 생성된 세션 키는 해당 통신 세션 동안 유지되며, Client-Server는 이 세션 키를 사용하여 안전한 통신을 이어간다.
    
    [ 1.6. **ChangeCipherSpec / Finished**: SSL Handshake 종료 ]
    
    ---
    
    - Client와 Server는 ChangeCipherSpec 메시지를 교환하여 대칭키, 즉 세션 키 암호화가 활성화되었음을 서로에게 알리게 된다.
        - 이때 메시지에는 Client-Server 간에 암호화 및 복호화를 위한 사용할 알고리즘, 세션 키 등을 협상하고 교환한다.
    - 그리고 Finished 메시지를 보내서 SSL Handshake의 완료를 알린다.

1. **[ SSL Handsake 연결 해제 및 HTTPS 통신 시작 ] - 데이터 전송**
    - Client와 Server는 세션 키를 활용해 데이터를 암호화, 복호화하면서 데이터를 송수신한다.
2. **[ HTTPS 통신 종료 ] - 연결 종료 및 세션 키 폐기**

## HTTP 요청/응답 헤더

HTTP 헤더는 클라이언트와 서버가 요청 또는 응답으로 부가적인 정보를 전송하는 것을 의미한다.

### HTTP 헤더의 분류

---

![스크린샷 2024-01-24 오전 10.47.55.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/c33fee58-8f40-4523-b222-c56099de30a9/93a91c54-b2f0-4027-98ff-49f702b459f8/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2024-01-24_%E1%84%8B%E1%85%A9%E1%84%8C%E1%85%A5%E1%86%AB_10.47.55.png)

**[ RFC2616 과거 ]**

- General Header(공통 헤더)
- Request Header(요청 헤더)
- Response Header(응답 헤더)
- Entity Header(엔티티 헤더)

---

![스크린샷 2024-01-24 오전 10.39.14.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/c33fee58-8f40-4523-b222-c56099de30a9/d0495d82-76de-4d8e-8cd9-cb37b5f35e7f/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2024-01-24_%E1%84%8B%E1%85%A9%E1%84%8C%E1%85%A5%E1%86%AB_10.39.14.png)

**[ Entity Header ]**

---

- 메시지 본문:
    - 엔티티 본문을 전달하는데 사용한다.
- 엔티티 본문:
    - 요청이나 응답에서 전달할 실제 데이터이다.
- 엔티티 헤더:
    - 엔티티 본문의 데이터를 해석할 수 있는 정보를 제공한다.
    - 데이터 유형(html, json), 데이터 길이, 압축 정보 등이 포함되어 있다.

**[ ~~RFC2616 폐기~~ → RFC230~7235 등장 ]**

- Entity(엔티티) → Representation(표현)으로 분류 방식 변경
- 표현 = 표현 메타데이터(Representation Metadata) + 표현 데이터(Representation Data)
- 예를 들어, 리소스(회원 데이터)를 HTML, XML, JSON 등과 같이 여러가지 형태(표현)로 전달할 수 있다.

![스크린샷 2024-01-24 오전 10.39.40.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/c33fee58-8f40-4523-b222-c56099de30a9/859c853e-1202-43b6-b9e0-26627ba72def/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2024-01-24_%E1%84%8B%E1%85%A9%E1%84%8C%E1%85%A5%E1%86%AB_10.39.40.png)

---

- 메시지 본문을 통해 표현 데이터를 전달한다.
- 메시지 본문을 페이로드(payload)라고 한다.
- 표현은 요청이나 응답에서 전달할 실제 데이터(표현 헤더 + 표현 데이터)
- 표현 헤더는 표현 데이터를 해석할 수 있는 정보를 제공한다.
    - 데이터 유형(html, json), 데이터 길이, 압축 정보 등 HTTP Body 부분을 설명한다.

### HTTP 헤더 내 공통 헤더(General Header)

---

요청과 응답 모두에 적용되지만, 바디에서 최종적으로 전송되는 데이터와는 관련이 없는 헤더이다.

| 주요 항목 | 설명 |
| --- | --- |
| Data | HTTP 메시지를 생성한 일시를 나타낸다.
Data: Sat, 2 Oct 2018 02:00:12 GMT |
| Pragma | 캐시제어, HTTP/1.0에서 사용하던 것으로, HTTP/1.1에서는 Cache-Control을 사용한다. |
| Cache-Control | 캐시를 제어할 때 사용한다. |
| Upgrade | 프로토콜 변경 시 사용한다. |
| Via | 중계(프록시) 서버의 이름, 버전, 호스트명 |
| Connection | 네트워크 접속을 유지할지 말지를 제어한다.
Connection: close → 현재 HTTP 메시지 직후에 TCP 접속을 끊는다는 것을 알린다.
Connection: Keep-Alive → 현재 TCP 접속을 유지한다. (Default) |
| Transfer-Encoding | 사용자에게 entity를 안전하게 전송하기 위해 사용하는 인코딩 형식을 지정한다. |

### HTTP 헤더 내 표현 헤더(Representation Header)

---

요청 및 응답 메시지 모두에서 사용 가능한 헤더이다.

| 주요 항목 | 설명 |
| --- | --- |
| Content-Type | 해당 개체에 포함되는 미디어 타입 정보이다. |
|  | - 컨텐츠의 타입(MIME 미디어 타입) 및 문자 인코딩 방식(EUC-KR, UTF-8)을 지정한다.
- 타입 및 서브타입으로 구성되어 있다.
  Content-Type: text/html; charset-latin-1 → 해당 개체가 html로 표현된 텍스트 문서이고, iso-latin-1 문자 인코딩 방식으로 표현된다. |
  | Content-Language | 해당 개체와 가장 잘 어울리는 사용자 언어 |
  | Content-Encoding | 해당 개체 데이터의 압축 방식 |
  |  | Content-Encoding: gzip, deflate
- 만약 압축이 시행되었다면, Content-Encoding 및 Content-Length 2개 항목을 토대로 압축 해제가 가능하다. |
  | Content-Length | 전달되는 해당 개체의 바이트 길이 또는 크기(10진수) |
  |  | - 응답 메시지 Body의 길이를 지정하거나, 특정 지정된 개체의 길이를 지정한다. |
  | Content-Location | 해당 개체가 실제 어디에 위치하는지를 알려준다. |
  | Content-Disposition | 응답 Body를 브라우저가 어떻게 표시해야 할지 알려주는 헤더이다. |
  |  | - inline인 경우 웹 페이지 화면에 표시되고, attachment인 경우 다운로드된다.
  Content-Disposition: inline
  Content-Disposition: attachment; filename=’filename.csv’
- 다운로드 되길 원하는 파일은 attachment로 값을 설정하고, filename 옵션으로 파일명까지 지정해줄 수 있다.
- 파일용 서버인 경우 이 태그를 자주 사용한다. |
  | Content-Security-Policy | 다른 외부 파일들을 불러오는 경우, 차단할 소스와 불러올 소스를 명시한다. |
  |  | - XSS 공격에 대한 방어가 가능하다. 단, 허용한 외부 소스만 지정이 가능하다.
  Content-Security-Policy:default-src https:→https를 통해서만 파일을 가져옴
  Content-Security-Policy:default-src 'self':→자신의 도메인 파일들만 가져옴
  Content-Security-Policy:default-src 'none':→파일을 가져올 수 없음 |
  | Location | 리소스가 리다이렉트된 때에 이동된 주소, 또는 새로 생성된 리소스 주소이다. |
  |  | - 300번대 응답이나 201 Created 응답일 때, 어느 페이지로 이동할지를 알려주는 주소
- 새로 생성된 경우에 HTTP 상태 코드 201 Created 가 반환된다.
  HTTP/1.1 302 Found Location: / → 브라우저는 / 주소로 리다이렉트한다. |
  | Last-Modified | 리소스를 마지막으로 갱신한 일시이다. |

### HTTP 헤더 내 요청 헤더(Request Header)

---

요청 헤더는 HTTP 요청 메시지 내에서만 나타나며 가장 방대하다.

| 주요 항목 | 설명 |
| --- | --- |
| Host | 요청하는 호스트에 대한 호스트명 및 포트번호 (필수) |
|  | - Host 필드에 도메인명 및 호스트명 모두를 포함한 전체 URI(FQDN) 지정이 필요하다.
- 이에 따라 동일 IP 주소를 갖는 단일 서버에 여러 사이트를 구축 가능하다. |
| User-Agent | 클라이언트 소프트웨어(브라우저, OS) 명칭 및 버전 정보 |
| From | 클라이언트 사용자 메일 주소 |
|  | - 주로 검색엔진 웹 로봇의 연락처, 메일 주소를 나타낸다.
- 때로는 이 연락처, 메일 주소를 User-Agent 항목에 두는 경우도 있다. |
| Cookie | 서버에 의해 Set-Cookie로 클라이언트에게 설정된 쿠기 정보이다. |
| Referer | 바로 직전에 머물렀던 웹 링크 주소이다. |
| If-Modified-Since | 제시한 일시 이후로만 변경된 리소스를 취득 요청한다. |
| Authorization | 인증 토큰(JWT/Bearer 토큰)을 서버로 보낼 때 사용하는 헤더이다. |
|  | - 토큰의 종류(Basic, Bearer 등) + 실제 토큰 문자를 전송 |
| Origin | - 서버로 POST 요청을 보낼 때, 요청이 어느 주소에서 시작되었는지를 나타낸다.
- 여기서 요청을 보낸 주소와 받는 주소가 다르면, CORS 에러가 발생한다.
- 응답 헤더의 Access-Control-Allow-Origin과 연관이 있다. |

**[ HTTP 메시지 Body의 속성 또는 내용 협상용 항목들 ]**

---

| 협상용 항목 | 설명 |
| --- | --- |
| Accept | 클라이언트는 자신이 원하는 미디어 타입 및 우선순위를 알린다.
- Accept: */* → 어떤 미디어 타입도 가능하다.
- Accept: image/* → 모든 이미지 유형이 가능하다. |
  | Accept-Charset | 클라이언트 자신이 원하는 문자 집합 |
  | Accept-Encoding | 클라이언트 자신이 원하는 문자 인코딩 방식 |
  | Accept-Language | 클라이언트 자신이 원하는 가능한 언어 |

### HTTP 헤더 내 응답 헤더(Response Header)

---

특정 유형의 HTTP 요청이나 특정 HTTP 헤더를 수신했을 때, 이에 응답한다.

| 주요 항목 | 내용 |
| --- | --- |
| Server | 서버 소프트웨어 정보 |
| Accept-Range |  |
| Set-Cookie | 서버측에서 클라이언트에게 세션 쿠키 정보를 설정한다. |
| Expires | 리소스가 지정된 일시까지 캐시로써 유효하다. |
| Age | 캐시 응답, max-age 시간 내에서 얼마나 시간이 흘렀는지 알려준다. (초 단위) |
| ETag | HTTP 컨텐츠가 바뀌었는지를 검사할 수 있는 태그이다. |
| Proxy-authenticate |  |
| Allow | 해당 엔티티에 대해 서버 측에서 지원 가능한 HTTP 메서드의 리스트를 나타낸다. |
|  | - 때로 HTTP 요청 메시지의 HTTP 메서드 OPTIONS에 대한 응답용 항목이다.
- OPTIONS: 웹 서버측에서 제공하는 HTTP 메서드에 대한 질의이다. |
| Access-Control-Allow-Origin | 요청을 보내는 프론트 주소와 받는 백엔드 주소가 다르면, CORS 에러가 발생한다. |
|  | - 서버에서 이 헤더에 프론트 주소를 적어줘야 에러가 발생하지 않는다.
Access-Control-Allow-Origin: www.zerocho.com
- 프로토콜, 서브도메인, 도메인, 포트 중 하나만 달라도 CORS 에러가 발생한다.
  Access-Control-Allow-Origin: *
- 만약 주소를 일일히 지정하지 싫다면 *으로 모든 주소에 CORS 요청을 허용한다.
- 유사한 헤더로 Access-Control-Request-Method, Access-Control-Request-Headers, Accesas-Control-Allow-Methods, Access-Control-Allow-Headers 등이 있다. |