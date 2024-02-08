import java.io.*;
import java.util.*;

class Main {
	
	public static void main(String[] args) throws IOException {

		// N, M 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// map에 '사이트-비밀번호' 저장
		Map<String, String> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			map.put(st.nextToken(), st.nextToken());
		}
		
		// 찾으려는 사이트의 비밀번호 출력
		for (int i = 0; i < M; i++) {
			System.out.println(map.get(br.readLine()));
		}
		
	}


}