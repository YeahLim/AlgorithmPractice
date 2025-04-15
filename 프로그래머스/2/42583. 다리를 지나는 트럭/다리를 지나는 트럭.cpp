#include <string>
#include <vector>
#include <queue>
using namespace std;

int solution(int bridge_length, int weight, vector<int> truck_weights) {
    
    queue<int> on_bridge;
    for (int i = 0; i < bridge_length; i++) {
        on_bridge.push(0);
    }
    
    int answer = 0;
    int total_weights = 0;
    int index = 0;
    while (!on_bridge.empty()) {
        
        total_weights -= on_bridge.front();
        on_bridge.pop();
        answer++;
        
        if (index >= truck_weights.size()) {
            continue;
        }
        
        if (truck_weights[index] + total_weights > weight) {
            on_bridge.push(0);
        } 
        else {
            total_weights += truck_weights[index];
            on_bridge.push(truck_weights[index]);
            index++;
        }
        
    }
    
    return answer;
}