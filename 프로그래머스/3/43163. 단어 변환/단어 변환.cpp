#include <string>
#include <vector>
#include <queue>
using namespace std;

//8:48
struct Word {
public:
    string word;
    int step;
    
    Word(string word, int step) {
        this->word = word;
        this->step = step;
    }
};

int solution(string begin, string target, vector<string> words) {
    
    queue<Word> q; // 문자 큐
    q.push(Word(begin, 0));
    
    vector<bool> visited(words.size());
    
    while (!q.empty()) {
        
        Word curr = q.front();
        q.pop();
        
        if (curr.word == target) {
            return curr.step;
        }
        
        for (int i = 0; i < words.size(); i++) {
            
            if (visited[i]) {
                continue;
            }
            
            int count = begin.size();
            for (int j = 0; j < begin.size(); j++) {
        
                if (words[i][j] == curr.word[j]) {
                    count--;
                }
            }
        
            if (count == 1) {
                visited[i] = true;
                q.push(Word(words[i], curr.step+1));
            }
        }
    }
    
    return 0;
}