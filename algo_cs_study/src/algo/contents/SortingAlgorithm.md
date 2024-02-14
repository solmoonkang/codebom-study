# *Sorting Algorithm*, 정렬 알고리즘

## *Sorting*, 정렬이란?

---

*`Sorting*, 정렬`이란 데이터를 특정한 기준에 따라서 순서대로 나열하는 것을 의미한다.

*`Sorting*, 정렬` 알고리즘을 통해 데이터를 정렬하면 *`Binary Search*, 이진 탐색`이 가능해진다.

**[ 정렬 알고리즘의 종류 ]**

---

- *`Quick Sort*(퀵 정렬)`: 분할 정복 방식을 이용하여 배열을 빠르게 정렬한다.
    - *`Arrays.sort( )`*: 퀵 정렬을 사용해 배열을 정렬하며, 기본 타입, 객체 타입 배열 모두 사용 가능하다.
    - *`Collection.sort( )`*: 퀵 정렬을 사용해 객체를 정렬하며, *`List`, `Set`, `Que`* 등의 *Collection Framework* 사용이 가능하다.
- `*Bubble Sort*(버블 정렬)`: 인접한 두 원소를 비교하여 큰 값을 오른쪽으로 이동시켜 정렬한다.
- `*Selection Sort*(선택 정렬)`: 주어진 배열에서 최소값을 찾아 맨 앞 원소와 교환하며 정렬한다.
- `*Insertion Sort*(삽입 정렬)`: 정렬된 부분집합 내에서 자신이 들어갈 위치를 찾아 삽입하며 정렬한다.
- `*Merge Sort*(병합 정렬)`: 분할 정복 방식을 이용하여 배열을 정렬한다.
- `*Heap Sort*(힙 정렬)`: 힙 자료구조를 이용하여 정렬한다.
- `*Radix Sort*(기수 정렬)`: 각 자리의 숫자를 비교하여 정렬한다.

<aside>
📌 위에 나열한 정렬 알고리즘 순서대로 시간 복잡도가 빠른 순으로 정렬되어 있다.

*Radix Sort* → *Quick Sort* 순으로 속도가 빠르다.

</aside>

### 정렬 알고리즘의 특징

---

| 특징 | 설명 |
| --- | --- |
| 시간 복잡도 | 일부 알고리즘은 작은 데이터 집합에 대해 빠르지만, 큰 데이터 집합에 대해 느릴 수 있다.
따라서, 알고리즘의 시간 복잡도를 고려하여 적절한 정렬 알고리즘을 선택해야 한다. |
| 안정성 | 정렬 알고리즘은 동일한 값의 순서가 바뀌지 않는다는 안정적인 특징을 가지고 있다.
이는 동일한 값을 가진 요소들의 순서가 변하지 않도록 보장한다. |
| 추가 메모리 사용 | 몇몇 정렬 알고리즘은 추가적인 메모리 공간을 필요로 한다.
따라서, 정렬 알고리즘을 선택할 때 고려해야 할 요소 중 하나이다. |
| 알고리즘 복잡성 | 몇몇 정렬 알고리즘은 간단하지만, 다른 알고리즘은 이해와 구현의 어려움이 있어 복잡성이 존재한다. |

## *Quick Sort*, 퀵 정렬이란?

---

퀵 정렬은 분할 정복(*Divide and Conquer*) 방법을 사용하여 구현된 정렬 알고리즘이다.

- 분할 정복(*Divide and Conquer*): 큰 문제를 작은 문제로 나누어서 해결하는 알고리즘이다.
    - 분할 정복은 ‘분할 → 정복 → 결합’ 단계를 거쳐서 처리된다.
        1. 분할 단계에서는 문제를 작은 부분 문제들로 나누는 단계이다.
        2. 정복 단계에서는 부분 문제들을 해결하는 단계이다.
        3. 결합 단계에서는 부분 문제들의 해(*Solution*)들을 모아 원래의 문제 해를 구하는 단계이다.

퀵 정렬은 대규모 데이터를 정렬하는 데 매우 유용하며, 많은 프로그래밍 언어에서도 내장 정렬 함수로 이용한다.

### *Quick Sort* 동작 방식

