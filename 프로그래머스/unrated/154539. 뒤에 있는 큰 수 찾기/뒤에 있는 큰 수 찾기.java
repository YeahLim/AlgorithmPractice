import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                result[stack.pop()] = numbers[i];
            }
            stack.push(i);
        }
        
        while (!stack.isEmpty()) {
            result[stack.pop()] = -1;
        }
        
        return result;
    }
}