package algorithm.week8;

import java.util.*;

public class 여행경로 {

    /**
     * [ 문제 설명 ]
     * 주어진 항공권을 모두 이용하여 여행경로를 짜려고 합니다. 항상 "ICN" 공항에서 출발합니다.
     * 항공권 정보가 담긴 2차원 배열 tickets가 매개변수로 주어질 때, 방문하는 공항 경로를 배열에 담아 return 하도록 solution 함수를 작성해주세요.
     */

    /**
     * [ 제한 사항 ]
     * 모든 공항은 알파벳 대문자 3글자로 이루어집니다.
     * 주어진 공항 수는 3개 이상 10,000개 이하입니다.
     * tickets의 각 행 [a, b]는 a 공항에서 b 공항으로 가는 항공권이 있다는 의미입니다.
     * 주어진 항공권은 모두 사용해야 합니다.
     * 만일 가능한 경로가 2개 이상일 경우 알파벳 순서가 앞서는 경로를 return 합니다.
     * 모든 도시를 방문할 수 없는 경우는 주어지지 않습니다.
     */
    List<String> answer;
    Map<String, PriorityQueue<String>> graph;

    public String[] solution(String[][] tickets) {
        // TODO: 문제 흐름은 이해했지만, 아직 DFS를 구현하는 능력이 많이 미숙하다. 많은 문제들을 더 풀어보자.
        answer = new ArrayList<>();
        graph = new HashMap<>();

        for (String[] ticket : tickets) {
            graph.putIfAbsent(ticket[0], new PriorityQueue<>());
            graph.get(ticket[0]).offer(ticket[1]);
        }

        dfs("ICN");
        Collections.reverse(answer);
        return answer.toArray(new String[0]);
    }

    public void dfs(String node) {
        PriorityQueue<String> edges = graph.get(node);

        while (edges != null && !edges.isEmpty()) {
            dfs(edges.poll());
        }
        answer.add(node);
    }

    public static void main(String[] args) {
        여행경로 travelItinerary = new 여행경로();
        String[][] firstTickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        System.out.println("firstTickets = " + Arrays.toString(travelItinerary.solution(firstTickets)));

        String[][] secondTickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
        System.out.println("secondTickets = " + Arrays.toString(travelItinerary.solution(secondTickets)));
    }
}
