## ➕ JOIN 이란?

---

관계형 데이터베이스에서 정규화를 수행하면, 데이터의 집합으로 테이블이 구성되고, 각 테이블은 관계를 갖는다.

때문에 관계형 데이터베이스는 시간 단축, 관리 용이, 그리고 확장성을 향상시킬 수 있게 된다.

반대로, 서로 관계있는 데이터가 여러 테이블들로 나뉘어 저장되어 있다는 말이다.

- 때문에 각 테이블에 저장된 데이터를 효과적으로 검색하기 위해서는 **“JOIN(조인) 연산자”**가 필요하다.

<aside>
📌 **JOIN이란 두 개 이상의 테이블을 연결하여 하나의 결과 테이블을 만드는 것을 의미한다.**

</aside>

## 4️⃣ JOIN 종류

---

**JOIN** 문의 종류로는 다음과 같이 ***INNER JOIN, OUTER JOIN, CROSS JOIN, SELF JOIN*** 등이 있다.

다음은 **JOIN** 문을 진행하기 전 예시 테이블이다.

**EMPLOYEE**

---

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/c33fee58-8f40-4523-b222-c56099de30a9/923eb375-c742-4e20-8948-1bd44894305e/Untitled.png)

**DEPARTMENT**

---

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/c33fee58-8f40-4523-b222-c56099de30a9/d59940a5-1bbf-4438-97bf-eddd524c7eee/Untitled.png)

### *INNER JOIN, 내부 조인*

---

**INNER JOINI(내부 조인)**은 두 개 이상의 테이블에서 조건이 일치하는 행들을 결합하여 결과를 반환한다.

**INNER JOINI(내부 조인)**의 특징은 다음과 같다.

- **조건 일치**: 두 테이블 간 조인 조건에 따라 일치하는 데이터만을 선택한다.
- **데이터 손실**: 조인 조건에 맞지 않는 행을 제외되어 어느 한 테이블에만 존재하는 데이터는 포함되지 않는다.
- **효율적인 데이터 검색**: 관련 데이터만을 결합하여 조회해서 특정 조건에 따른 분석이나 검색이 효율적이다.

내부 조인은 **“명시적 조인 표현”**과 **“암시적 조인 표현”**으로 2개의 조인 구문으로 나뉘고 사용 방식은 다음과 같다.

**[ 명시적 조인 표현 ]**

```sql
SELECT * 
FROM employee 
INNER JOIN department 
ON employee.DepartmentID = department.DepartmentID;
```

---

명시적 조인 표현은 위 코드와 같이 조인을 지정하기 위해 **JOIN** 문과 **ON** 문을 통해 사용한다.

**[ 암시적 조인 표현 ]**

```sql
SELECT * 
FROM employee, department 
WHERE employee.DepartmentID = department.DepartmentID;
```

---

암시적 조인 표현은 **FROM** 절에서 `,` 콤마를 사용해서 단순히 조인을 위한 테이블들을 나열하기만 한다.

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/c33fee58-8f40-4523-b222-c56099de30a9/44897d42-a6e0-493e-a4d8-f6d84dea5cd4/Untitled.png)

---

다음은 **INNER JOIN(내부 조인)**의 일종인 **EQUI(동등)**과 **NATURAL(자연) JOIN**에 대해 살펴보자.

**[ EQUI JOIN, 동등 조인 ]**

---

**EQUI JOIN(동등 조인)**은 두 테이블에서 하나 이상의 열에서 값이 동일한 행을 결합하는 조인 방식이다.

- 이때, 조인 조건은 “동등성, `=`”을 기준으로 사용한다.

동등 조인은 조건에 `=` 동등 연산자만 사용하며,

`<,` `>` 와 같은 다른 비교 연산자를 사용하는 것은 동등 조인으로서의 조인 자격을 박탈하는 것이다.

때문에 동등 조인을 사용하면, 특정 열의 값이 서로 일치하는 행만 결합되어, 두 테이블 간 관계가 명확하다.

**[ NATURAL JOIN, 자연 조인 ]**

---

**NATURAL JOIN(자연 조인)**은 두 테이블 간 동일한 이름을 가진 모든 열에 대해 동등 조인을 자동으로 수행하는 조인 방식이다.

- 명시적으로 조인을 기술할 필요 없이, 두 테이블에서 이름이 같은 모든 열을 기준으로 조인이 이루어진다.

자연 조인은 동일한 이름의 열이 여러 개 있을 경우 모든 열에 대해 동등 조인을 적용하기 때문에, 주의가 필요하다.

