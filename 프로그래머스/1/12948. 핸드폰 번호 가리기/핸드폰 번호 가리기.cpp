#include <string>
#include <vector>

using namespace std;

string solution(string phone_number) {
    string answer = "";
    
    int index = phone_number.size() - 4;
    for (int i = 0; i < index; i++) answer += "*";    
    answer += phone_number.substr(index);
    
    return answer;
}