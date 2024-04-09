import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int[][] paper;
	static List<Coordinate> cheeseList = new ArrayList<>();
	static final int CHEESE = 1;
	static boolean[][] visited;
	static boolean[][] outside;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		
		// N, K, cheese 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		paper = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
				
				if (paper[i][j] == CHEESE) {
					cheeseList.add(new Coordinate(i, j));
				}
			}
		}
		
		// 치즈에 둘러쌓였는지 확인
		System.out.println(getMeltedTime());
	}

	private static int getMeltedTime() {
		
		int time = 0;
		
		while (!cheeseList.isEmpty()) {

			// 치즈 외/내부인지 확인
			visited = new boolean[N][M];
			outside = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				if (!visited[i][0] && paper[i][0] != CHEESE) {
					visited[i][0] = true;
					searchInOrOutSide(new Coordinate(i, 0));
				}
			}
			for (int j = 0; j < M; j++) {	
				if (!visited[0][j] && paper[0][j] != CHEESE) {
					visited[0][j] = true;
					searchInOrOutSide(new Coordinate(0, j));
				}
			}
			
//			printOutside();
			
			// 치즈 녹히기
			for (int i = cheeseList.size() - 1; i >= 0; i--) {
				Coordinate cheese = cheeseList.get(i);
				
				if (checkMeltedCheese(cheese)) {
					paper[cheese.x][cheese.y] = 0;
					cheeseList.remove(i);
				}
			}
			
			time++;
			
//			printPaper();
		}		
		
		return time;
	}

	private static void printOutside() {
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				
				if (outside[i][j]) {
					System.out.print("O ");
				}
				
				else
					System.out.print("X ");
			}
			System.out.println();
		}
		
	}

	private static void printPaper() {
		
		System.out.println("치즈리스트 사이즈 : " + cheeseList.size());
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(paper[i][j] +  " ");
			}
			System.out.println();
		}
		
	}

	private static void searchInOrOutSide(Coordinate coordinate) {
		
		Queue<Coordinate> q = new LinkedList<>();
		q.offer(coordinate);
		
		while (!q.isEmpty()) {
			Coordinate curr = q.poll();
			
			outside[curr.x][curr.y] = true;
			
			for (int i = 0; i < dx.length; i++) {
				int nx = dx[i] + curr.x;
				int ny = dy[i] + curr.y;
				
				if (nx < 0 || nx >= N || ny < 0 || ny >= M ) {
					continue;
				}
				
				if (visited[nx][ny] || paper[nx][ny] == CHEESE) {
					continue;
				}
				
				visited[nx][ny] = true;
				q.offer(new Coordinate(nx, ny));
			}
		}
		
		
	}

	private static boolean checkMeltedCheese(Coordinate cheese) {
		
		int outsideCount = 0;
		for (int i = 0; i < dx.length; i++) {
			int nx = dx[i] + cheese.x;
			int ny = dy[i] + cheese.y;
			
			if (nx < 0 || nx >= N || ny < 0 || ny >= M ) {
				continue;
			}
			
			if (outside[nx][ny]) {
				outsideCount++;
			}
		}
		
		if (outsideCount >= 2) {
			return true;
		}
		
		return false;
	}



}

class Coordinate {
	
	int x, y;
	
	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}
}