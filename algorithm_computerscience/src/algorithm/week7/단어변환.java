package algorithm.week7;

import java.util.Deque;
import java.util.LinkedList;

public class 단어변환 {

    /**
     * [ 문제 설명 ]
     * 두 개의 단어 begin, target과 단어의 집합 words가 있습니다.
     * 아래와 같은 규칙을 이용하여 begin에서 target으로 변환하는 가장 짧은 변환 과정을 찾으려고 합니다.
     * 1. 한 번에 한 개의 알파벳만 바꿀 수 있습니다.
     * 2. words에 있는 단어로만 변환할 수 있습니다.
     * 예를 들어 begin이 "hit", target가 "cog", words가 ["hot","dot","dog","lot","log","cog"]라면
     * "hit" -> "hot" -> "dot" -> "dog" -> "cog"와 같이 4단계를 거쳐 변환할 수 있습니다.
     * 두 개의 단어 begin, target과 단어의 집합 words가 매개변수로 주어질 때,
     * 최소 몇 단계의 과정을 거쳐 begin을 target으로 변환할 수 있는지 return 하도록 solution 함수를 작성해주세요.
     */

    /**
     * [ 제한 사항 ]
     * 각 단어는 알파벳 소문자로만 이루어져 있습니다.
     * 각 단어의 길이는 3 이상 10 이하이며 모든 단어의 길이는 같습니다.
     * words에는 3개 이상 50개 이하의 단어가 있으며 중복되는 단어는 없습니다.
     * begin과 target은 같지 않습니다.
     * 변환할 수 없는 경우에는 0를 return 합니다.
     */

    /**
     * [ BFS 문제 풀이 흐름 ]
     * 먼저, begin 단어를 시작 노드로 하여 BFS를 시작합니다.
         * 이때, 각 노드는 단어를 나타내며, 노드 간의 연결은 한 단어에서 다른 단어로 변환할 수 있는지를 나타냅니다.
     * BFS를 수행하는 동안, 각 단계에서 가능한 모든 변환을 확인합니다.
         * 이때, 변환은 한 단어에서 한 문자만 바꿔서 words 집합에 있는 다른 단어로 가는 것을 의미합니다.
     * 만약 변환한 단어가 목표 단어 target와 같다면, BFS를 종료하고 현재까지의 단계 수를 반환합니다.
         * 이는 begin에서 target으로 가는 가장 짧은 변환 과정을 나타냅니다.
     * 만약 BFS가 끝나도 목표 단어를 찾지 못했다면, 변환할 수 없는 경우이므로 0을 반환합니다.
     */
    static class WordNode {
        String word;
        int count;

        WordNode(String word,
                 int count) {
            this.word = word;
            this.count = count;
        }
    }

    public int solution(String begin, String target, String[] words) {
        // TODO: 문제 다시 한 번 더 풀어보기.
        boolean[] visited = new boolean[words.length];
        Deque<WordNode> deque = new LinkedList<>();
        deque.offerLast(new WordNode(begin, 0));

        while (!deque.isEmpty()) {
            WordNode current = deque.pollFirst();
            if (current.word.equals(target)) {
                return current.count;
            }

            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && isConvertible(current.word, words[i])) {
                    visited[i] = true;
                    deque.offerLast(new WordNode(words[i], current.count + 1));
                }
            }
        }
        return 0;
    }

    private boolean isConvertible(String word1, String word2) {
        int count = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                count++;
            }
        }
        return count == 1;
    }

    public static void main(String[] args) {
        단어변환 wordTransformation = new 단어변환();
        String[] firstWords = {"hot", "dot", "dog", "lot", "log", "cog"};
        System.out.println("Result: " + wordTransformation.solution("hit", "cog", firstWords));

        String[] secondWords = {"hot", "dot", "dog", "lot", "log"};
        System.out.println("Result: " + wordTransformation.solution("hit", "cog", secondWords));
    }
}
