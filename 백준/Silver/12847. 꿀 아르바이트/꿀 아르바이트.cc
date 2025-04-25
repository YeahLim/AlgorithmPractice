#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

int main() {
    
    // 입력
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int n, m;
    cin >> n;
    cin >> m;

    vector<int> salary(n);
    for (int i = 0; i < n; i++) {
        cin >> salary[i];
    }   


    // 초기값 구하기
    long long current = 0;
    for (int i = 0; i < m; i++) {
        current += salary[i];
    }

    // 슬라이딩 윈도우로 최대값 구하기
    long long answer = current;
    for (int i = m; i < n; i++) {
        current += salary[i] - salary[i-m];
        answer = max(answer, current);
    }


    // 출력
    cout << answer;
}