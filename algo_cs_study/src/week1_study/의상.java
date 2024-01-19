package week1_study;

import java.util.HashMap;
import java.util.Map;

public class 의상 {

    /**
     * [ 문제 설명 ]
     * 코니는 매일 다른 옷을 조합하여 입는것을 좋아합니다.
     *
     * 예를 들어 코니가 가진 옷이 아래와 같고, 오늘 코니가 동그란 안경, 긴 코트, 파란색 티셔츠를 입었다면
     * 다음날은 청바지를 추가로 입거나 동그란 안경 대신 검정 선글라스를 착용하거나 해야합니다.
     * 코니는 각 종류별로 최대 1가지 의상만 착용할 수 있습니다.
     * 예를 들어 위 예시의 경우 동그란 안경과 검정 선글라스를 동시에 착용할 수는 없습니다.
     * 착용한 의상의 일부가 겹치더라도, 다른 의상이 겹치지 않거나, 혹은 의상을 추가로 더 착용한 경우에는 서로 다른 방법으로 옷을 착용한 것으로 계산합니다.
     * 코니는 하루에 최소 한 개의 의상은 입습니다.
     *
     * 코니가 가진 의상들이 담긴 2차원 배열 clothes가 주어질 때 서로 다른 옷의 조합의 수를 return 하도록 solution 함수를 작성해주세요.
     */

    /**
     * [ 제한 사항 ]
     * clothes의 각 행은 [의상의 이름, 의상의 종류]로 이루어져 있습니다.
     * 코니가 가진 의상의 수는 1개 이상 30개 이하입니다.
     * 같은 이름을 가진 의상은 존재하지 않습니다.
     * clothes의 모든 원소는 문자열로 이루어져 있습니다.
     * 모든 문자열의 길이는 1 이상 20 이하인 자연수이고 알파벳 소문자 또는 '_' 로만 이루어져 있습니다.
     */
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> clothesType = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            clothesType.put(clothes[i][1], clothesType.getOrDefault(clothes[i][1], 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : clothesType.entrySet()) {
            int num = (entry.getValue() + 1);
            answer *= num;
        }

        return answer - 1;
    }

    public int refactor_solution(String[][] clothes) {
        HashMap<String, Integer> clothesCountByType = new HashMap<>();

        for (String[] pair : clothes) {
            String type = pair[1];
            clothesCountByType.put(type, clothesCountByType.getOrDefault(type, 0) + 1);
        }

        int numCombinations = 1;
        for (int count : clothesCountByType.values()) {
            numCombinations *= (count + 1);
        }
        return numCombinations - 1;
    }

    public static void main(String[] args) {
        의상 costume = new 의상();
        String[][] firstClothes = {
                {"yellow_hat", "headgear"},
                {"blue_sunglasses", "eyewear"},
                {"green_turban", "headgear"}};
        System.out.println("Result: " + costume.solution(firstClothes));

        String[][] secondClothes = {
                {"crow_mask", "face"},
                {"blue_sunglasses", "face"},
                {"smoky_makeup", "face"}};
        System.out.println("Result: " + costume.solution(secondClothes));
    }
}
