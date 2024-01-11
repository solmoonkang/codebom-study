package week1_study;

import java.util.HashMap;

public class 완주하지못한선수 {

    /**
     * [ 문제 설명 ]
     * 수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.
     * 마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때,
     * 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.
     */
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> runner = new HashMap<>();

        // 마라톤에 참여한 참가자들의 숫자를 1씩 증가시킨다.
        for (String name : participant) {
            runner.put(name, runner.getOrDefault(name, 0) + 1);
        }

        // 마라톤에 완주한 참가자들의 숫자를 1씩 감소시킨다.
        for (String name : completion) {
            runner.put(name, runner.get(name) - 1);
            // 만약, 완주한 참가자를 찾을 때마다 해당 이름을 제거한다.
            if (runner.get(name) == 0) {
                runner.remove(name);
            }
        }
        return runner.keySet().iterator().next();
    }

    public static void main(String[] args) {
        완주하지못한선수 theIncompletePlayer = new 완주하지못한선수();
        String[] firstParticipant = {"leo", "kiki", "eden"};
        String[] firstCompletion = {"eden", "kiki"};
        System.out.println("Result: " + theIncompletePlayer.solution(firstParticipant, firstCompletion));

        String[] secondParticipant = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] secondCompletion = {"josipa", "filipa", "marina", "nikola"};
        System.out.println("Result: " + theIncompletePlayer.solution(secondParticipant, secondCompletion));

        String[] thirdParticipant = {"mislav", "stanko", "mislav", "ana"};
        String[] thirdCompletion = {"stanko", "ana", "mislav"};
        System.out.println("Result: " + theIncompletePlayer.solution(thirdParticipant, thirdCompletion));
    }
}
