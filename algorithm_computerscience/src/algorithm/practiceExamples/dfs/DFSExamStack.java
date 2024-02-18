package algorithm.practiceExamples.dfs;

import java.util.Deque;
import java.util.LinkedList;

public class DFSExamStack {

    public static void dfs(int v, boolean[] visited, int[][] graph) {
        visited[v] = true;
        System.out.print(v + " ");

        Deque<Integer> usingStack = new LinkedList<>();

        usingStack.push(v);

        while (!usingStack.isEmpty()) {
            int current = usingStack.peek();

            boolean hasNearNode = false;

            for (int g : graph[current]) {
                if (!visited[g]) {
                    hasNearNode = true;
                    usingStack.push(g);
                    visited[g] = true;
                    System.out.print(g + " ");
                    break;
                }
            }
            if (!hasNearNode) {
                usingStack.pop();
            }
        }
    }

    public static void main(String[] args) {
        boolean[] visited = {false, false, false, false, false, false, false, false, false};
        int[][] graph = {
                {},
                {2, 3, 8},
                {1, 7},
                {1, 4, 5},
                {3, 5},
                {3, 4},
                {7},
                {2, 6, 8},
                {1, 7}};

        int start = 1;
        System.out.print("현재 방문한 노드: ");
        dfs(start, visited, graph);
    }
}
