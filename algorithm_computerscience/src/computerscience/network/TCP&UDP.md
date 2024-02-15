## TCP와 UDP

> **TCP와 UDP는 OSI 7 계층들 중 전송 계층에서 사용되는 프로토콜이다.**
>

---

**[ 전송 계층은 송신자와 수신자를 연결하는 통신서비스를 제공하는 계층이다. ]**

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/c33fee58-8f40-4523-b222-c56099de30a9/62b0706f-a619-45dd-b70d-d07d84ba7d68/Untitled.png)

### TCP(Transmission Control Protocol), 전송을 제어하는 프로토콜

---

<aside>
📌 **TCP란 '인터넷상에서 데이터를 메세지의 형태로 보내기 위해 IP와 함께 사용하는 프로토콜'이다.**

</aside>

---

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/c33fee58-8f40-4523-b222-c56099de30a9/eaf83282-5c92-4068-a897-981eb3c2da58/Untitled.png)

---

- TCP는 ‘연결 지향적 프로토콜’이다.
    - 연결 지향적 프로토콜: 클라이언트와 서버가 연결된 상태에서 데이터를 주고받는 프로토콜을 의미한다.
- TCP는 인터넷을 통해 디바이스에서 웹 서버로 데이터를 전송하는 네트워크 프로토콜이다.
    - TCP/IP 프로토콜이라고도 한다.
- TCP는 연결 기반으로 데이터를 전송하는 동안 수신자와 발신자 사이의 연결을 설정하고 유지한다.
    - 때문에, 데이터가 **안정적으로, 순서대로, 에러 없이** 도착할 수 있도록 보장한다.
- 이렇게 장치들 사이에 논리적인 접속을 성립하기 위한 연결을 설정해서 ‘신뢰성을 보장하는 연결 서비스’이다.

예를 들어, 친구와 메신저로 채팅을 하거나, 이메일을 보내거나, 웹을 검색할 때마다 TCP를 사용한다.

### TCP 특징

---

1. 연결형 서비스로 가상 회선 방식을 제공한다.
    - 3-way handshake 과정을 통해 연결을 설정하고,
    - 4-way handshake 을 통해 해제한다.
2. 흐름제어(Flow Control) 및 혼잡 제어(Congestion Control)
    - 흐름제어(Flow Control): 데이터 처리 속도를 조절하여 수신자의 버퍼 오버플로우를 방지한다.
    - 혼잡 제어(Congestion Control): 네트워크 내의 패킷 수가 과도하게 증가하지 않도록 방지한다.
3. 높은 신뢰성을 보장한다.
    - 신뢰성이 높은 전송을 하기 때문에 UDP 보다 속도가 느리다.
4. 전이중(Full-Duplex), 점대점(Point to Point) 방식을 사용한다.
    - 전이중(Full-Duplex): 전송이 양방향으로 동시에 일어날 수 있다.
    - 점대점(Point to Point): 각 연결이 정확히 2대의 종단점을 가지고 있다.

### UDP(User Datagram Protocol), 데이터의 정확한 전송을 보장하지 않는 프로토콜

---

<aside>
📌 **UDP는** **'데이터를 데이터그램 단위로 처리하는 프로토콜'이다.**

</aside>

---

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/c33fee58-8f40-4523-b222-c56099de30a9/478f7e86-e235-4405-82f0-21095a2872e6/Untitled.png)

---

- UDP는 '비연결형 프로토콜'이다.
    - 연결을 위해 할당되는 논리적인 경로가 없다.
    - 때문에, 각각의 패킷은 다른 경로로 전송되고, 각각의 패킷은 독립적인 관계를 지니게 된다.
    - 즉, 데이터를 서로 다른 경로로 독립적으로 처리한다.
- 정보를 주고 받을 때, 정보를 보내거나 받는다는 신호절차를 거치지 않는다.

### UDP 특징

---

- 비연결형 서비스로 데이터그램 방식을 제공한다.
    - 데이터의 전송 순서가 바뀔 수 있다.
