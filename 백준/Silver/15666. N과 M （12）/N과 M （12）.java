import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int[] nums;
	
	public static void main(String[] args) throws IOException {
		
		// N, M, array 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		// 비내림차순으로 수열구하기
		Arrays.sort(nums);
		searchArray(0, 0, new int[M]);
		
	}

	private static void searchArray(int depth, int index, int[] array) {
		
		if (depth == M) {

			if (checkAscendingArray(array)) {
				printArray(array);
			}
			
			return;
		}
		
		int before = 0;
		for (int i = index; i < N; i++) {
			// 중복 피하기
			if (before == nums[i]) {
				continue;
			}
			
			before = nums[i];
			array[depth] = nums[i];
			searchArray(depth+1, i, array);
		}
		
	}

	private static boolean checkAscendingArray(int[] array) {
		
		for (int i = 1; i < M; i++) {
			if (array[i] < array[i-1]) {
				return false;
			}
		}
		return true;
	}

	private static boolean checkDuplicatedArray(int[] array, int[] before) {		
	
		for (int i = 0; i < M; i++) {
			if (array[i] != before[i]) {
				return false;
			}
		}
		
		return true;
	}

	private static void printArray(int[] array) {
		
		for (int i = 0; i < M; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	
	
	
}