package algorithm.week8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class 퍼즐조각채우기 {

    /**
     * [ 문제 설명 ]
     * 테이블 위에 놓인 퍼즐 조각을 게임 보드의 빈 공간에 적절히 올려놓으려 합니다. 게임 보드와 테이블은 모두 각 칸이 1x1 크기인 정사각 격자 모양입니다.
     * 이때, 다음 규칙에 따라 테이블 위에 놓인 퍼즐 조각을 게임 보드의 빈칸에 채우면 됩니다.
         * 조각은 한 번에 하나씩 채워 넣습니다.
         * 조각을 회전시킬 수 있습니다.
         * 조각을 뒤집을 수는 없습니다.
         * 게임 보드에 새로 채워 넣은 퍼즐 조각과 인접한 칸이 비어있으면 안 됩니다.
     * 다음은 퍼즐 조각을 채우는 예시입니다.
     * 위 그림에서 왼쪽은 현재 게임 보드의 상태를, 오른쪽은 테이블 위에 놓인 퍼즐 조각들을 나타냅니다.
     * 테이블 위에 놓인 퍼즐 조각들 또한 마찬가지로 [상,하,좌,우]로 인접해 붙어있는 경우는 없으며, 흰 칸은 퍼즐이 놓이지 않은 빈 공간을 나타냅니다.
     * 모든 퍼즐 조각은 격자 칸에 딱 맞게 놓여있으며, 격자 칸을 벗어나거나, 걸쳐 있는 등 잘못 놓인 경우는 없습니다.
     * 이때, 아래 그림과 같이 3,4,5번 조각을 격자 칸에 놓으면 규칙에 어긋나므로 불가능한 경우입니다.
        * 3번 조각을 놓고 4번 조각을 놓기 전에 위쪽으로 인접한 칸에 빈칸이 생깁니다.
        * 5번 조각의 양 옆으로 인접한 칸에 빈칸이 생깁니다.
     * 최대한 많은 조각을 채워 넣으면 총 14칸을 채울 수 있습니다.
     * 현재 게임 보드의 상태 game_board, 테이블 위에 놓인 퍼즐 조각의 상태 table이 매개변수로 주어집니다.
     * 규칙에 맞게 최대한 많은 퍼즐 조각을 채워 넣을 경우, 총 몇 칸을 채울 수 있는지 return 하도록 solution 함수를 완성해주세요.
     */

    /**
     * [ 제한 사항 ]
     * 3 ≤ game_board의 행 길이 ≤ 50
     * game_board의 각 열 길이 = game_board의 행 길이
        * 즉, 게임 보드는 정사각 격자 모양입니다.
        * game_board의 모든 원소는 0 또는 1입니다.
        * 0은 빈칸, 1은 이미 채워진 칸을 나타냅니다.
        * 퍼즐 조각이 놓일 빈칸은 1 x 1 크기 정사각형이 최소 1개에서 최대 6개까지 연결된 형태로만 주어집니다.
     * table의 행 길이 = game_board의 행 길이
     * table의 각 열 길이 = table의 행 길이
        * 즉, 테이블은 game_board와 같은 크기의 정사각 격자 모양입니다.
        * table의 모든 원소는 0 또는 1입니다.
        * 0은 빈칸, 1은 조각이 놓인 칸을 나타냅니다.
        * 퍼즐 조각은 1 x 1 크기 정사각형이 최소 1개에서 최대 6개까지 연결된 형태로만 주어집니다.
     * game_board에는 반드시 하나 이상의 빈칸이 있습니다.
     * table에는 반드시 하나 이상의 블록이 놓여 있습니다.
     */
    private static final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int N;

    public int solution(int[][] game_board, int[][] table) {
        // TODO: 문제를 제대로 풀지 못했다.
        N = game_board.length;
        List<Block> blocks = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (table[i][j] == 1) {
                    Block block = new Block();
                    findBlock(i, j, block, table, 1);
                    blocks.add(block);
                }
            }
        }

        int answer = 0;
        for (Block block : blocks) {
            for (int d = 0; d < 4; d++) {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (game_board[i][j] == 0 && canPut(block, i, j, game_board)) {
                            putBlock(block, i, j, game_board, 1);
                            answer += block.size;
                            i = N;
                            j = N;
                            d = 4;
                        }
                    }
                }
                block.rotate();
            }
        }
        return answer;
    }

    void putBlock(Block block, int x, int y, int[][] board, int value) {
        for (Point p : block.points) {
            int nx = x + p.x;
            int ny = y + p.y;

            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            board[nx][ny] = value;
        }
    }

    boolean canPut(Block block, int x, int y, int[][] board) {
        for (Point p : block.points) {
            int nx = x + p.x;
            int ny = y + p.y;

            if (nx < 0 || ny < 0 || nx >= N || ny >= N) return false;
            if (board[nx][ny] != 0) return false;
        }
        return true;
    }

    void findBlock(int x, int y, Block block, int[][] table, int value) {
        if (x < 0 || y < 0 || x >= N || y >= N) return;
        if (table[x][y] != value) return;

        table[x][y] = 0;
        block.addPoint(x, y);
        for (int[] dir : dirs) {
            findBlock(x + dir[0], y + dir[1], block, table, value);
        }
        block.normalize();
    }

    class Block {
        List<Point> points = new ArrayList<>();
        int size = 0;
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;

        void addPoint(int x, int y) {
            points.add(new Point(x, y));
            size++;
            minX = Math.min(minX, x);
            minY = Math.min(minY, y);
        }

        void rotate() {
            for (Point point : points) {
                int temp = point.x;
                point.x = point.y;
                point.y = N - 1 - temp;
            }
            normalize();
        }

        void normalize() {
            int minX = points.stream().min(Comparator.comparingInt(p -> p.x)).get().x;
            int minY = points.stream().min(Comparator.comparingInt(p -> p.y)).get().y;
            for (Point p : points) {
                p.x -= minX;
                p.y -= minY;
            }
            Collections.sort(points);
        }
    }

    class Point implements Comparable<Point> {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            if (this.x == o.x) return this.y - o.y;
            else return this.x - o.x;
        }
    }

    public static void main(String[] args) {
        퍼즐조각채우기 fillingInPuzzlePieces = new 퍼즐조각채우기();
        int[][] firstGameBoards = {
                {1, 1, 0, 0, 1, 0},
                {0, 0, 1, 0, 1, 0},
                {0, 1, 1, 0, 0, 1},
                {1, 1, 0, 1, 1, 1},
                {1, 0, 0, 0, 1, 0},
                {0, 1, 1, 1, 0, 0}};
        int[][] firstTables = {
                {1, 0, 0, 1, 1, 0},
                {1, 0, 1, 0, 1, 0},
                {0, 1, 1, 0, 1, 1},
                {0, 0, 1, 0, 0, 0},
                {1, 1, 0, 1, 1, 0},
                {0, 1, 0, 0, 0, 0}};
        System.out.println("firstGameBoards = " + fillingInPuzzlePieces.solution(firstGameBoards, firstTables));

//        int[][] secondGameBoards = {{0, 0, 0}, {1, 1, 0}, {1, 1, 1}};
//        int[][] secondTables = {{1, 1, 1}, {1, 0, 0}, {0, 0, 0}};
//        System.out.println("secondTables = " + fillingInPuzzlePieces.solution(secondGameBoards, secondTables));
    }
}
