import java.io.*;
import java.util.*;

class Main {
	
	public static void main(String[] args) throws IOException {

		// N, M, tree, min, max 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] tree = new int[N];
		st = new StringTokenizer(br.readLine());
		
		int min = 0;
		int max = 0;
		
		for (int i = 0; i < N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
	
			if (max < tree[i]) {
				max = tree[i];
			}
		}
		
		
		// 절단기에 설정할 최대 높이값 구하기
		while (min <= max) {
			
			int mid = (min + max) / 2;
			
			long total = 0;
			for (int tr : tree) {
				
				if (tr > mid) {
					total += tr - mid;
				}
			}
			
			// 더 적은 양의 나무가 필요할 떄
			if (total >= M) {
				min = mid + 1;
			}
			
			// 더 많은 양의 나무가 필요할 때
			else {
				max = mid - 1;
			}
		}
		
		System.out.println(max);
	}

}