- 데이터 수신 여부를 확인하지 않는다.
    - TCP의 3-way handshake와 같은 과정이 존재하지 않는다.
    - 즉, 연결을 설정하고 해제하는 과정이 존재하지 않는다.
- 신뢰성이 낮다.
    - Flow Control, 흐름 제어가 없어서 제대로 전송되었는지, 오류가 없는지 확인할 수 없다.
- TCP보다 속도가 빠르며 네트워크 부하가 적다는 장점이 있지만, 신뢰성 있는 데이터 전송을 보장하지 못한다.
- 1:1 & 1:N & N:N 통신이 가능하다.

### TCP vs UDP

---

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/c33fee58-8f40-4523-b222-c56099de30a9/ef32cfca-c444-4fe5-8987-1e98ce3b1f26/Untitled.png)

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/c33fee58-8f40-4523-b222-c56099de30a9/d8928447-a1a8-473f-8068-5b1cc25237e3/Untitled.png)

---

**[ 각 프로토콜의 특징 ]**

| 프로토콜 종류 | TCP | UDP |
| --- | --- | --- |
| 연결 방식 | 연결형 서비스 | 비연결형 서비스 |
| 패킷 교환 방식 | 가상 회선 방식 | 데이터그램 방식 |
| 전송 순서 | 전송 순서 보장 | 전송 순서가 바뀔 수 있음 |
| 수신 여부 확인 | 수신 여부를 확인함 | 수신 여부를 확인하지 않음 |
| 통신 방식 | 1:1 통신 | 1:1 OR 1:N OR N:N 통신 |
| 신뢰성 | 높다 | 낮다 |
| 속도 | 느리다 | 빠르다 |

## TCP와 UDP의 헤더 분석

### TCP 헤더 분석

---

![스크린샷 2024-01-17 오후 4.21.57.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/c33fee58-8f40-4523-b222-c56099de30a9/5aaf2884-7264-446b-a314-3b38d1ce95f5/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2024-01-17_%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE_4.21.57.png)

---

**[ TCP는 상위계층으로부터 데이터를 받아 헤더를 추가해 IP로 전송한다. ]**

| 필드 | 내용 | 크기(Bits) |
| --- | --- | --- |
| Source Port, Destination Port | TCP로 연결되는 가상 회선 양단의 송수신 프로세스에 할당되는 포트 주소이다. | 16Bits |
| Sequence Number | 송신자가 지정하는 순서 번호이다.
전송되는 바이트 수를 기준으로 증가한다.
SYN = 1 은 초기 시퀸스 번호이다. (ACK 번호는 여기에 +1) | 32Bits |
| Acknowledgment(ACK) Number | 수신 프로세스가 제대로 수신한 바이트의 수이다. (응답용) | 32Bits |
| Header Length(Data Offset) | TCP 헤더 길이를 4Byte 단위로 표시한다.
(최소 20Byte ~ 최대 60Byte) | 4Bits |
| Resv(Reserved) | 나중을 위해 0으로 채워진 예약 필드이다. | 6Bits |
| Flag Bit | SYN, ACK, FIN 등 제어 번호가 있다. | 6Bits |
| Window Size | 수신 윈도우의 버퍼 크기를 지정한다. (0이면 송신 중지)
상대방의 확인이 없어도 전송 가능한 최대 Byte 수이다. | 16Bits |
| TCP Checksum | 헤더와 데이터의 에러 확인 용도이다. | 16Bits |
| Urgent Pointer | 현재 순서 번호부터 표시된 바이트까지 긴급한 데이터를 표시한다.
URG Flag Bit가 지정된 경우에만 유효하다. | 16Bits |
| Options | 추가 옵션이 있을 경우에 표시한다. | 0~40Bits |
- **Flag Bit 종류**


    | 종류 | 내용 |
    | --- | --- |
    | URG | 긴급 위치 필드 유효 여부를 설정한다. |
    | ACK | 응답 유효 여부를 설정한다. 최초의 SYN 패킷 이후 모든 패킷은 ACK 플래그 설정이 필요하다.
    데이터를 잘 받았으면, 긍정 응답으로 ACK(=SYN + 1)를 전송한다. |
    | PSH | 수신측에 버퍼링된 데이터를 상위 계층에 즉시 전달할 때 사용된다. |
    | RST | 연결 리셋 응답 OR 유효하지 않은 세그먼트를 응답할 때 사용된다. |
    | SYN | 연결 설정 요청이다. 양쪽이 보낸 최초 패킷에만 SYN 플래그를 설정한다. |
    | FIN | 연결 종료 의사를 표시한다. |

