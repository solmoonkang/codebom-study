package algo.week2;

import java.util.*;

public class 기능개발 {

    /**
     * [ 문제 설명 ]
     * 프로그래머스 팀에서는 기능 개선 작업을 수행 중입니다. 각 기능은 진도가 100%일 때 서비스에 반영할 수 있습니다.
     * 또, 각 기능의 개발속도는 모두 다르기 때문에 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수 있고,
     * 이때 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포됩니다.
     * 먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 progresses와 각 작업의 개발 속도가 적힌 정수 배열 speeds가 주어질 때
     * 각 배포마다 몇 개의 기능이 배포되는지를 return 하도록 solution 함수를 완성하세요.
     */

    /**
     * [ 제한 사항 ]
     * 작업의 개수(progresses, speeds배열의 길이)는 100개 이하입니다.
     * 작업 진도는 100 미만의 자연수입니다.
     * 작업 속도는 100 이하의 자연수입니다.
     * 배포는 하루에 한 번만 할 수 있으며, 하루의 끝에 이루어진다고 가정합니다.
     */

    /**
     * [ 문제 풀이 흐름 ]
     * 1. 각 기능들이 완성되기까지 필요한 일수를 계산한다.
     * 2. 계산한 일수를 기반으로 기능들을 배포하는 순서를 결정한다.
     * 3. 이제 각 배포마다 몇 개의 기능이 배포되는지를 계산한다.
     * 4. 마지막으로 각 배포마다 배포되는 기능의 수를 리스트로 반환한다.
     */
    public int[] solution(int[] progresses, int[] speeds) {
        Deque<Integer> deployment = new LinkedList<>();
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < progresses.length; i++) {
            int days = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
            deployment.offerLast(days);
        }

        if (deployment.isEmpty()) {
            return new int[]{0};
        }

        int count = 1;
        int firstProgress = deployment.pollFirst();

        while (!deployment.isEmpty()) {
            if (firstProgress >= deployment.peekFirst()) {
                count++;
                deployment.pollFirst();
            } else {
                answer.add(count);
                count = 1;
                firstProgress = deployment.pollFirst();
            }
        }
        answer.add(count);

        return answer.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        기능개발 featureDevelop = new 기능개발();

        int[] firstProgresses = {93, 30, 55};
        int[] firstSpeeds = {1, 30, 5};
        System.out.println("Result: " + Arrays.toString(featureDevelop.solution(firstProgresses, firstSpeeds)));

        int[] secondProgresses = {95, 90, 99, 99, 80, 99};
        int[] secondSpeeds = {1, 1, 1, 1, 1, 1};
        System.out.println("Result: " + Arrays.toString(featureDevelop.solution(secondProgresses, secondSpeeds)));
    }
}
