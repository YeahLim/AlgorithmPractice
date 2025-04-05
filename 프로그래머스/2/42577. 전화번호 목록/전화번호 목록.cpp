#include <string>
#include <vector>
#include <algorithm>
#include <unordered_set>
using namespace std;

bool solution(vector<string> phone_book) {
    bool answer = true;
    
    sort(phone_book.begin(), phone_book.end(), [](const string& a, const string& b){
        return a.length() < b.length();
    });
    
    unordered_set<string> set;
    
    for (auto phone : phone_book) {
        for (int i = 0; i < phone.length(); i++) {
            if (set.find(phone.substr(0, i)) != set.end()) {
                return false;
            }
        }
        set.insert(phone);
    }
    
    return true;
}