---

퀵 정렬에서 분할 정복 방법을 사용하여 구현되기 때문에, 배열을 분할하고 분할된 부분 배열을 재귀적으로 정렬을 수행하는 방식으로 동작한다.

- 합병 정렬과 속도가 비슷하고 힙 정렬보다 빠르지만, 최악의 경우 *O(n$^2$)* 만큼 걸린다.
- 보통 재귀로 구현하기 때문에, 메모리를 더 사용할 수 있다는 단점이 있다.

1. 배열에서 하나의 요소를 기준으로 선택한다.
    - 여기서 선택한 요소를 *Pivot*(피벗)이라고 한다.
2. *Pivot*을 기준으로 작은 요소는 *Pivot*의 왼쪽으로, 큰 요소는 *Pivot*의 오른쪽으로 분할한다.
3. 분할된 두 개의 하위 배열에 대해서 재귀적으로 위의 과정들을 반복한다.
4. 하위 배열이 더 이상 분할되지 않으면, 정렬이 완료된다.

**[ 퀵 정렬 코드 및 설명 ]**

---

```java
public static void sortByQuickSort(int[] arr) {
    quickSort(arr, 0, arr.length - 1);
}
public static void quickSort(int[] arr, int left, int right) {
    int part = partition(arr, left, right);
    if (left < part - 1) {
        quickSort(arr, left, part - 1);
    }
    if (part < right) {
        quickSort(arr, part, right);
    }
}
public static int partition(int[] arr, int left, int right) {
    int pivot = arr[(left + right) / 2];
    while (left <= right) {
        while (arr[left] < pivot) {
            left++;
        }
        while (arr[right] > pivot) {
            right--;
        }
        if (left <= right) {
            swap(arr, left, right);
            left++;
            right--;
        }
    }
    return left;
}
```

---

*`left`* 는 부분 배열의 첫 번째 인덱스를, *`right`* 는 부분 배열의 마지막 인덱스이다.

*`pivot`* 은 그 중간의 원소 값을 사용한다.

1. *`partition( )`* 에서 *`left`* 의 원소 값이 *`pivot`* 보다 클 때까지 증가시키면서 찾는다.
2. *`right`* 의 원소 값이 *`pivot`* 보다 작을 때까지 감소시키면서 찾는다.
3. 만약, 둘 다 찾았으면 두 원소를 교환한다.
4. 위 과정을 반복하다 보면 자연스럽게 *`pivot`* 좌측에는 더 작은 값들이 우측에는 더 큰 값들이 위치한다.
5. 반복이 끝나면 *`pivot`* 의 위치인 *`left`* 를 반환한다.
6. 그럼 전달받은 *`pivot`* 은 알맞은 위치에 특정되고, 다시 *`pivot`* 을 기준으로 좌측, 우측 부분집합으로 나누어서 재귀 호출한다.

## *Arrays.sort(), Collections.sort( )* 퀵 정렬 종류: 일반 정렬이란?

### *Arrays.sort( )* 이란?

---

퀵 정렬을 사용해 배열을 정렬하며, 기본 타입 배열과 객체 타입 배열 모두에 대해서 사용할 수 있다.

### *Collection.sort( )* 이란?

---

퀵 정렬을 사용해 객체를 정렬하며, *List, Set, Queue* 등의 *Collection Framework* 에 대해서 사용할 수 있다.

## *Bubble Sort*, 버블 정렬이란?

---

버블 정렬은 인접한 두 원소를 비교하여 필요한 경우 위치를 교환하여 배열을 정렬하는 알고리즘이다.

- 버블 정렬은 정렬할 원소의 개수가 적거나, 정렬할 원소의 개수가 많아도 이미 정렬된 상태에서 사용한다.

버블 정렬은 대부분의 다른 정렬 알고리즘들보다 느리고 비효율적이기 때문에, 실제 사용은 거의 드물다.

- 비교와 교환이 모두 일어날 수 있기 때문에 코드는 단순하지만 성능은 좋지 않다.
- 또한 최선, 평균, 최악의 경우 모두 *O(n$^2$)* 만큼 걸린다.

### *Bubble Sort* 동작 방식

---

