package algorithm.week9;

public class 순위 {

    /*
     * [ 문제 설명 ]
     * n명의 권투선수가 권투 대회에 참여했고 각각 1번부터 n번까지 번호를 받았습니다.
     * 권투 경기는 1대1 방식으로 진행이 되고, 만약 A 선수가 B 선수보다 실력이 좋다면 A 선수는 B 선수를 항상 이깁니다.
     * 심판은 주어진 경기 결과를 가지고 선수들의 순위를 매기려 합니다.
     * 하지만 몇몇 경기 결과를 분실하여 정확하게 순위를 매길 수 없습니다.
     * 선수의 수 n, 경기 결과를 담은 2차원 배열 results가 매개변수로 주어질 때,
     * 정확하게 순위를 매길 수 있는 선수의 수를 return 하도록 solution 함수를 작성해주세요.
     */

    /*
     * [ 제한 사항 ]
     * 선수의 수는 1명 이상 100명 이하입니다.
     * 경기 결과는 1개 이상 4,500개 이하입니다.
     * results 배열 각 행 [A, B]는 A 선수가 B 선수를 이겼다는 의미입니다.
     * 모든 경기 결과에는 모순이 없습니다.
     */
    public int solution(int n, int[][] results) {
        // TODO: 플로이드-와샬 알고리즘에 대해 공부해보자. 그리고 마지막에 선수를 세는 방법에 대해서 이해가 잘 되지 않는다.
        boolean[][] graph = new boolean[n + 1][n + 1];

        for (int[] result : results) {
            int winner = result[0];
            int loser = result[1];

            graph[winner][loser] = true;
        }

        // 플로이드-와샬 알고리즘
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (graph[i][k] && graph[k][j]) {
                        graph[i][j] = true;
                    }
                }
            }
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 1; j <= n; j++) {
                if (graph[i][j] || graph[j][i]) {
                    count++;
                }
            }
            if (count == n - 1) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        순위 ranking = new 순위();
        int[][] results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
        System.out.println("results = " + ranking.solution(5, results));
    }

    /*
     * 4번은 3번을 이김
     * 4번은 2번을 이김
     *
     * 3번은 2번을 이김
     *
     * 1번은 2번을 이김
     *
     * 2번은 5번을 이김
     */
}
