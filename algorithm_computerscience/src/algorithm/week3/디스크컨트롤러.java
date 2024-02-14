package algorithm.week3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 디스크컨트롤러 {

    /**
     * [ 문제 설명 ]
     * 하드디스크는 한 번에 하나의 작업만 수행할 수 있습니다.
     * 디스크 컨트롤러를 구현하는 방법은 여러 가지가 있습니다. 가장 일반적인 방법은 요청이 들어온 순서대로 처리하는 것입니다.
     * 각 작업에 대해 [작업이 요청되는 시점, 작업의 소요시간]을 담은 2차원 배열 jobs가 매개변수로 주어질 때,
     * 작업의 요청부터 종료까지 걸린 시간의 평균을 가장 줄이는 방법으로 처리하면 평균이 얼마가 되는지 return 하도록 solution 함수를 작성해주세요.
     * (단, 소수점 이하의 수는 버립니다)
     */

    /**
     * [ 제한 사항 ]
     * jobs의 길이는 1 이상 500 이하입니다.
     * jobs의 각 행은 하나의 작업에 대한 [작업이 요청되는 시점, 작업의 소요시간] 입니다.
     * 각 작업에 대해 작업이 요청되는 시간은 0 이상 1,000 이하입니다.
     * 각 작업에 대해 작업의 소요시간은 1 이상 1,000 이하입니다.
     * 하드디스크가 작업을 수행하고 있지 않을 때에는 먼저 요청이 들어온 작업부터 처리합니다.
     */

    /**
     * [ 문제 풀이 흐름 ]
     * 1. jobs 배열을 요청 시간에 따라 오름차순으로 정렬합니다. ⭕️
     * 2. 우선순위 큐를 생성하고, 작업의 소요시간에 따라 오름차순으로 정렬되도록 합니다. ⭕️
     * 3. 현재 시간을 관리하는 변수를 만듭니다. 초기값은 0입니다. ⭕️
     * 4. jobs 배열을 순회하면서, 현재 시간 이전에 요청된 작업들을 우선순위 큐에 추가합니다. ⭕️
     * 5. 큐에서 가장 짧은 작업을 꺼내어 처리하고, 대기 시간을 계산하여 누적합니다. 대기 시간은 현재 시간 - 작업의 요청 시간 + 작업의 소요시간입니다.
     * 6. 큐가 빌 때까지 위 과정을 반복합니다.
     * 7. 모든 작업이 완료되면 누적된 대기 시간의 평균을 반환합니다.
     */
    public int solution(int[][] jobs) {
        // TODO: 2차원 배열 활용이 미숙하다.
        Arrays.sort(jobs, Comparator.comparingInt(o -> o[0]));
        PriorityQueue<int[]> diskController = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));

        int time = 0;
        int index = 0;
        int totalWaitTime = 0;
        while(index < jobs.length || !diskController.isEmpty()) {
            while (index < jobs.length && jobs[index][0] <= time) {
                diskController.offer(jobs[index++]);
            }

            if (!diskController.isEmpty()) {
                int[] job = diskController.poll();
                totalWaitTime += time - job[0] + job[1];
                time += job[1];
            } else {
                time = jobs[index][0];
            }
        }

        return totalWaitTime / jobs.length;
    }

    public static void main(String[] args) {
        디스크컨트롤러 diskController = new 디스크컨트롤러();
        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
        System.out.println("Result: " + diskController.solution(jobs));
    }
}
