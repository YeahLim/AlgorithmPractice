import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		// 변수 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] mushroom = new int[11];
		for (int i = 1; i <= 10; i++) {
			mushroom[i] += Integer.parseInt(br.readLine()) + mushroom[i-1];
		}
		
		int min = Math.abs(mushroom[0] - 100);
		int score = 0;
		for (int i = 1; i <= 10; i++) {
			if (min >= Math.abs(mushroom[i] - 100)) {
				min = Math.min(min, Math.abs(mushroom[i] - 100));
				score = mushroom[i];
			}
			
	
		}
		
		System.out.println(score);
	}
}