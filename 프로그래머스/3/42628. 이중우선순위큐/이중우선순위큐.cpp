#include <bits/stdc++.h>

using namespace std;

vector<int> solution(vector<string> operations) {
    
    multiset<int> pq;
    
    for (string& operation : operations) {
        
        string cmd;
        int num;
        
        stringstream ss(operation);
        ss >> cmd;
        ss >> num;
        
        // 숫자 삽입
        if (cmd == "I") {
            pq.insert(num);
        }
        // 큐가 비었을 때
        else if (pq.empty()) {
            continue;
        }
        // 최대값 제거
        else if (num == 1) {
            pq.erase(*pq.rbegin());
        }
        // 최소값 제거
        else if (num == -1) {
            pq.erase(*pq.begin());
        }
        
    }
    
    if (pq.empty()) {
        return {0, 0};
    }
    return {*pq.rbegin(), *pq.begin()};
}