#include <bits/stdc++.h>
using namespace std;

int main() {
    int n;
    cin >> n;
    cin.ignore();

    vector<string> options;
    vector<bool> key(26, false);

    for (int i = 0; i < n; i++) {
        string option;
        getline(cin, option);

        bool isOption = false;

        // 단어의 첫번째 글자에서 단축키 찾기
        stringstream ss(option);
        string word;
        int index = 0;
        while (ss >> word) {
            if (!key[tolower(word[0]) - 'a']) {
                key[tolower(word[0]) - 'a'] = true;

                option.insert(index+1, 1, ']');
                option.insert(index, 1, '[');
                
                isOption = true;
                break;
            }
            index += word.size() + 1;
        }

        // 차례대로 단축기 찾기
        if (!isOption) {
            for (index = 0; index < option.size(); index++) {
                if (option[index] != ' ' && !key[tolower(option[index]) - 'a']) {
                    key[tolower(option[index]) - 'a'] = true;

                    option.insert(index+1, 1, ']');
                    option.insert(index, 1, '[');
                    break;
                }
            }
        }

        cout << option << endl;
    }
}