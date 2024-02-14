package algorithm.week1;

import java.util.Arrays;
import java.util.HashMap;

public class 전화번호목록 {

    /**
     * [ 문제 설명 ]
     * 전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 합니다.
     * 전화번호가 다음과 같을 경우, 구조대 전화번호는 영석이의 전화번호의 접두사입니다.
     *
     * 구조대 : 119
     * 박준영 : 97 674 223
     * 지영석 : 11 9552 4421
     * 전화번호부에 적힌 전화번호를 담은 배열 phone_book 이 solution 함수의 매개변수로 주어질 때,
     * 어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return 하도록 solution 함수를 작성해주세요.
     */
    public boolean solution(String[] phone_book) {
        HashMap<String, Integer> phoneNumberList = new HashMap();

        // 모든 전화번호를 HashMap에 추가한다.
        for (int i = 0; i < phone_book.length; i++) {
            phoneNumberList.put(phone_book[i], i);
        }

        // 각 전화번호에 대한 부분 문자열을 검사한다.
        for (int i = 0; i < phone_book.length; i++) {
            for (int j = 0; j < phone_book[i].length(); j++) {
                if (phoneNumberList.containsKey(phone_book[i].substring(0, j))) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean sort_solution(String[] phone_book) {
        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                // 다음 전화번호가 현재 전화번호로 시작하면 false를 반환한다.
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        전화번호목록 phoneNumberList = new 전화번호목록();

        String[] firstPhoneBooks = {"119", "97674223", "1195524421"};
        System.out.println("Result: " + phoneNumberList.solution(firstPhoneBooks));

        String[] secondPhoneBooks = {"123","456","789"};
        System.out.println("Result: " + phoneNumberList.solution(secondPhoneBooks));

        String[] thirdPhoneBooks = {"12","123","1235","567","88"};
        System.out.println("Result: " + phoneNumberList.solution(thirdPhoneBooks));
    }
}
