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
		
		while (right < N && answer != M) {
			
			// M보다 작을 경우
			if (diff < M) {
                right++;
            } 
            // M보다 클 경우
            else if (diff > M) {
               left++;
            }
            
            if (right == N) {
                break;
            }
             
            diff = array[right] - array[left];
            answer = getClosest(answer, diff);
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

