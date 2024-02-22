# ⚛️ *Frame & Packet & Segment & Datagram* 이란?

## 네트워크 데이터 단위 정리

---

네트워크는 정보 전송 및 공유를 쉽게 만들어서 인터넷을 통해 로컬 혹은 전세계로 정보를 공유할 수 있다.

- 로컬 네트워크 또는 전세계로 데이터를 공유하는 동안 데이터는 “Byte” 로 표시된다.

그런 네트워크를 표현한 OSI 7 계층 모델을 예시로, 데이터 바이트는 특정 형식을 갖는다.

- 데이터 바이트는 각 계층마다 사용되는 프로토콜 또는 연결에 따라 데이터 단위가 다르다.
- 각 계층을 거치면서 헤더 정보가 추가되고, 그에 따라 데이터 단위 이름도 달라진다.

<aside>
📌 여기서 각 계층에서 처리하는 한 덩어리의 데이터 단위를 “*PDU(Protocol Data Unit)”* 이라고 한다.

</aside>

### OSI 7 계층과 TCP / IP 4 계층의 PDU

---

| 계층 | 계층명, PDU |
| --- | --- |
| L7. Application | Message(Data) |
| L6. Presentation | Message(Data) |
| L5. Session | Message(Data) |
| L4. Transport | Segments |
| L3. Network | Packets |
| L2. Data-Link | Frames |
| L1.Physical | Bits |

| 계층 | 계층명, PDU |
| --- | --- |
| L4. Application | TCP - Segments |
|  | UDP - Datagrams |
|  |  |
| L3. Transport | Packets |
| L2. Internet | Frames |
|  |  |
| L1. Network Access | Bits |

## *PDU, Protocol Data Unit* 이란?

---

PDU 는 제어 정보를 포함한 HEADER 와 데이터 자체인 PAYLOAD 로 구성되어 있다.

- 이러한 데이터 단위는 처리되는 계층에 따라서 명칭이 다르다.

예를 들어, 데이터-링크 계층의 이더넷이라면, “이더넷 프레임” 이라고 부르거나 혹은 네트워크 계층의 IP 라면, “IP 패킷” 등과 같이 조합해서 부를 수 있다.

## 캡슐화와 비캡슐화 란?

### *Encapsulation*, 캡슐화

---

송신 측에서 애플리케이션 계층에서 순서대로 각 계층에서 PAYLOAD 에 HEADER 를 붙여 PDU 로 만들어서
한 단계 아래에 있는 계층으로 전달한다.

- 여기서 HEADER 를 추가하는 과정, 즉 필요한 데이터를 추가해 나가는 과정을 캡슐화 라고 한다.

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/c33fee58-8f40-4523-b222-c56099de30a9/ef0fb899-c08c-4dbd-9fc1-f4ecdd5a735b/Untitled.png)

### *Decapsulation,* 비캡슐화

---

수신 측에서는 물리 계층에서 순서대로 PDU 로부터 HEADER 를 제거하고, PAYLOAD 만 한 단계 위 계층으로 전달한다.

- 여기서 HEADER 를 제거하는 과정, 즉 데이터를 제거해 나가는 과정을 비캡슐화 라고 한다.