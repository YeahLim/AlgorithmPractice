import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int[] house;
	static int answer = 1;
	
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int C = sc.nextInt();
		
		house = new int[N];
		for (int i = 0; i < N; i++) {
			house[i] = Integer.parseInt(sc.next());
		}
		Arrays.sort(house);
		
		int start = 0;
		int end = house[N-1];
		
		while (start <= end) {
			int mid = (start + end) / 2;
			
			if (checkInstall(mid) >= C){
				start = mid + 1;
				answer = mid;
			}
			else {
				end = mid - 1;
			}
		}
		
		System.out.println(answer);
	}

	private static int checkInstall(int dist) {
		
		int count = 1;
		int lastInstalledHouse = house[0];
		
		for (int i = 1; i < house.length; i++) {
			if (house[i] - lastInstalledHouse >= dist) {
				count++;
				lastInstalledHouse = house[i];
			}
			// 모든 집에 반드시 설치되어야하는 것이 아니므로
//			else {
//				break;
//			}
		}
		
		return count;
	}

}
