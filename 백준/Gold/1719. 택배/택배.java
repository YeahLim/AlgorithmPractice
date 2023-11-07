import java.util.*;
import java.io.*;

// 첫번째 경우지면 자기자신 집어넣고, 아니면 현재의 것 집어넣기
// 6:17
class Main {
	
	static int N, M;
	static List<Node>[] graph;
	
	public static void main(String[] args) throws IOException {
		
		// 입력 및 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new List[N+1];
		for (int i = 0; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph[a].add(new Node(b, c));
			graph[b].add(new Node(a, c));
		}
		
		
		// 다익스트라로 최단 경로의 첫번째 경유지 구하기
		int[][] layover = new int[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			layover[i] = djikstra(i);
		}
		
		// 출력
		StringBuilder answer = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i == j) {
					answer.append("-");
				}
				else {
					answer.append(layover[i][j]);
				}
				answer.append(" ");
			}
			answer.append("\n");
		}
		System.out.println(answer);
		
	}

	private static int[] djikstra(int start) {
		int[] dist = new int[N+1];
		Arrays.fill(dist,  1000 * 10000 + 1);
		dist[start] = 0;
		boolean[] visited = new boolean[N+1];
		Queue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0, 0));
		int[] layover = new int[N+1];
		
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			
			if (visited[curr.to]) {
				continue;
			}
			
			visited[curr.to] = true;
			
		
			for (Node next : graph[curr.to]) {
				if (dist[next.to] > dist[curr.to] + next.cost) {
					dist[next.to] = dist[curr.to] + next.cost;
					
//					System.out.println("next " + next.toString());
					
					if (curr.layover == 0) {
						pq.offer(new Node(next.to, dist[next.to], next.to));
						layover[next.to] = next.to;
					}
					else {
						pq.offer(new Node(next.to, dist[next.to], curr.layover));
						layover[next.to] = curr.layover;
					}
				}
			}
		}
		return layover;
	}
	
	
}

class Node implements Comparable<Node> {
	int to;
	int cost;
	int layover;
	
	public Node(int to, int cost) {
		this.to = to;
		this.cost = cost;
	}

	public Node(int to, int cost, int layover) {
		this.to = to;
		this.cost = cost;
		this.layover = layover;
	}
	
	@Override
	public int compareTo(Node o) {
		return this.cost - o.cost;
	}

	@Override
	public String toString() {
		return "Node [to=" + to + ", cost=" + cost + ", layover=" + layover + "]";
	}
	
	
}