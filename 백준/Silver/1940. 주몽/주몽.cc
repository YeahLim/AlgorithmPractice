#include <algorithm>
#include <iostream>
#include <vector>
using namespace std;

int main() {

    // 입력
    int N, M;
    cin >> N >> M;

    vector<int> ingredients(N);
    for (int i = 0; i < N; i++) {
        cin >> ingredients[i];
    }

    // 정렬
    sort(ingredients.begin(), ingredients.end());

    // 투포인터로 M인 경우 구하기 
    int left = 0;
    int right = N-1;
    int answer = 0;
    while (left < right) {
        
        int sum = ingredients[left] + ingredients[right];

        if (sum < M) {
            left++;
        } 
        else if (sum > M) {
            right--;
        }
        else {
            answer++;
            left++;
            right--;
        }
        
    }

    // 출력
    cout << answer;
}