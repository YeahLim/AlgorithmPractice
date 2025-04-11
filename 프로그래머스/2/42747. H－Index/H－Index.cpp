#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

int solution(vector<int> citations) {
    
    sort(citations.begin(), citations.end(), greater<int>());
    
    if (citations[0] == 0) {
        return 0;
    }
    
    int answer;
    for (int i = 0; i < citations.size(); i++) {
        
        if (citations[i] >= i+1) {
            answer =  i+1;
        }
    }
    
    return answer;
}