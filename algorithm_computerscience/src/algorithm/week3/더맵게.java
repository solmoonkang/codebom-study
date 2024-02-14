package algorithm.week3;

import java.util.PriorityQueue;

public class 더맵게 {

    /**
     * [ 문제 설명 ]
     * 매운 것을 좋아하는 Leo는 모든 음식의 스코빌 지수를 K 이상으로 만들고 싶습니다.
     * 모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 Leo는 스코빌 지수가 가장 낮은 두 개의 음식을 만듭니다.
     * 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
     * Leo는 모든 음식의 스코빌 지수가 K 이상이 될 때까지 반복하여 섞습니다.
     * Leo가 가진 음식의 스코빌 지수를 담은 배열 scoville과 원하는 스코빌 지수 K가 주어질 때,
     * 모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 섞어야 하는 최소 횟수를 return 하도록 solution 함수를 작성해주세요.
     */

    /**
     * [ 제한 사항 ]
     * scoville의 길이는 2 이상 1,000,000 이하입니다.
     * K는 0 이상 1,000,000,000 이하입니다.
     * scoville의 원소는 각각 0 이상 1,000,000 이하입니다.
     * 모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우에는 -1을 return 합니다.
     */

    /**
     * [ 문제 풀이 흐름 ]
     * 1. 스코빌 지수를 담은 배열 scoville을 우선순위 큐에 넣습니다. ⭕️
     *  이 때, 우선순위 큐는 기본적으로 가장 작은 원소부터 꺼내집니다.
     * 2. 우선순위 큐의 가장 작은 원소(가장 앞에 있는 원소)를 확인합니다. ⭕️
     *  이 원소가 K 이상이면, 모든 음식의 스코빌 지수가 K 이상이 된 것이므로 반복을 종료합니다.
     * 3. 우선순위 큐의 원소가 K 미만이면, 가장 작은 원소와 그 다음으로 작은 원소를 꺼내어 새로운 음식을 만듭니다. ⭕️
     *  새로운 음식의 스코빌 지수는 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)로 계산합니다.
     * 4. 계산한 스코빌 지수를 다시 우선순위 큐에 넣습니다. ⭕️
     * 5. 이 과정을 반복하여 모든 음식의 스코빌 지수가 K 이상이 될 때까지 섞는 횟수를 카운트합니다. ⭕️
     * 6. 만약 모든 음식의 스코빌 지수가 K 이상이 될 수 없는 경우에는 -1을 반환합니다. ⭕️
     *  이는 우선순위 큐의 크기가 1이 되었는데도 스코빌 지수가 K 미만일 때 발생합니다.
     */
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> lessSpicier = new PriorityQueue<>();

        for (int scov : scoville) {
            lessSpicier.offer(scov);
        }

        int count = 0;
        while (lessSpicier.size() > 1 && lessSpicier.peek() < K) {
            int leastSpicyFood = lessSpicier.poll();
            int secondLeastSpicyFood = lessSpicier.poll();
            int mixedFood = leastSpicyFood + (secondLeastSpicyFood * 2);

            lessSpicier.offer(mixedFood);
            count++;
        }

        return lessSpicier.peek() < K ? -1 : count;
    }

    public static void main(String[] args) {
        더맵게 spicier = new 더맵게();
        int[] scoville = {1, 2, 3, 9, 10, 12};
        System.out.println("Result: " + spicier.solution(scoville, 7));
    }
}
