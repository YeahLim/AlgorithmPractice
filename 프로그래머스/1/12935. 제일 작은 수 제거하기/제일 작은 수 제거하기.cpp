#include <bits/stdc++.h>

using namespace std;

vector<int> solution(vector<int> arr) {
    
    if (arr.size() == 1) return {-1};
    
    
    vector<int> answer;
    int min = *min_element(arr.begin(), arr.end());
    
    for (int num : arr) {
        if (min != num) answer.push_back(num);
    }
    
    return answer;
}