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
