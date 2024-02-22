package algorithm.week7;

import java.util.Deque;
import java.util.LinkedList;

public class 타겟넘버 {

    /**
     * [ 문제 설명 ]
     * n개의 음이 아닌 정수들이 있습니다. 이 정수들을 순서를 바꾸지 않고 적절히 더하거나 빼서 타겟 넘버를 만들려고 합니다.
     * 예를 들어 [1, 1, 1, 1, 1]로 숫자 3을 만들려면 다음 다섯 방법을 쓸 수 있습니다.
     * -1+1+1+1+1 = 3
     * +1-1+1+1+1 = 3
     * +1+1-1+1+1 = 3
     * +1+1+1-1+1 = 3
     * +1+1+1+1-1 = 3
     * 사용할 수 있는 숫자가 담긴 배열 numbers, 타겟 넘버 target이 매개변수로 주어질 때
     * 숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수를 return 하도록 solution 함수를 작성해주세요.
     */

    /**
     * [ 제한 사항 ]
     * 주어지는 숫자의 개수는 2개 이상 20개 이하입니다.
     * 각 숫자는 1 이상 50 이하인 자연수입니다.
     * 타겟 넘버는 1 이상 1000 이하인 자연수입니다.
     */

    /**
     * [ DFS (깊이 우선 탐색) 풀이 흐름 ]
     *
     * 우선, DFS를 수행할 재귀 함수를 만듭니다. 이 함수는 현재 숫자의 인덱스와 현재까지의 합을 매개변수로 받습니다.
     * 재귀 함수에서는 먼저 현재 인덱스가 numbers 배열의 길이와 같은지 확인합니다.
         * 만약 같다면, 현재까지의 합이 타겟 넘버와 같은지 확인하고, 같다면 1을 반환하고, 그렇지 않다면 0을 반환합니다.
     * 현재 인덱스가 numbers 배열의 길이와 같지 않다면,
         * 다음 인덱스로 넘어가고 현재 숫자를 더하거나 뺀 경우를 각각 재귀 함수로 호출합니다. 이때, 재귀 함수의 반환값을 합산합니다.
     * 마지막으로, 재귀 함수의 합산 결과를 반환합니다.
     */
    public int solutionDfs(int[] numbers, int target) {
        // TODO: DFS, BFS 방법 둘 다 다시 풀어보기.
        return dfs(numbers, target, 0, 0);
    }

    private int dfs(int[] numbers, int target, int index, int sum) {
        if (index == numbers.length) {
            return (sum == target) ? 1 : 0;
        } else {
            return dfs(numbers, target, index + 1, sum + numbers[index])
                    + dfs(numbers, target, index + 1, sum - numbers[index]);
        }
    }

    /**
     * [ BFS (너비 우선 탐색) 풀이 흐름 ]
     *
     * 큐에 시작 노드를 넣습니다. 여기서 시작 노드는 입력 배열의 첫 번째 숫자를 더하거나 뺀 두 가지 경우입니다.
     * 큐에서 노드를 하나 꺼내고, 그 다음 숫자를 더하거나 뺀 두 가지 경우를 큐에 넣습니다.
        * 이런 방식으로 모든 숫자에 대해 더하거나 빼는 경우를 고려하면서 트리를 너비 우선으로 탐색합니다.
     * 마지막 숫자까지 더하거나 뺀 결과가 타겟 넘버와 같다면 카운트를 증가시키고, 그렇지 않다면 카운트를 증가시키지 않습니다.
     * 모든 경우를 탐색한 후, 카운트를 반환합니다.
     */
    public int solutionBfs(int[] numbers, int target) {
        Deque<Integer> deque = new LinkedList<>();
        deque.offerLast(numbers[0]);
        deque.offerLast(-numbers[0]);

        int count = 0;
        int idx = 1;
        while (!deque.isEmpty()) {
            int size = deque.size();

            for (int i = 0; i < size; i++) {
                int current = deque.pollFirst();

                if (idx == numbers.length) {
                    if (current == target) {
                        count++;
                    }
                } else {
                    deque.offerLast(current + numbers[idx]);
                    deque.offerLast(current - numbers[idx]);
                }
            }

            if (idx != numbers.length) {
                idx++;
            }
        }

        return count;
    }


    public static void main(String[] args) {
        타겟넘버 targetNumber = new 타겟넘버();
        int[] firstNumbers = {1, 1, 1, 1};
        System.out.println("Result: " + targetNumber.solutionDfs(firstNumbers, 3));

        int[] secondNumbers = {4, 1, 2, 1};
        System.out.println("Result: " + targetNumber.solutionDfs(secondNumbers, 4));
    }
}
