class Solution {
    
    int answer = 0;
    int[] number;
    
    public int solution(int[] number) {
        this.number = number;
        combination(0, 0, 0);
        return answer;
    }
    
    private void combination(int current, int index, int total) {
        if (index == 3) {
            if (total == 0) {
                answer++;
            }
            return;
        }
        
        for (int i = current; i < number.length; i++) {
            total += number[i];
            combination(i+1, index+1, total);
            total -= number[i];
        }
    }
}