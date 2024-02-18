package algorithm.week5;

import java.util.ArrayList;
import java.util.List;

public class 모음사전 {

    /**
     * [ 문제 설명 ]
     * 사전에 알파벳 모음 'A', 'E', 'I', 'O', 'U'만을 사용하여 만들 수 있는, 길이 5 이하의 모든 단어가 수록되어 있습니다.
     * 사전에서 첫 번째 단어는 "A"이고, 그다음은 "AA"이며, 마지막 단어는 "UUUUU"입니다.
     * 단어 하나 word가 매개변수로 주어질 때, 이 단어가 사전에서 몇 번째 단어인지 return 하도록 solution 함수를 완성해주세요.
     */

    /**
     * [ 제한 사항 ]
     * word의 길이는 1 이상 5 이하입니다.
     * word는 알파벳 대문자 'A', 'E', 'I', 'O', 'U'로만 이루어져 있습니다.
     */

    /**
     * [ 문제 풀이 흐름 ]
     * 1. 'A', 'E', 'I', 'O', 'U' 각 문자에 대해 1부터 5까지의 길이를 가질 수 있는 모든 조합을 생성합니다.
     * 2. 이 조합을 사전 순으로 정렬합니다.
     * 3. 정렬된 조합에서 주어진 단어가 몇 번째에 위치하는지를 찾습니다.
     */
    String[] vowels = {"A", "E", "I", "O", "U"};
    List<String> dictionary = new ArrayList<>();

    public int exhaustiveSearchSolution(String word) {
        // TODO: 재귀함수를 사용하면 쉽게 구할 수 있지만, 아직 재귀함수에 대한 이해도가 부족한 것 같다. 다시 한 번 풀어보자.
        int answer = 0;
        recursion("", 0);

        for (int i = 0; i < dictionary.size(); i++) {
            if (dictionary.get(i).equals(word)) {
                answer = i;
                break;
            }
        }
        return answer;
    }

    private void recursion(String answer, int length) {
        dictionary.add(answer);

        if (length == 5) return;

        for (int i = 0; i < vowels.length; i++) {
            recursion(answer + vowels[i], length + 1);
        }
    }



    public int countingOrWeightSolution(String word) {
        String vowels = "AEIOU";
        int[] weights = {781, 156, 31, 6, 1};
        int answer = 0;

        for (int i = 0; i < word.length(); i++) {
            answer += vowels.indexOf(word.charAt(i)) * weights[i] + 1;
        }
        return answer;
    }

    public static void main(String[] args) {
        모음사전 vowelDictionary = new 모음사전();
        System.out.println("Result: " + vowelDictionary.exhaustiveSearchSolution("AAAAE"));
        System.out.println("Result: " + vowelDictionary.exhaustiveSearchSolution("AAAE"));
        System.out.println("Result: " + vowelDictionary.exhaustiveSearchSolution("I"));
        System.out.println("Result: " + vowelDictionary.exhaustiveSearchSolution("EIO"));
    }
}
