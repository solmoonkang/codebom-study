package week2_study;

import java.util.Deque;
import java.util.LinkedList;

public class 올바른괄호 {

    /**
     * [ 문제 설명 ]
     * 괄호가 바르게 짝지어졌다는 것은 '(' 문자로 열렸으면 반드시 짝지어서 ')' 문자로 닫혀야 한다는 뜻입니다.
     * '(' 또는 ')' 로만 이루어진 문자열 s가 주어졌을 때,
     * 문자열 s가 올바른 괄호이면 true를 return 하고, 올바르지 않은 괄호이면 false를 return 하는 solution 함수를 완성해 주세요.
     */
    boolean solution(String s) {
        Deque<String> parentheses = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                parentheses.offerLast("(");
            } else if (s.charAt(i) == ')') {
                if (parentheses.isEmpty()) {
                    return false;
                }
                parentheses.pollLast();
            }
        }
        return parentheses.isEmpty();
    }

    public static void main(String[] args) {
        올바른괄호 validParentheses = new 올바른괄호();
        System.out.println("Result: " + validParentheses.solution("()()"));
        System.out.println("Result: " + validParentheses.solution("(())()"));
        System.out.println("Result: " + validParentheses.solution(")()("));
        System.out.println("Result: " + validParentheses.solution("(()("));
    }
}
