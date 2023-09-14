import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String s) {  
        s = s.replace("},{", "-");
        s = s.substring(2, s.length() - 2);
        String[] str = s.split("-");
        Arrays.sort(str, (a, b) -> a.length() - b.length());
        Set<Integer> set = new HashSet<>();
        int[] ans = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            String[] strnum = str[i].split(",");
            int[] num = new int[strnum.length];
            for (int j = 0; j < strnum.length; j++) {
                num[j] = Integer.parseInt(strnum[j]);
                if (!set.contains(num[j])) {
                    ans[i] = num[j];
                    set.add(num[j]);
                }
            }
        }
            
        
        return ans;
    }
}