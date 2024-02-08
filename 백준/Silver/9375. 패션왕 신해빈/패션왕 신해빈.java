import java.io.*;
import java.util.*;

class Main {
	
	static int N;
	static Map<String, Integer> map;
	
	public static void main(String[] args) throws IOException {

		// tc 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		while (tc-- > 0) {
			
			// N, map 초기화
			N = Integer.parseInt(br.readLine());
			map = new HashMap<>();
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String clothes = st.nextToken();
				String type = st.nextToken();
				map.put(type, map.getOrDefault(type, 1) + 1);
			}
			
			
			// 입을 수 있는 경우의 수 구하기
			int answer = 1;
			
			for (String type : map.keySet()) {
				answer *= map.get(type);
				
			}
			
			System.out.println(answer - 1);
		}
		
	}


}