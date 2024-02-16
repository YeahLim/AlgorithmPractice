import java.io.*;
import java.util.*;

class Main {
	
	static int N;
	static int[][] map;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {

		// N, map, visited, count 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			String info = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = info.charAt(j) - '0';
			}
		}
		
		visited = new boolean[N][N];
		List<Integer> count = new ArrayList<>();
		
		
		// 단지 찾기
		int num = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				
				if (!visited[i][j] && map[i][j] != 0) {
					visited[i][j] = true;
					count.add(searchHouse(i, j, num));
					num++;
				}
			}
		}
		
		
		

		// 단지 수 오름차순 정렬
		Collections.sort(count);
		
		
		// 총 단지 수, 단지내 집의 수 출력
		System.out.println(count.size());
		for (int i = 0; i < count.size(); i++) {
			System.out.println(count.get(i));
		}
		
	}

	
	private static int searchHouse(int x, int y, int num) {
		
		Queue<Node> q = new LinkedList<>();
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		int count = 1;
		
		q.offer(new Node(x, y));
		
		while(!q.isEmpty()) {
			Node curr = q.poll();
			
			
			map[curr.x][curr.y] = num;
			
			
			for (int i = 0; i < dx.length; i++) {
				int nx = dx[i] + curr.x;
				int ny = dy[i] + curr.y;
				
				if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
					continue;
				}
				
				if (visited[nx][ny] || map[nx][ny] == 0) {
					continue;
				}
				
				visited[nx][ny] = true;
				count++;
				q.offer(new Node(nx, ny));
			}
			
		}
		
		return count;
	}

}


class Node {
	int x, y;
	
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}