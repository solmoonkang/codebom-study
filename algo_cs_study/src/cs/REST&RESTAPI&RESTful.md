# *REST, REST API, RESTful* 이란?

## *REST* 란?

---

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/c33fee58-8f40-4523-b222-c56099de30a9/63ee0eb3-df6d-4c11-a5ca-2a382e1a327b/Untitled.png)

---

*REST* 는 *Representational State Transfer* 의 약자로, 인터넷에서 정보를 주고받는 방식 중 하나이다.

자원을 이름(자원의 표현)으로 구분하여 해당 자원의 상태(정보)를 주고 받는 모든 것을 의미한다.

1. REST는 기본적으로 웹의 기존 기술과 HTTP 프로토콜을 그대로 활용하기 때문에,
    1. 웹의 장점을 최대한 활용할 수 있는 아키텍처 스타일이다.
2. REST는 네트워크 상에서 Client와 Server 사이의 통신 방식 중 하나이다.

<aside>
👀 예를 들어, 블로그를 방문해서 글을 보는 경우를 생각해보자.

블로그의 각 글은 모두 고유한 URL(웹 주소)을 가지고 있다.

그리고 이 ***URL***은 그 글에 대한 ***‘자원의 이름’*** 이라고 볼 수 있다.

웹 브라우저에서 이 URL을 입력하면, 서버는 해당 URL에 연결된 ***‘상태’*** 즉, 그 글의 내용을 보내준다.

이렇게 서버에서 클라이언트로 정보를 주고 받는 것을 REST 방식이라고 한다.

</aside>

---

그렇다면, “자원을 식별하는 주소(자원의 표현)”와 "자원의 상태(정보)” 를 주고 받는 방법을 살펴보자.

1. 자원을 가리키는 주소 혹은 자원의 식별자(자원의 표현):
    - 여기서 자원이란 해당 소프트웨어가 관리하는 모든 것을 의미한다.
    - 따라서 자원의 표현이란 해당 자원을 웹 상에서 고유하게 식별될 수 있도록 하는 역할을 한다.
2. 상태(정보) 전달:
    - 클라이언트가 데이터를 요청하는 시점에 서버에서 자원의 상태(정보)를 전달한다.
    - 여기서 상태(정보)는 주로 JSON 혹은 XML 형식으로 주고 받는 경우가 일반적이다.

*REST* 에 대해서 더 구체적으로 살펴보면,

*HTTP URI* 를 통해 자원을 명시하고, *HTTP Method* 를 통해 해당 자원에 대한 *CRUD Operation* 을 적용한다.

- *HTTP URI* 는 웹 상의 자원을 가리키는 주소이다.
    - 예를 들어, *“https://www.example.com/images/dog.jpg”* 라는 URI는
    - *example.com* 이라는 웹 사이트의 *dog.jpg* 라는 이미지를 가리키는 주소이다.
- *HTTP Method* 는 웹 상의 자원에 대해 어떤 작업을 할 것인지를 나타내는 방법이다.
    - 이 방법에는 POST, GET, PUT, DELETE 등의 방법이 있다.

### *REST* 의 장점

---

1. 손쉬운 사용
    - HTTP 프로토콜 인프라를 그대로 사용하므로 별도의 인프라 구축을 할 필요가 없다.
2. 클라이언트-서버 역할의 명확한 분리
    - 클라이언트는 REST API를 통해 서버와 정보를 주고 받는다.
    - REST의 특징인 무상태에 따라서 서버는 클라이언트의 Context를 유지할 필요가 없다.
3. 특정 데이터 표현이 사용 가능
    - REST API는 헤더 부분에 URI 처리 메소드를 명시하고, 필요한 실제 데이터를 Body에 표현할 수 있도록 분리시켰다.
    - JSON, XML 등 원하는 표현 언어로 사용이 가능하다.

### *REST* 의 단점

---

1. 메소드의 한계
    - REST는 HTTP Method를 이용하여 URI를 표현한다.
    - 이러한 표현은 쉬운 사용이 가능하다는 장점이 있지만, 반대로 메소드의 형태가 제한적이다.
2. 표준이 없음
    - REST는 설계 가이드 일 뿐 표준이 아니다. 즉, 명확한 표준이 존재하지 않는다.
3. 구형 브라우저가 제대로 지원해주지 못하는 부분이 존재
    - PUT, DELETE를 사용하지 못한다.
    - pushState를 지원하는 않는다.

## *REST API* 란?

---

REST 를 기반으로 서비스 API를 구현한 것을 의미한다.

- 최근 OpenAPI(누구나 사용 가능한 API), 마이크로 서비스(큰 애플리케이션을 여러 작은 애플리케이션으로 쪼개서 변경과 조합이 가능한 아키텍처) 등을 제공하는 업체 대부분은 REST API를 제공한다.

### *REST API* 의 특징

