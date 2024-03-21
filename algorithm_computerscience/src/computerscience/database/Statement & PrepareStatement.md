## 📮 Statement와 PrepareStatement 란?

---

Statement와 PrepareStatement는 JDBC API를 통해서 DB와 상호작용할 때 사용하는 인터페이스이다.

이 둘의 공통점은 SQL 명령을 DB에 보내기 위해서 사용하는데, 두 인터페이스 사이에는 중요한 차이점이 있다.

### Statement

---

- Statement 인터페이스는 정적 SQL 문을 실행할 때 사용된다.
    - 따라서 매 실행마다 SQL 문을 DB 엔진으로 전송하여 컴파일하기 때문에
    - 동일한 SQL 문을 반복해서 실행할 경우 비효율적일 수 있다.
- Statement 인터페이스는 SQL Injection 공격에 취약할 수 있다.
    - Statement는 매개변수를 동적으로 삽입하는 기능을 제공하지 않는다.
    - 따라서 사용자 입력을 직접 문자열로 연결하여 SQL 문을 구성하기 쉽다.

Statement 인터페이스 사용 예시를 살펴보면 다음과 같다.

```java
statement = connection.createStatement();
ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
```

### PrepareStatement

---

- PrepareStatement 인터페이스는 매개변수화된 SQL 문을 실행할 때 사용된다.
    - 즉, SQL 문에서 직접 값을 삽입하는 대신, `?` (물음표)를 사용하여 매개변수 위치를 지정하고,
    - 이후 해당하는 매개변수에 값을 설정할 수 있다.
- PrepareStatement 객체는 미리 컴파일되고, 매개변수의 값만 바꿔가면서 여러 번 실행될 수 있다.
    - 때문에 반복 실행할 경우, 성능 향상을 가져올 수 있다.
- PrepareStatement 인터페이스는 Statement 인터페이스와 반대로 SQL Injection에 보다 안전하다.
    - 매개변수의 값을 설정할 때 PrepareStatement는 적절한 ESCAPE 처리를 자동으로 수행한다.

PrepareStatement 인터페이스 사용 예시를 살펴보면 다음과 같다.

```java
PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE name = ?"); 
preparedStatement.setString(1, "Alice"); 
ResultSet resultSet = preparedStatement.executeQuery();
```

## 📝🔓 Statement와 PrepareStatement 차이점

---

앞서 살펴보았듯이 Statement 인터페이스를 사용하면, 매번 쿼리를 날릴 때마다 지속적으로 단계를 거치지만,

PrepareStatement 인터페이스는 처음 한 번만 세 단계를 거친 후 **캐시**에 담아서 재사용한다.

결론은 동일한 쿼리를 반복적으로 수행한다고 하면, PrepareStatement가 DB에 적은 부하를 주고 성능도 좋다.