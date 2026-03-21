import java.util.*;

class Solution {
    
    class Node {
        String cmd;
        String id;
        
        public Node (String cmd, String id) {
            this.cmd = cmd;
            this.id = id;
        }
    }
    
    public String[] solution(String[] record) {
        
        List<Node> nodeList = new ArrayList<>();
        Map<String, String> nicknameMap = new HashMap<>();
        
        for (String rc : record) {
            String[] info = rc.split(" ");
            Node curr = new Node(info[0], info[1]);
            
            // 입장한 경우
            if (curr.cmd.equals("Enter")) {
                nicknameMap.put(curr.id, info[2]); // 닉네임 구하기
                nodeList.add(curr);
            }
            // 떠난 경우
            else if (curr.cmd.equals("Leave")) {
                nodeList.add(curr);
            }
            // 닉네임을 바꾼 경우
            else if (curr.cmd.equals("Change")) {
                nicknameMap.put(curr.id, info[2]);
            }
        }
        
        // 출력문 구하기
        String[] answer = new String[nodeList.size()];
        for (int i = 0; i < nodeList.size(); i++) {
            Node curr = nodeList.get(i);
            
            String ans = nicknameMap.get(curr.id);
            
            if (curr.cmd.equals("Enter")) {
                ans += "님이 들어왔습니다.";
            } else if (curr.cmd.equals("Leave")) {
                ans += "님이 나갔습니다.";
            }
            
            answer[i] = ans;
        }
        return answer;
    }
}