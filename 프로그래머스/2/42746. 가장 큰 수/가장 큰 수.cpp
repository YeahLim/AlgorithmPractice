#include <string>
#include <vector>
#include <algorithm>

using namespace std;

string solution(vector<int> numbers) {
    
    vector<string> str_numbers;
    for (int &number : numbers) {
        str_numbers.push_back(to_string(number));
    }
    
    sort(str_numbers.begin(), str_numbers.end(), [](const string &a, const string &b) {
        return a+b > b+a;
    });
    
    if (str_numbers[0] == "0") {
        return "0";
    }
    
    string answer;
    for (string &num : str_numbers) {
        answer += num;
    }
    
    return answer;
}