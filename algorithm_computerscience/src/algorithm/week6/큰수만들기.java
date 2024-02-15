package algorithm.week6;

import java.util.Deque;
import java.util.LinkedList;

public class 큰수만들기 {

    /**
     * [ 문제 설명 ]
     * 어떤 숫자에서 k개의 수를 제거했을 때 얻을 수 있는 가장 큰 숫자를 구하려 합니다.
     * 예를 들어, 숫자 1924에서 수 두 개를 제거하면 [19, 12, 14, 92, 94, 24] 를 만들 수 있습니다. 이 중 가장 큰 숫자는 94 입니다.
     * 문자열 형식으로 숫자 number와 제거할 수의 개수 k가 solution 함수의 매개변수로 주어집니다.
     * number에서 k 개의 수를 제거했을 때 만들 수 있는 수 중 가장 큰 숫자를 문자열 형태로 return 하도록 solution 함수를 완성하세요.
     */

    /**
     * [ 제한 사항 ]
     * number는 2자리 이상, 1,000,000자리 이하인 숫자입니다.
     * k는 1 이상 number의 자릿수 미만인 자연수입니다.
     */
    public String solution(String number, int k) {
        Deque<Character> deque = new LinkedList<>();

        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);

            while (!deque.isEmpty() && deque.peekLast() < c && k > 0) {
                deque.removeLast();
                k--;
            }
            deque.offerLast(c);
        }
        StringBuilder builder = new StringBuilder();

        while (!deque.isEmpty() && builder.length() < (number.length() - k)) {
            builder.append(deque.pollFirst());
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        큰수만들기 makingALargeNumber = new 큰수만들기();
        System.out.println("Result: " + makingALargeNumber.solution("1924", 2));
        System.out.println("Result: " + makingALargeNumber.solution("1231234", 3));
        System.out.println("Result: " + makingALargeNumber.solution("4177252841", 4));
    }
}
