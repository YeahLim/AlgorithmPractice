import java.io.*;
import java.util.*;

class Main {
	
	public static void main(String[] args) throws IOException {

		// N 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int N = Integer.parseInt(br.readLine());

		// 최소 개수의 제곱수 합 구하기
		int[] dp = new int[N+1];
		dp[1] = 1;
		
		for (int i = 1; i <= N; i++) {
			
			dp[i] = dp[i-1] + 1;
			
			for (int j = 1; j*j <= i; j++) {
				
				dp[i] = Math.min(dp[i], dp[i-j*j] + 1);
			}
			
		}
		
		System.out.println(dp[N]);
	}

}