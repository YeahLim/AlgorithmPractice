import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static int N;
	static char[][] colors;
	static boolean[][][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		colors = new char[N][N];
		
		for (int i = 0; i < N; i++) {
			String info = br.readLine();
			for (int j = 0; j < N; j++) {
				colors[i][j] = info.charAt(j);
			}
		}
		
		
		visited = new boolean[N][N][2];
		int countArea = 0;
		int countAreaBlindness = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				
				if (!visited[i][j][0]) {
					searchColors(i, j);
					countArea++;
				}
				
				if (!visited[i][j][1]) {
					searchColorBlindness(i, j);
					countAreaBlindness++;
				}
			}
		}
		
		System.out.println(countArea + " " + countAreaBlindness);
		
	}

	private static void searchColors(int x, int y) {
		
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x, y});
		
		visited[x][y][0] = true;
		
		char color = colors[x][y];
		
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			
			for (int i = 0; i < dx.length; i++) {
				int nx = curr[0] + dx[i];
				int ny = curr[1] + dy[i];
				
				if (checkBoundary(nx, ny) || visited[nx][ny][0]) {
					continue;
				}
				
				if (colors[nx][ny] == color) {
					visited[nx][ny][0] = true;
					q.offer(new int[] {nx, ny});
				}
			}
		}
		
	}
	
	private static void searchColorBlindness(int x, int y) {
		
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x, y});
		
		visited[x][y][1] = true;
		
		char color = colors[x][y];
		boolean blue = true;
		
		if (color != 'B') {
			blue = false;
		}
		
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			
			for (int i = 0; i < dx.length; i++) {
				int nx = curr[0] + dx[i];
				int ny = curr[1] + dy[i];
				
				if (checkBoundary(nx, ny) || visited[nx][ny][1]) {
					continue;
				}
				
				// Blue가 아닌 경우
				if (!blue && colors[nx][ny] != 'B') {
					visited[nx][ny][1] = true;
					q.offer(new int[] {nx, ny});
				}
				
				// Blue인 경우
				else if (blue && colors[nx][ny] == color) {
					visited[nx][ny][1] = true;
					q.offer(new int[] {nx, ny});
				}
			}
		}
		
	}

	private static boolean checkBoundary(int nx, int ny) {	
		return nx < 0 || nx >= N || ny < 0 || ny >= N;
	}


}
