import java.util.*;
import java.io.*;


class Main {
	
	static int M; 
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nm = br.readLine().split(" ");
		int N = Integer.parseInt(nm[0]);
		M = Integer.parseInt(nm[1]);
		int[] array = new int[N];

		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(array);
		
		int left = 0;
		int right = 0;
		int diff = array[right] - array[left];
		int answer = diff;
		
		while (left <= right) {
			
			// M보다 작을 경우
			while (diff < M && ++right < N) {
				diff = array[right] - array[left];
				answer = getClosest(answer, diff);
//				System.out.println("<2> diff : " + diff + " answer : " + answer);
			}
			
			if (right == N || answer == M) {
				break;
			}
			
			// M보다 클 경우
			while (diff > M && ++left < N) {
				diff = array[right] - array[left];
				answer = getClosest(answer, diff);
//				System.out.println("<3> diff : " + diff + " answer : " + answer);
			}
			
			if (left == N || answer == M) {
				break;
			}
			
		}
		
		System.out.println(answer);
	}
	
	static private int getClosest(int answer, int diff) {
		if(diff < M || Math.abs(M - diff) > Math.abs(M - answer)) {
			return answer;
		}
		return diff;
	}
}

