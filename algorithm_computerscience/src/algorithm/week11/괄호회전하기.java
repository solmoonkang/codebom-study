package algorithm.week11;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class 괄호회전하기 {

    /**
     * [ 문제 설명 ]
     * 다음 규칙을 지키는 문자열을 올바른 괄호 문자열이라고 정의합니다.
     *
     * (), [], {} 는 모두 올바른 괄호 문자열입니다.
     * 만약 A가 올바른 괄호 문자열이라면, (A), [A], {A} 도 올바른 괄호 문자열입니다.
     * 예를 들어, [] 가 올바른 괄호 문자열이므로, ([]) 도 올바른 괄호 문자열입니다.
     * 만약 A, B가 올바른 괄호 문자열이라면, AB 도 올바른 괄호 문자열입니다.
     * 예를 들어, {} 와 ([]) 가 올바른 괄호 문자열이므로, {}([]) 도 올바른 괄호 문자열입니다.
     * 대괄호, 중괄호, 그리고 소괄호로 이루어진 문자열 s가 매개변수로 주어집니다.
     * 이 s를 왼쪽으로 x (0 ≤ x < (s의 길이)) 칸만큼 회전시켰을 때
     * s가 올바른 괄호 문자열이 되게 하는 x의 개수를 return 하도록 solution 함수를 완성해주세요.
     */

    /**
     * [ 제한 사항 ]
     * s의 길이는 1 이상 1,000 이하입니다.
     */
    private static final Map<Character, Character> bracketPairs = new HashMap<>();

    static {
        bracketPairs.put(')', '(');
        bracketPairs.put('}', '{');
        bracketPairs.put(']', '[');
    }

    public int solution(String s) {
        // TODO: 다시 한 번 풀어보자.
        int validRotations = 0;

        for (int i = 0; i < s.length(); i++) {
            if (isValidBracketSequence(s)) validRotations++;
            s = s.substring(1) + s.charAt(0);
        }

        return validRotations;
    }

    private boolean isValidBracketSequence(String s) {
        Deque<Character> correctBracket = new LinkedList<>();

        for (char c : s.toCharArray()) {
            if (bracketPairs.containsValue(c)) {
                correctBracket.addLast(c);
            } else if (bracketPairs.containsKey(c)) {
                if (correctBracket.isEmpty() || correctBracket.removeLast() != bracketPairs.get(c)) {
                    return false;
                }
            }
        }

        return correctBracket.isEmpty();
    }

    public static void main(String[] args) {
        괄호회전하기 rotatingBrackets = new 괄호회전하기();

        System.out.println("rotatingBrackets = " + rotatingBrackets.solution("[](){}"));
        System.out.println("rotatingBrackets = " + rotatingBrackets.solution("}]()[{"));
        System.out.println("rotatingBrackets = " + rotatingBrackets.solution("[)(]"));
        System.out.println("rotatingBrackets = " + rotatingBrackets.solution("}}}"));
    }
}
