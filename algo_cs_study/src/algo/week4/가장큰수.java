package algo.week4;

import java.util.Arrays;

public class 가장큰수 {

    /**
     * [ 문제 설명 ]
     * 0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.
     * 예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.
     * 0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때,
     * 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.
     */

    /**
     * [ 제한 사항 ]
     * numbers의 길이는 1 이상 100,000 이하입니다.
     * numbers의 원소는 0 이상 1,000 이하입니다.
     * 정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.
     */

    /**
     * [ 문제 풀이 흐름 ]
     * 1. 입력으로 받은 정수 배열을 문자열 배열로 변환합니다. ⭕️
     *  왜냐하면, 숫자를 문자열로 변환하면 문자열 비교를 통해 쉽게 숫자의 순서를 정할 수 있기 때문입니다.
     * 2. 문자열 비교를 통해 두 숫자를 이어 붙였을 때 더 큰 숫자를 만드는 순서대로 정렬합니다. ⭕️
     *  예를 들어, "6"과 "10"이 있을 때 "610"과 "106"을 비교하여 "610"이 더 크므로 "6", "10" 순서로 정렬합니다.
     * 3. 정렬된 문자열 배열을 합쳐 하나의 문자열로 만듭니다. ⭕️
     * 4. 만약 가장 큰 수가 0으로 시작한다면 그 수는 0이므로, 결과가 "0"이라면 "0"을 반환합니다. 그렇지 않다면 만들어진 문자열을 반환합니다. ⭕️
     */
    public String solution(int[] numbers) {
        // TODO: 다시 한 번 더 풀어보기.
        String[] strNumbers = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strNumbers[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(strNumbers, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        if (strNumbers[0].equals("0")) {
            return "0";
        }

        StringBuilder builder = new StringBuilder();

        for (String strNumber: strNumbers) {
            builder.append(strNumber);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        가장큰수 theLargestNumber = new 가장큰수();
        int[] firstNumbers = {6, 10, 2};
        System.out.println("Result: " + theLargestNumber.solution(firstNumbers));

        int[] secondNumbers = {3, 30, 34, 5, 9};
        System.out.println("Result: " + theLargestNumber.solution(secondNumbers));
    }
}
