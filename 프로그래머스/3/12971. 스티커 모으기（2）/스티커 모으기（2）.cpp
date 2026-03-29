#include <bits/stdc++.h>
using namespace std;

int solution(vector<int> sticker)
{
    if (sticker.size() == 1) {
        return sticker[0];
    }
    else if (sticker.size() == 2) {
        return max(sticker[0], sticker[1]);
    }
    
    // 1. 첫번째거 뜯고 마지막거 안뜯는 경우
    vector<int> dp1(sticker.size() - 1);
    dp1[0] = sticker[0];
    dp1[1] = sticker[0];
    
    for (int i = 2; i < sticker.size() - 1; i++) {
       dp1[i] = max(dp1[i-1], dp1[i-2] + sticker[i]); 
    }
    
    // 2. 첫번째거 안뜯고 마지막거 뜯는 경우
    vector<int> dp2(sticker.size());
    dp2[0] = 0;
    dp2[1] = sticker[1];
    
    for (int i = 2; i < sticker.size(); i++) {
        dp2[i] = max(dp2[i-1], dp2[i-2] + sticker[i]);
    }

    return max(dp1[sticker.size() - 2], dp2[sticker.size()-1]);
}