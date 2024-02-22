package algorithm.practiceExamples.bfs;

import java.util.Deque;
import java.util.LinkedList;

public class BFSExamQueue {
    public static String bfs(int start, int[][] graphs, boolean[] visited) {
        // 탐색 순서를 나타내기 위해 선언한 StringBuilder
        StringBuilder builder = new StringBuilder();

        // BFS를 위해 Deque를 생성해준다.
        Deque<Integer> deque = new LinkedList<>();
        // Deque에 BFS를 시작할 첫 번째 노드 번호를 추가한다.
        deque.offerLast(start);
        // 해당 노드 즉, 시작 노드를 방문처리해준다.
        visited[start] = true;

        // BFS 알고리즘은 Deque가 비어있을 때까지 반복한다.
        while (!deque.isEmpty()) {
            int currentNode = deque.pollFirst();
            builder.append(currentNode + " -> ");

            // Deque에서 꺼낸 노드와 연결된 노드들을 확인한다.
            for (int i = 0; i < graphs[currentNode].length; i++) {
                int temp = graphs[currentNode][i];

                // 방문하지 않았을 경우, 해당 노드를 방문처리 한 후에 Deque에 추가한다.
                if (!visited[temp]) {
                    visited[temp] = true;
                    deque.offerLast(temp);
                }
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        // 그래프를 graphs 2차원 배열로 표현한다.
        // 배열의 인덱스를 노드와 매칭시켜서 사용하기 위해 첫 번째 인덱스에는 아무것도 저장하지 않는다.
        // 1번 인덱스는 1번 노드를 의미하고, 노드 배열의 값은 연결된 노드들이다.
        int[][] graphs = {
                {},
                {2, 3, 8},
                {1, 6, 8},
                {1, 5},
                {5, 7},
                {3, 4, 7},
                {2},
                {4, 5},
                {1, 2}};

        // 방문처리를 위한 boolean 배열을 선언한다.
        boolean[] visited = new boolean[9];

        System.out.println("Result: " + bfs(1, graphs, visited));
    }
}
