import java.io.*;
import java.util.*;

// 6:34
class Main {
	
    public static void main(String[] args) throws IOException {
    	
    	// 입력 및 초기화
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	List<List<Node>> graph = new ArrayList<>();
    	for (int i = 0; i <= N; i++) {
    		graph.add(new ArrayList<>());
    	}
    	for (int i = 0; i < M; i++) {
    		st = new StringTokenizer(br.readLine());
    		int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    		int c = Integer.parseInt(st.nextToken());
    		graph.get(a).add(new Node(b, c));
    		graph.get(b).add(new Node(a, c));
    	}
    	int[] dist = new int[N+1];
    	Arrays.fill(dist, Integer.MAX_VALUE);
    	
    	// 1에서 출발
    	dist[1] = 0;
    	boolean[] visited = new boolean[N+1];
    	PriorityQueue<Node> pq = new PriorityQueue<>();
    	pq.offer(new Node(1, 0));
    	
    	// 다익스트라
    	while (!pq.isEmpty()) {
    		Node curr = pq.poll();
    		
    		if (visited[curr.to]) {
    			continue;
    		}
    		
    		visited[curr.to] = true;
    		
    		for (Node next : graph.get(curr.to)) {
    			if (dist[next.to] > dist[curr.to] + next.cost) {
    				dist[next.to] = dist[curr.to] + next.cost; 
    				pq.offer(new Node(next.to, dist[next.to]));
    			}
    		}
    	}
    	
    	
    	System.out.println(dist[N]);
    }
    
}

class Node implements Comparable<Node> {
	int to; // 헛간
	int cost; // 여물
	
	public Node(int to, int cost) {
		this.to = to;
		this.cost = cost;
	}

	@Override
	public int compareTo(Node o) {
		return this.cost - o.cost;
	}
	
	
}