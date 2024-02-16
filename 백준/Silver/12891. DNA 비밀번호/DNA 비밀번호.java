import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	static int S, P;
	static int A, C, G, T;
	static int[] dna;
	static int[] windowDna;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		S = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		
		String str = br.readLine();
		
		dna = new int[4];
		windowDna = new int[4];
		
		st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		dna[0] = A; dna[1] = C; dna[2] = G; dna[3] = T;
		
		int answer = 0;
		for (int i = 0; i < P; i++) {
			int idx = changeCharToIdx(str.charAt(i));
			windowDna[idx]++;
		}
		
		if (checkValidation()) {
			answer++;
		}
		
		for (int i = P; i < S; i++) {
			int idx = changeCharToIdx(str.charAt(i));
			windowDna[idx]++;
			
			int deleteIdx = changeCharToIdx(str.charAt(i - P));
			windowDna[deleteIdx]--;
			
			if (checkValidation()) {
				answer++;
			}
		}
		
		System.out.println(answer);
	}
	
	private static boolean checkValidation() {
		for (int i = 0; i < 4; i++) {
			if (windowDna[i] < dna[i]) {
				return false;
			}
		}
		return true;
	}
	
	private static int changeCharToIdx(char c) {
		if (c == 'A') return 0;
		if (c == 'C') return 1;
		if (c == 'G') return 2;
		return 3;
	}
}
