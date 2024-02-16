import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Main {
	
	public static void main(String[] args) throws IOException {

		// T 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		while (T-- > 0) {
			
			// N, mbti 초기화
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			String[] mbti = new String[N];
			
			for (int i = 0; i < N; i++) {
				mbti[i] = st.nextToken();
			}
			
			
			// 32명이 넘은 경우
			if (N > 32) {
				System.out.println(0);
				continue;
			}
			
			
			// 가장 가까운 세 사람의 거리 구하기
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				for (int j = i+1; j < N; j++) {
					for (int k = j+1; k < N; k++) {
						min = Math.min(min, getPsychologicalDistance(new String[] {mbti[i], mbti[j], mbti[k]}));
					}
				}
			}
			
			System.out.println(min);
		}
		
		
		
	}

	// 30분 + 20분시작
	private static int getPsychologicalDistance(String[] mbti) {
		
		int E = 0, I = 0, N = 0, F = 0, T = 0, S = 0, P = 0, J = 0;
		
		for (int i = 0; i < mbti.length; i++) {
			
			// E/I 판단
			if (mbti[i].charAt(0) == 'E') {
				E++;
			} else {
				I++;
			}
			
			// N/S 판단
			if (mbti[i].charAt(1) == 'N') {
				N++;
			} else {
				S++;
			}
			
			// T/F 판단
			if (mbti[i].charAt(2) == 'T') {
				T++;
			} else {
				F++;
			}
			
			// P/J 판단
			if (mbti[i].charAt(3) == 'P') {
				P++;
			} else {
				J++;
			}
		}

		return E * I + N * S + T * F + P * J;
		
	}
}