결과적으로, 두 테이블에서 중복되는 열 이름이 자동으로 조인의 기준이 되고, 사용 방식은 다음과 같다.

```sql
SELECT * FROM employee NATURAL JOIN department;
```

---

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/c33fee58-8f40-4523-b222-c56099de30a9/43d14895-7475-4014-878f-67898b249ce9/Untitled.png)

---

**EQUI JOIN(동등 조인)**과 **NATURAL JOIN(자연 조인)** 두 조인 방식 모두 DB에서 흔하게 사용되며,

데이터를 관계적으로 연결하여 보다 의미 있는 정보를 추출하는 데 큰 역할을 한다.

### *OUTER JOIN, 외부 조인*

---

**OUTER JOIN(외부 조인)**은 두 테이블을 조인할 때, 조인 조건에 맞는 행 뿐만 아닌,

한쪽 테이블에 일치하는 행이 없는 경우에도 해당 테이블의 행을 결과에 포함시키는 조인 방식이다.

- 이를 통해 두 테이블 간의 관계를 보다 포괄적으로 파악할 수 있다.
- 외부 조인에는 **LFET(좌측 외부 조인)**, **RIGHT(우측 외부 조인)**, **FULL(전체 외부 조인)** 세 종류가 있다.

**[ LEFT OUTER JOIN, 좌측 외부 조인 ]**

---

**LEFT OUTER JOIN(좌측 외부 조인)**은 두 테이블 중 왼쪽 테이블의 모든 행과 오른쪽 테이블에서 조인 조건에 일치하는 행을 결합한다.

- 만약, 오른쪽 테이블에 일치하는 행이 없을 경우, 왼쪽 테이블의 행은 결과에 포함되며,
- 오른쪽 테이블의 해당 열은 *`NULL`* 값으로 채워진다.

**LEFT OUTER JOIN(좌측 외부 조인)**의 사용 방식은 다음과 같다.

```sql
SELECT *
FROM employee LEFT OUTER JOIN department
ON employee.DepartmentID = department.DepartmentID;
```

---

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/c33fee58-8f40-4523-b222-c56099de30a9/eed92d45-f957-4dc6-b8d6-2c262068e26b/Untitled.png)

**[ RIGHT OUTER JOIN, 우측 외부 조인 ]**

---

**RIGHT OUTER JOIN(우측 외부 조인)**은 좌측 외부 조인의 반대로,

두 테이블 중 오른쪽 테이블의 모든 행과 왼쪽 테이블에서 조인 조건에 일치하는 행을 결합한다.

- 만약, 왼쪽 테이블에 일치하는 행이 없는 경우, 오른쪽 테이블의 행은 결과에 포함되고,
- 왼쪽 테이블의 해당 열은 *`NULL`* 값으로 채워진다.

**RIGHT OUTER JOIN(우측 외부 조인)**의 사용 방식은 다음과 같다.

```sql
SELECT *
FROM employee RIGHT OUTER JOIN department
ON employee.DepartmentID = department.DepartmentID;
```

---

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/c33fee58-8f40-4523-b222-c56099de30a9/8457531b-a6b3-4699-9674-72da722da162/Untitled.png)

**[ FULL OUTER JOIN, 전체 외부 조인 ]**

---

**FULL OUTER JOIN(전체 외부 조인)**은 두 테이블의 모든 행을 결합하며, 한쪽 테이블에만 존재하는 행도 결과에 포함된다.

- 양쪽 테이블에서 조인 조건에 일치하지 않은 행은 *`NULL`* 값을 채워진 열과 함께 결과에 포함된다.

**FULL OUTER JOIN(전체 외부 조인)**의 사용 방식은 다음과 같다.

```sql
SELECT *
FROM employee FULL OUTER JOIN department
ON employee.DepartmentID = department.DepartmentID;
```

---

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/c33fee58-8f40-4523-b222-c56099de30a9/9d7b9c6b-753a-4f11-8e98-daa01f34a64a/Untitled.png)

### *CROSS JOIN, 교차 조인*

---

**CROSS JOIN(교차 조인)**은 두 테이블 간의 모든 가능한 조합을 생성하는 조인 방식이다.

- 다른 조인 방식과 달리, 교차 조인은 조인 조건을 사용하지 않는다.
- 대신, 첫 번째 테이블의 각 행은 두 번째 테이블의 모든 행과 조합된다.
    - 때문에, 결과 집합의 크기는 두 테이블의 행 수를 곱한 것과 같다.
    - 예를 들어, M행을 가진 테이블과 N행을 가진 테이블이 교차 조인되면, M*N 개의 행을 생성한다.

