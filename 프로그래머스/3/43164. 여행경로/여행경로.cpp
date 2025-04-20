#include <string>
#include <vector>
#include <algorithm>
using namespace std;

vector<vector<string>> tickets;
vector<bool> visited;
vector<string> answer;

void searchRoute(string airport, int depth, vector<string> route) {
    
    if (depth == tickets.size()) {
        
        // 첫번째 경로
        if (answer.empty()) {
            answer = route;
        }
        
        // 더 작은 경로가 나온 경우
        if (route < answer) {
            answer = route;
        }
        return;
    }
    
    for (int i = 0; i < tickets.size(); i++) {
        
        if (!visited[i] && airport == tickets[i][0]) {
            visited[i] = true;
            route.push_back(tickets[i][1]);
            searchRoute(tickets[i][1], depth+1, route);
            route.pop_back();
            visited[i] = false;
        }
    }
}

vector<string> solution(vector<vector<string>> tickets) {

    ::tickets = tickets;
    visited = vector<bool>(tickets.size(), false);
    
    // dfs로 루트 구하기
    searchRoute("ICN", 0, {"ICN"});
    
    return answer;
}