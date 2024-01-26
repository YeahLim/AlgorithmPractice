import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException {
		
		// N 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// tree 초기화
		Node[] tree = new Node[N];
		
		for(int i = 0; i < N; i++) {
			String info = br.readLine();
			char value = info.charAt(0);
			char left = info.charAt(2);
			char right = info.charAt(4);
			
			// 루트 
			if (tree[value - 'A'] == null) {
				tree[value - 'A'] = new Node(value);	
			}
			
			// 왼쪽
			if (left != '.') {
				tree[left - 'A'] = new Node(left);
				tree[value - 'A'].left = tree[left - 'A'];
			}
			
			// 오른쪽
			if (right != '.') {
				tree[right - 'A'] = new Node(right);
				tree[value - 'A'].right = tree[right - 'A'];
			}
			
		}
		
		// 전위 순회
		preOrder(tree[0]);
		System.out.println();
		
		// 전위 순회
		inOrder(tree[0]);
		System.out.println();
		
		// 후위 순회
		postOrder(tree[0]);
		System.out.println();
		
	}

	
	private static void preOrder(Node node) {
		if (node == null) {
			return;
		}
		
		// 루트
		System.out.print(node.value);
		
		// 왼쪽
		preOrder(node.left);
		
		// 오른쪽
		preOrder(node.right);
		
	}

	
	private static void inOrder(Node node) {
		if (node == null) {
			return;
		}
		
		// 왼쪽
		inOrder(node.left);
		
		// 루트
		System.out.print(node.value);
		
		// 오른쪽
		inOrder(node.right);
		
	}

	
	private static void postOrder(Node node) {
		if (node == null) {
			return;
		}
		
		// 왼쪽
		postOrder(node.left);
		
		// 오른쪽
		postOrder(node.right);
		
		// 루트
		System.out.print(node.value);
		
	}



}

class Node {
	char value;
	Node left, right;
	
	public Node (char value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}
}