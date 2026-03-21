import java.util.*;

class Solution {
    
    class Node {
        String file;
        String head;
        int number;
        int index;
        
        public Node (String file, String head, String number, int index) {
            this.file = file;
            this.head = head.toUpperCase();
            this.number = number == null ? 0 : Integer.parseInt(number);
            this.index = index;
        }
    }
    
    public String[] solution(String[] files) {
        
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {  
            
            if (a.head.equals(b.head)) {
                
                if (a.number == b.number) {
                    return a.index - b.index; // 주어진 순서 유지
                }
                return a.number - b.number; // number - 오름차순
            }
            
            return a.head.compareTo(b.head); // head - 대소문자 구분 없이 사전순
        });
        
        int index = 0;
        for (String file : files) {
            String head = "", number = "", tail = "";
            int i = 0;
            
            // head 구하기
            for (; i < file.length(); i++) {
                
                if ('0' <= file.charAt(i) && file.charAt(i) <= '9') {
                    break;
                }
                head += file.charAt(i);
            }
            
            // number 구하기
            for (; i < file.length(); i++) {
                
                if ('0' > file.charAt(i) || file.charAt(i) > '9') {
                    break;
                }
                number += file.charAt(i);
            }
            
            pq.add(new Node(file, head, number, index));
            index++;
        }
        
        String[] answer = new String[files.length];
        int i = 0;
        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            answer[i++] = curr.file;
        }
        return answer;
    }
}