#include <string>
#include <vector>
#include <unordered_map>
#include <algorithm>

using namespace std;

class Song {
public:
    int no;
    int plays;
    
    Song(int no, int plays) : no(no), plays(plays) {}
};

vector<int> solution(vector<string> genres, vector<int> plays) {
    
    unordered_map<string, int> genres_plays; // 장르별 재생횟수
    unordered_map<string, vector<Song>> genres_songs; // 장르별 노래
    
    for (int i = 0; i < genres.size(); i++) {
        
        if (genres_plays.find(genres[i]) == genres_plays.end()) {
            genres_plays.insert(make_pair(genres[i], plays[i]));
        }
        else {
            genres_plays[genres[i]] += plays[i];
        }
        
        if (genres_songs.find(genres[i]) == genres_songs.end()) {
            genres_songs.insert(make_pair(genres[i], vector<Song>{Song(i, plays[i])}));
        }
        else {
            genres_songs[genres[i]].push_back(Song(i, plays[i]));
        }
    }
    
    vector<pair<string, int>> ger_plays(genres_plays.begin(), genres_plays.end());
    sort(ger_plays.begin(), ger_plays.end(), [](const pair<string, int>& a, const pair<string, int>& b) {
        return a.second > b.second;
    });
    
    vector<int> answer;
    for (pair<string, int> gen : ger_plays) {
        sort(genres_songs[gen.first].begin(), genres_songs[gen.first].end(), [](const Song& a, const Song& b) {
            if (a.plays == b.plays) {
                return a.no < b.no;
            }
            return a.plays > b.plays;
        });
        answer.push_back(genres_songs[gen.first][0].no);
        if (genres_songs[gen.first].size() > 1) {
            answer.push_back(genres_songs[gen.first][1].no);
        }
    }
   
    return answer;
}