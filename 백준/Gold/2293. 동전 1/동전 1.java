import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int[] coin = new int[N+1];
		for (int i = 1; i <= N; i++) {
			coin[i] = sc.nextInt();
		}
		
		int[] dp = new int[K+1];
		dp[0] = 1;
		
		for (int i = 1; i <= N; i++) {
			for (int j = coin[i]; j <= K; j++) {
				dp[j] += dp[j - coin[i]];	
			}
		}
		
		
		System.out.println(dp[K]);
	}
}