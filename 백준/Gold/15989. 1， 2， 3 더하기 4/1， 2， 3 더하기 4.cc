#include <vector>
#include <iostream>
using namespace std;

int main() {
    
    // 입력
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    cin >> n;

    // dp로 더하는 방법 구하기
    vector<vector<int>> dp(10001, vector<int>(3, 0));

    // dp초기화 
    dp[1][1] = 1; // 1을 1로 구성한 방법 수
    dp[2][1] = 1; // 2를 1로
    dp[2][2] = 1; // 2를 1,2로
    dp[3][1] = 1; // 3을 1로
    dp[3][2] = 1; // 3을 1,2로
    dp[3][3] = 1; // 3을 1,2,3으로

    for (int i = 4; i < 10001; i++) {
        dp[i][1] = 1;
        dp[i][2] = dp[i-2][1] + dp[i-2][2];
        dp[i][3] = dp[i-3][1] + dp[i-3][2] + dp[i-3][3];
    }


    // 출력
    for (int i = 0; i < n; i++) {
        int curr;
        cin >> curr;
        cout << dp[curr][1] + dp[curr][2] + dp[curr][3] << endl;
    }
}