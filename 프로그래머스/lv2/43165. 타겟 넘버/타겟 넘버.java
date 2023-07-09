class Solution {
    
    int answer = 0;
    
    public int solution(int[] numbers, int target) {
        searchTarget(numbers, target, 0, 0);
        return answer;
    }
    
    public void searchTarget(int[] numbers, int target, int total, int idx) {
        if (idx == numbers.length) {
            if (total == target) {
                answer++;
            }
            return;
        }
        // 더하기
        searchTarget(numbers, target, total + numbers[idx], idx+1);
        // 빼기
        searchTarget(numbers, target, total - numbers[idx], idx+1);
    }
}