import java.io.*;
import java.util.*;

class Solution {
    public String solution(String s) {
        StringTokenizer st = new StringTokenizer(s);
        List<Integer> list = new ArrayList<>();
        while(st.hasMoreTokens()) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        sb.append(list.get(0));
        sb.append(" ");
        sb.append(list.get(list.size()-1));
        return sb.toString();
    }
}