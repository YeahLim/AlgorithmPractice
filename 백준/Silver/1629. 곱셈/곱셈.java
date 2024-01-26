import java.util.*;
import java.io.*;

class Main {
	
	static int size;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		
		// A, B, C 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] info = br.readLine().split(" ");
		int A = Integer.parseInt(info[0]);
		int B = Integer.parseInt(info[1]);
		int C = Integer.parseInt(info[2]);
		
		System.out.println(pow(A, B, C));
	}

	private static long pow(int a, int b, int mod) {
		if (b == 0) {
			return 1;
		}
		
		
		long n = pow(a, b/2, mod); // 분할 계산
		
		// 짝수
		if (b % 2 == 0) {
			return n*n % mod;
		}
		
		// 홀수
		return ( n*n % mod ) * a % mod;
	}

}