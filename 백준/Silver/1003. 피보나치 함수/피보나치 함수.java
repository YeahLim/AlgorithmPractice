import java.util.*;
import java.io.*;

class Main {
	
	
	public static void main(String[] args) throws IOException {
		
		// T, N, array 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int N = 0; // 최대값
		int[] array = new int[T];
		
		for (int i = 0; i < T; i++) {
			array[i] = Integer.parseInt(br.readLine());
			N = array[i] > N ? array[i] : N;
		}
		
		// 0, 1의 개수 구하기
		int[][] dp = new int[N+2][2];
		dp[0][0] = 1;
		dp[1][1] = 1;
		
		for (int i = 2; i <= N; i++) {
			dp[i][0] = dp[i-1][0] + dp[i-2][0];
			dp[i][1] = dp[i-1][1] + dp[i-2][1];
		}
		
		// 출력
		for (int i = 0; i < T; i++) {
			System.out.println(dp[array[i]][0] + " " + dp[array[i]][1]);
		}
	}

	
	

}