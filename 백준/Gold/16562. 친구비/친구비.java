import java.util.*;
import java.io.*;

// 6 :35
class Main {
	
	static int[] friend;
	static int[] fee;

	public static void main(String[] args) throws IOException {
		
		// 입력 및 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		fee = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			fee[i] = Integer.parseInt(st.nextToken());
		}
		
		friend = new int[N];
		for (int i = 0; i < N; i++) {
			friend[i] = i;
		}
		
		
		// 친구의 친구 구하기
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			
			union(a, b);
		}
		
		// 친구비 내기
		int currFee = 0;
		boolean[] isFriend = new boolean[N];
		for (int i = 0; i < N; i++) {
			
			int currParent = findParent(i);
			
			if (isFriend[currParent]) {
				continue;
			}
			isFriend[currParent] = true;
			currFee += fee[currParent];
		}
		
		if (K < currFee) {
			System.out.println("Oh no");
			return;
		}
		System.out.println(currFee);
	}
	
	private static void union(int a, int b) {
		int parentA = findParent(a);
		int parentB = findParent(b);
		
		if (parentA == parentB) {
			return;
		}
		
		if (fee[parentA] > fee[parentB]) {
			friend[parentA] = parentB;
		}
		else {
			friend[parentB] = parentA;
		}
		
	}

	private static int findParent(int node) {
		if (friend[node] == node) {
			return node;
		}
		friend[node] =  findParent(friend[node]);
		return friend[node];
	}
	
}