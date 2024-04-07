package algorithm.week14;

import java.util.*;

public class 뒤에있는큰수찾기 {

    /**
     * [ 문제 설명 ]
     * 정수로 이루어진 배열 numbers가 있습니다.
     * 배열의 각 원소들에 대해 자신보다 뒤에 있는 숫자 중에서 자신보다 크면서 가장 가까이 있는 수를 뒷 큰수라고 합니다.
     * 정수 배열 numbers가 매개변수로 주어질 때,
     * 모든 원소에 대한 뒷 큰수들을 차례로 담은 배열을 return 하도록 solution 함수를 완성해주세요.
     * 단, 뒷 큰수가 존재하지 않는 원소는 -1을 담습니다.
     */

    /**
     * [ 제한 사항 ]
     * 4 ≤ numbers의 길이 ≤ 1,000,000
     *  - 1 ≤ numbers[i] ≤ 1,000,000
     */
    public int[] solutionBruteForce(int[] numbers) {
        int[] answer = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            answer[i] = -1;
        }

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] < numbers[j]) {
                    answer[i] = numbers[j];
                    break;
                }
            }
        }

        return answer;
    }

    public int[] solutionDeque(int[] numbers) {
        int[] answer = new int[numbers.length];
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < numbers.length; i++) {
            answer[i] = -1;
        }

        for (int i = 0; i < numbers.length; i++) {
            while (!deque.isEmpty() && numbers[deque.peekLast()] < numbers[i]) {
                answer[deque.pollLast()] = numbers[i];
            }
            deque.offerLast(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        뒤에있는큰수찾기 findTheNextGreaterElement = new 뒤에있는큰수찾기();

        System.out.println("===== Brute Force =====");
        int[] firstNumbers = {2, 3, 3, 5};
        System.out.println("findTheNextGreaterElement = " +
                Arrays.toString(findTheNextGreaterElement.solutionBruteForce(firstNumbers)));

        int[] secondNumbers = {9, 1, 5, 3, 6, 2};
        System.out.println("findTheNextGreaterElement = " +
                Arrays.toString(findTheNextGreaterElement.solutionBruteForce(secondNumbers)));


        System.out.println("===== Deque =====");
        System.out.println("findTheNextGreaterElement = " +
                Arrays.toString(findTheNextGreaterElement.solutionDeque(firstNumbers)));

        System.out.println("findTheNextGreaterElement = " +
                Arrays.toString(findTheNextGreaterElement.solutionDeque(secondNumbers)));
    }
}
