import java.util.*;
import java.io.*;

class Main {
	
	static int N, M;
	static int[] array;
	static List<String> list;
	
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
		Arrays.sort(array);
		
		// 수열 구하기
//		set = new HashSet<>();
		list = new ArrayList<>();
		permutation(0, new boolean[N], new int[M]);
		
		
		// 오름차순 정렬
//		List<int[]> list = new ArrayList<>(set);
//		Collections.sort(list, (a, b) -> {
//			if (a[0] == b[0]) {
//				return a[1] - b[1];
//			}
//			return a[0] - b[0];
//		}); 
		
		
		// 출력
		for (String arr : list) {
			System.out.println(arr);
//			for (int a : arr) {
//				System.out.print(a + " ");
//			}
//			System.out.println();
		}
		
	}

	private static void permutation(int count, boolean[] visited, int[] temp) {
		
		if (count == M) {
			
			String str = "";
			for (int n : temp) {
				str += n + " ";
			}
			list.add(str);
			
			return;
		}
		
	
		int before = 0;
		for (int i = 0; i < array.length; i++) {
			
			if (visited[i] || before == array[i]) {
				continue;
			}
			
			visited[i] = true;
			
			temp[count] = array[i]; 
			before = array[i];
			permutation(count+1, visited, temp);
			
			visited[i] = false;
		}
		
	}

}