import java.util.*;

/***
*   전위 순회 : root -> left -> right
*   후위 순회 : left -> right -> root
*/

// 9:11
class Solution {
    
    List<Node> allNodes;
    List<Node> nodeList;
    List<Integer> preOrder;
    List<Integer> postOrder;
    
    public int[][] solution(int[][] nodeinfo) {
        
        nodeList = new LinkedList<>();
        allNodes = new ArrayList<>();
        
        for (int i = 0; i < nodeinfo.length; i++) {
            int[] curr = nodeinfo[i];
            Node node = new Node(curr[0], curr[1], i+1);
            allNodes.add(node);
            nodeList.add(node);
        }

        
        // 트리 만들기        
        Collections.sort(nodeList);
        makeTree(nodeList.remove(0), nodeList);
        
        // for (Node node : nodeList) {
        //     System.out.println(node);
        // }
        
        // 전/후위 순회 구하기
        Collections.sort(allNodes);
        preOrder = new ArrayList<>();
        postOrder = new ArrayList<>();
        searchOrder(allNodes.get(0));
        
        
        int[][] answer = new int[2][nodeinfo.length];
        for (int i = 0; i < preOrder.size(); i++) {
            answer[0][i] = preOrder.get(i);
        }
        for (int i = 0; i < postOrder.size(); i++) {
            answer[1][i] = postOrder.get(i);
        }
        return answer;
    }
    
    /* 트리 만들기 */
    private void makeTree(Node top, List<Node> nodeList) {
        
        List<Node> leftList = new LinkedList<>();
        List<Node> rightList = new LinkedList<>();
        
        for (Node node : nodeList) {
            
            // 부모노드 보다 왼쪽에 있을 때
            if (top.x > node.x) {
                leftList.add(node);
            }
            // 부모노드 보다 오른쪽에 있을 때
            else {
                rightList.add(node);
            }
        }
        
        // 왼쪽이 존재하는 경우
        if (!leftList.isEmpty()) {
            Collections.sort(leftList);
            Node leftTop = leftList.remove(0);
            top.left = leftTop;
            makeTree(leftTop, leftList);
        }
        
        // 오른쪽이 존재하는 경우
        if (!rightList.isEmpty()) {
            Node rightTop = rightList.remove(0);
            top.right = rightTop;
            makeTree(rightTop, rightList);    
        }
    }
    
    /* 전/후위 순회 구하기 */
    private void searchOrder(Node curr) {
        
        preOrder.add(curr.num);
        
        if (curr.left != null) {
            searchOrder(curr.left);
        }
            
        if (curr.right != null) {
            searchOrder(curr.right);
        }
        
        postOrder.add(curr.num);
    }
}

class Node implements Comparable<Node> {
    int x, y;
    int num;
    Node left, right;
    
    public Node(int x, int y, int num) {
        this.x = x;
        this.y = y;
        this.num = num;
    }
    
    @Override
    public int compareTo(Node other) {
        return other.y - this.y;
    }
    
    @Override
    public String toString() {
        return "[Node " + num + " ]  x : " + x + ", y : " + y + " left : " + left + " right : " + right; 
    }
}