### UDP 헤더 분석

---

![스크린샷 2024-01-17 오후 4.22.39.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/c33fee58-8f40-4523-b222-c56099de30a9/1d46ce5b-8361-4892-920d-5d8cb01925d0/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2024-01-17_%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE_4.22.39.png)

---

**[ UDP는 TCP와 달리 연결을 설정하지 않으며, 데이터의 순서 확인이나 에러 복구 기능을 제공하지 않는다. ]**

| 필드 | 내용 | 크기(Bits) |
| --- | --- | --- |
| Source Port, Destination Port | 송 / 수신 애플리케이션의 포트 번호이다. | 16Bits |
| Length | 헤더와 데이터를 포함한 전체 길이이다. | 16Bits |
| Checksum | 헤더와 데이터의 에러를 확인하는 용도이다.
UDP는 에러 복구를 위한 필드가 불필요해 TCP 헤더에 비해 간단하다. | 16Bits |

## TCP의 3-way handshake와 4-way handshake

### TCP 연결 성립 과정, 3-Way Handshake

---

![스크린샷 2024-01-17 오후 4.49.32.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/c33fee58-8f40-4523-b222-c56099de30a9/ba49f502-f9ef-411b-b8a9-272b63d866ce/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2024-01-17_%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE_4.49.32.png)

---

**[ TCP는 신뢰성 확보를 위해 '3-way handshake' 작업을 진행한다. ]**

1. **SYN 단계:**
    - 클라이언트는 서버에 클라이언트의 ISN을 담아 SYN을 보낸다.
        - ISN은 Initial Sequence Numbers의 약어이다.
        - ISN은 초기 네트워크 연결할 때 할당된 32Bits 고유 시퀸스 번호이다.
        - ISN은 새로운 TCP 연결을 첫 번째 패킷에 할당된 임의의 시퀸스 번호를 말한다.
2. **SYN + ACK 단계:**
    - 서버는 클라이언트의 SYN을 수신하고 서버의 ISN을 보내며 승인번호로 클라이언트의 ISN+1을 보낸다.
        - SYN은 SYNchronization의 약자로, 연결 요청 플래그이다.
3. **ACK 단계:**
    - 클라이언트는 서버의 ISN+1 한 값인 승인번호를 담아서 ACK를 서버에 보낸다.

이렇게 3-way handshake 과정 이후 신뢰성이 구축되고 데이터 전송을 시작한다.

TCP는 이런 과정이 있어서 신뢰성 있는 계층이라고 하며, UDP는 해당 과정이 없어 신뢰성 없는 계층이라고 한다.

### TCP 연결 해제 과정, 4-Way Handshake

---

![스크린샷 2024-01-17 오후 5.01.01.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/c33fee58-8f40-4523-b222-c56099de30a9/618b80cf-cbf7-4ba0-86c7-f6eebe10e2ce/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2024-01-17_%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE_5.01.01.png)

---

**[ TCP가 연결을 해제하기 위해 '4-way handshake' 작업을 진행한다. ]**

1. **FIN_WAIT_1 단계**:
    - 클라이언트가 연결을 닫으려고 할 때, FIN으로 설정된 세그먼트를 보낸다.
    - 그리고 클라이언트는 FIN_WAIT_1 상태로 들어가고 서버의 응답을 기다린다.
