package algo.week4;

import java.util.Arrays;
import java.util.Collections;

public class H_Index {

    /**
     * [ 문제 설명 ]
     * H-Index는 과학자의 생산성과 영향력을 나타내는 지표입니다. 어느 과학자의 H-Index를 나타내는 값인 h를 구하려고 합니다.
     * 위키백과1에 따르면, H-Index는 다음과 같이 구합니다.
     * 어떤 과학자가 발표한 논문 n편 중, h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 인용되었다면 h의 최댓값이 과학자의 H-Index입니다.
     * 어떤 과학자가 발표한 논문의 인용 횟수를 담은 배열 citations가 매개변수로 주어질 때,
     * 이 과학자의 H-Index를 return 하도록 solution 함수를 작성해주세요.
     */

    /**
     * [ 제한 사항 ]
     * 과학자가 발표한 논문의 수는 1편 이상 1,000편 이하입니다.
     * 논문별 인용 횟수는 0회 이상 10,000회 이하입니다.
     */

    /**
     * [ 문제 풀이 흐름 ]
     * 1. 배열을 내림차순으로 정렬합니다. 이렇게 하면 가장 많이 인용된 논문부터 순서대로 배열됩니다. ⭕️
     * 2. 배열을 순회하면서, 현재 인덱스(0부터 시작)가 현재 논문의 인용 횟수를 넘어서는 지점을 찾습니다. ⭕️
     *  이 때, 현재 인덱스가 곧 h가 됩니다. 인덱스는 0부터 시작하므로 실제로는 인덱스 + 1이 h가 됩니다.
     * 3. 이렇게 찾은 h가 H-Index가 됩니다. ⭕️
     */
    public int solution(int[] citations) {
        // TODO: 다시 한 번 문제 풀어보기.

        // Arrays.sort는 오름차순만 지원하기 때문에, Integer[]로 변환 후 내림차순으로 정렬시켜줘야 한다.
        Integer[] h_index = Arrays.stream(citations).boxed().toArray(Integer[]::new);
        Arrays.sort(h_index, Collections.reverseOrder());

        int maxIndex = 0;
        for (int i = 0; i < citations.length; i++) {
            // 각 논문의 인용 횟수와 그보다 많이 인용된 논문의 수 중 작은 값을 구하고,
            int minIndex = Math.min(citations[i], citations.length - i);
            // 이 값들 중 가장 큰 값을 찾아서 반환한다.
            if (maxIndex < minIndex) maxIndex = minIndex;
        }
        return maxIndex;
    }

    public static void main(String[] args) {
        H_Index h_index = new H_Index();
        int[] citations = {3, 0, 6, 1, 5};
        System.out.println("Result: " + h_index.solution(citations));
    }
}
