#include <bits/stdc++.h>

using namespace std;

vector<int> solution(string msg) {
    
    // 1. 사전 초기화
    unordered_map<string, int> dict;
    for (int i = 0; i < 26; i++) {
        dict[string(1, 'A' + i)] = i + 1;
    }
    
    // 2. 사전에 있는 가장 긴 문자열 찾기
    vector<int> answer;
    int index = 27;
    int i = 0;
    string curr = string(1, msg[0]);
    
    while (i < msg.length()) {
        
        // 사전에 존재하는 경우
        if (dict.count(curr)) {
            curr += msg[++i];
        }
        
        // 사전에 없는 경우
        if (!dict.count(curr)) {
            // 사전에 넣기
            dict[curr] = index++;
            // 색인번호 추출
            answer.push_back(dict[curr.substr(0, curr.length() - 1)]);
            curr = string(1, msg[i]);
        }
    }
    
    return answer;
}