#include <bits/stdc++.h>

using namespace std;

vector<int> solution(vector<int> arr, int divisor) {
    vector<int> answer;
    
    sort(arr.begin(), arr.end());
    for (int num : arr) {
        if (num % divisor == 0) {
            answer.push_back(num);
        }
    }
    
    if (answer.size() == 0) {
        answer.push_back(-1);
    }
    
    
    return  answer;
}