#include <bits/stdc++.h>

using namespace std;

vector<string> solution(vector<string> record) {
    
    vector<vector<string>> infoList;
    unordered_map<string, string> nicknameMap;
    for (string rc : record) {

        vector<string> info;
        stringstream ss(rc);
        string token;
        while (ss >> token) {
            info.push_back(token);
        }
        
        // 입장한 경우
        if (info[0] == "Enter") {
            infoList.push_back(info);
            nicknameMap[info[1]] = info[2];
        } 
        // 떠난 경우
        else if (info[0] == "Leave") {
            infoList.push_back(info);
        } 
        // 닉네임을 바꾼 경우
        else if (info[0] == "Change") {
            nicknameMap[info[1]] = info[2];
        }
    }
    
    // 출력문 구하기
    vector<string> answer;
    for (vector<string> info : infoList) {
        
        string ans = nicknameMap[info[1]];
        
        if (info[0] == "Enter") {
            ans += "님이 들어왔습니다.";
        }
        else if (info[0] == "Leave") {
            ans += "님이 나갔습니다.";
        }
        
        answer.push_back(ans);
    }
    
    return answer;
}