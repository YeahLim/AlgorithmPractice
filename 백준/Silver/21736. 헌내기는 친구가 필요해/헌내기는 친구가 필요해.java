import java.io.*;
import java.util.*;

class Main {
	
	public static void main(String[] args) throws IOException {

		// N, M 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		String[] info = br.readLine().split(" ");
		int N = Integer.parseInt(info[0]);
		int M = Integer.parseInt(info[1]);
		
		
		// map, startX, startY 초기화
		char[][] map = new char[N][M];
		int startX = -1, startY = -1;
		
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j);
				
				if (map[i][j] == 'I') {
					startX = i;
					startY = j;
				}
			}
		}
		
		
		// 만날 수 있는 사람의 수 구하기
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		boolean[][] visited = new boolean[N][M];
		visited[startX][startY] = true;
		
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(startX, startY));
		
		int answer = 0;
		
		while(!q.isEmpty()) {
			Node curr = q.poll();
			
			for (int i = 0; i < dx.length; i++) {
				int nx = curr.x + dx[i];
				int ny = curr.y + dy[i];
				
				
				// 지나갈 수 없는 경우
				if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
					continue;
				}
				
				if (visited[nx][ny] || map[nx][ny] == 'X') {
					continue;
				}
				
				
				// 지나갈 수 있는 경우				
				visited[nx][ny] = true;
				
				if (map[nx][ny] == 'P') {
					answer++;
				}
				
				q.offer(new Node(nx, ny));
				
				}
			
		}
		
		System.out.println(answer == 0 ? "TT" : answer);
		
	}

}

class Node {
	int x, y;
	
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}