---

- 사내 시스템들도 REST를 기반으로 시스템을 분산해 확장성과 재사용성을 높여 유지보수 및 운용을 편리하게 할 수 있다.
- REST는 HTTP 표준을 기반으로 구현하므로, HTTP를 지원하는 프로그램 언어로 클라이언트, 서버를 구현할 수 있다.
- 즉, REST API를 제작하면 델파이 클라이언트 뿐 아니라, 자바, C#, 웹 등을 이용해 클라이언트를 제작할 수 있다.

### *REST API* 기본 설계 규칙

---

1. URI는 정보의 자원을 표현해야 한다.
    - 자원은 동사보다 명사를 사용한다.
    - 자원은 영어 소문자 복수형을 사용하여 표현한다.
2. 자원에 대한 행위는 HTTP Method(POST, GET, PUT, DELETE 등)로 표현한다.
    - URI에 HTTP Method가 들어가면 안된다.
        - EX) *`GET /members/delete/1`* → *`DELETE /members/1`*
    - URI에 행위에 대한 동사 표현이 들어가면 안된다.
        - EX) *`GET /members/show/1`* → *`GET /members/1`*
        - EX) *`GET /members/insert/2`* → *`POST /members/2`*

### *REST API* 설계 규칙

---

1. 슬래시 구분자(/)는 계층 관계를 나타내는데 사용한다.
    - EX) `*http://restapi.example.com/houses/apartments*`
2. URI 마지막 문자로 슬래스(/)를 포함하지 않는다.
    - URI에 포함되는 모든 글자는 리소스의 유일한 식별자로 사용되어야 하며, URI가 다르다는 것은 리소스가 다르다는 것이고, 역으로 리소스가 다르면 URI도 달라져야 한다.
    - REST API는 분명한 URI를 만들어 통신을 해야 하므로, 혼동을 주지 않도록 URI 경로 마지막에는 슬래시(/)를 사용하지 않는다.
    - EX) `*http://restapi.example.com/houses/apartments` (X) → `http://restapi.example.com/houses/apartments` (O)*
3. 하이픈(-)은 URI 가독성을 높이는데 사용한다.
    - 불가피하게 긴 URI 경로를 사용하게 된다면, 하이픈(-)을 사용해서 가독성을 높인다.
4. 언더바(_)는 URI에 사용하지 않는다.
    - 밑줄(_)은 보기 어렵거나 밑줄 때문에 문자가 가려지기도 하므로, 가독성을 위해 사용하지 않는다.
5. URI 경로에는 소문자가 적합하다.
    - URI 경로에서 대문자 사용은 피하도록 한다.
    - RFC 3986에서 URI 스키마와 호스트를 제외하고는 대소문자를 구분하도록 규정하였다.
6. 파일 확장자는 URI에 포함하지 않는다.
    - REST API는 메시지 Body 내용의 포맷을 나타내기 위한 파일 확장자를 URI 안에 포함시키지 않는다.
    - Accept Header를 사용한다.
    - EX) *`http://restapi.example.com/members/soccer/345/photo.jpg` (X)*
    - EX) `*GET / members/soccer/345/photo HTTP/1.1 Host: restapi.example.com Accept: image/jpg` (O)*
7. 리소스 간 연관 관계가 있는 경우
    - *`/리소스명/리소스 ID/관계가 있는 다른 리소스명`*
    - EX) *`GET : /users/{userid}/devices` (일반적으로 소유(’has’)의 관계를 표현할 때)*
8. *`:id`*는 하나의 특정 자원을 나타내는 고유값이다.
    - EX) student를 생성하는 Route: *`POST / students`*
    - EX) ID=12인 student를 삭제하는 Route: *`DELETE /students/12`*

## *RESTful* 이란?

---

RESTful 이란 일반적으로 REST 아키텍처를 구현하는 웹 서비스를 나타내기 위해 사용되는 용어이다.

- REST API 를 제공하는 웹 서비스를 RESTful 하다고 할 수 있다.

RESTful 은 REST를 REST답게 쓰기 위한 방법으로, 누군가가 공식적인 발표를 한 것은 아니다.

- 즉, REST 원리를 따르는 시스템을 RESTful 이라고 지칭한다.

### *RESTful* 의 목적

---

- 이해하기 쉽고 사용하기 쉬운 REST API 를 만드는 것이다.
- RESTful 한 API 를 구현하는 근복적인 목적은 성능 향상이 아닌,

  일관적인 컨벤션을 통한 API의 이해도 및 호환성을 높이는 것으로, 성능이 중요한 상황에서는 굳이 RESTful 한 API를 구현할 필요는 없다.

- RESTful 하지 못한 경우
    - EX) CRUD 기능을 모두 POST 로만 처리하는 API
    - EX) Route 에 Resource, ID 외의 정보가 들어가는 경우 *`/students/updateName`*