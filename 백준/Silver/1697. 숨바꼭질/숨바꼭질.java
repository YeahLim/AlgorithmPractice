import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException {
		
		// N, K 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] info = br.readLine().split(" ");
		int N =  Integer.parseInt(info[0]); // 수빈이의 위치
		int K =  Integer.parseInt(info[1]); // 동생의 위치
		
//		// K를 더 큰 수로 두기
//		if (N > K) {
//			int tmp = N;
//			N = K;
//			K = tmp;
//		}
		
		// N에서 K까지 걸리는 시간 구하기
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(N, 0));
		boolean[] visited = new boolean[100_001];
		visited[N] = true;
		
		while(!q.isEmpty()) {
			Node curr = q.poll();
			
			if (curr.location == K) {
				System.out.println(curr.time);
				break;
			}
			
			if (curr.location - 1 >= 0 && !visited[curr.location - 1]) {
				visited[curr.location - 1] = true;
				q.offer(new Node(curr.location - 1, curr.time+1));
			}
			
			if (curr.location + 1 < 100_001 && !visited[curr.location + 1]) {
				visited[curr.location + 1] = true;
				q.offer(new Node(curr.location + 1, curr.time+1));
			}
			
			if (curr.location * 2 < 100_001 && !visited[curr.location * 2]) {
				visited[curr.location * 2] = true;
				q.offer(new Node(curr.location * 2, curr.time+1));
			}
			
		}

	}


}

class Node{
	int location, time;
	
	public Node(int location, int time) {
		this.location = location;
		this.time = time;
	}
}