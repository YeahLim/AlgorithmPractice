import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] info = new int[N+2][2];
		
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			info[i][0] = Integer.parseInt(st.nextToken());
			info[i][1] = Integer.parseInt(st.nextToken());
		}
		
		
		int[] dp = new int[N+2];
		int max = -1;
		
		for(int i=1; i<= N+1; i++) {
			
			if(max < dp[i]) {
				max = dp[i];
			}
			
			int next = i + info[i][0];
			
			if(next < N+2) {
				dp[next] = Math.max(dp[next], max + info[i][1]);
			}
		}
		
		
		System.out.println(dp[N+1]);
	}

}
