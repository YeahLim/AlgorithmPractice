import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	
	public static void main(String[] args) throws IOException {
		
		// 변수 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] array = new int[N+1][M+1];
	
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		// 누적합 구하기
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				array[i][j] += array[i-1][j] + array[i][j-1] - array[i-1][j-1];
			}
		}
		
		
		// 배열의 합 구하기
		int K = Integer.parseInt(br.readLine());
		while (K-- > 0) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			System.out.println(array[x][y] - array[i-1][y] - array[x][j-1] + array[i-1][j-1]);
		}
		
	}
}