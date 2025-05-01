#include <string>
#include <vector>
using namespace std;

string solution(string number, int k) {
    
    string answer = "";
    
    int answer_index = 0;
    for (int i = 0; i < number.size(); i++) {
        
        int max_num = number[i] - '0';
        int max_index = i;
        
         for (int j = i + 1; j <= k + answer_index; ++j) {
            
            // 더 큰 숫자인 경우
            if (max_num < number[j] - '0') {
                max_num = number[j] - '0';
                max_index = j;
            }
           
        }
        
        // 모든 숫자를 구한 경우
        if (answer_index == number.size() - k) {
            break;
        }
                     
        answer += to_string(max_num);
        i = max_index;
        answer_index++;
    }
    
    return answer;
}