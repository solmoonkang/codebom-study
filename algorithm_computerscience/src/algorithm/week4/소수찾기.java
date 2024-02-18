package algorithm.week4;

import java.util.HashSet;
import java.util.Set;

public class 소수찾기 {

    /**
     * [ 문제 설명 ]
     * 한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.
     * 각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때,
     * 종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.
     */

    /**
     * [ 제한 사항 ]
     * numbers는 길이 1 이상 7 이하인 문자열입니다.
     * numbers는 0~9까지 숫자만으로 이루어져 있습니다.
     * "013"은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.
     */
    Set<Integer> set = new HashSet<>();
    boolean[] visited = new boolean[7];

    public int solution(String numbers) {
        // TODO: 문제 해결 못함. 기본 개념 공부 후 다시 풀어보자.
        int count = 0;
        dfs(numbers, "", 0);

        for (Integer number : set) {
            if (isPrime(number)) {
                count++;
            }
        }
        return count;
    }

    private void dfs(String numbers, String answer, int depth) {
        if (!answer.equals("")) {
            set.add(Integer.parseInt(answer));
        }

        if (depth == numbers.length()) {
            return;
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(numbers, answer + numbers.charAt(i), depth + 1);
                visited[i] = false;;
            }
        }
    }

    private boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }

        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        소수찾기 findingPrimeNumbers = new 소수찾기();
        System.out.println("Result: " + findingPrimeNumbers.solution("17"));
        System.out.println("Result: " + findingPrimeNumbers.solution("011"));
    }
}
