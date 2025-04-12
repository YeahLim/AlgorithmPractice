#include<string>
#include <stack>

using namespace std;

bool solution(string s)
{
    
    stack<char> stack;
    for (auto & ch : s) {
        if (ch == '(') {
            stack.push(ch);
        }
        else if (!stack.empty()) {
            stack.pop();
        }
        else {
            return false;
        }
    }
    
    
    
    return stack.empty() ? true : false;
}