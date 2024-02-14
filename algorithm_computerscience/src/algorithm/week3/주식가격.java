package algorithm.week3;

import java.util.*;

public class 주식가격 {

    /**
     * [ 문제 설명 ]
     * 초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때,
     * 가격이 떨어지지 않은 기간은 몇 초인지를 return 하도록 solution 함수를 완성하세요.
     */

    /**
     * [ 제한 사항 ]
     * prices의 각 가격은 1 이상 10,000 이하인 자연수입니다.
     * prices의 길이는 2 이상 100,000 이하입니다.
     */

    /**
     * [ 문제 풀이 흐름 ]
     * 1. 우선, prices의 길이만큼의 결과 배열을 선언합니다. 이 배열은 각 주식 가격이 떨어지지 않은 기간을 저장할 것입니다.
     * 2. 덱을 선언하고, prices의 첫 번째 인덱스를 덱에 넣습니다.
     * 3. prices의 두 번째 인덱스부터 순회를 시작합니다.
     *  현재 가격이 덱의 마지막 인덱스에 위치한 가격보다 크거나 같다면, 덱에 현재 인덱스를 추가합니다.
     *  현재 가격이 덱의 마지막 인덱스에 위치한 가격보다 작다면, 가격이 떨어진 것이므로 덱에서 값을 빼고, 결과 배열에 현재 인덱스 - 덱에서 뺀 값의 인덱스를 저장합니다. 이 과정을 현재 가격이 덱의 마지막 인덱스에 위치한 가격보다 크거나 같아질 때까지 반복합니다.
     * 4. 마지막으로, 덱에 남아 있는 인덱스에 대해, prices의 길이 - 1 - 덱에서 뺀 값의 인덱스를 결과 배열에 저장합니다.
     * 5. 결과 배열을 반환합니다.
     */
    public int[] solution(int[] prices) {
        // TODO: 나중에 다시 한 번 풀어보자.
        int period = prices.length;

        Deque<Integer> stockPrice = new LinkedList<>();
        int[] answer = new int[period];

        for (int i = 0; i < period; i++) {
            while (!stockPrice.isEmpty() && prices[i] < prices[stockPrice.peekLast()]) {
                int current = stockPrice.pollLast();
                answer[current] = i - current;
            }
            stockPrice.offerLast(i);
        }

        while (!stockPrice.isEmpty()) {
            int current = stockPrice.pollLast();
            answer[current] = period - current - 1;
        }
        return answer;
    }

    public static void main(String[] args) {
        주식가격 stockPrice = new 주식가격();
        int[] prices = {1, 2, 3, 2, 3};
        System.out.println("Result: " + Arrays.toString(stockPrice.solution(prices)));
    }
}
