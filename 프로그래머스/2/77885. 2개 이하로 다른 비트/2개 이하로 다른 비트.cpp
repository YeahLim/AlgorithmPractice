#include <bits/stdc++.h>

using namespace std;

vector<long long> solution(vector<long long> numbers) {
    vector<long long> answer;
    
    for (long long number : numbers) {
        
        // 짝수인 경우
        if (number % 2 == 0) {
            answer.push_back(number + 1);
        }
        
        // 홀수인 경우
        else {
            string binary = bitset<64>(number).to_string();
            int index = binary.rfind("0");
            answer.push_back(stoll(binary.replace(index, 2, "10"), nullptr, 2));
        }
    }
    
    return answer;
}