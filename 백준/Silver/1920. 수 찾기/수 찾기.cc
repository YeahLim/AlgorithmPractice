#include <unordered_set>
#include <iostream>
using namespace std;

int main() {

    // 입력
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    cin >> n;
    
    unordered_set<int> num_set; // set 이용
    for (int i = 0; i < n; i++) {
        int x;
        cin >> x;
        num_set.insert(x);
    }
    
    // 출력
    int m;
    cin >> m;
    for (int i = 0; i < m; i++) {
        int x;
        cin >> x;
        if (num_set.find(x) == num_set.end()) {
            cout << "0\n";
        } else {
            cout << "1\n";
        }
    }
}