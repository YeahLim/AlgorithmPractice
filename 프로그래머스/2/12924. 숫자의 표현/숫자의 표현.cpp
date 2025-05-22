#include <string>
#include <vector>

using namespace std;

int solution(int n) {
    
    int left = 0;
    int right = 1;
    int sum = 1;
    
    int answer = sum == n ? 1 : 0;
    while (right <= n) {
        
        if (sum <= n) {
            right++;
            sum += right;
        }   
        else {
            sum -= left;
            left++;
        }
        
        if (sum == n) {
            answer++;
        }
        
    }
    
    return answer;
}