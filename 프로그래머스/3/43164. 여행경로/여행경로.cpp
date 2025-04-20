#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
using namespace std;

vector<vector<string>> tickets;
vector<bool> visited;
bool isSearched;
vector<string> answer;

void searchRoute(string airport, int depth, vector<string> route) {
   
    if (isSearched) {
        return;
    }
   
    if (depth == tickets.size()) {
        isSearched = true;
        answer = route;
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

    visited = vector<bool>(tickets.size(), false);
    isSearched = false;
   
    // 1. tickets 알파벳 정렬
    sort(tickets.begin(), tickets.end());
    ::tickets = tickets;

    // 2. dfs로 루트 구하기
    searchRoute("ICN", 0, {"ICN"});
   
    return answer;
}