1. 배열의 첫 번째 요소부터 인접한 요소와 비교한다.
2. 만약, 인접한 요소의 순서가 잘못되어 있다면 위치를 교환한다.
3. 배열의 끝까지 이동하면서 위의 과정들을 반복한다.
4. 한 번 반복이 끝나면, 가장 큰 요소가 배열의 마지막으로 이동한다.
5. 위의 과정들을 배열이 정렬될 때까지 반복한다.

**[ 버블 정렬 코드 및 설명 ]**

---

```java
public static void sortByBubbleSort(int[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
        for (int j = 0; j < arr.length - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                swap(arr, j, j + 1);
            }
        }
    }
}
```

---

첫 번째 for 문의 *`i`* 는 두 번째 for 문의 *`j`* 가 *`0 ~ (n - 2) → 0 ~ (n - 3) → … → 0`* 과 같이 반복하도록 하기 위함이다.

*`j`* 가 처음에 *`0 ~ (n - 2)`* 까지 반복하는 이유는 *`j`* 의 원소와 *`j + 1`* 의 원소를 비교하기 때문에, *`n - 2`* 까지 for 문을 돌면서 뒤에 있는 원소가 더 작으면 *`swap( )`* 하게 된다.

## *Selection Sort*, 선택 정렬이란?

---

선택 정렬은 주어진 배열에서 최소값을 찾아 맨 앞 원소와 바꾸고 그 다음 작은 원소를 찾아 두 번째 원소와 자리를 바꾸는 식으로 정렬하는 알고리즘이다.

- 선택 정렬은 정렬할 원소의 개수가 적거나, 이미 거의 정렬된 상태에서 사용한다.

선택 정렬은 대부분의 다른 정렬 알고리즘보다 느리고 비효율적이기 때문에, 실제 사용은 거의 드물다.

- 교환 횟수는 O(n) 으로 적지만, 비교는 모두 진행되며 버블 정렬보다는 성능이 좋다.
- 또한 최선, 평균, 최악의 경우 모두 *O(n$^2$)* 만큼 걸린다.

### *Selection Sort* 동작 방식

---

1. 배열에서 가장 작은 요소(최소값)를 찾는다.
2. 가장 작은 요소와 배열의 첫 번째 요소와 교환한다.
3. 두 번째로 작은 요소를 찾아서 배열의 두 번째 요소와 교환한다.
4. 위의 과정들을 배열의 끝까지 반복한다.

**[  정렬 코드 및 설명 ]**

---

```java
public static void sortBySelectionSort(int[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
        int minIdx = i;
        for (int j = i + 1; j < arr.length; j++) {
            if (arr[j] < arr[minIdx]) {
                minIdx = j;
            }
        }
        swap(arr, i, minIdx);
    }
}
```

---

1. 인덱스 *`0 ~ (n - 1)`* 을 돌면서 원소의 값이 가장 작은 인덱스를 찾는다.
2. 인덱스 0과 가장 작은 인덱스의 원소를 *`swap( )`* 한다.
3. 다시 인덱스 *`1 ~ (n - 1)`* 을 돌면서 원소의 값이 가장 작은 인덱스를 찾는다.
4. 인덱스 1과 가장 작은 인덱스의 원소를 *`swap( )`* 한다.
5. 위의 과정들을 반복한다.

## *Insertion Sort*, 삽입 정렬이란?

---

삽입 정렬은 정렬되지 않은 부분에서 값을 선택하고, 해당 값을 이미 정렬된 부분의 올바른 위치에 삽입하는 알고리즘이다.

- 이를 통해 정렬되지 않은 부분들은 점차적으로 감소하고 배열 전체가 정렬되게 된다.
- 정렬이 되어 있는 배열의 경우 *O(n)* 의 속도로 정렬되어 있을수록 성능이 좋다.

### *Insertion Sort* 동작 방식

---

1. 배열의 두 번째 요소부터 시작한다.
2. 현재 위치의 요소를 기준으로, 이전 위치의 요소들과 비교한다.
3. 이전 위치의 요소가 현재 위치의 요소보다 크다면, 이전 위치의 요소를 현재 위치로 이동시킨다.
4. 이전 위치의 요소가 현재 위치의 요소보다 작거나 같다면, 정렬이 완료된 것으로 간주하고 다음 요소로 이동한다.
5. 배열의 시작에 도달할 때까지 반복한다.

