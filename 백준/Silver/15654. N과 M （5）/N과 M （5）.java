import java.util.*;
import java.io.*;

class Main {
	
	static int N, M;
	static int[] array;
	static StringBuilder answer;
	
	public static void main(String[] args) throws IOException {
		
		// N, M 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());


		// array 초기화
		array = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(array); // 오름차순 정렬
		
		
		// 수열 구하기
		answer = new StringBuilder();
		permutation(0, new boolean[N], new int[M]);

		System.out.println(answer);
	}

	private static void permutation(int count, boolean[] visited, int[] temp) {
		
		if (count == M) {
			
			for (int n : temp) {
				answer.append(n).append(" ");
			}
			answer.append("\n");
			
			return;
		}
		
	
		for (int i = 0; i < array.length; i++) {
			
			if (visited[i]) {
				continue;
			}
			
			temp[count] = array[i]; 
			visited[i] = true;
			
			permutation(count+1, visited, temp);
			
			visited[i] = false;
		}
		
	}

}