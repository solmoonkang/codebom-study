package algorithm.week8;

import java.util.Deque;
import java.util.LinkedList;

public class 아이템줍기 {

    /**
     * [ 문제 설명 ]
     * 다음과 같은 다각형 모양 지형에서 캐릭터가 아이템을 줍기 위해 이동하려 합니다.
     * 지형은 각 변이 x축, y축과 평행한 직사각형이 겹쳐진 형태로 표현하며, 캐릭터는 이 다각형의 둘레(굵은 선)를 따라서 이동합니다.
     * 만약 직사각형을 겹친 후 다음과 같이 중앙에 빈 공간이 생기는 경우, 다각형의 가장 바깥쪽 테두리가 캐릭터의 이동 경로가 됩니다.
     * 단, 서로 다른 두 직사각형의 x축 좌표 또는 y축 좌표가 같은 경우는 없습니다.
     * 즉, 위 그림처럼 서로 다른 두 직사각형이 꼭짓점에서 만나거나, 변이 겹치는 경우 등은 없습니다.
     * 다음 그림과 같이 지형이 2개 이상으로 분리된 경우도 없습니다.
     * 한 직사각형이 다른 직사각형 안에 완전히 포함되는 경우 또한 없습니다.
     * 지형을 나타내는 직사각형이 담긴 2차원 배열 rectangle, 초기 캐릭터의 위치 characterX, characterY,
     * 아이템의 위치 itemX, itemY가 solution 함수의 매개변수로 주어질 때,
     * 캐릭터가 아이템을 줍기 위해 이동해야 하는 가장 짧은 거리를 return 하도록 solution 함수를 완성해주세요.
     */

    /**
     * [ 제한 사항 ]
     * rectangle의 세로(행) 길이는 1 이상 4 이하입니다.
     * rectangle의 원소는 각 직사각형의 [좌측 하단 x, 좌측 하단 y, 우측 상단 x, 우측 상단 y] 좌표 형태입니다.
     * 직사각형을 나타내는 모든 좌표값은 1 이상 50 이하인 자연수입니다.
     * 서로 다른 두 직사각형의 x축 좌표, 혹은 y축 좌표가 같은 경우는 없습니다.
     * 문제에 주어진 조건에 맞는 직사각형만 입력으로 주어집니다.
     * charcterX, charcterY는 1 이상 50 이하인 자연수입니다.
     * 지형을 나타내는 다각형 테두리 위의 한 점이 주어집니다.
     * itemX, itemY는 1 이상 50 이하인 자연수입니다.
     * 지형을 나타내는 다각형 테두리 위의 한 점이 주어집니다.
     * 캐릭터와 아이템의 처음 위치가 같은 경우는 없습니다.
     * 전체 배점의 50%는 직사각형이 1개인 경우입니다.
     * 전체 배점의 25%는 직사각형이 2개인 경우입니다.
     * 전체 배점의 25%는 직사각형이 3개 또는 4개인 경우입니다.
     */

    private static final int MAX = 101;
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};
    private int[][] dist = new int[MAX][MAX];
    private int[][] map = new int[MAX][MAX];
    private boolean[][] visited = new boolean[MAX][MAX];

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        // TODO: 문제 이해부터 어려웠지만, 문제는 이해를 했다. 하지만 테두리를 2배 해주는 이유에 대해서 정확히 이해하지 못했다.
        for (int[] rec : rectangle) {
            draw(rec);
        }
        return bfs(2 * characterX, 2 * characterY, 2 * itemX, 2 * itemY);
    }

    private void draw(int[] rect) {
        int x1 = 2 * rect[0];
        int y1 = 2 * rect[1];
        int x2 = 2 * rect[2];
        int y2 = 2 * rect[3];

        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                if (map[i][j] == 2) continue;
                map[i][j] = 2;
                if (i == x1 || i == x2 || j == y1 || j == y2) {
                    map[i][j] = 1;
                }
            }
        }
    }

    private int bfs(int x, int y, int itemX, int itemY) {
        Deque<int[]> deque = new LinkedList<>();
        deque.offerLast(new int[]{x, y});
        visited[x][y] = true;

        while (!deque.isEmpty()) {
            int[] current = deque.pollFirst();

            for (int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];


                if ((nx >= 0) && (ny >= 0) && (nx < MAX) && (ny < MAX) && !visited[nx][ny] && map[nx][ny] == 1) {
                    dist[nx][ny] = dist[current[0]][current[1]] + 1;
                    visited[nx][ny] = true;
                    deque.offerLast(new int[]{nx, ny});
                }
            }
        }
        return dist[itemX][itemY] / 2;
    }

    public static void main(String[] args) {
        아이템줍기 pickUpItem = new 아이템줍기();
        int[][] firstRectangle = {{1, 1, 7, 4}, {3, 2, 5, 5}, {4, 3, 6, 9}, {2, 6, 8, 8}};
        System.out.println("firstRectangle = " + pickUpItem.solution(firstRectangle, 1, 3, 7, 8));

//        int[][] secondRectangle = {{1, 1, 8, 4}, {2, 2, 4, 9}, {3, 6, 9, 8}, {6, 3, 7, 7}};
//        System.out.println("secondRectangle = " + pickUpItem.solution(secondRectangle, 9, 7, 6, 1));

//        int[][] thirdRectangle = {{1, 1, 5, 7}};
//        System.out.println("thirdRectangle = " + pickUpItem.solution(thirdRectangle, 1, 1, 4, 7));

//        int[][] fourthRectangle = {{2, 1, 7, 5}, {6, 4, 10, 10}};
//        System.out.println("fourthRectangle = " + pickUpItem.solution(fourthRectangle, 3, 1, 7, 10));
//
//        int[][] fifthRectangle = {{2, 2, 5, 5}, {1, 3, 6, 4}, {3, 1, 4, 6}};
//        System.out.println("fifthRectangle = " + pickUpItem.solution(fifthRectangle, 1, 4, 6, 3));
    }
}
