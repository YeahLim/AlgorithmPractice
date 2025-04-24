#include <string>
#include <vector>
#include <algorithm>
using namespace std;

vector<int> solution(string s) {
    
    int tx_count = 0;
    int zero_count = 0;
    
    while (s != "1") {
        
        tx_count++;
        
        // 0 제거
        int length = s.size();
        s.erase(remove(s.begin(), s.end(), '0'), s.end());
        zero_count += length - s.size();
        
        // 이진 변환
        int num = s.size();
        s = "";
        while (num > 0) {
            s = to_string(num % 2) + s;
            num /= 2;
        }
        
    }
    
    return {tx_count, zero_count};
}