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
		
		int[][] array = new int[N][M];
	
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		// 누적합 구하기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				
				if (i == 0 && j == 0) {
					continue;
				}
				
				if (i == 0) {
					array[i][j] += array[i][j-1];
				}
				
				else if (j == 0) {
					array[i][j] += array[i-1][j];
				}
				
				else {
					array[i][j] += array[i-1][j] + array[i][j-1] - array[i-1][j-1];
				}
				
			}
		}
		
		
		// 배열의 합 구하기
		int K = Integer.parseInt(br.readLine());
		while (K-- > 0) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken()) - 1;
			int j = Integer.parseInt(st.nextToken()) - 1;
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			
			int total = array[x][y];
			
			if (i >= 1) {
				total -= array[i-1][y];
			}
			
			if (j >= 1) {
				total -= array[x][j-1];
			}
			
			if (i >= 1 && j >= 1) {
				total += array[i-1][j-1];
			}
			
			System.out.println(total);
		}
		
	}
}