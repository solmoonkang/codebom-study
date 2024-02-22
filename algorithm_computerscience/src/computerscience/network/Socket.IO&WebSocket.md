# *🚀 Socket.IO vs WEBSocket*

## *WebSocket* 이란?

---

WebSocket 은 HTML5의 표준 기술로 양방향 통신을 지원하는 통신 프로토콜이다.

<aside>
📌 즉, 웹 페이지의 한계에서 벗어나 실시간으로 상호작용하는 웹 서비스를 만드는 표준 기술이다.

</aside>

## *WebSocket* 배경

---

기존 HTTP 프로토콜은 클라이언트에서 서버로의 단방향 통신을 위해서 만들어진 프로토콜이다.

하지만, 실시간 웹을 구현하기 위해서는 양방향 통신이 필요했고 이를 구현하기 위해 Polling, Streaming 방식의 AJAX 코드를 이용해서 이를 구현하였다.

그러나 이 방법들을 이용해도 각 브라우저마다 구현 방법이 달라져서 개발이 어렵다는 문제점이 발생하였다.

이러한 한계를 해결하기 위해 HTML5 표준의 일부로 WebSocket 이 만들어지게 되었다.

## *WebSocket* 통신 과정

---

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/c33fee58-8f40-4523-b222-c56099de30a9/f80a5917-cd41-4e12-b844-104a36a65bfa/Untitled.png)

WebSocket 과 HTTP 모두 Handshake 과정에서는 동일한 방식을 사용한다.

- 하지만 WebSocket 은 연결이 확립된 후, WebSocket 독자적인 프로토콜을 사용해서 연결을 유지한다.

WebSocket 은 데이터의 송 / 수신에 커넥션을 맺을 필요없이 하나의 커넥션만으로 데이터를 송 / 수신할 수 있다.

- 사용 방법은 AJAX 와 비슷하지만, 서버도 클라이언트를 인지하기 때문에 양방향 통신이 가능하다는 차이점이 있다.

## *WebSocket* 특징

---

- WebSocket 은 소켓을 이용하여 자유롭게 데이터를 주고 받을 수 있다.
- WebSocket 은 기존 요청-응답 방식보다 더 쉽게 데이터를 주고 받을 수 있다.
- 다른 HTTP Request 과 마찬가지로, 80 Port 를 통해서 웹 서버에 연결한다.
- *“http://”* 대신 *“ws://”* 으로 시작하며, Streaming 과 유사한 방식으로 푸쉬를 지원한다.
- 클라이언트인 브라우저와 마찬가지로, 서버 측도 WebSocket 기능을 지원해야 한다.
    - WebSocket 을 지원하는 서버 구현체는 다음과 같다: Jetty, GlassFish, Node.js, Netty 등
    - WebSocket 을 지원하는 클라이언트 브라우저는 다음과 같다: Chrome, Safari, Firefox 등
- WebSocket 프로토콜은 아직 확정된 상태가 아니기 때문에, 브라우저별 지원하는 버전이 다르다.
    - 즉, WebSocket 은 앞으로 다가올 미래 기술로, 인터넷 기업에서 시범 사용하기에는 이르다.

## *WebSocket* 장점과 주의할 점

### *WebSocket* 장점

---

- HTTP 통신과는 다르게 서버가 클라이언트에게 데이터를 보내 양방향 통신이 가능하다.
- HTTP 요청과는 다르게 최초 연결 이후, 최소한의 헤더 정보만을 사용해 데이터 오버헤드를 줄일 수 있다.
- WebSocket 은 연결이 종료될 때까지 연결이 지속되기 때문에, 연결 설정에 따른 대기 시간을 줄일 수 있다.

### *WebSocket* 사용 시 주의해야 할 점

---

- WebSocket 은 HTTP 통신과는 다르게 stateful(무상태) 하다는 특징이 있어, 비정상적인 연결 중단에 대한 대책을 세워야 한다.
- 서버와 클라이언트가 항상 연결되어 있기 때문에, Socket 연결 유지 비용이 필요하다는 점을 고려해야 한다.
- 서버와 클라이언트 간 연결이 끊어졌을 때 생성되는 메시지가 구체적이지 않다.

## *Socet.IO* 란?

---

Socket.IO 는 WebSocket 을 기반으로 실시간 웹 애플리케이션을 위한 JavaScript 라이브러리이다.

Socket.IO 는 다양한 방법을 하나의 API 로 추상화한 것으로,

- WebSocket, FlashSocket, AJAX Long Polling, IFrame 등의 방법을 추상화하였다.

<aside>
📌 즉, 웹 클라이언트와 서버 간 실시간 양방향 통신을 가능하게 해주는 *Node.js* 의 모듈이다.

</aside>

## *Socket.IO* 특징

---

- Socket.IO 는 표준 기술이 아니며 라이브러리이고, 현재 바로 사용할 수 있는 기술이다.
- Socket.IO 는 소켓 연결 실패 시 fallback을 통해 다른 방식으로 알아서 해당 클라이언트와 연결을 시도한다.
- Socket.IO 는 방 개념을 이용해서 일부 클라이언트에게만 데이터를 전송하는 브로드캐스팅이 가능하다.

## *Socket.IO* 장점

---

- 개발자가 Socket.IO 를 이용해 개발을 하면서 클라이언트에게 푸쉬 메시지를 보낼 경우,
- WebSocket 을 지원하지 않는 브라우저의 경우 브라우저 모델과 버전에 따라서
    - AJAX Long Polling, MultiPart Streaming, Iframe 등을 이용한 푸쉬,
    - JSON Polling, Flash Socket 등 다양한 방법으로 내부에 푸쉬 메시지를 보내준다.
- 즉, WebSocket 을 지원하지 않는 어느 브라우저라도 푸쉬 메시지를 일관된 모듈로 보낼 수 있다.