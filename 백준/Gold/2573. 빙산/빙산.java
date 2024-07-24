import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int[][] berg;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	static boolean[][] visited;
	static int time = 0;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		berg = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				berg[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while (true) {
			
			time++;
			berg = meltedBerg();
			
//			printBerg();
			
			if (checkSplitedBurg() || checkMeltedAll()) {
				break;
			}
		}

		System.out.println(time);
	}

	private static boolean checkMeltedAll() {
		
		boolean meltedAll = true;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (berg[i][j] > 0) {
					meltedAll = false;
				}
			}
		}
		
		if (meltedAll) {
			time = 0;	
		}
		return meltedAll;
	}

	private static void printBerg() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				
				if (berg[i][j] < 0) {
					System.out.print(0 + " ");
				}
				else
					System.out.print(berg[i][j] +" ");
				
			}
			System.out.println();
		}
		System.out.println("------------");
	}

	private static boolean checkSplitedBurg() {
		
		visited = new boolean[N][M];
		
		int splited = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j] && berg[i][j] > 0) {
					searchBerg(i, j);
					splited++;
				}
			}
		}
		
		return splited > 1;
	}

	private static void searchBerg(int x, int y) {
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x, y});
		visited[x][y] = true;
		
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			
			for (int i = 0; i < dx.length; i++) {
				int nx = dx[i] + curr[0];
				int ny = dy[i] + curr[1];
				
				if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny]) {
					continue;
				}
				
				if (berg[nx][ny] > 0) {
					q.add(new int[] {nx, ny});
					visited[nx][ny] = true;
				}
				
			}
			
		}
		
	}

	private static int[][] meltedBerg() {
		
		int[][] newBerg = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (berg[i][j] > 0) {
					newBerg[i][j] = berg[i][j] - checkMelted(i, j);
				}
			}
		}
		
		return newBerg;
	}

	private static int checkMelted(int x, int y) {		
		int count = 0;
		for (int i = 0; i < dx.length; i++) {
			int nx = dx[i] + x;
			int ny = dy[i] + y;
			
			if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
				continue;
			}
			
			if (berg[nx][ny] <= 0) {
				count++;
			}
		}
		
		return count;
	}

}
