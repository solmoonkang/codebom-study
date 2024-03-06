package algorithm.week9;

public class 등굣길 {

    /**
     * [ 문제 설명 ]
     * 계속되는 폭우로 일부 지역이 물에 잠겼습니다.
     * 물에 잠기지 않은 지역을 통해 학교를 가려고 합니다. 집에서 학교까지 가는 길은 m x n 크기의 격자모양으로 나타낼 수 있습니다.
     * 격자의 크기 m, n과 물이 잠긴 지역의 좌표를 담은 2차원 배열 puddles이 매개변수로 주어집니다.
     * 오른쪽과 아래쪽으로만 움직여 집에서 학교까지 갈 수 있는 최단경로의 개수를
     * 1,000,000,007로 나눈 나머지를 return 하도록 solution 함수를 작성해주세요.
     */

    /**
     * [ 제한 조건 ]
     * 격자의 크기 m, n은 1 이상 100 이하인 자연수입니다.
     * m과 n이 모두 1인 경우는 입력으로 주어지지 않습니다.
     * 물에 잠긴 지역은 0개 이상 10개 이하입니다.
     * 집과 학교가 물에 잠긴 경우는 입력으로 주어지지 않습니다.
     */
    public int solution(int m, int n, int[][] puddles) {
        int[][] routes = new int[m + 1][n + 1];
        routes[1][1] = 1;

        for (int[] puddle : puddles) {
            routes[puddle[0]][puddle[1]] = -1;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 && j == 1) continue;
                if (routes[i][j] == -1) {
                    routes[i][j] = 0;
                    continue;
                }
                if(i > 1) routes[i][j] += routes[i - 1][j] % 1000000007;
                if(j > 1) routes[i][j] += routes[i][j - 1] % 1000000007;
            }
        }
        return routes[m][n];
    }

    public static void main(String[] args) {
        등굣길 routeToSchool = new 등굣길();
        int[][] puddles = {{2, 2}};
        System.out.println("routeToSchool = " + routeToSchool.solution(4, 3, puddles));
    }
}
