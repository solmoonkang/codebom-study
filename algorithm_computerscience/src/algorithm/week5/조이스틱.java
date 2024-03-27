package algorithm.week5;

public class 조이스틱 {

    /**
     * [ 문제 설명 ]
     * 조이스틱으로 알파벳 이름을 완성하세요. 맨 처음엔 A로만 이루어져 있습니다.
     * ex) 완성해야 하는 이름이 세 글자면 AAA, 네 글자면 AAAA
     *
     * 조이스틱을 각 방향으로 움직이면 아래와 같습니다.
     *
     * ▲ - 다음 알파벳
     * ▼ - 이전 알파벳 (A에서 아래쪽으로 이동하면 Z로)
     * ◀ - 커서를 왼쪽으로 이동 (첫 번째 위치에서 왼쪽으로 이동하면 마지막 문자에 커서)
     * ▶ - 커서를 오른쪽으로 이동 (마지막 위치에서 오른쪽으로 이동하면 첫 번째 문자에 커서)
     * 예를 들어 아래의 방법으로 "JAZ"를 만들 수 있습니다.
     *
     * - 첫 번째 위치에서 조이스틱을 위로 9번 조작하여 J를 완성합니다.
     * - 조이스틱을 왼쪽으로 1번 조작하여 커서를 마지막 문자 위치로 이동시킵니다.
     * - 마지막 위치에서 조이스틱을 아래로 1번 조작하여 Z를 완성합니다.
     * 따라서 11번 이동시켜 "JAZ"를 만들 수 있고, 이때가 최소 이동입니다.
     * 만들고자 하는 이름 name이 매개변수로 주어질 때, 이름에 대해 조이스틱 조작 횟수의 최솟값을 return 하도록 solution 함수를 만드세요.
     */

    /**
     * [ 제한 사항 ]
     * name은 알파벳 대문자로만 이루어져 있습니다.
     * name의 길이는 1 이상 20 이하입니다.
     */
    public int solution(String name) {
        // TODO: 문제 이해가 부족한거 같다. 다시 한 번 풀어보자.
        int answer = 0;
        int length = name.length();

        // 최대로 가질 수 있는 min 이동 거리는 좌우 최대 이동 거리
        int minMove = length - 1;

        for(int i = 0; i < length; i++) {
            // 각 알파벳에 대해 상하 조작 횟수
            char c = name.charAt(i);
            int move = Math.min(c - 'A', 'Z' - c + 1);
            answer += move;

            // 다음 문자로 이동하기 위한 최소 좌우 이동 횟수 계산
            int nextIndex = i + 1;
            while (nextIndex < length && name.charAt(nextIndex) == 'A') {
                nextIndex++;
            }
            minMove = Math.min(minMove, i + length - nextIndex + Math.min(i, length - nextIndex));
        }

        answer += minMove;

        return answer;
    }

    public static void main(String[] args) {
        조이스틱 joystick = new 조이스틱();
        System.out.println("Result: " + joystick.solution("JEROEN"));
        System.out.println("Result: " + joystick.solution("JAN"));
    }
}
