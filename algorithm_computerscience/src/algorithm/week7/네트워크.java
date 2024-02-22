package algorithm.week7;

public class 네트워크 {

    /**
     * [ 문제 설명 ]
     * 네트워크란 컴퓨터 상호 간에 정보를 교환할 수 있도록 연결된 형태를 의미합니다.
     * 예를 들어, 컴퓨터 A와 컴퓨터 B가 직접적으로 연결되어있고, 컴퓨터 B와 컴퓨터 C가 직접적으로 연결되어 있을 때
     * 컴퓨터 A와 컴퓨터 C도 간접적으로 연결되어 정보를 교환할 수 있습니다.
     * 따라서 컴퓨터 A, B, C는 모두 같은 네트워크 상에 있다고 할 수 있습니다.
     * 컴퓨터의 개수 n, 연결에 대한 정보가 담긴 2차원 배열 computers가 매개변수로 주어질 때,
     * 네트워크의 개수를 return 하도록 solution 함수를 작성하시오.
     */

    /**
     * [ 제한 사항 ]
     * 컴퓨터의 개수 n은 1 이상 200 이하인 자연수입니다.
     * 각 컴퓨터는 0부터 n-1인 정수로 표현합니다.
     * i번 컴퓨터와 j번 컴퓨터가 연결되어 있으면 computers[i][j]를 1로 표현합니다.
     * computer[i][i]는 항상 1입니다.
     */

    /**
     * [ DFS 문제 풀이 흐름 ]
     * 먼저, 컴퓨터들의 방문 여부를 체크하는 visited 배열을 선언합니다.
        * 컴퓨터의 개수만큼의 크기를 가진 boolean 타입의 배열을 선언하고, 모든 값을 false로 초기화합니다.
     * 그 다음, 모든 컴퓨터를 순회하면서 아직 방문하지 않은 컴퓨터가 있다면 DFS를 수행하고, 네트워크의 개수를 1 증가시킵니다.
         * DFS는 해당 컴퓨터를 방문했다는 표시를 하고, 해당 컴퓨터와 연결된 모든 컴퓨터에 대해 아직 방문하지 않았다면 DFS를 재귀적으로 수행하는 방식으로 작동합니다.
     * 모든 컴퓨터를 순회하고 DFS를 수행한 후에, 증가시킨 네트워크의 개수를 반환합니다.
     */
    public int solution(int n, int[][] computers) {
        // TODO: 아직 DFS 개념이 부족한거 같다. 개념 이해와 문제 풀이를 충분히 해보자. 해당 문제도 다시 한 번 풀어보자.
        boolean[] visited = new boolean[n];

        int networkCount = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, computers, visited);
                networkCount++;
            }
        }
        return networkCount;
    }

    private void dfs(int i, int[][] computers, boolean[] visited) {
        visited[i] = true;

        for (int j = 0; j < computers.length; j++) {
            if (computers[i][j] == 1 && !visited[j]) {
                dfs(j, computers, visited);
            }
        }
    }

    public static void main(String[] args) {
        네트워크 network = new 네트워크();
        int[][] firstComputers = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}};
        System.out.println("Result: " + network.solution(3, firstComputers));

        int[][] secondComputers = {
                {1, 1, 0},
                {1, 1, 1},
                {0, 1, 1}};
        System.out.println("Result: " + network.solution(3, secondComputers));
    }
}
