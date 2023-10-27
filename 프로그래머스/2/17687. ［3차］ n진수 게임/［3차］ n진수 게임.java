import java.util.*;

class Solution {
    Map<Integer, String> map = new HashMap<>();
    
    public String solution(int n, int t, int m, int p) {
        map.put(10, "A");
        map.put(11, "B");
        map.put(12, "C");
        map.put(13, "D");
        map.put(14, "E");
        map.put(15, "F");
        List<Character> tube = new ArrayList<>();
        int order = 1;
        int number = 0;
        
        // tube의 사이즈가 t가 될때까지
        while (tube.size() < t) {
            // n진수 구하기
//        	System.out.println("진수 변환 전 : "+number);
            String curNum = getNBaseNum(number, n);
//            System.out.println("진수 변환 후 : "+curNum);
            for (char cur : curNum.toCharArray()) {
                if (tube.size() == t) {
                	break;
                }
            	
            	if (order % m == p) {
                    tube.add(cur);
                }       
                
                if (m == p && order % m == 0) {
                    tube.add(cur);
                }
                order++;
            }
            number++;
        }
    
        StringBuilder answer = new StringBuilder();
        for (char c : tube) {
        	answer.append(c);
        }
        return answer.toString();
    }
    
    
    private String getNBaseNum(int number, int base) {
        if (number == 0) {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        while (number > 0) {
            int baseNum = number % base;          
            if (baseNum < 10) {
               sb.append(baseNum);
            }
            else {
                sb.append(map.get(baseNum));    
            }
            number /= base;
        }
        return sb.reverse().toString();
    }
}