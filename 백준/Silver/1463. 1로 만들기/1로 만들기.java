import java.util.*;
import java.io.*;

class Main {
		
	public static void main(String[] args) throws IOException {
		
		// n 초기화
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		
		// dp 초기화
		int[] dp = new int[n+1];
		
		// n을 만들 수 있는 최소 회수 구하기
		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i-1] + 1;
			if (i % 2 == 0) {
				dp[i] = Math.min(dp[i],  dp[i/2] + 1);	
			}
			
			if (i % 3 == 0) {
				dp[i] = Math.min(dp[i],  dp[i/3] + 1);
			}
		}

		System.out.println(dp[n]);
	}
	
}