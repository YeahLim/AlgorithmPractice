import java.util.*;
import java.io.*;

class Main {
		
	public static void main(String[] args) throws IOException {
		
		// N, M 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] info = br.readLine().split(" ");
		int N = Integer.parseInt(info[0]);
		int M = Integer.parseInt(info[1]);
		
		// map 초기화
		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String infor = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = infor.charAt(j) - '0';
			}
		} 
		
		// 방향배열, 방문여부 초기화
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		boolean[][] visited = new boolean[N][M];
		
		// queue 초기화
		Queue<Node> q = new LinkedList<>();
		
		
		// bfs로 최단 거리 구하기
		q.offer(new Node(0, 0, 1));
		visited[0][0] = true;
		
		while (!q.isEmpty()) {
			Node curr = q.poll();
			
			if (curr.x == N - 1 && curr.y == M - 1) {
				System.out.println(curr.count);
				break;
			}
			
			for (int i = 0; i < dx.length; i++) {
				int nx = dx[i] + curr.x;
				int ny = dy[i] + curr.y;
				
				if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
					continue;
				}
				
				if (visited[nx][ny] || map[nx][ny] == 0) {
					continue;
				}
				
				visited[nx][ny] = true;
				q.offer(new Node(nx, ny, curr.count + 1));
			}
		}
		
	}
	
}


class Node {
	int x, y;
	int count;
	
	public Node(int x, int y, int count) {
		this.x = x;
		this.y = y;
		this.count = count;
	}

	@Override
	public String toString() {
		return "Node [x=" + x + ", y=" + y + ", count=" + count + "]";
	}
	
	
}