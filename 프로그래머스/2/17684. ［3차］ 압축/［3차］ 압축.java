import java.util.*;

class Solution {
    public int[] solution(String msg) {
        
        // 1. 길이가 1인 단어 사전 초기화
        Map<String, Integer> dict = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            String alphabet = (char)('A' + i) + "";
            dict.put(alphabet, i+1);
        }
        
        // 2. 가장 긴 문자열 찾기
        int i = 0;
        int index = 27;
        List<Integer> answer = new ArrayList<>();
        String curr = msg.charAt(0) + "";
        
        // msg 길이가 1일때
        if (msg.length() == 1) {
            return new int[] {dict.get(curr)};
        }
        
        while (i < msg.length() - 1) {
            
            // 사전에 존재한다면
            if (dict.containsKey(curr)) {
                curr += msg.charAt(++i);
            }
            
            // 아니라면
            if (!dict.containsKey(curr)) {
                dict.put(curr, index++); // 사전에 단어 등록
                curr = curr.substring(0, curr.length() - 1);
                answer.add(dict.get(curr)); // 색인번호 추출
                curr = msg.charAt(i) + "";
            }
        }
        
        // 마지막 단어의 색인번호 추출
        answer.add(dict.get(curr));
            
        int[] ans = new int[answer.size()];
        for (int j = 0; j < answer.size(); j++) {
            ans[j] = answer.get(j);
        }
        
        return ans;
    }
}