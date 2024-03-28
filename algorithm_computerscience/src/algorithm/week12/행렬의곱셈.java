package algorithm.week12;

import java.util.Arrays;

public class 행렬의곱셈 {

    /**
     * [ 문제 설명 ]
     * 2차원 행렬 arr1과 arr2를 입력받아, arr1에 arr2를 곱한 결과를 반환하는 함수, solution을 완성해주세요.
     */

    /**
     * [ 제한 사항 ]
     * 행렬 arr1, arr2의 행과 열의 길이는 2 이상 100 이하입니다.
     * 행렬 arr1, arr2의 원소는 -10 이상 20 이하인 자연수입니다.
     * 곱할 수 있는 배열만 주어집니다.
     */
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2[0].length; j++) {
                for (int k = 0; k < arr1[0].length; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        행렬의곱셈 matrixMultiplication = new 행렬의곱셈();

        int[][] firstArr1 = {{1, 4}, {3, 2}, {4, 1}};
        int[][] firstArr2 = {{3, 3}, {3, 3}};
        System.out.println("matrixMultiplication = " + Arrays.deepToString(matrixMultiplication.solution(firstArr1, firstArr2)));

        int[][] secondArr1 = {{2, 3, 2}, {4, 2, 4}, {3, 1, 4}};
        int[][] secondArr2 = {{5, 4, 3}, {2, 4, 1}, {3, 1, 1}};
        System.out.println("matrixMultiplication = " + Arrays.deepToString(matrixMultiplication.solution(secondArr1, secondArr2)));
    }
}
