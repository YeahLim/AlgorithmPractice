import java.util.*;
import java.io.*;

// 6 :35
class Main {
	

	public static void main(String[] args) throws IOException {
		
		// 입력 및 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		final int LION = 1;
		
		List<Integer> lions = new ArrayList<>();
		int[] toys = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			toys[i] = Integer.parseInt(st.nextToken());
			if (toys[i] == LION) {
				lions.add(i);
			}
		}
		
		if (lions.size() < K) {
			System.out.println(-1);
			return;
		}
		
		
		int start = 0;
		int end = K - 1;
		int answer = lions.get(end) - lions.get(start) + 1;
		while (true) {
			start++;
			end++;
			if (end == lions.size()) {
				break;
			}
			answer = Math.min(lions.get(end) - lions.get(start) + 1, answer);
		}
		
		System.out.println(answer);
	}

	
	
}