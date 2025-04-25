#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int main() {

    // 입력
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int n, m;
    cin >> n >> m;

    vector<int> array(n);
    for (int i = 0; i < n; i++) {
        cin >> array[i];
    }

    // 투 포인터로 합이 m이 되는 경우 구하기
    int left = 0;
    int right = 0;
    int sum = array[left];
    int answer = sum == m ? 1: 0;
    while (right < n) {

        if (sum <= m) {
            if (right++ == n - 1) break;
            sum += array[right];
        }
        else if (sum > m) {
            sum -= array[left++];
        }

        if (sum == m) {
            answer++;
        }

    }


    // 출력
    cout << answer;
}