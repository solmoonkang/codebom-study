package algorithm.week12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N_2배열자르기 {

    /**
     * [ 문제 설명 ]
     * 정수 n, left, right가 주어집니다. 다음 과정을 거쳐서 1차원 배열을 만들고자 합니다.
     *
     * 1. n행 n열 크기의 비어있는 2차원 배열을 만듭니다. ⭕️
     * 2. i = 1, 2, 3, ..., n에 대해서, 다음 과정을 반복합니다. ⭕️
     *  (1행 1열부터 i행 i열까지의 영역 내의 모든 빈 칸을 숫자 i로 채웁니다.)
     * 3. 1행, 2행, ..., n행을 잘라내어 모두 이어붙인 새로운 1차원 배열을 만듭니다. ⭕️
     * 4. 새로운 1차원 배열을 arr이라 할 때, arr[left], arr[left+1], ..., arr[right]만 남기고 나머지는 지웁니다. ⭕️
     * 정수 n, left, right가 매개변수로 주어집니다.
     * 주어진 과정대로 만들어진 1차원 배열을 return 하도록 solution 함수를 완성해주세요.
     */

    /**
     * [ 제한 사항 ]
     * 1 ≤ n ≤ 10^7
     * 0 ≤ left ≤ right < n^2
     * right - left < 10^5
     */
    public int[] solution(int n, long left, long right) {
        int[][] twoDimensionalArray = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int row = 0; row <= i; row++) {
                twoDimensionalArray[row][i] = i + 1;
                twoDimensionalArray[i][row] = i + 1;
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int[] array : twoDimensionalArray) {
            for (int num : array) {
                list.add(num);
            }
        }

        return list.subList((int) left, (int) (right + 1)).stream().mapToInt(i -> i).toArray();
    }




    public int[] feedback(int n, long left, long right) {
        int[] answer = new int[(int) (right - left + 1)];

        for (long i = left; i <= right; i++) {
            long row = i / n;
            long col = i % n;

            answer[(int) (i - left)] = (int) (Math.max(row, col) + 1);
        }
        return answer;
    }

    public static void main(String[] args) {
        N_2배열자르기 slicingN2Array = new N_2배열자르기();

        System.out.println("slicingN2Array = " + Arrays.toString(slicingN2Array.solution(3, 2, 5)));
        System.out.println("slicingN2Array = " + Arrays.toString(slicingN2Array.solution(4, 7, 14)));

        System.out.println("slicingN2Array = " + Arrays.toString(slicingN2Array.feedback(3, 2, 5)));
        System.out.println("slicingN2Array = " + Arrays.toString(slicingN2Array.feedback(4, 7, 14)));
    }
}
