package algorithm.week9;

import java.util.*;

public class 가장먼노드 {

    /*
     *  문제 설명 ]
     * n개의 노드가 있는 그래프가 있습니다. 각 노드는 1부터 n까지 번호가 적혀있습니다.
     * 1번 노드에서 가장 멀리 떨어진 노드의 갯수를 구하려고 합니다.
     * 가장 멀리 떨어진 노드란 최단경로로 이동했을 때 간선의 개수가 가장 많은 노드들을 의미합니다.
     * 노드의 개수 n, 간선에 대한 정보가 담긴 2차원 배열 vertex가 매개변수로 주어질 때,
     * 1번 노드로부터 가장 멀리 떨어진 노드가 몇 개인지를 return 하도록 solution 함수를 작성해주세요.
     */

    /*
     * [ 제한 사항 ]
     * 노드의 개수 n은 2 이상 20,000 이하입니다.
     * 간선은 양방향이며 총 1개 이상 50,000개 이하의 간선이 있습니다.
     * vertex 배열 각 행 [a, b]는 a번 노드와 b번 노드 사이에 간선이 있다는 의미입니다.
     */
    public int solution(int n, int[][] edge) {
        ArrayList<Integer>[] graph = createGraph(n, edge);
        int[] distances = bfs(graph, n);

        int maxDistance = Arrays.stream(distances).max().getAsInt();
        return (int) Arrays.stream(distances)
                .filter(distance -> distance == maxDistance)
                .count();
    }

    private ArrayList<Integer>[] createGraph(int n, int[][] edges) {
        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];

            graph[node1].add(node2);
            graph[node2].add(node1);
        }

        return graph;
    }

    private int[] bfs(ArrayList<Integer>[] graph, int n) {
        int[] distances = new int[n + 1];
        Arrays.fill(distances, -1);

        distances[1] = 0;
        Deque<Integer> deque = new LinkedList<>();
        deque.add(1);

        while (!deque.isEmpty()) {
            int currentNode = deque.pollFirst();

            for (int adjacentNode : graph[currentNode]) {
                if (distances[adjacentNode] == -1) {
                    distances[adjacentNode] = distances[currentNode] + 1;
                    deque.add(adjacentNode);
                }
            }
        }

        return distances;
    }

    public static void main(String[] args) {
        가장먼노드 theFarthestNode = new 가장먼노드();
        int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        System.out.println("edge = " + theFarthestNode.solution(6, edge));
    }
}
