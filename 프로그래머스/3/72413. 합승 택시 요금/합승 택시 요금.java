import java.util.*;

class Solution {
    int N; // 지점 개수
    int start;
    int A;
    int B;
    int E; // 길 개수
    List<List<Node>> graph;
    int INF = 200 * 100000 + 1;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        
        this.N = n;
        this.start = s;
        this.A = a;
        this.B = b;
        this.graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] fare : fares) {
            int c = fare[0];
            int d = fare[1];
            int f = fare[2];
            graph.get(c).add(new Node(d, f));
            graph.get(d).add(new Node(c, f));
        }
        
        int[] costA = new int[N+1];
        int[] costB = new int[N+1];
        int[] cost = new int[N+1];
        Arrays.fill(costA, INF);
        Arrays.fill(costB, INF);
        Arrays.fill(cost, INF);
        
        costA = djikstra(A, costA);
        costB = djikstra(B, costB);
        cost = djikstra(start, cost);
        
        
        int answer = Integer.MAX_VALUE;
        for(int i = 1; i <= N; i++) {
            System.out.println(costA[i] + costB[i] + cost[i]);
            answer = Math.min(answer, costA[i] + costB[i] + cost[i]);
        }
        return answer;
    }
    
    private int[] djikstra(int start, int[] costs) {
        boolean[] visited = new boolean[N+1];
        costs[start] = 0;
        Queue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        
        while (!pq.isEmpty()) {
            int curr = pq.poll().to;
            
            if (visited[curr]) {
                continue;
            }
            
            visited[curr] = true;
            
            for (Node next : graph.get(curr)) {

                if (costs[next.to] > costs[curr] + next.cost) {
                    costs[next.to] = costs[curr] + next.cost;
                    pq.offer(new Node(next.to, costs[next.to]));
                }
            }
        }
        return costs;
    }
}

class Node implements Comparable<Node> {
    int to;
    int cost;
    
    public Node(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }
    
    @Override
    public int compareTo(Node other) {
        return this.cost - other.cost;
    }
}