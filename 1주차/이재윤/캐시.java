// 왜 맞았는가?
// 1. map에 값들을 저장해야 한다
// 2. city는 lowercase로 저장한다
// 3. 만약에 Map에 캐시가 있다면, answer에 1을 더하고, 최신 좌표를 업데이트 한다
// 4. 만약에 Map이 꽉 찼다면, pos값이 가장 작은, 즉, LRU를 지우고, 새 값을 Map에 넣어준다
//   -> 그리고 answer에 5를 더한다. 

import java.util.*; 

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        HashMap<String, Integer> map = new HashMap<>(); 
        
        if(cacheSize == 0){
            return 5*cities.length;
        }else{
            
            for(int i=0; i<cities.length; i++){
                String city = cities[i].toLowerCase();
                
                if(map.containsKey(city)){
                    answer += 1;
                    map.put(city, i);
                }else{
                    if(map.size()== cacheSize){
                        int minPos = Integer.MAX_VALUE; 
                        String lru = "";
                        for(String str: map.keySet()){
                            int pos = map.get(str);
                            if(pos <= minPos){
                                minPos = pos;
                                lru = str;
                            }
                        }
                        map.remove(lru);
                        map.put(city, i);
                    }else{
                        map.put(city, i);
                    }
                    answer += 5;
                }
            }
        }
        
        return answer;
    }
}
