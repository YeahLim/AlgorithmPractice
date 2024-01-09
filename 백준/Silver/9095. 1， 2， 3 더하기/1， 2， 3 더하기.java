import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException {
		
		// N 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		// DP로 1,2,3으로 정수를 구할 수 있는 개수 찾기
		while (T-- > 0) {
			searchNum(Integer.parseInt(br.readLine()));	
		}
		
	}

	private static void searchNum(int num) {
		if (num < 3) {
			System.out.println(num);
			return;
		}
		
		// dp 초기화
		int[] dp = new int[num+1];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		for (int i = 4; i <= num; i++) {
			// i = (1 + i-1) + (2 + i-2) + (3 + i-3)
			dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
		}
		
		System.out.println(dp[num]);
	}
	
}