2. **CLOSE_WAIT & FIN_WAIT_2 단계**:
    - 서버는 클라이언트로 ACK라는 승인 세그먼트를 보낸다.
    - 그리고 CLOSE_WAIT 상태에 들어간다.
    - 클라이언트가 세그먼트를 받으면, FIN_WAIT_2 상태에 들어간다.
3. **LAST_ACK 단계**:
    - 서버는 ACK를 보내고 일정 시간 이후에 클라이언트에게 FIN이라는 세그먼트를 보낸다.
4. **TIME_WAIT & CLOSED 단계**:
    - 클라이언트는 TIME_WAIT 상태가 되고 다시 서버로 ACK를 보내서 서버는 CLOSED 된다.
    - 이후, 클라이언트는 어느 정도의 시간을 대기한 후 연결이 닫히고, 클라이언트와 서버의 모든 자원 연결이 해제된다.

❓ 해당 과정에서 가장 눈여겨봐야 할 과정은 TIME_WAIT 단계이다.

TIME_WAIT 단계에서는 그냥 연결을 닫지 않고 일정 시간 뒤에 CLOSED 상태에 들어갈까?

---

1. 첫 번째는 지연 패킷이 발생할 경우를 대비하기 위함이다. 패킷이 뒤늦게 도달하고 이를 처리하지 못한다면 데이터 무결성 문제가 발생한다.
    1. 예를 들어, 전체 데이터가 100일 때 일부 데이터인 50만 들어오는 현상이 발생할 수도 있는 것이다.
2. 두 번째는 두 장치 간 연결이 닫혔는지 확인하기 위함이다. 만약, LAST_ACK 상태에서 닫히게 되면 다시 새로운 연결을 하려고 할 때, 장치는 줄곧 LAST_ACK 상태로 되어 있기 때문에 접속 오류가 나타나게 된다.

따라서, 위와 같은 이유들로 TIME_WAIT 이라는 단계에서 잠시 기다릴 시간이 필요하다.

## 면접 예상 질문

### ❓ TCP 관련 질문 1

### Q. TCP의 연결 설정 과정(3단계)과 연결 종료 과정(4단계)이 단계가 차이나는 이유?

---

**A. 클라이언트가 데이터 전송을 마쳤다고 하더라도 서버는 아직 보낼 데이터가 남아있을 수 있기 때문에 우선 FIN에 대한 ACK만 보내고, 데이터를 모두 전송한 후에 자신도 FIN 메세지를 보내기 때문이다.**

### ❓ TCP 관련 질문 2

### Q. 만약, 서버에서 FIN 플래그를 전송하기 전에
전송한 패킷이 라우팅 지연이나 패킷 유실로 인한 재전송 등으로 인해
FIN 패킷보다 늦게 도착하는 상황이 발생하면 어떻게 될까?

---

**A. 이러한 현상에 대비하여 클라이언트는 서버로부터 FIN 플래그를 수신하더라도 일정시간 동안 세션을 남겨 놓고 잉여 패킷을 기다리는 과정을 거친다. (TIME_WAIT 과정)**

### ❓ TCP 관련 질문 3

### Q. 초기 Sequence Number인 ISN을 0부터 시작하지 않고 난수를 생성해서 설정하는 이유?

---

**A. Connection(연결)을 맺을 때 사용하는 포트는 유한 범위 내에서 사용하고 시간 지남에 따라 재사용된다.**

**그래서 두 통신 호스트가 과거에 사용된 포트 번호 쌍을 사용하는 가능성이 존재한다.**

**서버 측에서는 패킷의 SYN을 보고 패킷을 구분하게 되는데, 난수가 아닌 순차적인 번호가 전송된다면 이전의 연결로부터 오는 패킷으로 인식할 수 있다.**

**따라서, 이런 문제가 발생할 가능성을 줄이기 위해 난수로 ISN을 설정한다.**