**[  정렬 코드 및 설명 ]**

---

```java
public static void sortByInsertionSort(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
        int tmp = arr[i];
        int j = i - 1;
        while (j >= 0 && tmp < arr[j]) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = tmp;
    }
}
```

---

1. 인덱스 *`1 ~ (n - 1)`* 의 원소들을 순차적으로 자신이 들어갈 위치에 넣는다.
2. *while* 문을 사용하여 더 작으면 계속 앞으로 전진시키면서 비교한 원소를 한 칸씩 뒤로 밀어낸다.
3. 그러다 들어갈 자리가 정해지면 넣어준다.

## *Merge Sort*, 병합 정렬이란?

---

병합 정렬은 배열을 반으로 나누어 각각 정렬한 후, 병합하는 과정을 통해 전체 배열을 정렬하는 알고리즘이다.

1. 배열을 반으로 나누어 각각을 재귀적으로 정렬한다.
2. 그리고 정렬된 두 개의 배열을 병합하는 단계에서 작은 값을 선택하여 새로운 배열에 차례로 배치한다.
3. 이 과정을 반복하면서 전체 배열이 정렬하게 된다.
    - 시간 복잡도가 *O(Nlog N)* 으로 빠르지만, 아래 코드를 보면 *`tmpArr`* 를 사용해야되서 제자리 정렬보다 *O(n)* 만큼 추가적인 메모리가 사용되는 단점이 있다.
    - 보통은 재귀함수로 구현하므로 이것 또한 많은 메모리를 사용하게 된다.

### *Merge Sort* 동작 방식

---

1. 배열을 반으로 나눈다.
2. 각 배열의 반쪽을 재귀적으로 정렬한다.
3. 정렬된 두 개의 반쪽을 병합하여 하나의 정렬된 배열로 합친다.

**[  정렬 코드 및 설명 ]**

---

```java
public static void sortByMergeSort(int[] arr) {
    int[] tmpArr = new int[arr.length];
    mergeSort(arr, tmpArr, 0, arr.length - 1);
}
public static void mergeSort(int[] arr, int[] tmpArr, int left, int right) {
    if (left < right) {
        int m = left + (right - left) / 2;
        mergeSort(arr, tmpArr, left, m);
        mergeSort(arr, tmpArr, m + 1, right);
        merge(arr, tmpArr, left, m, right);
    }
}
public static void merge(int[] arr, int[] tmpArr, int left, int mid, int right) {
    for (int i = left; i <= right; i++) {
        tmpArr[i] = arr[i];
    }
    int part1 = left;
    int part2 = mid + 1;
    int index = left;
    while (part1 <= mid && part2 <= right) {
        if (tmpArr[part1] <= tmpArr[part2]) {
            arr[index] = tmpArr[part1];
            part1++;
        } else {
            arr[index] = tmpArr[part2];
            part2++;
        }
        index++;
    }
    for (int i = 0; i <= mid - part1; i++) {
        arr[index + i] = tmpArr[part1 + i];
    }
}
```

---

재귀를 수행하는 부분인 *`mergeSort( )`* 와 재귀를 마치고 합병하는 부분인 *`merge( )`* 로 구성된다.

1. *`mergeSort( )`* 는 반으로 나누면서 재귀호출을 하고, 다 나눴으면 점점 올라오면서 *`merge( )`* 한다.
2. *`merge( )`* 는 두 부분 배열의 인덱스를 점차적으로 비교하면서 정렬한다.
    1. while 문이 끝나고 배열의 좌측 부분 배열에 남은 것만 저장하는 이유는 다음과 같다.
        - 우측 부분 배열이 다 들어가고, 좌측 부분 배열만 남은 경우 좌측 부분 배열만 넣으면 된다.
        - 좌측 부분 배열이 다 들어가고, 우측 부분 배열만 남은 경우 이미 배열은 다 정렬된 것이다.

## *Heap Sort*, 힙 정렬이란?

---

