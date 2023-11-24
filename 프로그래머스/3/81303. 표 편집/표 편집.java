import java.util.*;


class Solution {
    public String solution(int n, int k, String[] cmd) {
        
        int pointer = k;
        
        Node[] nodes = new Node[n];
        nodes[0] = new Node();
        for (int i = 1; i < n; i++) {
            nodes[i] = new Node();
            nodes[i].prev = nodes[i-1];
            nodes[i-1].next = nodes[i];
        }
        
        Stack<Node> deleteStack = new Stack<>();
        Node now = nodes[k]; // 현재 선택된 행의 노드
        for (String c : cmd) {
            if (c.startsWith("U ")) {
                int count = Integer.parseInt(c.split(" ")[1]); 
                while (count-- > 0) {
                    now = now.prev;
                }
            }
            
            else if (c.startsWith("D ")) {
                int count = Integer.parseInt(c.split(" ")[1]); 
                while (count-- > 0) {
                    now = now.next;
                }
            }
            
            else if (c.equals("C")) {
                now.deleted = true;
                deleteStack.add(now);
                
                Node prev = now.prev;
                Node next = now.next;
                
                if (prev != null) {
                    prev.next = next;
                }
                if (next != null) {
                    next.prev = prev;
                    now = next;
                }
                else {
                    now = prev;
                }
                
            }
            
            else if (c.equals("Z")) {
                Node node = deleteStack.pop();
                node.deleted = false;
                Node prev = node.prev;
                Node next = node.next;
                
                if (prev != null) {
                    prev.next = node;
                }
                
                if (next != null) {
                    next.prev = node;
                }

            }
                
        }
        
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (nodes[i].deleted) {
                answer.append('X');
            }
            else {
                answer.append('O');
            }
        }
        
        return answer.toString();
    }
}

class Node{
    Node prev, next;
    boolean deleted;
}
