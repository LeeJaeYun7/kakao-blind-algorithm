import java.util.*;
class Solution {
    public int[] solution(String[] words, String[] queries) {
        Map<Integer, List<String>> forward = new HashMap<>();
        Map<Integer, List<String>> backward = new HashMap<>();

        for (String word : words) {
            forward.computeIfAbsent(word.length(), i -> new ArrayList<>()).add(word);
            backward.computeIfAbsent(word.length(), i -> new ArrayList<>()).add(new StringBuilder(word).reverse().toString());
        }

        for (Integer key : forward.keySet()) {
            forward.get(key).sort(null);
            backward.get(key).sort(null);
        }

        int[] ans = new int[queries.length];

        int idx = 0;
        for (String query : queries) {
            List<String> wordList;
            if(query.startsWith("?")){ // backword
                query = new StringBuilder(query).reverse().toString();
                wordList = backward.get(query.length());
            }else{
                wordList = forward.get(query.length());
            }
            if(wordList == null) ans[idx] = 0;
            else{
                ans[idx] = lowerBound(wordList, query.replace('?', Character.MAX_VALUE)) -
                        lowerBound(wordList, query.replace('?', Character.MIN_VALUE));
            }
            idx++;
        }

        return ans;
    }

    int lowerBound(List<String> list, String query){
        int s = 0;
        int e = list.size();
        while(s < e){
            int m = (s + e)/2;
            if(query.compareTo(list.get(m)) <= 0)
                e = m;
            else
                s = m + 1;
        }
        return s;
    }
}