힙 정렬은 주어진 배열을 힙 자료구조로 만들고, 가장 큰 값을 배열의 가장 마지막으로 보내는 방식으로 정렬하는 알고리즘이다.

- 힙 정렬은 안정적인 정렬 알고리즘이며, 평균적으로 다른 정렬 알고리즘에 비해 빠른 실행 시간을 가지는 특징이 있다.
- 그러나 추가적인 메모리 공간이 필요하다는 단점이 있다.
- 시간 복잡도가 O(Nlog N) 으로 합병 정렬, 퀵 정렬과 동일하지만 사실상 성능은 더 낮다.
    - 매번 루트에서 최대 값을 빼고 *`heapify( )`* 를 사용해 다시 최대힙으로 만들어야하기 때문이다.

### *Heap Sort* 동작 방식

---

1. 주어진 배열을 최대 힙으로 구성한다.
2. 최대 힙에서 가장 큰 요소(루트)를 가져와서 배열의 맨 끝으로 이동시킨다.
3. 배열의 크기를 줄이고, 남은 요소들을 다시 최대 힙으로 구성한다.
4. 위의 과정을 반복하여 정렬이 완료될 때까지 반복한다.

**[  정렬 코드 및 설명 ]**

---

```java
public static void sortByHeapSort(int[] arr) {
    for (int i = arr.length / 2 - 1; i < arr.length; i++) {
        heapify(arr, i, arr.length - 1);
    }
    for (int i = arr.length - 1; i >= 0; i--) {
        swap(arr, 0, i);
        heapify(arr, 0, i - 1);
    }
}
public static void heapify(int[] arr, int parentIdx, int lastIdx) {
    int leftChildIdx;
    int rightChildIdx;
    int largestIdx;
    while (parentIdx * 2 + 1 <= lastIdx) {
        leftChildIdx = (parentIdx * 2) + 1;
        rightChildIdx = (parentIdx * 2) + 2;
        largestIdx = parentIdx;
        if (arr[leftChildIdx] > arr[largestIdx]) {
            largestIdx = leftChildIdx;
        }
        if (rightChildIdx <= lastIdx && arr[rightChildIdx] > arr[largestIdx]) {
            largestIdx = rightChildIdx;
        }
        if (largestIdx != parentIdx) {
            swap(arr, parentIdx, largestIdx);
            parentIdx = largestIdx;
        } else {
            break;
        }
    }
}
```

---

*`heapify( )`* 부터 설명하면 배열, *parentIdx, lastIdx* 가 주어지면, *parentIdx* 를 알맞은 자리에 들어가게 하여 최대 힙을 만들어주는 함수이다.

즉, 부모 노드를 왼쪽 자식, 오른쪽 자식 중 존재하거나 더 큰 것과 비교하여 *`swap( )`* 을 하여 알맞은 자리로 보내주는 것이다.

1. 배열을 최대 힙으로 만든다.
2. 배열의 0번째 인덱스 원소(즉, 가장 큰 수)를 마지막 인덱스와 교환한다.
3. 0번째 인덱스를 자기 자리로 보내주기 위해 *`heapify( )`* 를 사용한다.
4. 위의 과정을 반복하고, 반복하면서 마지막 인덱스를 1씩 감소시킨다.

## *Radix Sort*, 기수 정렬

---

기수 정렬은 비교 연산을 사용하지 않고, 자릿수별로 정렬하는 알고리즘이다.

- 정렬할 숫자들을 가장 낮은 자릿수부터 가장 높은 자릿수까지 반복적으로 처리한다.
- 각 자릿수별로 숫자 그룹을 나누고, 해당 그룹 내에서 정렬을 수행한다.
- 이 과정에서 가장 높은 자릿수까지 반복하면 전체 숫자들이 정렬되게 된다.

### *Radix Sort* 동작 방식

---

1. 정렬할 요소들을 가장 낮은 자릿수부터 가장 높은 자릿수까지 반복적으로 정렬한다.
2. 각 자릿수에 대해 요소들을 해당 자릿수의 값에 따라 그룹화한다.
3. 그룹화된 요소들을 순서대로 다시 배열한다.
4. 위의 과정을 가장 높은 자릿수까지 반복하여 정렬이 완료될 때까지 진행한다.