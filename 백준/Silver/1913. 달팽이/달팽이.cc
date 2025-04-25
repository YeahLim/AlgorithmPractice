#include <vector>
#include <iostream>
using namespace std;

int main() {

    // 입력
    int n, m;
    cin >> n >> m;

    // 중심축
    int x, y;
    x = y = n / 2;

    // 달팽이 배열
    vector<vector<int>> snail(n, vector<int>(n, 0));
    int num = 1;
    snail[x][y] = num++;

    // 방향 벡터 (상, 우, 하, 좌)
    vector<int> dx = {-1, 0, 1, 0};
    vector<int> dy = {0, 1, 0, -1};

    int length = 1;
    while (num <= n*n) {
        for (int d = 0; d < dx.size(); d++) {

            for (int i = 0; i < length; i++) {
                x += dx[d];
                y += dy[d];

                if (num > n*n) {
                    break;
                }

                snail[x][y] = num++;
            }

            if (d % 2 == 1) {
                length++;
            }
        }
    }
    
    // 출력
    int m_x, m_y; // 숫자 m의 위치
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {

            if (snail[i][j] == m) {
                m_x = i;
                m_y = j;
            }

            cout << snail[i][j] << " ";
        }
        cout << endl;
    }
    cout << m_x + 1 << " " << m_y + 1 << endl;
}