#include <bits/stdc++.h>

using namespace std;

vector<string> solution(vector<string> files) {
    
    struct Node {
        string file;
        string head;
        int number;
        
        Node (string file, string head, string number) 
            : file(file), head(head), number(stoi(number)) {}
    };
    
    vector<Node> nodeArray;
    
    // 1. head, number 구하기
    for (string file : files) {
        
        string head, number;
        int i = 0;
        
        for (; i < file.length(); i++) {
            char ch = file[i];
            
            if ('0' <= ch && ch <= '9') {
                break;
            }
            head += ch;
        }
        
        for (; i < file.length(); i++) {
            char ch = file[i];
            
            if ('0' > ch && ch > '9') {
                break;
            }
            number += ch;
        }
        
        transform(head.begin(), head.end(), head.begin(), ::tolower); // 소문자로 전환
        nodeArray.push_back(Node(file, head, number));
    }
    
    // 2. 주어진 조건대로 정렬하기
    stable_sort(nodeArray.begin(), nodeArray.end(), [](Node a, Node b) {
        if (a.head == b.head) {
            return a.number < b.number;
        }
        return a.head < b.head;
    });
    
    vector<string> answer;
    for (Node node : nodeArray) {
        answer.push_back(node.file);
    }
    return answer;
}