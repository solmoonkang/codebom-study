package algorithm.week7;

import java.util.Deque;
import java.util.LinkedList;

public class 게임맵최단거리 {

    /**
     * [ 문제 설명 ]
     * ROR 게임은 두 팀으로 나누어서 진행하며, 상대 팀 진영을 먼저 파괴하면 이기는 게임입니다.
     * 따라서, 각 팀은 상대 팀 진영에 최대한 빨리 도착하는 것이 유리합니다.
     * 지금부터 당신은 한 팀의 팀원이 되어 게임을 진행하려고 합니다.
     * 캐릭터가 움직일 때는 동, 서, 남, 북 방향으로 한 칸씩 이동하며, 게임 맵을 벗어난 길은 갈 수 없습니다.
     * 게임 맵의 상태 maps가 매개변수로 주어질 때,
     * 캐릭터가 상대 팀 진영에 도착하기 위해서 지나가야 하는 칸의 개수의 최솟값을 return 하도록 solution 함수를 완성해주세요.
     * 단, 상대 팀 진영에 도착할 수 없을 때는 -1을 return 해주세요.
     */

    /**
     * [ 제한 조건 ]
     * maps는 n x m 크기의 게임 맵의 상태가 들어있는 2차원 배열로, n과 m은 각각 1 이상 100 이하의 자연수입니다.
     * n과 m은 서로 같을 수도, 다를 수도 있지만, n과 m이 모두 1인 경우는 입력으로 주어지지 않습니다.
     * maps는 0과 1로만 이루어져 있으며, 0은 벽이 있는 자리, 1은 벽이 없는 자리를 나타냅니다.
     * 처음에 캐릭터는 게임 맵의 좌측 상단인 (1, 1) 위치에 있으며, 상대방 진영은 게임 맵의 우측 하단인 (n, m) 위치에 있습니다.
     */

    /**
     * [ BFS 문제 풀이 흐름 ]
     * BFS를 수행하기 위해, 시작점인 (1,1)에서 시작하는 큐를 생성합니다. 큐에는 위치 정보와 해당 위치까지의 거리 정보를 저장합니다.
     * BFS를 시작하기 위해, 큐가 빌 때까지 다음의 작업을 반복합니다:
     * 큐에서 노드를 하나 꺼냅니다.
     * 꺼낸 노드에서 이동할 수 있는 상하좌우 네 방향에 대해 다음의 작업을 수행합니다:
     * 이동할 위치가 맵의 범위 안에 있고, 벽이 아니며(즉, 값이 1이며), 아직 방문하지 않았다면(즉, 거리가 0이라면) 큐에 넣습니다.
         * 이때, 위치 정보와 함께 거리 정보(현재 노드의 거리 + 1)도 같이 저장합니다.
     * 이 과정을 통해 BFS를 수행하면, 각 위치까지의 최단 거리를 구할 수 있습니다.
     * BFS가 끝나면, 도착점인 (n,m)까지의 거리를 확인합니다.
         * 만약 도착점을 방문하지 않았다면 -1을 반환하고, 그렇지 않다면 도착점까지의 거리를 반환합니다.
     */
    public int solution(int[][] maps) {
        // TODO: 문제는 이해했지만, 다시 한 번 풀어보자.
        class Point {
            int x, y, dist;

            public Point(int x,
                         int y,
                         int dist) {
                this.x = x;
                this.y = y;
                this.dist = dist;
            }
        }
        final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Deque<Point> deque = new LinkedList<>();
        deque.offerLast(new Point(0, 0, 1));

        while (!deque.isEmpty()) {
            Point current  = deque.pollFirst();

            for (int[] direction : DIRECTIONS) {
                int nextX = current.x + direction[0];
                int nextY = current.y + direction[1];

                if (nextX >= 0 && nextX < maps.length && nextY >= 0 && nextY < maps[0].length && maps[nextX][nextY] == 1) {
                    deque.offerLast(new Point(nextX, nextY, current.dist + 1));
                    maps[nextX][nextY] = 0;
                }
            }
            if (current.x == maps.length - 1 && current.y == maps[0].length - 1) {
                return current.dist;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        게임맵최단거리 shortestDistanceInGameMap = new 게임맵최단거리();
        int[][] firstMaps = {
                {1,0,1,1,1},
                {1,0,1,0,1},
                {1,0,1,1,1},
                {1,1,1,0,1},
                {0,0,0,0,1}};
        System.out.println("Result: " + shortestDistanceInGameMap.solution(firstMaps));

        int[][] secondMaps = {
                {1,0,1,1,1},
                {1,0,1,0,1},
                {1,0,1,1,1},
                {1,1,1,0,0},
                {0,0,0,0,1}};
        System.out.println("Result: " + shortestDistanceInGameMap.solution(secondMaps));
    }
}
