import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        List<String> wordList = List.of("aya", "ye", "woo", "ma");
        int answer = 0;
        for (String word : babbling) {
            for (String candidate : wordList) {
                word = word.replace(candidate, " ");
            }   
            if (word.trim().length() == 0) {
                answer++;
            }
        }
        return answer;
    }
}

