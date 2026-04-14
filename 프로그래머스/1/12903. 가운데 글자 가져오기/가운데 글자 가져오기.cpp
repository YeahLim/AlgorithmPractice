#include <string>
#include <vector>

using namespace std;

string solution(string s) {
    int index = s.size() / 2;
    
    if (s.size() % 2 == 0) {
        return s.substr(index - 1, 2);
    }
    else {
        return s.substr(index, 1);
    }
}