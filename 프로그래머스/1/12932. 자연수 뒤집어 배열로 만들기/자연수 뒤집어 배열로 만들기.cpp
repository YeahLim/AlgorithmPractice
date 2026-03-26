#include <bits/stdc++.h>

using namespace std;

vector<int> solution(long long n) {
    
    string str = to_string(n);  
    vector<int> answer(str.length());

    for (int i = 0; i < str.length(); i++) {
        answer[i] = str[str.length() - 1 - i] - '0';
    }

    return answer;
}