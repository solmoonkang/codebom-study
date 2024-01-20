package algo.week2;

import java.util.Deque;
import java.util.LinkedList;

public class 다리를지나는트럭 {

    /**
     * [ 문제 설명 ]
     * 트럭 여러 대가 강을 가로지르는 일차선 다리를 정해진 순으로 건너려 합니다.
     * 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 알아내야 합니다.
     * 다리에는 트럭이 최대 bridge_length대 올라갈 수 있으며, 다리는 weight 이하까지의 무게를 견딜 수 있습니다.
     * 단, 다리에 완전히 오르지 않은 트럭의 무게는 무시합니다.
     *
     * solution 함수의 매개변수로
     * 다리에 올라갈 수 있는 트럭 수 bridge_length,
     * 다리가 견딜 수 있는 무게 weight,
     * 트럭 별 무게 truck_weights가 주어집니다.
     * 이때 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 return 하도록 solution 함수를 완성하세요.
     */

    /**
     * [ 제한 조건 ]
     * bridge_length는 1 이상 10,000 이하입니다.
     * weight는 1 이상 10,000 이하입니다.
     * truck_weights의 길이는 1 이상 10,000 이하입니다.
     * 모든 트럭의 무게는 1 이상 weight 이하입니다.
     */
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        // TODO: 문제에 대한 이해가 부족, 흐름에 대해서 공부가 필요하다.
        Deque<Integer> bridge = new LinkedList<>();
        Deque<Integer> waitingTrucks = new LinkedList<>();

        for (int i = 0; i < bridge_length; i++) {
            bridge.offer(0);
        }

        for (int truck_weight : truck_weights) {
            waitingTrucks.offer(truck_weight);
        }

        int time = 0;
        int totalWeight = 0;
        while (!waitingTrucks.isEmpty()) {
            time++;

            if (bridge.size() == bridge_length) {
                totalWeight -= bridge.pollFirst();
            }

            if (totalWeight + waitingTrucks.peekFirst() <= weight) {
                int truck = waitingTrucks.pollFirst();
                bridge.offerLast(truck);
                totalWeight += truck;
            } else {
                bridge.offerLast(0);
            }
        }
        return time + bridge_length;
    }

    public static void main(String[] args) {
        다리를지나는트럭 truckCrossingTheBridge = new 다리를지나는트럭();
        int[] firstTruckWeights = {7, 4, 5, 6};
        System.out.println("Result: " + truckCrossingTheBridge.solution(2, 10, firstTruckWeights));

        int[] secondTruckWeights = {10};
        System.out.println("Result: " + truckCrossingTheBridge.solution(100, 100, secondTruckWeights));

        int[] thirdTruckWeights = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        System.out.println("Result: " + truckCrossingTheBridge.solution(100, 100, thirdTruckWeights));
    }
}
