import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int[] coins = new int[N];
		for (int i = 0; i < N; i++) {
			coins[i] = Integer.parseInt(sc.next());
		}
		Arrays.sort(coins);		
	
		int[] dp = new int[K+1];
		Arrays.fill(dp, 1000001);
		dp[0] = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = coins[i]; j <= K; j++) {
				dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
			}
		}
		
		System.out.println(dp[K] == 1000001 ? -1 : dp[K]);
	}

}
