package algorithm.week5;

import java.util.ArrayList;

public class 전력망을둘로나누기 {

    /**
     * [ 문제 설명 ]
     * n개의 송전탑이 전선을 통해 하나의 트리 형태로 연결되어 있습니다.
     * 당신은 이 전선들 중 하나를 끊어서 현재의 전력망 네트워크를 2개로 분할하려고 합니다.
     * 이때, 두 전력망이 갖게 되는 송전탑의 개수를 최대한 비슷하게 맞추고자 합니다.
     * 송전탑의 개수 n, 그리고 전선 정보 wires가 매개변수로 주어집니다.
     * 전선들 중 하나를 끊어서 송전탑 개수가 가능한 비슷하도록 두 전력망으로 나누었을 때,
     * 두 전력망이 가지고 있는 송전탑 개수의 차이(절대값)를 return 하도록 solution 함수를 완성해주세요.
     */

    /**
     * [ 제한 사항 ]
     * n은 2 이상 100 이하인 자연수입니다.
     * wires는 길이가 n-1인 정수형 2차원 배열입니다.
         * wires의 각 원소는 [v1, v2] 2개의 자연수로 이루어져 있으며,
             * 이는 전력망의 v1번 송전탑과 v2번 송전탑이 전선으로 연결되어 있다는 것을 의미합니다.
         * 1 ≤ v1 < v2 ≤ n 입니다.
         * 전력망 네트워크가 하나의 트리 형태가 아닌 경우는 입력으로 주어지지 않습니다.
     */
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int totalNodes;

    public int solution(int n, int[][] wires) {
        // TODO: 전체적인 이해도가 부족하다. BFS/DFS 알고리즘을 다시 공부하고 풀어보자.

        // 최대 차이는 n-1이 될 수 있으므로 n으로 초기화
        int answer = n;
        graph = new ArrayList[n+1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] wire : wires) {
            int v1 = wire[0];
            int v2 = wire[1];
            graph[v1].add(v2);
            graph[v2].add(v1);
        }

        for (int[] wire : wires) {
            visited = new boolean[n+1];
            int v1 = wire[0];
            int v2 = wire[1];

            // 해당 전선을 끊음
            graph[v1].remove((Integer) v2);
            graph[v2].remove((Integer) v1);

            // 끊어진 전선으로 인해 생성된 서브 트리의 노드 개수 계산
            totalNodes = 0;
            dfs(v1);

            // 두 서브 트리의 차이 계산
            answer = Math.min(answer, Math.abs(n - 2*totalNodes));

            // 원래 상태로 복구
            graph[v1].add(v2);
            graph[v2].add(v1);
        }

        return answer;
    }

    public void dfs(int node) {
        visited[node] = true;
        totalNodes++;
        for (int next : graph[node]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    public static void main(String[] args) {
        전력망을둘로나누기 dividingThePowerNetwork = new 전력망을둘로나누기();
        int[][] firstWires = {{1, 3},{2, 3},{3, 4},{4, 5},{4, 6},{4, 7},{7, 8},{7, 9}};
        System.out.println("Result: " + dividingThePowerNetwork.solution(9, firstWires));

        int[][] secondWires = {{1, 2},{2, 3},{3, 4}};
        System.out.println("Result: " + dividingThePowerNetwork.solution(4, secondWires));

        int[][] thirdWires = {{1, 2},{2, 7},{3, 7},{3, 4},{4, 5},{6, 7}};
        System.out.println("Result: " + dividingThePowerNetwork.solution(7, thirdWires));
    }
}
