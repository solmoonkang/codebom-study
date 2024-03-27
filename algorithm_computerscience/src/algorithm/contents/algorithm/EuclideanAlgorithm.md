### Euclidean Algorithm, 유클리드 호제법

> **Euclidean Algorithm 이란?**
>

---

두 수의 **‘최대공약수(GCD)’** 를 찾기 위한 알고리즘을 의미한다.

큰 수를 작은 수로 나눠 떨어지게 수를 반복적으로 취하여 나머지가 0이 될 때까지 작동하는 방법을 의미한다.
( 그때, 작은 수가 ‘최대공약수’ 이다. )

<aside>
💡 **호제법이란?**

두 수가 서로 상대방 수를 나누어 결국, 원하는 수를 얻는 알고리즘을 의미한다.

</aside>

### Greatest Common Divisor(GCD) & Least Common Multiple(LCM)

> **Greatest Common Divisor (GCD), 최대공약수 란?**
>

---

두 수의 공통된 **‘약수 중에서 가장 큰 수’** 를 의미한다.

<aside>
💡 **약수 (Divisors) 란?**

어떤 수를 나누어 떨어지게 하는 수를 그 수의 약수라고 한다.
예를 들어, 10의 약수는 1, 2, 5, 10 이다.

</aside>

> **Least Common Multiple (LCM), 최소공배수 란?**
>

---

두 수의 공통된 **‘배수 중에서 가장 작은 수’** 를 의미한다.

<aside>
💡 **배수 (Multiple) 란?**

배수는 어떤 수의 배를 이루는 수를 의미한다.
예를 들어 24는 12의 배수이며, 시간의 배수는 1시간의 2배인 2시간을 말한다.

</aside>

## 두 수의 최대공약수 & 최소공배수 구현하기

### **최대공약수 구현**

> **재귀 방식으로 구현**
>

---

B가 0이라면, A가 최대공약수가 되며, 그렇지 않으면, B와 A % B의 최대공약수를 구한다.
( 이를 재귀적으로 반복하여 최대공약수를 구할 수 있다. )

```java
// 재귀 방식
public static int gcd(int a, int b) {
    if (b == 0) return a;
    return gcd(b, a % b);
}
```

> **반복문 방식으로 구현**
>

---

B가 0이 될 때까지, A를 B로 나눈 나머지를 B에 대입하고, A와 B의 값을 교환한다.
( 이를 반복하여 최대공약수를 구할 수 있다. )

```java
// 반복문 방식
public static int gcd(int a, int b) {
    while (b != 0) {
        int temp = b;
        b = a % b;
        a = temp;
    }
    return a;
}
```

### **최소공배수 구현**

> **최대공약수의 함수를 기반으로 최소공배수를 구현**
>

---

해당 방식은 두 수 A와 B의 최소공배수를 구하는 함수이다.

함수 내부에서는 A와 B의 최대공약수를 이용하여 최소공배수를 계산한다.

최소공배수는 두 수의 곱에 최대공약수를 나눈 값과 같다.

```java
public static int lcm(int a, int b) {
    return a * b / gcd(a, b);
}
```

### 약수와 배수를 구하는 방식

> **약수를 구하는 방식**
>

---

```java
int divisor = 12;                     // 약수를 구할 수

for (int i = 1; i <= divisor; i++) {  // 1부터 divisor까지 반복하여
    if (diviso % i == 0) {            // divisor를 i로 나누어 나머지가 0일 경우,
        System.out.println(i);        // 즉, 약수일 때마다 i를 출력한다.
    }
}
```

> **배수를 구하는 방식**
>

---

```java
int multiple = 3;                      // 배수를 구할 수

for (int i = 1; i <= 10; i++) {        // 1부터 10까지 반복하여
    System.out.println(multiple * i);  // multiple * i(multiple의 배수)를 출력한다.
}
```