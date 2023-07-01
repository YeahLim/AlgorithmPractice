import java.util.*;

class Solution {
    
    class Song {
        int idx;
        String genre;
        int playCnt;
        public Song(int idx, String genre, int playCnt) {
            this.idx = idx;
            this.genre = genre;
            this.playCnt = playCnt;
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> totalPlays = new HashMap<>(); // 장르별 전체 재생 횟수
        Map<String, List<Song>> songs = new HashMap<>(); // 장르별 노래 
        for (int i = 0; i < plays.length; i++) {
            
            // 장르별 재생 횟수
            totalPlays.put(genres[i], totalPlays.getOrDefault(genres[i], 0) + plays[i]); 
            // 장르별 노래
            if (songs.containsKey(genres[i])) {
                songs.get(genres[i]).add(new Song(i, genres[i], plays[i]));
            } else {
                songs.put(genres[i], new ArrayList<>());
                songs.get(genres[i]).add(new Song(i, genres[i], plays[i]));
            }
        }
        
        List<String> sortedPlays = new ArrayList<>(totalPlays.keySet());
        Collections.sort(sortedPlays, (a, b) -> totalPlays.get(b).compareTo(totalPlays.get(a)));
        
        List<Integer> answer = new ArrayList<>();
        for (String key : sortedPlays) {
            // todo : songs.get(key) 얘 내림차순으로 정렬 (같을 경우 고유번호 낮은 노래 정렬)
            List<Song> sortedSongs = songs.get(key);
            Collections.sort(sortedSongs, (a, b) -> {
                return b.playCnt == a.playCnt ? a.idx - b.idx : b.playCnt - a.playCnt;
            });
            answer.add(sortedSongs.get(0).idx);
            System.out.println(key + "의 사이즈 : " + songs.get(key).size());
            if (songs.get(key).size() == 1) continue;
            answer.add(sortedSongs.get(1).idx);
        }
        
        return answer.stream().mapToInt(x -> x.intValue()).toArray();
    }
}