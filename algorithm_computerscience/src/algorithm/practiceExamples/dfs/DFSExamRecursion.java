package algorithm.practiceExamples.dfs;

public class DFSExamRecursion {

    public static void dfs(int v, boolean[] visited, int[][] graph) {
        visited[v] = true;
        System.out.print(v + " ");

        for (int g : graph[v]) {
            if (!visited[g]) {
                dfs(g, visited, graph);
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
