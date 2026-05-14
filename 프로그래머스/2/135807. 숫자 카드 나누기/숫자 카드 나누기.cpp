#include <bits/stdc++.h>

using namespace std;

vector<int> isSucceedToDivide(vector<int> array) {
    
    vector<int> successList;
    
    for (int i = array[0]; i >= 2; i--) {
        
        bool success = true;
        
        for (int num : array) {
            
            if (num % i != 0) {
                success = false;
                break;
            }
        }
        
        if (success) {
            successList.push_back(i);
        }
    }
    
    return successList;
}

int isFailedToDivide(vector<int> array, vector<int> successList) {
    
    for (int i : successList) {
        bool failure = true;
        
        for (int num : array) {
            if (num % i == 0) {
                failure = false;
                break;
            }
        }
        
        if (failure) {
            return i;
        }
    }
    return 0;
}

int solution(vector<int> arrayA, vector<int> arrayB) {

    sort(arrayA.begin(), arrayA.end());
    sort(arrayB.begin(), arrayB.end());
    
    vector<int> successList = isSucceedToDivide(arrayA);
    int ans1 = isFailedToDivide(arrayB, successList);
        
    successList = isSucceedToDivide(arrayB);
    int ans2 = isFailedToDivide(arrayA, successList);
    
    return max(ans1, ans2);
}