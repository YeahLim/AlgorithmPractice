#include <bits/stdc++.h>
using namespace std;

int main() {
    string s, t;
    cin >> s >> t;

    queue<string> q;
    q.push(t);

    set<string> set;

    int answer = 0;

    while (!q.empty()) {
        string curr = q.front();
        q.pop();

        if (curr == s) {
            answer = 1;
            break;
        }

        string next = curr;
        if (curr.back() == 'A') {
            next.pop_back();
            if (set.find(next) == set.end()) {
                set.insert(next);
                q.push(next);
            }
        }

        next = curr;
        if (curr.front() == 'B') {
            reverse(next.begin(), next.end());
            next.pop_back();
            if (set.find(next) == set.end()) {
                set.insert(next);
                q.push(next);
            }
        }
    }

    cout << answer;
}