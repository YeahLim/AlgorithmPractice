import java.util.*;
import java.io.*;

class Main {
	
	static List<Integer>[] graph;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		
		// N 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 정점의 개수
		
		// array, sortedArray 초기화
		int[] array = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Set<Integer> set = new HashSet<>();
		List<Integer> sortedArray = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
			
			if (!set.contains(array[i])) {
				set.add(array[i]);
				sortedArray.add(array[i]);
			}
		}

		
		
		// 좌표 찾기
		Collections.sort(sortedArray); // 오름차순 정렬
		int num = 0; // 좌표
		
		Map<Integer, Integer> map = new HashMap<>();
		
		for (int a : sortedArray) {
			map.put(a, num);
			num++;
		}
		
		
		// 좌표 적용
		StringBuilder sb = new StringBuilder();
		for (int a : array) {
			sb.append(map.get(a)).append(" ");
		}
		
		System.out.println(sb);
		
	}

}