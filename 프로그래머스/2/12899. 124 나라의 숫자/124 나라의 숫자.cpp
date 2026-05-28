#include <string>
#include <vector>

using namespace std;

string solution(int n) {
    string answer = "";
    
    vector<string> nums = {"4", "1", "2"};
        
        while (n > 0) {
            int number = n % 3;
            
            if (number == 0) {
                n--;
            }
            
            answer = nums[number] + answer;
            
            n /= 3;
        }
    return answer;
}