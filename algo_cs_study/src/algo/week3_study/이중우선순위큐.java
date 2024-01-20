package algo.week3_study;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class 이중우선순위큐 {

    /**
     * [ 문제 설명 ]
     * 이중 우선순위 큐는 다음 연산을 할 수 있는 자료구조를 말합니다.
     * I 숫자	큐에 주어진 숫자를 삽입합니다.
     * D  1   	큐에서 최댓값을 삭제합니다.
     * D -1	    큐에서 최솟값을 삭제합니다.
     * 이중 우선순위 큐가 할 연산 operations가 매개변수로 주어질 때,
     * 모든 연산을 처리한 후 큐가 비어있으면 [0,0] 비어있지 않으면 [최댓값, 최솟값]을 return 하도록 solution 함수를 구현해주세요.
     */

    /**
     * [ 제한 사항 ]
     * operations는 길이가 1 이상 1,000,000 이하인 문자열 배열입니다.
     * operations의 원소는 큐가 수행할 연산을 나타냅니다.
     * 원소는 “명령어 데이터” 형식으로 주어집니다.- 최댓값/최솟값을 삭제하는 연산에서 최댓값/최솟값이 둘 이상인 경우, 하나만 삭제합니다.
     * 빈 큐에 데이터를 삭제하라는 연산이 주어질 경우, 해당 연산은 무시합니다.
     */

    /**
     * [ 문제 풀이 흐름 ]
     * 1. 우선, PriorityQueue 두 개를 생성합니다. 하나는 최대힙으로, 다른 하나는 최소힙으로 설정합니다. ⭕️
     *  이는 자바의 PriorityQueue가 기본적으로 최소힙으로 동작하기 때문에, 최대힙을 생성하려면 Comparator를 통해 설정해야 합니다.
     * 2. 주어진 연산들을 반복문을 통해 하나씩 처리합니다. ⭕️
     *  이때, "I" 연산일 경우 두 개의 힙에 모두 값을 추가합니다. "D" 연산일 경우, 해당 힙에서 값을 제거합니다.
     * 3. "D" 연산 후에는 두 힙이 동기화되어있는지 확인합니다. ⭕️
     *  만약 두 힙의 최대값과 최소값이 일치하지 않는다면, 두 힙 모두에서 해당 값을 제거하여 동기화를 유지합니다.
     * 4. 모든 연산을 처리한 후, 힙이 비어있는지 확인합니다. ⭕️
     *  비어있다면 [0,0]을 반환하고, 그렇지 않다면 최대힙의 root와 최소힙의 root를 반환합니다. 이 두 값이 각각 최대값과 최소값이 됩니다.
     */
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (String operation : operations) {
            String[] splitOperation = operation.split(" ");
            String command = splitOperation[0];
            int value = Integer.parseInt(splitOperation[1]);

            if (command.equals("I")) {
                minHeap.add(value);
                maxHeap.add(value);
            } else if (command.equals("D")) {
                if (!minHeap.isEmpty() && !maxHeap.isEmpty()) {
                    if (value == 1) {
                        int max = maxHeap.poll();
                        minHeap.remove(max);
                    } else if (value == -1) {
                        int min = minHeap.poll();
                        maxHeap.remove(min);
                    }
                }
            }
        }
        if (minHeap.isEmpty() && maxHeap.isEmpty()) {
            return new int[]{0, 0};
        }
        return new int[]{maxHeap.peek(), minHeap.peek()};
    }

    public static void main(String[] args) {
        이중우선순위큐 doublePriorityQueue = new 이중우선순위큐();
        String[] firstOperations = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        System.out.println("Result: " + Arrays.toString(doublePriorityQueue.solution(firstOperations)));

        String[] secondOperations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        System.out.println("Result: " + Arrays.toString(doublePriorityQueue.solution(secondOperations)));
    }
}