**CROSS JOIN(교차 조인)**의 기본 구문은 다음과 같이 사용할 수 있다.

**[ 명시적 조인 표현 ]**

```sql
SELECT * FROM employee CROSS JOIN department;
```

---

또는 명시적 조인 조건 없이 FROM 절에서 여러 테이블을 `,` 쉼표로 구분하여 나열하는 방식으로 사용할 수 있다.

**[ 암시적 조인 표현 ]**

```sql
SELECT * FROM employee, department;
```

---

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/c33fee58-8f40-4523-b222-c56099de30a9/1645b166-c12e-419d-975f-8675f1032ab0/Untitled.png)

### *SELF JOIN, 셀프(자체) 조인*

---

**SELF JOIN(셀프 조인)**은 테이블이 자기 자신과 조인되는 경우를 의미한다.

- 해당 방식은 테이블 내에서 관련된 행들 사이의 관계를 찾을 때 사용된다.

**SELF JOIN(셀프 조인)**은 명시적으로 지원되는 특별한 조인은 아니지만,
**INNER JOIN(내부 조인)**, **OUTER JOIN(외부 조인)** 등을 사용해 테이블을 자신과 조인하도록 구현할 수 있다.

- 예를 들어, 직원 테이블에서 각 지원의 상사를 찾거나, 같은 카테고리 상품들을 찾는 경우에 사용한다.

**SELF JOIN(셀프 조인)**을 구현할 때는 동일한 테이블을 참조하기 위해 별칭을 사용한다.

- 이렇게 하면, 쿼리에서 동일 테이블의 서로 다른 행들을 마치 두 개의 별도 테이블처럼 참조할 수 있다.

```sql
SELECT E.Name AS '직원 이름', D.DepartmentName AS '부서 이름'
FROM EMPLOYEE E
JOIN DEPARTMENT D ON E.DepartmentID = D.DepartmentID;
```

---

**SELF JOIN(셀프 조인)**은 테이블 내에서 관련 있는 데이터를 연결하여 보다 복잡한 관계나 구조를 쉽게 조회할 수 있게 해준다.

## ⚠️ 조인 사용 시 주의사항

---

조인을 사용할 때는 여러 가지 주의사항이 존재하는데, 다음과 같다.

1. **조인 조건의 명확성**: 조인 조건이 모호하거나 잘못 지정되면 예상하지 못한 결과가 나올 수 있다.

1. **데이터 무결성**: 잘못된 조인 조건은 데이터의 정확성을 해쳐서, 데이터의 무결성을 유지하는 것이 중요하다.

1. **성능 저하**: 큰 테이블을 조인할 때는 성능 저하가 발생할 수 있으므로 주의해야 한다.

1. **ON 절과 WHERE 절의 차이**: 외부 조인 사용 시 ON 절과 WHERE 절의 차이를 명확히 이해해야 한다.
    1. **ON 절**은 조인 조건을 지정하는 데 사용되며,
    2. **WHERE 절**은 조인된 결과에서 특정 조건에 맞는 행을 필터링하는 데 사용된다.

## 💭 조인 사용 시 고려사항

---

다음은 조인을 사용할 때 고려해야 할 사항들로 다음과 같은 것들이 있다.

1. **조인 타입 선택**: 각 조인 타입에 따라 결과에 영향을 미치기 때문에 내부 조인, 외부 조인, 교차 조인 등 상황에 맞는 조인 타입을 선택해야 한다.

1. **인덱스 활용**: 조인에 사용되는 컬럼에 인덱스가 있다면, 조회 성능이 크게 향상된다.
    - 특히, 대용량 데이터를 다룰 때는 인덱스 유무로 인해 성능에 큰 차이를 만든다.

1. **필요한 데이터만 조인**: 가능한 적은 수의 행과 컬럼을 조인하는 것이 성능상의 이점이 있다.

1. **서브쿼리와의 비교**: 상황에 따라 조인 대신 서브쿼리를 사용하는 것이 더 효율적일 수 있다.

1. **조인 순서**: 여러 테이블을 조인할 때는 조인 순서를 고려하는 것이 좋다.
    - 일반적으로 먼저 필터링되어 행의 수가 줄어든 테이블을 기준으로 조인하는 것이 성능에 유리하다.