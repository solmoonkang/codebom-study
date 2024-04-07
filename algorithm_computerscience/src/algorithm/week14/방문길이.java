package algorithm.week14;

import java.util.HashSet;
import java.util.Set;

public class 방문길이 {

    /**
     * [ 문제 설명 ]
     * 게임 캐릭터를 4가지 명령어를 통해 움직이려 합니다. 명령어는 다음과 같습니다.
     *
     * U: 위쪽으로 한 칸 가기
     * D: 아래쪽으로 한 칸 가기
     * R: 오른쪽으로 한 칸 가기
     * L: 왼쪽으로 한 칸 가기
     *
     * 캐릭터는 좌표평면의 (0, 0) 위치에서 시작합니다.
     * 좌표평면의 경계는 왼쪽 위(-5, 5), 왼쪽 아래(-5, -5), 오른쪽 위(5, 5), 오른쪽 아래(5, -5)로 이루어져 있습니다.
     *
     * 이때, 우리는 게임 캐릭터가 지나간 길 중 캐릭터가 처음 걸어본 길의 길이를 구하려고 합니다.
     * 예를 들어 위의 예시에서 게임 캐릭터가 움직인 길이는 9이지만, 캐릭터가 처음 걸어본 길의 길이는 7이 됩니다.
     * (8, 9번 명령어에서 움직인 길은 2, 3번 명령어에서 이미 거쳐 간 길입니다)
     * 단, 좌표평면의 경계를 넘어가는 명령어는 무시합니다.
     *
     * 명령어가 매개변수 dirs로 주어질 때, 게임 캐릭터가 처음 걸어본 길의 길이를 구하여 return 하는 solution 함수를 완성해 주세요.
     */

    /**
     * [ 제한 사항 ]
     * dirs는 string형으로 주어지며, 'U', 'D', 'R', 'L' 이외에 문자는 주어지지 않습니다.
     * dirs의 길이는 500 이하의 자연수입니다.
     */
    public int solution(String dirs) {
        int x = 0, y = 0;
        Set<String> paths = new HashSet<>();

        int[][] moves = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        char[] directions = {'U', 'D', 'R', 'L'};

        for (char move : dirs.toCharArray()) {
            int nx = x, ny = y;

            for (int i = 0; i < directions.length; i++) {
                if (move == directions[i]) {
                    nx += moves[i][0];
                    ny += moves[i][1];
                    break;
                }
            }

            if (nx > 5 || nx < -5 || ny > 5 || ny < -5) continue;

            StringBuilder path = new StringBuilder().append(x).append(y).append(nx).append(ny);
            StringBuilder reversePath = new StringBuilder().append(nx).append(ny).append(x).append(y);
            if (!paths.contains(path.toString())) {
                paths.add(path.toString());
                paths.add(reversePath.toString());
            }

            x = nx;
            y = ny;
        }

        return paths.size() / 2;
    }

    public static void main(String[] args) {
        방문길이 visitLength = new 방문길이();

        System.out.println("visitLength = " + visitLength.solution("ULURRDLLU"));

        System.out.println("visitLength = " + visitLength.solution("LULLLLLLU"));
    }
}
