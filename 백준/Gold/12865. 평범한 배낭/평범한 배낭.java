import java.io.*;
import java.util.*;

class Main {
	
	public static void main(String[] args) throws IOException {

		// N, K 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		// dp 초기화
		int[][] dp = new int[N+1][K+1];
		
		for (int i = 1; i <= N; i++) {
			
			// weight, value 초기화
			st = new StringTokenizer(br.readLine());
			int weight = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
		
			for (int j = 1; j <= K; j++) {
				
				// weight를 j에 담을 수 없을 때
				if (weight > j) {
					dp[i][j] = dp[i-1][j];
				}
				
				// weight를 j에 담을 수 있을 때
				else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight] + value);
				}
			}
		}
		
		System.out.println(dp[N][K]);
	}


}